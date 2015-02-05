package com.webdatis.classes;

public class Client {

	public String s_id;
	public String s_nom;
	public String s_prenom;
	public String s_adresse;
	public String s_numtel;

	public Client(String s_id, String s_nom, String s_prenom, String s_adresse,
			String s_numtel) {
		super();
		this.s_id = s_id;
		this.s_nom = s_nom;
		this.s_prenom = s_prenom;
		this.s_adresse = s_adresse;
		this.s_numtel = s_numtel;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getS_nom() {
		return s_nom;
	}

	public void setS_nom(String s_nom) {
		this.s_nom = s_nom;
	}

	public String getS_prenom() {
		return s_prenom;
	}

	public void setS_prenom(String s_prenom) {
		this.s_prenom = s_prenom;
	}

	public String getS_adresse() {
		return s_adresse;
	}

	public void setS_adresse(String s_adresse) {
		this.s_adresse = s_adresse;
	}

	public String getS_numtel() {
		return s_numtel;
	}

	public void setS_numtel(String s_numtel) {
		this.s_numtel = s_numtel;
	}

	@Override
	public String toString() {
		return "Client [s_id=" + s_id + ", s_nom=" + s_nom + ", s_prenom="
				+ s_prenom + ", s_adresse=" + s_adresse + ", s_numtel="
				+ s_numtel + "]";
	}

}
