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
import com.iemr.mmu.data.anc.BenChildDevelopmentHistory;
import com.iemr.mmu.data.anc.BenFamilyHistory;
import com.iemr.mmu.data.anc.BenMedHistory;
import com.iemr.mmu.data.anc.BenMenstrualDetails;
import com.iemr.mmu.data.anc.BenPersonalHabit;
import com.iemr.mmu.data.anc.BencomrbidityCondDetails;
import com.iemr.mmu.data.anc.ChildFeedingDetails;
import com.iemr.mmu.data.anc.ChildOptionalVaccineDetail;
import com.iemr.mmu.data.anc.ChildVaccineDetail1;
import com.iemr.mmu.data.anc.FemaleObstetricHistory;
import com.iemr.mmu.data.anc.PerinatalHistory;
import com.iemr.mmu.data.anc.PhyGeneralExamination;
import com.iemr.mmu.data.anc.PhyHeadToToeExamination;
import com.iemr.mmu.data.anc.SysCardiovascularExamination;
import com.iemr.mmu.data.anc.SysCentralNervousExamination;
import com.iemr.mmu.data.anc.SysGastrointestinalExamination;
import com.iemr.mmu.data.anc.SysGenitourinarySystemExamination;
import com.iemr.mmu.data.anc.SysMusculoskeletalSystemExamination;
import com.iemr.mmu.data.anc.SysObstetricExamination;
import com.iemr.mmu.data.anc.SysRespiratoryExamination;
import com.iemr.mmu.data.anc.WrapperAncImmunization;
import com.iemr.mmu.data.anc.WrapperBenInvestigationANC;
import com.iemr.mmu.data.anc.WrapperChildOptionalVaccineDetail;
import com.iemr.mmu.data.anc.WrapperComorbidCondDetails;
import com.iemr.mmu.data.anc.WrapperFemaleObstetricHistory;
import com.iemr.mmu.data.anc.WrapperImmunizationHistory;
import com.iemr.mmu.data.anc.WrapperMedicationHistory;
import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;
import com.iemr.mmu.service.anc.ANCServiceImpl;
import com.iemr.mmu.service.quickConsultation.QuickConsultationServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping({ "/anc" })
public class InsertNurseANCController {
	private InputMapper inputMapper;
	private Logger logger = LoggerFactory.getLogger(InsertNurseANCController.class);

	private ANCServiceImpl ancServiceImpl;

	@Autowired
	public void setAncServiceImpl(ANCServiceImpl ancServiceImpl) {
		this.ancServiceImpl = ancServiceImpl;
	}

	private QuickConsultationServiceImpl quickConsultationServiceImpl;

	@Autowired
	public void setEmergencyCasesheetServiceImpl(QuickConsultationServiceImpl quickConsultationServiceImpl) {
		this.quickConsultationServiceImpl = quickConsultationServiceImpl;
	}

