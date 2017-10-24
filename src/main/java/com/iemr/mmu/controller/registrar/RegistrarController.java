package com.iemr.mmu.controller.registrar;

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

import com.google.gson.JsonObject;
import com.iemr.mmu.data.registrar.BeneficiaryData;
import com.iemr.mmu.data.registrar.V_BenAdvanceSearch;
import com.iemr.mmu.data.registrar.WrapperBeneficiaryRegistration;
import com.iemr.mmu.service.masterservice.RegistrarServiceMasterDataImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.mmu.service.registrar.RegistrarServiceImpl;
import com.iemr.utils.mapper.InputMapper;
import com.iemr.utils.response.OutputResponse;

@CrossOrigin
@RestController
@RequestMapping({ "/registrar" })
public class RegistrarController {

	private Logger logger = LoggerFactory.getLogger(RegistrarController.class);
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

	// Registrar Work List API .....
	@CrossOrigin()
	@RequestMapping(value = { "/registrarWorkListData" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String getRegistrarWorkList(@RequestBody String comingRequest) throws JSONException {
		OutputResponse response = new OutputResponse();
		logger.info("getRegistrarWorkList request:" + comingRequest);
		try {

			JSONObject obj = new JSONObject(comingRequest);

			// wrapperRegWorklistArray =
			// this.registrarServiceImpl.getRegWorkList(obj.getInt("spID"));
			response.setResponse(this.registrarServiceImpl.getRegWorkList(obj.getInt("spID")));
			logger.info("getRegistrarWorkList response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in getRegistrarWorkList:" + e);
		}
		return response.toString();
	}

	// Registrar Beneficiary Registration API .....
	@CrossOrigin()
	@RequestMapping(value = { "/registrarBeneficaryRegistration" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String createBeneficiary(@RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		try {

			// JsonObject responseOBJ = new JsonObject();
			WrapperBeneficiaryRegistration wrapperBeneficiaryRegistrationOBJ = InputMapper.gson()
					.fromJson(comingRequest, WrapperBeneficiaryRegistration.class);
			logger.info("createBeneficiary request:" + comingRequest);
			JsonObject benD = wrapperBeneficiaryRegistrationOBJ.getBenD();

			if (benD == null || benD.isJsonNull()) {
				response.setError(0, "Data Not Sufficient...");
			} else {
				BeneficiaryData benData = registrarServiceImpl.createBeneficiary(benD);
				if (benData != null) {
					Long benRegID = benData.getBeneficiaryRegID();
					Long benDemoID = registrarServiceImpl.createBeneficiaryDemographic(benD, benRegID);
					Long benPhonMapID = registrarServiceImpl.createBeneficiaryPhoneMapping(benD, benRegID);

					int benGovIdMapID = registrarServiceImpl.createBenGovIdMapping(benD, benRegID);

					Long benbenDemoOtherID = registrarServiceImpl.createBeneficiaryDemographicAdditional(benD,
							benRegID);

					if (benRegID > 0 && benDemoID > 0 && benPhonMapID > 0 && benbenDemoOtherID > 0) {
						if (benData.getBeneficiaryID() != null) {
							response.setResponse(benData.getBeneficiaryID());
						} else {
							// i_beneficiary, i_bendemographics and
							// m_benphonemap
							// roll-back
							response.setResponse("Registration Done But BeneficiaryID Not Generated!!!");
						}
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
			logger.info("createBeneficiary response:" + response);
		} catch (Exception e) {
			logger.error("Error in createBeneficiary :" + e);
			response.setError(e);
		}
		return response.toString();
	}

	// Registrar Quick search .....
	@CrossOrigin()
	@RequestMapping(value = { "/quickSearch" }, method = { RequestMethod.POST }, produces = { "application/json" })
	public String quickSearchBeneficiary(@RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("quickSearchBeneficiary request:" + comingRequest);
		try {

			JSONObject obj = new JSONObject(comingRequest);

			// wrapperRegWorklistArray =
			// registrarServiceImpl.getQuickSearchBenData(obj.getString("benID"));
			response.setResponse(registrarServiceImpl.getQuickSearchBenData(obj.getString("benID")));
			logger.info("quickSearchBeneficiary response:" + response);
		} catch (Exception e) {
			logger.error("Error in quickSearchBeneficiary :" + e);
			response.setError(e);
		}
		return response.toString();
	}

	// Registrar Advance search .....
	@CrossOrigin()
	@RequestMapping(value = { "/advanceSearch" }, method = { RequestMethod.POST }, produces = { "application/json" })
	public String advanceSearch(@RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("advanceSearch request :" + comingRequest);
		try {
			// JSONObject obj = new JSONObject(comingRequest);
			V_BenAdvanceSearch v_BenAdvanceSearch = inputMapper.gson().fromJson(comingRequest,
					V_BenAdvanceSearch.class);
			response.setResponse(registrarServiceImpl.getAdvanceSearchBenData(v_BenAdvanceSearch));
			logger.info("advanceSearch response:" + response);
		} catch (Exception e) {
			logger.error("Error in advanceSearch :" + e);
			response.setError(e);
		}

		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = { "/registrarMasterData" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String masterDataForRegistration(@RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("masterDataForRegistration request :" + comingRequest);
		try {

			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("spID")) {
				if (obj.getInt("spID") > 0) {
					response.setResponse(registrarServiceMasterDataImpl.getRegMasterData());
				} else {
					response.setError(500, "Invalid Service-Point...");
				}
			} else {
				response.setError(500, "Bad Request... Service-Point is not there in request");
			}
			logger.info("masterDataForRegistration response :" + response);

		} catch (Exception e) {
			logger.error("Error in masterDataForRegistration :" + e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = { "/get/benDetailsByRegID" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String getBenDetailsByRegID(@RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		logger.info("getBenDetailsByRegID request :" + comingRequest);
		try {

			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("beneficiaryRegID")) {
				if (obj.getLong("beneficiaryRegID") > 0) {

					String beneficiaryData = registrarServiceMasterDataImpl
							.getBenDetailsByRegID(obj.getLong("beneficiaryRegID"));

					response.setResponse(beneficiaryData);
				} else {
					response.setError(500, "Please pass beneficiaryRegID");
				}
			} else {
				response.setError(500, "Bad Request... beneficiaryRegID is not there in request");
			}
			logger.info("getBenDetailsByRegID response :" + response);
		} catch (Exception e) {
			logger.error("Error in getBenDetailsByRegID :" + e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin
	@RequestMapping(value = { "/update/benDetailsAndSubmitToNurse" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public String saveBeneficiaryVisitDetail(@RequestBody String comingRequest) {

		OutputResponse response = new OutputResponse();
		inputMapper = new InputMapper();
		logger.info("benDetailsAndSubmitToNurse request:" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("beneficiaryRegID")) {
				if (obj.getLong("beneficiaryRegID") > 0) {

					Integer i = nurseServiceImpl.updateBeneficiaryStatus('R', obj.getLong("beneficiaryRegID"));
					if (i != null && i > 0) {
						response.setResponse("Beneficiary Successfully Submitted to Nurse Work-List.");
					} else {
						response.setError(500, "Something went Wrong please try after Some Time !!!");
					}

				} else {
					response.setError(500, "Beneficiary Registration ID is Not valid !!!");
				}
			} else {
				response.setError(500, "Beneficiary Registration ID is Not valid !!!");
			}
			logger.info("benDetailsAndSubmitToNurse response:" + response);
		} catch (Exception e) {
			response.setError(e);
			logger.error("Error in benDetailsAndSubmitToNurse:" + e);
		}

		return response.toString();
	}

}
