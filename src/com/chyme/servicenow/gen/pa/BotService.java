//	Generated using Unvired Modeller - Build R-4.000.0042
package com.chyme.servicenow.gen.pa;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.unvired.chyme.api.ChymeAPI;
import com.unvired.lib.utility.InfoMessage;
import com.unvired.lib.utility.InfoMessage.InfoMessageCategory;
import com.unvired.ump.agent.IBusinessProcess;
import com.unvired.ump.agent.IBusinessProcess.RequestType;
import com.unvired.ump.agent.IHTTPRequest;
import com.unvired.ump.agent.IHTTPResponse;
import com.unvired.ump.agent.IProcessAgent;
import com.unvired.ump.agent.InvalidOutput;

public abstract class BotService implements IProcessAgent {
	protected Vector<InfoMessage> infoMessages;
	protected IBusinessProcess process;
	protected ChymeAPI chymeAPI;

	public void init(IBusinessProcess process) {
		this.process = process;
		infoMessages = new Vector<InfoMessage>();
		chymeAPI = new ChymeAPI(process);
	}

	public void finish() {
		try {
			process.setOutput(chymeAPI.getBusinessEntityOutput(), null);
		} catch (InvalidOutput e) {
			process.getInfoMessageList().add(new InfoMessage(e.getMessage(), InfoMessageCategory.FAILURE));
		}
	}

	protected void addParameter(Hashtable<String, String> parameters, String name, String value, String defaultValue) {
		if (!isEmpty(name)) {
			if (!isEmpty(value))
				parameters.put(name, value);
			else if (!isEmpty(defaultValue))
				parameters.put(name, defaultValue);
		}
	}

	protected boolean isEmpty(String value) {
		return (value == null || value.trim().isEmpty());
	}

	static final String AUTHORIZATION = "Basic YWRtaW46Q2h5bWVAMDI=";
	static final String VERSION = "/v1";
	static final String TABLE_NAME = "@TABLE@";
	static final String QUERY_STRING = "@QUERY@";
	static final String SYS_ID = "@SYS_ID@";

	static final String DISPLAY_VALUE = "?sysparm_display_value=all";

	static final String CREATE = "/api/now" + VERSION + "/table/" + TABLE_NAME + DISPLAY_VALUE;
	static final String UPDATE = "/api/now" + VERSION + "/table/" + TABLE_NAME + "/" + SYS_ID + DISPLAY_VALUE;
	static final String DELETE = "/api/now" + VERSION + "/table/" + TABLE_NAME + "/" + SYS_ID;
	static final String GET = "/api/now" + VERSION + "/table/" + TABLE_NAME + QUERY_STRING;
	static final String QUERY = "/api/now" + VERSION + "/table/" + TABLE_NAME + QUERY_STRING;

	public com.chyme.servicenow.gen.servicenow.snobject.SNOBJECT serviceNowCreate(
			com.chyme.servicenow.gen.servicenow.snobject.SNOBJECT snObject) {
		IHTTPRequest httpRequest = (IHTTPRequest) process.createRequest(RequestType.HTTP);

		//	Verb
		httpRequest.setVerb(IHTTPRequest.HTTPVerb.POST);

		//	Path
		String path = CREATE.replaceAll(TABLE_NAME, snObject.getObjectName());

		httpRequest.setPath(path);

		//	Header
		Hashtable<String, String> headers = new Hashtable<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", AUTHORIZATION);
		httpRequest.setHeaders(headers);

		//	Body
		httpRequest.setMessageBody(snObject.getJson());

		//	Execute
		IHTTPResponse httpResponse = (IHTTPResponse) process.getService().submitRequest(httpRequest,
				Constant.SERVICENOW_SAMPLE_SERVICENOW_SAMPLE_SERVICE_NOW_SERVICENOW_EXECUTE);

		return getSNOBJECTFromResponse(httpResponse, snObject);
	}

