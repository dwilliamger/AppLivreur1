package com.webdatis.classes;

public class Commande {

	public int i_id;
	public int i_idfood;
	public int i_idclient;
	public int i_quantiteplat;
	public String s_qualiteplat;

	public Commande(int i_id, int i_idfood, int i_idclient, int i_quantiteplat,
			String s_qualiteplat) {
		super();
		this.i_id = i_id;
		this.i_idfood = i_idfood;
		this.i_idclient = i_idclient;
		this.i_quantiteplat = i_quantiteplat;
		this.s_qualiteplat = s_qualiteplat;
	}

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getI_id() {
		return i_id;
	}

	public void setI_id(int i_id) {
		this.i_id = i_id;
	}

	public int getI_idfood() {
		return i_idfood;
	}

	public void setI_idfood(int i_idfood) {
		this.i_idfood = i_idfood;
	}

	public int getI_idclient() {
		return i_idclient;
	}

	public void setI_idclient(int i_idclient) {
		this.i_idclient = i_idclient;
	}

	public int getI_quantiteplat() {
		return i_quantiteplat;
	}

	public void setI_quantiteplat(int i_quantiteplat) {
		this.i_quantiteplat = i_quantiteplat;
	}

	public String getS_qualiteplat() {
		return s_qualiteplat;
	}

	public void setS_qualiteplat(String s_qualiteplat) {
		this.s_qualiteplat = s_qualiteplat;
	}

	@Override
	public String toString() {
		return "Commande [i_id=" + i_id + ", i_idfood=" + i_idfood
				+ ", i_idclient=" + i_idclient + ", i_quantiteplat="
				+ i_quantiteplat + ", s_qualiteplat=" + s_qualiteplat + "]";
	}

}
