/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
import model.Cliente;
import model.DevolucaoLivro;
import model.Livro;
import model.RetiradaLivro;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import repositorio.RepositorioDevolucao;
import repositorio.RepositorioRetirada;

/**
 *
 * @author saulovieira
 */
public class DevolucaoTest {
    
    RepositorioDevolucao repo;
    
    RepositorioRetirada retiradaRepo;
    
    public DevolucaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        retiradaRepo = new RepositorioRetirada();
        repo = new RepositorioDevolucao(retiradaRepo);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testDevolveLivroCorretamente(){
        // setup test     
        RetiradaLivro retirada = new RetiradaLivro();
        Cliente c = new Cliente("1", "Saulo Vieira", "(51)30242428");
        Date date = new Date();
        Livro l = new Livro(123, "Cronicas Gelo e Fogo", "Martin", "Abril", date);
        retirada.setId(1);
        retirada.setCliente(c);
        retirada.setLivro(l);
        retirada.setRetirada(new Date(System.currentTimeMillis()));
        retiradaRepo.addRetirada(retirada);
        DevolucaoLivro devolucao = new DevolucaoLivro();
        assertEquals(true, repo.addDevolucao(1, devolucao));
        
    }
    
    @Test
    public void testAoRetirarLivroNaoDevolvido(){
        RetiradaLivro retirada = new RetiradaLivro();
        Cliente c = new Cliente("1", "Saulo Vieira", "(51)30242428");
        Date date = new Date();
        Livro l = new Livro(123, "Cronicas Gelo e Fogo", "Martin", "Abril", date);
        retirada.setId(1);
        retirada.setCliente(c);
        retirada.setLivro(l);
        retirada.setRetirada(new Date(System.currentTimeMillis()));
        retiradaRepo.addRetirada(retirada);
        DevolucaoLivro devolucao = new DevolucaoLivro();
        assertEquals(true, repo.addDevolucao(1, devolucao));
    }
    
    
    
    @Test
    public void testFalhaAoDevolverLivroDuasVezes(){
        RetiradaLivro retirada = new RetiradaLivro();
        Cliente c = new Cliente("1", "Saulo Vieira", "(51)30242428");
        Date date = new Date();
        Livro l = new Livro(123, "Cronicas Gelo e Fogo", "Martin", "Abril", date);
        retirada.setId(1);
        retirada.setCliente(c);
        retirada.setLivro(l);
        retirada.setRetirada(new Date(System.currentTimeMillis()));
        retiradaRepo.addRetirada(retirada);
        DevolucaoLivro devolucao = new DevolucaoLivro();
        assertEquals(true, repo.addDevolucao(1, devolucao));
        assertEquals(false, repo.addDevolucao(1, devolucao));
    }
    
    @Test
    public void testGetDiasEmAtrasoCorretamente(){
        RetiradaLivro retirada = new RetiradaLivro();
        Cliente c = new Cliente("1", "Saulo Vieira", "(51)30242428");
        Date date = new Date();
        Livro l = new Livro(123, "Cronicas Gelo e Fogo", "Martin", "Abril", date);
        retirada.setId(1);
        retirada.setCliente(c);
        retirada.setLivro(l);
        retirada.setRetirada(new Date(System.currentTimeMillis()));
        retiradaRepo.addRetirada(retirada);
        DevolucaoLivro devolucao = new DevolucaoLivro();
        repo.addDevolucao(1, devolucao);
       
        assertEquals(0, devolucao.getAtraso());
        
    }
}
