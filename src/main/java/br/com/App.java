package br.com;

import java.io.IOException;

import br.com.model.classes.BuscarLivro;
import br.com.model.classes.Livro;
import br.com.model.classes.LivrosFavoritos;
import br.com.model.exception.ProcessamentoException;

public class App {

    public static void main(String[] args) throws ProcessamentoException, IOException, InterruptedException {
        BuscarLivro buscarLivro = new BuscarLivro();
        Livro livro = buscarLivro.encontraLivro("batman");
        Livro livro2 = buscarLivro.encontraLivro("Superman");
        LivrosFavoritos livrosFavoritos = new LivrosFavoritos();
        livrosFavoritos.adicionarLivroAoFavoritos(livro);
        livrosFavoritos.adicionarLivroAoFavoritos(livro2);
        System.out.println(livrosFavoritos.getLivrosFavoritosList());
        livrosFavoritos.gerarArquivoDeLivrosFavoritos();
    }
}
