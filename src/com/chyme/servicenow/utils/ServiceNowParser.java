package com.chyme.servicenow.utils;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

import com.chyme.servicenow.gen.be.INCIDENT;
import com.chyme.servicenow.gen.be.INCIDENT.INCIDENT_HEADER;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.unvired.lib.utility.Structure;

public class ServiceNowParser {
	
	public static Vector<INCIDENT> getIncident(JsonElement jsonElement, Hashtable<String, String> fields) {
		Vector<INCIDENT> incidents = new Vector<INCIDENT>();
		JsonObject baseObject = jsonElement.getAsJsonObject();
		if (baseObject != null && baseObject.entrySet() != null) {			
			Set<Entry<String, JsonElement>> entrySet = baseObject.entrySet();
			for (Entry<String, JsonElement> entry : entrySet) {
				String attributeName = entry.getKey();
				if (ServiceNowConstants.RESULT.equalsIgnoreCase(attributeName)) {
					JsonObject baseObject1 = (JsonObject) entry.getValue();					
					Set<Entry<String, JsonElement>> assetAttibuteEntrySet = baseObject1.entrySet();
					INCIDENT incidentBE = new INCIDENT();
					INCIDENT_HEADER incidentHeader = incidentBE.getINCIDENT_HEADER();
					incidents.add(incidentBE);
					addIncidentFieldsToStructure(assetAttibuteEntrySet, INCIDENT_HEADER.FIELDS, incidentBE, incidentHeader);
				}
			}
		}
		return incidents;
	}

	public static Vector<INCIDENT> getIncidents(JsonElement jsonElement) {
		Vector<INCIDENT> incidents = new Vector<INCIDENT>();
		JsonObject baseObject = jsonElement.getAsJsonObject();
		if (baseObject != null && baseObject.entrySet() != null) {

			JsonArray jsonArray = baseObject.get(ServiceNowConstants.RESULT).getAsJsonArray();

			if (jsonArray != null && jsonArray.size() > 0) {
				for (int i = 0; i < jsonArray.size(); i++) {
					JsonObject baseObject1 = jsonArray.get(i).getAsJsonObject();
					Set<Entry<String, JsonElement>> assetAttibuteEntrySet = baseObject1.entrySet();

					INCIDENT incidentBE = new INCIDENT();
					INCIDENT_HEADER incidentHeader = incidentBE.getINCIDENT_HEADER();
					incidents.add(incidentBE);
					addIncidentFieldsToStructure(assetAttibuteEntrySet, INCIDENT_HEADER.FIELDS, incidentBE, incidentHeader);
				}
			}
		}
		return incidents;
	}

