package view;

import java.util.InputMismatchException;
import model.Cliente;
import repositorio.RepositorioClientes;
import util.Console;
import view.menu.ClienteMenu;

/**
 * Classe para Menu de Clientes - Interface com o Usuário
 *
 * @author Francke
 * @since JDK 1.0
 */
public class ClienteUI {

    /**
    * Lista novos Clientes.
    */
    private RepositorioClientes lista;
    
    /**
     * Construtor para inicializar lista menu cliente
     *
     * @param lista de clientes.
     */
    public ClienteUI(RepositorioClientes lista) {
        this.lista = lista;
    }

    /**
     * Executa as opções do Menu Cliente.
     *
     */
    public void executar() {
        int opcao = 0;
        do {
            System.out.println(ClienteMenu.getOpcoes());
            try{
                 opcao = Console.scanInt("Digite sua opção: ");
            }catch (InputMismatchException e) {
                   opcao = -1;
            }
            switch (opcao) {
                case ClienteMenu.OP_CADASTRAR:
                    cadastrarCliente();
                    break;
                case ClienteMenu.OP_LISTAR:
                    mostrarClientes();
                    break;
                case ClienteMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.err.println("ERRO! Digite uma opção válida!!");

            }
        } while (opcao != ClienteMenu.OP_VOLTAR);
    }
    
    /**
     * Cadastra novo Cliente.
     *
     * @param matricula, recebe a matrícula de um novo cliente.
     * @param nome, recebe o nome de um novo cliente.
     * @param telefone, recebe telefone de um novo cliente.
     */
    private void cadastrarCliente() {
        String matricula = Console.scanString("Matrícula: ");
        if (lista.clienteExiste(matricula)) {
            System.err.println("ERRO! Matrícula " + matricula + " já existente no cadastro");
        } else {
            String nome = Console.scanString("Nome: ");
            String telefone = Console.scanString("Telefone: ");
            lista.addClientes(new Cliente(matricula, nome, telefone));
            System.out.println("Cliente " + nome + " cadastrado com sucesso!");
        }
    }

    /**
     * Mostra novo Cliente.
     *
     * imprime os clientes formatados em Strings
     */
public void mostrarClientes() {
        System.out.println("--------------------------------------\n");
        System.out.println(String.format("%-10s", "MATRÍCULA") + "\t"
                + String.format("%-20s", "|NOME") + "\t"
                + String.format("%-20s", "|TELEFONE"));
        for (Cliente cliente : lista.getListaClientes()) {
            System.out.println(String.format("%-10s", cliente.getMatricula()) + "\t"
                    + String.format("%-20s", "|" + cliente.getNome()) + "\t"
                    + String.format("%-20s", "|" + cliente.getTelefone()));
        }
    }
}
