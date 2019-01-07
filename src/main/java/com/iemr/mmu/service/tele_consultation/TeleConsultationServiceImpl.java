package com.iemr.mmu.service.tele_consultation;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;
import com.iemr.mmu.data.nurse.CommonUtilityClass;
import com.iemr.mmu.data.tele_consultation.TCRequestModel;
import com.iemr.mmu.data.tele_consultation.TeleconsultationRequestOBJ;
import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.repo.tc_consultation.TCRequestModelRepo;
import com.iemr.mmu.service.anc.Utility;
import com.iemr.mmu.utils.mapper.InputMapper;

@Service
public class TeleConsultationServiceImpl implements TeleConsultationService {
	@Autowired
	private TCRequestModelRepo tCRequestModelRepo;
	@Autowired
	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;

	public int createTCRequest(TCRequestModel tCRequestModel) {
		TCRequestModel tCRequestModelRS = tCRequestModelRepo.save(tCRequestModel);
		if (tCRequestModelRS != null && tCRequestModelRS.gettMRequestID() > 0)
			return 1;
		else
			return 0;
	}

	@Transactional(rollbackFor = Exception.class)
	public int updateBeneficiaryArrivalStatus(String requestOBJ) throws Exception {
		int resultFlag = 0;
		JsonObject requestJson = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElement = jsnParser.parse(requestOBJ);
		requestJson = jsnElement.getAsJsonObject();

		if (requestJson.has("benflowID") && requestJson.has("benRegID") && requestJson.has("visitCode")
				&& requestJson.has("modifiedBy") && requestJson.has("status") && requestJson.has("userID")
				&& !requestJson.get("benflowID").isJsonNull() && !requestJson.get("benRegID").isJsonNull()
				&& !requestJson.get("visitCode").isJsonNull() && !requestJson.get("status").isJsonNull()
				&& !requestJson.get("modifiedBy").isJsonNull() && !requestJson.get("userID").isJsonNull()) {

			int i = beneficiaryFlowStatusRepo.updateBeneficiaryArrivalStatus(requestJson.get("benflowID").getAsLong(),
					requestJson.get("benRegID").getAsLong(), requestJson.get("visitCode").getAsLong(),
					requestJson.get("status").getAsBoolean(), requestJson.get("modifiedBy").getAsString(),
					requestJson.get("userID").getAsInt());

			if (i > 0) {
				int j = tCRequestModelRepo.updateBeneficiaryStatus(requestJson.get("benRegID").getAsLong(),
						requestJson.get("visitCode").getAsLong(), "A", requestJson.get("modifiedBy").getAsString(),
						requestJson.get("userID").getAsInt());
				if (j > 0)
					resultFlag = 1;
				else
					throw new Exception("Beneficiary arrival status update failed");
			} else
				throw new Exception("Beneficiary arrival status update failed");
		} else {
			throw new Exception("Invalid request");
		}

		return resultFlag;
	}

	@Transactional(rollbackFor = Exception.class)
	public int updateBeneficiaryStatusToCancelTCRequest(String requestOBJ) throws Exception {
		int resultFlag = 0;
		JsonObject requestJson = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElement = jsnParser.parse(requestOBJ);
		requestJson = jsnElement.getAsJsonObject();

		if (requestJson.has("benflowID") && requestJson.has("benRegID") && requestJson.has("visitCode")
				&& requestJson.has("modifiedBy") && requestJson.has("userID")
				&& !requestJson.get("benflowID").isJsonNull() && !requestJson.get("benRegID").isJsonNull()
				&& !requestJson.get("visitCode").isJsonNull() && !requestJson.get("modifiedBy").isJsonNull()
				&& !requestJson.get("userID").isJsonNull()) {

			int i = beneficiaryFlowStatusRepo.updateBeneficiaryStatusToCancelRequest(
					requestJson.get("benflowID").getAsLong(), requestJson.get("benRegID").getAsLong(),
					requestJson.get("visitCode").getAsLong(), requestJson.get("modifiedBy").getAsString(),
					requestJson.get("userID").getAsInt());

			if (i > 0) {
				int j = tCRequestModelRepo.updateBeneficiaryStatus(requestJson.get("benRegID").getAsLong(),
						requestJson.get("visitCode").getAsLong(), "C", requestJson.get("modifiedBy").getAsString(),
						requestJson.get("userID").getAsInt());
				if (j > 0)
					resultFlag = 1;
				else
					throw new Exception("Teleconsultation cancel request failed");
			} else
				throw new Exception("Teleconsultation cancel request failed");
		} else {
			throw new Exception("Invalid request");
		}

		return resultFlag;
	}

