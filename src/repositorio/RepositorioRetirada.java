package repositorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.RetiradaLivro;

/**
 * Classe para repositório do tipo retirada de, onde serão armazenados os livros
 * emprestados.
 *
 * @author Francke
 * @since JDK 1.0
 */
public class RepositorioRetirada {

    /**
     * cria uma nova lista com objetos retiradas
     */
    private List<RetiradaLivro> retiradas;

    /**
     * Construtor para inicializar repositório de Devolução
     */
    public RepositorioRetirada() {
        retiradas = new ArrayList<RetiradaLivro>();
    }

    /**
     * Gera Retirada de livros através do ID
     *
     * @param id, informa o id para retirada.
     * @return um id válido para livro.
     */
    public RetiradaLivro getRetiradaById(int id) {
        for (RetiradaLivro ret : retiradas) {
            if (ret.getId() == id) {
                return ret;
            }
        }
        return null;
    }

    /**
     * Retorna o ID do último livro retirado
     *
     * @return ID do último livro retirado.
     */
    public int getUltimoId() {

        return retiradas.size();
    }

    /**
     * Gera um nova Retirada de livro
     *
     * @param retirada, informa uma nova retirada.
     * @return verdadeiro para um livro disponível ou ainda não retirado no
     * prazo, falso para um livro indisponível.
     */
    public boolean addRetirada(RetiradaLivro retirada) {
        RetiradaLivro r = null;
        Collections.reverse(retiradas);
        for (RetiradaLivro ret : retiradas) {
            if ((ret.getLivro().getIsbn() == retirada.getLivro().getIsbn()) && !ret.getLivroDevolvido()) {
                r = ret;
                break;
            }
        }

        if (r == null && validaRetirada(retirada)) {
            retirada.setId(getUltimoId() + 1);
            retiradas.add(retirada);
            return true;
        }

        if (r != null && (r.compareTo(retirada) < 0 && r.getLivroDevolvido()) && validaRetirada(retirada)) {
            retirada.setId(getUltimoId() + 1);
            retiradas.add(retirada);
            return true;
        }

        return false;
    }

    /**
     * Valida um nova Retirada de livro
     *
     * @param retirada, informa uma nova retirada.
     * @return verdadeiro para um cliente válido com menos de 3 retiradas dentro de um preríodo
     */
    private Boolean validaRetirada(RetiradaLivro retirada) {
        int i = 0;
        for (RetiradaLivro ret : retiradas) {
            if (ret.getCliente().getMatricula().equals(retirada.getCliente().getMatricula())) {
                i++;
            }
        }
        return i < 3;
    }

    /**
     * Retorna a lista de retiradas
     *
     * @return a lista de todas as retiradas correntes.
     */
    public List<RetiradaLivro> getListaDeRetiradas() {
        Collections.sort(retiradas);
        return retiradas;
    }
}
