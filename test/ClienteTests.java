/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import repositorio.RepositorioClientes;

/**
 *
 * @author saulovieira
 */
public class ClienteTests {
    
    private RepositorioClientes repo;
    
    public ClienteTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         repo = new RepositorioClientes();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testAdicionaClienteCorretamente(){
        Cliente c = new Cliente("1", "Saulo Vieira", "(51)30242428");
        repo.addClientes(c);
        assertEquals(1, repo.getListaClientes().size());
    }
    
   
}
