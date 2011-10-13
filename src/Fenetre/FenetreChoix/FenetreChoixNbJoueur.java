package Fenetre.FenetreChoix;

import java.awt.*;
import java.awt.event.*;

public class FenetreChoixNbJoueur extends FenetreChoix
{
	public FenetreChoixNbJoueur(String nomFenetre, int nbJoueur)
	{
		super(nomFenetre, 5, nbJoueur);
	}
	
	public void itemStateChanged(ItemEvent e) 
	{
		// TODO Auto-generated method stub
		Checkbox cb = (Checkbox) e.getSource();
		super.setNbJoueur(Integer.parseInt(cb.getLabel()));
	}
}
