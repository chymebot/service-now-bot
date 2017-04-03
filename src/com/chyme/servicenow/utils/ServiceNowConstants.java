package com.chyme.servicenow.utils;

public class ServiceNowConstants {	
	
	public static final int INCIDENT_NUMBER_LENGTH = 7; 
	public static final String INCIDENT_NUMBER_PREFIX = "INC";
	
	public static final String[] SN_IMPACTS ={"High", "Medium", "Low"};
	public static final String[] SN_PRIORITIES ={"Critical", "High", "Moderate", "Low", "Planning"};
	public static final String[] SN_STATES ={"New", "Active", "Awaiting Problem", "Awaiting User Info", "Awaiting Evidence", "Resolved", "Closed"};
	
	public static final String INCIDENT_NO_IS_MANDATORY = "Incident Number is mandatory.";
	
	public static final String SYS_ID_IS_MANDATORY = "Sys Id is mandatory.";	
	public static final String INCIDENT_NOT_FOUND = "Incident not found.";	
	
	public static final FollowUp thanksFollowUp = new FollowUp("Thanks", "Thanks");
	
	public static final String ERROR = "error";	
	public static final String DETAIL = "detail";
	public static final String MESSAGE = "message";
}