	@Transactional(rollbackFor = Exception.class)
	public int checkBeneficiaryStatusForSpecialistTransaction(String requestOBJ) throws Exception {
		int returnOBJ = 0;
		JsonObject requestJson = new JsonObject();
		JsonParser jsnParser = new JsonParser();
		JsonElement jsnElement = jsnParser.parse(requestOBJ);
		requestJson = jsnElement.getAsJsonObject();

		if (requestJson.has("benflowID") && requestJson.has("benRegID") && requestJson.has("visitCode")
				&& requestJson.has("userID") && !requestJson.get("benflowID").isJsonNull()
				&& !requestJson.get("benRegID").isJsonNull() && !requestJson.get("visitCode").isJsonNull()
				&& !requestJson.get("userID").isJsonNull()) {

			ArrayList<BeneficiaryFlowStatus> resultSet = beneficiaryFlowStatusRepo.checkBeneficiaryArrivalStatus(
					requestJson.get("benflowID").getAsLong(), requestJson.get("benRegID").getAsLong(),
					requestJson.get("visitCode").getAsLong(), requestJson.get("userID").getAsInt());

			if (resultSet != null && resultSet.size() == 1) {
				BeneficiaryFlowStatus obj1 = resultSet.get(0);
				if (obj1.getBenArrivedFlag()) {
					ArrayList<TCRequestModel> tCRequestModelOBJ = tCRequestModelRepo.checkBenTcStatus(
							requestJson.get("benRegID").getAsLong(), requestJson.get("visitCode").getAsLong(),
							requestJson.get("userID").getAsInt());
					if (tCRequestModelOBJ != null && tCRequestModelOBJ.size() > 0) {
						returnOBJ = 1;
					} else {
						throw new Exception("Sorry, Beneficiary have not any active Teleconsultation session.");
					}
				} else {
					throw new Exception("Sorry, Beneficiary have not arrived at TM spoke/center");
				}
			} else {
				throw new Exception("No record or multiple record found in DB. Kindly contact the administrator");
			}
		} else {
			throw new Exception("Invalid request.");
		}
		return returnOBJ;
	}

	@Transactional(rollbackFor = Exception.class)
	public int createTCRequestFromWorkList(JsonObject tcRequestOBJ) throws Exception {
		int returnOBJ = 0;
		int tcRequestStatusFlag = 0;

		CommonUtilityClass commonUtilityClass = InputMapper.gson().fromJson(tcRequestOBJ, CommonUtilityClass.class);
		TeleconsultationRequestOBJ tcRequest = InputMapper.gson().fromJson(tcRequestOBJ.get("tcRequest"),
				TeleconsultationRequestOBJ.class);

		if (tcRequest != null && tcRequest.getUserID() != null && tcRequest.getUserID() > 0
				&& tcRequest.getAllocationDate() != null && tcRequest.getFromTime() != null) {
			tcRequest.setAllocationDate(Utility.combineDateAndTimeToDateTime(tcRequest.getAllocationDate().toString(),
					tcRequest.getFromTime()));

			TCRequestModel tRequestModel = InputMapper.gson().fromJson(tcRequestOBJ, TCRequestModel.class);
			tRequestModel.setUserID(tcRequest.getUserID());
			tRequestModel.setRequestDate(tcRequest.getAllocationDate());

			// create tc request
			tcRequestStatusFlag = createTCRequest(tRequestModel);

			if (tcRequestStatusFlag > 0) {
				int i = beneficiaryFlowStatusRepo.updateFlagAfterTcRequestCreatedFromWorklist(
						commonUtilityClass.getBenFlowID(), commonUtilityClass.getBeneficiaryRegID(),
						commonUtilityClass.getVisitCode(), tRequestModel.getUserID(), tRequestModel.getRequestDate());
				if (i > 0) {
					returnOBJ = 1;
				} else {
					throw new Exception(
							"Teleconsultation request created but ERROR while updating the beneficiary status.");
				}
			} else {
				throw new Exception("Error while creating Teleconsultation request.");
			}
		} else {
			throw new Exception("Invalid request.");
		}
		return returnOBJ;
	}

	public String getTCRequestListBySpecialistIdAndDate(Integer providerServiceMapID, Integer userID, String reqDate)
			throws Exception {
		LocalDate datePart = LocalDate.parse(reqDate.split("T")[0]);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.SSS");
		Date d = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").parse(datePart.format(format));
		Timestamp t = new Timestamp(d.getTime());
		ArrayList<BeneficiaryFlowStatus> tcList = beneficiaryFlowStatusRepo.getTCRequestList(providerServiceMapID,
				userID, t);
		return new Gson().toJson(tcList);
	}
}
