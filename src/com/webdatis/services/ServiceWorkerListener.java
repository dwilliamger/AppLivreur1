package com.webdatis.services;

public interface ServiceWorkerListener {
	public void onPrepareRequest();

	public void onFinishRequestWithJSON(String json);
}
