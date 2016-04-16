
package view;

import model.Livro;
import repositorio.RepositorioLivros;
import util.Console;
import view.menu.LivroMenu;

/**
 *
 * @author Francke
 */
public class LivroUI {
    private RepositorioLivros listaLivros;

    public LivroUI(RepositorioLivros lista) {
        this.listaLivros = lista;
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(LivroMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção: ");
            switch (opcao) {
                case LivroMenu.OP_CADASTRAR:
                    cadastrarLivros();
                    break;
                case LivroMenu.OP_LISTAR:
                    mostrarLivros();
                    break;
                case LivroMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.err.println("ERRO! Digite uma opção válida!!");

            }
        } while (opcao != LivroMenu.OP_VOLTAR);
    }

    private void cadastrarLivros() {
        String isbn = Console.scanString("ISBN: ");
        if (listaLivros.buscarLivro(isbn)!=null) {
            System.err.println("ERRO! Cód ISBN " + isbn + " já existente no cadastro");
        } else {
            String nome = Console.scanString("Nome: ");
            String descricao = Console.scanString("Descrição: ");
            listaLivros.addLivros(new Livro(isbn, nome, descricao));
            System.out.println("Livro " + nome + " cadastrado com sucesso!");
        }
    }

    public void mostrarLivros() {
        System.out.println("--------------------------------------\n");
        System.out.println(String.format("%-10s", "ISBN") + "\t"
                + String.format("%-20s", "|NOME") + "\t"
                + String.format("%-20s", "|DESCRIÇÃO"));
        for (Livro livro : listaLivros.getListaLivros()) {
            System.out.println(String.format("%-10s", livro.getIsbn()) + "\t"
                    + String.format("%-20s", "|" + livro.getNome()) + "\t"
                    + String.format("%-20s", "|" + livro.getDescricao()));
        }
    }    
}
