package br.com.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.com.exception.ProcessamentoException;
import br.com.model.Livro;

public class ExportarArquivo {

    public static void gerarArquivoDeLivrosFavoritos(List<Livro> livrofavoritos) throws ProcessamentoException {
        try {
            FileWriter wr = new FileWriter("LivrosFavoritos.txt");
            for (Livro livro : livrofavoritos) {
                wr.write(livro.toString());
            }
            wr.close();
        } catch (IOException e) {
            throw new ProcessamentoException("Erro na criação do arquivo");
        }
    }
}