	public com.chyme.servicenow.gen.servicenow.snobject.SNOBJECT serviceNowUpdate(
			com.chyme.servicenow.gen.servicenow.snobject.SNOBJECT snObject, String sys_id) {
		IHTTPRequest httpRequest = (IHTTPRequest) process.createRequest(RequestType.HTTP);

		//	Verb
		httpRequest.setVerb(IHTTPRequest.HTTPVerb.PATCH);

		//	Path
		String path = UPDATE.replaceAll(TABLE_NAME, snObject.getObjectName());
		path = path.replaceAll(SYS_ID, sys_id);
		httpRequest.setPath(path);

		//	Header
		Hashtable<String, String> headers = new Hashtable<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", AUTHORIZATION);
		httpRequest.setHeaders(headers);

		//	Body
		snObject.setValue(snObject.getKey(), null);
		httpRequest.setMessageBody(snObject.getJson());

		//	Execute
		IHTTPResponse httpResponse = (IHTTPResponse) process.getService().submitRequest(httpRequest,
				Constant.SERVICENOW_SAMPLE_SERVICENOW_SAMPLE_SERVICE_NOW_SERVICENOW_EXECUTE);

		return getSNOBJECTFromResponse(httpResponse, snObject);
	}

	public IHTTPResponse serviceNowDelete(com.chyme.servicenow.gen.servicenow.snobject.SNOBJECT snObject,
			String sys_id) {
		IHTTPRequest httpRequest = (IHTTPRequest) process.createRequest(RequestType.HTTP);

		//	Verb
		httpRequest.setVerb(IHTTPRequest.HTTPVerb.DELETE);

		//	Path
		String path = DELETE.replaceAll(TABLE_NAME, snObject.getObjectName());
		path = path.replaceAll(SYS_ID, sys_id);
		httpRequest.setPath(path);

		//	Header
		Hashtable<String, String> headers = new Hashtable<String, String>();
		headers.put("Authorization", AUTHORIZATION);
		httpRequest.setHeaders(headers);

		//	Body
		httpRequest.setMessageBody(snObject.getJson());

		//	Execute
		IHTTPResponse httpResponse = (IHTTPResponse) process.getService().submitRequest(httpRequest,
				Constant.SERVICENOW_SAMPLE_SERVICENOW_SAMPLE_SERVICE_NOW_SERVICENOW_EXECUTE);
		return httpResponse;
	}

