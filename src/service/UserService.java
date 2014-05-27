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

    public User find(long id_user, EntityManager em) {
        return em.find(User.class, id_user);
    }
    
    public User findByName(long id_user, EntityManager em) {
    	List<User> results =  (List<User>)em.createQuery("SELECT u FROM User u WHERE u.ID_user = :value",User.class).setParameter("value", id_user).getResultList();
		return results.get(0);
    }
}
