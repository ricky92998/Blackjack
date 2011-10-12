package Carte;

import java.util.*;

public class Pioche 
{
	ArrayList<Carte> alC;
	
	public Pioche()
	{
		alC = new ArrayList<Carte>();
	}
	
	public void ajouterCarte(Carte carte)
	{
		alC.add(carte);
	}
	
	public Carte getPremiereCarte()
	{
		Carte c =  alC.get(0);
		enleverCarte(c);
		return c;
	}
	
	public boolean enleverCarte(Carte carte)
	{
		return alC.remove(carte);
	}
	
	public void melangerCarte()
	{
		Collections.shuffle(alC);
	}
}