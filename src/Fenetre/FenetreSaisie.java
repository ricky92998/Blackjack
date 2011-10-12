package Fenetre;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Blackjack.*;


public class FenetreSaisie extends Fenetre
{	
	private String 				nomFenetre;
	private int 				nbTextFieldUsed = 0;
	// Ceci permet de stocker l'argent que les joueurs entrent
	private ArrayList<Integer> 	alI;
	
	public FenetreSaisie(String nomFenetre, int nbJoueur)
	{
		// On créé la fenetre
		super(nomFenetre , 5, false, nbJoueur);
		// on active autant de saisie que le nombre de joueur
		super.activerSaisie(0);
		
		alI = new ArrayList<Integer>();
		this.nomFenetre = nomFenetre;
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
		boolean continu = true;
		if (nomFenetre.equals("pari"))
		{
			continu = bonneValeurPari(montant, nbTextFieldUsed);
		}
		// si continu on passe a la valeur prochaine (pour la mise)
		if (continu)
		{
			alI.add(montant);
	
			super.desactiverSaisie(nbTextFieldUsed);
			if (nbTextFieldUsed+1 < super.getNbJoueur())
				super.activerSaisie(++nbTextFieldUsed);
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		// TODO inutile vu qu'on a pas d'Item
	}
	
	public boolean bonneValeurPari(int montant, int numJoueur)
	{
		if (montant < Blackjack.MISE_MINI || montant > Blackjack.MISE_MAXI)
			return false;
		if (montant > Blackjack.alJ.get(numJoueur).getPognon())
			return false;
		
		return true;
	}
	
	public void vider()
	{
		alI.clear();
		nbTextFieldUsed = 0;
	}
}
