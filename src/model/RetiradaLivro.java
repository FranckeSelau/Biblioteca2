package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class RetiradaLivro implements Comparable<RetiradaLivro> {

    private int id;
    private Date retirada;
    private Date entrega;
    private Cliente cliente;
    private Livro livro;
    private Boolean livroDevolvido = false;

    public RetiradaLivro() {
        long DAY_IN_MS = 1000 * 60 * 60 * 24;
        this.setEntrega(new Date(System.currentTimeMillis() + (7 * DAY_IN_MS)));
    }

    public Date getEntrega() {
        return entrega;
    }

    public String getEntregaFormatada() {
        LocalDate formatter;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(entrega);
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

    public Date getRetirada() {
        return retirada;
    }

    public void setRetirada(Date retirada) {
        this.retirada = retirada;
    }

    public Boolean getLivroDevolvido() {
        return livroDevolvido;
    }

    public void setLivroDevolvido(Boolean livroDevolvido) {
        this.livroDevolvido = livroDevolvido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(RetiradaLivro o) {
        return (this.getEntrega().compareTo(o.getEntrega()));
    }

    public Object getHorario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
