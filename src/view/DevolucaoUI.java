/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.DevolucaoLivro;
import repositorio.RepositorioDevolucao;
import repositorio.RepositorioRetirada;
import util.Console;
import view.menu.DevolucaoMenu;

/**
 *
 * @author Francke
 */
public class DevolucaoUI {
    
    private RepositorioRetirada listaRetiradas;
    private RepositorioDevolucao listaDevolucoes;
    
    public DevolucaoUI(RepositorioRetirada listaRetiradas, RepositorioDevolucao listaDevolucoes){
        this.listaDevolucoes = listaDevolucoes;
        this.listaRetiradas = listaRetiradas;
    }
    
    public void executar() {
        int opcao = 0;
        do {
            System.out.println(DevolucaoMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção: ");
            try {
                switch (opcao) {
                    case DevolucaoMenu.OP_RETIRADA:
                        devolverLivro();
                        break;
                    
                    case DevolucaoMenu.OP_VOLTAR:
                        System.out.println("Retornando ao menu principal..");
                        break;
                    default:
                        System.err.println("ERRO! Digite uma opção válida!!");

                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (opcao != DevolucaoMenu.OP_VOLTAR);
    }
    
    private void devolverLivro() throws Exception {
         //Busca o cliente pela matrícula
        Integer idRetirada = Integer.parseInt(Console.scanString("Informe o identificador da retirada: "));
        if(listaDevolucoes.addDevolucao(idRetirada, new DevolucaoLivro())){
            System.out.println("Livro devolvido com sucesso!");
        }else{
            throw new Exception("Livro não encontrado ou já devolvido.");
        }
            
    }
}
