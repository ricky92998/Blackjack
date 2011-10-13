package Fenetre.FenetreSaisie;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Blackjack.*;


public abstract class FenetreSaisie extends Frame implements ActionListener
{
	private String				nomFenetre;
	private int 				nbJoueur;
	private int 				nbTextFieldUsed = 0;
	// Ceci permet de stocker les infos que les joueurs entrent
	private ArrayList<String> 	alS;

	private TextField 			saisie1;
	private TextField 			saisie2;
	private TextField 			saisie3;
	private TextField 			saisie4;
	
	public FenetreSaisie(String titre, int ligne, int nbJoueur)
	{
		nomFenetre = titre;
		this.nbJoueur = nbJoueur;
		alS = new ArrayList<String>();
		
		String title = "";
		if (titre.equals("nomJoueur"))
			title = "Choisissez le nom des joueurs";
		else if (titre.equals("pognon"))
			title = "Combien avez vous d'argent";
		else if (titre.equals("pari"))
			title = "Choix des paris";
		
		setTitle(title);
		setLocation(100, 100);
		
		// permet a la croix d'arreter le programme
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setLayout(new GridLayout(ligne, 1));
		
		String label = "";
		if (titre.equals("nomJoueur"))
			label = "Quels sont les noms des joueurs ?";
		else if (titre.equals("pognon"))
			label = "Combien d'argent ont chaques joueurs ?";
		else if (titre.equals("pari"))
			label = "Quels sont vos paris ?";
		
		add(new Label(label));
		
		// initialisation des TextFields
		saisie1 = new TextField();
		saisie1.addActionListener(this);
		saisie1.setEnabled(false); // permet a la zone de ne pas etre editable
		add(saisie1);

		saisie2 = new TextField();
		saisie2.addActionListener(this);
		saisie2.setEnabled(false);
		add(saisie2);
				
		saisie3 = new TextField();
		saisie3.addActionListener(this);
		saisie3.setEnabled(false);
		add(saisie3);
				
		saisie4 = new TextField();
		saisie4.addActionListener(this);
		saisie4.setEnabled(false);
		add(saisie4);
		
		pack();
		setVisible(true);	
		
	}
	
	// accesseur
	public String 				getNomFenetre()			{		return nomFenetre;	}
	public int 					getNbJoueur()			{	return nbJoueur;		}
	public ArrayList<String> 	getAlS() 				{	return alS;				}
	public int 					getNbTextFieldUsed()	{	return nbTextFieldUsed;	}
	// retourne un entier ou un String selon le besoin
	public int 					getIntAlS(int i)		{	return Integer.parseInt(alS.get(i));		}
	public String 				getStringAlS(int i)		{	return alS.get(i);		}
	
	// modificateur de nbJoueur
	public void setNbJoueur(int nbJoueur)				{	this.nbJoueur = nbJoueur;				}
	public void setNbTextFieldUsed(int nbTextFieldUsed)	{	this.nbTextFieldUsed = nbTextFieldUsed;	}
	
	public void ajouterAlS(String info)
	{
		alS.add(info);
	}
	
	public void activerSaisie(int textfield)
	{
		if (textfield == 0)
			saisie1.setEnabled(true);
		else if (textfield == 1)
			saisie2.setEnabled(true);
		else if (textfield == 2)
			saisie3.setEnabled(true);
		else if (textfield == 3)
			saisie4.setEnabled(true);
	}
	
	public void desactiverSaisie(int numTextField)
	{
		// si le num est egale a 0, 1, 2 ou 3 alors on desactive la zone de texte
		if (numTextField == 0)
			saisie1.setEnabled(false);
		else if (numTextField == 1)
			saisie2.setEnabled(false);
		else if (numTextField == 2)
			saisie3.setEnabled(false);
		else if (numTextField == 3)
			saisie4.setEnabled(false);
	}
	
	public void vider()
	{
		alS.clear();
		nbTextFieldUsed = 0;
	}
}