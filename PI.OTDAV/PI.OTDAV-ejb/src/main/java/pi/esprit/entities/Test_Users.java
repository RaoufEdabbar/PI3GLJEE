package pi.esprit.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Test_Users  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	int id;
	@Column(name = "NOM")
	String nom;
	@Column(name = "PRENOM")
	String prenom;
	@Column(name = "ADRESS_MAIL")
	String adresseMail;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getAdresseMail() {
		return adresseMail;
	}
	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}
	public Test_Users(int id, String nom, String prenom, String adresseMail) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresseMail = adresseMail;
	}

	public Test_Users() {
		super();
		
	}
}
