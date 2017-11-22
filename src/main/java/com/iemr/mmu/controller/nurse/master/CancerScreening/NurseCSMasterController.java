package com.iemr.mmu.controller.nurse.master.CancerScreening;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.iemr.mmu.controller.nurse.main.cancerScreening.NurseController;
import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenCancerVitalDetail;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerDietHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerHistory;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.service.common.master.NurseMasterDataService;
import com.iemr.mmu.service.common.master.NurseMasterDataServiceImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping({ "/nurse" })
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
