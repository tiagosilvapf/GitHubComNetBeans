package testes;

import jpa.EntityManagerUtil;
import javax.persistence.EntityManager;
import modelo.Condominio;
import modelo.Pessoa;
import modelo.UnidadeCondominial;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class TestePersistirUnidadeCondominial {

    public TestePersistirUnidadeCondominial() {
    }
    
    @Test
    public void teste(){
        EntityManager em = EntityManagerUtil.getEntityManager();
        UnidadeCondominial p = new UnidadeCondominial();
     
        p.setNumero("1");
        p.setDescricao("Unidade 1");
        p.setCondominio(em.find(Condominio.class, 1));
        p.setPessoa(em.find(Pessoa.class, 1));
        p.setArea(100.2);
        p.setNumero_quarto(1);
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();  
    }

}