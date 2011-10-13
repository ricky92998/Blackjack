package Fenetre.FenetreBouton;

import java.awt.*;
import java.awt.event.*;
import Blackjack.*;

public abstract class FenetreBouton extends Frame implements ActionListener
{
	private String				nomFenetre;
	private String[][]			tabString = new String[100][100];

	
	private Button				button;
	private Panel				panel;
	private Label				label;
	
	public FenetreBouton(String titre, String nomJoueur, Boolean peutSepare, Boolean peutAssure)
	{
		nomFenetre = titre;
		String title = "";
		
		if (titre.equals("action"))
		{
			String[][] tabAction = {{"Carte", "Rester", "Double", "Partager", "Assurance", "Abandonner" },
									{"true", "true", "true", peutSepare.toString(), peutAssure.toString(), "true"},
								   };
			
			for (int i = 0; i < 6; i++)
				for (int j = 0; j < tabAction.length; j++)
					tabString[j][i] = tabAction[j][i];

			title = "Action - " + nomJoueur;
		}
		
		setTitle(title);
		setLocation(100, 100);
		setSize(500, 100);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setLayout(new GridLayout(2, 1));
		
		panel = new Panel();
		panel.setLayout(new GridLayout());
		for (int i = 0; tabString[0][i] != null; i++)
		{
			if (Boolean.parseBoolean(tabString[1][i]))
			{
				button = new Button(tabString[0][i]);
				button.setBackground(Color.green);
			}
			else
			{
				button = new Button(tabString[0][i]);
				button.setBackground(Color.red);
			}
			button.addActionListener(this);
			panel.add(button);
		}
		add(panel);
		label = new Label();
		add(label);
		
		setVisible(true);
	}
}
