package com.iemr.mmu.controller.cancerscreening;

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
import com.iemr.mmu.service.cancerScreening.CSServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author NE298657
 * @Objective Saving Cancer screening data for Nurse and Doctor both.
 * @Date 15-01-2018
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/CS-cancerScreening", headers = "Authorization")
public class CancerScreeningCreateController {
	private Logger logger = LoggerFactory.getLogger(CancerScreeningCreateController.class);

	private CSServiceImpl cSServiceImpl;

	@Autowired
	public void setCancerScreeningServiceImpl(CSServiceImpl cSServiceImpl) {
		this.cSServiceImpl = cSServiceImpl;
	}

	/**
	 * 
	 * @return
	 */

	@CrossOrigin
	@ApiOperation(value = "Save cancer screening nurse data..", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/nurseData" }, method = { RequestMethod.POST })
	public String saveBenCancerScreeningNurseData(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		try {
			logger.info("Request object for cancer screening nurse data saving :" + requestObj);

			JsonObject jsnOBJ = new JsonObject();
			JsonParser jsnParser = new JsonParser();
			JsonElement jsnElmnt = jsnParser.parse(requestObj);
			jsnOBJ = jsnElmnt.getAsJsonObject();

			if (jsnOBJ != null) {
				Long nurseDataSaveSuccessFlag = cSServiceImpl.saveCancerScreeningNurseData(jsnOBJ);
				if (nurseDataSaveSuccessFlag != null && nurseDataSaveSuccessFlag > 0) {
					response.setResponse("Nurse data saved successfully.");
				} else {
					response.setError(5000, "Something went wrong !!!");
				}
			} else {
				response.setError(5000, "Invalid Request !!!");
			}

		} catch (Exception e) {
			logger.error("Exception occurs in cancer screening nurse data saving :" + e);
			response.setError(e);
		}
		return response.toString();
	}

	/**
	 * 
	 * @return
	 */

	@CrossOrigin
	@ApiOperation(value = "Save cancer screening doctor data..", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/doctorData" }, method = { RequestMethod.POST })
	public String saveBenCancerScreeningDoctorData(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		try {
			logger.info("Request object for cancer screening doctor data saving :" + requestObj);

			JsonObject jsnOBJ = new JsonObject();
			JsonParser jsnParser = new JsonParser();
			JsonElement jsnElmnt = jsnParser.parse(requestObj);
			jsnOBJ = jsnElmnt.getAsJsonObject();

			if (jsnOBJ != null) {
				Long csDocDataSaveSuccessFlag = cSServiceImpl.saveCancerScreeningDoctorData(jsnOBJ);
				if (csDocDataSaveSuccessFlag != null && csDocDataSaveSuccessFlag > 0) {
					response.setResponse("Doc data saved successfully.");
				} else {
					response.setError(5000, "Something went wrong !!!");
				}
			} else {
				response.setError(5000, "Invalid Request !!!");
			}

		} catch (Exception e) {
			logger.error("Exception occurs in cancer screening doctor saving :" + e);
			response.setError(e);
		}
		return response.toString();
	}
}
