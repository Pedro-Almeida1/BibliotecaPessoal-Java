package br.com.model.classes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.model.Livro;
import br.com.model.exception.ProcessamentoException;

public class LivrosFavoritos {

    private ArrayList<Livro> livrosFavoritosList;

    public LivrosFavoritos() {
        this.livrosFavoritosList = new ArrayList<>();
    }

    public void adicionarLivroAoFavoritos(Livro livro) throws ProcessamentoException {
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

    public ArrayList getLivrosFavoritosList() {
        return livrosFavoritosList;
    }

}
