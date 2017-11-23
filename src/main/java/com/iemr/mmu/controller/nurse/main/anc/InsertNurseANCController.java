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
import com.iemr.mmu.data.anc.WrapperANCCareDetail;
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
	@ApiOperation(value = "save Beneficiary ANC Care Detail", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/save/ancScreen/ancCare" }, method = { RequestMethod.POST })
	public String saveBeneficiaryANCCareDetail(
			@ApiParam(value = "{\"ANCCareDetail\":{\"beneficiaryRegID\":\"Long\", \"benVisitID\": \"Long\", \"providerServiceMapID\": \"Integer\","
					+ "\"visitNo\":\"Short\", \"comolaintType\":\"String\", \"duration\":\"String\", \"description\":\"String\","
					+ "\"aNCRegistrationDate\":\"Timestamp\", \"aNCVisitNumber\":\"Short\", \"lastMenstrualPeriod_LMP\":\"Timestamp\","
					+ "\"gestationalAgeOrPeriodofAmenorrhea_POA\":\"Short\", \"trimesterNumber\":\"Short\", \"expectedDateofDelivery\":\"Timestamp\","
					+ "\"primiGravida\":\"Boolean\", \"obstetricFormula\":\"String\", \"gravida_G\":\"Short\", \"termDeliveries_T\":\"Short\", "
					+ "\"pretermDeliveries_P\":\"Short\", \"abortions_A\":\"Short\", \"livebirths_L\":\"Short\", \"bloodGroup\":\"String\","
					+ " \"createdBy\":\"String\"}, \"ANCWomenVaccineDetail\":[{\"beneficiaryRegID\":\"Long\", \"vaccineName\":\"String\", "
					+ "\"status\":\"String\", \"receivedDate\":\"Timestamp\", \"receivedFacilityName\":\"String\"}]}") @RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		inputMapper = new InputMapper();
		logger.info("saveBeneficiaryANCCareDetail request:" + requestObj);

		WrapperANCCareDetail ancCareDetails = InputMapper.gson().fromJson(requestObj, WrapperANCCareDetail.class);

		try {
			Long ancCareID = ancServiceImpl.saveBeneficiaryANCDetails(ancCareDetails.getAncCareDetails());
			Long ancWomenVaccineID = ancServiceImpl
					.saveANCWomenVaccineDetails(ancCareDetails.getAncWomenVaccineDetail());
			if (ancCareID != null && ancCareID > 0 && ancWomenVaccineID != null && ancWomenVaccineID > 0) {
				response.setResponse("Beneficiary ANC Care Details stored successfully");
			} else {
				response.setError(500, "Failed to Store Beneficiary ANC Care Details");
			}
			logger.info("saveBeneficiaryANCCareDetail response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in saveBeneficiaryANCCareDetail:" + e);
		}

		return response.toString();
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
}
