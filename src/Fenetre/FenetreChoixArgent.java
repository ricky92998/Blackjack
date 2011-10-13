package Fenetre;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class FenetreChoixArgent extends FenetreSaisie
{
	private int 				nbTextFieldUsed = 0;
	// Ceci permet de stocker l'argent que les joueurs entrent
	private ArrayList<Integer> 	alI;
	
	public FenetreChoixArgent(String nomFenetre, int nbJoueur)
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
		
		alI.add(montant);
		
		super.desactiverSaisie(nbTextFieldUsed);
		if (nbTextFieldUsed+1 < super.getNbJoueur())
		super.activerSaisie(++nbTextFieldUsed);
	}

}
