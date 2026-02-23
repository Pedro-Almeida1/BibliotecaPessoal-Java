# 📚 Minha Biblioteca Pessoal
Este é o meu primeiro projeto individual em Java! Fui construindo e evoluindo essa aplicação passo a passo, colocando em prática tudo o que venho aprendendo na minha faculdade e na carreira de Java da Alura. 

O resultado é uma aplicação de linha de comando (Console) desenvolvida para buscar informações reais de livros e gerenciar uma lista de favoritos. Para isso, o projeto consome a API pública do Google Books, trazendo dados precisos sobre as obras pesquisadas.

## ✨ Funcionalidades

* **Busca de Livros:** Integração via HTTP com a API do Google Books para buscar livros pelo título.
* **Mapeamento de Dados:** Conversão do JSON retornado pela API para objetos Java (DTOs) utilizando records.
* **Gerenciamento de Usuários:** Criação de perfil de usuário com validação formato de e-mail utilizando Regex.
* **Rastreamento de Tempo:** Registro de data e hora em que um livro foi adicionado aos favoritos.
* **Exportação de Dados:** Geração automática de um arquivo LivrosFavoritos.txt contendo a lista formatada de todos os livros salvos pelo usuário.

## 🚀 Tecnologias e Práticas Utilizadas

* **Java 11+:** Utilização de recursos modernos como records, HttpClient.
* **Orientação a Objetos:** Código estruturado com divisão de responsabilidades (Model, DTO, Service, Exception).
* **Tratamento de Exceções:** Criação de exceções personalizadas (ProcessamentoException, EmailInvalidoException) para evitar erros.
* **Manipulação de Arquivos:** Uso de FileWriter com *Try-with-resources* para escrita de arquivos de texto.

## 🛠️ Como Executar o Projeto

1. Certifique-se de ter o **Java (JDK)** instalado na sua máquina.
2. Clone este repositório:
   ```bash
   git clone [https://github.com/seu-usuario/bibliotecapessoal.git](https://github.com/seu-usuario/bibliotecapessoal.git)