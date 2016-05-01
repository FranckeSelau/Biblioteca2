package view;

import model.Livro;
import repositorio.RepositorioLivros;
import java.util.Date;
import util.Console;
import util.DateUtil;
import view.menu.LivroMenu;
import java.text.ParseException;
import java.util.InputMismatchException;

/**
 * Classe para Menu de Livros - Interface com o Usuário
 *
 * @author Francke
 * @since JDK 1.0
 */
public class LivroUI {

    /**
    * Lista novos Livros.
    */
    private RepositorioLivros listaLivros;
    
    /**
     * Construtor para inicializar lista menu livros
     *
     * @param lista de livros.
     */
    public LivroUI(RepositorioLivros lista) {
        this.listaLivros = lista;
    }

    /**
     * Executa as opções do Menu Livros.
     *
     */
    public void executar() {
        int opcao = 0;
        do {
            System.out.println(LivroMenu.getOpcoes());
            try{
                 opcao = Console.scanInt("Digite sua opção: ");
            }catch (InputMismatchException e) {
                  opcao = -1;
            }
           
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

    /**
     * Cadastra novo Livro.
     *
     * @param isbn, recebe o ISBN de um novo livro.
     * @param nome, recebe o nome de um novo livro.
     * @param autor, recebe o autor de um novo livro.
     * @param editora, recebe a editora de um novo livro.
     * @param ano, recebe o ano de um novo livro.
     */
    private void cadastrarLivros() {
        try {
            int isbn = Console.scanInt("ISBN: ");
            if (listaLivros.buscarLivro(isbn) != null) {
                System.err.println("ERRO! Cód ISBN " + isbn + " já existente no cadastro");
            } else {
                String nome = Console.scanString("Nome: ");
                String autor = Console.scanString("Autor(es): ");
                String editora = Console.scanString("Editora: ");
                String anoString = Console.scanString("Ano Publicação: ");
                Date ano;

                ano = DateUtil.stringToYear(anoString);
                listaLivros.addLivros(new Livro(isbn, nome, autor, editora, ano));
                System.out.println("Livro " + nome + " cadastrado com sucesso!");

            }
        } catch (InputMismatchException e) {
            System.err.println("ERRO! O ISBN deve ser numérico!");
        } catch (ParseException e) {
            System.err.println("ERRO! Ano no formato inválido!");
        }
    }

    /**
     * Mostra novo livro.
     *
     * imprime os livros formatados em Strings
     */
    public void mostrarLivros() {
        System.out.println("--------------------------------------\n");
        System.out.println(String.format("%-10s", "ISBN") + "\t"
                + String.format("%-20s", "|NOME") + "\t"
                + String.format("%-20s", "|AUTOR") + "\t"
                + String.format("%-20s", "|EDITORA") + "\t"
                + String.format("%-5s", "|ANO"));
        for (Livro livro : listaLivros.getListaLivros()) {
            System.out.println(String.format("%-10s", livro.getIsbn()) + "\t"
                    + String.format("%-20s", "|" + livro.getNome()) + "\t"
                    + String.format("%-20s", "|" + livro.getAutor()) + "\t"
                    + String.format("%-20s", "|" + livro.getEditora()) + "\t"
                    + String.format("%-5s", "|" + DateUtil.yearToString(livro.getAno()))); // converte ano data em String
        }
    }
}
