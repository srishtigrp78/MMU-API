package com.iemr.mmu.controller.radiologist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.controller.doctor.main.cancerScreening.FetchDoctorCSController;
import com.iemr.mmu.service.common.master.DoctorMasterDataService;
import com.iemr.mmu.service.radiologist.RadiologistServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = "/radiologist", headers = "Authorization")
public class FetchRadiologistController {

	private OutputResponse response;
	private Logger logger = LoggerFactory.getLogger(FetchDoctorCSController.class);
	private DoctorMasterDataService doctorMasterDataService;

	private RadiologistServiceImpl radiologistServiceImpl;

	@Autowired
	public void setRadiologistServiceImpl(RadiologistServiceImpl radiologistServiceImpl) {
		this.radiologistServiceImpl = radiologistServiceImpl;
	}

	@CrossOrigin()
	@ApiOperation(value = "provides Radiologist worklist", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getRadiologistWorklist" }, method = { RequestMethod.GET })
	public String getRadioWorkList() {
		OutputResponse response = new OutputResponse();
		try {
			String s = radiologistServiceImpl.getRadiologistWorkList();
			response.setResponse(s);
		} catch (Exception e) {
			logger.error("Error in getRadiologistWorkList:" + e);
			response.setError(e);
		}
		return response.toString();
	}
}
