package util;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import model.Like;
import model.NormalUser;
import model.UserAffinity;



public class AffinityCalculator {
	
	public void calculateAffinities(){
		
		EntityManager em = EntityManagerUtil.getEntityManager();
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
		int value=0, i=0, j=0;
		
		List<NormalUser> results1 = (List<NormalUser>)em.createQuery("SELECT p FROM NormalUser p").getResultList();
		List<NormalUser> results2 = (List<NormalUser>)em.createQuery("SELECT p FROM NormalUser p").getResultList();
		NormalUser[] resultsArray1 = results1.toArray(new NormalUser[results1.size()]);
		NormalUser[] resultsArray2 = results2.toArray(new NormalUser[results2.size()]);
		for(i = 0 ; i<resultsArray1.length ; i++){
			for(j = i+1 ; j<resultsArray2.length ; j++){
				value = 0;
				NormalUser source = resultsArray1[i];
				NormalUser target = resultsArray2[j];
				if(source.getResidence().equals(target.getResidence()))
					value = value + 4;
				calendar1.setTime(source.getBirthdate());
				calendar2.setTime(target.getBirthdate());
				if((calendar1.get(Calendar.YEAR) - calendar2.get(Calendar.YEAR)) < 5)
					value = value + 2;
				ArrayList<String> GameListSource = new ArrayList<String>();
				ArrayList<String> GameListTarget = new ArrayList<String>();
				List<Like> likeSource = (List<Like>)em.createQuery("SELECT l FROM Like l WHERE l.user.ID_user = :id_user",Like.class).setParameter("id_user", source.getID_user()).getResultList();
				List<Like> likeTarget = (List<Like>)em.createQuery("SELECT l FROM Like l WHERE l.user.ID_user = :id_user",Like.class).setParameter("id_user", target.getID_user()).getResultList();

				for(Like l : likeSource){
					GameListSource.add(l.getGame().getName());
				}
				for(Like l : likeTarget){
					GameListTarget.add(l.getGame().getName());
				}
				for(String gameName : GameListSource){
					for(String check : GameListTarget){
						System.out.println(gameName+" "+check);
						if(gameName.equals(check)){
							value = value + 1;
							System.out.println("game match! "+gameName+" "+check);
						}
					}
				}
				UserAffinity ua = new UserAffinity(source,target,value);
				em.getTransaction().begin();
				em.persist(ua);
				em.getTransaction().commit();
			}
		}
		
		
		EntityManagerUtil.closeEntityManager(em);
		System.out.println("*********** END CALCULATE AFFINITIES ***********");
	}
}