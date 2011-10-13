package Fenetre.FenetreChoix;

import java.awt.*;
import java.awt.event.*;

public class FenetreChoixNbJoueur extends FenetreChoix
{
	private boolean choixUtilise;
	public FenetreChoixNbJoueur(String nomFenetre, int nbJoueur)
	{
		super(nomFenetre, 5, nbJoueur);
		choixUtilise = false;
	}
	
	public void itemStateChanged(ItemEvent e) 
	{
		// TODO Auto-generated method stub
		Checkbox cb = (Checkbox) e.getSource();
		if (!choixUtilise)
		{
			super.setNbJoueur(Integer.parseInt(cb.getLabel()));
			choixUtilise = true;
		}
	}
}
