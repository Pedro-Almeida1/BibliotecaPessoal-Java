package br.com;

import br.com.exception.EmailInvalidoException;
import br.com.exception.ProcessamentoException;
import br.com.model.Livro;
import br.com.model.Usuario;
import br.com.service.BuscarLivro;
import br.com.service.ExportarArquivo;

public class App {

    public static void main(String[] args) {
        try {
            Usuario usuario1 = new Usuario("Pedro Almeida", "pedro.ramos@carglass.com");
            BuscarLivro buscar = new BuscarLivro();
            Livro livro = buscar.encontraLivro("Batman");
            System.out.println(livro);
            usuario1.adicionarLivroAoFavoritos(livro);
            System.out.println(usuario1.getLivrosFavoritosList());
            ExportarArquivo.gerarArquivoDeLivrosFavoritos(usuario1.getLivrosFavoritosList());

        } catch (ProcessamentoException e) {
            System.out.println(e.getMessage());
        } catch (EmailInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }
}
