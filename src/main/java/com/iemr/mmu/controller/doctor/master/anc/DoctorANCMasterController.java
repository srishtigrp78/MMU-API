package com.iemr.mmu.controller.doctor.master.anc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.controller.nurse.master.anc.NurseANCMasterController;
import com.iemr.mmu.service.masterservice.ANCMasterDataServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping({ "/anc" })
/** Objective: Provides ANC master data for doctor*/
public class DoctorANCMasterController {
	
	private InputMapper inputMapper = new InputMapper();
	private OutputResponse response;
	private Logger logger = LoggerFactory.getLogger(DoctorANCMasterController.class);
	
	private ANCMasterDataServiceImpl ancMasterDataServiceImpl;
	
	@Autowired
	public void setAncMasterDataServiceImpl(ANCMasterDataServiceImpl ancMasterDataServiceImpl) {
		this.ancMasterDataServiceImpl = ancMasterDataServiceImpl;
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Doctor ANC master data", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/ancDoctorMasterData" }, method = { RequestMethod.GET })
	public String getDoctorMasterDataForANC() {
		OutputResponse response = new OutputResponse();
		try {
			String s = ancMasterDataServiceImpl.getANCMasterDataForDoctor();
			if (s != null)
				response.setResponse(s);
			else
				response.setError(5000, "No Master Data Available");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Quick Consultation master data:" + e);
			response.setError(e);
		}
		return response.toString();
	}
}
