import java.util.*;
import Fenetre.*;

public class Blackjack
{
	private ArrayList<Joueur> 		alJ;
	private Pioche 					pioche;
	
	private FenetreChoixJoueurs		fenetreJoueurs;
	private FenetreChoixPognon		fenetrePognon;
	private int 					nbJoueur;

	public Blackjack()
	{
		alJ = new ArrayList<Joueur>();
		pioche = new Pioche();
		fenetreJoueurs = new FenetreChoixJoueurs();
		
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
			alJ.add(new Joueur(fenetreJoueurs.getStringAl(i)));
	}
	
	public void choixPognon()
	{
		fenetrePognon = new FenetreChoixPognon(nbJoueur);
		while (nbJoueur != fenetrePognon.getAlI().size());
		for (int i = 0; i < nbJoueur; i++)
			alJ.get(i).setPognon(fenetrePognon.getIntAl(i));
	}
	
	// accesseur de Pioche et Fenetre et nbJoueur
	public Pioche getPioche() 						{	return pioche;	}
	public int getNbJoueur() 						{	return nbJoueur;	}
	
	public FenetreChoixJoueurs getJoueurFenetre() 	{	return fenetreJoueurs;	}
	public FenetreChoixPognon getPognonFenetre()	{	return fenetrePognon;	}
	
	
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
		while (b.getJoueurFenetre().getNbJoueur() != b.getJoueurFenetre().getAlS().size());
		
		b.setNbJoueur(b.getJoueurFenetre().getNbJoueur());
		// on ferme la fenetre sans arreter le programmme
		b.getJoueurFenetre().dispose();
		
		b.initialiserJoueur();
		
		b.choixPognon();
	}

	
}
