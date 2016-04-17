package model;

import java.util.Date;

public class Livro {
    private static int CODIGO_GERADO=1;
    private String nome, autor, editora;
    private int isbn;
    private Date ano;

    public Livro(int isbn, String nome, String autor, String editora, Date ano) {
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.isbn = isbn;
        this.ano = ano;
    }   

    public static int getCODIGO_GERADO() {
        return CODIGO_GERADO;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public int getIsbn() {
        return isbn;
    }

    public Date getAno() {
        return ano;
    }        
    
    private int generateCodigo(){
        return(CODIGO_GERADO++);
    }    
}
