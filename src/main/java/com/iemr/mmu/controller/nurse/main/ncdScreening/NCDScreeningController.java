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

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.controller.nurse.main.cancerScreening.InsertNurseCSController;
import com.iemr.mmu.service.ncdscreening.NCDScreeningService;
import com.iemr.mmu.service.ncdscreening.NCDScreeningServiceImpl;
import com.iemr.mmu.service.nurse.NurseService;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping({ "/ncdScreening" })
public class NCDScreeningController {

	private Logger logger = LoggerFactory.getLogger(InsertNurseCSController.class);
	private NCDScreeningServiceImpl ncdScreeningService;
	private NurseServiceImpl nurseService;
	
	@Autowired
	public void setNcdScreeningService(NCDScreeningServiceImpl ncdScreeningService) {
		this.ncdScreeningService = ncdScreeningService;
	}
	
	@Autowired
	public void setNurseService(NurseServiceImpl nurseService) {
		this.nurseService = nurseService;
	}

	@CrossOrigin
	@ApiOperation(value = "save Beneficiary NCD Screening Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/nurseData" }, method = { RequestMethod.POST })
	public String saveBeneficiaryNCDScreeningDetails( @RequestBody String requestObj) {

		logger.info("Save NCDScreening Details request:" + requestObj);
		OutputResponse response = new OutputResponse();
		JsonObject jsonObject = new JsonObject();
		JsonParser jsonParser = new JsonParser();
		
		try {
			JsonElement jsonElement = jsonParser.parse(requestObj);
			jsonObject = jsonElement.getAsJsonObject();

			if (jsonObject != null) {
				Integer r = ncdScreeningService.handleSaveNCDScreeningRequest(jsonObject);
				if (r != null && r == 1) {
					response.setResponse("Beneficiary Visit Details and NCD Screening data saved successfully");
				} else {
					response.setError(5000, "Error in saving ncd screening details");
				}
			} else {
				response.setError(5000, "Invalid Data !!!");
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in beneficiary Visit details and NCD screening data: " + e);
		}
		logger.info("Save NCDScreening Details response:" + response);
		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "update Beneficiary NCD Screening Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/nurseData" }, method = { RequestMethod.POST })
	public String updateBeneficiaryNCDScreeningDetails( @RequestBody String requestObj) {

		logger.info("Update NCDScreening Details request:" + requestObj);
		OutputResponse response = new OutputResponse();
		JsonObject jsonObject = new JsonObject();
		JsonParser jsonParser = new JsonParser();
		
		try {
			JsonElement jsonElement = jsonParser.parse(requestObj);
			jsonObject = jsonElement.getAsJsonObject();

			if (jsonObject != null) {
				Integer r = ncdScreeningService.handleUpdateNCDScreeningRequest(jsonObject);
				if (r != null && r == 1) {
					response.setResponse("Beneficiary NCD Screening data updated successfully");
				} else {
					response.setError(5000, "Error in updating ncd screening details");
				}
			} else {
				response.setError(5000, "Invalid Data !!!");
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in updating beneficiary NCD screening data: " + e);
		}
		logger.info("Update NCDScreening Details response:" + response);
		return response.toString();
	}


	@CrossOrigin()
	@ApiOperation(value = "Get NCD Screening Visit Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/get/nurseData" }, method = { RequestMethod.POST })
	public String getNCDScreenigDetails( @ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {

		OutputResponse response = new OutputResponse();
		logger.info("getNCDScreeningDetails:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.length() > 1) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String ncdScreeningDetails = ncdScreeningService.getNCDScreeningDetails(benRegID, benVisitID);
				String anthropometryDetails = nurseService.getBeneficiaryPhysicalAnthropometryDetails(benRegID, benVisitID);
				String vitalDetails = nurseService.getBeneficiaryPhysicalVitalDetails(benRegID, benVisitID);


				Map<String, String> res = new HashMap<String, String>();

				if(ncdScreeningDetails != null && anthropometryDetails != null && vitalDetails != null) {
					res.put("ncdScreeningDetails", ncdScreeningDetails);
					res.put("anthropometryDetails", anthropometryDetails);
					res.put("vitalDetails", vitalDetails);
					response.setResponse(res.toString());
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
