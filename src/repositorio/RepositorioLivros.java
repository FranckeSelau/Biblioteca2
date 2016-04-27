package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Livro;

/**
 * Classe para repositório do tipo livros, onde serão armazenados os livros da
 * Biblioteca.
 *
 * @author Francke
 * @since JDK 1.0
 */
public class RepositorioLivros {

    /**
     * cria uma nova lista com objetos livros
     */
    private List<Livro> listaLivros;

    /**
     * Construtor para inicializar repositório de livros
     */
    public RepositorioLivros() {
        listaLivros = new ArrayList<Livro>();
    }

    /**
     * adiciona novos livros ao repositório
     *
     * @param novo livro, adiciona um novo livro.
     * @return novo livro a lista
     */
    public boolean addLivros(Livro livros) {
        return (listaLivros.add(livros));
    }

    /**
     * mostra a lista de livros existentes
     *
     * @return todos livros cadastrados na lista de livros.
     */
    public List<Livro> getListaLivros() {
        return listaLivros;
    }

    /**
     * verifica livros existentes
     *
     * @return verdadeiro para livros ja existentes ou falso caso contrário.
     */
    public boolean livroExiste(int isbn) {
        for (Livro livro : listaLivros) {
            if (livro.getIsbn() == isbn) {
                return true;
            }
        }
        return false;
    }

    /**
     * busca um livro existente na lista através de seu ISBN
     *
     * @param isbn de um livro para uma busca.
     * @return um livro existente conforme o ISBN informado ou nulo para um ISBN
     * inexistente na lista.
     */
    public Livro buscarLivro(int isbn) {
        for (Livro livro : listaLivros) {
            if (livro.getIsbn() == isbn) {
                return livro;
            }
        }
        return null;
    }

    /**
     * busca um livro existente na lista através de seu nome
     *
     * @param nome de um livro para uma busca.
     * @return um livro existente conforme o nome informado ou nulo para um nome
     * inexistente na lista.
     */
    public Livro buscarLivroPorNome(String nome) {
        for (Livro livro : listaLivros) {
            if (livro.getNome().equals(nome)) {
                return livro;
            }
        }
        return null;
    }
}
