//	Generated using Unvired Modeller - Build R-4.000.0042
package com.chyme.servicenow.gen.servicenow.snobject;

public class SNERROR extends SNOBJECT
{
	private static final long serialVersionUID = 1L;

	public static String FIELD_CODE = "Code";
	public static String FIELD_TEXT = "Text";

	public static String[] FIELDS = {FIELD_CODE,FIELD_TEXT};
	public SNERROR()
	{
	}

	public Integer getCODE(){
		return (Integer)values.get("Code");
	}
	public void setCODE(Integer value){
		values.put("Code", value);
	}
	public String getTEXT(){
		return (String)values.get("Text");
	}
	public void setTEXT(String value){
		values.put("Text", value);
	}
	public String getKey(){
		return "Code";
	}
	public String getObjectName(){
		return "SNERROR";
	}
}