	@CrossOrigin
	@ApiOperation(value = "save Beneficiary Adherence", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/visitDetails/adherence" }, method = { RequestMethod.POST })
	public String saveBenAdherence(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("saveBeneficiaryANCCareDetail request:" + requestObj);
		// inputMapper = new InputMapper();
		try {
			if (requestObj != null) {
				BenAdherence benAdherence = InputMapper.gson().fromJson(requestObj, BenAdherence.class);
				int r = ancServiceImpl.saveBenAdherenceDetails(benAdherence);
				if (r > 0) {
					response.setResponse("Ben Adherence data saved successfully.");
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
	@ApiOperation(value = "save Beneficiary Chief complaints", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/visitDetails/chiefComplaints" }, method = { RequestMethod.POST })
	public String saveBenchiefComplaints(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("saveBeneficiaryANCCareDetail request:" + requestObj);
		try {
			if (requestObj != null) {
				BenChiefComplaint[] benChiefComplaintArray = InputMapper.gson().fromJson(requestObj,
						BenChiefComplaint[].class);

				List<BenChiefComplaint> benChiefComplaintList = Arrays.asList(benChiefComplaintArray);
				int r = ancServiceImpl.saveBenChiefComplaints(benChiefComplaintList);

				if (r > 0) {
					response.setResponse("Chief-complaints data saved successfully.");
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
	@ApiOperation(value = "save Beneficiary Investigation", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/visitDetails/investigation" }, method = { RequestMethod.POST })
	public String saveBenInvestigation(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("saveBeneficiaryANCCareDetail request:" + requestObj);
		try {
			WrapperBenInvestigationANC wrapperBenInvestigationANC = InputMapper.gson().fromJson(requestObj,
					WrapperBenInvestigationANC.class);

			if (wrapperBenInvestigationANC != null) {
				Long prescriptionID = ancServiceImpl.saveBenInvestigation(wrapperBenInvestigationANC);
				if (prescriptionID != null && prescriptionID > 0) {
					response.setResponse("Investigation data saved successfully.");
				} else {
					response.setError(5000, "Something went wrong !!!");
				}
			} else {
				response.setError(5000, "Invalid Data !!!");
			}
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "Save Beneficiary ANC details and ANC Obstetric", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/ANC/ancDetails_obstetricFormula" }, method = { RequestMethod.POST })
	public String saveBenAncDetails_obstetricFormula(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("Save Beneficiary ANC details and ANC Obstetric" + requestObj);
		try {
			if (requestObj != null) {
				ANCCareDetails ancCareDetailsOBJ = InputMapper.gson().fromJson(requestObj, ANCCareDetails.class);
				int r = ancServiceImpl.saveBenAncCareDetails(ancCareDetailsOBJ);
				if (r > 0) {
					response.setResponse("ANC Care data saved successfully.");
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
	@ApiOperation(value = "Save Beneficiary ANC Immunization data", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/ANC/ancImmunization" }, method = { RequestMethod.POST })

	public String saveBenAncImmunization(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("Save Beneficiary ANC Immunization details " + requestObj);
		try {
			if (requestObj != null) {
				WrapperAncImmunization wrapperAncImmunizationOBJ = InputMapper.gson().fromJson(requestObj,
						WrapperAncImmunization.class);
				int r = ancServiceImpl.saveAncImmunizationDetails(wrapperAncImmunizationOBJ);
				if (r > 0) {
					response.setResponse("ANC Immunization data saved Successfully.");
				} else {
					response.setError(5000, "Something Went Wrong !!!");
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
	@ApiOperation(value = "save Beneficiary Physical General Examination Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/examination/generalExamination" }, method = { RequestMethod.POST })
	public String saveBenGeneralExamination(@ApiParam(value = "{\"beneficiaryRegID\":\"Long\",\"benVisitID\": \"Long\","
			+ "\"consciousness\":\"String\", \"coherence\":\"String\", \"cooperation\":\"String\", \"comfortness\":\"String\","
			+ "\"builtAndAppearance\":\"String\", \"gait\":\"String\", \"dangerSigns\":\"String\", \"typeOfDangerSigns\":\"String\", \"pallor\":\"String\", "
			+ "\"jaundice\":\"String\", \"cyanosis\":\"String\", \"clubbing\":\"String\", \"lymphadenopathy\":\"String\", \"lymphnodesInvolved\":\"String\", "
			+ "\"typeOfLymphadenopathy\":\"String\", \"edema\":\"String\",  \"extentOfEdema\":\"String\", \"edemaType\":\"String\", \"createdBy\":\"String\"}") @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("saveBenGeneralExamination request:" + requestObj);
		try {
			inputMapper = new InputMapper();
			if (requestObj != null) {
				PhyGeneralExamination generalExamination = InputMapper.gson().fromJson(requestObj,
						PhyGeneralExamination.class);
				int r = ancServiceImpl.savePhyGeneralExamination(generalExamination);
				if (r > 0) {
					response.setResponse("Ben General Examination data saved successfully.");
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

	@ApiOperation(value = "save Beneficiary Physical Head To Toe Examination Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/examination/headToToeExamination" }, method = { RequestMethod.POST })
	public String saveBenHeadToToeExamination(
			@ApiParam(value = "{\"beneficiaryRegID\":\"Long\",\"benVisitID\": \"Long\","
					+ "\"headtoToeExam\":\"String\", \"head\":\"String\", \"eyes\":\"String\", \"ears\":\"String\", \"nose\":\"String\", "
					+ "\"oralCavity\":\"String\", \"throat\":\"String\", \"breastAndNipples\":\"String\", \"trunk\":\"String\", \"upperLimbs\":\"String\", "
					+ "\"lowerLimbs\":\"String\", \"skin\":\"String\", \"hair\":\"String\", \"nails\":\"String\", \"createdBy\":\"String\"}") @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("saveBenHeadToToeExamination request:" + requestObj);
		try {
			inputMapper = new InputMapper();
			if (requestObj != null) {
				PhyHeadToToeExamination headToToeExamination = InputMapper.gson().fromJson(requestObj,
						PhyHeadToToeExamination.class);
				int r = ancServiceImpl.savePhyHeadToToeExamination(headToToeExamination);
				if (r > 0) {
					response.setResponse("Ben Head To Toe Examination data saved successfully.");
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
	@ApiOperation(value = "save Beneficiary Gastrointestinal System Examination Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/examination/gastrointestinalExamination" }, method = { RequestMethod.POST })
	public String saveSysGastrointestinalExamination(
			@ApiParam(value = "{\"beneficiaryRegID\":\"Long\",\"benVisitID\": \"Long\","
					+ "\"inspection\":\"String\", \"palpation_AbdomenTexture\":\"String\", \"palpation_Liver\":\"String\", \"palpation_Spleen\":\"String\", "
					+ "\"palpation_Tenderness\":\"String\", \"palpation_LocationOfTenderness\":\"String\", \"percussion\":\"String\", \"auscultation\":\"String\","
					+ " \"trunk\":\"String\", \"analRegion\":\"String\", \"createdBy\":\"String\"}") @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("saveSysGastrointestinalExamination request:" + requestObj);
		try {
			inputMapper = new InputMapper();
			if (requestObj != null) {
				SysGastrointestinalExamination gastrointestinalExamination = InputMapper.gson().fromJson(requestObj,
						SysGastrointestinalExamination.class);
				int r = ancServiceImpl.saveSysGastrointestinalExamination(gastrointestinalExamination);
				if (r > 0) {
					response.setResponse("Ben Gastrointestinal Examination data saved successfully.");
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
	@ApiOperation(value = "save Beneficiary Cardiovascular System Examination Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/examination/cardiovascularExamination" }, method = { RequestMethod.POST })
	public String saveSysCardiovascularExamination(
			@ApiParam(value = "{\"beneficiaryRegID\":\"Long\",\"benVisitID\": \"Long\","
					+ "\"jugularVenousPulse_JVP\":\"String\", \"apexbeatLocation\":\"String\", \"apexbeatType\":\"String\","
					+ "\"firstHeartSound_S1\":\"String\", \"secondHeartSound_S2\":\"String\", \"additionalHeartSounds\":\"String\", "
					+ "\"murmurs\":\"String\", \"pericardialRub\":\"String\", \"createdBy\":\"String\"}") @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		logger.info("saveSysCardiovascularExamination request:" + requestObj);
		try {
			inputMapper = new InputMapper();
			if (requestObj != null) {
				SysCardiovascularExamination cardiovascularExamination = InputMapper.gson().fromJson(requestObj,
						SysCardiovascularExamination.class);
				int r = ancServiceImpl.saveSysCardiovascularExamination(cardiovascularExamination);
				if (r > 0) {
					response.setResponse("Ben Cardiovascular Examination data saved successfully.");
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
	@ApiOperation(value = "Save Beneficairy Respiratory System Examination Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/examination/respiratorySystemExamination" }, method = { RequestMethod.POST })
	public String saverespiratorySystemExamination(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("saveSysCardiovascularExamination request:" + requestObj);
		try {
			if (requestObj != null) {
				SysRespiratoryExamination sysRespiratoryExamination = InputMapper.gson().fromJson(requestObj,
						SysRespiratoryExamination.class);

				int r = ancServiceImpl.saveSysRespiratoryExamination(sysRespiratoryExamination);
				if (r > 0) {
					response.setResponse("Beneficairy Respiratory System Examination Details saved successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
			}
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "Save Beneficairy Central Nervous System Examination Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/examination/centralNervousSystemExamination" }, method = { RequestMethod.POST })
	public String centralNervousSystemExamination(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("centralNervousSystemExamination request:" + requestObj);
		try {
			if (requestObj != null) {
				SysCentralNervousExamination sysCentralNervousExamination = InputMapper.gson().fromJson(requestObj,
						SysCentralNervousExamination.class);

				int r = ancServiceImpl.saveSysCentralNervousExamination(sysCentralNervousExamination);
				if (r > 0) {
					response.setResponse("Beneficairy Central Nervous System Examination Details saved successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
			}
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "Save Beneficairy Musculoskeletal System Examination Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/examination/musculoskeletalSystemExamination" }, method = { RequestMethod.POST })
	public String musculoskeletalSystemExamination(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("musculoskeletalSystemExamination request:" + requestObj);
		try {
			if (requestObj != null) {
				SysMusculoskeletalSystemExamination sysMusculoskeletalSystemExamination = InputMapper.gson()
						.fromJson(requestObj, SysMusculoskeletalSystemExamination.class);

				int r = ancServiceImpl.saveSysMusculoskeletalSystemExamination(sysMusculoskeletalSystemExamination);
				if (r > 0) {
					response.setResponse("Beneficairy Musculoskeletal System Examination Details saved successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
			}
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "Save Beneficairy Genito Urinary System Examination Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/examination/genitoUrinarySystemExamination" }, method = { RequestMethod.POST })
	public String genitoUrinarySystemExamination(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("genitoUrinarySystemExamination request:" + requestObj);
		try {
			if (requestObj != null) {
				SysGenitourinarySystemExamination sysGenitourinarySystemExamination = InputMapper.gson()
						.fromJson(requestObj, SysGenitourinarySystemExamination.class);

				int r = ancServiceImpl.saveSysGenitourinarySystemExamination(sysGenitourinarySystemExamination);
				if (r > 0) {
					response.setResponse("Beneficairy Genito Urinary System Examination Details saved successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
			}
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "Save Beneficairy Obstetric  Examination Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/examination/obstetricExamination" }, method = { RequestMethod.POST })
	public String obstetricExamination(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("obstetricExamination request:" + requestObj);
		try {
			if (requestObj != null) {
				SysObstetricExamination sysObstetricExamination = InputMapper.gson().fromJson(requestObj,
						SysObstetricExamination.class);

				int r = ancServiceImpl.saveSysObstetricExamination(sysObstetricExamination);
				if (r > 0) {
					response.setResponse("Save Beneficairy Obstetric  Examination Details saved successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
			}
		} catch (Exception e) {
			response.setError(e);
		}
		return response.toString();
	}
	
//	{ "beneficiaryRegID":"7506",
//		"benVisitID":"222",
//		"providerServiceMapID":"1251",
//		"createdBy":"Test",
//		 "pastIllness": [ { "illnessType": { "illnessID": "12", "illnessType": "Malaria" }, "otherIllnessType": "sfdgfd", "timePeriodAgo": "2", "timePeriodUnit": "Years" } ], "pastSurgery": [ { "surgeryType": { "surgeryID": "3", "surgeryType": "Appendicectomy" }, "otherSurgeryType": null, "timePeriodAgo": "4", "timePeriodUnit": "Weeks" } ] }
	@CrossOrigin
	@ApiOperation(value = "Save Beneficiary ANC past history Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/history/pastHistory" }, method = { RequestMethod.POST })
	public String saveANCBenPastHistory(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("saveANCBenPastHistory request:" + requestObj);
		try {
			if (requestObj != null) {
				BenMedHistory benMedHistory = InputMapper.gson().fromJson(requestObj,
						BenMedHistory.class);

				int r = ancServiceImpl.saveBenANCPastHistory(benMedHistory);
				if (r > 0) {
					response.setResponse("Beneficairy Past History Details saved successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
				logger.info("saveANCBenPastHistory response:" + response);
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error while storing Beneficiary ANC Past History.");
		}
		return response.toString();
	}
	
//	
//	 {"comrbidityCondDetails":[ { "beneficiaryRegID":"7506",
//		 "benVisitID":"222",
//		 "providerServiceMapID":"1251",
//		 "createdBy":"Test","comorbidConditionID":5,"comorbidCondition": "Hypertension", "otherComorbidConditions": null, "timePeriodAgo": "2", "timePeriodUnit": "Months", "showNextTime": null } ] }
	@CrossOrigin
	@ApiOperation(value = "Save Beneficiary ANC ComorbidCondition Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/history/comorbidConditions" }, method = { RequestMethod.POST })
	public String saveANCBenComorbidConditions(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("saveANCBenComorbidConditions request:" + requestObj);
		try {
			if (requestObj != null) {
				WrapperComorbidCondDetails wrapperComorbidCondDetails = InputMapper.gson().fromJson(requestObj,
						WrapperComorbidCondDetails.class);

				int r = ancServiceImpl.saveBenANCComorbidConditions(wrapperComorbidCondDetails);
				if (r > 0) {
					response.setResponse("Beneficairy ComorbidCondition Details saved successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
				logger.info("saveANCBenComorbidConditions response:" + response);
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error while storing Beneficiary ANC Comorbid Conditions.");
		}
		return response.toString();
	}

	
//	{ "medicationHistoryList": [ { "beneficiaryRegID":"7506", "benVisitID":"222", "providerServiceMapID":"1251", "createdBy":"Test","currentMedication": "saff", "timePeriodAgo": 2, "timePeriodUnit": "Years"} ] }
	@CrossOrigin
	@ApiOperation(value = "Save Beneficiary ANC Medication History Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/history/medicationHistory" }, method = { RequestMethod.POST })
	public String saveANCBenMedicationHistory(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("saveANCBenMedicationHistory request:" + requestObj);
		try {
			if (requestObj != null) {
				WrapperMedicationHistory wrapperMedicationHistory = InputMapper.gson().fromJson(requestObj,
						WrapperMedicationHistory.class);

				int r = ancServiceImpl.saveBenANCMedicationHistory(wrapperMedicationHistory);
				if (r > 0) {
					response.setResponse("Beneficairy ANC Medication History Details saved successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
				logger.info("saveANCBenMedicationHistory response:" + response);
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error while storing Beneficiary ANC Medication History.");
		}
		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Save Beneficiary ANC Menstrual History Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/history/menstrualHistory" }, method = { RequestMethod.POST })
	public String saveANCMenstrualHistory(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("saveANCMenstrualHistory request:" + requestObj);
		try {
			if (requestObj != null) {
				BenMenstrualDetails menstrualDetails = InputMapper.gson().fromJson(requestObj,
						BenMenstrualDetails.class);

				int r = ancServiceImpl.saveBenANCMenstrualHistory(menstrualDetails);
				if (r > 0) {
					response.setResponse("Beneficairy ANC Menstrual Details saved successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
				logger.info("saveANCMenstrualHistory response:" + response);
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error while storing Beneficiary ANC Menstrual Details.");
		}
		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Save Beneficiary Female Obstetric History Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/history/femaleObstetricHistory" }, method = { RequestMethod.POST })
	public String saveFemaleObstetricHistory(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("saveFemaleObstetricHistory request:" + requestObj);
		try {
			if (requestObj != null) {
				WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory = InputMapper.gson().fromJson(requestObj,
						WrapperFemaleObstetricHistory.class);

				int r = ancServiceImpl.saveFemaleObstetricHistory(wrapperFemaleObstetricHistory);
				if (r > 0) {
					response.setResponse("Beneficairy ANC Female Obstetric History saved successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
				logger.info("saveFemaleObstetricHistory response:" + response);
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error while storing Beneficiary ANC Female Obstetric History Details.");
		}
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "Save Beneficiary Perinatal History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/history/perinatalHistory" }, method = { RequestMethod.POST })
	public String saveANCPerinatalHistory(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("saveANCPerinatalHistory request:" + requestObj);
		try {
			if (requestObj != null) {
				PerinatalHistory perinatalHistory = InputMapper.gson().fromJson(requestObj,
						PerinatalHistory.class);

				int r = ancServiceImpl.savePerinatalHistory(perinatalHistory);
				if (r > 0) {
					response.setResponse("Beneficairy ANC  Perinatal History saved successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
				logger.info("saveANCPerinatalHistory response:" + response);
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error while storing Beneficiary ANC Perinatal History Details.");
		}
		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Save child Vaccine Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/history/childVaccineDetails" }, method = { RequestMethod.POST })
	public String saveANCChildVaccineDetails(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("saveANCChildVaccineDetails request:" + requestObj);
		try {
			if (requestObj != null) {
				WrapperChildOptionalVaccineDetail wrapperChildVaccineDetail = InputMapper.gson().fromJson(requestObj,
						WrapperChildOptionalVaccineDetail.class);

				int r = ancServiceImpl.saveChildOptionalVaccineDetail(wrapperChildVaccineDetail);
				if (r > 0) {
					response.setResponse("Beneficairy ANC Child Vaccine Details saved successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
				logger.info("saveANCChildVaccineDetails response:" + response);
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error while storing Beneficiary ANC Child Vaccine Details.");
		}
		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Save child Development Details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/history/childDevelopmentHistory" }, method = { RequestMethod.POST })
	public String saveANCChildDevelopmentHistory(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("saveANCChildDevelopmentHistory request:" + requestObj);
		try {
			if (requestObj != null) {
				BenChildDevelopmentHistory benChildDevelopmentHistory = InputMapper.gson().fromJson(requestObj,
						BenChildDevelopmentHistory.class);

				int r = ancServiceImpl.saveChildDevelopmentHistory(benChildDevelopmentHistory);
				if (r > 0) {
					response.setResponse("Beneficairy ANC Child Development History Details saved successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
				logger.info("saveANCChildDevelopmentHistory response:" + response);
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error while storing Beneficiary ANC Child Development History Details.");
		}
		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Save ANC Personal History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/history/PersonalHistory" }, method = { RequestMethod.POST })
	public String saveANCPersonalHistory(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("saveANCPersonalHistory request:" + requestObj);
		try {
			if (requestObj != null) {
				BenPersonalHabit personalHabit = InputMapper.gson().fromJson(requestObj,
						BenPersonalHabit.class);
				
				BenAllergyHistory benAllergyHistory = InputMapper.gson().fromJson(requestObj,
						BenAllergyHistory.class);

				int r = ancServiceImpl.saveANCPersonalHistory(personalHabit);
				int s= ancServiceImpl.saveANCAllergyHistory(benAllergyHistory);
				if ( s > 0) {
					response.setResponse("Beneficairy ANC Personal History Details saved successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
				logger.info("saveANCPersonalHistory response:" + response);
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error while storing Beneficiary ANC Personal History Details.");
		}
		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Save ANC Family History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/history/familyHistory" }, method = { RequestMethod.POST })
	public String saveANCFamilyHistory(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("saveANCFamilyHistory request:" + requestObj);
		try {
			if (requestObj != null) {
				BenFamilyHistory benFamilyHistory = InputMapper.gson().fromJson(requestObj,
						BenFamilyHistory.class);

				int r = ancServiceImpl.saveANCBenFamilyHistory(benFamilyHistory);
				if (r > 0) {
					response.setResponse("Beneficairy ANC Family History Details saved successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
				logger.info("saveANCFamilyHistory response:" + response);
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error while storing Beneficiary ANC Family History Details.");
		}
		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Save ANC Child Feeding History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/history/childFeedingHistory" }, method = { RequestMethod.POST })
	public String saveChildFeedingHistory(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("saveChildFeedingHistory request:" + requestObj);
		try {
			if (requestObj != null) {
				ChildFeedingDetails childFeedingDetails = InputMapper.gson().fromJson(requestObj,
						ChildFeedingDetails.class);

				int r = ancServiceImpl.saveChildFeedingHistory(childFeedingDetails);
				if (r > 0) {
					response.setResponse("Beneficairy ANC Child Feeding History Details saved successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
				logger.info("saveChildFeedingHistory response:" + response);
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error while storing Beneficiary ANC Child Feeding History Details.");
		}
		return response.toString();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Save ANC Immunization History", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/history/immunizationHistory" }, method = { RequestMethod.POST })
	public String saveImmunizationHistory(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		logger.info("saveImmunizationHistory request:" + requestObj);
		try {
			if (requestObj != null) {
				WrapperImmunizationHistory wrapperImmunizationHistory = InputMapper.gson().fromJson(requestObj,
						WrapperImmunizationHistory.class);

				int r = ancServiceImpl.saveANCImmunizationHistory(wrapperImmunizationHistory);
				if (r > 0) {
					response.setResponse("Beneficairy ANC Immunization History Details saved successfully");
				} else {
					response.setError(5000, "Something went wrong");
				}
				logger.info("saveImmunizationHistory response:" + response);
			}
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error while storing Beneficiary ANC Immunization History Details.");
		}
		return response.toString();
	}
}
