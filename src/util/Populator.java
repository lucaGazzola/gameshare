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
import model.LikePK;
import model.NormalUser;

public class Populator {
	
	private EntityManager em = EntityManagerUtil.getEntityManager();
	private PersistUtil pu = new PersistUtil();
	
	public void popolate(){
		
		//---------- POPULATE GIOCHI ---------------------------------------------------------
		System.out.println("*********** START POPULATE DB ***********");
		System.out.println("Inizio populate giochi:");
		
		//populate di alcuni giochi di carte
		CardGame cg = new CardGame("briscola", "bello", "5-10 euro", 10, 2, 4, "carte regionali");
		CardGame cg2 = new CardGame("scopa", "bello", "5-10 euro", 10, 2, 4, "carte regionali");
		CardGame cg3 = new CardGame("tresette", "bello", "5-10 euro", 10, 2, 4, "carte regionali");
		CardGame cg4 = new CardGame("brascola", "bello", "5-10 euro", 10, 2, 4, "carte regionali");
		CardGame cg5 = new CardGame("brucola", "bello", "5-10 euro", 10, 2, 4, "carte regionali");
		CardGame cg6 = new CardGame("brisafuccola", "bello", "5-10 euro", 10, 2, 4, "carte regionali");
		pu.saveCardGame(cg, em);pu.saveCardGame(cg2, em);pu.saveCardGame(cg3, em);
		pu.saveCardGame(cg4, em);
		pu.saveCardGame(cg5, em);
		pu.saveCardGame(cg6, em);
	
		//populate di alcuni board game
		BoardGame bg = new BoardGame("Risiko", 
				"RisiKo!, la versione italiana di Risk, dal quale tuttavia si differenzia in modo sostanziale, è un celebre gioco di strategia da tavolo che ha come argomento una guerra planetaria. Scopo del gioco è il raggiungimento di un obiettivo predefinito, segreto e diverso per ciascun giocatore, che può consistere nella conquista di un certo numero di territori, nella conquista di due o più continenti o nell'annientamento di un giocatore avversario.",
				"5-10 euro", 5, 2, 4);
		BoardGame bg2 = new BoardGame("Monopoly", 
				"Monopoly è un classico gioco da tavolo, pubblicato in Italia dal 1935 per oltre 70 anni dalla Editrice Giochi con il nome Monopoli, fino all'estate 2009, quando anche la distribuzione italiana passa alla Hasbro. I giocatori competono per guadagnare denaro mediante un'attività economica che coinvolge l'acquisto, affitto e commercio di proprietà terriere mediante denaro finto. I giocatori a turno muovono sul tabellone di gioco secondo il risultato del tiro di due dadi. Il gioco prende il suo nome dal concetto economico di monopolio, il dominio del mercato da parte di un singolo venditore.",
				"5-10 euro", 5, 2, 4);
		pu.saveBoardGame(bg, em);pu.saveBoardGame(bg2, em);
		
		
		//populate di alcuni videogiochi
		Videogame vg = new Videogame("Pac-Man",
				"Pac-Man (conosciuto in Giappone con il nome di Pakkuman) è un celebre videogioco ideato da Tohru Iwatani programmatore della Namco e pubblicato per la prima volta dalla Midway Games nel 1980 nel formato arcade da sala",
				"2-5 euro", false, "Arcade");
		Videogame vg2 = new Videogame("Counter-Strike",
				"Counter-Strike è un videogioco sparatutto in multiplayer, nato dall'idea di due studenti universitari che nel 1998 misero mano al codice di Half-Life. Divenuto in seguito proprietà della Valve Software, il suo attuale successo è dovuto al fatto che venne pubblicato come mod gratuito di Half-Life, ne usa il motore grafico, ed è giocabile online. ",
				"10-15 euro", true, "First Person Shooter");
		
		Collection<Platform> piattaforme = new ArrayList<Platform>(){
			private static final long serialVersionUID = 1L;
		{
			add(new Platform("NES"));
			add(new Platform("Commodore"));
			add(new Platform("Atari"));
			
		}};
		vg.setPlatforms(piattaforme);
		
		
		Collection<Platform> piattaforme2 = new ArrayList<Platform>(){
			private static final long serialVersionUID = 1L;
		{
			add(new Platform("Windows"));
			add(new Platform("MAC"));
			add(new Platform("Xbox"));
			add(new Platform("Linux"));
		}};
		vg2.setPlatforms(piattaforme2);
		
		//persisto le piattaforme prima dei videogiochi
		for (Platform platform : piattaforme){pu.savePlatform(platform,em);}
		for (Platform platform : piattaforme2){pu.savePlatform(platform,em);}
		pu.saveVideogame(vg, em);pu.saveVideogame(vg2, em);
		
		//populate di alcuni sport
		Sport sp = new Sport("Calcio a 11",
				"",
				"medio-basso", 90, 22, 30);
		Sport sp2 = new Sport("Tennis",
				"Il tennis è uno sport che vede opposti due giocatori (uno contro uno, incontro singolare) o quattro (due contro due, incontro di doppio) in un campo diviso in due metà da una rete alta circa un metro dal terreno.",
				"medio-alto", 60, 2, 2);
		pu.saveSport(sp, em);pu.saveSport(sp2, em);
		
		//populate di alcuni giochi classici
		//ClassicGame
		//---------- FINE POPULATE GIOCHI ---------------------------------------------------------
		
		
		// -------- POPULATE DI ALCUNI UTENTI -------------------------------------------------------
		System.out.println();
		System.out.println("Inizio populate utenti:");
		Date now = new Date();
		NormalUser u = new NormalUser("franco@franco.net", "prolol", now, "luca", "franchi", 'M', "studente", "milano", "bicocca", "milano");
		NormalUser u2 = new NormalUser("gigi@gmail.com", "antilol", now, "gigi", "rizzi", 'M', "impiegato", "roma", "roma 3", "roma");
		NormalUser u3 = new NormalUser("pippo@gmail.com", "prorofl", now, "pippo", "labamba", 'M', "agricoltore", "amsterdam", "kingstone university", "jamaica");
		NormalUser u4 = new NormalUser("gina@gmail.com", "antilol", now, "gina", "lollobrigida", 'F', "attrice-cantante", "roma", "elementari", "casablanca");
		pu.saveNormalUser(u,em);pu.saveNormalUser(u2,em);pu.saveNormalUser(u3,em);pu.saveNormalUser(u4,em);
		
		Administrator a = new Administrator("topogigio@gmail.com", "strapazzami", now, "gigio", "topo", 'M', "presentatore-cantante", "roma", "asilo", "roma");
		Analyst aa = new Analyst("ragionierugofantozzi@gmail.com", "uga");
		Moderator m = new Moderator("foobar@gmail.com", "foo", now, "foo", "bar", 'M', "esempio per i test", "massachusetts", "mit massachusetts", "massachusetts");
		pu.saveAdministrator(a,em);pu.saveAnalyst(aa,em);pu.saveModerator(m,em);
		//---------- FINE POPULATE UTENTI ----------------------------------------------------------
		
		
		// -------- POPULATE DI ALCUNI LIKE --------------------------------------------------------
		System.out.println();
		System.out.println("Inizio populate likes: ");
		
		Like l = new Like(new LikePK(u.getID_user(), cg2.getID_game()), true, "Very good Really enjoy playing this, and can play with your friends too.", 5);
		Like l1 = new Like(new LikePK(u.getID_user(), bg.getID_game()), false, "", 0);
		Like l2 = new Like(new LikePK(u2.getID_user(), sp.getID_game()), true, "Very good Really enjoy playing this, and can play with your friends too.", 4);
		Like l3 = new Like(new LikePK(u3.getID_user(), cg3.getID_game()), true, "Brings back old times playing against my dad", 4);
		Like l4 = new Like(new LikePK(u4.getID_user(), cg.getID_game()), true, "Very good Really enjoy playing this, and can play with your friends too.", 3);
		pu.saveLike(l,em);pu.saveLike(l1,em);pu.saveLike(l2,em);
		pu.saveLike(l3,em);pu.saveLike(l4,em);
		//---------- FINE POPULATE LIKE ----------------------------------------------------------
		
		EntityManagerUtil.closeEntityManager(em);
		System.out.println("*********** END POPULATE DB ***********");
	}
}