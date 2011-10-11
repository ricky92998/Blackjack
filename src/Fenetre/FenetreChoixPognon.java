package Fenetre;

import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class FenetreChoixPognon extends Fenetre
{	
	int 				textFieldUsed = 0;
	ArrayList<Integer> alI;
	
	public FenetreChoixPognon(int nbJoueur)
	{
		super("pognon", 5, false);
		super.activerSaisie(nbJoueur);
		
		alI = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> getAlI() {	return alI;		}
	public int getIntAl(int i)	{	return alI.get(i);	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		TextField tf = (TextField) e.getSource();
		String text = tf.getText();
		alI.add(Integer.parseInt(text));
		
		String name = tf.getName();
		
		name = name.substring(0, 9);
		name = name + textFieldUsed;

		super.setTextField(name);
		textFieldUsed++;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e)  // inutile
	{
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new FenetreChoixPognon(2);
	}



}
