import java.util.*;

public class Joueur
{
	static int id = 0;
	int numJoueur;
	String nom;
	ArrayList<Carte> alC = new ArrayList<Carte>();
	
	public Joueur(String nom)
	{
		this.nom = nom;
		numJoueur = ++id;
	}

	public int getNumJoueur()	{	return numJoueur;	}
	public String getNom()		{	return nom;	}
	
	public void setNumJoueur(int numJoueur)	{	this.numJoueur = numJoueur;	}
	public void setNom(String nom)			{	this.nom = nom;	}
	
	public void ajouterCarte(Carte carte)
	{
		alC.add(carte);
	}
	
	@Override
	public String toString() 
	{
		return "Joueur [numJoueur=" + numJoueur + ", nom=" + nom + "]";
	}
	
	public String afficherCarte()
	{
		String s ="";
		for (Carte carte : alC)
			s += carte.toString() + "\n";
		
		return s;
	}

	public boolean enleverCarte(Carte carte)
	{
		return alC.remove(carte);
	}
	
}
