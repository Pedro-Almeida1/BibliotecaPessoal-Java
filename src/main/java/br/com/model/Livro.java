package br.com.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.model.dto.ImageLinksDto;
import br.com.model.dto.LivroDto;

public class Livro {

    private LocalDateTime dataAdicionado = LocalDateTime.now();
    private String titulo;
    private String autor;
    private int anoDePublicacao;
    private String descricao;
    private String editora;
    private String categoria;
    private ImageLinksDto imagens;

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
        this.imagens = livroDto.imageLinks();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEditora() {
        return editora;
    }

    public String getCategoria() {
        return categoria;
    }

    public ImageLinksDto getImageLinks() {
        return imagens;
    }

    public String getDataAdicionado() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String horaFormatada = dataAdicionado.format(formatter);
        return horaFormatada;
    }

    public ImageLinksDto getImagens() {
        return imagens;
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
                Hora adicionado:    %s
                -----------------------
                
                """, titulo, autor, editora, categoria, descricao, imagens.thumbnail(), anoDePublicacao, getDataAdicionado());
    }

}
