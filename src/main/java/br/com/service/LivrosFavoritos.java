package br.com.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.exception.ProcessamentoException;
import br.com.model.Livro;

public class LivrosFavoritos {

    private List<Livro> livrosFavoritosList = new ArrayList<>();

    public void adicionarLivroAoFavoritos(Livro livro) {
        livrosFavoritosList.add(livro);
    }

    public void gerarArquivoDeLivrosFavoritos() throws ProcessamentoException {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter wr = new FileWriter("LivrosFavoritos.json");
            wr.write(gson.toJson(livrosFavoritosList));
            wr.close();
        } catch (IOException e) {
            throw new ProcessamentoException("Erro na criação do arquivo");
        }
    }

    public List<Livro> getLivrosFavoritosList() {
        return livrosFavoritosList;
    }

}
