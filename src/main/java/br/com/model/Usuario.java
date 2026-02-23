package br.com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.exception.EmailInvalidoException;

public class Usuario {

    private String nome;
    private String email;
    private List<Livro> livrosFavoritos = new ArrayList<>();

    public Usuario(String nome, String email) throws EmailInvalidoException {
        this.nome = nome;
        validarEmail(email);
    }

    private void validarEmail(String email) throws EmailInvalidoException {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+([.|_][a-zA-Z0-9]+)*@[a-zA-Z]+\\.[a-z]{2,4}");
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            this.email = email;
        } else {
            throw new EmailInvalidoException("Email: " + email + ", inválido!!");
        }
    }

    public void adicionarLivroAoFavoritos(Livro livro) {
        livrosFavoritos.add(livro);
    }

    public List<Livro> getLivrosFavoritosList() {
        return livrosFavoritos;
    }
}
