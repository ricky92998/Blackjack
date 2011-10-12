package Blackjack;

import java.util.*;

import Fenetre.*;
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
	
	private FenetreChoixJoueurs		fenetreJoueurs;
	private FenetreSaisie			fenetreSaisie;
	
	private static int 					nbJoueur;

	public Blackjack()
	{
		alJ = new ArrayList<Joueur>();
		croupier = new Croupier();
		pioche = new Pioche();
		
		initialiserPioche();
		initialiserJoueur();
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
		fenetreJoueurs = new FenetreChoixJoueurs();
		while (fenetreJoueurs.getNbJoueur() != fenetreJoueurs.getAlS().size())
			attendre();
		
		// on modifie le nombre de joueur
		nbJoueur = fenetreJoueurs.getNbJoueur();
		
		// TODO On ajoute les joueurs
		for (int i = 0; i < nbJoueur; i++)
			alJ.add(new Joueur(fenetreJoueurs.getStringAl(i)));
		
		// on ferme la fenetre sans arreter le programmme
		fenetreJoueurs.dispose();

		// les joueurs ont une certaine somme
		choixPognon();
	}
	
	public void choixPognon()
	{
		// TODO On donne l'argent au joueur
		fenetreSaisie = new FenetreSaisie("pognon", nbJoueur);
		while (nbJoueur != fenetreSaisie.getAlI().size())
			attendre();
			
			
		for (int i = 0; i < nbJoueur; i++)
			alJ.get(i).setPognon(fenetreSaisie.getIntAl(i));
		
		fenetreSaisie.dispose();
		fenetreSaisie.vider();
	}
	
	public void choixPari()
	{
		fenetreSaisie = new FenetreSaisie("pari", nbJoueur);
		while (nbJoueur != fenetreSaisie.getAlI().size())
			attendre();
		
		for (int i = 0; i < nbJoueur; i++)
			alJ.get(i).setMise(fenetreSaisie.getIntAl(i));
		
		fenetreSaisie.dispose();
		fenetreSaisie.vider();
	}
	
	// accesseur de Pioche et nbJoueur
	public Pioche getPioche() 						{	return pioche;			}
	public int getNbJoueur() 						{	return nbJoueur;		}
	
	// accesseur des fenetres
	public FenetreChoixJoueurs getFenetreJoueur() 	{	return fenetreJoueurs;	}
	public FenetreSaisie getFenetreSaisie()			{	return fenetreSaisie;	}
	public ArrayList<Joueur> getAlJ()				{	return alJ;				}

	//permet de mélanger la pioche
	public void melangerPioche()
	{
		pioche.melangerCarte();
	}
	
	public void distribuerCarte()
	{
		for (int i = 0; i < NB_CARTE_DEBUT; i++)
		{
			for (Joueur j : alJ)
				j.ajouterCarte(pioche.getPremiereCarte());
			
			croupier.ajouterCarte(pioche.getPremiereCarte());
		}
	}
	
	public String afficherCarte()
	{
		String s = "";
		for (Joueur j : alJ)
			s += j.afficherCarte() + "\n";
		
		s += croupier.afficherCarte();
		
		return s;
	}
	
	// on attend pour pas prendre trop de ressources
	public void attendre()
	{
		try
		{
			Thread.sleep(5000);
		} catch (Exception e){}
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
	}
}