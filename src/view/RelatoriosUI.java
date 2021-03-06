/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import model.Cliente;
import model.Livro;
import repositorio.RepositorioClientes;
import repositorio.RepositorioLivros;
import repositorio.RepositorioRetirada;
import util.Console;
import util.DateUtil;
import view.menu.RelatoriosMenu;

/**
 *
 * @author Francke
 */
public class RelatoriosUI {

    /**
     * Lista novos Livros.
     */
    private RepositorioLivros listaLivros;

    /**
     * Lista novos Livros.
     */
    private RepositorioRetirada listaRetiradas;

    /**
     * Lista novos clientes.
     */
    private RepositorioClientes listaClientes;

    /**
     * Lista novos Livros.
     */
    private RepositorioLivros listaLivrosDisponiveis;

    /**
     * Construtor para inicializar lista menu livros
     *
     * @param lista de livros.
     */
    public RelatoriosUI(RepositorioLivros lista, RepositorioRetirada listaRetiradas, RepositorioClientes listaClientes) {
        this.listaLivros = lista;
        this.listaRetiradas = listaRetiradas;
        this.listaClientes = listaClientes;
    }

    /**
     * Executa as opções do Menu Livros.
     *
     */
    public void executar() {
        int opcao = 0;
        do {
            System.out.println(RelatoriosMenu.getOpcoes());
            try {
                opcao = Console.scanInt("Digite sua opção: ");
            } catch (InputMismatchException e) {
                opcao = -1;
            }

            switch (opcao) {
                case RelatoriosMenu.OP_RELATORIO_LIVROS_DISP:
                    livrosDisponiveis();
                    break;
                case RelatoriosMenu.OP_RELATORIO_LIVROS_RET:
                    livrosMaisRetirados();
                    break;
                case RelatoriosMenu.OP_RELATORIO_CLIENTES_RET:
                    clientesMaisRetiraram();
                    break;
                case RelatoriosMenu.OP_RELATORIO_CLIENTES_ATR:
                    clientesMaisRetiraram();
                    break;
                case RelatoriosMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.err.println("ERRO! Digite uma opção válida!!");

            }
        } while (opcao != RelatoriosMenu.OP_VOLTAR);
    }

    public void livrosDisponiveis() {
        mostrarLivros(listaLivros.getListaLivrosDisponiveis(listaRetiradas));
    }

    public void livrosMaisRetirados() {
        Collections.sort(listaLivros.getListaLivros(), new MyComparator());
        mostrarLivrosRetirados(listaLivros.getListaLivros());
    }

    public void clientesMaisRetiraram() {
        Collections.sort(listaClientes.getListaClientes(), new MyComparatorCliente());
        mostrarClientes(listaClientes);
    }
    
    public void clientesMaisAtrasaram() {
        Collections.sort(listaClientes.getListaClientes(), new MyComparatorClienteAtraso());
        mostrarClientes(listaClientes);
    }

    /**
     * Mostra novo livro.
     *
     * imprime os livros formatados em Strings
     */
    public void mostrarLivros(List<Livro> listaLivrosDisponiveis) {
        System.out.println("--------------------------------------\n");
        System.out.println(String.format("%-10s", "ISBN") + "\t"
                + String.format("%-20s", "|NOME") + "\t"
                + String.format("%-20s", "|AUTOR") + "\t"
                + String.format("%-20s", "|EDITORA") + "\t"
                + String.format("%-5s", "|ANO"));
        for (Livro livro : listaLivrosDisponiveis) {
            System.out.println(String.format("%-10s", livro.getIsbn()) + "\t"
                    + String.format("%-20s", "|" + livro.getNome()) + "\t"
                    + String.format("%-20s", "|" + livro.getAutor()) + "\t"
                    + String.format("%-20s", "|" + livro.getEditora()) + "\t"
                    + String.format("%-5s", "|" + DateUtil.yearToString(livro.getAno()))); // converte ano data em String
        }
    }

    /**
     * Mostra novo livro.
     *
     * imprime os livros formatados em Strings
     */
    public void mostrarLivrosRetirados(List<Livro> listaLivrosDisponiveis) {
        System.out.println("--------------------------------------\n");
        System.out.println(String.format("%-10s", "ISBN") + "\t"
                + String.format("%-20s", "|NOME") + "\t"
                + String.format("%-20s", "|AUTOR") + "\t"
                + String.format("%-20s", "|EDITORA") + "\t"
                + String.format("%-20s", "|RETIRADAS") + "\t"
                + String.format("%-5s", "|ANO"));
        for (Livro livro : listaLivrosDisponiveis) {
            System.out.println(String.format("%-10s", livro.getIsbn()) + "\t"
                    + String.format("%-20s", "|" + livro.getNome()) + "\t"
                    + String.format("%-20s", "|" + livro.getAutor()) + "\t"
                    + String.format("%-20s", "|" + livro.getEditora()) + "\t"
                    + String.format("%-20s", "|" + livro.getRetiradas()) + "\t"
                    + String.format("%-5s", "|" + DateUtil.yearToString(livro.getAno()))); // converte ano data em String
        }
    }
    
    public void mostrarClientes(RepositorioClientes clientes) {
        System.out.println("--------------------------------------\n");
        System.out.println(String.format("%-10s", "MATRÍCULA") + "\t"
                + String.format("%-20s", "|NOME") + "\t"
                + String.format("%-20s", "|RETIRADAS") + "\t"
                + String.format("%-20s", "|ATRASOS") + "\t"
                + String.format("%-20s", "|TELEFONE"));
        for (Cliente cliente : clientes.getListaClientes()) {
            System.out.println(String.format("%-10s", cliente.getMatricula()) + "\t"
                    + String.format("%-20s", "|" + cliente.getNome()) + "\t"
                    + String.format("%-20s", "|" + cliente.getRetiradas()) + "\t"
                    + String.format("%-20s", "|" + cliente.getAtrasos()) + "\t"
                    + String.format("%-20s", "|" + cliente.getTelefone()));
        }
    }
}
