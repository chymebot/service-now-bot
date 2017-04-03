package com.chyme.servicenow.utils;

public class Messages {
	
	public static final String TECHNICAL_ERROR = "I am sorry! Some technical issues and I am not able to get this done. You may try again. If its re-occuring, please contact your administrator.\nIssue Detail: $ERROR$.";	
	
	// Add Note to Incident
	public static final String CANNOT_ADD_NOTE_TO_INCIDENT_INPUT_EMPTY = "Provide valid data to add Work Note to Incident.";
	public static final String ADD_NOTE_TO_INCIDENT_SUCCESS = "Work Note added to Incident $NUMBER$ with text '$SHORT_DESC$'.";
	public static final String ADD_NOTE_TO_INCIDENT_FAILURE = "Failed to add Work Note.";
	
	public static final String $SHORT_DESC$ = "$SHORT_DESC$";
	public static final String $NUMBER$ = "$NUMBER$";
		
}