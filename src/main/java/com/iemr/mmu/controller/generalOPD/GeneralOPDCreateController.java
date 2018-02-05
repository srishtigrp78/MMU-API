package com.iemr.mmu.controller.generalOPD;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.service.generalOPD.GeneralOPDServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

/***
 * 
 * @author NE298657
 *
 */

@RestController
@CrossOrigin
@RequestMapping(value = "/generalOPD", headers = "Authorization")
public class GeneralOPDCreateController {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	private GeneralOPDServiceImpl generalOPDServiceImpl;

	@Autowired
	public void setGeneralOPDServiceImpl(GeneralOPDServiceImpl generalOPDServiceImpl) {
		this.generalOPDServiceImpl = generalOPDServiceImpl;
	}

	@CrossOrigin
	@ApiOperation(value = "Save General OPD nurse data..", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/nurseData" }, method = { RequestMethod.POST })
	@Transactional(rollbackFor = Exception.class)
	public String saveBenGenOPDNurseData(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		try {
			logger.info("Request object for GeneralOPD nurse data saving :" + requestObj);

			JsonObject jsnOBJ = new JsonObject();
			JsonParser jsnParser = new JsonParser();
			JsonElement jsnElmnt = jsnParser.parse(requestObj);
			jsnOBJ = jsnElmnt.getAsJsonObject();

			if (jsnOBJ != null) {
				Long genOPDRes = generalOPDServiceImpl.saveNurseData(jsnOBJ);
				if (null != genOPDRes && genOPDRes > 0) {
					response.setResponse("General OPD Nurse Entered Details stored successfully.");
				} else {
					response.setResponse("Failed to store General OPD Details.");
				}

			} else {
				response.setResponse("Invalid Request!");
			}
		} catch (Exception e) {
			logger.error("Exception occurs while saving General OPD nurse data :" + e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "Save General OPD doctor data..", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/doctorData" }, method = { RequestMethod.POST })
	@Transactional(rollbackFor = Exception.class)
	public String saveBenGenOPDDoctorData(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		try {
			logger.info("Request object for GeneralOPD doctor data saving :" + requestObj);

			JsonObject jsnOBJ = new JsonObject();
			JsonParser jsnParser = new JsonParser();
			JsonElement jsnElmnt = jsnParser.parse(requestObj);
			jsnOBJ = jsnElmnt.getAsJsonObject();

			if (jsnOBJ != null) {
				Long genOPDRes = generalOPDServiceImpl.saveNurseData(jsnOBJ);
				if (null != genOPDRes && genOPDRes > 0) {
					response.setResponse("General OPD doctor Entered Details stored successfully.");
				} else {
					response.setResponse("Failed to store General OPD doctor Details.");
				}

			} else {
				response.setResponse("Invalid Request!");
			}
		} catch (Exception e) {
			logger.error("Exception occurs while saving General OPD doctor data :" + e);
			response.setError(e);
		}
		return response.toString();
	}
}
