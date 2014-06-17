package util;


import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import model.Like;
import model.NormalUser;
import model.User;



public class AffinityCalculator {
	
	public void calculateAffinities(){
		
		EntityManager em = EntityManagerUtil.getEntityManager();
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
		int value = 0;
		
		List<NormalUser> results = (List<NormalUser>)em.createQuery("SELECT p FROM NormalUser p").getResultList();
		for(NormalUser source : results){
			List<NormalUser> innerResults = (List<NormalUser>)em.createQuery("SELECT p FROM NormalUser p").getResultList();
			for(NormalUser target : innerResults){
				if(source.getResidence().equals(target.getResidence()))
					value = value + 4;
				calendar1.setTime(source.getBirthdate());
				calendar2.setTime(target.getBirthdate());
				if((calendar1.get(Calendar.YEAR) - calendar2.get(Calendar.YEAR)) < 5)
					value = value + 2;
				for(Like l : source.getLikes()){
					
				}
			}
		}
		
		EntityManagerUtil.closeEntityManager(em);
		System.out.println("*********** END CALCULATE AFFINITIES ***********");
	}
}