import java.util.*;

public class Banquier
{
	ArrayList<Carte> alC;
	
	public Banquier(String nom)
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
}
