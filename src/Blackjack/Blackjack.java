package Blackjack;

import java.util.*;

import Fenetre.*;
import Fenetre.FenetreBouton.*;
import Fenetre.FenetreChoix.*;
import Fenetre.FenetreSaisie.*;
import Personne.*;
import Carte.*;
import Enum.*;

public class Blackjack
{
	public static final int MISE_MINI = 2;
	public static final int MISE_MAXI = 100;
	public static final int NB_CARTE_DEBUT = 2;
	
	public static ArrayList<Joueur>	alJ;
	private Croupier				croupier;
	private Pioche 					pioche;
	
	private	String 					action;
	
	private static int 				nbJoueur;

	public Blackjack()
	{
		alJ = new ArrayList<Joueur>();
		croupier = new Croupier();
		pioche = new Pioche();
		nbJoueur = 0;
		
		initialiser();
		initialiserPioche();
		initialiserJoueur();
	}
	
	public void initialiser()
	{
		FenetreChoixNbJoueur fj = new FenetreChoixNbJoueur("nbJoueur", nbJoueur);
		while (fj.getNbJoueur() == nbJoueur)
			attendre();
		
		// on modifie le nombre de joueur
		nbJoueur = fj.getNbJoueur();
		fj.dispose();
	}
	
	public void initialiserPioche()
	{
		for (Categorie cat : Categorie.values())
			for (Face face : Face.values())
				pioche.ajouterCarte(new Carte(face, cat));
		
		melangerPioche();	
	}	
	
	public void initialiserJoueur() 
	{
		FenetreSaisieString fNomJoueur = new FenetreSaisieString("nomJoueur", nbJoueur);
		while (nbJoueur != fNomJoueur.getAlS().size())
			attendre();
		
		
		// TODO On ajoute les joueurs
		for (int i = 0; i < nbJoueur; i++)
			alJ.add(new Joueur(fNomJoueur.getStringAlS(i)));
		
		// on ferme la fenetre sans arreter le programmme
		fNomJoueur.dispose();
		fNomJoueur.vider();

		// les joueurs ont une certaine somme
		choixPognon();
	}
	
	public void choixPognon()
	{
		// TODO On donne l'argent au joueur
		FenetreSaisieInt fArgent= new FenetreSaisieInt("pognon", nbJoueur);
		while (nbJoueur != fArgent.getAlS().size())
			attendre();
			
		for (int i = 0; i < nbJoueur; i++)
			alJ.get(i).setPognon(fArgent.getIntAlS(i));
		
		fArgent.dispose();
		fArgent.vider();
	}
	
	public void choixPari()
	{
		FenetreSaisieInt fMise = new FenetreSaisieInt("pari", nbJoueur);
		while (nbJoueur != fMise.getAlS().size())
			attendre();
		
		for (int i = 0; i < nbJoueur; i++)
			modifierMise(alJ.get(i), fMise.getIntAlS(i));
			
		
		fMise.dispose();
		fMise.vider();
	}
	
	

	public void choixJoueurCarte(Joueur j, int nbTours)
	{
		boolean peutDoubler = false;
		boolean peutSeparer = false;
		boolean peutAssurer = false;
		
		Carte carte1 = j.getListeCarte().get(0);
		Carte carte2 = j.getListeCarte().get(1);
		
		if (nbTours == 1)
		{
			if (carte1.equals(carte2))
				peutSeparer = true;
			if (croupier.possedeCarte(Face.AS))
				peutAssurer = true;
			
			peutDoubler = true;
		}

		FenetreBoutonAction fAction = new FenetreBoutonAction("action", j.getNom(), peutDoubler, peutSeparer, peutAssurer);
		while (fAction.getAction() == "")
			attendre();

		action = fAction.getAction();
		fAction.dispose();
		
	}
	
	// accesseur de Pioche et nbJoueur
	public Pioche 				getPioche() 	{	return pioche;		}
	public int 					getNbJoueur() 	{	return nbJoueur;	}
	public String 				getAction()		{	return action;		}
	public ArrayList<Joueur> 	getAlJ()		{	return alJ;			}

	//permet de m�langer la pioche
	public void melangerPioche()
	{
		pioche.melangerCarte();
	}
	
	// on distribue les cartes aux joueurs
	public void distribuerCarte()
	{
		for (int i = 0; i < NB_CARTE_DEBUT; i++)
		{
			for (Joueur j : alJ)
				j.ajouterCarte(pioche.getPremiereCarte());
			
			croupier.ajouterCarte(pioche.getPremiereCarte());
		}
	}
	
	public void faireAction(Joueur j)
	{
		if (action.equals("Carte"))
			j.ajouterCarte(pioche.getPremiereCarte());
		else if (action.equals("Rester"))
			j.setStop(true);
		else if (action.equals("Double"))
		{
			j.ajouterCarte(pioche.getPremiereCarte());
			modifierMise(j, j.getMise());
			j.setStop(true);
		}
		else if (action.equals("Partager"))
			j.partagerCarte();
		else if (action.equals("Assurance"))
		{
			ajoutAssurance(j, -j.getMise()/2);
			j.setStop(true);
		}
		else if (action.equals("Abandonner"))
			abandonner(j);
	}
	
	public void modifierMise(Joueur joueur, int mise)
	{
		// TODO Auto-generated method stub
		int nouvelleMise = joueur.getMise() + mise;
		int nouveauPognon = joueur.getPognon() - mise;
		joueur.setMise(nouvelleMise);
		joueur.setPognon(nouveauPognon);
	}
	
	public void ajoutAssurance(Joueur joueur, int miseAssurance)
	{
		int nouveauPognon = joueur.getPognon() - miseAssurance;
		joueur.setMiseAssurance(miseAssurance);
		joueur.setPognon(nouveauPognon);
	}
	
	public void abandonner(Joueur joueur)
	{
		int nouveauPognon = joueur.getPognon() + 1/2 * joueur.getMise();
		joueur.setPognon(nouveauPognon);
		joueur.setMise(0);
		joueur.setElimine(true);
	}
	
	// on attend pour pas prendre trop de ressource
	public void attendre()
	{
		try
		{
			Thread.sleep(3000);
		} catch (Exception e){}
	}
	
	public String afficherCarte()
	{
		String s = "";
		for (Joueur j : alJ)
			s += j.afficherCarte() + "\n";
		
		s += croupier.afficherCarte();
		
		return s;
	}
	
	public String toString()
	{
		String s ="";
		for (Joueur j : alJ)
			s += j.toString() + "\n";
		
		return s;
	}
	
	public static void main(String[] arg)
	{
		Blackjack b = new Blackjack();

		b.choixPari();
		
		b.distribuerCarte();
		System.out.println(b.afficherCarte());
		
		for (Joueur j : alJ)
		{
			int nbTours = 1;
			while (!j.estElimine() && !j.aUnBlackjack() && !j.aArreter())
			{
				b.choixJoueurCarte(j, nbTours);
				
				b.faireAction(j);
				System.out.println(b.afficherCarte());
				nbTours++;
			}
		}
	}

	
}