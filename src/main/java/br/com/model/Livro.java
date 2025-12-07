package br.com.model;

import br.com.model.dto.ImageLinksDto;
import br.com.model.dto.LivroDto;

public class Livro {

    public Livro(LivroDto livroDto) {
        this.titulo = livroDto.title();
        this.autor = livroDto.authors();
        this.editora = livroDto.publisher();
        this.descricao = livroDto.description();
        try {
            this.anoDePublicacao = Integer.parseInt(livroDto.publishedDate().substring(0, 4));
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            this.anoDePublicacao = 0;
        }
        this.categoria = livroDto.categories();
        this.imageLinks = livroDto.imageLinks();
    }

    private String titulo;
    private String autor;
    private int anoDePublicacao;
    private String descricao;
    private String editora;
    private String categoria;
    private ImageLinksDto imageLinks;

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

    @Override
    public String toString() {
        return String.format("""
                -------  Livro  -------
                Título:        %s
                Autor:         %s
                Editora:       %s
                Categoria:     %s
                Descrição:     %s
                Imagem:        %s
                Data Publicação:    %d
                -----------------------
                """, titulo, autor, editora, categoria, descricao, imageLinks.thumbnail(), anoDePublicacao);
    }
}
