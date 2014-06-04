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

    public void remove(long id, EntityManager em) {
        Game g = find(id, em);
        if (g != null) {
            em.remove(g);
        }
    }

    public Game find(long id, EntityManager em) {
        return em.find(Game.class, id);
    }
    
    public List<Game> findAll(EntityManager em){
    	List<Game> results =  (List<Game>)em
    			.createQuery("SELECT g FROM Game g",Game.class)
    			.getResultList();
    	return results;
    }
    
    public Game findByName(String name, EntityManager em) {
    	List<Game> results =  (List<Game>)em.createQuery("SELECT p FROM Game p WHERE p.name = :value",Game.class).setParameter("value", name).getResultList();
		if(!results.isEmpty())
    		return results.get(0);
		else
			return null;
    }
    
    public void removeByName(String name, EntityManager em) {
    	
    	Game g = findByName(name, em);
    	if(g != null){
    		em.remove(g);
    		em.getTransaction().begin();
			em.getTransaction().commit();
    	}
    }

}