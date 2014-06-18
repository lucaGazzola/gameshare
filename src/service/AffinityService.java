package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import model.User;
import model.UserAffinity;



public class AffinityService {
	
	public List<User> getUserAffinities(long id_user, EntityManager em) {
		List<User> affinityList = new ArrayList<User>();
    	List<UserAffinity> affinity =  (List<UserAffinity>)em.createQuery("SELECT u FROM UserAffinity u WHERE u.firstUser.ID_user = :value OR u.secondUser.ID_user = :value ORDER BY u.value DESC",UserAffinity.class).setParameter("value", id_user).getResultList();
    	if(!affinity.isEmpty()){
    		for(UserAffinity ua : affinity){
    			if(ua.getFirstUser().getID_user() != id_user){
    				if(ua.getValue() > 3)
    					affinityList.add(ua.getFirstUser());
    			}
    			if(ua.getSecondUser().getID_user() != id_user){
    				if(ua.getValue() > 3)
    					affinityList.add(ua.getSecondUser());
    			}  				
    		}
    	}
    	return affinityList;
	}
}
