package Fenetre;

import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class FenetreChoixJoueurs extends Fenetre
{	
	private int 				nbJoueur;
	private boolean				use;
	// permet de stocker le nom des joueurs
	private	ArrayList<String> 	alS;
	
	public FenetreChoixJoueurs()
	{
		super("joueur", 10, true);
		
		// pour pas avoir la meme taille que la liste
		nbJoueur = -1;
		use = false;
		alS = new ArrayList<String>();
			
	}
	
	public int getNbJoueur() 			{	return nbJoueur;	}
	public ArrayList<String> getAlS() 	{	return alS;			}
	public String getStringAl(int i)	{	return alS.get(i);	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		TextField tf = (TextField) e.getSource();
		String text = tf.getText();
		alS.add(text);
		
		String name = tf.getName();
		
		super.setTextField(name);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		// TODO Auto-generated method stub
		Checkbox cb = (Checkbox) e.getSource();
		nbJoueur = Integer.parseInt(cb.getLabel());
		// si le nombre de joueurs est superieur ou egale a 1 on active saisie1
		if (!use)
			super.activerSaisie(nbJoueur);
		
		use = true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		FenetreChoixJoueurs f = new FenetreChoixJoueurs();
	}

}
