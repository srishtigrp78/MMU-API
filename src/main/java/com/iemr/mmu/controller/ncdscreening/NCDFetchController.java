package com.iemr.mmu.controller.ncdscreening;

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

import com.iemr.mmu.service.ncdscreening.NCDScreeningServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @author NA874500
 * @Objective Fetching NCD Screening nurse data.
 * @Date 24-01-2018
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value =  "/NCD", headers = "Authorization")
public class NCDFetchController {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	private NCDScreeningServiceImpl ncdScreeningServiceImpl;
	
	@Autowired
	public void setNcdScreeningServiceImpl(NCDScreeningServiceImpl ncdScreeningServiceImpl) {
		this.ncdScreeningServiceImpl = ncdScreeningServiceImpl;
	}
	
	/**
	 * @Objective Fetching NCD Screening nurse data.
	 * @param benRegID and benVisitID
	 * @return NCD Screening nurse data in JSON format
	 */
	@CrossOrigin()
	@ApiOperation(value = "Get NCD Screening Visit Details", consumes = "application/json", produces = "application/json")

	@RequestMapping(value = { "/get/nurseData" }, method = { RequestMethod.POST })
	public String getNCDScreenigDetails(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {

		OutputResponse response = new OutputResponse();
		logger.info("Request obj to fetch nurse data :" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.length() > 1) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String screeningDetails = ncdScreeningServiceImpl.getNCDScreeningDetails(benRegID, benVisitID);
				response.setResponse(screeningDetails);
			} else {
				response.setError(5000, "Invalid request");
			}
			logger.info("NCD Screening nurse data fetch response :" + response);
		} catch (Exception e) {
			response.setError(5000, "Error while getting NCD Screening data");
			logger.error("Error while getting NCD Screening data :" + e);
		}
		return response.toString();
	}
}
