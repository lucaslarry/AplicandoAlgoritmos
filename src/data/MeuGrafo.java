package data;

import entities.Categoria;

public class MeuGrafo {
    private MinhaEstruturaDeDados<Vertice> vertices;
    private MinhaEstruturaDeDados<Aresta> arestas;


    public MeuGrafo() {
        vertices = new MinhaEstruturaDeDados<>();
        arestas = new MinhaEstruturaDeDados<>();
    }

    public void adicionarVertice(Categoria nomeCategoria) {
        Vertice vertice = new Vertice(nomeCategoria);
        if (!vertices.contem(vertice)) {
            vertices.adicionar(vertice);
        }
    }

    public void adicionarAresta(Categoria categoria1, Categoria categoria2) {
        Vertice vertice1 = new Vertice(categoria1);
        Vertice vertice2 = new Vertice(categoria2);

        if (!vertices.contem(vertice1)) {
            vertices.adicionar(vertice1);
        }
        if (!vertices.contem(vertice2)) {
            vertices.adicionar(vertice2);
        }

        Aresta aresta = new Aresta(vertice1, vertice2);
        arestas.adicionar(aresta);
}

    public MinhaEstruturaDeDados<Aresta> getArestas() {
        return arestas;
    }

    public MinhaEstruturaDeDados<Vertice> getVertices() {
        return vertices;
    }

    public void setArestas(MinhaEstruturaDeDados<Aresta> arestas) {
        this.arestas = arestas;
    }

    public void setVertices(MinhaEstruturaDeDados<Vertice> vertices) {
        this.vertices = vertices;
    }
}
