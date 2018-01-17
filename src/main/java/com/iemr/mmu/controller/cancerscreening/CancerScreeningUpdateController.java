package com.iemr.mmu.controller.cancerscreening;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.controller.doctor.main.cancerScreening.UpdateDoctorCSController;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.service.cancerScreening.CancerScreeningServiceImpl;
import com.iemr.mmu.service.common.master.DoctorMasterDataService;
import com.iemr.mmu.service.common.master.DoctorMasterDataServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @author NA874500
 * @Objective Updating Cancer screening data for Nurse.
 * @Date 17-01-2018
 *
 */
@CrossOrigin
@RestController
@RequestMapping({ "/CS-cancerScreening" })
public class CancerScreeningUpdateController {
	private InputMapper inputMapper = new InputMapper();
	private OutputResponse response;
	private Logger logger = LoggerFactory.getLogger(UpdateDoctorCSController.class);
	private CancerScreeningServiceImpl cancerScreeningServiceImpl;
	
	@Autowired
	public void setCancerScreeningServiceImpl(CancerScreeningServiceImpl cancerScreeningServiceImpl) {
		this.cancerScreeningServiceImpl = cancerScreeningServiceImpl;
	}
	
	/**
	 * 
	 * @param requestObj
	 * @return success or failure response
	 * @objective Replace Cancer Screening History Details 
	 * 				entered by Nurse with the details entered by Doctor
	 */
	
	@CrossOrigin
	@ApiOperation(value = "update Cancer Screening History Nurse Data in Doctor screen", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/historyScreen" }, method = { RequestMethod.POST })
	public String updateCSHistoryNurse(
			@ApiParam(value = "[{\"ID\": \"Long\", \"beneficiaryRegID\":\"Long\",\"benVisitID\":\"Long\","
					+ "\"cancerDiseaseType\":\"String\", \"familyMemberList\":\"List\", \"modifiedBy\":\"String\"},"
					+ "{ \"beneficiaryRegID\":\"Long\",\"benVisitID\":\"Long\","
					+ "\"cancerDiseaseType\":\"String\", \"familyMemberList\":\"List\", \"createdBy\":\"String\"}]") @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		inputMapper = new InputMapper();
		logger.info("updateCSHistoryNurse request:" + requestObj);

		JsonObject jsnOBJ = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElmnt = jsnParser.parse(requestObj);
		jsnOBJ = jsnElmnt.getAsJsonObject();

		
		try {
			int result = cancerScreeningServiceImpl.UpdateCSHistoryNurseData(jsnOBJ);
			if (result > 0) {
				Map<String, Integer> resMap = new HashMap<String, Integer>();
				resMap.put("result", result);
				response.setResponse(new Gson().toJson(resMap));
			} else {
				response.setError(500, "Failed to update CS History Nurse Data");
			}
			logger.info("updateCSHistoryNurse response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in updateCSHistoryNurse :" + e);
		}

		return response.toString();
	}
}
