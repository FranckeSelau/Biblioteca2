package view.menu;

/**
 * Classe para interação Menu Devolução Livros
 *
 * @author Francke
 * @since JDK 1.0
 */
public class DevolucaoMenu {
    
    public static final int OP_DEVOLUCAO = 1;
    public static final int OP_VOLTAR = 0;

    /**
     * Retorna as opções do Menu Devolução Livros.
     *
     * @return opções para o menu Devolução
     */
    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1 - Registrar Devolução\n"
                + "0 - Voltar"
                + "\n--------------------------------------");
    }      
}
