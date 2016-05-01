
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Classe para objetos do tipo devolução de livros, onde são instanciados os eventos de devoluções
 * Implementa FrameWork CompareTo
 * @author Francke
 * @since JDK 1.0
 */
public class DevolucaoLivro implements Comparable<DevolucaoLivro> {
    private Date devolucao;    
    private Livro livro;
    private RetiradaLivro retirada;
    private int atraso;
 
    /**
     * Retorna a devoluçao
     *
     * @return a devolução de um livro.
     */
    public Date getDevolucao() {
        return devolucao;
    }
    
    /**
     * Retorna data de devoluçao no formato correto
     *
     * @return a data de devolução no formato "dd/MM/yyyy".
     */
    public String getDevolucaoFormatada(){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(devolucao);
    }

    /**
     * Método que verifica o atraso na devolução de um livro
     *
     * @param data de devolução.
     */
    public void setDevolucao(Date devolucao) throws Exception {
        if(retirada == null){
            throw new Exception("É necessário setar o valor para retirada antes de devolução.");
        }
        this.devolucao = devolucao;
        long diff =  devolucao.getTime() - retirada.getDevolvido().getTime();
        if(diff < 0){
            atraso = 0;
        }else{
            atraso = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        }        
    }

    /**
     * Método que retorna um livro a ser devolvido
     *
     * @return livro retirado. 
     */
    public Livro getLivro() {
        return livro;
    }

    /**
     * Método que informa um livro a ser devolvido
     *
     * @param livro retirado.
     */
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    /**
     * Método que retorna se o livro a ser devolvido foi realmente retirado
     *
     * @return livro retirado.
     */
    public RetiradaLivro getRetirada() {
        return retirada;
    }

    /**
     * Método que informa a retirada a ser devolvida
     *
     * @param retirada a ser devolvida.
     */
    public void setRetirada(RetiradaLivro retirada) {
        this.retirada = retirada;
    }

    /**
     * Método que informa a retirada a ser devolvida
     *
     * @param retirada a ser devolvida.
     */
    public int getAtraso() {
        return atraso;
    }  
    
    /**
     * Compara se um livro ja foi devolvido antes de realizar a devolução do mesmo.
     *
     * @return verdadeiro ou falso para o livro a ser devolvido.
     */
    @Override
    public int compareTo(DevolucaoLivro o) {
        return(this.getDevolucao().compareTo(o.getDevolucao()));
    }   
}
