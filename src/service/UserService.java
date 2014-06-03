package service;

import java.util.List;

import javax.persistence.EntityManager;

import model.User;

public class UserService {

    public void save(User u, EntityManager em) {
			em.persist(u);
			em.getTransaction().begin();
			em.getTransaction().commit();
    }

    public void remove(long id, EntityManager em) {
        User u = find(id, em);
        if (u != null) {
            em.remove(u);
        }
    }
    
    public void removeByEmail(String email, EntityManager em) {
        User u = findByEmail(email, em);
        if (u != null) {
            em.remove(u);
            em.getTransaction().begin();
			em.getTransaction().commit();
        }
    }

    public User find(long id_user, EntityManager em) {
        return em.find(User.class, id_user);
    }
    
    public User findByEmail(String email, EntityManager em) {
    	List<User> results =  (List<User>)em.createQuery("SELECT u FROM User u WHERE u.email = :value",User.class).setParameter("value", email).getResultList();
		if(!results.isEmpty())
			return results.get(0);
		else
			return null;
    }
}
