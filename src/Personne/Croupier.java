package Personne;

import java.util.*;

import Carte.*;

public class Croupier
{
	private ArrayList<Carte> alC;
	
	public Croupier()
	{
		alC = new ArrayList<Carte>();
	}
	
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
		return "Croupier" + alC.get(0).toString();
	}
}