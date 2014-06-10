package util;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.codec.digest.DigestUtils;

import model.Administrator;
import model.Analyst;
import model.BoardGame;
import model.CardGame;
import model.ClassicGame;
import model.Game;
import model.Like;
import model.Moderator;
import model.NormalUser;
import model.Platform;
import model.Sport;
import model.Videogame;

public class PersistUtil {

	
	public boolean saveNormalUser(NormalUser entity, EntityManager em) {
		try {
			entity.setPassword(DigestUtils.md5Hex(entity.getPassword()));
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			//em.getTransaction().rollback();
			System.out.println("Errore nel salvataggio, normal user: '"+entity.toString()+"'");
			System.out.println(e.getMessage());
			return false;
		}
		System.out.println("OK: '"+entity.toString()+"' salvato correttamente");
		return true;
	}
	
	public boolean saveCardGame(CardGame entity, EntityManager em) {
		try {
			em.getTransaction().begin();
			entity.setPublished(true);
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
	
	public boolean saveBoardGame(BoardGame entity, EntityManager em) {
		try {
			em.getTransaction().begin();
			entity.setPublished(true);
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
	
	public boolean saveVideogame(Videogame entity, EntityManager em) {
		try {
			em.getTransaction().begin();
			entity.setPublished(true);
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
	
	
	public boolean saveSport(Sport entity, EntityManager em) {
		try {
			em.getTransaction().begin();
			entity.setPublished(true);
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
	
	public boolean saveClassicGame(ClassicGame entity, EntityManager em) {
		try {
			em.getTransaction().begin();
			entity.setPublished(true);
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

	public boolean saveAdministrator(Administrator entity, EntityManager em) {
		try {
			entity.setPassword(DigestUtils.md5Hex(entity.getPassword()));
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
	
	public boolean saveAnalyst(Analyst entity, EntityManager em) {
		try {
			entity.setPassword(DigestUtils.md5Hex(entity.getPassword()));
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
	
	public boolean saveModerator(Moderator entity, EntityManager em) {
		try {
			entity.setPassword(DigestUtils.md5Hex(entity.getPassword()));
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
	
	public boolean savePlatform(Platform entity, EntityManager em) {
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
	
	public boolean saveLike(Like entity, EntityManager em) {
		em.getTransaction().begin();
		try {
			em.persist(entity);
			
			if(entity.getScore() != -1){
				//aggiorno average score
				List<Like> likeList = (List<Like>)em.createQuery("SELECT l FROM Like l WHERE l.game.ID_game = :id_game",Like.class)
						.setParameter("id_game", entity.getGame().getID_game())
						.getResultList();
				
				Game game = em.createQuery("SELECT g FROM Game g WHERE g.ID_game = :id_game", Game.class)
						.setParameter("id_game", entity.getGame().getID_game())
						.getSingleResult();
				
				//inizio calcolo avgscore -----
				int cummScore = 0;
				Iterator<Like> it = likeList.iterator();
				while(it.hasNext()){
					cummScore =+ it.next().getScore();
				}	
				float avgScore = (cummScore+entity.getScore())/(likeList.size()+1);
				//fine calcolo avgscore -----
				
				game.setAvgScore(avgScore);
				em.merge(game);
				entity.getGame().setAvgScore(avgScore);
			}
			
			
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nel salvataggio, '"+entity.toString()+"'");
			System.out.println(e.getMessage());
			return false;
		}
		System.out.println("OK: '"+entity.toString()+"' salvato correttamente");
		return true;
	}
}