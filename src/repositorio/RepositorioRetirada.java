package repositorio;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.RetiradaLivro;


/**
 * Classe para repositório do tipo retirada de, onde serão armazenados os livros emprestados.
 *
 * @author Francke
 * @since JDK 1.0
 */

public class RepositorioRetirada {

    private List<RetiradaLivro> retiradas;

    public RepositorioRetirada() {
        retiradas = new ArrayList<RetiradaLivro>();
    }
    
    public RetiradaLivro getRetiradaById(int id) {
        for (RetiradaLivro ret : retiradas) {
            if (ret.getId() == id) {
                return ret;
            }
        }
        return null;
    }
    
    public int getUltimoId() {
        int idRetirada = 0;
        for (RetiradaLivro ret : retiradas) {
            idRetirada = ret.getId();
        }
        return idRetirada;
    }

    public boolean addRetirada(RetiradaLivro retirada) {
        RetiradaLivro r = null;
        for (RetiradaLivro ret : retiradas) {
            if (ret.getLivro().getIsbn() == retirada.getLivro().getIsbn()) {
                r = ret;
                break;
            }
        }
        
        
        if (r == null) {
            retiradas.add(retirada);
            return true;
        }
        
        if(r != null && (r.compareTo(retirada) > 0 || r.getLivroDevolvido())){
            retiradas.add(retirada);
            return true;
        }
        
        return false;
    }
    
    public List<RetiradaLivro> getListaDeRetiradas(){
         Collections.sort(retiradas);
         return retiradas;
    }

}
