package domain;

public class livre1 {
	private String nisbn,titre,auteur;

	public String getNisbn() {
		return nisbn;
	}

	public void setNisbn(String nisbn) {
		this.nisbn = nisbn;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public livre1(String nisbn, String titre, String auteur) {
		this.nisbn = nisbn;
		this.titre = titre;
		this.auteur = auteur;
	}

	
}
