package br.com;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.Strictness;

import br.com.model.Livro;
import br.com.model.dto.GoogleBooksResponseDto;
import br.com.model.dto.ItemDto;
import br.com.model.dto.LivroDto;
import br.com.model.dto.VolumeInfoDto;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o termo de busca para livros: ");
        String busca = scanner.nextLine();
        String endereco = "https://www.googleapis.com/books/v1/volumes?q=intitle:" + busca;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create(endereco))
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String json = response.body();
        Gson gson = new GsonBuilder().setStrictness(Strictness.STRICT).create();
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
        System.out.println(livro);
    }
}
