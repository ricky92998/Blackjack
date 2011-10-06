import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Blackjack extends Frame implements ActionListener, ItemListener
{
	private ArrayList<Joueur> 	alJ;
	private Pioche 				pioche;
	private TextField 			saisie;

	private CheckboxGroup 		cbg;
	private Checkbox			choix1;
	private Checkbox			choix2;
	private Checkbox			choix3;
	private Checkbox			choix4;
	
	private static boolean use = false;
	
	public Blackjack()
	{
		alJ = new ArrayList<Joueur>();
		pioche = new Pioche();
		
		initialiser();
	}
	
	public void initialiser()
	{
		for (Categorie cat : Categorie.values())
			for (int i = 0; i < 13; i++)
				pioche.ajouterCarte(new Carte(i, cat));
		
		setTitle("Initialisation Blackjack");
		setLocation(100, 100);
		
		setLayout(new GridLayout(9, 1));
		
		add(new Label("Combien de joueurs jouent ?(1/4)"));
		
		cbg 	= new CheckboxGroup();
		choix1 	= new Checkbox("1", cbg, false);
		choix2 	= new Checkbox("2", cbg, false);
		choix3 	= new Checkbox("3", cbg, false);
		choix4 	= new Checkbox("4", cbg, false);
		
		choix1.addItemListener(this);
		choix2.addItemListener(this);
		choix3.addItemListener(this);
		choix4.addItemListener(this);
		
		add(choix1);
		add(choix2);
		add(choix3);
		add(choix4);
		
		pack();
		setVisible(true);
	}
	
	public void ajouterSaisie(int i)
	{
		setTitle("Initialisation Blackjack");
		setLocation(100, 100);
		for (; i > 0; i--)
		{
			saisie = new TextField();
			saisie.addActionListener(this);
			
			add(saisie);
			pack();
			setVisible(true);
		}
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		Checkbox cb = (Checkbox) e.getSource();
		if (!use)
		{
			if (cb.equals(choix1))
				ajouterSaisie(1);
			else if (cb.equals(choix2))
				ajouterSaisie(2);
			else if (cb.equals(choix3))
				ajouterSaisie(3);
			else if (cb.equals(choix4))
				ajouterSaisie(4);
			use = true;
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		TextField tf = (TextField) e.getSource();
		String nom = tf.getText();
		alJ.add(new Joueur(nom));
		
		dispose();
	}
	
	public String toString()
	{
		String s ="";
		for (Joueur j : alJ)
			s += j.toString() + "\n";
		
		return s;
	}
	
	public static void main(String[] arg)
	{
		Blackjack b = new Blackjack();
		
		try
		{
			Thread.sleep(3000);
		}
		catch (Exception e){}
		
		System.out.println("test");
	}
}
