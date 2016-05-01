package view;

import java.util.InputMismatchException;
import model.DevolucaoLivro;
import repositorio.RepositorioDevolucao;
import repositorio.RepositorioRetirada;
import util.Console;
import view.menu.DevolucaoMenu;

/**
 * Classe para Menu Retirada de Livros - Interface com o Usuário
 *
 * @author Francke
 * @since JDK 1.0
 */
public class DevolucaoUI {
    
    private RepositorioRetirada listaRetiradas;
    private RepositorioDevolucao listaDevolucoes;
    
    /**
     * Construtor para inicializar Menu Retirada de Livros
     *
     * @param listaRetiradas de clientes e livros.
     * @param listaDevolucoes de clientes e livros.
     */
    public DevolucaoUI(RepositorioRetirada listaRetiradas, RepositorioDevolucao listaDevolucoes){
        this.listaDevolucoes = listaDevolucoes;
        this.listaRetiradas = listaRetiradas;
    }
    
    /**
     * Executa as opções do Menu devolução de Livros.
     *
     */
    public void executar() {
        int opcao = 0;
        do {
            System.out.println(DevolucaoMenu.getOpcoes());
            try{
                 opcao = Console.scanInt("Digite sua opção: ");
            }catch (InputMismatchException e) {
                   opcao = -1;
            }
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
    
    /**
     * Cadastra nova devolução de Livro.
     */
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
