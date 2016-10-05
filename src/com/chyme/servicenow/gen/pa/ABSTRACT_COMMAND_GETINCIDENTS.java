//	Generated using Unvired Modeller - Build R-4.000.0002
package com.chyme.servicenow.gen.pa;

import com.chyme.servicenow.gen.utils.BEUtility;
import com.unvired.ump.agent.IBusinessProcess;

public abstract class ABSTRACT_COMMAND_GETINCIDENTS extends BotService {
	protected com.chyme.servicenow.gen.be.BE_GetIncidents inputBE_GetIncidents;

	public void init(IBusinessProcess process) {
		super.init(process);

		inputBE_GetIncidents = BEUtility.getBE_GetIncidents(process.getBusinessEntityInput()).get(0);

	}

}
