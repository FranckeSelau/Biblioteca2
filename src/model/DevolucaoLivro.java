/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Francke
 */
public class DevolucaoLivro implements Comparable<DevolucaoLivro> {
    private Date devolucao;    
    private Livro livro;
    private RetiradaLivro retirada;
    private int atraso;
    

    public Date getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Date devolucao) throws Exception {
        if(retirada == null){
            throw new Exception("É necessário setar o valor para retirada antes de devolução.");
        }
        this.devolucao = devolucao;
        long diff =  devolucao.getTime() - retirada.getEntrega().getTime();
        if(diff < 0){
            atraso = 0;
        }else{
            atraso = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        }
        
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public RetiradaLivro getRetirada() {
        return retirada;
    }

    public void setRetirada(RetiradaLivro retirada) {
        this.retirada = retirada;
    }

    public int getAtraso() {
        return atraso;
    }

  
    
    @Override
    public int compareTo(DevolucaoLivro o) {
        return(this.getDevolucao().compareTo(o.getDevolucao()));
    }
    
}
