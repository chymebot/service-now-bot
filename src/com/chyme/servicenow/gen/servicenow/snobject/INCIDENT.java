//	Generated using Unvired Modeller - Build R-4.000.0042
package com.chyme.servicenow.gen.servicenow.snobject;

public class INCIDENT extends SNOBJECT
{
	private static final long serialVersionUID = 1L;

	public static String FIELD_ACTIVE = "active";
	public static String FIELD_ACTIVITY_DUE = "activity_due";
	public static String FIELD_APPROVAL = "approval";
	public static String FIELD_APPROVAL_HISTORY = "approval_history";
	public static String FIELD_APPROVAL_SET = "approval_set";
	public static String FIELD_ASSIGNED_TO = "assigned_to";
	public static String FIELD_ASSIGNMENT_GROUP = "assignment_group";
	public static String FIELD_BUSINESS_DURATION = "business_duration";
	public static String FIELD_BUSINESS_STC = "business_stc";
	public static String FIELD_CALENDAR_DURATION = "calendar_duration";
	public static String FIELD_CALENDAR_STC = "calendar_stc";
	public static String FIELD_CALLER_ID = "caller_id";
	public static String FIELD_CATEGORY = "category";
	public static String FIELD_CAUSED_BY = "caused_by";
	public static String FIELD_CHILD_INCIDENTS = "child_incidents";
	public static String FIELD_CLOSE_CODE = "close_code";
	public static String FIELD_CLOSE_NOTES = "close_notes";
	public static String FIELD_CLOSED_AT = "closed_at";
	public static String FIELD_CLOSED_BY = "closed_by";
	public static String FIELD_CMDB_CI = "cmdb_ci";
	public static String FIELD_COMMENTS = "comments";
	public static String FIELD_COMMENTS_AND_WORK_NOTES = "comments_and_work_notes";
	public static String FIELD_COMPANY = "company";
	public static String FIELD_CONTACT_TYPE = "contact_type";
	public static String FIELD_CORRELATION_DISPLAY = "correlation_display";
	public static String FIELD_CORRELATION_ID = "correlation_id";
	public static String FIELD_DELIVERY_PLAN = "delivery_plan";
	public static String FIELD_DELIVERY_TASK = "delivery_task";
	public static String FIELD_DESCRIPTION = "description";
	public static String FIELD_DUE_DATE = "due_date";
	public static String FIELD_ESCALATION = "escalation";
	public static String FIELD_EXPECTED_START = "expected_start";
	public static String FIELD_FOLLOW_UP = "follow_up";
	public static String FIELD_GROUP_LIST = "group_list";
	public static String FIELD_IMPACT = "impact";
	public static String FIELD_INCIDENT_STATE = "incident_state";
	public static String FIELD_KNOWLEDGE = "knowledge";
	public static String FIELD_LOCATION = "location";
	public static String FIELD_MADE_SLA = "made_sla";
	public static String FIELD_NOTIFY = "notify";
	public static String FIELD_NUMBER = "number";
	public static String FIELD_OPENED_AT = "opened_at";
	public static String FIELD_OPENED_BY = "opened_by";
	public static String FIELD_ORDER = "order";
	public static String FIELD_PARENT = "parent";
	public static String FIELD_PARENT_INCIDENT = "parent_incident";
	public static String FIELD_PRIORITY = "priority";
	public static String FIELD_PROBLEM_ID = "problem_id";
	public static String FIELD_REASSIGNMENT_COUNT = "reassignment_count";
	public static String FIELD_REJECTION_GOTO = "rejection_goto";
	public static String FIELD_REOPEN_COUNT = "reopen_count";
	public static String FIELD_RESOLVED_AT = "resolved_at";
	public static String FIELD_RESOLVED_BY = "resolved_by";
	public static String FIELD_RFC = "rfc";
	public static String FIELD_SEVERITY = "severity";
	public static String FIELD_SHORT_DESCRIPTION = "short_description";
	public static String FIELD_SLA_DUE = "sla_due";
	public static String FIELD_STATE = "state";
	public static String FIELD_SUBCATEGORY = "subcategory";
	public static String FIELD_SYS_CLASS_NAME = "sys_class_name";
	public static String FIELD_SYS_CREATED_BY = "sys_created_by";
	public static String FIELD_SYS_CREATED_ON = "sys_created_on";
	public static String FIELD_SYS_DOMAIN = "sys_domain";
	public static String FIELD_SYS_DOMAIN_PATH = "sys_domain_path";
	public static String FIELD_SYS_ID = "sys_id";
	public static String FIELD_SYS_MOD_COUNT = "sys_mod_count";
	public static String FIELD_SYS_UPDATED_BY = "sys_updated_by";
	public static String FIELD_SYS_UPDATED_ON = "sys_updated_on";
	public static String FIELD_TIME_WORKED = "time_worked";
	public static String FIELD_UPON_APPROVAL = "upon_approval";
	public static String FIELD_UPON_REJECT = "upon_reject";
	public static String FIELD_URGENCY = "urgency";
	public static String FIELD_USER_INPUT = "user_input";
	public static String FIELD_VARIABLES = "variables";
	public static String FIELD_WATCH_LIST = "watch_list";
	public static String FIELD_WF_ACTIVITY = "wf_activity";
	public static String FIELD_WORK_END = "work_end";
	public static String FIELD_WORK_NOTES = "work_notes";
	public static String FIELD_WORK_NOTES_LIST = "work_notes_list";
	public static String FIELD_WORK_START = "work_start";

