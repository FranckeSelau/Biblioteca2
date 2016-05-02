package view.menu;

/**
 * Classe para interação Menu de Clientes
 *
 * @author Francke
 * @since JDK 1.0
 */
public class ClienteMenu {
    public static final int OP_CADASTRAR = 1;
    public static final int OP_LISTAR = 2;
    public static final int OP_VOLTAR = 0;

    /**
     * Retorna as opções do Menu Cliente.
     *
     * @return opções para o menu cadastro clientes
     */
    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1 - Cadastrar Clientes\n"
                + "2 - Listar Clientes\n"
                + "0 - Voltar"
                + "\n--------------------------------------");
    }    
}
