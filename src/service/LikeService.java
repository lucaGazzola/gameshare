package service;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import model.Game;
import model.Like;

public class LikeService {
	
	
	public void saveVote(long id_game,long id_user,int score, EntityManager em){
		Like l;
		em.getTransaction().begin();
		
		try{
			List<Like> resultList = (List<Like>)em.createQuery(
				      "SELECT l FROM Like l WHERE l.game.ID_game = :id_game AND l.user.ID_user = :id_user",
				      Like.class)
				      .setParameter("id_game", id_game)
				      .setParameter("id_user", id_user)
				      .getResultList();
			l = resultList.get(0);
			
			boolean newVote = false;
			if(l.getScore()==-1) newVote=true;
			
			l.setScore(score);
			
			//inizio aggiornamento average score
			List<Like> likeList = (List<Like>)em.createQuery("SELECT l FROM Like l WHERE l.game.ID_game = :id_game",Like.class)
					.setParameter("id_game", id_game)
					.getResultList();
			
			Game game = em.createQuery("SELECT g FROM Game g WHERE g.ID_game = :id_game", Game.class)
					.setParameter("id_game", id_game)
					.getSingleResult();
			
			//inizio calcolo avgscore -----------------------------------
			int cummScore = 0;
			Iterator<Like> it = likeList.iterator();
			
			while(it.hasNext()){
				Like tempLike = it.next();
				if(!(!newVote && tempLike.getUser().getID_user() == id_user))
					cummScore =+ tempLike.getScore();
			}
			
			float avgScore = 0;
			if(newVote)
				avgScore = (cummScore+score)/(likeList.size()+1);
			else
				avgScore = (cummScore+score)/likeList.size();
			//fine calcolo avgscore -----------------------------------
			
			l.getGame().setAvgScore(avgScore);
			game.setAvgScore(avgScore);
			em.merge(game);
			//fine aggiornamento average score ---------------------
			
			
			

			
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			System.out.println("Errore nel salvataggio del voto: "+e.getMessage());
		}
	}
	
	// ritorno true se ho creato una nuova entity, false se ho fatto solo l'update
	public boolean savePlay(Like entity, EntityManager em) {
		boolean newEntity = false;
		try {
			em.getTransaction().begin();
			
			//controllo se l'utente non abbia gia'  messo like al gioco (getSingleResult ritorna eccezione)
			List<Like> resultList = (List<Like>)em.createQuery(
				      "SELECT l FROM Like l WHERE l.game.ID_game = :id_game AND l.user.ID_user = :id_user",
				      Like.class)
				      .setParameter("id_game", entity.getGame().getID_game())
				      .setParameter("id_user", entity.getUser().getID_user())
				      .getResultList();
			
			if(resultList.isEmpty()){
				em.persist(entity);
				newEntity = true;
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
		}
		System.out.println("OK: '"+entity.toString()+"' salvato correttamente");
		return newEntity;
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

	public Like findLike(long id_user, long id_game, EntityManager em){
		Like l = null;
		List<Like> resultList = (List<Like>)em.createQuery(
			      "SELECT l FROM Like l WHERE l.game.ID_game = :id_game AND l.user.ID_user = :id_user",
			      Like.class)
			      .setParameter("id_game", id_game)
			      .setParameter("id_user", id_user)
			      .getResultList();
		if(!resultList.isEmpty())
			l = resultList.get(0);
		return l;
	}
	
	@SuppressWarnings("unchecked")
	public List<Like> findAll(EntityManager em){
		return (List<Like>)em.createQuery("SELECT l FROM Like l").getResultList();
	}
}
