package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import data.Algoritmos.AlgoritmoGuloso;
import data.MeuGrafo;
import data.MinhaEstruturaDeDados;
import data.Algoritmos.BubbleSort;
import data.Algoritmos.Estrategias;
import data.Algoritmos.QuickSort;

public class Biblioteca {
    private MinhaEstruturaDeDados<Livro> meuArrayList;

    public Biblioteca(){
       this.meuArrayList = new MinhaEstruturaDeDados<>();
    }

    public void adicionarLivro(String nomeLivro, String nomeAutor, Date data, Categoria categoria){
        meuArrayList.adicionar(new Livro(nomeLivro, new Autor(nomeAutor), data,categoria));
    }

    private Date formatarData(String data) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(data);
    }
    public void adicionarLivro(String nomeLivro, String nomeAutor, String data, Categoria categoria) throws ParseException{
        Date dataPublicacao = formatarData(data);
        meuArrayList.adicionar(new Livro(nomeLivro, new Autor(nomeAutor), dataPublicacao, categoria));
    }

    public String listarLivros(){
        StringBuilder lista = new StringBuilder("Livros cadastrados:\n");
        for(int i = 0; i < meuArrayList.quantidade(); i++){
            lista.append(meuArrayList.pegar(i)).append("\n");
        }
        return lista.toString();
    }

    public String listarLivros(MinhaEstruturaDeDados<Livro> array){
        StringBuilder lista = new StringBuilder("Livros cadastrados:\n");
        for(int i = 0; i < array.quantidade(); i++){
            lista.append("Livro: ").append(array.pegar(i)).append(" | ");
            lista.append("Categoria: ").append(array.pegar(i).getCategoria()).append("\n");
        }
        return lista.toString();
    }

    public void ordenarLivros(Estrategias estrategias){
        if(estrategias.equals(Estrategias.ALGORITMO_QUICKSORT)){
            meuArrayList=QuickSort.quickSort(meuArrayList);
        }
        if(estrategias.equals(Estrategias.ALGORITMO_BUBBLESORT)){
            meuArrayList = BubbleSort.bubbleSort(meuArrayList);
        }

    }

    public int buscarLivros(String titulo){
        for(int i = 0; i < meuArrayList.quantidade(); i++){
            if(meuArrayList.pegar(i).getTitulo().equals(titulo)){
                return i;
            }
        }
        return -1;
    }

    public MinhaEstruturaDeDados<Livro> recomendarLivros(MeuGrafo grafo, String titulo){
        for(int i = 0; i < meuArrayList.quantidade(); i++){
            if(meuArrayList.pegar(i).getTitulo().equals(titulo)){
               return QuickSort.quickSort(AlgoritmoGuloso.recomendarLivros(grafo, meuArrayList, meuArrayList.pegar(i)));
            }
        }
        return null;
    }


}
