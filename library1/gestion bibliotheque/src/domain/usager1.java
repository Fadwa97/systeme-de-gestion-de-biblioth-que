package domain;

public class usager1 {
private String nabonne,nom,prenom,statut,email;

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getNabonne() {
	return nabonne;
}

public void setNabonne(String nabonne) {
	this.nabonne = nabonne;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getStatut() {
	return statut;
}

public void setStatut(String statut) {
	this.statut = statut;
}

public usager1(String nabonne, String nom, String prenom, String statut,String email) {
	this.nabonne = nabonne;
	this.nom = nom;
	this.prenom = prenom;
	this.statut = statut;
	this.email=email;
}

}
