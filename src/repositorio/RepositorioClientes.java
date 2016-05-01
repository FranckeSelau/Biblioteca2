package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;

/**
 * Classe para repositório do tipo clientes, onde serão armazenados os clientes
 * da Biblioteca.
 *
 * @author Francke
 * @since JDK 1.0
 */
public class RepositorioClientes {

    /**
     * cria uma nova lista com objetos cliente
     */
    private List<Cliente> clientes;

    /**
     * Construtor para inicializar repositório de Clientes
     */
    public RepositorioClientes() {
        clientes = new ArrayList<Cliente>();
    }

    /**
     * adiciona novos clientes ao repositório
     *
     * @param cliente, cria um novo cliente.
     * @return novo cliente a lista
     */
    public boolean addClientes(Cliente cliente) {
        return (clientes.add(cliente));
    }

    /**
     * mostra a lista de clientes existentes
     *
     * @return todos clientes cadastrados
     */
    public List<Cliente> getListaClientes() {
        return clientes;
    }

    /**
     * verifica clientes existentes
     *
     * @param matricula, verifica se a matrícula não é repetida.
     * @return verdadeiro para clientes ja existentes ou falso caso contrário.
     */
    public boolean clienteExiste(String matricula) {
        for (Cliente cliente : clientes) {
            if (cliente.getMatricula().equals(matricula)) {
                return true;
            }
        }
        return false;
    }

    /**
     * busca um cliente existente na lista através da sua matrícula
     *
     * @param matricula de um cliente para uma busca.
     * @return um cliente existente conforme a matrícula informada ou nulo para
     * uma matrícula inexistente na lista.
     */
    public Cliente buscarCliente(String matricula) {
        for (Cliente cliente : clientes) {
            if (cliente.getMatricula().equals(matricula)) {
                return cliente;
            }
        }
        return null;
    }
}
