package com.iemr.mmu.controller.nurse.main.anc;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.data.anc.ANCCareDetails;
import com.iemr.mmu.data.anc.BenAdherence;
import com.iemr.mmu.data.anc.BenAllergyHistory;
import com.iemr.mmu.data.anc.BenFamilyHistory;
import com.iemr.mmu.data.anc.BenMedHistory;
import com.iemr.mmu.data.anc.BenPersonalHabit;
import com.iemr.mmu.data.anc.WrapperAncImmunization;
import com.iemr.mmu.data.anc.WrapperBenInvestigationANC;
import com.iemr.mmu.data.anc.WrapperChildOptionalVaccineDetail;
import com.iemr.mmu.data.anc.WrapperComorbidCondDetails;
import com.iemr.mmu.data.anc.WrapperImmunizationHistory;
import com.iemr.mmu.data.anc.WrapperMedicationHistory;
import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.service.anc.ANCServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping({ "/anc" })
public class UpdateNurseANCController {
	private InputMapper inputMapper;
	private Logger logger = LoggerFactory.getLogger(InsertNurseANCController.class);

	private ANCServiceImpl ancServiceImpl;

	@Autowired
	public void setAncServiceImpl(ANCServiceImpl ancServiceImpl) {
		this.ancServiceImpl = ancServiceImpl;
	}

