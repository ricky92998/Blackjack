package Carte;

import Enum.*;

public class Carte implements Comparable<Carte>
{
	private int 		num;
	private Face 		face;
	private Categorie 	cat;
	
	public Carte(Face face, Categorie cat)
	{
		this.face = face;
		this.cat = cat;
	}

	// accesseur
	public int getNum()					{	return num;		}
	public Categorie getCat()			{	return cat;		}
	public Face	getFace()				{	return face;	}
	
	// modificateur
	public void setNum(int num)			{	this.num = num;	}
	public void setCat(Categorie cat)	{	this.cat = cat;	}
	
	@Override
	public int compareTo(Carte c)
	{
		// TODO Auto-generated method stub
		if (face.equals(c.getFace()))
			if (cat.equals(c.getCat()))
				return 0;
		
		return -1;
	}
	
	@Override
	public String toString() 
	{
		return "Carte [face=" + face + ", cat=" + cat + "]";
	}

	
}