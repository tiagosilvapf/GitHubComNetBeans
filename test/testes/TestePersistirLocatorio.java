package testes;

import jpa.EntityManagerUtil;
import javax.persistence.EntityManager;
import modelo.Locatorio;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */

public class TestePersistirLocatorio {

    public TestePersistirLocatorio() {
    }
    
    @Test
    public void teste(){
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Locatorio en = new Locatorio();
        en.setRenda(100.20);
        en.setLocalTrabalho("local 1");
        en.setTelefone_trabalho("3313-1466");
        en.setNome("Local 1");
        en.setTelefone("(54)98734-0987");
        en.setEmail("tiago@yahoo.com.br");   
        en.setCpf("532.089.750-23");
        em.getTransaction().begin();
        em.persist(en); 
        em.getTransaction().commit();
    }

}