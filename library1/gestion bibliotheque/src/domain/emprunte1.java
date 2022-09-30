package domain;

import java.sql.Date;

public class emprunte1 {
private String id_exemplaire,titre,id_usager,prenom,date_emprunte;

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
public String getD() {
	return date_emprunte;
}
public void setD(String d) {
	this.date_emprunte = d;
}
public emprunte1(String id_exp, String titre, String id_usa, String prenom, String d) {
	this.id_exemplaire = id_exp;
	this.titre = titre;
	this.id_usager = id_usa;
	this.prenom = prenom;
	this.date_emprunte= d;
}

}
