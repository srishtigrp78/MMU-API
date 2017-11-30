package com.iemr.mmu.controller.doctor.master.cancerScreening;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.service.common.master.DoctorMasterDataService;
import com.iemr.mmu.service.common.master.DoctorMasterDataServiceImpl;
import com.iemr.mmu.service.doctor.DoctorServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping({ "/doctor" })
/** Objective: Provides Cancer Screening master data for doctor */
public class DoctorCSMasterController {
	private InputMapper inputMapper = new InputMapper();
	private OutputResponse response;
	private Logger logger = LoggerFactory.getLogger(DoctorCSMasterController.class);
	private DoctorMasterDataService doctorMasterDataService;
	private DoctorMasterDataServiceImpl doctorMasterDataServiceImpl;

	@Autowired
	private DoctorServiceImpl doctorServiceImpl;

	@Autowired
	public void setDoctorMasterDataServiceImpl(DoctorMasterDataServiceImpl doctorMasterDataServiceImpl) {
		this.doctorMasterDataServiceImpl = doctorMasterDataServiceImpl;
	}

	@CrossOrigin()
	@ApiOperation(value = "provides doctor master Data", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/doctorMasterData" }, method = { RequestMethod.POST })
	public String getMasterDataForDoctor(@RequestBody String requestOBJ) {

		OutputResponse response = new OutputResponse();
		logger.info("getMasterDataForDoctor..");
		try {
			JSONObject obj = new JSONObject(requestOBJ);
			if (obj != null && obj.has("psmID") && obj.getInt("psmID") > 0) {
				response.setResponse(
						doctorMasterDataServiceImpl.getCancerScreeningMasterDataForDoctor(obj.getInt("psmID")));
				logger.info("getMasterDataForDoctor response:" + response);
			} else {
				response.setError(5000, "Provider Service MapID is missing !!!");
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getMasterDataForDoctor:" + e);
		}
		return response.toString();
	}

}
