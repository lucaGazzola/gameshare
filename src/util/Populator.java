package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;

import model.Administrator;
import model.Analyst;
import model.BoardGame;
import model.CardGame;
import model.Moderator;
import model.Platform;
import model.Sport;
import model.Videogame;
import model.Like;
import model.NormalUser;

public class Populator {
	
	public void delete(){
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		
		em.createQuery("DELETE FROM AcceptLock").executeUpdate();
		em.createQuery("DELETE FROM Like").executeUpdate();
		em.createQuery("DELETE FROM NormalUser").executeUpdate();
		em.createQuery("DELETE FROM Administrator").executeUpdate();
		em.createQuery("DELETE FROM Moderator").executeUpdate();
		em.createQuery("DELETE FROM SystemUser").executeUpdate();
		em.createQuery("DELETE FROM Analyst").executeUpdate();
		em.createQuery("DELETE FROM User").executeUpdate();
		em.createQuery("DELETE FROM CardGame").executeUpdate();
		em.createQuery("DELETE FROM BoardGame").executeUpdate();
		em.createQuery("DELETE FROM Sport").executeUpdate();
		em.createQuery("DELETE FROM Videogame").executeUpdate();
		em.createQuery("DELETE FROM ClassicGame").executeUpdate();
		em.createQuery("DELETE FROM Game").executeUpdate();
		em.createQuery("DELETE FROM GameReport").executeUpdate();
		em.createQuery("DELETE FROM Platform").executeUpdate();
		em.createQuery("DELETE FROM UserReport").executeUpdate();



		/*
		em.createNativeQuery("UPDATE counters SET value = 0 WHERE key = 'ID_friendship'").executeUpdate();
		em.createNativeQuery("UPDATE counters SET value = 0 WHERE key = 'ID_user'").executeUpdate();
		em.createNativeQuery("UPDATE counters SET value = 0 WHERE key = 'ID_game'").executeUpdate();
		em.createNativeQuery("UPDATE counters SET value = 0 WHERE key = 'ID_like'").executeUpdate();
		em.createNativeQuery("UPDATE counters SET value = 0 WHERE key = 'ID_platform'").executeUpdate();
		*/
		em.getTransaction().commit();
		EntityManagerUtil.closeEntityManager(em);
	}
	
