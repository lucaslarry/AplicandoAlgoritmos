package data.Algoritmos;

import data.Aresta;
import data.MeuGrafo;
import data.MinhaEstruturaDeDados;
import data.Vertice;
import entities.Categoria;
import entities.Livro;

public class AlgoritmoGuloso {

    public static MinhaEstruturaDeDados<Livro> recomendarLivros(MeuGrafo grafo,MinhaEstruturaDeDados<Livro> minhaEstruturaDeDados, Livro livroEscolhido) {
        MinhaEstruturaDeDados<Livro> recomendacoes = new MinhaEstruturaDeDados<>();
        Categoria categoriaEscolhida = livroEscolhido.getCategoria();

        return pegarLivros(grafo, minhaEstruturaDeDados, livroEscolhido, recomendacoes, categoriaEscolhida);

    }

    private static MinhaEstruturaDeDados<Livro> pegarLivros(MeuGrafo grafo, MinhaEstruturaDeDados<Livro> minhaEstruturaDeDados, Livro livroEscolhido, MinhaEstruturaDeDados<Livro> recomendacoes, Categoria categoriaEscolhida) {

        for (int i = 0; i < minhaEstruturaDeDados.quantidade(); i++) {
            Livro livroAtual = minhaEstruturaDeDados.pegar(i);
            if (!livroAtual.equals(livroEscolhido) && livroAtual.getCategoria().equals(categoriaEscolhida)) {
                if(!recomendacoes.contem(livroAtual)){
                    recomendacoes.adicionar(livroAtual);
                }

            }
            if(recomendacoes.quantidade() == 6){
                return recomendacoes;
            }
        }

        if (recomendacoes.quantidade() < 6) {
            pegarLivros(grafo, minhaEstruturaDeDados, livroEscolhido, recomendacoes, pegarNovaCategoria(grafo, categoriaEscolhida));
        }

        return recomendacoes;

    }

    private static Categoria pegarNovaCategoria(MeuGrafo grafo, Categoria categoriaAtual) {

        for (int i = 0; i < grafo.getArestas().quantidade(); i++) {
            Aresta aresta = grafo.getArestas().pegar(i);
            Vertice origem = aresta.getOrigem();
            Vertice destino = aresta.getDestino();

            if (origem.getCategoria().equals(categoriaAtual)) {
                return destino.getCategoria();
            }
        }

        return null;
    }
}





