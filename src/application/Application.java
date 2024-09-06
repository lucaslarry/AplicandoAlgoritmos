package application;

import java.text.ParseException;

import javax.swing.JOptionPane;

import data.Algoritmos.Estrategias;
import entities.Biblioteca;
import entities.BibliotecaException;


public class Application {
    public static void main(String[] args) throws Exception {
        Biblioteca biblioteca = new Biblioteca();
        Boolean sair = false;

        biblioteca.adicionarLivro("It", "JK", new java.util.Date());
        biblioteca.adicionarLivro("Duna", "Sarah", new java.util.Date());
        biblioteca.adicionarLivro("Harry Potter", "JK", new java.util.Date());
        biblioteca.adicionarLivro("Trono de Vidro", "Sarah", new java.util.Date());
        biblioteca.adicionarLivro("A Vida é Bela", "Autor", new java.util.Date());
        biblioteca.adicionarLivro("Diario de um banana", "Tolkien", new java.util.Date());
        biblioteca.adicionarLivro("O Iluminado", "Tolkien", new java.util.Date());
        biblioteca.adicionarLivro("O Senhor dos Aneis 2", "Tolkien", new java.util.Date());
        biblioteca.adicionarLivro("O Senhor dos Aneis", "Tolkien", new java.util.Date());
        biblioteca.adicionarLivro("Jogos Vorazes", "Autor", new java.util.Date());

        while(!sair){
            try {
            String[] options = {"Adicionar", "Listar", "Ordenar", "Buscar", "Sair"};
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
                        biblioteca.adicionarLivro(titulo, autorStr, dataPublicacaoStr);
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
