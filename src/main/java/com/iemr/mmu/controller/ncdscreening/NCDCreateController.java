package com.iemr.mmu.controller.ncdscreening;

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
import com.iemr.mmu.service.ncdscreening.NCDScreeningServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author NA874500
 * @Objective Fetching Cancer Screening Data for caseSheet.
 * @Date 24-01-2018
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/NCD", headers = "Authorization")
public class NCDCreateController {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	private NCDScreeningServiceImpl ncdScreeningServiceImpl;

	@Autowired
	public void setNcdScreeningServiceImpl(NCDScreeningServiceImpl ncdScreeningServiceImpl) {
		this.ncdScreeningServiceImpl = ncdScreeningServiceImpl;
	}

	@CrossOrigin
	@ApiOperation(value = "save Beneficiary NCD Screening Detail", consumes = "application/json", produces = "application/json")

	@RequestMapping(value = { "/save/nurseData" }, method = { RequestMethod.POST })
	public String saveBeneficiaryNCDScreeningDetails(@RequestBody String requestObj) {

		logger.info("Save NCDScreening Details request:" + requestObj);
		OutputResponse response = new OutputResponse();

		JsonObject jsonObject = new JsonObject();
		JsonParser jsonParser = new JsonParser();

		try {
			JsonElement jsonElement = jsonParser.parse(requestObj);
			jsonObject = jsonElement.getAsJsonObject();

			if (jsonObject != null) {
				Integer r = ncdScreeningServiceImpl.saveNCDScreeningNurseData(jsonObject);
				if (r != null && r > 0) {
					response.setResponse("NCD Screening data saved successfully");
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
}
