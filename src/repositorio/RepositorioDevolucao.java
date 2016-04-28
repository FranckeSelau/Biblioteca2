package repositorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import model.DevolucaoLivro;
import model.RetiradaLivro;

public class RepositorioDevolucao {

    private List<DevolucaoLivro> devolucoes;
    private RepositorioRetirada retiradaRepo;
    
    public RepositorioDevolucao(RepositorioRetirada retiradaRepo) {
        devolucoes = new ArrayList<DevolucaoLivro>();
        this.retiradaRepo = retiradaRepo;
    }
    
    public boolean addDevolucao(int idRetirada, DevolucaoLivro devolucao){
        RetiradaLivro retirada = retiradaRepo.getRetiradaById(idRetirada);
        if(retirada != null && !retirada.getLivroDevolvido()){
            devolucao.setRetirada(retirada);
            devolucao.setLivro(retirada.getLivro());
            RetiradaLivro ret = new RetiradaLivro();
            ret.setEntrega(new Date(System.currentTimeMillis()));
            retirada.setLivroDevolvido(true);
            return true;
        }
        
        return false;
    }
    
    

}
