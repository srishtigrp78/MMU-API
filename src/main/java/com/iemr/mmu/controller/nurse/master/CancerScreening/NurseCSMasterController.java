package com.iemr.mmu.controller.nurse.master.CancerScreening;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.service.common.master.NurseMasterDataServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = "/nurse", headers = "Authorization")
/** Objective: Performs fetching master data for nurse Cancer Screening */
public class NurseCSMasterController {
	private InputMapper inputMapper;
	private Logger logger = LoggerFactory.getLogger(NurseCSMasterController.class);

	private NurseMasterDataServiceImpl nurseMasterDataServiceImpl;

	@Autowired
	public void setNurseMasterDataServiceImpl(NurseMasterDataServiceImpl nurseMasterDataServiceImpl) {
		this.nurseMasterDataServiceImpl = nurseMasterDataServiceImpl;
	}

	@CrossOrigin()
	@ApiOperation(value = "provides Nurse master Data", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/nurseMasterData" }, method = { RequestMethod.POST }, produces = { "application/json" })
	public String masterDataForNurse() {

		OutputResponse response = new OutputResponse();
		logger.info("getting Nurse Master Data ");
		try {
			response.setResponse(nurseMasterDataServiceImpl.getCancerScreeningMasterDataForNurse());
			logger.info("masterDataForNurse response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in masterDataForNurse :" + e);
		}
		return response.toString();
	}

}
