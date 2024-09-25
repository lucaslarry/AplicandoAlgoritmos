package entities;

import java.util.Date;

public class Livro implements Comparable<Livro> {
    private String titulo;
    private Autor autor;
    private Date publicacao;
    private Categoria categoria;

    public Livro(){

    }

    public Livro(String titulo, Autor autor, Date publicacao, Categoria categoria){
        this.titulo = titulo;
        this.autor = autor;
        this.publicacao = publicacao;
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }
    public Date getPublicacao() {
        return publicacao;
    }
    public String getTitulo() {
        return titulo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    public void setPublicacao(Date publicacao) {
        this.publicacao = publicacao;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Livro [titulo=" + titulo + "]";
    }

    @Override
    public int compareTo(Livro o) {
        return this.titulo.compareTo(o.titulo);
    }
    
}
