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
		
		sessionExpiryTime = ConfigProperties.getSessionExpiryTime();
	}

											
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
		Integer sessionExpiryTime = ConfigProperties.getSessionExpiryTime();
		
		updateConcurrentSessionObject(key, value , sessionExpiryTime);
		return objectStore.updateObject(key, value , sessionExpiryTime);
	}
	private void updateConcurrentSessionObject(String key, String value, Integer sessionExpiryTime) {
		try {
			JsonObject jsnOBJ = new JsonObject();
			JsonParser jsnParser = new JsonParser();
			JsonElement jsnElmnt = jsnParser.parse(value);
			jsnOBJ = jsnElmnt.getAsJsonObject();
			if (jsnOBJ.has("userName") && jsnOBJ.get("userName") != null) {
				objectStore.updateObject(jsnOBJ.get("userName").getAsString().trim().toLowerCase(), key, sessionExpiryTime);
			}
		} catch (Exception e) {
		}
	}
	public void deleteSessionObject(String key) throws RedisSessionException {
		
		objectStore.deleteObject(key);
	}

	
}
