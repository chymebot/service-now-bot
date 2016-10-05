//	Generated using Unvired Modeller - Build R-4.000.0002
package com.chyme.servicenow.gen.be;

import java.util.ArrayList;

import com.unvired.lib.utility.BusinessEntity;
import com.unvired.lib.utility.Structure;

public class INCIDENT extends BusinessEntity {

	private static final long serialVersionUID = 1L;
	public static final String NAME = "INCIDENT";
	public INCIDENT()
	{
		setName(NAME);
		setHeader(new INCIDENT_HEADER());
	}

	public INCIDENT_HEADER getINCIDENT_HEADER()
	{
		return (INCIDENT_HEADER)super.getHeader();
	}

	public static class INCIDENT_HEADER extends Structure
	{
		private static final long serialVersionUID = 1L;
		public static final String NAME = "INCIDENT_HEADER";

		public static final String FLD_SHORT_DESC = "SHORT_DESC";
		public static final String FLD_NUMBER = "NUMBER";
		public static final String FLD_CATEGORY = "CATEGORY";
		public static final String FLD_IMPACT = "IMPACT";
		public static final String FLD_PRIORITY = "PRIORITY";
		public static final String FLD_STATE = "STATE";
		public static final String FLD_OPENED_DATE = "OPENED_DATE";

		public static final ArrayList<String> FIELDS = new ArrayList<String>();

		static {
			FIELDS.add(FLD_SHORT_DESC);
			FIELDS.add(FLD_NUMBER);
			FIELDS.add(FLD_CATEGORY);
			FIELDS.add(FLD_IMPACT);
			FIELDS.add(FLD_PRIORITY);
			FIELDS.add(FLD_STATE);
			FIELDS.add(FLD_OPENED_DATE);
		}

		public INCIDENT_HEADER()
		{
			setName(NAME);
		}

		public String getSHORT_DESC()
		{
			return getField(FLD_SHORT_DESC);
		}

		public void setSHORT_DESC(String value)
		{
			if(value != null)
				addField(FLD_SHORT_DESC, value);
		}

		public String getNUMBER()
		{
			return getField(FLD_NUMBER);
		}

		public void setNUMBER(String value)
		{
			if(value != null)
				addField(FLD_NUMBER, value);
		}

		public String getCATEGORY()
		{
			return getField(FLD_CATEGORY);
		}

		public void setCATEGORY(String value)
		{
			if(value != null)
				addField(FLD_CATEGORY, value);
		}

		public String getIMPACT()
		{
			return getField(FLD_IMPACT);
		}

		public void setIMPACT(String value)
		{
			if(value != null)
				addField(FLD_IMPACT, value);
		}

		public String getPRIORITY()
		{
			return getField(FLD_PRIORITY);
		}

		public void setPRIORITY(String value)
		{
			if(value != null)
				addField(FLD_PRIORITY, value);
		}

		public String getSTATE()
		{
			return getField(FLD_STATE);
		}

		public void setSTATE(String value)
		{
			if(value != null)
				addField(FLD_STATE, value);
		}

		public String getOPENED_DATE()
		{
			return getField(FLD_OPENED_DATE);
		}

		public void setOPENED_DATE(String value)
		{
			if(value != null)
				addField(FLD_OPENED_DATE, value);
		}

	}
}