//	Generated using Unvired Modeller - Build R-4.000.0042
package com.chyme.servicenow.gen.pa;

import com.chyme.servicenow.gen.utils.BEUtility;
import com.unvired.ump.agent.IBusinessProcess;

public abstract class ABSTRACT_COMMAND_ADDNOTESAMPLE extends BotService {
	protected com.chyme.servicenow.gen.be.BE_AddNoteSample inputBE_AddNoteSample;

	public void init(IBusinessProcess process) {
		super.init(process);

		inputBE_AddNoteSample = BEUtility.getBE_AddNoteSample(process.getBusinessEntityInput()).get(0);

	}

	public com.chyme.servicenow.gen.servicenow.snobject.INCIDENT mapPojoToServicenow(
			com.chyme.servicenow.gen.be.BE_AddNoteSample pojo) {
		com.chyme.servicenow.gen.servicenow.snobject.INCIDENT entity = new com.chyme.servicenow.gen.servicenow.snobject.INCIDENT();
		com.chyme.servicenow.gen.be.BE_AddNoteSample.AddNoteSample_HEADER header = (com.chyme.servicenow.gen.be.BE_AddNoteSample.AddNoteSample_HEADER) pojo
				.getHeader();

		entity.setNUMBER(header.getnumber());
		entity.setCOMMENTS(header.getnote());

		return entity;
	}

	public com.chyme.servicenow.gen.be.INCIDENT mapServicenowToPojo(
			com.chyme.servicenow.gen.servicenow.snobject.INCIDENT entity) {
		com.chyme.servicenow.gen.be.INCIDENT pojo = new com.chyme.servicenow.gen.be.INCIDENT();
		com.chyme.servicenow.gen.be.INCIDENT.INCIDENT_HEADER header = (com.chyme.servicenow.gen.be.INCIDENT.INCIDENT_HEADER) pojo
				.getHeader();

		header.setshort_description(entity.getSHORT_DESCRIPTION());
		header.setnumber(entity.getNUMBER());
		header.setcategory(entity.getCATEGORY());
		header.setopened_at(entity.getOPENED_AT());

		return pojo;
	}

	public com.chyme.servicenow.gen.be.INCIDENT mapServicenowToBE(
			com.chyme.servicenow.gen.servicenow.snobject.INCIDENT header) {
		com.chyme.servicenow.gen.be.INCIDENT be = mapServicenowToPojo(header);

		return be;
	}

}
