import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class Fenetre extends Frame implements ActionListener, ItemListener
{
	private CheckboxGroup 		cbg;
	
	private Checkbox			choix;	
	private TextField 			saisie1;
	private TextField 			saisie2;
	private TextField 			saisie3;
	private TextField 			saisie4;
	
	private int 				nbJoueur;
	private static int 			joueurInscrit;
	private boolean				use;
	private	ArrayList<String> 	alS;
	
	public Fenetre()
	{
		// pour pas avoir la meme taille que la liste
		nbJoueur = -1;
		joueurInscrit = 0;
		use = false;
		alS = new ArrayList<String>();
		
		setTitle("Initialisation Blackjack");
		setLocation(100, 100);
		
		// permet a la croix d'arreter le programme
		addWindowListener (new WindowAdapter(){
			public void windowClosing (WindowEvent e){
				System.exit(0);
			}
		});
		
		setLayout(new GridLayout(9, 1));
		
		add(new Label("Combien de joueurs jouent ?(1/4)"));
		
		cbg 	= new CheckboxGroup();
		
		// initialiser de la liste des nombres de joueurs
		for (int i = 1; i < 5; i++)
		{
			choix = new Checkbox(String.valueOf(i), cbg, false);
			choix.addItemListener(this);
			add(choix);
		}

		/** initialisation des zones de textes **/
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
	
	public int getNbJoueur() {		return nbJoueur;	}
	public ArrayList<String> getAlS() {		return alS;	}

	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		// TODO Auto-generated method stub
		Checkbox cb = (Checkbox) e.getSource();
		nbJoueur = Integer.parseInt(cb.getLabel());
		if (nbJoueur >= 1 && !use)
		{
			saisie1.setEnabled(true);
			if (nbJoueur >= 2)
			{
				saisie2.setEnabled(true);
				if (nbJoueur >= 3)
				{
					saisie3.setEnabled(true);
					if (nbJoueur == 4)
						saisie4.setEnabled(true);
				}
			}
		}
		use = true;
	}

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
		if (name.equals("textfield0"))
			saisie1.setEnabled(false);
		else if (name.equals("textfield1"))
			saisie2.setEnabled(false);
		else if (name.equals("textfield2"))
			saisie3.setEnabled(false);
		else if (name.equals("textfield3"))
			saisie4.setEnabled(false);
		
		joueurInscrit++;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Fenetre f = new Fenetre();
	}

}
