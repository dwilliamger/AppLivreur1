package com.webdatis.classes;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

public class ParseurDeJson {

	public InputStream obtenir_Resultat_Requete(String url,
			List<NameValuePair> params) {

		InputStream is = null;

		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(url);
			httppost.setEntity(new UrlEncodedFormEntity(params));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();

		} catch (Exception e) {
			Log.e("Erreur HTTP",
					"Erreur lors de l'envoi des requetes HTTP/recuperation des reponses HTTP "
							+ e.toString());
		}

		return is;

	}

	private String convertir_En_String(InputStream istr) {

		String result = "";

		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					istr, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;

			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}

			result = sb.toString();

		} catch (Exception e) {
			Log.e("Erreur de concersion",
					"Impossible de convertir le résultat en String :  "
							+ e.toString());
		}

		return result;

	}

	public JSONArray recuperer_Resultat_Requete_Sous_Forme_De_Tableau_JSON(
			String url, List<NameValuePair> params) {

		JSONArray jArray = new JSONArray();
		InputStream is = obtenir_Resultat_Requete(url, params);
		String result = convertir_En_String(is);

		try {

			jArray = new JSONArray(result);

		} catch (Exception e) {
			Log.e("Erreur HTTP",
					"Erreur lors de l'envoi des requetes HTTP/recuperation des reponses HTTP "
							+ e.toString());
		}

		return jArray;

	}

	public int recuperer_Resultat_Requete_Sous_Forme_De_Int(String url,
			List<NameValuePair> params, String nom) {

		int resultat = 0;
		JSONObject jObject = new JSONObject();
		InputStream is = obtenir_Resultat_Requete(url, params);
		String result = convertir_En_String(is);

		try {

			jObject = new JSONObject(result);
			resultat = jObject.getInt(nom);

		} catch (Exception e) {
			Log.e("Erreur HTTP",
					"Erreur lors de l'envoi des requetes HTTP/recuperation des reponses HTTP "
							+ e.toString());
		}

		return resultat;

	}

	public JSONObject recuperer_Resultat_Requete_Sous_Forme_Objet_JSON(
			String url, List<NameValuePair> params) {

		JSONArray jArray = new JSONArray();
		JSONObject jObj = new JSONObject();
		InputStream is = obtenir_Resultat_Requete(url, params);
		String result = convertir_En_String(is);

		try {

			jArray = new JSONArray(result.replace(".0", ""));
			if (jArray.length() == 0)
				jObj = null;
			else {
				jObj = jArray.getJSONObject(0);
			}

		} catch (Exception e) {
			Log.e("Erreur HTTP",
					"Erreur lors de l'envoi des requetes HTTP/recuperation des reponses HTTP "
							+ e.toString());
		}

		return jObj;

	}

}