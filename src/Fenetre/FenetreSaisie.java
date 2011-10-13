package Fenetre;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Blackjack.*;


public abstract class FenetreSaisie extends Frame implements ActionListener
{
	private int 				nbJoueur;
	
	private TextField 			saisie1;
	private TextField 			saisie2;
	private TextField 			saisie3;
	private TextField 			saisie4;
	
	public FenetreSaisie(String titre, int ligne, int nbJoueur)
	{
		this.nbJoueur = nbJoueur;
		
		String title = "";
		if (titre.equals("pognon"))
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
		if (titre.equals("pognon"))
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
	
	// accesseur de nbJoueur
	public int getNbJoueur()		{	return nbJoueur;	}
	
	// modificateur de nbJoueur
	public void setNbJoueur(int nbJoueur)	{	this.nbJoueur = nbJoueur;	}
	
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
	
	
	/*private String 				nomFenetre;
	private int 				nbTextFieldUsed = 0;
	// Ceci permet de stocker l'argent que les joueurs entrent
	private ArrayList<Integer> 	alI;
	
	public FenetreSaisie(String nomFenetre, int nbJoueur)
	{
		// On cr�� la fenetre
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
	}*/
}
