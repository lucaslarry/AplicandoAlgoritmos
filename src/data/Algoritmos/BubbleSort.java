package data.Algoritmos;

import data.MinhaEstruturaDeDados;
import entities.Livro;

public class BubbleSort {
     public static <T> MinhaEstruturaDeDados<T> bubbleSort(MinhaEstruturaDeDados<T> array){
        MinhaEstruturaDeDados<T> novoArray = array;
       
        for (int i = 0; i < array.quantidade() - 1; i++) {
            for (int j = 0; j < array.quantidade() - 1 - i; j++) {
                if (((Livro) array.pegar(j)).compareTo((Livro)array.pegar(j+1)) > 0) {
                    T temp = array.pegar(j);
                    novoArray.set(j, array.pegar(j+1));
                    novoArray.set(j+1, temp);
                }
            }
        }
        return novoArray;
    }
}
