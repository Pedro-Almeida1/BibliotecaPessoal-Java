package br.com;

import java.io.IOException;

import br.com.model.Livro;
import br.com.model.classes.BuscarLivro;
import br.com.model.classes.LivrosFavoritos;
import br.com.model.exception.ProcessamentoException;

public class App {

    public static void main(String[] args) throws ProcessamentoException, IOException, InterruptedException {
        try {
            LivrosFavoritos livrosFavoritos = new LivrosFavoritos(); 
            BuscarLivro buscarLivro = new BuscarLivro();
            Livro livro = buscarLivro.encontraLivro("batman");
            System.out.println(livro); 
            Livro livro2 = buscarLivro.encontraLivro("Superman");
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
