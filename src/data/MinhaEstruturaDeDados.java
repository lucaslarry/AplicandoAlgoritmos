package data;

import entities.BibliotecaException;

public class MinhaEstruturaDeDados<T> {
    private static final int TAMANHO_REDIMENSIONAR = 2;
    private static final int TAMANHO_INICIAL = 10;
    private T[] array;
    private int inseridos;

    @SuppressWarnings("unchecked")
    public MinhaEstruturaDeDados() {
        this.array = (T[]) new Object[TAMANHO_INICIAL];
        this.inseridos = 0;
    }
    public boolean estaVazio(){
        return inseridos == 0;
    }
    private boolean estaCheio() {
        return inseridos == array.length;
    }
    private boolean checarIndex(int indice){
        return indice >= 0 && indice < inseridos;
    }
    @SuppressWarnings("unchecked")
    private void redimensionar() {
        int novoTamanho = array.length * TAMANHO_REDIMENSIONAR;
        T[] novoArray = (T[]) new Object[novoTamanho];

        for (int i = 0; i < array.length; i++) {
            novoArray[i] = array[i];
        }

        array = novoArray;
    }

    public void adicionar(T elemento) {
        if (estaCheio()) {
            redimensionar();
        }
        array[inseridos] = elemento;
        inseridos++;
    }

    public void adicionar(int indice, T elemento) {
        if (!checarIndex(indice)) {
            throw new BibliotecaException("Índice fora do intervalo: " + indice);
        }
    
        if (estaCheio()) {
            redimensionar();
        }
    
        for (int i = inseridos; i > indice; i--) {
            array[i] = array[i - 1];
        }
    
        array[indice] = elemento;
        inseridos++;
    }

    public void set(int indice, T elemento) {
        if (!checarIndex(indice)) {
            throw new BibliotecaException("Índice fora do intervalo: " + indice);
        }
    
        array[indice] = elemento;
    }

    public T pegar(int indice) {
        if (!checarIndex(indice)) {
            throw new BibliotecaException("Índice fora do intervalo: " + indice);
        }
        return array[indice];
    }

    @SuppressWarnings("unchecked")
    public void limpar() {
        array = (T[]) new Object[TAMANHO_INICIAL];
        inseridos = 0;
    }

    public T remover(int indice) {
        if (!checarIndex(indice)) {
            throw new BibliotecaException("Índice fora do intervalo: " + indice);
        }
        T elementoRemovido = array[indice];
        for (int i = indice; i < inseridos - 1; i++) {
            array[i] = array[i + 1];
        }
        array[inseridos - 1] = null;
        inseridos--;
        return elementoRemovido;
    }

    public boolean contem(Object objeto) {
        return primeiroIndiceDe(objeto) != -1;
    }
    
    public int primeiroIndiceDe(Object objeto) {
        for (int i = 0; i < inseridos; i++) {
            if (array[i].equals(objeto)) {
                return i;
            }
        }
        return -1;
    }
    
    public int ultimoIndiceDe(Object objeto) {
        for (int i = inseridos - 1; i >= 0; i--) {
            if (array[i].equals(objeto)) {
                return i;
            }
        }
        return -1;
    }

    public int quantidade() {
        return inseridos;
    }
}