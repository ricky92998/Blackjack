package Enum;

public enum Categorie
{
	PIQUE("Pique"),
	COEUR("Coeur"),
	CARREAU("Carreau"),
	TREFLE("Trefle");
	
	private String libelle;
	
	Categorie(String libelle)
	{
		this.libelle = libelle;
	}
	
	 public String getLibelle() { return libelle; }
}