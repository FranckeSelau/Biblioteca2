package view.menu;

public class RetiradaMenu {
    public static final int OP_RETIRADA = 1;
    public static final int OP_LISTAR = 2;
    public static final int OP_VOLTAR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1 - Registrar Retirada\n"
                + "2 - Listar Retiradas\n"
                + "0 - Voltar"
                + "\n--------------------------------------");
    }        
}
