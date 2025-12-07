package br.com.model.dto;

import java.util.List;

public record VolumeInfoDto(String title, List<String> authors, String publisher, String publishedDate, String description, List<String> categories, ImageLinksDto imageLinks) {
}
