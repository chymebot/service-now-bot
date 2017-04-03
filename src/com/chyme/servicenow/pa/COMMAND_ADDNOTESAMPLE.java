//	Generated using Unvired Modeller - Build R-4.000.0039
package com.chyme.servicenow.pa;

import java.util.Hashtable;

import com.chyme.servicenow.gen.pa.ABSTRACT_COMMAND_ADDNOTESAMPLE;
import com.chyme.servicenow.gen.servicenow.snobject.INCIDENT;
import com.chyme.servicenow.gen.servicenow.snobject.SNERROR;
import com.chyme.servicenow.gen.servicenow.snobject.SNOBJECT;
import com.chyme.servicenow.utils.Messages;
import com.chyme.servicenow.utils.ServiceNowConstants;
import com.chyme.servicenow.utils.ServiceNowJsonParser;
import com.chyme.servicenow.utils.ServiceNowUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.unvired.chyme.api.ChymeAPI.ResultStatus;

public class COMMAND_ADDNOTESAMPLE extends ABSTRACT_COMMAND_ADDNOTESAMPLE {
	
	private Hashtable<String, String> fields = new Hashtable<String, String>();
	private String sysId = "";
	private boolean incidentNotFound = false;

	public void execute() {
		try {
			if (inputBE_AddNoteSample == null) {
				ServiceNowUtils.setStatusMessage(chymeAPI, Messages.CANNOT_ADD_NOTE_TO_INCIDENT_INPUT_EMPTY, null, false, false, ResultStatus.FAILURE);				
			} else {	
				
				String incidentNo = inputBE_AddNoteSample.getAddNoteSample_HEADER().getnumber();	
				String noteText = inputBE_AddNoteSample.getAddNoteSample_HEADER().getnote();
				
				if (incidentNo == null || incidentNo.isEmpty()) {
					ServiceNowUtils.setStatusMessage(chymeAPI, ServiceNowConstants.INCIDENT_NO_IS_MANDATORY, null, false, false, ResultStatus.FAILURE);
					return;
				} else {					
					incidentNo = ServiceNowUtils.getFormattedIncidentNumber(incidentNo);
					inputBE_AddNoteSample.getAddNoteSample_HEADER().setnumber(incidentNo);
				}					

				if (sysId == null || sysId.isEmpty()) {
					sysId = getSysId(incidentNo);				
					if (sysId == null || sysId.isEmpty()) {
						if(incidentNotFound) {
							ServiceNowUtils.setStatusMessage(chymeAPI, ServiceNowConstants.INCIDENT_NOT_FOUND, null, false, false, ResultStatus.FAILURE);
						} else {
							ServiceNowUtils.setStatusMessage(chymeAPI, ServiceNowConstants.SYS_ID_IS_MANDATORY, null, false, false, ResultStatus.FAILURE);
						}
						return;
					}
				} 				
				
				SNOBJECT object = serviceNowUpdate(mapPojoToServicenow(inputBE_AddNoteSample), sysId);

				 if (object instanceof INCIDENT) {		
					 
					INCIDENT incident = (INCIDENT) object;
					com.chyme.servicenow.gen.be.INCIDENT incidentBE = mapServicenowToBE(incident);					
					
					String messageText = ServiceNowUtils.getMessage("Work Note added to Incident $number$ with text '" + noteText + "'.", fields);
					ServiceNowUtils.setStatusMessage(chymeAPI, messageText, null, true, true, ResultStatus.SUCCESS);
					chymeAPI.addBE(incidentBE);
					
				} else if (object instanceof SNERROR) {
					SNERROR error = (SNERROR) object;	
					String errorMsg = getErrorMessage(error);
					if(errorMsg != null && !errorMsg.isEmpty()) {
						if(errorMsg.contains("not found")) {
							incidentNotFound = true;
						} else {
							incidentNotFound = false;
						}
					}
					ServiceNowUtils.setStatusMessage(chymeAPI, errorMsg, null, false, false, ResultStatus.FAILURE);
				}
			}
		} catch (Throwable e) {
			ServiceNowUtils.handleError(chymeAPI, e, infoMessages);
			e.printStackTrace();
		}
	}
	
	private String getSysId(String number) {	
		
		String systemId = "";			
		SNOBJECT object = serviceNowGet(mapSysIdPojoToServicenow(inputBE_AddNoteSample));
		
		if (object instanceof INCIDENT) {					
			INCIDENT incident = (INCIDENT) object;
			mapServicenowToBE(incident);			
			systemId = incident.getSYS_ID();	
		} else if (object instanceof SNERROR) {
			SNERROR error = (SNERROR) object;	
			String errorMsg = getErrorMessage(error);	
			ServiceNowUtils.setStatusMessage(chymeAPI, errorMsg, null, false, false, ResultStatus.FAILURE);
		} 	
		
		return systemId;
	}
	
	public com.chyme.servicenow.gen.servicenow.snobject.INCIDENT mapSysIdPojoToServicenow(
			com.chyme.servicenow.gen.be.BE_AddNoteSample pojo) {
		com.chyme.servicenow.gen.servicenow.snobject.INCIDENT entity = new com.chyme.servicenow.gen.servicenow.snobject.INCIDENT();
		com.chyme.servicenow.gen.be.BE_AddNoteSample.AddNoteSample_HEADER header = (com.chyme.servicenow.gen.be.BE_AddNoteSample.AddNoteSample_HEADER) pojo
				.getHeader();

		entity.setNUMBER(header.getnumber());

		return entity;
	}
	
	private String getErrorMessage(SNERROR error) {
		String errorMsg = error.getTEXT();
		if (errorMsg != null && !errorMsg.isEmpty() && errorMsg.startsWith("{")) {
			JsonElement responseJSON = new JsonParser().parse(errorMsg);
			errorMsg = ServiceNowJsonParser.getErrorMessage(responseJSON);
		}
		return errorMsg;
	}	
}