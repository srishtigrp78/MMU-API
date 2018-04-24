package com.iemr.mmu.controller.quickconsult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
/**
 * 
 * @author NA874500
 * @Objective updating GeneralOPD (QuickConsult) data for Doctor.
 * @Date 24-04-2018
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value =  "/ANC", headers = "Authorization")
public class QuickConsultUpdateController {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	/*@CrossOrigin
	@ApiOperation(value = "update GeneralOPD Doctor Data", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/doctorData" }, method = { RequestMethod.POST })
	public String updateGeneralOPDDoctorData( @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("updateGeneralOPDDoctorData request:" + requestObj);

		JsonObject jsnOBJ = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElmnt = jsnParser.parse(requestObj);
		jsnOBJ = jsnElmnt.getAsJsonObject();

		try {
			Long result = generalOPDServiceImpl.updateGeneralOPDDoctorData(jsnOBJ);
			if (null != result && result > 0) {
				response.setResponse("GeneralOPD Doctor Data updated successfully.");
			} else {
				response.setError(500, "Failed to update GeneralOPD Doctor Data");
			}
			logger.info("updateGeneralOPDDoctorData response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in updateGeneralOPDDoctorData :" + e);
		}

		return response.toString();
	}*/
	
}