	public void popolate(){
		
		PersistUtil pu = new PersistUtil();
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		//---------- POPULATE GIOCHI ---------------------------------------------------------
		System.out.println("*********** START POPULATE DB ***********");
		System.out.println("Inizio populate giochi:");
		
		//populate di alcuni giochi di carte
		CardGame cg = new CardGame("Briscola",
				"Briscola one of Italy's most popular games together with Scopa and Tressette, and a little-changed descendant of Brusquembille, the ancestor of Briscan and Bezique,[1] is a Mediterranean trick-taking card game for two to six players played with a standard Italian 40-card deck.",
				"5-10", 10, 2, 4, "carte regionali");
		CardGame cg2 = new CardGame("Scopa",
				"Scopa is an Italian card game, and one of the two major national card games in Italy.[1] It is also popular in Brazil, brought in by Italian immigrants, mostly in the Scopa di Quindici variation.[2] It is played with a standard Italian 40-card deck, mostly between two players or four in two partnerships, but it can also be played by 3, 5, or 6 players.",
				"5-10", 10, 2, 4, "carte regionali");
		CardGame cg3 = new CardGame("Tresette",
				"Tressette or Tresette is one of Italy's major national trick-taking card games, together with Scopa and Briscola. It is recorded only from the early 18th century, though greater antiquity is suggested by its trumplessness. The name of the game, literally \"three Sevens\" may refer to a scoring combination no longer recognized, or to the fact that it is played up to twenty-one. There are many variants depending on the region of Italy the game is played in.[1]",
				"5-10", 10, 2, 4, "carte regionali");
		CardGame cg4 = new CardGame("Brascola",
				"Briscola one of Italy's most popular games together with Scopa and Tressette, and a little-changed descendant of Brusquembille, the ancestor of Briscan and Bezique,[1] is a Mediterranean trick-taking card game for two to six players played with a standard Italian 40-card deck.",
				"5-10", 10, 2, 4, "carte regionali");
		CardGame cg5 = new CardGame("Brucola",
				"Briscola one of Italy's most popular games together with Scopa and Tressette, and a little-changed descendant of Brusquembille, the ancestor of Briscan and Bezique,[1] is a Mediterranean trick-taking card game for two to six players played with a standard Italian 40-card deck.",
				"5-10", 10, 2, 4, "carte regionali");
		CardGame cg6 = new CardGame("Brisafuccola",
				"Briscola one of Italy's most popular games together with Scopa and Tressette, and a little-changed descendant of Brusquembille, the ancestor of Briscan and Bezique,[1] is a Mediterranean trick-taking card game for two to six players played with a standard Italian 40-card deck.",
				"5-10", 10, 2, 4, "carte regionali");
		pu.saveCardGame(cg, em);pu.saveCardGame(cg2, em);pu.saveCardGame(cg3, em);
		pu.saveCardGame(cg4, em);
		pu.saveCardGame(cg5, em);
		pu.saveCardGame(cg6, em);
	
		//populate di alcuni board game
		BoardGame bg = new BoardGame("Risiko", 
				"RisiKo!, la versione italiana di Risk, dal quale tuttavia si differenzia in modo sostanziale, è un celebre gioco di strategia da tavolo che ha come argomento una guerra planetaria. Scopo del gioco è il raggiungimento di un obiettivo predefinito, segreto e diverso per ciascun giocatore, che può consistere nella conquista di un certo numero di territori, nella conquista di due o più continenti o nell'annientamento di un giocatore avversario.",
				"5-10", 5, 2, 4);
		BoardGame bg2 = new BoardGame("Monopoly", 
				"Monopoly e un classico gioco da tavolo, pubblicato in Italia dal 1935 per oltre 70 anni dalla Editrice Giochi con il nome Monopoli, fino all'estate 2009, quando anche la distribuzione italiana passa alla Hasbro. I giocatori competono per guadagnare denaro mediante un'attività economica che coinvolge l'acquisto, affitto e commercio di proprietà terriere mediante denaro finto. I giocatori a turno muovono sul tabellone di gioco secondo il risultato del tiro di due dadi. Il gioco prende il suo nome dal concetto economico di monopolio, il dominio del mercato da parte di un singolo venditore.",
				"5-10", 5, 2, 4);
		pu.saveBoardGame(bg, em);pu.saveBoardGame(bg2, em);
		
		
		//populate di alcuni videogiochi
		Videogame vg = new Videogame("Pac-Man",
				"Pac-Man (conosciuto in Giappone con il nome di Pakkuman) e'� un celebre videogioco ideato da Tohru Iwatani programmatore della Namco e pubblicato per la prima volta dalla Midway Games nel 1980 nel formato arcade da sala",
				"2-5", false, "Arcade");
		Videogame vg2 = new Videogame("Counter-Strike",
				"Counter-Strike e'� un videogioco sparatutto in multiplayer, nato dall'idea di due studenti universitari che nel 1998 misero mano al codice di Half-Life. Divenuto in seguito proprietà della Valve Software, il suo attuale successo è dovuto al fatto che venne pubblicato come mod gratuito di Half-Life, ne usa il motore grafico, ed è giocabile online. ",
				"10-15", true, "First Person Shooter");
		
		Collection<Platform> piattaforme = new ArrayList<Platform>(){
			private static final long serialVersionUID = 1L;
		{
			add(new Platform("PS"));
			add(new Platform("PC"));
		}};
		vg.setPlatforms(piattaforme);
		
		
		Collection<Platform> piattaforme2 = new ArrayList<Platform>(){
			private static final long serialVersionUID = 1L;
		{
			add(new Platform("Wii"));
			add(new Platform("XBox"));
		}};
		vg2.setPlatforms(piattaforme2);
		
		//persisto le piattaforme prima dei videogiochi
		for (Platform platform : piattaforme){pu.savePlatform(platform,em);}
		for (Platform platform : piattaforme2){pu.savePlatform(platform,em);}
		pu.saveVideogame(vg, em);pu.saveVideogame(vg2, em);
		
		//populate di alcuni sport
		Sport sp = new Sport("Calcio a 11",null,"10-15", 90, 22, 30);
		Sport sp2 = new Sport("Tennis",
				"Il tennis e' uno sport che vede opposti due giocatori (uno contro uno, incontro singolare) o quattro (due contro due, incontro di doppio) in un campo diviso in due metà da una rete alta circa un metro dal terreno.",
				"50-100", 60, 2, 2);
		pu.saveSport(sp, em);pu.saveSport(sp2, em);
		//---------- FINE POPULATE GIOCHI ---------------------------------------------------------
		
		
		// -------- POPULATE DI ALCUNI UTENTI -------------------------------------------------------
		System.out.println();
		System.out.println("Inizio populate utenti:");
		Date now = new Date();
		NormalUser u = new NormalUser("franco@franco.net", "prolol", now, "luca", "franchi", 'M', "studente", "milano", "bicocca", "milano");
		NormalUser u2 = new NormalUser("gigi@gmail.com", "test", now, "gigi", "bianchi", 'M', "impiegato", "roma", "roma 3", "roma");
		NormalUser u3 = new NormalUser("pippo@gmail.com", "test", now, "pippo", "franchi", 'M', "agricoltore", "amsterdam", "kingstone university", "jamaica");
		NormalUser u4 = new NormalUser("gina@gmail.com", "test", now, "gina", "rossi", 'F', "attrice-cantante", "milano", "elementari", "casablanca");
		NormalUser u5 = new NormalUser("gina1@gmail.com", "test", now, "gino", "franchi", 'M', "attrice-cantante", "firenze", "elementari", "casablanca");
		NormalUser u6 = new NormalUser("gina2@gmail.com", "test", now, "francesco", "rossi", 'M', "attrice-cantante", "firenze", "elementari", "casablanca");
		NormalUser u7 = new NormalUser("gina3@gmail.com", "test", now, "franco", "bellini", 'M', "attrice-cantante", "roma", "elementari", "casablanca");
		NormalUser u8 = new NormalUser("gina4@gmail.com", "test", now, "gina", "rossini", 'F', "attrice-cantante", "roma", "elementari", "casablanca");
		NormalUser u9 = new NormalUser("gina5@gmail.com", "test", now, "luca", "rossi", 'M', "attrice-cantante", "milano", "elementari", "casablanca");
		NormalUser u10 = new NormalUser("gina6@gmail.com", "test", now, "dario", "limongi", 'M', "attrice-cantante", "roma", "elementari", "casablanca");
		NormalUser u11 = new NormalUser("gina7@gmail.com", "test", now, "marco", "conti", 'M', "attrice-cantante", "roma", "elementari", "casablanca");
		NormalUser u12 = new NormalUser("gina8@gmail.com", "test", now, "beppe", "grosso", 'M', "attrice-cantante", "firenze", "elementari", "casablanca");
		NormalUser u13 = new NormalUser("gina9@gmail.com", "test", now, "alessio", "mario", 'M', "attrice-cantante", "firenze", "elementari", "casablanca");
		NormalUser u14 = new NormalUser("gina10@gmail.com", "test", now, "mario", "alessio", 'M', "attrice-cantante", "roma", "elementari", "casablanca");
		
		pu.saveNormalUser(u,em);pu.saveNormalUser(u2,em);pu.saveNormalUser(u3,em);pu.saveNormalUser(u4,em);
		pu.saveNormalUser(u5,em);pu.saveNormalUser(u6,em);pu.saveNormalUser(u7,em);pu.saveNormalUser(u8,em);
		pu.saveNormalUser(u9,em);pu.saveNormalUser(u10,em);pu.saveNormalUser(u11,em);pu.saveNormalUser(u12,em);
		pu.saveNormalUser(u13,em);pu.saveNormalUser(u14,em);
		
		Administrator a = new Administrator("topogigio@gmail.com", "strapazzami", now, "gigio", "topo", 'M', "presentatore-cantante", "roma", "asilo", "roma");
		Analyst aa = new Analyst("ragionierugofantozzi@gmail.com", "passworddd","ugo","fantozzi");
		Moderator m = new Moderator("foobar@gmail.com", "foo", now, "foo", "bar", 'M', "esempio per i test", "massachusetts", "mit massachusetts", "massachusetts", "card");
		pu.saveAdministrator(a,em);pu.saveAnalyst(aa,em);pu.saveModerator(m,em);
		//---------- FINE POPULATE UTENTI ----------------------------------------------------------
		
		
		// -------- POPULATE DI ALCUNI LIKE --------------------------------------------------------
		System.out.println();
		System.out.println("Inizio populate likes: ");
		
		Like l = new Like(u, cg2, true, "Very good Really enjoy playing this, and can play with your friends too.", 5);
		Like l1 = new Like(u, bg, false, null, -1);
		Like l2 = new Like(u2, vg, true, "Very good Really enjoy playing this, and can play with your friends too.", 4);
		Like l3 = new Like(u3, cg3, true, "Brings back old times playing against my dad", 4);
		Like l4 = new Like(u4, cg, true, "Very good Really enjoy playing this, and can play with your friends too.", 3);
		Like l7 = new Like(u4, sp2, true, "Very good Really enjoy playing this, and can play with your friends too.", -1);
		Like l5 = new Like(u3, cg2, true, "Very good Really enjoy playing this, and can play with your friends too.", 3);
		Like l6 = new Like(u, sp2, true, "I like it very much. I can enjoy my time with my friends during weekends", 4);
		
		Like l8 = new Like(u5, cg2, false, null, -1);
		Like l9 = new Like(u6, cg2, false, null, -1);
		Like l10 = new Like(u7, cg2, false, null, -1);
		Like l11 = new Like(u8, cg2, false, null, -1);
		Like l12 = new Like(u9, cg2, false, null, -1);
		Like l13 = new Like(u10, cg2, false, null, -1);
		Like l14 = new Like(u11, cg2, false, null, -1);
		Like l15 = new Like(u12, cg2, false, null, -1);
		Like l16 = new Like(u13, cg2, false, null, -1);
		Like l17 = new Like(u14, cg2, false, null, -1);
		
		pu.saveLike(l,em);pu.saveLike(l1,em);pu.saveLike(l2,em);
		pu.saveLike(l3,em);pu.saveLike(l4,em);pu.saveLike(l5,em);
		pu.saveLike(l6,em);pu.saveLike(l7,em);pu.saveLike(l8,em);
		pu.saveLike(l9,em);pu.saveLike(l10,em);pu.saveLike(l11,em);
		pu.saveLike(l12,em);pu.saveLike(l13,em);pu.saveLike(l14,em);
		pu.saveLike(l15,em);pu.saveLike(l16,em);pu.saveLike(l17,em);
		//---------- FINE POPULATE LIKE ----------------------------------------------------------
		
		EntityManagerUtil.closeEntityManager(em);
		System.out.println("*********** END POPULATE DB ***********");
	}
}