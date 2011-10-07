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
	
	public boolean enleverCarte(Carte carte)
	{
		return alC.remove(carte);
	}
	
	public void melangerCarte()
	{
		Collections.shuffle(alC);
	}
}
