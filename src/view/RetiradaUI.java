/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Date;
import model.Cliente;
import model.Livro;
import model.RetiradaLivro;
import repositorio.RepositorioClientes;
import repositorio.RepositorioLivros;
import repositorio.RepositorioRetirada;
import util.Console;
import view.menu.RetiradaMenu;

/**
 *
 * @author Francke
 */
public class RetiradaUI {

    private RepositorioRetirada lista;
    private RepositorioLivros livros;
    private RepositorioClientes clientes;

    public RetiradaUI(RepositorioRetirada lista, RepositorioLivros livros, RepositorioClientes clientes) {
        this.lista = lista;
        this.livros = livros;
        this.clientes = clientes;
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(RetiradaMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção: ");
            try {
                switch (opcao) {
                    case RetiradaMenu.OP_RETIRADA:
                        retirarLivro();
                        break;
                    case RetiradaMenu.OP_LISTAR:
                        mostrarRetirada();
                        break;
                    case RetiradaMenu.OP_VOLTAR:
                        System.out.println("Retornando ao menu principal..");
                        break;
                    default:
                        System.err.println("ERRO! Digite uma opção válida!!");

                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (opcao != RetiradaMenu.OP_VOLTAR);
    }

    private void retirarLivro() throws Exception {
        //Busca o cliente pela matrícula
        String matricula = Console.scanString("Informe a matrícula do usuario: ");
        Cliente cliente = getCliente(matricula);
        //Busca o livro pela isbn
        String isbn = Console.scanString("ISBN do livro a ser retirado: ");
        Livro livro = getLivro(Integer.parseInt(isbn));
        //Valida se o livro a ser retirado está disponível
       
        RetiradaLivro retirada = new RetiradaLivro();
        retirada.setId(lista.getUltimoId()+1);
        retirada.setLivro(livro);
        retirada.setCliente(cliente);
        retirada.setRetirada(new Date(System.currentTimeMillis()));
        Boolean ok = lista.addRetirada(retirada);
        if(!ok){
            throw new Exception("Erro! Livro não disponível para ser emprestado.");
        }
        System.out.println("Livro "+livro.getNome()+" emprestado para "+cliente.getNome()+", devolução em: "+retirada.getEntregaFormatada());
    }
    
    private Cliente getCliente(String matricula) throws Exception{
        Cliente cliente = this.clientes.buscarCliente(matricula);
        if (cliente == null) {
            throw new Exception("Erro! Cliente não encontrado.");
        }
        System.out.println("Cliente selecionado: "+cliente.getNome());
        return cliente;
    }
    
    private Livro getLivro(int isbn) throws Exception{
        Livro livro = this.livros.buscarLivro(isbn);
        if (livro == null) {
            throw new Exception("Erro! Livro não encontrado.");
        }
        System.out.println("Livro selecionado: "+livro.getNome());
        return livro;
    }

    public void mostrarRetirada() {
        System.out.println("--------------------------------------\n");
        System.out.println(String.format("%-10s", "ID") + "\t"
                + String.format("%-20s", "|LIVRO") + "\t"
                + String.format("%-20s", "|CLIENTE"));
        for (RetiradaLivro retirada : lista.getListaDeRetiradas()) {
            System.out.println(String.format("%-10s", retirada.getId()) + "\t"
                    + String.format("%-20s", "|" + retirada.getLivro().getNome()) + "\t"
                    + String.format("%-20s", "|" + retirada.getCliente().getNome()));
        }
    }
}


