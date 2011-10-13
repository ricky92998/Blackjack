package Personne;

import java.util.*;

import Carte.*;

public class Joueur
{
	private static int 			id = 0;
	private	int 				numJoueur;
	private	String 				nom;
	// argent du joueur
	private	int 				pognon;
	// mise du joueur
	private	int 				mise;
	private int 				miseAssurance;
	// si le joueur est elimine il ne joue plus 
	private boolean 			elimine;
	private boolean				stop;
	// Le joueur possede une liste de Carte
	private ArrayList<Carte> 	alC;
	// Le joueur peut avoir une deuxi�me liste s�pare ces 2 cartes
	private	ArrayList<Carte>	alCUtilitaire;
	
	public Joueur(String nom)
	{
		this.nom = nom;
		numJoueur = ++id;
		pognon = 0;
		mise = 0;
		elimine = false;
		stop = false;
		alC = new ArrayList<Carte>();
	}

	public int 		getNumJoueur()		{	return numJoueur;	}
	public String 	getNom()			{	return nom;			}
	public int 		getPognon() 		{	return pognon;		}
	public int 		getMise()			{	return mise;		}
	public int 		getMiseAssurance()	{	return miseAssurance;	}
	
	public ArrayList<Carte> getListeCarte()	{	return alC;			}
	
	public void setNumJoueur(int numJoueur)	{	this.numJoueur = numJoueur;	}
	public void setNom(String nom)			{	this.nom = nom;				}
	public void setPognon(int pognon) 		{	this.pognon = pognon;		}
	public void setMise(int mise)			{	this.mise = mise;			}
	public void setElimine(boolean elimine)	{	this.elimine = elimine;		}
	public void setStop(boolean stop)		{	this.stop = stop;			}
	public void setMiseAssurance(int miseAssurance)	{		this.miseAssurance = miseAssurance;	}
	
	public void ajouterCarte(Carte carte)
	{
		alC.add(carte);
	}
	
	public boolean enleverCarte(Carte carte)
	{
		return alC.remove(carte);
	}
	
	public boolean aUnBlackjack()
	{
		return false;
	}
	
	public boolean estElimine()	
	{	
		return elimine;
	}
	
	public boolean aArreter()
	{
		return stop;
	}
	
	public void partagerCarte()
	{
		alCUtilitaire.add(alC.get(1));
		enleverCarte(alC.get(1));
	}
	
	public String afficherCarte()
	{
		String s ="";
		for (Carte carte : alC)
			s += nom + " : " + carte.toString() + ", ";
		
		return s;
	}
	
	@Override
	public String toString() 
	{
		return "Joueur [numJoueur=" + numJoueur + ", nom=" + nom + ", argent= " + pognon + ", mise en jeu : "+ mise + "]";
	}
}