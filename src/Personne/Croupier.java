package Personne;

import java.util.*;

import Carte.*;
import Enum.Face;

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
	
	public boolean possedeCarte(Face face)
	{
		if (alC.get(0).getFace().equals(face))
			return true;
		
		return false;
	}
	
	public String afficherCarte()
	{
		return "Croupier" + alC.get(0).toString();
	}
}