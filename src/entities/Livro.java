package entities;

import java.util.Date;

public class Livro implements Comparable<Livro> {
    private String titulo;
    private Autor autor;
    private Date publicacao;

    public Livro(){

    }

    public Livro(String titulo, Autor autor, Date publicacao){
        this.titulo = titulo;
        this.autor = autor;
        this.publicacao = publicacao;
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
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    public void setPublicacao(Date publicacao) {
        this.publicacao = publicacao;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
