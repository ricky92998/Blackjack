import java.util.*;

public class Blackjack
{
	private ArrayList<Joueur> 	alJ;
	private Pioche 				pioche;
	
	private Fenetre				fenetre;
	private int 				nbJoueur;

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
	
	public void initialiserJoueur() 
	{
		// TODO Auto-generated method stub
		for (int i = 0; i < nbJoueur; i++)
			alJ.add(new Joueur(fenetre.getStringAl(i)));
	}
	
	// accesseur de Pioche et Fenetre et nbJoueur
	public Pioche getPioche() 	{	return pioche;	}
	public Fenetre getFenetre() {	return fenetre;	}
	public int getNbJoueur() 	{	return nbJoueur;	}
	
	public void setNbJoueur(int nbJoueur) {		this.nbJoueur = nbJoueur;	}
	
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
		
		//permet d'attendre qu'on entre les informations
		while (b.getFenetre().getNbJoueur() != b.getFenetre().getAlS().size());
		
		b.setNbJoueur(b.getFenetre().getNbJoueur());
		// on ferme la fenetre sans arreter le programmme
		b.getFenetre().dispose();
		
		b.initialiserJoueur();
		
		
		System.out.println(b.alJ);
	}

	
}
