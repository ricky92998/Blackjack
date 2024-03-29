package Fenetre.FenetreBouton;

import java.awt.*;
import java.awt.event.*;

public class FenetreBoutonAction extends FenetreBouton
{
	private String	action;
	private boolean boutonUtilise;
	
	public FenetreBoutonAction(String titre, String nomJoueur, boolean peutDoubler, boolean peutSeparer, boolean peutAssurer)
	{
		super(titre, nomJoueur, peutDoubler, peutSeparer, peutAssurer);
		action = "";
		boutonUtilise = false;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		Button button = (Button) e.getSource();
		if (button.getBackground().equals(Color.green) && !boutonUtilise)
		{
			action = button.getLabel();
			boutonUtilise = true;
		}
	}
	
	public String getAction()
	{
		return action;
	}
}
