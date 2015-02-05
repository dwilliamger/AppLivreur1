package com.webdatis.classes;

public class Food {

	public int i_id;
	public String s_libelle;
	public String s_description;
	public int i_qtedispo;

	public Food(int i_id, String s_libelle, String s_description, int i_qtedispo) {
		super();
		this.i_id = i_id;
		this.s_libelle = s_libelle;
		this.s_description = s_description;
		this.i_qtedispo = i_qtedispo;
	}

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getI_id() {
		return i_id;
	}

	public void setI_id(int i_id) {
		this.i_id = i_id;
	}

	public String getS_libelle() {
		return s_libelle;
	}

	public void setS_libelle(String s_libelle) {
		this.s_libelle = s_libelle;
	}

	public String getS_description() {
		return s_description;
	}

	public void setS_description(String s_description) {
		this.s_description = s_description;
	}

	public int getI_qtedispo() {
		return i_qtedispo;
	}

	public void setI_qtedispo(int i_qtedispo) {
		this.i_qtedispo = i_qtedispo;
	}

	@Override
	public String toString() {
		return "Food [i_id=" + i_id + ", s_libelle=" + s_libelle
				+ ", s_description=" + s_description + ", i_qtedispo="
				+ i_qtedispo + "]";
	}

}
