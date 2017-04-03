package com.chyme.servicenow.utils;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import com.unvired.chyme.api.ChymeAPI;
import com.unvired.chyme.api.ChymeAPI.ResultStatus;
import com.unvired.chyme.api.Message;
import com.unvired.lib.utility.InfoMessage;
import com.unvired.lib.utility.InfoMessage.InfoMessageCategory;
import com.unvired.lib.utility.InfoMessage.InfoMessageType;

public class ServiceNowUtils {
	
	public static final String NLP_DATE_FORMAT = "yyyyMMdd";
	public static final String SERVER_DATE_FORMAT = "yyyy-MM-dd";
	public static final String CONVERSATION_DATE_FORMAT = "dd-MM-yyyy' 'HH:mm";
	
	public static void setStatusMessage(ChymeAPI chymeAPI, String errorMessage, Vector<FollowUp> followUps, boolean groupBE, boolean useDefaultFollowups, ResultStatus status) {
		
		Message message = null;
		if(followUps != null && !followUps.isEmpty())
			message = new Message(errorMessage, null);
		else {
			message = new Message(errorMessage, null);
			
			if(!useDefaultFollowups)
				message.setFlags(Message.FLAG_NO_FOLLOWUP_COMMAND);
		}
		
		addFollowUps(message, followUps);
		
		if(groupBE)
			message.setFlags(Message.FLAG_GROUP_BE);
		
		chymeAPI.setResultStatus(status);
		chymeAPI.setMessage(message);
	}
	
	public static void addFollowUps(Message message, Vector<FollowUp> followUps) {
		
		if(followUps != null && followUps.size() > 0) {			
			for (FollowUp followup : followUps) {				
				message.addFollowup(followup.getSuggestionText(), followup.getText());
			}
		}
	}
	
	public static String getMessage(String message, Hashtable<String, String> fields) {
		if (fields != null) {
			Enumeration<String> fieldNames = fields.keys();
			while (fieldNames.hasMoreElements()) {
				String fieldName = fieldNames.nextElement();
				String fieldValue = fields.get(fieldName);
				message = message.replace(fieldName, fieldValue);
			}
		}
		return message;
	}
	
	public static String getFormattedIncidentNumber(String incidentNo) {
		
		if(incidentNo != null && !incidentNo.isEmpty())
			incidentNo = incidentNo.toUpperCase();
		
		if(!incidentNo.startsWith(ServiceNowConstants.INCIDENT_NUMBER_PREFIX) || 
				incidentNo.length() != ServiceNowConstants.INCIDENT_NUMBER_PREFIX.length() + ServiceNowConstants.INCIDENT_NUMBER_LENGTH) {
			
			incidentNo = incidentNo.replace(ServiceNowConstants.INCIDENT_NUMBER_PREFIX, "");
			incidentNo = ServiceNowConstants.INCIDENT_NUMBER_PREFIX + ServiceNowUtils.padZeroToNumber(incidentNo, ServiceNowConstants.INCIDENT_NUMBER_LENGTH);
		}
		
		return incidentNo;
	}
	
	public static String padZeroToNumber(String value, int length) {
		String retVal = value;

		try {
			int intVal = Integer.parseInt(value);
			retVal = String.valueOf(intVal);
			if (retVal.length() < length) {
				int padLength = length - retVal.length();
				for (int i = 0; i < padLength; i++) {
					retVal = "0" + retVal;
				}
			}
		} catch (Exception ex) {
			// DO Nothing
		}
		return retVal;
	}
	
	public static Integer getStateCode(String stateValue) {		
		if(stateValue == null) {
			return null;
		}		
		for (int i = 0; i < ServiceNowConstants.SN_STATES.length; i++) {			
			if(ServiceNowConstants.SN_STATES[i].equalsIgnoreCase(stateValue)) {
				return i + 1;
			}
		}		
		return 0;
	}
	
	public static String getStateValue(int stateCode) {	
		String stateValue = "";
		if(stateCode >= 0 && stateCode <= ServiceNowConstants.SN_STATES.length + 1) {
			stateValue = ServiceNowConstants.SN_STATES[stateCode-1];
			return stateValue;
		}
		
		return stateValue;
	}
	
	public static Integer getImpactCode(String impactValue) {		
		if(impactValue == null) {
			return null;
		}		
		for (int i = 0; i < ServiceNowConstants.SN_IMPACTS.length; i++) {
			
			if(ServiceNowConstants.SN_IMPACTS[i].equalsIgnoreCase(impactValue)) {
				return i + 1;
			}
		}		
		return 0;
	}
	
	public static String getImpactValue(int impactCode) {	
		String impactValue = "";
		if(impactCode >= 0 && impactCode <= ServiceNowConstants.SN_IMPACTS.length + 1) {
			impactValue = ServiceNowConstants.SN_IMPACTS[impactCode-1];
			return impactValue;
		}
		
		return impactValue;
	}
	
	public static Integer getPriorityCode(String priorityValue) {		
		if(priorityValue == null) {
			return null;
		}		
		for (int i = 0; i < ServiceNowConstants.SN_PRIORITIES.length; i++) {
			
			if(ServiceNowConstants.SN_PRIORITIES[i].equalsIgnoreCase(priorityValue)) {
				return i + 1;
			}
		}		
		return 0;
	}
	
	public static String getPriorityValue(int priorityCode) {	
		String priorityValue = "";
		if(priorityCode >= 0 && priorityCode <= ServiceNowConstants.SN_PRIORITIES.length + 1) {
			priorityValue = ServiceNowConstants.SN_PRIORITIES[priorityCode-1];
			return priorityValue;
		}
		
		return priorityValue;
	}
	
	public static void handleError(final ChymeAPI chymeAPI, final Throwable e, final Vector<InfoMessage> infoMessages) {
		String msg = e.getMessage() !=null ? e.getMessage() : e.getClass().getName();
		if(!(e instanceof CustomError)) {
			msg = Messages.TECHNICAL_ERROR.replace("$ERROR$", msg); 
		}
		else {
			msg = e.getMessage();
		}
		chymeAPI.setResultStatus(ResultStatus.RETRY);
		chymeAPI.setMessage(new Message(msg, "", Message.FLAG_COMMAND_ERROR | Message.FLAG_NO_FOLLOWUP_COMMAND));
		e.printStackTrace();
		infoMessages.add(new InfoMessage(msg, InfoMessageType.APPLICATION, InfoMessageCategory.FAILURE));
	}
		
	public class CustomError extends Exception
	{

	    private static final long serialVersionUID = 1997753363232807009L;

			public CustomError()
			{
			}

			public CustomError(String message)
			{
				super(message);
			}

			public CustomError(Throwable cause)
			{
				super(cause);
			}

			public CustomError(String message, Throwable cause)
			{
				super(message, cause);
			}

			public CustomError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
			{
				super(message, cause, enableSuppression, writableStackTrace);
			}

	}
}