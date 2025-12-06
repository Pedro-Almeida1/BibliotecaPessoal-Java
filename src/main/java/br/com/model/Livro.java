package br.com.model;

public class Livro{
    private String titulo;
    private String autor;
    private int anoDePublicacao;

   //Adicionar model.Livro
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //Adicionar nome do autor
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    //Adiciona ano de publicação
    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }
    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    public void exibirDetalhes(){
        System.out.println(getTitulo());
        System.out.println(getAutor());
        System.out.println(getAnoDePublicacao());
    }


// Listar Livros
// Buscar model.Livro
// Remover model.Livro
}