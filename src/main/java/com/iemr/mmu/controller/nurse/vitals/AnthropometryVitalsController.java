package com.iemr.mmu.controller.nurse.vitals;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.service.nurse.vitals.AnthropometryVitalsService;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping(value = "/anthropometryVitals", headers = "Authorization", consumes = "application/json", produces = "application/json")
public class AnthropometryVitalsController {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	@Autowired
	private AnthropometryVitalsService anthropometryVitalsService;
	
	//Auto-patching height in anthropometry details
		@CrossOrigin()	
		@ApiOperation(value = "Get beneficiary height details", consumes = "application/json", produces = "application/json")
		@RequestMapping(value = { "/getBenHeightDetailsFrmNurse" }, method = { RequestMethod.POST })
		public String getBenHeightDetailsFrmNurse(
				@Param(value = "{\"benRegID\":\"Long\",\"visitCode\":\"Long\"}") @RequestBody String comingRequest) {
			OutputResponse response = new OutputResponse();

			logger.info("Request object for beneficiary height data fetching :" + comingRequest);
			try {
				JSONObject obj = new JSONObject(comingRequest);
				if (obj.has("benRegID") && obj.has("visitCode")) {
					Long benRegID = obj.getLong("benRegID");
					Long visitCode = obj.getLong("visitCode");

					String res = anthropometryVitalsService.getBeneficiaryHeightDetails(benRegID, visitCode);
					response.setResponse(res);
				} else {
					logger.info("Invalid request");
					response.setError(5000, "Invalid request");
				}
				logger.info("Beneficiary height data fetching Response:" + response);
			} catch (Exception e) {
				response.setError(5000, "Error while getting beneficiary height data");
				logger.error("Error while getting beneficiary height data :" + e);
			}
			return response.toString();
		}
}
