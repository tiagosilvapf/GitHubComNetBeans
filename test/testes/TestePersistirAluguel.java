package testes;

import java.util.Calendar;
import jpa.EntityManagerUtil;
import javax.persistence.EntityManager;
import modelo.Aluguel;
import modelo.Condominio;
import modelo.Locatorio;
import modelo.UnidadeCondominial;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class TestePersistirAluguel {

    public TestePersistirAluguel() {
    }
    
    @Test
    public void teste(){
        EntityManager em = EntityManagerUtil.getEntityManager();
    
 
            Aluguel us = new Aluguel();
            us.setValor(600.00);
            us.setInicioContrato(Calendar.getInstance());
            us.setFimContrato(Calendar.getInstance());
            us.setDiaVencimento(5);
            us.setLocatorio(em.find(Locatorio.class, 10));
            us.setUnidadeCondominial(em.find(UnidadeCondominial.class, 10));
            em.getTransaction().begin();
            em.persist(us);
            em.getTransaction().commit();
    }

}