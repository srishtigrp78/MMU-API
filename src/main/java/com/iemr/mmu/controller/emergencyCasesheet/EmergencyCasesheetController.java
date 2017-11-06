package com.iemr.mmu.controller.emergencyCasesheet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.iemr.mmu.controller.doctor.DoctorController;
import com.iemr.mmu.data.emergencyCasesheet.BenChiefComplaint;
import com.iemr.mmu.data.emergencyCasesheet.BenClinicalObservations;
import com.iemr.mmu.data.emergencyCasesheet.LabTestOrderDetail;
import com.iemr.mmu.data.emergencyCasesheet.PrescribedDrugDetail;
import com.iemr.mmu.data.emergencyCasesheet.PrescriptionDetail;
import com.iemr.mmu.data.emergencyCasesheet.WrapperEmergencyCaseSheet;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.data.registrar.WrapperBeneficiaryRegistration;
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
	
	@Autowired
	public void setEmergencyCasesheetServiceImpl(EmergencyCasesheetServiceImpl emergencyCasesheetServiceImpl) {
		this.emergencyCasesheetServiceImpl = emergencyCasesheetServiceImpl;
	}
	
	@CrossOrigin
	@ApiOperation(
			value = "save Emergency Casesheet Detail",
			consumes = "application/json",
			produces = "application/json")
	@RequestMapping(value = { "/save/doctor/emergencyCaseSheet" }, method = { RequestMethod.POST })
	public String saveEmergencyCaseSheetDetail(@ApiParam(
			value = "{\"emCaseSheet\":{\"beneficiaryRegID\":\"Long\",\"providerServiceMapID\": \"Integer\", \"benVisitID\":\"Long\", \"benChiefComplaint\":[{\"chiefComplaintID\":\"Integer\", "
					+ "\"chiefComplaint\":\"String\", \"duration\":\"Integer\", \"unitOfDuration\":\"String\", \"description\":\"String\"}], "
					+ "\"clinicalObservation\":\"String\", \"diagnosisProvided\":\"String\", \"instruction\":\"String\", \"remarks\":\"String\","
					+ "\"prescribedDrugs\":[{\"drugForm\":\"String\", \"drugTradeOrBrandName\":\"String\", \"genericDrugName\":\"String\", \"drugStrength\":\"String\", "
					+ "\"dose\":\"String\", \"route\":\"String\", \"frequency\":\"String\", \"drugDuration\":\"String\", \"relationToFood\":\"String\", "
					+ "\"specialInstruction\":\"String\"}], \"labTestOrders\":[{\"testID\":\"String\", \"orderedTestName\":\"String\", \"testingRequirements\":\"String\","
					+ " \"isRadiologyImaging\":\"String\", \"createdBy\":\"String\"}, {\"testID\":\"Integer\", \"orderedTestName\":\"String\", "
					+ "\"testingRequirements\":\"String\", \"isRadiologyImaging\":\"Boolean\"}],"
					+ "\"createdBy\":\"String\"}}") @RequestBody String requestObj) {
		
		OutputResponse response = new OutputResponse();
		inputMapper = new InputMapper();
		logger.info("saveEmergencyCaseSheetDetail request:" + requestObj);
		
/*		BenChiefComplaint benChiefComplaint = InputMapper.gson().fromJson(requestObj,BenChiefComplaint.class);
		BenClinicalObservations benClinicalObservations = InputMapper.gson().fromJson(requestObj,BenClinicalObservations.class);
		PrescriptionDetail prescriptionDetail = InputMapper.gson().fromJson(requestObj,PrescriptionDetail.class);
		PrescribedDrugDetail prescribedDrugDetail = InputMapper.gson().fromJson(requestObj,PrescribedDrugDetail.class);*/

		
		
		WrapperEmergencyCaseSheet wrapperEmergencyCaseSheet = InputMapper.gson().fromJson(requestObj,WrapperEmergencyCaseSheet.class);
		
		JsonObject caseSheet = wrapperEmergencyCaseSheet.getEmCaseSheet();
		
		//List<LabTestOrderDetail> labTestOrderDetails = wrapperEmergencyCaseSheet.getLabTestOrders();
		try {
			Long benChiefComplaintID = emergencyCasesheetServiceImpl.saveBeneficiaryChiefComplaint(caseSheet);
			Long clinicalObservationID = emergencyCasesheetServiceImpl.saveBeneficiaryClinicalObservations(caseSheet);
			Long prescriptionID = emergencyCasesheetServiceImpl.saveBeneficiaryPrescription(caseSheet);
			
			Long prescribedDrugID = null;
			Long labTestOrderID = null;
			
			if (prescriptionID != null && prescriptionID > 0) {
				
				prescribedDrugID = emergencyCasesheetServiceImpl.saveBeneficiaryPrescribedDrugDetail(caseSheet, prescriptionID);
				
				
			    labTestOrderID = emergencyCasesheetServiceImpl.saveBeneficiaryLabTestOrderDetails(caseSheet, prescriptionID);
				
			    
			} 
			if((null != benChiefComplaintID && benChiefComplaintID > 0) && (null != clinicalObservationID && clinicalObservationID > 0) && 
					(null != prescriptionID && prescriptionID > 0) && (null != prescribedDrugID && prescribedDrugID > 0) && (null != labTestOrderID && labTestOrderID > 0)){
				response.setResponse("Emergency CaseSheet Details stored successfully");
			}else {
				response.setError(500, "Something Went-Wrong");
			}
			logger.info("saveEmergencyCaseSheetDetail response:" + response);
		} catch (Exception e) {
			response.setError(e);
			e.printStackTrace();
			logger.error("Error in saveEmergencyCaseSheetDetail:" + e);
		}

		return response.toString();
	}

}
