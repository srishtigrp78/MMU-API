package com.iemr.mmu.controller.anc;

import java.text.ParseException;

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
import com.iemr.mmu.controller.cancerscreening.CancerScreeningCreateController;
import com.iemr.mmu.service.anc.ANCServiceImpl;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author NA874500
 * @Objective Saving ANC data for Nurse.
 * @Date 19-01-2018
 *
 */
@CrossOrigin
@RestController
@RequestMapping({ "/ANC" })
public class ANCCreateController {
	private Logger logger = LoggerFactory.getLogger(ANCCreateController.class);
	
	private ANCServiceImpl ancServiceImpl;
	
	@Autowired
	public void setAncServiceImpl(ANCServiceImpl ancServiceImpl) {
		this.ancServiceImpl = ancServiceImpl;
	}
	
	/**
	 * 
	 * @return
	 */

	@CrossOrigin
	@ApiOperation(value = "Save ANC nurse data..", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/nurseData" }, method = { RequestMethod.POST })
	public String saveBenANCNurseData(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		try {
			logger.info("Request object for ANC nurse data saving :" + requestObj);

			JsonObject jsnOBJ = new JsonObject();
			JsonParser jsnParser = new JsonParser();
			JsonElement jsnElmnt = jsnParser.parse(requestObj);
			jsnOBJ = jsnElmnt.getAsJsonObject();

			if (jsnOBJ != null) {
				ancServiceImpl.saveANCNurseData(jsnOBJ);
			} else {
				response.setError(5000, "Invalid Request !!!");
			}

		} catch (ParseException e) {
			logger.error("Exception occurs in ANC nurse data saving :" + e);
			response.setError(e);
		}
		return null;
	}
}
