package repositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DevolucaoLivro;
import model.RetiradaLivro;

/**
 * Classe para repositório de devolução de livros, onde serão arazenados os clientes
 * que devolveram livros.
 *
 * @author Francke
 * @since JDK 1.0
 */
public class RepositorioDevolucao {
    
    /**
     * cria uma nova lista com objetos devolução
     */
    private List<DevolucaoLivro> devolucoes;
    private RepositorioRetirada retiradaRepo;

    /**
     * Construtor para inicializar repositório de Devolução
     */
    public RepositorioDevolucao(RepositorioRetirada retiradaRepo) {
        devolucoes = new ArrayList<DevolucaoLivro>();
        this.retiradaRepo = retiradaRepo;
    }
    
    /**
     * adiciona novas devoluções ao repositório
     *
     * @param idRetirada, informa o id da retirada.
     * @param devolucao, insere nova devolução.
     * @return nova devolução de livro.
     */
    public boolean addDevolucao(int idRetirada, DevolucaoLivro devolucao) {
        RetiradaLivro retirada = retiradaRepo.getRetiradaById(idRetirada);
        if (retirada != null && !retirada.getLivroDevolvido()) {
            try {
                devolucao.setRetirada(retirada);
                devolucao.setLivro(retirada.getLivro());
                devolucao.setDevolucao(new Date(System.currentTimeMillis()));
                RetiradaLivro ret = new RetiradaLivro();
                ret.setEntrega(new Date(System.currentTimeMillis()));
                retirada.setLivroDevolvido(true);
                retirada.setDevolvido(new Date(System.currentTimeMillis()));
                if (devolucao.getAtraso() > 0) {
                    System.err.println("Livro devolvido com " + devolucao.getAtraso() + " dia(s) de atraso.");
                }
                return true;
            } catch (Exception ex) {
                Logger.getLogger(RepositorioDevolucao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
    }
}
