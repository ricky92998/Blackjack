package Fenetre.FenetreChoix;

import java.awt.*;
import java.awt.event.*;

public abstract class FenetreChoix extends Frame implements ItemListener
{
	private int 				nbJoueur;
	
	private CheckboxGroup 		cbg;
	private Checkbox			choixNbJoueur;
	
	// titre pour les différentes fenetres
	// ligne pour le nombre de ligne a notre fenetre
	// choix pour savoir s'il y a un choix a faire
	public FenetreChoix(String titre, int ligne, int nbJoueur)
	{
		this.nbJoueur = nbJoueur;
		
		String title = "";
		if (titre.equals("nbJoueur"))
			title = "Initialisation Joueur";

		
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
		
		if (titre.equals("nbJoueur"))
		{
			label = "Combien de joueurs jouent ?(1/4)";
			add(new Label(label));
		}

		cbg 	= new CheckboxGroup();
			
		// initialiser de la liste des nombres de joueurs
		for (int i = 1; i < ligne; i++)
		{
			choixNbJoueur = new Checkbox(String.valueOf(i), cbg, false);
			choixNbJoueur.addItemListener(this);
				add(choixNbJoueur);
		}
		
		pack();
		setVisible(true);	
	}
	
	// accesseur de nbJoueur
	public int getNbJoueur()		{	return nbJoueur;	}
	
	// modificateur de nbJoueur
	public void setNbJoueur(int nbJoueur)	{	this.nbJoueur = nbJoueur;	}
}