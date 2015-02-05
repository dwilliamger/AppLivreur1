package com.webdatis.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.webdatis.config.Method;

public class Services {

	@SuppressWarnings("rawtypes")
	public static List<NameValuePair> nameValuePairsFromHashMap(
			HashMap<String, String> hash) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		Set set = hash.entrySet();
		Iterator i = set.iterator();
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			params.add(new BasicNameValuePair(me.getKey().toString(), me
					.getValue().toString()));
		}
		return params;
	}

	public static void getJSONFromUrl(String url,
			HashMap<String, String> params, ServiceWorkerListener listener) {
		List<NameValuePair> parameters = nameValuePairsFromHashMap(params);
		ServiceWorker worker = new ServiceWorker();
		worker.listener = listener;
		worker.execute(url, Method.GET, parameters);
	}

	public static void postToUrl(String url, HashMap<String, String> params,
			ServiceWorkerListener listener) {
		List<NameValuePair> parameters = nameValuePairsFromHashMap(params);
		ServiceWorker worker = new ServiceWorker();
		worker.listener = listener;
		worker.execute(url, Method.POST, parameters);
	}

}
