package com.iemr.mmu.utils.sessionobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.utils.config.ConfigProperties;
import com.iemr.mmu.utils.redis.RedisSessionException;
import com.iemr.mmu.utils.redis.RedisStorage;

@Component
public class SessionObject {
	private RedisStorage objectStore;

	@Autowired
	// @Required
	public void setObjectStore(RedisStorage objectStore) {
		
		this.objectStore = objectStore;
	}

	public SessionObject() {
		
		extendExpirationTime = ConfigProperties.getExtendExpiryTime();
		sessionExpiryTime = ConfigProperties.getSessionExpiryTime();
	}

	private boolean extendExpirationTime;
											
	private int sessionExpiryTime;

	public String getSessionObject(String key) throws RedisSessionException {
		Integer sessionExpiryTime = ConfigProperties.getSessionExpiryTime();
		
		return objectStore.getObject(key, sessionExpiryTime);
	}

	public String setSessionObject(String key, String value) throws RedisSessionException {
		Integer sessionExpiryTime = ConfigProperties.getSessionExpiryTime();
		return objectStore.setObject(key, value, sessionExpiryTime);
	}

	public String updateSessionObject(String key, String value) throws RedisSessionException {
		Boolean extendExpirationTime = ConfigProperties.getExtendExpiryTime();
		Integer sessionExpiryTime = ConfigProperties.getSessionExpiryTime();
		
		updateConcurrentSessionObject(key, value, extendExpirationTime, sessionExpiryTime);
		return objectStore.updateObject(key, value, Boolean.valueOf(extendExpirationTime), sessionExpiryTime);
	}
	private void updateConcurrentSessionObject(String key, String value, Boolean extendExpirationTime,
			Integer sessionExpiryTime) {
		try {
			JsonObject jsnOBJ = new JsonObject();
			JsonParser jsnParser = new JsonParser();
			JsonElement jsnElmnt = jsnParser.parse(value);
			jsnOBJ = jsnElmnt.getAsJsonObject();
			if (jsnOBJ.has("userName") && jsnOBJ.get("userName") != null) {
				objectStore.updateObject(jsnOBJ.get("userName").getAsString().trim().toLowerCase(), key,
						extendExpirationTime, sessionExpiryTime);
			}
		} catch (Exception e) {
		}
	}
	public void deleteSessionObject(String key) throws RedisSessionException {
		
		objectStore.deleteObject(key);
	}

	
}
