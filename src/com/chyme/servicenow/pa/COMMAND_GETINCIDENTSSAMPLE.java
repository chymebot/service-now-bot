//	Generated using Unvired Modeller - Build R-4.000.0001
package com.chyme.servicenow.pa;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Hashtable;

import com.chyme.servicenow.gen.pa.ABSTRACT_COMMAND_GETINCIDENTSSAMPLE;
import com.chyme.servicenow.gen.servicenow.snobject.SNOBJECT;
import com.chyme.servicenow.utils.ServiceNowUtils;
import com.unvired.chyme.api.ChymeAPI.ResultStatus;

public class COMMAND_GETINCIDENTSSAMPLE extends ABSTRACT_COMMAND_GETINCIDENTSSAMPLE {
	
	private Hashtable<String, String> fields = new Hashtable<String, String>();
	
	public void execute() {

		try {
			if (inputBE_GetIncidentsSample != null) {						
				getIncidents();			
			}				
		} catch (Throwable e) {
			ServiceNowUtils.handleError(chymeAPI, e, infoMessages);
			e.printStackTrace();
		}
	}

	public void getIncidents() {

		String shortDesc = inputBE_GetIncidentsSample.getGetIncidentsSample_HEADER().getshort_description();
		String impact = inputBE_GetIncidentsSample.getGetIncidentsSample_HEADER().getField("impact");
		String state = inputBE_GetIncidentsSample.getGetIncidentsSample_HEADER().getField("state");
		String number = inputBE_GetIncidentsSample.getGetIncidentsSample_HEADER().getnumber();

		String queryString = "?sysparm_limit=5&sysparm_display_value=all&sysparm_query=";

		if (shortDesc != null && !shortDesc.isEmpty()) {
			String shortDescription = null;
			try {
				shortDescription = URLEncoder.encode(shortDesc, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if (queryString != null && !queryString.isEmpty() && !queryString.endsWith("=")) {
				queryString += "%5Eshort_descriptionSTARTSWITH" + shortDescription;
			} else {
				queryString += "short_descriptionSTARTSWITH" + shortDescription;
			}
		}

		if (state != null && !state.isEmpty()) {

			if (queryString != null && !queryString.isEmpty() && !queryString.endsWith("=")) {
				queryString += "%5Estate=" + state;
			} else {
				queryString += "state=" + state;
			}
		}

		if (impact != null && !impact.isEmpty()) {
			if (queryString != null && !queryString.isEmpty() && !queryString.endsWith("=")) {
				queryString += "%5Eimpact=" + impact;
			} else {
				queryString += "impact=" + impact;
			}
		}

		if (number != null && !number.isEmpty()) {
			number = ServiceNowUtils.getFormattedIncidentNumber(number);
			if (queryString != null && !queryString.isEmpty() && !queryString.endsWith("=")) {
				queryString += "%5Enumber=" + number;
			} else {
				queryString += "number=" + number;
			}
		}

		com.chyme.servicenow.gen.servicenow.snobject.INCIDENT incident = new com.chyme.servicenow.gen.servicenow.snobject.INCIDENT();
		SNOBJECT[] objects = servicenowQuery((SNOBJECT) incident, queryString);
		if (objects != null && objects.length > 0) {
			for (int i = 0; i < objects.length; i++) {
				if (objects[i] instanceof com.chyme.servicenow.gen.servicenow.snobject.INCIDENT) {
					com.chyme.servicenow.gen.servicenow.snobject.INCIDENT incidentObj = (com.chyme.servicenow.gen.servicenow.snobject.INCIDENT) objects[i];
					com.chyme.servicenow.gen.be.INCIDENT incidentBE = mapServicenowToBE(incidentObj);

					String stateValue = ServiceNowUtils.getStateValue(Integer.valueOf(incidentObj.getSTATE()));
					String impactValue = ServiceNowUtils.getImpactValue(Integer.valueOf(incidentObj.getIMPACT()));
					String priorityValue = ServiceNowUtils.getPriorityValue(Integer.valueOf(incidentObj.getPRIORITY()));

					incidentBE.getINCIDENT_HEADER().setstate(stateValue);
					incidentBE.getINCIDENT_HEADER().setimpact(impactValue);
					incidentBE.getINCIDENT_HEADER().setpriority(priorityValue);

					String messageText = ServiceNowUtils.getMessage("Incidents:\nDescription: $short_description$ \nImpact: $impact$ \nState: $state$ \nPriortiy: $priority$ \nNumber: $number$", fields);
					ServiceNowUtils.setStatusMessage(chymeAPI, messageText, null, true, true, ResultStatus.SUCCESS);

					chymeAPI.addBE(incidentBE);
				}
			}
		}
	}
}