package com.iemr.mmu.controller.nurse.main.anc;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.service.anc.ANCServiceImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping({ "/anc" })
public class FetchNurseANCController {
	private InputMapper inputMapper;
	private Logger logger = LoggerFactory.getLogger(FetchNurseANCController.class);

	private NurseServiceImpl nurseServiceImpl;

	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}

	private ANCServiceImpl aNCServiceImpl;

	@Autowired
	public void setANCServiceImpl(ANCServiceImpl aNCServiceImpl) {
		this.aNCServiceImpl = aNCServiceImpl;
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary Visit details from Nurse ANC", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenVisitDetailsFrmNurseANC" }, method = { RequestMethod.POST })
	public String getBenVisitDetailsFrmNurseANC(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenVisitDetailsFrmNurseANC request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.length() > 1) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String s = nurseServiceImpl.getBenDataFrmNurseToDocVisitDetailsScreen(benRegID, benVisitID);
				response.setResponse(s);
			} else {

			}
			logger.info("getBenDataFrmNurseScrnToDocScrnVisitDetails response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenDataFrmNurseScrnToDocScrnVisitDetails:" + e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary ANC Examination details from Nurse to Doctor ", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenExaminationDetailsANC" }, method = { RequestMethod.POST })
	public String getBenExaminationDetailsANC(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"benVisitID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("getBenVisitDetailsFrmNurseANC request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID") && obj.has("benVisitID")) {
				Long benRegID = obj.getLong("benRegID");
				Long benVisitID = obj.getLong("benVisitID");

				String s = aNCServiceImpl.getANCExaminationDetailsData(benRegID, benVisitID);
				response.setResponse(s);
			} else {
				response.setError(5000, "Wrong data !!!");
			}
			logger.info("getBenDataFrmNurseScrnToDocScrnVisitDetails response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getBenDataFrmNurseScrnToDocScrnVisitDetails:" + e);
		}
		return response.toString();
	}

}
