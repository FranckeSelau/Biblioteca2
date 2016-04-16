
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;

/**
 *
 * @author Francke
 */
public class RepositorioClientes {

    private List<Cliente> clientes;

    public RepositorioClientes() {
        clientes = new ArrayList<Cliente>();
    }

    public boolean addClientes(Cliente cliente) {
        return (clientes.add(cliente));
    }

    public List<Cliente> getListaClientes() {
        return clientes;
    }

    public boolean clienteExiste(String matricula) {
        for (Cliente cliente : clientes) {
            if (cliente.getMatricula().equals(matricula)) {
                return true;
            }
        }
        return false;
    }

    public Cliente buscarCliente(String matricula) {
        for (Cliente cliente : clientes) {
            if (cliente.getMatricula().equals(matricula)) {
                return cliente;
           }
        }
        return null;
    }
} 
