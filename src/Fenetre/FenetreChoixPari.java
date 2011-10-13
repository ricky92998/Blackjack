package Fenetre;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class FenetreChoixPari extends FenetreSaisie
{
	private int 				nbTextFieldUsed = 0;
	// Ceci permet de stocker l'argent que les joueurs entrent
	private ArrayList<Integer> 	alI;
	
	public FenetreChoixPari(String nomFenetre, int nbJoueur)
	{
		// On cr�� la fenetre
		super(nomFenetre , 5, nbJoueur);
		// on active autant de saisie que le nombre de joueur
		super.activerSaisie(0);
		
		alI = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getAlI() {	return alI;		}
	public int getIntAl(int i)	{	return alI.get(i);	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		TextField tf = (TextField) e.getSource();
		String text = tf.getText();
		int montant = Integer.parseInt(text);
		boolean continu = bonneValeurPari(montant, nbTextFieldUsed);
		
		// si continu on passe a la valeur prochaine (pour la mise)
		if (continu)
		{
			alI.add(montant);
	
			super.desactiverSaisie(nbTextFieldUsed);
			if (nbTextFieldUsed+1 < super.getNbJoueur())
				super.activerSaisie(++nbTextFieldUsed);
		}
	}
	
	public boolean bonneValeurPari(int montant, int numJoueur)
	{
		if (montant < Blackjack.MISE_MINI || montant > Blackjack.MISE_MAXI)
			return false;
		if (montant > Blackjack.alJ.get(numJoueur).getPognon())
			return false;
		
		return true;
	}

}
