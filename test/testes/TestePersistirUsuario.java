package testes;

import java.util.Calendar;
import jpa.EntityManagerUtil;
import javax.persistence.EntityManager;
import modelo.Aluguel;
import modelo.Condominio;
import modelo.Locatario;
import modelo.UnidadeCondominial;
import modelo.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class TestePersistirUsuario {

    public TestePersistirUsuario() {
    }
    
    @Test
    public void teste(){
        EntityManager em = EntityManagerUtil.getEntityManager();
    
 
            Usuario us = new Usuario();
            us.setNomeUsuario("Tiago");
            us.setAtivo(Boolean.TRUE);
            us.setSenha("123456");
            em.getTransaction().begin();
            em.persist(us);
            em.getTransaction().commit();
    }

}