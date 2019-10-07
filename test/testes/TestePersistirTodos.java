package testes;

import jpa.EntityManagerUtil;
import modelo.Locatorio;
import modelo.Pessoa;
import java.util.Calendar;
import javax.persistence.EntityManager;
import modelo.Aluguel;
import modelo.Condominio;
import modelo.Mensalidades;
import modelo.Recurso;
import modelo.UnidadeCondominial;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class TestePersistirTodos {

    public TestePersistirTodos() {
    }
    
    
    @Test
    public void teste(){
       
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Pessoa pe = new Pessoa();
        pe.setNome("Maria");
        pe.setCpf("532.089.750-23");
        pe.setTelefone("(54)98734-0987");
        pe.setEmail("tiago@yahoo.com.br");     
        em.getTransaction().begin();
        em.persist(pe);
        em.getTransaction().commit();
        
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
        
        
        Condominio c = new Condominio();
        c.setNome("Condominio 1");
        c.setEndereco("aaaaaaaaaa");
        c.setNumero("1050");
        c.setCep("99852-698");
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        
        Recurso r = new Recurso();
        r.setDescricao("Recurso 1");
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        
        UnidadeCondominial p = new UnidadeCondominial();
        p.setNumero("1");
        p.setDescricao("Unidade 1");
        p.setCondominio(c);
        p.setPessoa(pe);
        p.setArea(100.2);
        p.setNumero_quarto(1);
         em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();  
      
            Aluguel us = new Aluguel();
            us.setValor(600.00);
            us.setInicioContrato(Calendar.getInstance());
            us.setFimContrato(Calendar.getInstance());
            us.setDiaVencimento(5);
            us.setUnidadeCondominial(p);
            us.setLocatorio(en);
            em.getTransaction().begin();
            em.persist(us);
            em.getTransaction().commit();
     
        Mensalidades m = new Mensalidades();
        m.setValor(600.00);
        m.setVencimento(Calendar.getInstance());
        m.setValorPagamento(500.94);
        m.setDataPagamento(Calendar.getInstance());
        m.setAluguel(us);
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();

        
    }

}