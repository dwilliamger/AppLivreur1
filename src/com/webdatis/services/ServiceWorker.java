package com.webdatis.services;

import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONObject;

import android.os.AsyncTask;

public class ServiceWorker extends AsyncTask<Object, Void, Void> {

	ServiceWorkerListener listener;
	String json_result = "";

	@Override
	protected void onPreExecute() {

		super.onPreExecute();
		listener.onPrepareRequest();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Void doInBackground(Object... parameters) {

		HTTPRequester jParser = new HTTPRequester();
		String method = (String) parameters[1];
		String url = (String) parameters[0];
		List<NameValuePair> params = (List<NameValuePair>) parameters[2];
		JSONObject json = jParser.makeHttpRequest(url, method, params);
		json_result = json.toString();
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {

		super.onPostExecute(result);
		listener.onFinishRequestWithJSON(json_result);
	}

}
