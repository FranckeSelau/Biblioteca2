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
        Date date = new Date();
        Livro l = new Livro(123, "Cronicas Gelo e Fogo", "Martin", "Abril", date);
        retirada.setCliente(c);
        retirada.setLivro(l);
        retirada.setRetirada(new Date(System.currentTimeMillis()));
        
        assertEquals(true, repo.addRetirada(retirada));
        assertEquals(false, repo.addRetirada(retirada));
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
        retirada.setId(1);
        retirada.setCliente(c);
        retirada.setLivro(l);
        retirada.setRetirada(new Date(System.currentTimeMillis()));
        
        assertEquals(true, repo.addRetirada(retirada));
        assertEquals(retirada, repo.getRetiradaById(1));
    }
}
