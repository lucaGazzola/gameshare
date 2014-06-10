package service;

import java.util.List;

import javax.persistence.EntityManager;

import model.AcceptLock;
import model.Game;
import model.User;

public class AcceptLockService {

	
	public boolean saveLock(User u, Game g, EntityManager em) {
		AcceptLock lock = new AcceptLock(u, g);
		try {
			em.getTransaction().begin();
			em.persist(lock);
			em.getTransaction().commit();
		} catch (Exception e) {
			//em.getTransaction().rollback();
			System.out.println("Errore nel salvataggio, '"+lock.toString()+"'");
			System.out.println(e.getMessage());
			return false;
		}
		System.out.println("OK: '"+lock.toString()+"' salvato correttamente");
		return true;
	}
	
	public AcceptLock findLock(User u, Game g, EntityManager em){
		AcceptLock l = null;
		List<AcceptLock> resultList = (List<AcceptLock>)em.createQuery("SELECT l FROM AcceptLock l WHERE l.game.ID_game = :id_game AND l.user.ID_user = :id_user",AcceptLock.class).setParameter("id_game", g.getID_game()).setParameter("id_user", u.getID_user()).getResultList();
		if(!resultList.isEmpty())
			l = resultList.get(0);
		return l;
	}

}
