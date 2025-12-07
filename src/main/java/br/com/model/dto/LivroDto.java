package br.com.model.dto;

public record LivroDto(String title, String authors, String publisher, String publishedDate, String description, String categories, ImageLinksDto imageLinks) {

}
