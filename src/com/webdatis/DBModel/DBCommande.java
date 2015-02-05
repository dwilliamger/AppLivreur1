package com.webdatis.DBModel;

import java.util.ArrayList;

import com.webdatis.classes.Commande;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBCommande extends SQLiteOpenHelper {

	SQLiteDatabase bd = this.getWritableDatabase();

	public DBCommande(Context context, String name, CursorFactory factory,
			int version) {
		super(context, "commande.db", null, 1);

	}

	public DBCommande(Context context) {

		super(context, "commande.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase bdd) {

		bdd.execSQL("create table commande (i_id integer primary key autoincrement, "
				+ "i_idfood integer not null, "
				+ "i_idclient integer not null), "
				+ "i_quantiteplat integer not null), "
				+ "s_qualiteplat text not null);");
		bdd.execSQL("insert into commande values('', 1, 3, 1, 'bonne')");

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

		arg0.execSQL("drop table commande");
		onCreate(arg0);

	}

	public void add_commande(Commande c) {
		SQLiteDatabase bd = this.getWritableDatabase();
		bd.execSQL("insert into commande values(' ', '" + c.getI_idfood()
				+ "', '" + c.getI_idclient() + "', '" + c.getI_quantiteplat()
				+ "', '" + c.getS_qualiteplat() + "')");

	}

	public void delete_commande(Commande cm) {
		SQLiteDatabase bd = this.getWritableDatabase();
		bd.execSQL("delete from commande where i_id='" + cm.getI_id() + "'");

	}

	public void modify_commande(Commande cmd) {

		SQLiteDatabase bd = this.getWritableDatabase();

		ContentValues valeurs = new ContentValues();
		valeurs.put("i_idfood", cmd.getI_idfood());
		valeurs.put("i_idclient", cmd.getI_idclient());
		valeurs.put("i_quantiteplat", cmd.getI_quantiteplat());
		valeurs.put("s_qualiteplat", cmd.getS_qualiteplat());
		bd.update("commande", valeurs, "i_id = '" + cmd.getI_id() + "'", null);

	}

	public ArrayList<Commande> list_commande() {
		ArrayList<Commande> list = new ArrayList<Commande>();

		Cursor cr = bd.rawQuery("select * from commande", null);
		while (cr.moveToNext()) {
			Commande com = new Commande(cr.getInt(0), cr.getInt(1),
					cr.getInt(2), cr.getInt(3), cr.getString(4));
			list.add(com);
		}
		;

		return list;
	}

}
