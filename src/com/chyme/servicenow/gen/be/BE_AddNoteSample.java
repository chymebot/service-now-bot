//	Generated using Unvired Modeller - Build R-4.000.0042
package com.chyme.servicenow.gen.be;

import java.util.ArrayList;

import com.unvired.lib.utility.BusinessEntity;
import com.unvired.lib.utility.Structure;

public class BE_AddNoteSample extends BusinessEntity {

	private static final long serialVersionUID = 1L;
	public static final String NAME = "BE_AddNoteSample";
	public BE_AddNoteSample()
	{
		setName(NAME);
		setHeader(new AddNoteSample_HEADER());
	}

	public AddNoteSample_HEADER getAddNoteSample_HEADER()
	{
		return (AddNoteSample_HEADER)super.getHeader();
	}

	public static class AddNoteSample_HEADER extends Structure
	{
		private static final long serialVersionUID = 1L;
		public static final String NAME = "AddNoteSample_HEADER";

		public static final String FLD_note = "note";
		public static final String FLD_number = "number";

		public static final ArrayList<String> FIELDS = new ArrayList<String>();

		static {
			FIELDS.add(FLD_note);
			FIELDS.add(FLD_number);
		}

		public AddNoteSample_HEADER()
		{
			setName(NAME);
		}

		public String getnote()
		{
			return getField(FLD_note);
		}

		public void setnote(String value)
		{
			if(value != null)
				addField(FLD_note, value);
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