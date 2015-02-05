package com.webdatis.applivreur;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.webdatis.DBModel.DBUserAdapter;
import com.webdatis.services.ServiceWorkerListener;
import com.webdatis.services.Services;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressWarnings("unused")
public class AppLivreurActivity extends Activity implements OnClickListener,
		ServiceWorkerListener {

	Button connecter, contacter;
	EditText usermail, passwords;

	String strEmailAddress;

	final Date date = new Date();
	final String ISO_FORMAT = "yyyyMMdd'T'HHmmss'Z'";
	final SimpleDateFormat sdf = new SimpleDateFormat(ISO_FORMAT);
	final TimeZone utc = TimeZone.getTimeZone("UTC");

	protected static String language = Locale.FRANCE.getLanguage();
	protected static String country = Locale.FRANCE.getCountry().toUpperCase();

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		usermail = (EditText) findViewById(R.id.etMail);
		passwords = (EditText) findViewById(R.id.etPassword);

		connecter = (Button) findViewById(R.id.btConnecter);
		contacter = (Button) findViewById(R.id.btContacter);

		OnClickListener connect = new OnClickListener() {
			public void onClick(View v) {

				sdf.setTimeZone(utc);

				Editable email = usermail.getText();
				Editable password = passwords.getText();
				String authString = email + ":" + password;
				if (email.toString().equals("")) {
					Toast.makeText(getApplicationContext(),
							" le champs adresse email est requis!",
							Toast.LENGTH_SHORT).show();
				} else if (password.toString().equals("")) {
					Toast.makeText(getApplicationContext(),
							" le champs mot de passe est requis!",
							Toast.LENGTH_SHORT).show();
				}

				byte[] authEncBytes = Base64.encode(authString.getBytes(),
						Base64.DEFAULT);
				String authStringEnc = new String(authEncBytes);

				/*
				 * HashMap<String, String> headers = new HashMap<String,
				 * String>(); HashMap<String, String> params = new
				 * HashMap<String, String>(); headers.put("x-fc-datetime",
				 * sdf.format(date)); headers.put("x-fc-api-key", "XXXXXXXX");
				 * headers.put("x­fc­language", " ");
				 * headers.put("x­fc­country", " ");
				 * headers.put("Authorization", "Basic " + authStringEnc);
				 */

			}
		};

		OnClickListener contact = new OnClickListener() {
			public void onClick(View v) {

				Toast.makeText(getApplicationContext(), "Contact foodcheri",
						Toast.LENGTH_LONG).show();

				/*
				 * contacter.setOnClickListener(new OnClickListener() { public
				 * void onClick(View v) { String phoneNumber="1234567890";
				 * Intent i=new
				 * Intent(Intent.ACTION_DIAL,Uri.parse(phoneNumber));
				 * startActivity(i); } });
				 */

			}
		};

		usermail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				String regEx = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
				strEmailAddress = usermail.getText().toString().trim();
				Matcher matcherObj = Pattern.compile(regEx).matcher(
						strEmailAddress);

				if ((!matcherObj.matches()) && (!strEmailAddress.equals(""))) {
					Toast.makeText(getApplicationContext(),
							strEmailAddress + " est invalide mail ",
							Toast.LENGTH_SHORT).show();
				}

			}
		});

		connecter.setOnClickListener(connect);
		contacter.setOnClickListener(contact);

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	public void onPrepareRequest() {
		// TODO Auto-generated method stub

	}

	public void onFinishRequestWithJSON(String json) {
		// TODO Auto-generated method stub

	}

}
