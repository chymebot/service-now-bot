//	Generated using Unvired Modeller - Build R-4.000.0001
package com.chyme.servicenow.pa;

import java.net.URLEncoder;
import java.util.Vector;

import com.chyme.servicenow.gen.be.INCIDENT;
import com.chyme.servicenow.gen.pa.ABSTRACT_COMMAND_GETINCIDENTS;
import com.chyme.servicenow.utils.ServiceNowParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.unvired.chyme.api.Message;
import com.unvired.ump.agent.IHTTPResponse;

public class COMMAND_GETINCIDENTS extends ABSTRACT_COMMAND_GETINCIDENTS {
	
	private String INSTANCE_WAKEUP_MSG = "Your instance is currently not active. Click More to proceed and wake up the instance.";

	@Override
	public void execute() {

		try {

			String state = inputBE_GetIncidents.getGetIncidents_HEADER().getSTATE();
			String priority = inputBE_GetIncidents.getGetIncidents_HEADER().getPRIORITY();
			String shortDesc = inputBE_GetIncidents.getGetIncidents_HEADER().getSHORT_DESC();

			String queryString = "sysparm_limit=10&sysparm_display_value=all&sysparm_query=";

			if (shortDesc != null && !shortDesc.isEmpty()) {
				String shortDescription = URLEncoder.encode(shortDesc, "UTF-8");
				if (queryString != null && !queryString.isEmpty() && !queryString.endsWith("=")) {
					queryString += "%5Eshort_descriptionSTARTSWITH" + shortDescription;
				} else {
					queryString += "short_descriptionSTARTSWITH" + shortDescription;
				}
			}

			if (state != null && !state.isEmpty() && !state.equals("Default")) {

				if (queryString != null && !queryString.isEmpty() && !queryString.endsWith("=")) {
					queryString += "%5Estate=" + state;
				} else {
					queryString += "state=" + state;
				}
			}

			if (priority != null && !priority.isEmpty() && !priority.equals("Default")) {
				if (queryString != null && !queryString.isEmpty() && !queryString.endsWith("=")) {
					queryString += "%5Epriority=" + priority;
				} else {
					queryString += "priority=" + priority;
				}
			}

			IHTTPResponse httpResponse = GET_INCIDENTS(queryString, null);

			if (httpResponse.isSuccess() && (httpResponse.getCode() == 200 || httpResponse.getCode() == 201)) {

				String queryResult = httpResponse.getMessage();
				System.out.println(queryResult);

				if (queryResult != null && !queryResult.isEmpty() && !queryResult.startsWith("<")) {
					JsonElement responseJSON = new JsonParser().parse(queryResult);
					Vector<INCIDENT> incidentBEs = ServiceNowParser.getIncidents(responseJSON);
					if (incidentBEs != null && incidentBEs.size() > 0) {
						for (INCIDENT incidentBE : incidentBEs) {
							chymeAPI.addBE(incidentBE);							
						}
					}	
					chymeAPI.setMessage(new Message("Incident(s) matching your search criteria are available.", null, Message.FLAG_GROUP_BE));
				} else {
					Message message = new Message(INSTANCE_WAKEUP_MSG, null, Message.FLAG_NO_FOLLOWUP_COMMAND);
					chymeAPI.setMessage(message);
					chymeAPI.addHTML(queryResult);				
					return;
					
				}
			} else {		
				chymeAPI.setMessage(new Message("No Incident found for the criteria.", null, Message.FLAG_NO_FOLLOWUP_COMMAND));
			}
		} catch (Exception e) {
			chymeAPI.setMessage(new Message(e.getMessage(), null, Message.FLAG_NO_FOLLOWUP_COMMAND));		
		}
	}	
}