	@CrossOrigin
	@ApiOperation(value = "Update Beneficiary Adherence", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/visitDetails/adherence" }, method = { RequestMethod.POST })
	public String updateBenAdherence(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("UpdateBenAdherenceDetail request:" + requestObj);
		// inputMapper = new InputMapper();
		try {
			if (requestObj != null) {
				BenAdherence benAdherence = InputMapper.gson().fromJson(requestObj, BenAdherence.class);
				int r = ancServiceImpl.updateBenAdherenceDetails(benAdherence);
				if (r > 0) {
					response.setResponse("Ben Adherence data update successfully.");
				} else {
					response.setError(5000, "Something went wrong !!!");
				}
			} else {
				response.setError(5000, "Invalid request Data");
			}
		} catch (Exception e) {
		}
		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Update Beneficiary Chief complaints", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/visitDetails/chiefComplaints" }, method = { RequestMethod.POST })
	public String updateBenchiefComplaints(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("updateBenchiefComplaints request:" + requestObj);
		try {
			if (requestObj != null) {
				BenChiefComplaint[] benChiefComplaintArray = InputMapper.gson().fromJson(requestObj,
						BenChiefComplaint[].class);

				List<BenChiefComplaint> benChiefComplaintList = Arrays.asList(benChiefComplaintArray);
				int r = ancServiceImpl.updateBenChiefComplaints(benChiefComplaintList);

				if (r > 0) {
					response.setResponse("Chief-complaints data updated successfully.");
				} else {
					response.setError(5000, "Something went Wrong !!!");
				}
			} else {
				response.setError(5000, "Invalid request Data");
			}
			// inputMapper = new InputMapper();
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Update Beneficiary Investigations", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/visitDetails/investigations" }, method = { RequestMethod.POST })
	public String updateBenInvestigations(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("updateBenInvestigations request:" + requestObj);
		try {
			if (requestObj != null) {
				WrapperBenInvestigationANC wrapperBenInvestigationANC = InputMapper.gson().fromJson(requestObj,
						WrapperBenInvestigationANC.class);
	
				if (wrapperBenInvestigationANC != null) {
					Long prescriptionID = ancServiceImpl.updateBenInvestigation(wrapperBenInvestigationANC);
					if (prescriptionID != null && prescriptionID > 0) {
						response.setResponse("Investigation data updated successfully.");
					} else {
						response.setError(5000, "Something went wrong !!!");
					}
				} else {
					response.setError(5000, "Invalid Data !!!");
				}
			}
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Update Beneficiary ANC Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/ANC/ANCDetails" }, method = { RequestMethod.POST })
	public String updateBenANCDetails(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("Update Beneficiary ANC details and ANC Obstetric" + requestObj);
		try {
			if (requestObj != null) {
				ANCCareDetails ancCareDetailsOBJ = InputMapper.gson().fromJson(requestObj, ANCCareDetails.class);
				int r = ancServiceImpl.updateBenAncCareDetails(ancCareDetailsOBJ);
				if (r > 0) {
					response.setResponse("ANC Care data updated successfully.");
				} else {
					response.setError(5000, "Something went wrong !!!");
				}
			} else {
				response.setError(5000, "Invalid request Data");
			}
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Update Beneficiary ANC Immunization Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/ANC/ANCImmunizationDetails" }, method = { RequestMethod.POST })
	public String updateBenANCImmunizationDetails(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("Update Beneficiary ANC Immunization details " + requestObj);
		try {
			if (requestObj != null) {
				WrapperAncImmunization wrapperAncImmunization = InputMapper.gson().fromJson(requestObj, WrapperAncImmunization.class);
				int r = ancServiceImpl.updateBenAncImmunizationDetails(wrapperAncImmunization);
				if (r > 0) {
					response.setResponse("ANC Immunization data updated successfully.");
				} else {
					response.setError(5000, "Something went wrong !!!");
				}
			} else {
				response.setError(5000, "Invalid request Data");
			}
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Update Beneficiary ANC Past History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/history/pastHistoryDetails" }, method = { RequestMethod.POST })
	public String updateBenANCPastHistoryDetails(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("Update Beneficiary ANC Past History details " + requestObj);
		try {
			if (requestObj != null) {
				BenMedHistory benMedHistory = InputMapper.gson().fromJson(requestObj, BenMedHistory.class);
				int r = ancServiceImpl.updateBenAncPastHistoryDetails(benMedHistory);
				if (r > 0) {
					response.setResponse("ANC Past History data updated successfully.");
				} else {
					response.setError(5000, "Something went wrong !!!");
				}
			} else {
				response.setError(5000, "Invalid request Data");
			}
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Update Beneficiary ANC ComorbidCondition Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/history/comorbidConditions" }, method = { RequestMethod.POST })
	public String updateANCBenComorbidConditions(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("updateANCBenComorbidConditions request:" + requestObj);
		try {
			if (requestObj != null) {
				WrapperComorbidCondDetails wrapperComorbidCondDetails = InputMapper.gson().fromJson(requestObj,
						WrapperComorbidCondDetails.class);

				int r = ancServiceImpl.updateBenANCComorbidConditions(wrapperComorbidCondDetails);
				if (r > 0) {
					response.setResponse("Beneficairy ComorbidCondition Details updated successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
				logger.info("updateANCBenComorbidConditions response:" + response);
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error while storing Beneficiary ANC Comorbid Conditions."+e);
		}
		return response.toString();
	}
	
	
	@CrossOrigin
	@ApiOperation(value = "Update Beneficiary ANC Medication History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/history/medicationHistory" }, method = { RequestMethod.POST })
	public String updateANCBenMedicationHistory(@ApiParam(value = "{\"medicationHistoryList\":[{\"currentMedication\": \"String\","
			+ "\"timePeriodAgo\":\"Integer\", \"timePeriodUnit\":\"String\"}], \"beneficiaryRegID\":\"Long\", \"benVisitID\":\"Long\", "
			+ "\"providerServiceMapID\":\"Integer\", \"createdBy\":\"String\"}") @RequestBody String requestObj) {
		
		OutputResponse response = new OutputResponse();
		logger.info("updateANCBenMedicationHistory request:" + requestObj);
		try {
			if (requestObj != null) {
				WrapperMedicationHistory wrapperMedicationHistory = InputMapper.gson().fromJson(requestObj,
						WrapperMedicationHistory.class);

				int r = ancServiceImpl.updateBenANCMedicationHistory(wrapperMedicationHistory);
				if (r > 0) {
					response.setResponse("Beneficiary ANC Medication History Details updated successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
				logger.info("updateANCBenMedicationHistory response:" + response);
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error while storing Beneficiary ANC Medication History."+e);
		}
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "Update Beneficiary ANC Personal History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/history/personalHistory" }, method = { RequestMethod.POST })
	public String updateANCBenPersonalHistory(@ApiParam(value = "{\"dietaryType\": \"String\","
			+ "\"physicalActivityType\":\"String\", \"riskySexualPracticesStatus\":\"Character\",\"tobaccoUseStatus\":\"String\", "
			+ "\"alcoholIntakeStatus\":\"String\",\"allergyStatus\":\"String\", \"tobaccoList\":[{\"tobaccoUseTypeID\":\"String\", "
			+ "\"tobaccoUseType\":\"String\", \"otherTobaccoUseType\":\"String\", \"numberperDay\":\"Short\", \"duration\":\"Integer\""
			+ "\"durationUnit\":\"String\"}],\"alcoholList\":[{\"alcoholTypeID\":\"String\", \"alcoholType\":\"String\", "
			+ "\"otherAlcoholType\":\"String\", \"alcoholIntakeFrequency\":\"String\", \"avgAlcoholConsumption\":\"String\""
			+ "\"duration\":\"Integer\", \"durationUnit\":\"String\"}], \"allergicList\":[{\"allergyType\":\"String\", \"allergenName\":\"String\", "
			+ "\"typeOfAllergicReactions\":[{\"name\":\"String\", \"allergicReactionTypeID\":\"String\"}],"
			+ "\"otherAllergicReaction\":\"String\", \"remarks\":\"String\"}],"
			+ "\"beneficiaryRegID\":\"Long\", \"benVisitID\":\"Long\", "
			+ "\"providerServiceMapID\":\"Integer\", \"createdBy\":\"String\"}") @RequestBody String requestObj) {
				  
		OutputResponse response = new OutputResponse();
		logger.info("updateANCBenPersonalHistory request:" + requestObj);
		try {
			if (requestObj != null) {
				BenPersonalHabit personalHabit = InputMapper.gson().fromJson(requestObj,
						BenPersonalHabit.class);
				
				BenAllergyHistory benAllergyHistory = InputMapper.gson().fromJson(requestObj,
						BenAllergyHistory.class);

				int r = ancServiceImpl.updateBenANCPersonalHistory(personalHabit);
				
				int s = ancServiceImpl.updateBenANCAllergicHistory(benAllergyHistory);
				if ( r > 0 && s > 0) {
					response.setResponse("Beneficiary ANC Personal History Details updated successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
				logger.info("updateANCBenPersonalHistory response:" + response);
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error while storing Beneficiary ANC Personal History."+e);
		}
		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Update Beneficiary ANC Family History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/history/familyHistory" }, method = { RequestMethod.POST })
	public String updateANCBenFamilyHistory(@ApiParam(value = "{\"familyDiseaseList\": [{\"diseaseTypeID\":\"Short\", \"diseaseType\":\"String\","
			+ "\"otherDiseaseType\":\"String\", \"familyMembers\":\"List\"]}, \"isGeneticDisorder\":\"Boolean\",\"geneticDisorder\":\"String\", "
			+ "\"isConsanguineousMarrige\":\"Boolean\", \"beneficiaryRegID\":\"Long\", \"benVisitID\":\"Long\", "
			+ "\"providerServiceMapID\":\"Integer\", \"createdBy\":\"String\"}") @RequestBody String requestObj) {
				  
		OutputResponse response = new OutputResponse();
		logger.info("updateANCBenFamilyHistory request:" + requestObj);
		try {
			if (requestObj != null) {
				BenFamilyHistory benFamilyHistory = InputMapper.gson().fromJson(requestObj,
						BenFamilyHistory.class);
				

				int r = ancServiceImpl.updateBenANCFamilyHistory(benFamilyHistory);
				
				if ( r > 0 ) {
					response.setResponse("Beneficiary ANC Family History Details updated successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
				logger.info("updateANCBenFamilyHistory response:" + response);
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error while storing Beneficiary ANC Personal History."+e);
		}
		return response.toString();
	}

	
	@CrossOrigin
	@ApiOperation(value = "Update Beneficiary ANC Child Optional Vaccine History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/history/childOptionalVaccineHistory" }, method = { RequestMethod.POST })
	public String updateANCChildOptionalVaccineHistory(@ApiParam(value = "{\"childOptionalVaccineList\": [{\"vaccineName\":\"String\", \"otherVaccineName\":\"String\","
			+ "\"actualReceivingAge\":\"String\", \"receivedFacilityName\":\"String\", \"vaccineID\":\"String\"}], \"beneficiaryRegID\":\"Long\", "
			+ "\"benVisitID\":\"Long\", \"providerServiceMapID\":\"Integer\", \"createdBy\":\"String\"}") @RequestBody String requestObj) {
	
		OutputResponse response = new OutputResponse();
		logger.info("updateANCChildOptionalVaccineHistory request:" + requestObj);
		try {
			if (requestObj != null) {
				WrapperChildOptionalVaccineDetail wrapperChildOptionalVaccineDetail = InputMapper.gson().fromJson(requestObj,
						WrapperChildOptionalVaccineDetail.class);
				

				int r = ancServiceImpl.updateChildOptionalVaccineDetail(wrapperChildOptionalVaccineDetail);
				
				if ( r > 0 ) {
					response.setResponse("Beneficiary ANC Child Optional Vaccine History Details updated successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
				logger.info("updateANCChildOptionalVaccineHistory response:" + response);
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error while storing Beneficiary ANC Child Optional Vaccine History."+e);
		}
		return response.toString();
	}
	
	
	@CrossOrigin
	@ApiOperation(value = "Update Beneficiary Vitals", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/vitals" }, method = { RequestMethod.POST })
	public String updateANCAnthropometryVitals(@RequestBody String requestObj) {
	
		OutputResponse response = new OutputResponse();
		logger.info("updateANCVitals request:" + requestObj);
		try {
			if (requestObj != null) {
				BenAnthropometryDetail benAnthropometryDetail = InputMapper.gson().fromJson(requestObj,
						BenAnthropometryDetail.class);
				
				BenPhysicalVitalDetail benPhysicalVitalDetail = InputMapper.gson().fromJson(requestObj,
						BenPhysicalVitalDetail.class);


				int r = ancServiceImpl.updateANCAnthropometryDetails(benAnthropometryDetail);
				int s = ancServiceImpl.updateANCPhysicalVitalDetails(benPhysicalVitalDetail);
				
				if ( r > 0 && s > 0) {
					response.setResponse("Beneficiary ANC Vitals Details updated successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
				logger.info("updateANCVitals response:" + response);
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error while updating Anc Vitals"+e);
		}
		return response.toString();
	}
	
}
