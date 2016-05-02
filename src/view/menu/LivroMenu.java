
package view.menu;

/**
 * Classe para interação Menu de Livros
 *
 * @author Francke
 * @since JDK 1.0
 */
public class LivroMenu {
    public static final int OP_CADASTRAR = 1;
    public static final int OP_LISTAR = 2;
    public static final int OP_VOLTAR = 0;

    /**
     * Retorna as opções do Menu Livro.
     *
     * @return opções para o menu cadastro Livros
     */
    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1 - Cadastrar Livros\n"
                + "2 - Listar Livros\n"
                + "0 - Voltar"
                + "\n--------------------------------------");
    }    
}
