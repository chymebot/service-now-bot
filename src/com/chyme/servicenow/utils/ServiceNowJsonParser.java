package com.chyme.servicenow.utils;

import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ServiceNowJsonParser {	

	public static String getErrorMessage(JsonElement jsonElement) {

		String errorMessage = "";
		JsonObject baseObject = jsonElement.getAsJsonObject();
		if (baseObject != null && baseObject.entrySet() != null) {
			JsonObject baseJSON = baseObject.getAsJsonObject(ServiceNowConstants.ERROR);
			Set<Entry<String, JsonElement>> messageAttibuteEntrySet = baseJSON.entrySet();
			for (Entry<String, JsonElement> messageEntry : messageAttibuteEntrySet) {
				String attributeName = messageEntry.getKey();

				if (ServiceNowConstants.DETAIL.equalsIgnoreCase(attributeName)) {
					JsonElement attibuteJsonObject = (JsonElement) messageEntry.getValue();
					if (!attibuteJsonObject.isJsonNull())
						errorMessage = attibuteJsonObject.getAsString();
				}

				if (ServiceNowConstants.MESSAGE.equalsIgnoreCase(attributeName) && errorMessage.isEmpty()) {
					JsonElement attibuteJsonObject = (JsonElement) messageEntry.getValue();
					if (!attibuteJsonObject.isJsonNull())
						errorMessage = attibuteJsonObject.getAsString();
				}
			}
		}
		return errorMessage;
	}
}