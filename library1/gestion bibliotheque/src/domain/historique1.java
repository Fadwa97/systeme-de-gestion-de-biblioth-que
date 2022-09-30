package domain;

public class historique1 {
private String id_exemplaire,titre,id_usager,prenom,date_emprunte,date_retour;

public String getId_exp() {
	return id_exemplaire;
}

public void setId_exp(String id_exp) {
	this.id_exemplaire = id_exp;
}

public String getTitre() {
	return titre;
}

public void setTitre(String titre) {
	this.titre = titre;
}

public String getId_usa() {
	return id_usager;
}

public void setId_usa(String id_usa) {
	this.id_usager = id_usa;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getDatee() {
	return date_emprunte;
}

public void setDatee(String datee) {
	this.date_emprunte = datee;
}

public String getDater() {
	return date_retour;
}

public void setDater(String dater) {
	this.date_retour = dater;
}

public historique1(String id_exp, String titre, String id_usa, String prenom, String datee, String dater) {
	this.id_exemplaire = id_exp;
	this.titre = titre;
	this.id_usager = id_usa;
	this.prenom = prenom;
	this.date_emprunte = datee;
	this.date_retour = dater;
}

}
