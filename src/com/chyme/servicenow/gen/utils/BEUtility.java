//	Generated using Unvired Modeller - Build R-4.000.0002
package com.chyme.servicenow.gen.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.chyme.servicenow.gen.be.BE_GetIncidents;
import com.chyme.servicenow.gen.be.INCIDENT;
import com.unvired.lib.utility.BusinessEntity;
import com.unvired.lib.utility.Structure;

public class BEUtility
{
	public static List<BE_GetIncidents> getBE_GetIncidents(List<BusinessEntity> beList)
	{
		ArrayList<BE_GetIncidents> typedBEs = new ArrayList<BE_GetIncidents>();

		if(beList != null)
		{
			for (BusinessEntity be : beList)
			{
				if(be.getName().equals(BE_GetIncidents.NAME))
				{
					BE_GetIncidents typedBE = new BE_GetIncidents();
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