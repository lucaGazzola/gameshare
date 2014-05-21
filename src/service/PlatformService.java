package service;

import java.util.List;

import javax.persistence.EntityManager;

import model.*;

public class PlatformService{
	 
	public List<Platform> getAll(EntityManager em){
    	return (List<Platform>)em.createQuery("SELECT p FROM Game p",Platform.class).getResultList();
	}
	
}