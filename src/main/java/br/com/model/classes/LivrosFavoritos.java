package br.com.model.classes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LivrosFavoritos {

    private ArrayList<Livro> livrosFavoritosList;

    public LivrosFavoritos() {
        this.livrosFavoritosList = new ArrayList<>();
    }

    public void adicionarLivroAoFavoritos(Livro livro) {
        livrosFavoritosList.add(livro);
    }

    public void gerarArquivoDeLivrosFavoritos() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter wr = new FileWriter("LivrosFavoritos.json");
        wr.write(gson.toJson(livrosFavoritosList));
        wr.close();
    }

    public ArrayList getLivrosFavoritosList() {
        return livrosFavoritosList;
    }

}
