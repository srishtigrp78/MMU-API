package com.iemr.mmu.controller.doctor.main.quickConsultation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.iemr.mmu.data.quickConsultation.WrapperQuickConsultation;
import com.iemr.mmu.service.quickConsultation.QuickConsultationServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping({ "/quickConsultation" })
/** Objective: Saves Beneficiary Quick consultation details entered by doctor */
public class InsertDoctorQCController {

	private InputMapper inputMapper = new InputMapper();
	private OutputResponse response;
	private Logger logger = LoggerFactory.getLogger(InsertDoctorQCController.class);
	private QuickConsultationServiceImpl quickConsultationServiceImpl;

	@Autowired
	public void setEmergencyCasesheetServiceImpl(QuickConsultationServiceImpl quickConsultationServiceImpl) {
		this.quickConsultationServiceImpl = quickConsultationServiceImpl;
	}

	@CrossOrigin
	@ApiOperation(value = "save Quick Consultation Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/doctor/quickConsultation" }, method = { RequestMethod.POST })
	public String saveQuickConsultationDetail(
			@ApiParam(value = "{\"quickConsultation\":{\"beneficiaryRegID\":\"Long\",\"providerServiceMapID\": \"Integer\", \"benVisitID\":\"Long\", \"benChiefComplaint\":[{\"chiefComplaintID\":\"Integer\", "
					+ "\"chiefComplaint\":\"String\", \"duration\":\"Integer\", \"unitOfDuration\":\"String\"}], \"description\":\"String\""
					+ "\"clinicalObservation\":\"String\", \"externalInvestigation\":\"String\", \"diagnosisProvided\":\"String\", \"instruction\":\"String\", \"remarks\":\"String\","
					+ "\"prescribedDrugs\":[{\"drugForm\":\"String\", \"drugTradeOrBrandName\":\"String\", \"genericDrugName\":\"String\", \"drugStrength\":\"String\", "
					+ "\"dose\":\"String\", \"route\":\"String\", \"frequency\":\"String\", \"drugDuration\":\"String\", \"relationToFood\":\"String\", "
					+ "\"specialInstruction\":\"String\"}], \"labTestOrders\":[{\"testID\":\"String\", \"testName\":\"String\", \"testingRequirements\":\"String\","
					+ " \"isRadiologyImaging\":\"String\", \"createdBy\":\"String\"}, {\"testID\":\"Integer\", \"testName\":\"String\", "
					+ "\"testingRequirements\":\"String\", \"isRadiologyImaging\":\"Boolean\"}],"
					+ "\"createdBy\":\"String\"}}") @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		inputMapper = new InputMapper();
		logger.info("saveQuickConsultationDetail request:" + requestObj);

		/*
		 * BenChiefComplaint benChiefComplaint =
		 * InputMapper.gson().fromJson(requestObj,BenChiefComplaint.class);
		 * BenClinicalObservations benClinicalObservations =
		 * InputMapper.gson().fromJson(requestObj,BenClinicalObservations.class)
		 * ; PrescriptionDetail prescriptionDetail =
		 * InputMapper.gson().fromJson(requestObj,PrescriptionDetail.class);
		 * PrescribedDrugDetail prescribedDrugDetail =
		 * InputMapper.gson().fromJson(requestObj,PrescribedDrugDetail.class);
		 */

		WrapperQuickConsultation wrapperQuickConsultation = InputMapper.gson().fromJson(requestObj,
				WrapperQuickConsultation.class);

		JsonObject caseSheet = wrapperQuickConsultation.getQuickConsultation();

		// List<LabTestOrderDetail> labTestOrderDetails =
		// wrapperQuickConsultation.getLabTestOrders();
		try {
			Long benChiefComplaintID = quickConsultationServiceImpl.saveBeneficiaryChiefComplaint(caseSheet);
			Long clinicalObservationID = quickConsultationServiceImpl.saveBeneficiaryClinicalObservations(caseSheet);
			Long prescriptionID = quickConsultationServiceImpl.saveBeneficiaryPrescription(caseSheet);

			Long prescribedDrugID = null;
			Long labTestOrderID = null;

			if (prescriptionID != null && prescriptionID > 0) {

				prescribedDrugID = quickConsultationServiceImpl.saveBeneficiaryPrescribedDrugDetail(caseSheet,
						prescriptionID);

				labTestOrderID = quickConsultationServiceImpl.saveBeneficiaryLabTestOrderDetails(caseSheet,
						prescriptionID);

			}
			// Long externalLabTestOrderID =
			// quickConsultationServiceImpl.saveBeneficiaryExternalLabTestOrderDetails(caseSheet);
			// && (null != externalLabTestOrderID && externalLabTestOrderID > 0)
			if ((null != benChiefComplaintID && benChiefComplaintID > 0)
					&& (null != clinicalObservationID && clinicalObservationID > 0) && prescriptionID > 0) {
				response.setResponse("Quick Consultation Details stored successfully");
			} else {
				response.setError(500, "Something Went-Wrong");
			}
			logger.info("saveQuickConsultationDetail response:" + response);
		} catch (Exception e) {
			response.setError(e);
			e.printStackTrace();
			logger.error("Error in saveQuickConsultationDetail:" + e);
		}

		return response.toString();
	}

}
