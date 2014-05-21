package service;

import java.util.List;

import javax.persistence.*;

import model.*;

public class GameService{
	    

    public void save(Game g, EntityManager em) {
			em.persist(g);
			em.getTransaction().begin();
			em.getTransaction().commit();
    }

    public void remove(int id, EntityManager em) {
        Game g = find(id, em);
        if (g != null) {
            em.remove(g);
        }
    }

    public Game find(int id, EntityManager em) {
        return em.find(Game.class, id);
    }
    
    public Game findByName(String name, EntityManager em) {
    	List<Game> results =  (List<Game>)em.createQuery("SELECT p FROM Game p WHERE p.name = :value",Game.class).setParameter("value", name).getResultList();
		return results.get(0);
    }
    
    public void removeByName(String name, EntityManager em) {
    	Game g = findByName(name, em);
    	em.remove(g);
    }

}