	public static String[] FIELDS = {FIELD_ACTIVE,FIELD_ACTIVITY_DUE,FIELD_APPROVAL,FIELD_APPROVAL_HISTORY,FIELD_APPROVAL_SET,FIELD_ASSIGNED_TO,FIELD_ASSIGNMENT_GROUP,FIELD_BUSINESS_DURATION,FIELD_BUSINESS_STC,FIELD_CALENDAR_DURATION,FIELD_CALENDAR_STC,FIELD_CALLER_ID,FIELD_CATEGORY,FIELD_CAUSED_BY,FIELD_CHILD_INCIDENTS,FIELD_CLOSE_CODE,FIELD_CLOSE_NOTES,FIELD_CLOSED_AT,FIELD_CLOSED_BY,FIELD_CMDB_CI,FIELD_COMMENTS,FIELD_COMMENTS_AND_WORK_NOTES,FIELD_COMPANY,FIELD_CONTACT_TYPE,FIELD_CORRELATION_DISPLAY,FIELD_CORRELATION_ID,FIELD_DELIVERY_PLAN,FIELD_DELIVERY_TASK,FIELD_DESCRIPTION,FIELD_DUE_DATE,FIELD_ESCALATION,FIELD_EXPECTED_START,FIELD_FOLLOW_UP,FIELD_GROUP_LIST,FIELD_IMPACT,FIELD_INCIDENT_STATE,FIELD_KNOWLEDGE,FIELD_LOCATION,FIELD_MADE_SLA,FIELD_NOTIFY,FIELD_NUMBER,FIELD_OPENED_AT,FIELD_OPENED_BY,FIELD_ORDER,FIELD_PARENT,FIELD_PARENT_INCIDENT,FIELD_PRIORITY,FIELD_PROBLEM_ID,FIELD_REASSIGNMENT_COUNT,FIELD_REJECTION_GOTO,FIELD_REOPEN_COUNT,FIELD_RESOLVED_AT,FIELD_RESOLVED_BY,FIELD_RFC,FIELD_SEVERITY,FIELD_SHORT_DESCRIPTION,FIELD_SLA_DUE,FIELD_STATE,FIELD_SUBCATEGORY,FIELD_SYS_CLASS_NAME,FIELD_SYS_CREATED_BY,FIELD_SYS_CREATED_ON,FIELD_SYS_DOMAIN,FIELD_SYS_DOMAIN_PATH,FIELD_SYS_ID,FIELD_SYS_MOD_COUNT,FIELD_SYS_UPDATED_BY,FIELD_SYS_UPDATED_ON,FIELD_TIME_WORKED,FIELD_UPON_APPROVAL,FIELD_UPON_REJECT,FIELD_URGENCY,FIELD_USER_INPUT,FIELD_VARIABLES,FIELD_WATCH_LIST,FIELD_WF_ACTIVITY,FIELD_WORK_END,FIELD_WORK_NOTES,FIELD_WORK_NOTES_LIST,FIELD_WORK_START};
	public INCIDENT()
	{
	}

