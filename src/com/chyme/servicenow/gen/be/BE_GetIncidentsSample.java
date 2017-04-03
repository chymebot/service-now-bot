//	Generated using Unvired Modeller - Build R-4.000.0042
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

		public static final String FLD_short_description = "short_description";
		public static final String FLD_impact = "impact";
		public static final String FLD_state = "state";
		public static final String FLD_number = "number";

		public static final ArrayList<String> FIELDS = new ArrayList<String>();

		static {
			FIELDS.add(FLD_short_description);
			FIELDS.add(FLD_impact);
			FIELDS.add(FLD_state);
			FIELDS.add(FLD_number);
		}

		public GetIncidentsSample_HEADER()
		{
			setName(NAME);
		}

		public String getshort_description()
		{
			return getField(FLD_short_description);
		}

		public void setshort_description(String value)
		{
			if(value != null)
				addField(FLD_short_description, value);
		}

		public Integer getimpact()
		{
			Integer integer = null;
			try
			{
				integer = Integer.valueOf(getField(FLD_impact));
			}
			catch(Exception ex)
			{}
			return integer;
		}

		public void setimpact(Integer value)
		{
			if(value != null)
				addField(FLD_impact, value.toString());
		}

		public String getstate()
		{
			return getField(FLD_state);
		}

		public void setstate(String value)
		{
			if(value != null)
				addField(FLD_state, value);
		}

		public String getnumber()
		{
			return getField(FLD_number);
		}

		public void setnumber(String value)
		{
			if(value != null)
				addField(FLD_number, value);
		}

	}
}