package com.webdatis.DBModel;

import java.util.ArrayList;

import com.webdatis.classes.Food;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBFood extends SQLiteOpenHelper {

	SQLiteDatabase bd = this.getWritableDatabase();

	public DBFood(Context context, String name, CursorFactory factory,
			int version) {
		super(context, "food.db", null, 1);

	}

	public DBFood(Context context) {
		// TODO Auto-generated constructor stub
		super(context, "food.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase bdd) {

		bdd.execSQL("create table food (i_id integer primary key autoincrement, "
				+ "s_libelle text not null, "
				+ "s_description text not null), "
				+ " i_qtedispo integer not null);");
		bdd.execSQL("insert into commande values('', 'oeuf sur plat', 'cuit avec feu de bois', 5)");

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

		arg0.execSQL("drop table food");
		onCreate(arg0);

	}

	public void add_food(Food f) {
		SQLiteDatabase bd = this.getWritableDatabase();
		bd.execSQL("insert into food values(' ', '" + f.getS_libelle() + "', '"
				+ f.getS_description() + "', '" + f.getI_qtedispo() + "')");

	}

	public void delete_food(Food fd) {
		SQLiteDatabase bd = this.getWritableDatabase();
		bd.execSQL("delete from food where i_id='" + fd.getI_id() + "'");

	}

	public void modify_food(Food f_) {

		SQLiteDatabase bd = this.getWritableDatabase();

		ContentValues valeurs = new ContentValues();
		valeurs.put("s_libelle", f_.getS_libelle());
		valeurs.put("s_description", f_.getS_description());
		valeurs.put("i_stedispo", f_.getI_qtedispo());
		bd.update("food", valeurs, "i_id = ' " + f_.getI_id() + " '", null);

	}

	public ArrayList<Food> list_food() {
		ArrayList<Food> list = new ArrayList<Food>();

		Cursor cr = bd.rawQuery("select * from food", null);

		while (cr.moveToNext()) {
			Food food = new Food(cr.getInt(0), cr.getString(1),
					cr.getString(2), cr.getInt(3));
			list.add(food);
		}
		;

		return list;
	}

}
