package view;

import java.util.InputMismatchException;
import model.Cliente;
import repositorio.RepositorioClientes;
import util.Console;
import view.menu.ClienteMenu;

/**
 *
 * @author Francke
 */
public class ClienteUI {

    private RepositorioClientes lista;

    public ClienteUI(RepositorioClientes lista) {
        this.lista = lista;
    }

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