	public com.chyme.servicenow.gen.servicenow.snobject.SNOBJECT serviceNowGet(
			com.chyme.servicenow.gen.servicenow.snobject.SNOBJECT snObject) {
		IHTTPResponse httpResponse = null;
		try {
			IHTTPRequest httpRequest = (IHTTPRequest) process.createRequest(RequestType.HTTP);

			StringBuilder query = new StringBuilder();
			query.append(DISPLAY_VALUE + "&sysparm_query=");

			JsonObject jsonObject = new JsonParser().parse(snObject.getJson()).getAsJsonObject();

			for (java.util.Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
				if (entry.getValue() != null && !"".equals(entry.getValue().getAsString())) {
					if (!query.toString().endsWith("=")) {
						query.append("^");
					}
					query.append(entry.getKey());
					query.append("=");
					query.append(entry.getValue().getAsString());
				}
			}

			//	Verb
			httpRequest.setVerb(IHTTPRequest.HTTPVerb.GET);

			//	Path
			String path = GET.replaceAll(TABLE_NAME, snObject.getObjectName());
			path = path.replaceAll(QUERY_STRING, query.toString());
			httpRequest.setPath(path);

			//	Header
			Hashtable<String, String> headers = new Hashtable<String, String>();
			headers.put("Content-Type", "application/json");
			headers.put("Authorization", AUTHORIZATION);
			httpRequest.setHeaders(headers);

			//	Execute
			httpResponse = (IHTTPResponse) process.getService().submitRequest(httpRequest,
					Constant.SERVICENOW_SAMPLE_SERVICENOW_SAMPLE_SERVICE_NOW_SERVICENOW_EXECUTE);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return getSNOBJECTFromResponse(httpResponse, snObject);
	}

	private com.chyme.servicenow.gen.servicenow.snobject.SNOBJECT getSNOBJECTFromResponse(IHTTPResponse httpResponse,
			com.chyme.servicenow.gen.servicenow.snobject.SNOBJECT snObject) {

		try {
			if (httpResponse == null) {
				return null;
			}

			switch (httpResponse.getCode()) {
			case 200:
			case 201:
			case 204:

				if (httpResponse.getMessage() != null && !httpResponse.getMessage().isEmpty()
						&& !httpResponse.getMessage().startsWith("<")) {
					JsonObject jsonObject = (JsonObject) new JsonParser().parse(httpResponse.getMessage());
					JsonElement element = jsonObject.get("result");

					if (element.isJsonArray()) {
						JsonArray array = element.getAsJsonArray();
						snObject.load(array.get(0).getAsJsonObject().toString());

					} else if (element.isJsonObject()) {
						snObject.load(element.getAsJsonObject().toString());
					}
				} else {
					snObject = new com.chyme.servicenow.gen.servicenow.snobject.SNERROR();
					snObject.setValue("Code", httpResponse.getCode());

					if (httpResponse.getMessage() != null && !httpResponse.getMessage().isEmpty()) {
						snObject.setValue("Text", httpResponse.getMessage());
					} else {
						snObject.setValue("Text", httpResponse.getInfoMessages().get(0).getMessage());
					}
				}

				break;

			case 400:
			case 401:
			case 403:
			case 404:
			case 405:
			default:
				snObject = new com.chyme.servicenow.gen.servicenow.snobject.SNERROR();
				snObject.setValue("Code", httpResponse.getCode());

				if (httpResponse.getMessage() != null && !httpResponse.getMessage().isEmpty()) {
					snObject.setValue("Text", httpResponse.getMessage());
				} else {
					snObject.setValue("Text", httpResponse.getInfoMessages().get(0).getMessage());
				}
				break;

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			snObject = new com.chyme.servicenow.gen.servicenow.snobject.SNERROR();
			snObject.setValue("Code", 500);
			snObject.setValue("Text", e.getMessage());
		}

		return snObject;

	}

	public com.chyme.servicenow.gen.servicenow.snobject.SNOBJECT[] servicenowQuery(
			com.chyme.servicenow.gen.servicenow.snobject.SNOBJECT snObject, String query) {
		IHTTPResponse httpResponse = null;
		try {
			IHTTPRequest httpRequest = (IHTTPRequest) process.createRequest(RequestType.HTTP);

			//	Verb
			httpRequest.setVerb(IHTTPRequest.HTTPVerb.GET);

			//	Path
			String path = QUERY.replaceAll(TABLE_NAME, snObject.getObjectName());
			path = path.replaceAll(QUERY_STRING, query);
			httpRequest.setPath(path);

			//	Header
			Hashtable<String, String> headers = new Hashtable<String, String>();
			headers.put("Content-Type", "application/json");
			headers.put("Authorization", AUTHORIZATION);
			httpRequest.setHeaders(headers);

			//	Execute
			httpResponse = (IHTTPResponse) process.getService().submitRequest(httpRequest,
					Constant.SERVICENOW_SAMPLE_SERVICENOW_SAMPLE_SERVICE_NOW_SERVICENOW_EXECUTE);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return servicenowGetObjectsFromQuery(httpResponse, snObject);
	}

	private com.chyme.servicenow.gen.servicenow.snobject.SNOBJECT[] servicenowGetObjectsFromQuery(
			IHTTPResponse httpResponse, com.chyme.servicenow.gen.servicenow.snobject.SNOBJECT snObject) {

		String queryResult = null;

		try {

			if (httpResponse == null) {
				return null;
			}

			switch (httpResponse.getCode()) {
			case 200:
			case 201:
			case 204:
				queryResult = httpResponse.getMessage();

				break;

			case 400:
			case 401:
			case 403:
			case 404:
			case 405:
			default:
				snObject = new com.chyme.servicenow.gen.servicenow.snobject.SNERROR();
				snObject.setValue("Code", httpResponse.getCode());

				if (httpResponse.getMessage() != null && !httpResponse.getMessage().isEmpty()) {
					snObject.setValue("Text", httpResponse.getMessage());
				} else {
					snObject.setValue("Text", httpResponse.getInfoMessages().get(0).getMessage());
				}

				return new com.chyme.servicenow.gen.servicenow.snobject.SNOBJECT[] { snObject };
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			snObject = new com.chyme.servicenow.gen.servicenow.snobject.SNERROR();
			snObject.setValue("Code", 500);
			snObject.setValue("Text", e.getMessage());

			return new com.chyme.servicenow.gen.servicenow.snobject.SNOBJECT[] { snObject };
		}

		ArrayList<com.chyme.servicenow.gen.servicenow.snobject.SNOBJECT> results = new ArrayList<com.chyme.servicenow.gen.servicenow.snobject.SNOBJECT>();

		try {
			JsonObject resultObject = (JsonObject) new JsonParser().parse(queryResult);
			JsonArray sObjects = (JsonArray) resultObject.get("result");

			if (sObjects != null) {
				for (int i = 0; i < sObjects.size(); i++) {
					snObject = snObject.getClass().newInstance();
					snObject.load(new Gson().toJson(sObjects.get(i)));
					results.add(snObject);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return results.toArray(new com.chyme.servicenow.gen.servicenow.snobject.SNOBJECT[] {});
	}

}
