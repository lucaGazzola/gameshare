package service;

import java.util.List;

import javax.persistence.EntityManager;

import model.*;

public class PlatformService{
	 
	public List<Platform> getAll(EntityManager em){
    	return (List<Platform>)em.createQuery("SELECT p FROM Platform p",Platform.class).getResultList();
	}
	
	public Platform findByName(String name, EntityManager em) {
    	List<Platform> results =  (List<Platform>)em.createQuery("SELECT p FROM Platform p WHERE p.name = :value",Platform.class).setParameter("value", name).getResultList();
		if(!results.isEmpty())
			return results.get(0);
		else
			return null;
    }
    
    public void removeByName(String name, EntityManager em) {
    	Platform g = findByName(name, em);
    	em.remove(g);
    }
	
}