package com.iemr.mmu.controller.covid19;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.service.covid19.Covid19Service;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author DU20091017
 * @Saving covidq9 Data for nurse and Doctor
 * @Date : 25/06/2020 
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "pandemic/covid",headers = "Authorization")
public class CovidCreateController {

	private Logger logger =  LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	@Autowired
	private Covid19Service covid19Service ;
	
	@CrossOrigin
	@ApiOperation(value = "Save Covid nurse data..", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/nurseData" }, method = { RequestMethod.POST })
	public String saveBenCovid19NurseData(@RequestBody String requestObj,
			@RequestHeader(value ="Authorization") String Authorization) {
		OutputResponse outputResponse = new OutputResponse();
		
		try {
			logger.info("Request object for covid 19 nurse data saving :" + requestObj);
			
			JsonObject jsnOBJ = new JsonObject();
			JsonParser jsnParser = new JsonParser();
			JsonElement jsnElmnt = jsnParser.parse(requestObj);
			jsnOBJ = jsnElmnt.getAsJsonObject();
			
			if(jsnOBJ != null) {
				
				Long covid19Res =  covid19Service.saveCovid19NurseData(jsnOBJ, Authorization);
				if (null != covid19Res && covid19Res > 0) {
					outputResponse.setResponse("Data saved successfully");
				} else {
					outputResponse.setResponse("Unable to save data");
				}
			}else {
				outputResponse.setError(5000, "Invalid Request !!!");
			}
		}catch(Exception e) {
			logger.error("Error while saving Pandemic nurse data :" + e);
			outputResponse.setError(5000, "Unable to save data");
		}
		
		
		return outputResponse.toString();
	}
	
	
}
