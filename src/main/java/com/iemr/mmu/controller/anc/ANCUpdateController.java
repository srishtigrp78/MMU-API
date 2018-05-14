package com.iemr.mmu.controller.anc;

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
import com.iemr.mmu.service.anc.ANCServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author NA874500
 * @Objective Saving ANC data for Nurse.
 * @Date 24-01-2018
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value =  "/ANC", headers = "Authorization")
public class ANCUpdateController {

private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	private ANCServiceImpl ancServiceImpl;

	@Autowired
	public void setAncServiceImpl(ANCServiceImpl ancServiceImpl) {
		this.ancServiceImpl = ancServiceImpl;
	}
	
	/**
	 * 
	 * @param requestObj
	 * @return success or failure response
	 * @objective Replace ANC Care Data entered by Nurse with
	 *            the details entered by Doctor
	 */

	@CrossOrigin
	@ApiOperation(value = "update ANC care Data in Doctor screen", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/ANCScreen" }, method = { RequestMethod.POST })
	public String updateANCCareNurse( @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("updateANCCareNurse request:" + requestObj);

		JsonObject jsnOBJ = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElmnt = jsnParser.parse(requestObj);
		jsnOBJ = jsnElmnt.getAsJsonObject();

		try {
			int result = ancServiceImpl.updateBenANCDetails(jsnOBJ);
			if (result > 0) {
				response.setResponse("ANC Care data updated successfully");
			} else {
				response.setError(500, "Failed to update ANC Care data");
			}
			logger.info("updateANCCareNurse response:" + response);
		} catch (Exception e) {
			response.setError(5000, "Error while updating beneficiary ANC care data");
			logger.error("Error in updateANCCareNurse :" + e);
		}

		return response.toString();
	}
	
	/**
	 * 
	 * @param requestObj
	 * @return success or failure response
	 * @objective Replace ANC History Data entered by Nurse with
	 *            the details entered by Doctor
	 */

	@CrossOrigin
	@ApiOperation(value = "update ANC History Data in Doctor screen", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/historyScreen" }, method = { RequestMethod.POST })
	public String updateANCHistoryNurse( @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("updateANCHistoryNurse request:" + requestObj);

		JsonObject jsnOBJ = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElmnt = jsnParser.parse(requestObj);
		jsnOBJ = jsnElmnt.getAsJsonObject();

		try {
			int result = ancServiceImpl.updateBenANCHistoryDetails(jsnOBJ);
			if (result > 0) {
				response.setResponse("History data updated successfully");
			} else {
				response.setError(500, "Failed to update history data");
			}
			logger.info("updateANCHistoryNurse response:" + response);
		} catch (Exception e) {
			response.setError(5000, "Error while updating beneficiary history data");
			logger.error("Error in updateANCHistoryNurse :" + e);
		}

		return response.toString();
	}
	
	/**
	 * 
	 * @param requestObj
	 * @return success or failure response
	 * @objective Replace ANC Vital Data entered by Nurse with
	 *            the details entered by Doctor
	 */

	@CrossOrigin
	@ApiOperation(value = "update ANC Vital Data in Doctor screen", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/vitalScreen" }, method = { RequestMethod.POST })
	public String updateANCVitalNurse( @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("updateANCVitalNurse request:" + requestObj);

		JsonObject jsnOBJ = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElmnt = jsnParser.parse(requestObj);
		jsnOBJ = jsnElmnt.getAsJsonObject();

		try {
			int result = ancServiceImpl.updateBenANCVitalDetails(jsnOBJ);
			if (result > 0) {
				response.setResponse("Vital data updated successfully");
			} else {
				response.setError(500, "Failed to update vital data");
			}
			logger.info("updateANCVitalNurse response:" + response);
		} catch (Exception e) {
			response.setError(5000, "Error while updating beneficiary vital data");
			logger.error("Error in updateANCVitalNurse :" + e);
		}

		return response.toString();
	}
	
	/**
	 * 
	 * @param requestObj
	 * @return success or failure response
	 * @objective Replace ANC History Data entered by Nurse with
	 *            the details entered by Doctor
	 */

	@CrossOrigin
	@ApiOperation(value = "update ANC Examination Data in Doctor screen", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/examinationScreen" }, method = { RequestMethod.POST })
	public String updateANCExaminationNurse( @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("updateANCExaminationNurse request:" + requestObj);

		JsonObject jsnOBJ = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElmnt = jsnParser.parse(requestObj);
		jsnOBJ = jsnElmnt.getAsJsonObject();

		try {
			int result = ancServiceImpl.updateBenANCExaminationDetails(jsnOBJ);
			if (result > 0) {
				response.setResponse("Examination data updated successfully");
			} else {
				response.setError(500, "Failed to update examination data");
			}
			logger.info("updateANCExaminationNurse response:" + response);
		} catch (Exception e) {
			response.setError(5000, "Error while updating beneficiary examination data");
			logger.error("Error in updateANCExaminationNurse :" + e);
		}

		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "update ANC Doctor Data", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/doctorData" }, method = { RequestMethod.POST })
	public String updateANCDoctorData( @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("updateANCDoctorData request:" + requestObj);

		JsonObject jsnOBJ = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElmnt = jsnParser.parse(requestObj);
		jsnOBJ = jsnElmnt.getAsJsonObject();

		try {
			Long result = ancServiceImpl.updateANCDoctorData(jsnOBJ);
			if (null != result && result > 0) {
				response.setResponse("Doctor data updated successfully");
			} else {
				response.setError(500, "Failed to update doctor data");
			}
			logger.info("updateANCDoctorData response:" + response);
		} catch (Exception e) {
			response.setError(5000, "Error while updating beneficiary doctor data");
			logger.error("Error in updateANCDoctorData :" + e);
		}

		return response.toString();
	}
}
