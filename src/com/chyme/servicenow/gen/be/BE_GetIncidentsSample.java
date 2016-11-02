//	Generated using Unvired Modeller - Build R-4.000.0002
package com.chyme.servicenow.gen.be;

import java.util.ArrayList;

import com.unvired.lib.utility.BusinessEntity;
import com.unvired.lib.utility.Structure;

public class BE_GetIncidentsSample extends BusinessEntity {

	private static final long serialVersionUID = 1L;
	public static final String NAME = "BE_GetIncidentsSample";
	public BE_GetIncidentsSample()
	{
		setName(NAME);
		setHeader(new GetIncidentsSample_HEADER());
	}

	public GetIncidentsSample_HEADER getGetIncidentsSample_HEADER()
	{
		return (GetIncidentsSample_HEADER)super.getHeader();
	}

	public static class GetIncidentsSample_HEADER extends Structure
	{
		private static final long serialVersionUID = 1L;
		public static final String NAME = "GetIncidentsSample_HEADER";

		public static final String FLD_SHORT_DESC = "SHORT_DESC";
		public static final String FLD_STATE = "STATE";
		public static final String FLD_PRIORITY = "PRIORITY";

		public static final ArrayList<String> FIELDS = new ArrayList<String>();

		static {
			FIELDS.add(FLD_SHORT_DESC);
			FIELDS.add(FLD_STATE);
			FIELDS.add(FLD_PRIORITY);
		}

		public GetIncidentsSample_HEADER()
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

		public String getSTATE()
		{
			return getField(FLD_STATE);
		}

		public void setSTATE(String value)
		{
			if(value != null)
				addField(FLD_STATE, value);
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

	}
}