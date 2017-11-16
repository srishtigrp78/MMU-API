package com.iemr.mmu.controller.doctor.master.quickConsultation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.controller.doctor.main.cancerScreening.DoctorController;
import com.iemr.mmu.service.doctor.DoctorServiceImpl;
import com.iemr.mmu.service.masterservice.DoctorMasterDataService;
import com.iemr.mmu.service.masterservice.DoctorMasterDataServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping({ "/doctor" })
/** Objective: Provides Quick Consultation master data for doctor*/
public class MasterQCController {

	private InputMapper inputMapper = new InputMapper();
	private OutputResponse response;
	private Logger logger = LoggerFactory.getLogger(MasterQCController.class);
	private DoctorMasterDataService doctorMasterDataService;
	private DoctorMasterDataServiceImpl doctorMasterDataServiceImpl;

	@Autowired
	private DoctorServiceImpl doctorServiceImpl;

	@Autowired
	public void setDoctorMasterDataServiceImpl(DoctorMasterDataServiceImpl doctorMasterDataServiceImpl) {
		this.doctorMasterDataServiceImpl = doctorMasterDataServiceImpl;
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Quick Consultation master data", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/quickConsultationMasterData" }, method = { RequestMethod.GET })
	public String quickConsultationMasterData() {
		OutputResponse response = new OutputResponse();
		try {
			String s = doctorServiceImpl.getQuickConsultMasterData();
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
