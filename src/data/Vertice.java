package data;

import entities.Categoria;
import entities.Livro;

import java.util.Objects;

public class Vertice {
    private Categoria categoria;

    public Vertice() {

    }

    public Vertice(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertice vertice = (Vertice) o;
        return Objects.equals(categoria, vertice.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(categoria);
    }


}
