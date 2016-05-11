/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Comparator;
import model.Cliente;
import model.Livro;

class MyComparator implements Comparator<Livro> {

    @Override
    public int compare(Livro o1, Livro o2) {
        if (o1.getRetiradas() > o2.getRetiradas()) {
            return -1;
        } else if (o1.getRetiradas() < o2.getRetiradas()) {
            return 1;
        }
        return 0;
    }
    
    
    
}


class MyComparatorCliente implements Comparator<Cliente> {
    
    @Override
    public int compare(Cliente o1, Cliente o2) {
        if (o1.getRetiradas() > o2.getRetiradas()) {
            return -1;
        } else if (o1.getRetiradas() < o2.getRetiradas()) {
            return 1;
        }
        return 0;
    }
}

class MyComparatorClienteAtraso implements Comparator<Cliente> {
    
    @Override
    public int compare(Cliente o1, Cliente o2) {
        if (o1.getAtrasos() > o2.getAtrasos()) {
            return -1;
        } else if (o1.getAtrasos() < o2.getAtrasos()) {
            return 1;
        }
        return 0;
    }
}