	public Boolean getACTIVE(){
		return (Boolean)values.get("active");
	}
	public void setACTIVE(Boolean value){
		values.put("active", value);
	}
	public String getACTIVITY_DUE(){
		return (String)values.get("activity_due");
	}
	public void setACTIVITY_DUE(String value){
		values.put("activity_due", value);
	}
	public String getAPPROVAL(){
		return (String)values.get("approval");
	}
	public void setAPPROVAL(String value){
		values.put("approval", value);
	}
	public String getAPPROVAL_HISTORY(){
		return (String)values.get("approval_history");
	}
	public void setAPPROVAL_HISTORY(String value){
		values.put("approval_history", value);
	}
	public String getAPPROVAL_SET(){
		return (String)values.get("approval_set");
	}
	public void setAPPROVAL_SET(String value){
		values.put("approval_set", value);
	}
	public String getASSIGNED_TO(){
		return (String)values.get("assigned_to");
	}
	public void setASSIGNED_TO(String value){
		values.put("assigned_to", value);
	}
	public String getASSIGNMENT_GROUP(){
		return (String)values.get("assignment_group");
	}
	public void setASSIGNMENT_GROUP(String value){
		values.put("assignment_group", value);
	}
	public String getBUSINESS_DURATION(){
		return (String)values.get("business_duration");
	}
	public void setBUSINESS_DURATION(String value){
		values.put("business_duration", value);
	}
	public Integer getBUSINESS_STC(){
		return (Integer)values.get("business_stc");
	}
	public void setBUSINESS_STC(Integer value){
		values.put("business_stc", value);
	}
	public String getCALENDAR_DURATION(){
		return (String)values.get("calendar_duration");
	}
	public void setCALENDAR_DURATION(String value){
		values.put("calendar_duration", value);
	}
	public Integer getCALENDAR_STC(){
		return (Integer)values.get("calendar_stc");
	}
	public void setCALENDAR_STC(Integer value){
		values.put("calendar_stc", value);
	}
	public String getCALLER_ID(){
		return (String)values.get("caller_id");
	}
	public void setCALLER_ID(String value){
		values.put("caller_id", value);
	}
	public String getCATEGORY(){
		return (String)values.get("category");
	}
	public void setCATEGORY(String value){
		values.put("category", value);
	}
	public String getCAUSED_BY(){
		return (String)values.get("caused_by");
	}
	public void setCAUSED_BY(String value){
		values.put("caused_by", value);
	}
	public Integer getCHILD_INCIDENTS(){
		return (Integer)values.get("child_incidents");
	}
	public void setCHILD_INCIDENTS(Integer value){
		values.put("child_incidents", value);
	}
	public String getCLOSE_CODE(){
		return (String)values.get("close_code");
	}
	public void setCLOSE_CODE(String value){
		values.put("close_code", value);
	}
	public String getCLOSE_NOTES(){
		return (String)values.get("close_notes");
	}
	public void setCLOSE_NOTES(String value){
		values.put("close_notes", value);
	}
	public String getCLOSED_AT(){
		return (String)values.get("closed_at");
	}
	public void setCLOSED_AT(String value){
		values.put("closed_at", value);
	}
	public String getCLOSED_BY(){
		return (String)values.get("closed_by");
	}
	public void setCLOSED_BY(String value){
		values.put("closed_by", value);
	}
	public String getCMDB_CI(){
		return (String)values.get("cmdb_ci");
	}
	public void setCMDB_CI(String value){
		values.put("cmdb_ci", value);
	}
	public String getCOMMENTS(){
		return (String)values.get("comments");
	}
	public void setCOMMENTS(String value){
		values.put("comments", value);
	}
	public String getCOMMENTS_AND_WORK_NOTES(){
		return (String)values.get("comments_and_work_notes");
	}
	public void setCOMMENTS_AND_WORK_NOTES(String value){
		values.put("comments_and_work_notes", value);
	}
	public String getCOMPANY(){
		return (String)values.get("company");
	}
	public void setCOMPANY(String value){
		values.put("company", value);
	}
	public String getCONTACT_TYPE(){
		return (String)values.get("contact_type");
	}
	public void setCONTACT_TYPE(String value){
		values.put("contact_type", value);
	}
	public String getCORRELATION_DISPLAY(){
		return (String)values.get("correlation_display");
	}
	public void setCORRELATION_DISPLAY(String value){
		values.put("correlation_display", value);
	}
	public String getCORRELATION_ID(){
		return (String)values.get("correlation_id");
	}
	public void setCORRELATION_ID(String value){
		values.put("correlation_id", value);
	}
	public String getDELIVERY_PLAN(){
		return (String)values.get("delivery_plan");
	}
	public void setDELIVERY_PLAN(String value){
		values.put("delivery_plan", value);
	}
	public String getDELIVERY_TASK(){
		return (String)values.get("delivery_task");
	}
	public void setDELIVERY_TASK(String value){
		values.put("delivery_task", value);
	}
	public String getDESCRIPTION(){
		return (String)values.get("description");
	}
	public void setDESCRIPTION(String value){
		values.put("description", value);
	}
	public String getDUE_DATE(){
		return (String)values.get("due_date");
	}
	public void setDUE_DATE(String value){
		values.put("due_date", value);
	}
	public Integer getESCALATION(){
		return (Integer)values.get("escalation");
	}
	public void setESCALATION(Integer value){
		values.put("escalation", value);
	}
	public String getEXPECTED_START(){
		return (String)values.get("expected_start");
	}
	public void setEXPECTED_START(String value){
		values.put("expected_start", value);
	}
	public String getFOLLOW_UP(){
		return (String)values.get("follow_up");
	}
	public void setFOLLOW_UP(String value){
		values.put("follow_up", value);
	}
	public String getGROUP_LIST(){
		return (String)values.get("group_list");
	}
	public void setGROUP_LIST(String value){
		values.put("group_list", value);
	}
	public Integer getIMPACT(){
		return (Integer)values.get("impact");
	}
	public void setIMPACT(Integer value){
		values.put("impact", value);
	}
	public Integer getINCIDENT_STATE(){
		return (Integer)values.get("incident_state");
	}
	public void setINCIDENT_STATE(Integer value){
		values.put("incident_state", value);
	}
	public Boolean getKNOWLEDGE(){
		return (Boolean)values.get("knowledge");
	}
	public void setKNOWLEDGE(Boolean value){
		values.put("knowledge", value);
	}
	public String getLOCATION(){
		return (String)values.get("location");
	}
	public void setLOCATION(String value){
		values.put("location", value);
	}
	public Boolean getMADE_SLA(){
		return (Boolean)values.get("made_sla");
	}
	public void setMADE_SLA(Boolean value){
		values.put("made_sla", value);
	}
	public Integer getNOTIFY(){
		return (Integer)values.get("notify");
	}
	public void setNOTIFY(Integer value){
		values.put("notify", value);
	}
	public String getNUMBER(){
		return (String)values.get("number");
	}
	public void setNUMBER(String value){
		values.put("number", value);
	}
	public String getOPENED_AT(){
		return (String)values.get("opened_at");
	}
	public void setOPENED_AT(String value){
		values.put("opened_at", value);
	}
	public String getOPENED_BY(){
		return (String)values.get("opened_by");
	}
	public void setOPENED_BY(String value){
		values.put("opened_by", value);
	}
	public Integer getORDER(){
		return (Integer)values.get("order");
	}
	public void setORDER(Integer value){
		values.put("order", value);
	}
	public String getPARENT(){
		return (String)values.get("parent");
	}
	public void setPARENT(String value){
		values.put("parent", value);
	}
	public String getPARENT_INCIDENT(){
		return (String)values.get("parent_incident");
	}
	public void setPARENT_INCIDENT(String value){
		values.put("parent_incident", value);
	}
	public Integer getPRIORITY(){
		return (Integer)values.get("priority");
	}
	public void setPRIORITY(Integer value){
		values.put("priority", value);
	}
	public String getPROBLEM_ID(){
		return (String)values.get("problem_id");
	}
	public void setPROBLEM_ID(String value){
		values.put("problem_id", value);
	}
	public Integer getREASSIGNMENT_COUNT(){
		return (Integer)values.get("reassignment_count");
	}
	public void setREASSIGNMENT_COUNT(Integer value){
		values.put("reassignment_count", value);
	}
	public String getREJECTION_GOTO(){
		return (String)values.get("rejection_goto");
	}
	public void setREJECTION_GOTO(String value){
		values.put("rejection_goto", value);
	}
	public Integer getREOPEN_COUNT(){
		return (Integer)values.get("reopen_count");
	}
	public void setREOPEN_COUNT(Integer value){
		values.put("reopen_count", value);
	}
	public String getRESOLVED_AT(){
		return (String)values.get("resolved_at");
	}
	public void setRESOLVED_AT(String value){
		values.put("resolved_at", value);
	}
	public String getRESOLVED_BY(){
		return (String)values.get("resolved_by");
	}
	public void setRESOLVED_BY(String value){
		values.put("resolved_by", value);
	}
	public String getRFC(){
		return (String)values.get("rfc");
	}
	public void setRFC(String value){
		values.put("rfc", value);
	}
	public Integer getSEVERITY(){
		return (Integer)values.get("severity");
	}
	public void setSEVERITY(Integer value){
		values.put("severity", value);
	}
	public String getSHORT_DESCRIPTION(){
		return (String)values.get("short_description");
	}
	public void setSHORT_DESCRIPTION(String value){
		values.put("short_description", value);
	}
	public String getSLA_DUE(){
		return (String)values.get("sla_due");
	}
	public void setSLA_DUE(String value){
		values.put("sla_due", value);
	}
	public Integer getSTATE(){
		return (Integer)values.get("state");
	}
	public void setSTATE(Integer value){
		values.put("state", value);
	}
	public String getSUBCATEGORY(){
		return (String)values.get("subcategory");
	}
	public void setSUBCATEGORY(String value){
		values.put("subcategory", value);
	}
	public String getSYS_CLASS_NAME(){
		return (String)values.get("sys_class_name");
	}
	public void setSYS_CLASS_NAME(String value){
		values.put("sys_class_name", value);
	}
	public String getSYS_CREATED_BY(){
		return (String)values.get("sys_created_by");
	}
	public void setSYS_CREATED_BY(String value){
		values.put("sys_created_by", value);
	}
	public String getSYS_CREATED_ON(){
		return (String)values.get("sys_created_on");
	}
	public void setSYS_CREATED_ON(String value){
		values.put("sys_created_on", value);
	}
	public String getSYS_DOMAIN(){
		return (String)values.get("sys_domain");
	}
	public void setSYS_DOMAIN(String value){
		values.put("sys_domain", value);
	}
	public String getSYS_DOMAIN_PATH(){
		return (String)values.get("sys_domain_path");
	}
	public void setSYS_DOMAIN_PATH(String value){
		values.put("sys_domain_path", value);
	}
	public String getSYS_ID(){
		return (String)values.get("sys_id");
	}
	public void setSYS_ID(String value){
		values.put("sys_id", value);
	}
	public Integer getSYS_MOD_COUNT(){
		return (Integer)values.get("sys_mod_count");
	}
	public void setSYS_MOD_COUNT(Integer value){
		values.put("sys_mod_count", value);
	}
	public String getSYS_UPDATED_BY(){
		return (String)values.get("sys_updated_by");
	}
	public void setSYS_UPDATED_BY(String value){
		values.put("sys_updated_by", value);
	}
	public String getSYS_UPDATED_ON(){
		return (String)values.get("sys_updated_on");
	}
	public void setSYS_UPDATED_ON(String value){
		values.put("sys_updated_on", value);
	}
	public String getTIME_WORKED(){
		return (String)values.get("time_worked");
	}
	public void setTIME_WORKED(String value){
		values.put("time_worked", value);
	}
	public String getUPON_APPROVAL(){
		return (String)values.get("upon_approval");
	}
	public void setUPON_APPROVAL(String value){
		values.put("upon_approval", value);
	}
	public String getUPON_REJECT(){
		return (String)values.get("upon_reject");
	}
	public void setUPON_REJECT(String value){
		values.put("upon_reject", value);
	}
	public Integer getURGENCY(){
		return (Integer)values.get("urgency");
	}
	public void setURGENCY(Integer value){
		values.put("urgency", value);
	}
	public String getUSER_INPUT(){
		return (String)values.get("user_input");
	}
	public void setUSER_INPUT(String value){
		values.put("user_input", value);
	}
	public String getVARIABLES(){
		return (String)values.get("variables");
	}
	public void setVARIABLES(String value){
		values.put("variables", value);
	}
	public String getWATCH_LIST(){
		return (String)values.get("watch_list");
	}
	public void setWATCH_LIST(String value){
		values.put("watch_list", value);
	}
	public String getWF_ACTIVITY(){
		return (String)values.get("wf_activity");
	}
	public void setWF_ACTIVITY(String value){
		values.put("wf_activity", value);
	}
	public String getWORK_END(){
		return (String)values.get("work_end");
	}
	public void setWORK_END(String value){
		values.put("work_end", value);
	}
	public String getWORK_NOTES(){
		return (String)values.get("work_notes");
	}
	public void setWORK_NOTES(String value){
		values.put("work_notes", value);
	}
	public String getWORK_NOTES_LIST(){
		return (String)values.get("work_notes_list");
	}
	public void setWORK_NOTES_LIST(String value){
		values.put("work_notes_list", value);
	}
	public String getWORK_START(){
		return (String)values.get("work_start");
	}
	public void setWORK_START(String value){
		values.put("work_start", value);
	}
	public String getKey(){
		return "sys_id";
	}
	public String getObjectName(){
		return "incident";
	}
}