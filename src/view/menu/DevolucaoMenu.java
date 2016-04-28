/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menu;

/**
 *
 * @author Francke
 */
public class DevolucaoMenu {
    
    public static final int OP_RETIRADA = 1;
    public static final int OP_VOLTAR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1 - Registrar Devolução\n"
                + "0 - Voltar"
                + "\n--------------------------------------");
    }      
}
