package Fenetre.FenetreSaisie;

import java.awt.*;
import java.awt.event.*;

public class FenetreSaisieString extends FenetreSaisie
{

	public FenetreSaisieString(String nom, int nbJoueur)
	{
		super(nom, 5, nbJoueur);
		
		super.activerSaisie(0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		TextField tf = (TextField) e.getSource();
		String texte = tf.getText();
		
		int nbTextFieldUsed = super.getNbTextFieldUsed();
		boolean continu = bonneValeurString(texte);
		
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
	
	public boolean bonneValeurString(String texte)
	{
		if (texte.length() < 3 || texte.length() > 20)
			return false;
		
		for (int i = 0; i < texte.length(); i++)
			if (Character.isDigit(texte.charAt(i)))
					return false;
		
		return true;
	}
}
