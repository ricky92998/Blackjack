
public class Carte
{
	int num;
	Categorie cat;
	
	public Carte(int num, Categorie cat)
	{
		this.num = num;
		this.cat = cat;
	}

	// accesseur
	public int getNum()					{	return num;		}
	public Categorie getCat()			{	return cat;		}
	
	// modificateur
	public void setNum(int num)			{	this.num = num;	}
	public void setCat(Categorie cat)	{	this.cat = cat;	}
	
	@Override
	public String toString() 
	{
		return "Carte [num=" + num + ", cat=" + cat + "]";
	}
}