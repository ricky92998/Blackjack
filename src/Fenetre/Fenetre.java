package Fenetre;

import java.awt.*;
import java.awt.event.*;

public abstract class Fenetre extends Frame implements ActionListener, ItemListener
{
	private int 				nbJoueur;
	
	private CheckboxGroup 		cbg;
	private Checkbox			choixNbJoueur;
	
	private TextField 			saisie1;
	private TextField 			saisie2;
	private TextField 			saisie3;
	private TextField 			saisie4;
	
	// titre pour les différentes fenetres
	// ligne pour le nombre de ligne a notre fenetre
	// choix pour savoir s'il y a un choix a faire
	public Fenetre(String titre, int ligne, boolean choix, int nbJoueur)
	{
		this.nbJoueur = nbJoueur;
		
		String title = "";
		if (titre.equals("pognon"))
			title = "Combien avez vous d'argent";
		else if (titre.equals("joueur"))
			title = "Initialisation Joueur";
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
		
		if (titre.equals("joueur"))
		{
			label = "Combien de joueurs jouent ?(1/4)";
			add(new Label(label));
		}
		
		if (choix)
		{
			cbg 	= new CheckboxGroup();
			
			// initialiser de la liste des nombres de joueurs
			for (int i = 1; i < 5; i++)
			{
				choixNbJoueur = new Checkbox(String.valueOf(i), cbg, false);
				choixNbJoueur.addItemListener(this);
				add(choixNbJoueur);
			}
		}
		
		if (titre.equals("joueur"))
			label = "Quels sont vos noms ?";
		else if (titre.equals("pognon"))
			label = "Combien d'argent ont chaques joueurs ?";
		else if (titre.equals("pari"))
			label = "Quels sont vos paris ?";
		else
			label = null;
		
		if (label != null)
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
}