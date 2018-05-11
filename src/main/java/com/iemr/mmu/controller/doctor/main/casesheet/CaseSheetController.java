package com.iemr.mmu.controller.doctor.main.casesheet;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.service.casesheet.CaseSheetServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

// temporary controller

@CrossOrigin
@RestController
@RequestMapping(value = "/casesheet", headers = "Authorization")
/** Objective: Provides Nurse and doctor entered details for casesheet */
public class CaseSheetController {

	private InputMapper inputMapper = new InputMapper();
	private OutputResponse response;
	private Logger logger = LoggerFactory.getLogger(CaseSheetController.class);
	private CaseSheetServiceImpl caseSheetServiceImpl;

	@Autowired
	public void setCaseSheetServiceImpl(CaseSheetServiceImpl caseSheetServiceImpl) {
		this.caseSheetServiceImpl = caseSheetServiceImpl;
	}

	
	
	@CrossOrigin()
	@ApiOperation(value = "Get casesheet History of Beneficiary", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBeneficiaryCaseSheetHistory" }, method = { RequestMethod.POST })
	public String getBeneficiaryCaseSheetHistory(
			@ApiParam(value = "{\"benRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getBenDataForCaseSheet request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.length() >= 1) {
				Long benRegID = obj.getLong("benRegID");

				String caseSheetHistory = caseSheetServiceImpl.getBeneficiaryCaseSheetHistory(benRegID);

				response.setResponse(caseSheetHistory);
			} else {

			}
			logger.info("getBenDataForCaseSheet response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenDataForCaseSheet:" + e);
		}
		return response.toString();
	}

	
}
