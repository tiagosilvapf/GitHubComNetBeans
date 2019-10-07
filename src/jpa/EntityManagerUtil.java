package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author Tiago
 */
public class EntityManagerUtil {
    
    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;
    
    public static EntityManager getEntityManager(){
        if (emf == null){
            emf = Persistence.createEntityManagerFactory("DAW_2019_Trabalho_Tiago");
        }
        if (em == null){
            em = emf.createEntityManager();
        }
        return em;
    }
}
