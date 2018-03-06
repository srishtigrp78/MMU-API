package com.iemr.mmu.controller.common.main;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping(value = "/common", headers = "Authorization")
/** Objective: Performs updating Beneficiary status flag */
public class UpdateCommonController {
	private Logger logger = LoggerFactory.getLogger(UpdateCommonController.class);
	private InputMapper inputMapper = new InputMapper();
	private CommonNurseServiceImpl commonNurseServiceImpl;

	@Autowired
	public void setCommonNurseServiceImpl(CommonNurseServiceImpl commonNurseServiceImpl)
	{
		this.commonNurseServiceImpl = commonNurseServiceImpl;
	}

	@CrossOrigin
	@ApiOperation(value = "update Beneficiary Status Flag", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/benDetailsAndSubmitToNurse" }, method = { RequestMethod.POST })
	public String saveBeneficiaryVisitDetail(
			@ApiParam(value = "{\"beneficiaryRegID\": \"Long\"}") @RequestBody String comingRequest) {

		OutputResponse response = new OutputResponse();
		inputMapper = new InputMapper();
		logger.info("benDetailsAndSubmitToNurse request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("beneficiaryRegID")) {
				if (obj.getLong("beneficiaryRegID") > 0) {

					Integer i = commonNurseServiceImpl.updateBeneficiaryStatus('R', obj.getLong("beneficiaryRegID"));
					if (i != null && i > 0) {
						response.setResponse("Beneficiary Successfully Submitted to Nurse Work-List.");
					} else {
						response.setError(500, "Something went Wrong please try after Some Time !!!");
					}

				} else {
					response.setError(500, "Beneficiary Registration ID is Not valid !!!");
				}
			} else {
				response.setError(500, "Beneficiary Registration ID is Not valid !!!");
			}
			logger.info("benDetailsAndSubmitToNurse response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in benDetailsAndSubmitToNurse:" + e);
		}

		return response.toString();
	}
}
