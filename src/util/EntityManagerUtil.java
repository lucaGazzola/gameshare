package util;

import javax.persistence.*;

public class EntityManagerUtil {
	static EntityManagerFactory factory;

	private static final String persistenceUnitName="gameshareExample";
	
	public static EntityManager getEntityManager(){
		factory = Persistence.createEntityManagerFactory(persistenceUnitName);
		return factory.createEntityManager();
	}
	
	/*
	
	public void closeEntityManager(EntityManager em) {
		em.close();
		factory.close();
	}
	
	*/
}