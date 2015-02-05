package com.webdatis.applivreur;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class CommandeActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TextView tv = new TextView(this);
		tv.setTextSize(25);
		tv.setGravity(Gravity.CENTER_VERTICAL);
		tv.setText("Commandes");

		setContentView(tv);
	}
}