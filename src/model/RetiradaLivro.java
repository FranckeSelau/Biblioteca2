package model;

import java.util.Date;

public class RetiradaLivro implements Comparable<RetiradaLivro> {

   
    private Date entrega;    
    private Cliente cliente;
    private Livro livro;
    
    public Date getEntrega() {
        return entrega;
    }
    
    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public int compareTo(RetiradaLivro o) {
        return(this.getEntrega().compareTo(o.getEntrega()));
    }

    public Object getHorario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
