package com.iemr.mmu.controller.nurse.main.ncdScreening;

import java.util.HashMap;
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
import com.iemr.mmu.controller.nurse.main.cancerScreening.InsertNurseCSController;
import com.iemr.mmu.data.ncdScreening.NCDScreening;
import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.service.ncdscreening.NCDScreeningService;
import com.iemr.mmu.service.nurse.NurseService;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping({ "/nurse" })
public class NCDScreeningController {

	private InputMapper inputMapper;
	private Logger logger = LoggerFactory.getLogger(InsertNurseCSController.class);
	private NCDScreeningService ncdScreeningService;
	private NurseService nurseService;

	@Autowired
	public void setNcdScreeningService(NCDScreeningService ncdScreeningService) {
		this.ncdScreeningService = ncdScreeningService;
	}

	@Autowired
	public void setNurseService(NurseService nurseService) {
		this.nurseService = nurseService;
	}


	@CrossOrigin
	@ApiOperation(value = "save Beneficiary NCD Screening Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/ncdScreeningDetails" }, method = { RequestMethod.POST })
	public String saveBeneficiaryNCDScreeningDetails( @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		inputMapper = new InputMapper();
		logger.info("saveNCDScreeningDetails request:" + requestObj);
		NCDScreening ncdScreening = InputMapper.gson().fromJson(requestObj, NCDScreening.class);
		
		System.out.println(ncdScreening);
		BenPhysicalVitalDetail benPhysicalVitalDetail =  InputMapper.gson().fromJson(requestObj, BenPhysicalVitalDetail.class);
		BenAnthropometryDetail anthropometryDetail = InputMapper.gson().fromJson(requestObj, BenAnthropometryDetail.class);
		try {
			Long saveNCDScreeningDetails = ncdScreeningService.saveNCDScreeningDetails(ncdScreening);
			Long saveBeneficiaryPhysicalVitalDetails = nurseService.saveBeneficiaryPhysicalVitalDetails(benPhysicalVitalDetail);
			Long saveBeneficiaryPhysicalAnthropometryDetails = nurseService.saveBeneficiaryPhysicalAnthropometryDetails(anthropometryDetail);
			if (null != saveNCDScreeningDetails && null !=saveBeneficiaryPhysicalVitalDetails && null != saveBeneficiaryPhysicalAnthropometryDetails) {
				response.setResponse("Beneficiary NCD Screening Details saved successfully.");
			} else {
				response.setError(500, "Failed to Store Beneficiary NCD Screening Details");
			}
			logger.info("saveNCDScreeningDetails response:" + response);
		} catch (Exception e) {
			e.printStackTrace();
			response.setError(e);
			logger.error("Error in saveNCDScreeningDetails:" + e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get NCD Screening Visit Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/fetch/ncdScreeningDetails" }, method = { RequestMethod.POST })
	public String getNCDScreenigDetails( @ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {

		OutputResponse response = new OutputResponse();
		logger.info("getNCDScreeningDetails:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.length() > 1) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String s = ncdScreeningService.getNCDScreeningDetails(benRegID, benVisitID);
				if(s != null) {
					response.setResponse(s);
				} else {
					response.setError(5000, "Failed to Fetch Beneficiary NCD Screening Details");
				}
			} else {
				response.setError(5000, "Error in parsing request");
			}
			logger.info("getNCDScreeningDetails response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getNCDScreeningDetails:" + e);
		}
		return response.toString();
	}

}
