package br.com;
import br.com.model.Livro;

public class Biblioteca {
    public static void main(String[] args) {
        Livro livro1 = new Livro();
        livro1.setTitulo("Diario de um Banana");
        livro1.setAnoDePublicacao(2006);
        livro1.setAutor("Pedrinho");

        livro1.exibirDetalhes();
    }
}