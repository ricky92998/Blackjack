package Fenetre;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class FenetreChoixJoueurs extends Fenetre
{	
	//private int 				nbJoueur;
	private boolean				use;
	
	// permet de stocker le nom des joueurs
	private	ArrayList<String> 	alS;
	
	public FenetreChoixJoueurs()
	{
		// nombre de joueur a -1 pour pas avoir la meme taille que la liste
		super("joueur", 10, true, -1);
		
		
		use = false;
		alS = new ArrayList<String>();
			
	}
	
	public ArrayList<String> getAlS() 	{	return alS;			}
	public String getStringAl(int i)	{	return alS.get(i);	}

	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		TextField tf = (TextField) e.getSource();
		String text = tf.getText();
		alS.add(text);
		
		String name = tf.getName();
		
		int numTextField = Integer.parseInt(name.substring(9, 10));
		
		super.desactiverSaisie(numTextField);
		super.activerSaisie(++numTextField);
		
	}
	
	public void itemStateChanged(ItemEvent e) 
	{
		// TODO Auto-generated method stub
		Checkbox cb = (Checkbox) e.getSource();
		super.setNbJoueur(Integer.parseInt(cb.getLabel()));
		// si le nombre de joueurs est superieur ou egale a 1 on active saisie1
		if (!use)
			super.activerSaisie(0);
		
		use = true;
	}
}