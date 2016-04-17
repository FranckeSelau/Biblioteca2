
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

    public boolean livroExiste(int isbn) {
        for (Livro livro : listaLivros) {
            if (livro.getIsbn() == isbn) {
                return true;
            }
        }
        return false;
    }

    public Livro buscarLivro(int isbn) {
        for (Livro livro : listaLivros) {
            if (livro.getIsbn() ==isbn) {
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
