package application;

import data.Algoritmos.Estrategias;
import entities.Biblioteca;

public class Application {
    public static void main(String[] args) throws Exception {
        Biblioteca biblioteca = new Biblioteca();
        
        biblioteca.adicionarLivro("Harry Potter", "JK", new java.util.Date());
        biblioteca.adicionarLivro("Trono de Vidro", "Sarah", new java.util.Date());
        biblioteca.adicionarLivro("A Vida é Bela", "Autor", new java.util.Date());
        biblioteca.adicionarLivro("O Senhor dos Aneis 2", "Tolkien", new java.util.Date());
        biblioteca.adicionarLivro("O Senhor dos Aneis", "Tolkien", new java.util.Date());



        System.out.println("Antes da ordenação:");
        biblioteca.listarLivros();


        System.out.println("_------------_");

        System.out.println("Depois da ordenação");

        biblioteca.ordenarLivros(Estrategias.ALGORITMO_BUBBLESORT);
        biblioteca.listarLivros();
        System.out.println("_------------_");

        biblioteca.adicionarLivro("It", "JK", new java.util.Date());
        biblioteca.adicionarLivro("Duna", "Sarah", new java.util.Date());
        biblioteca.adicionarLivro("Jogos Vorazes", "Autor", new java.util.Date());
        biblioteca.adicionarLivro("Diario de um banana", "Tolkien", new java.util.Date());
        biblioteca.adicionarLivro("O Iluminado", "Tolkien", new java.util.Date());
        biblioteca.listarLivros();

        System.out.println("_------------_");
        System.out.println("Depois da ordenação");

        biblioteca.ordenarLivros(Estrategias.ALGORITMO_QUICKSORT);
        biblioteca.listarLivros();
    }

}
