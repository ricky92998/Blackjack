package Fenetre.FenetreSaisie;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import Blackjack.*;

public class FenetreSaisieInt extends FenetreSaisie
{
	public FenetreSaisieInt(String nomFenetre, int nbJoueur)
	{
		// On cree la fenetre
		super(nomFenetre , 5, nbJoueur);
		// on active autant de saisie que le nombre de joueur
		super.activerSaisie(0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		TextField tf = (TextField) e.getSource();
		String texte = tf.getText();
		
		String nomFenetre = super.getNomFenetre();

		int nbTextFieldUsed = super.getNbTextFieldUsed();
		boolean continu = true;
		
		if (nomFenetre.equals("pognon"))
			continu = bonneValeurArgent(texte);
		else if (nomFenetre.equals("pari"))
			continu = bonneValeurPari(texte, nbTextFieldUsed);
		
		// si continu on passe a la valeur prochaine (pour la mise)
		if (continu)
		{
			super.ajouterAlS(texte);
			super.desactiverSaisie(nbTextFieldUsed);
			
			if (nbTextFieldUsed+1 < super.getNbJoueur())
			{
				// on active la zone de texte suivante
				super.activerSaisie(++nbTextFieldUsed);
				
				super.setNbTextFieldUsed(nbTextFieldUsed);
			}
		}
	}
	public boolean bonneValeurArgent(String texte)
	{
		int montant = 0;
		if (estUnString(texte))
			return false;
		else
			montant = Integer.parseInt(texte);
		
		if (montant < 0 || montant > 1000)
			return false;
		
		return true;
	}
	
	public boolean bonneValeurPari(String texte, int numJoueur)
	{
		int montant = 0;
		if (estUnString(texte))
			return false;
		else
			montant = Integer.parseInt(texte);
		
		if (montant < Blackjack.MISE_MINI || montant > Blackjack.MISE_MAXI)
			return false;
		// si le montant est superieur a notre argent c'est pas bon
		if (montant > Blackjack.alJ.get(numJoueur).getPognon())
			return false;
		
		return true;
	}
	
	public boolean estUnString(String texte)
	{
		
		for (int i = 0; i < texte.length(); i++)
			if (!Character.isDigit(texte.charAt(i)))
					return true;

		return false;
	}
}