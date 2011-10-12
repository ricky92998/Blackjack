package Personne;

import java.util.*;

import Carte.*;

public class Joueur
{
	static int 			id = 0;
	int 				numJoueur;
	String 				nom;
	// argent du joueur
	int 				pognon;
	// mise du joueur
	int 				mise;
	// Le joueur possede une liste de Carte
	ArrayList<Carte> 	alC;
	// Le joueur peut avoir une deuxième liste sépare ces 2 cartes
	ArrayList<Carte>	alCUtilitaire;
	
	public Joueur(String nom)
	{
		this.nom = nom;
		numJoueur = ++id;
		pognon = 0;
		mise = 0;
		alC = new ArrayList<Carte>();
	}

	public int getNumJoueur()	{	return numJoueur;	}
	public String getNom()		{	return nom;			}
	public int getPognon() 		{	return pognon;		}
	public int getMise()		{	return mise;		}
	
	public void setNumJoueur(int numJoueur)	{	this.numJoueur = numJoueur;	}
	public void setNom(String nom)			{	this.nom = nom;				}
	public void setPognon(int pognon) 		{	this.pognon = pognon;		}
	public void setMise(int mise)			{	this.mise = mise;			}
	
	public void ajouterCarte(Carte carte)
	{
		alC.add(carte);
	}
	
	public boolean enleverCarte(Carte carte)
	{
		return alC.remove(carte);
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