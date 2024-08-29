package data.Algoritmos;

import java.util.Random;

import data.MinhaEstruturaDeDados;
import entities.Livro;

public class QuickSort {

    public static <T> MinhaEstruturaDeDados<T> quickSort(MinhaEstruturaDeDados<T> array){
        if (array.quantidade() < 2) {
            return array;
        } else {
            Random rand = new Random();
            int indicePivo = rand.nextInt(array.quantidade());
            T pivo = array.pegar(indicePivo);

            MinhaEstruturaDeDados<T> menores = new MinhaEstruturaDeDados<>();
            MinhaEstruturaDeDados<T> iguais = new MinhaEstruturaDeDados<>();
            MinhaEstruturaDeDados<T> maiores = new MinhaEstruturaDeDados<>();

            for (int i = 0; i < array.quantidade(); i++) {
                T elemento = array.pegar(i);
                int comparacao = ((Livro) elemento).compareTo((Livro)pivo);

                if (comparacao < 0) {
                    menores.adicionar(elemento);
                } else if (comparacao > 0) {
                    maiores.adicionar(elemento);
                } else {
                    iguais.adicionar(elemento);
                }
            }

            MinhaEstruturaDeDados<T> ordenados = new MinhaEstruturaDeDados<>();
            ordenados = concatenar(quickSort(menores), iguais, quickSort(maiores));

            return ordenados;
        }

    }
    private static <T> MinhaEstruturaDeDados<T> concatenar(MinhaEstruturaDeDados<T> menores, MinhaEstruturaDeDados<T> iguais, MinhaEstruturaDeDados<T> maiores) {
        MinhaEstruturaDeDados<T> resultado = new MinhaEstruturaDeDados<>();

        for (int i = 0; i < menores.quantidade(); i++) {
            resultado.adicionar(menores.pegar(i));
        }
        for (int i = 0; i < iguais.quantidade(); i++) {
            resultado.adicionar(iguais.pegar(i));
        }
        for (int i = 0; i < maiores.quantidade(); i++) {
            resultado.adicionar(maiores.pegar(i));
        }

        return resultado;
    }
}
