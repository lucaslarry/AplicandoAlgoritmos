package entities;

import java.util.Date;

import data.MinhaEstruturaDeDados;
import data.Algoritmos.BubbleSort;
import data.Algoritmos.Estrategias;
import data.Algoritmos.QuickSort;

public class Biblioteca {
    private MinhaEstruturaDeDados<Livro> meuArrayList;

    public Biblioteca(){
       this.meuArrayList = new MinhaEstruturaDeDados<>();
    }

    public void adicionarLivro(String nomeLivro, String nomeAutor, Date data){
        meuArrayList.adicionar(new Livro(nomeLivro, new Autor(nomeAutor), data));
    }

    public void listarLivros(){
        for(int i = 0; i < meuArrayList.quantidade(); i++){
            System.out.println(meuArrayList.pegar(i));
        }
    }

    public void ordenarLivros(Estrategias estrategias){
        if(estrategias.equals(Estrategias.ALGORITMO_QUICKSORT)){
            meuArrayList=QuickSort.quickSort(meuArrayList);
        }
        if(estrategias.equals(Estrategias.ALGORITMO_BUBBLESORT)){
            meuArrayList = BubbleSort.bubbleSort(meuArrayList);
        }

    }
}
