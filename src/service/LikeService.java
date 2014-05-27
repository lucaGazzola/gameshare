package service;

import java.util.List;

import javax.persistence.EntityManager;

import model.Like;

public class LikeService {
	
	
	public boolean savePlay(Like entity, EntityManager em) {
		try {
			em.getTransaction().begin();
			
			//controllo se l'utente non abbia già messo like al gioco (getSingleResult ritorna eccezione)
			List<Like> resultList = (List<Like>)em.createQuery(
				      "SELECT l FROM Like l WHERE l.game.ID_game = :id_game AND l.user.ID_user = :id_user",
				      Like.class)
				      .setParameter("id_game", entity.getGame().getID_game())
				      .setParameter("id_user", entity.getUser().getID_user())
				      .getResultList();
			
			if(resultList.isEmpty()){
				em.persist(entity);
			}
			else{
				//si suppone che la lista sia vuota, o con size==1
				long id = resultList.get(0).getID_like();
				Like like = (Like)em.find(Like.class, id);
				like.setPlay(true);
				em.merge(like);
			}
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
