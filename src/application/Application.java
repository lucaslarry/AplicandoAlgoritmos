package application;

import java.text.ParseException;

import javax.swing.JOptionPane;

import data.Algoritmos.Estrategias;
import data.MeuGrafo;
import entities.Biblioteca;
import entities.BibliotecaException;
import entities.Categoria;


public class Application {
    public static void main(String[] args) throws Exception {
        Biblioteca biblioteca = new Biblioteca();
        MeuGrafo meuGrafo = new MeuGrafo();
        boolean sair = false;


        Categoria cat1 = new Categoria("Ficcão Cientifica");
        Categoria cat2 = new Categoria("Fantasia");
        Categoria cat3 = new Categoria("Misterio");
        Categoria cat4 = new Categoria("Romance");
        Categoria cat5 = new Categoria("Drama");
        Categoria cat6 = new Categoria("Medieval");
        Categoria[] categorias = {cat1, cat2, cat3, cat4, cat5, cat6};
        meuGrafo.adicionarAresta(cat1, cat2);
        meuGrafo.adicionarAresta(cat2, cat6);
        meuGrafo.adicionarAresta(cat6, cat4);
        meuGrafo.adicionarAresta(cat4, cat5);
        meuGrafo.adicionarAresta(cat5, cat3);
        meuGrafo.adicionarAresta(cat3, cat1);





        biblioteca.adicionarLivro("Duna", "Frank Herbert", new java.util.Date(), cat1);
        biblioteca.adicionarLivro("O Silmarillion", "J.R.R. Tolkien", new java.util.Date(), cat1);
        biblioteca.adicionarLivro("1984", "George Orwell", new java.util.Date(), cat1);
        biblioteca.adicionarLivro("A Guerra dos Tronos", "George R.R. Martin", new java.util.Date(), cat2);
        biblioteca.adicionarLivro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", new java.util.Date(), cat2);
        biblioteca.adicionarLivro("O Senhor dos Anéis: A Sociedade do Anel", "J.R.R. Tolkien", new java.util.Date(), cat2);
        biblioteca.adicionarLivro("O Senhor dos Anéis: As Duas Torres", "J.R.R. Tolkien", new java.util.Date(), cat2);
        biblioteca.adicionarLivro("Jogos Vorazes", "Suzanne Collins", new java.util.Date(), cat2);
        biblioteca.adicionarLivro("It: A Coisa", "Stephen King", new java.util.Date(), cat3);
        biblioteca.adicionarLivro("O Iluminado", "Stephen King", new java.util.Date(), cat3);
        biblioteca.adicionarLivro("O Código Da Vinci", "Dan Brown", new java.util.Date(), cat3);
        biblioteca.adicionarLivro("A Metamorfose", "Franz Kafka", new java.util.Date(), cat3);
        biblioteca.adicionarLivro("Pessoas Normais", "Sally Rooney", new java.util.Date(), cat4);
        biblioteca.adicionarLivro("Orgulho e Preconceito", "Jane Austen", new java.util.Date(), cat4);
        biblioteca.adicionarLivro("Dom Casmurro", "Machado de Assis", new java.util.Date(), cat4);
        biblioteca.adicionarLivro("Pequenas Mulheres", "Louisa May Alcott", new java.util.Date(), cat5);
        biblioteca.adicionarLivro("Cem Anos de Solidão", "Gabriel García Márquez", new java.util.Date(), cat5);
        biblioteca.adicionarLivro("A Menina que Roubava Livros", "Markus Zusak", new java.util.Date(), cat5);
        biblioteca.adicionarLivro("Trono de Vidro", "Sarah J. Maas", new java.util.Date(), cat6);



        while(!sair){
            try {
            String[] options = {"Adicionar", "Listar", "Ordenar", "Buscar","Recomendar", "Sair"};
            int escolha = JOptionPane.showOptionDialog(
                null,
                "O que você gostaria de fazer?",
                "Biblioteca",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);


                switch (escolha) {
                    case 0 ->{
                        String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
                        if (titulo == null) break;
                        String autorStr = JOptionPane.showInputDialog("Digite o nome do autor:");
                        if (autorStr == null) break;
                        String dataPublicacaoStr = JOptionPane.showInputDialog("Digite a data de publicação (ex: dd/MM/yyyy):");
                        if (dataPublicacaoStr == null) break;
                        Categoria categoria = (Categoria) JOptionPane.showInputDialog(
                                null,
                                "Selecione uma categoria:",
                                "Categorias",
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                categorias,
                                categorias[0]
                        );
                        if (categoria == null) break;
                        biblioteca.adicionarLivro(titulo, autorStr, dataPublicacaoStr, categoria);
                    }
                    case 1 ->{
                        JOptionPane.showMessageDialog(null, biblioteca.listarLivros());
                    }
                    case 2 ->{
                        String[] optionsOrd = {"Bubble Sort", "Quick Sort"};
                        int escolhaOrd = JOptionPane.showOptionDialog(
                        null,
                        "Escolha o algoritmo de ordenação:",
                        "Ordenar Livros",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        optionsOrd,
                        optionsOrd[0]
                        );

                        Estrategias estrategia = (escolhaOrd == 0) ? Estrategias.ALGORITMO_BUBBLESORT : Estrategias.ALGORITMO_QUICKSORT;
                        biblioteca.ordenarLivros(estrategia);
                    }
                    case 3 -> {
                        String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
                        if (titulo == null) break;
                        int livro = biblioteca.buscarLivros(titulo);
                        String string = (livro >= 0) ? "O Livro: " + titulo + " Está na posição: " + livro : "Livro não encontrado";
                        JOptionPane.showMessageDialog(null, string);


                    }
                    case 4 -> {
                        String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
                        JOptionPane.showMessageDialog(null, biblioteca.listarLivros(biblioteca.recomendarLivros(meuGrafo,titulo)));

                    }
                    case 5 -> {
                        JOptionPane.showMessageDialog(null, "Obrigado pela visita");
                        sair = true;
                    }
                    default ->{

                        JOptionPane.showMessageDialog(null, "Nenhuma opção selecionada.");
                    }
                }
            } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Data de publicação inválida. Use o formato dd/MM/yyyy.");
            } catch (BibliotecaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

            }


        }



        
    }

}
