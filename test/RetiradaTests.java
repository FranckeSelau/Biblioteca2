/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
import model.Cliente;
import model.Livro;
import model.RetiradaLivro;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import repositorio.RepositorioRetirada;

/**
 *
 * @author saulovieira
 */
public class RetiradaTests {

    RepositorioRetirada repo;

    public RetiradaTests() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        repo = new RepositorioRetirada();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRetiraLivroCorretamente() {
        RetiradaLivro retirada = new RetiradaLivro();
        Cliente c = new Cliente("1", "Saulo Vieira", "(51)30242428");
        Cliente c2 = new Cliente("2", "Francke", "(51)30242428");
        Date date = new Date();
        Livro l = new Livro(123, "Cronicas Gelo e Fogo", "Martin", "Abril", date);
        retirada.setCliente(c);
        retirada.setLivro(l);
        retirada.setRetirada(date);
        
        RetiradaLivro retirada2 = new RetiradaLivro();
        retirada2.setCliente(c2);
        retirada2.setLivro(l);
        retirada2.setRetirada(date);
        //Verifica primeira retirada
        assertEquals(true, repo.addRetirada(retirada));
        //Verifica mesmo usuario retirando mesmo livro
        assertEquals(false, repo.addRetirada(retirada));
        //Verifica 
        assertEquals(false, repo.addRetirada(retirada2));
    }
    
    @Test
    public void testRetiradaESetaCorretamenteId(){
        RetiradaLivro retirada = new RetiradaLivro();
        RetiradaLivro retirada2 = new RetiradaLivro();
        Cliente c = new Cliente("1", "Saulo Vieira", "(51)30242428");
        Date date = new Date();
        Livro l = new Livro(123, "Cronicas Gelo e Fogo", "Martin", "Abril", date);
        Livro l2 = new Livro(124, "Cronicas Gelo e Fogo II", "Martin", "Abril", date);
        retirada.setCliente(c);
        retirada.setLivro(l);
        retirada.setRetirada(new Date(System.currentTimeMillis()));
        
        retirada2.setCliente(c);
        retirada2.setLivro(l2);
        retirada2.setRetirada(new Date(System.currentTimeMillis()));
        
        assertEquals(true, repo.addRetirada(retirada));
        assertEquals(true, repo.addRetirada(retirada2));
        assertEquals(1, retirada.getId());
        assertEquals(2, retirada2.getId());
    }
    
    @Test
    public void testGetRetiradaById(){
        RetiradaLivro retirada = new RetiradaLivro();
        Cliente c = new Cliente("1", "Saulo Vieira", "(51)30242428");
        Date date = new Date();
        Livro l = new Livro(123, "Cronicas Gelo e Fogo", "Martin", "Abril", date);
       
        retirada.setCliente(c);
        retirada.setLivro(l);
        retirada.setRetirada(new Date(System.currentTimeMillis()));
        
        assertEquals(true, repo.addRetirada(retirada));
        assertEquals(retirada, repo.getRetiradaById(1));
    }
    
    @Test
    public void testNaoPermiteRetiradaDeMaisDe3Livros(){
        RetiradaLivro retirada = new RetiradaLivro();
        RetiradaLivro retirada2 = new RetiradaLivro();
        RetiradaLivro retirada3 = new RetiradaLivro();
        RetiradaLivro retirada4 = new RetiradaLivro();
        Cliente c = new Cliente("1", "Saulo Vieira", "(51)30242428");
        Date date = new Date();
        Livro l = new Livro(123, "Cronicas Gelo e Fogo", "Martin", "Abril", date);
        Livro l2 = new Livro(124, "Cronicas Gelo e Fogo II", "Martin", "Abril", date);
        Livro l3 = new Livro(125, "Cronicas Gelo e Fogo III", "Martin", "Abril", date);
        Livro l4 = new Livro(126, "Cronicas Gelo e Fogo IV", "Martin", "Abril", date);
        
    
        retirada.setCliente(c);
        retirada.setLivro(l);
        retirada.setRetirada(new Date(System.currentTimeMillis()));
        
  
        retirada2.setCliente(c);
        retirada2.setLivro(l2);
        retirada2.setRetirada(new Date(System.currentTimeMillis()));
        
        
        retirada3.setCliente(c);
        retirada3.setLivro(l3);
        retirada3.setRetirada(new Date(System.currentTimeMillis()));
        
        
        retirada4.setCliente(c);
        retirada4.setLivro(l4);
        retirada4.setRetirada(new Date(System.currentTimeMillis()));
        
        assertEquals(true, repo.addRetirada(retirada));
        assertEquals(true, repo.addRetirada(retirada2));
        assertEquals(true, repo.addRetirada(retirada3));
        assertEquals(false, repo.addRetirada(retirada4));
    }
}
