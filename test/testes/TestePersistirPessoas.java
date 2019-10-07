package testes;

import jpa.EntityManagerUtil;
import modelo.Pessoa;
import javax.persistence.EntityManager;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */

public class TestePersistirPessoas {

    public TestePersistirPessoas() {
    }
    
    @Test
    public void teste(){
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Pessoa pe = new Pessoa();
        pe.setNome("Tiago");
        pe.setCpf("532.089.750-23");
        pe.setTelefone("(54)98734-0987");
        pe.setEmail("tiago@yahoo.com.br");     
        em.getTransaction().begin();
        em.persist(pe);
        em.getTransaction().commit();
    }

}