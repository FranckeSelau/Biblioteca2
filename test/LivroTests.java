/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
import model.Livro;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import repositorio.RepositorioLivros;

/**
 *
 * @author saulovieira
 */
public class LivroTests {
    
    private RepositorioLivros repo;
    
    public LivroTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        repo = new RepositorioLivros();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
   @Test
   public void testAdicionaLivroCorretamente(){
       Date date = new Date();
       Livro l = new Livro(123, "Cronicas Gelo e Fogo", "Martin", "Abril", date);
       repo.addLivros(l);
       assertEquals(l, repo.buscarLivro(123));
   }
}
