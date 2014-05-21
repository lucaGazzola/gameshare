package service;

import java.util.List;

import javax.persistence.EntityManager;

import model.Like;

public class LikeService {
	
	public boolean saveLike(Like entity, EntityManager em) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			//em.getTransaction().rollback();
			System.out.println("Errore nel salvataggio, '"+entity.toString()+"'");
			System.out.println(e.getMessage());
			return false;
		}
		System.out.println("OK: '"+entity.toString()+"' salvato correttamente");
		return true;
	}
	
	public boolean deleteLike(Like entity, EntityManager em) {
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			//em.getTransaction().rollback();
			System.out.println("Errore nel delete, '"+entity.toString()+"'");
			System.out.println(e.getMessage());
			return false;
		}
		System.out.println("OK: '"+entity.toString()+"' cancellato correttamente");
		return true;
	}
	
	public boolean updateLike(Like updateEntity, EntityManager em) {
		try {
			em.getTransaction().begin();
			em.merge(updateEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			//em.getTransaction().rollback();
			System.out.println("Errore nell'update, '"+updateEntity.toString()+"'");
			System.out.println(e.getMessage());
			return false;
		}
		System.out.println("OK: '"+updateEntity.toString()+"' aggiornato correttamente");
		return true;
	}

	public Like findLikeID_game(long id_game, EntityManager em){
		return em.find(Like.class, id_game);
	}
	
	public Like findLikeID_user(long id_user, EntityManager em){
		return em.find(Like.class, id_user);
	}
	
	@SuppressWarnings("unchecked")
	public List<Like> findAll(EntityManager em){
		return (List<Like>)em.createQuery("SELECT l FROM Like l").getResultList();
	}
}
