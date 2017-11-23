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
import com.iemr.mmu.data.anc.PhyGeneralExamination;
import com.iemr.mmu.data.anc.PhyHeadToToeExamination;
import com.iemr.mmu.data.anc.SysCardiovascularExamination;
import com.iemr.mmu.data.anc.SysGastrointestinalExamination;
import com.iemr.mmu.data.anc.WrapperAncImmunization;
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
			// inputMapper = new InputMapper();
			ancServiceImpl.saveBenInvestigation();
		} catch (Exception e) {
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
	@RequestMapping(value = { "/save/ANC/ancImmunization" }, method = {})

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

}
