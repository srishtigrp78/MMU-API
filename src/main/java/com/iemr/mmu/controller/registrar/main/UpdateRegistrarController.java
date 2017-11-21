package com.iemr.mmu.controller.registrar.main;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
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
import com.iemr.mmu.controller.registrar.master.RegistrarController;
import com.iemr.mmu.data.registrar.BeneficiaryData;
import com.iemr.mmu.data.registrar.V_BenAdvanceSearch;
import com.iemr.mmu.data.registrar.WrapperBeneficiaryRegistration;
import com.iemr.mmu.service.common.master.RegistrarServiceMasterDataImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.mmu.service.registrar.RegistrarServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping({ "/registrar" })
/** Objective: Performs Update Beneficiary Details*/
public class UpdateRegistrarController {
	private Logger logger = LoggerFactory.getLogger(UpdateRegistrarController.class);
	private InputMapper inputMapper = new InputMapper();
	private RegistrarServiceImpl registrarServiceImpl;
	private RegistrarServiceMasterDataImpl registrarServiceMasterDataImpl;
	private NurseServiceImpl nurseServiceImpl;

	@Autowired
	public void setRegistrarServiceImpl(RegistrarServiceImpl registrarServiceImpl) {
		this.registrarServiceImpl = registrarServiceImpl;
	}

	@Autowired
	public void setRegistrarServiceMasterDataImpl(RegistrarServiceMasterDataImpl registrarServiceMasterDataImpl) {
		this.registrarServiceMasterDataImpl = registrarServiceMasterDataImpl;
	}

	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}

	// Registrar Beneficiary Registration API .....
	@CrossOrigin()
	@ApiOperation(value = "Update Registered Beneficiary Data", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/BeneficiaryDetails" }, method = { RequestMethod.POST })
	public String updateBeneficiary(
			@ApiParam(value = "{\"benD\": {\"beneficiaryRegID\": \"Long\", \"firstName\": \"String\", \"lastName\": \"String\", \"gender\": \"Short\","
					+ "\"dob\": \"Timestamp\", \"maritalStatus\": \"Short\", \"fatherName\": \"String\", \"motherName\": \"String\","
					+ "\"husbandName\": \"String\", \"image\": \"String\", \"aadharNo\": \"String\", \"income\": \"Short\", "
					+ "\"literacyStatus\": \"String\", \"educationQualification\": \"Short\", \"occupation\": \"Short\", \"phoneNo\": \"String\","
					+ "\"emailID\": \"Integer\", \"bankName\": \"String\", \"branchName\": \"String\", \"IFSCCode\": \"String\", \"accountNumber\": \"String\","
					+ "\"community\": \"Short\", \"religion\": \"Short\", \"blockID\": \"Integer\", \"blockName\": \"String\", \"habitation\": \"String\", "
					+ "\"villageID\": \"Integer\", \"villageName\": \"String\", \"districtID\": \"Integer\", \"districtName\": \"String\", \"stateID\": \"Integer\", "
					+ "\"stateName\": \"String\", \"govID\": [{\"benGovMapID\": \"Long\", \"type\": \"String\",\"value\": \"String\"},"
					+ "{\"type\": \"String\",\"value\": \"String\"}], \"ageAtMarriage\": \"Integer\", \"createdBy\": \"String\", "
					+ "\"servicePointID\": \"Integer\", \"govtIdentityNo\": \"Integer\", \"govtIdentityTypeID\": \"Integer\", \"modifiedBy\": \"String\"}}") @RequestBody String comingRequest) {

		OutputResponse response = new OutputResponse();
		try {

			// JsonObject responseOBJ = new JsonObject();
			WrapperBeneficiaryRegistration wrapperBeneficiaryRegistrationOBJ = InputMapper.gson()
					.fromJson(comingRequest, WrapperBeneficiaryRegistration.class);
			logger.info("updateBeneficiary request:" + comingRequest);
			JsonObject benD = wrapperBeneficiaryRegistrationOBJ.getBenD();

			if (benD == null || benD.isJsonNull() || !benD.has("beneficiaryRegID")) {
				response.setError(0, "Data Not Sufficient...");
			} else {
				int benData = registrarServiceImpl.updateBeneficiary(benD);
				if (benData != 0 && !benD.get("beneficiaryRegID").isJsonNull()) {
					Long benRegID = benD.get("beneficiaryRegID").getAsLong();
					int benDemoUpdateRes = registrarServiceImpl.updateBeneficiaryDemographic(benD, benRegID);
					int benPhonMapUpdateRes = registrarServiceImpl.updateBeneficiaryPhoneMapping(benD, benRegID);

					int benGovIdMapUpdateRes = registrarServiceImpl.updateBenGovIdMapping(benD, benRegID);

					int benbenDemoOtherUpdateRes = registrarServiceImpl.updateBeneficiaryDemographicAdditional(benD,
							benRegID);

					int benImageUpdateRes = registrarServiceImpl.updateBeneficiaryImage(benD, benRegID);

					if (benRegID >= 0 && benDemoUpdateRes >= 0 && benPhonMapUpdateRes >= 0
							&& benbenDemoOtherUpdateRes >= 0 && benImageUpdateRes >= 0) {
						Integer i = nurseServiceImpl.updateBeneficiaryStatus('R', benRegID);
						response.setResponse("Beneficiary Details updated successfully!!!");

					} else {
						// i_beneficiary, i_bendemographics and m_benphonemap
						// roll-back
						response.setError(500, "Something Went-Wrong");
					}
				} else {
					// i_beneficiary roll-back
					response.setError(500, "Something Went-Wrong");
				}
			}
			logger.info("updateBeneficiary response:" + response);
		} catch (Exception e) {
			logger.error("Error in updateBeneficiary :" + e);
			response.setError(e);
		}
		return response.toString();
	}
}
