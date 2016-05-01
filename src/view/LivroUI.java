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
