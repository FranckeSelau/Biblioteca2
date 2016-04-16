
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Livro;

/**
 *
 * @author Francke
 */
public class RepositorioLivros {
    private List<Livro> listaLivros;

    public RepositorioLivros() {
        listaLivros = new ArrayList<Livro>();
    }

    public boolean addLivros(Livro livros) {
        return (listaLivros.add(livros));
    }

    public List<Livro> getListaLivros() {
        return listaLivros;
    }

    public boolean livroExiste(String isbn) {
        for (Livro livro : listaLivros) {
            if (livro.getIsbn().equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    public Livro buscarLivro(String isbn) {
        for (Livro livro : listaLivros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
           }
        }
        return null;
    }    
    public Livro buscarLivroPorNome(String nome) {
        for (Livro livro : listaLivros) {
            if (livro.getNome().equals(nome)) {
                return livro;
           }
        }
        return null;
    }    
}
