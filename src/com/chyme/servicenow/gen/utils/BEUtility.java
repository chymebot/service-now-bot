//	Generated using Unvired Modeller - Build R-4.000.0002
package com.chyme.servicenow.gen.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.chyme.servicenow.gen.be.BE_GetIncidentsSample;
import com.chyme.servicenow.gen.be.INCIDENT;
import com.unvired.lib.utility.BusinessEntity;
import com.unvired.lib.utility.Structure;

public class BEUtility
{
	public static List<BE_GetIncidentsSample> getBE_GetIncidentsSample(List<BusinessEntity> beList)
	{
		ArrayList<BE_GetIncidentsSample> typedBEs = new ArrayList<BE_GetIncidentsSample>();

		if(beList != null)
		{
			for (BusinessEntity be : beList)
			{
				if(be.getName().equals(BE_GetIncidentsSample.NAME))
				{
					BE_GetIncidentsSample typedBE = new BE_GetIncidentsSample();
					typedBEs.add(typedBE);
					for (Entry<String, String> field : be.getHeader().getFieldsInOrder().entrySet())
					{
						typedBE.getHeader().addField(field.getKey(), field.getValue());
					}

					//	Process each item individually
					for (Structure item : be.getItems())
					{
					}
				}
			}
		}
		return typedBEs;
	}

	public static List<INCIDENT> getINCIDENT(List<BusinessEntity> beList)
	{
		ArrayList<INCIDENT> typedBEs = new ArrayList<INCIDENT>();

		if(beList != null)
		{
			for (BusinessEntity be : beList)
			{
				if(be.getName().equals(INCIDENT.NAME))
				{
					INCIDENT typedBE = new INCIDENT();
					typedBEs.add(typedBE);
					for (Entry<String, String> field : be.getHeader().getFieldsInOrder().entrySet())
					{
						typedBE.getHeader().addField(field.getKey(), field.getValue());
					}

					//	Process each item individually
					for (Structure item : be.getItems())
					{
					}
				}
			}
		}
		return typedBEs;
	}

}