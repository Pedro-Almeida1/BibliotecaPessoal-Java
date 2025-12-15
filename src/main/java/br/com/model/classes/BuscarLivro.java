package br.com.model.classes;

import java.io.IOException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.Strictness;

import br.com.model.dto.GoogleBooksResponseDto;
import br.com.model.dto.ItemDto;
import br.com.model.dto.LivroDto;
import br.com.model.dto.VolumeInfoDto;

public class BuscarLivro {

    public Livro encontraLivro(String nomeLivro) throws IOException, InterruptedException {
        String busca = URLEncoder.encode(nomeLivro, StandardCharsets.UTF_8);
        String endereco = "https://www.googleapis.com/books/v1/volumes?q=intitle:" + busca;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create(endereco))
                .build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String json = response.body();
        Gson gson = new GsonBuilder().setStrictness(Strictness.STRICT).setPrettyPrinting().create();
        GoogleBooksResponseDto googleBooksResponse = gson.fromJson(json, GoogleBooksResponseDto.class);

        ItemDto primeiroItem = googleBooksResponse.items().get(0);
        VolumeInfoDto volumeInfo = primeiroItem.volumeInfo();
        String authors = String.join(", ", volumeInfo.authors());
        String categories = String.join(", ", volumeInfo.categories());

        LivroDto livroDto = new LivroDto(
                volumeInfo.title(),
                authors,
                volumeInfo.publisher(),
                volumeInfo.publishedDate(),
                volumeInfo.description(),
                categories,
                volumeInfo.imageLinks()
        );
        Livro livro = new Livro(livroDto);
        return livro;
    }
}
