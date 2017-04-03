//	Generated using Unvired Modeller - Build R-4.000.0042
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

		public static final String FLD_short_description = "short_description";
		public static final String FLD_number = "number";
		public static final String FLD_category = "category";
		public static final String FLD_impact = "impact";
		public static final String FLD_priority = "priority";
		public static final String FLD_state = "state";
		public static final String FLD_opened_at = "opened_at";

		public static final ArrayList<String> FIELDS = new ArrayList<String>();

		static {
			FIELDS.add(FLD_short_description);
			FIELDS.add(FLD_number);
			FIELDS.add(FLD_category);
			FIELDS.add(FLD_impact);
			FIELDS.add(FLD_priority);
			FIELDS.add(FLD_state);
			FIELDS.add(FLD_opened_at);
		}

		public INCIDENT_HEADER()
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

		public String getnumber()
		{
			return getField(FLD_number);
		}

		public void setnumber(String value)
		{
			if(value != null)
				addField(FLD_number, value);
		}

		public String getcategory()
		{
			return getField(FLD_category);
		}

		public void setcategory(String value)
		{
			if(value != null)
				addField(FLD_category, value);
		}

		public String getimpact()
		{
			return getField(FLD_impact);
		}

		public void setimpact(String value)
		{
			if(value != null)
				addField(FLD_impact, value);
		}

		public String getpriority()
		{
			return getField(FLD_priority);
		}

		public void setpriority(String value)
		{
			if(value != null)
				addField(FLD_priority, value);
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

		public String getopened_at()
		{
			return getField(FLD_opened_at);
		}

		public void setopened_at(String value)
		{
			if(value != null)
				addField(FLD_opened_at, value);
		}

	}
}