	private static void addIncidentFieldsToStructure(Set<Entry<String, JsonElement>> attibuteEntrySet,
			ArrayList<String> fields, INCIDENT incidentBE, Structure structure) {

		for (Entry<String, JsonElement> attributeEntry : attibuteEntrySet) {

			String attributeName = attributeEntry.getKey();

			if (ServiceNowConstants.NUMBER.equalsIgnoreCase(attributeName)) {
				JsonObject numberObj = (JsonObject) attributeEntry.getValue();
				Set<Entry<String, JsonElement>> numberAttibuteEntrySet = numberObj.entrySet();
				for (Entry<String, JsonElement> numberEntry : numberAttibuteEntrySet) {
					String numberAttributeName = numberEntry.getKey();
					if (ServiceNowConstants.DISPLAY_VALUE.equalsIgnoreCase(numberAttributeName)) {
						JsonElement attibuteJsonObject = (JsonElement) numberEntry.getValue();
						if (!attibuteJsonObject.isJsonNull()) {
							String attributeValue = attibuteJsonObject.getAsString();
							if (attributeValue != null && !attributeValue.isEmpty()) {
								structure.addField(INCIDENT_HEADER.FLD_NUMBER, attributeValue);								
							}
						}
					}
				}
			} else if (ServiceNowConstants.CATEGORY.equalsIgnoreCase(attributeName)) {
				JsonObject categoryObj = (JsonObject) attributeEntry.getValue();
				Set<Entry<String, JsonElement>> categoryAttibuteEntrySet = categoryObj.entrySet();
				for (Entry<String, JsonElement> categoryEntry : categoryAttibuteEntrySet) {
					String categoryAttributeName = categoryEntry.getKey();
					if (ServiceNowConstants.DISPLAY_VALUE.equalsIgnoreCase(categoryAttributeName)) {
						JsonElement attibuteJsonObject = (JsonElement) categoryEntry.getValue();
						if (!attibuteJsonObject.isJsonNull()) {
							String attributeValue = attibuteJsonObject.getAsString();
							if (attributeValue != null && !attributeValue.isEmpty())
								structure.addField(INCIDENT_HEADER.FLD_CATEGORY, attributeValue);
						}
					}
				}
			} else if (ServiceNowConstants.IMPACT.equalsIgnoreCase(attributeName)) {
				JsonObject impactObj = (JsonObject) attributeEntry.getValue();
				Set<Entry<String, JsonElement>> impactAttibuteEntrySet = impactObj.entrySet();
				for (Entry<String, JsonElement> impactEntry : impactAttibuteEntrySet) {
					String impactAttributeName = impactEntry.getKey();
					if (ServiceNowConstants.DISPLAY_VALUE.equalsIgnoreCase(impactAttributeName)) {
						JsonElement attibuteJsonObject = (JsonElement) impactEntry.getValue();
						if (!attibuteJsonObject.isJsonNull()) {
							String attributeValue = attibuteJsonObject.getAsString();
							if (attributeValue != null && !attributeValue.isEmpty()) {
								structure.addField(INCIDENT_HEADER.FLD_IMPACT, attributeValue);								
							}
						}
					}
				}
			} else if (ServiceNowConstants.PRIORITY.equalsIgnoreCase(attributeName)) {
				JsonObject priorityObj = (JsonObject) attributeEntry.getValue();
				Set<Entry<String, JsonElement>> priorityAttibuteEntrySet = priorityObj.entrySet();
				for (Entry<String, JsonElement> priorityEntry : priorityAttibuteEntrySet) {
					String priorityAttributeName = priorityEntry.getKey();
					if (ServiceNowConstants.DISPLAY_VALUE.equalsIgnoreCase(priorityAttributeName)) {
						JsonElement attibuteJsonObject = (JsonElement) priorityEntry.getValue();
						if (!attibuteJsonObject.isJsonNull()) {
							String attributeValue = attibuteJsonObject.getAsString();
							if (attributeValue != null && !attributeValue.isEmpty())
								structure.addField(INCIDENT_HEADER.FLD_PRIORITY, attributeValue);
						}
					}
				}
			} else if (ServiceNowConstants.STATE.equalsIgnoreCase(attributeName)) {
				JsonObject stateObj = (JsonObject) attributeEntry.getValue();
				Set<Entry<String, JsonElement>> stateAttibuteEntrySet = stateObj.entrySet();
				for (Entry<String, JsonElement> stateEntry : stateAttibuteEntrySet) {
					String stateAttributeName = stateEntry.getKey();
					if (ServiceNowConstants.DISPLAY_VALUE.equalsIgnoreCase(stateAttributeName)) {
						JsonElement attibuteJsonObject = (JsonElement) stateEntry.getValue();
						if (!attibuteJsonObject.isJsonNull()) {
							String attributeValue = attibuteJsonObject.getAsString();
							if (attributeValue != null && !attributeValue.isEmpty()) {
								structure.addField(INCIDENT_HEADER.FLD_STATE, attributeValue);								
							}
						}
					}
				}
			} else if (ServiceNowConstants.OPENED_DATE.equalsIgnoreCase(attributeName)) {
				JsonObject openedDateObj = (JsonObject) attributeEntry.getValue();
				Set<Entry<String, JsonElement>> openedDateAttibuteEntrySet = openedDateObj.entrySet();
				for (Entry<String, JsonElement> openedDateEntry : openedDateAttibuteEntrySet) {
					String openedDateAttributeName = openedDateEntry.getKey();
					if (ServiceNowConstants.DISPLAY_VALUE.equalsIgnoreCase(openedDateAttributeName)) {
						JsonElement attibuteJsonObject = (JsonElement) openedDateEntry.getValue();
						if (!attibuteJsonObject.isJsonNull()) {							
							String attributeValue = "";
							if (!attibuteJsonObject.isJsonNull()) {
								String date[] = attibuteJsonObject.getAsString().split(" ");
								attributeValue = date[0];							
							}						
							if (attributeValue != null && !attributeValue.isEmpty())
								structure.addField(INCIDENT_HEADER.FLD_OPENED_DATE, attributeValue);							
						}						
					}
				}
			} else if (ServiceNowConstants.SHORT_DESC.equalsIgnoreCase(attributeName)) {
				JsonObject shortDescObj = (JsonObject) attributeEntry.getValue();
				Set<Entry<String, JsonElement>> shortDescAttibuteEntrySet = shortDescObj.entrySet();
				for (Entry<String, JsonElement> shortDescEntry : shortDescAttibuteEntrySet) {
					String shortDescAttributeName = shortDescEntry.getKey();
					if (ServiceNowConstants.DISPLAY_VALUE.equalsIgnoreCase(shortDescAttributeName)) {
						JsonElement attibuteJsonObject = (JsonElement) shortDescEntry.getValue();
						if (!attibuteJsonObject.isJsonNull()) {
							String attributeValue = attibuteJsonObject.getAsString();
							if (attributeValue != null && !attributeValue.isEmpty()) {
								structure.addField(INCIDENT_HEADER.FLD_SHORT_DESC, attributeValue);								
							}
						}
					}
				}
			}   
		}
	}	
	
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
			}
		}
		return errorMessage;
	}
}