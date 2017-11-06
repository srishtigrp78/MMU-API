package com.iemr.mmu.controller.emergencyCasesheet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.iemr.mmu.controller.doctor.DoctorController;
import com.iemr.mmu.data.emergencyCasesheet.BenChiefComplaint;
import com.iemr.mmu.data.emergencyCasesheet.BenClinicalObservations;
import com.iemr.mmu.data.emergencyCasesheet.LabTestOrderDetail;
import com.iemr.mmu.data.emergencyCasesheet.PrescribedDrugDetail;
import com.iemr.mmu.data.emergencyCasesheet.PrescriptionDetail;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.service.emergencyCasesheet.EmergencyCasesheetServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping({ "/emergencyCaseSheet" })
public class EmergencyCasesheetController {
	
	private InputMapper inputMapper = new InputMapper();
	private OutputResponse response;
	private Logger logger = LoggerFactory.getLogger(DoctorController.class);
	private EmergencyCasesheetServiceImpl emergencyCasesheetServiceImpl;
	
	public void setEmergencyCasesheetServiceImpl(EmergencyCasesheetServiceImpl emergencyCasesheetServiceImpl) {
		this.emergencyCasesheetServiceImpl = emergencyCasesheetServiceImpl;
	}
	
	@CrossOrigin
	@ApiOperation(
			value = "save Emergency Casesheet Detail",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value = { "/save/doctor/emergencyCaseSheet" }, method = { RequestMethod.POST })
	public String saveEmergencyCaseSheetDetail(@RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		inputMapper = new InputMapper();
		logger.info("saveEmergencyCaseSheetDetail request:" + requestObj);
		
		BenChiefComplaint benChiefComplaint = InputMapper.gson().fromJson(requestObj,BenChiefComplaint.class);
		BenClinicalObservations benClinicalObservations = InputMapper.gson().fromJson(requestObj,BenClinicalObservations.class);
		PrescriptionDetail prescriptionDetail = InputMapper.gson().fromJson(requestObj,PrescriptionDetail.class);
		PrescribedDrugDetail prescribedDrugDetail = InputMapper.gson().fromJson(requestObj,PrescribedDrugDetail.class);
		LabTestOrderDetail[] labTestOrderDetail = InputMapper.gson().fromJson(requestObj,LabTestOrderDetail[].class);
		
		List<LabTestOrderDetail> labTestOrderDetails = Arrays.asList(labTestOrderDetail);
		try {
			
		} catch (Exception e) {
			response.setError(e);
			
		}

		return response.toString();
	}

}
