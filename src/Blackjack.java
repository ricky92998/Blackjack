import java.util.*;

public class Blackjack
{
	private ArrayList<Joueur> 	alJ;
	private Pioche 				pioche;
	
	private Fenetre				fenetre;
	
	public Blackjack()
	{
		alJ = new ArrayList<Joueur>();
		pioche = new Pioche();
		fenetre = new Fenetre();
		
		initialiser();
	}
	
	public void initialiser()
	{
		for (Categorie cat : Categorie.values())
			for (int i = 0; i < 13; i++)
				pioche.ajouterCarte(new Carte(i, cat));
		
		pioche.melangerCarte();
	}
	
	// accesseur de Pioche et Fenetre
	public Pioche getPioche() {		return pioche;	}
	public Fenetre getFenetre() {		return fenetre;	}
	
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
		
		/*try
		{
			Thread.sleep(3000);
		}
		catch (Exception e){}*/
		while (b.getFenetre().getNbJoueur() != b.getFenetre().getAlS().size())
		{
			System.out.println(b.getFenetre().getNbJoueur() + "\t" +  b.getFenetre().getAlS().size());
		}
		
		b.getFenetre().dispose();
		System.out.println("test");
	}
}
