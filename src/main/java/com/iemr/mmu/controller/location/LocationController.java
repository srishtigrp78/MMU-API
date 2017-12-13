package com.iemr.mmu.controller.location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.controller.common.master.CommonMasterController;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping({ "/location" })
public class LocationController {
	private OutputResponse response;
	private Logger logger = LoggerFactory.getLogger(CommonMasterController.class);

	@ApiOperation(value = "State master for beneficiary", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/get/stateMaster", method = RequestMethod.GET)
	public String getStateMaster() {
		logger.info("getVisitReasonAndCategories ...");
		response = new OutputResponse();

		logger.info("visitReasonAndCategories" + response.toString());
		return response.toString();
	}
}
