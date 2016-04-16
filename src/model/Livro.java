package model;


public class Livro {
    private static int CODIGO_GERADO=1;
    private String nome, isbn, descricao;

    public Livro(String isbn, String nome, String descricao) {
        this.nome = nome;
        this.isbn = isbn;
        this.descricao = descricao;
    }    

    public String getNome() {
        return nome;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDescricao() {
        return descricao;
    }       
    
    private int generateCodigo(){
        return(CODIGO_GERADO++);
    }    
}
