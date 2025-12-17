package br.com;

import java.io.IOException;

import br.com.exception.ProcessamentoException;
import br.com.model.Livro;
import br.com.service.BuscarLivro;
import br.com.service.LivrosFavoritos;

public class App {

    public static void main(String[] args) throws ProcessamentoException, IOException, InterruptedException {
        try {
            BuscarLivro buscar = new BuscarLivro();
            LivrosFavoritos livrosFavoritos = new LivrosFavoritos();
            Livro livro = buscar.encontraLivro("batman");
            System.out.println(livro);
            Livro livro2 = buscar.encontraLivro("Superman");
            System.out.println(livro2);
            livrosFavoritos.adicionarLivroAoFavoritos(livro);
            livrosFavoritos.adicionarLivroAoFavoritos(livro2);
            System.out.println(livrosFavoritos.getLivrosFavoritosList());
            livrosFavoritos.gerarArquivoDeLivrosFavoritos();

        } catch (ProcessamentoException e) {
            System.out.println(e.getMessage());
        }
    }
}
