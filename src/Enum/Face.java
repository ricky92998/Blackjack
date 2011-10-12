package Enum;

public enum Face
{
	ROI		(13, 10),
	DAME	(12, 10),
	VALET	(11, 10),
	DIX		(10, 10),
	NEUF	(9, 8),
	HUIT	(8, 8),
	SEPT	(7, 7),
	SIX		(6, 6),
	CINQ	(5, 5),
	QUATRE	(4, 4),
	TROIS	(3, 3),
	DEUX	(2, 2),
	AS		(1, 1);
	
	
	private int numCarte;
	private int nbPoint1;
	private int nbPoint2;
	
	Face(int numCarte, int nbPoint1)
	{
		this.numCarte = numCarte;
		this.nbPoint1 = nbPoint1;
		
		if (numCarte == 1)
			nbPoint2 = 11;
		else
			nbPoint2 = 0;
		
	}

	public int getNumCarte()	{	return numCarte;	}
	public int getNbPoint1()	{	return nbPoint1;	}
	public int getNbPoint2()	{	return nbPoint2;	}
}