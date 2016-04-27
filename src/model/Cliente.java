
package model;

import java.util.Objects;

/**
 * Classe para objetos do tipo cliente, onde serão criados os clientes da Biblioteca.
 *
 * @author Francke
 * @since JDK 1.0
 */
public class Cliente {

    private String matricula, nome, telefone;

    /**
     * Construtor para inicializar cliente
     *
     * @param matricula identifica a matrícula de uma pessoa.
     * @param nome identifica o nome de uma pessoa.
     * @param telefone identifica telefone de uma pessoa.
     *
     */
    public Cliente(String matricula, String nome, String telefone) {
        this.matricula = matricula;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public String toString() {
        return matricula+" - "+nome +", "+ telefone;
    }
    
    
    
    
    
}
