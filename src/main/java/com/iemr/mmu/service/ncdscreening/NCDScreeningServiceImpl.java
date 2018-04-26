package com.iemr.mmu.service.ncdscreening;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.ncdScreening.NCDScreening;
import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.service.benFlowStatus.CommonBenStatusFlowServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;

@Service
public class NCDScreeningServiceImpl implements NCDScreeningService {

	private NCDScreeningNurseServiceImpl ncdScreeningNurseServiceImpl;
	private NurseServiceImpl nurseServiceImpl;
	private CommonNurseServiceImpl commonNurseServiceImpl;
	private CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl;

	@Autowired
	public void setCommonBenStatusFlowServiceImpl(CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl) {
		this.commonBenStatusFlowServiceImpl = commonBenStatusFlowServiceImpl;
	}

	@Autowired
	public void setCommonNurseServiceImpl(CommonNurseServiceImpl commonNurseServiceImpl) {
		this.commonNurseServiceImpl = commonNurseServiceImpl;
	}

	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}

	@Autowired
	public void setNcdScreeningNurseServiceImpl(NCDScreeningNurseServiceImpl ncdScreeningNurseServiceImpl) {
		this.ncdScreeningNurseServiceImpl = ncdScreeningNurseServiceImpl;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer saveNCDScreeningNurseData(JsonObject jsonObject) throws Exception {

		Integer result = null;

		if (jsonObject != null && jsonObject.has("visitDetails") && jsonObject.has("ncdScreeningDetails")) {
			// JsonElement visitDetails = jsonObject.get("visitDetails");
			// JsonElement ncdScreeningDetails =
			// jsonObject.get("ncdScreeningDetails");

			Long benFlowID = jsonObject.get("benFlowID").getAsLong();

			BeneficiaryVisitDetail beneficiaryVisitDetail = InputMapper.gson().fromJson(jsonObject.get("visitDetails"),
					BeneficiaryVisitDetail.class);

			NCDScreening ncdScreening = InputMapper.gson().fromJson(jsonObject.get("ncdScreeningDetails"),
					NCDScreening.class);
			if (ncdScreening.getNextScreeningDate() != null)
				ncdScreening.setNextScreeningDateDB(Timestamp.valueOf(ncdScreening.getNextScreeningDate()));

			Long visitID = commonNurseServiceImpl.saveBeneficiaryVisitDetails(beneficiaryVisitDetail);

			if (null != visitID) {

				Long vitalSuccessFlag = saveNCDScreeningVitalDetails(jsonObject, visitID);
				Long saveNCDScreeningDetails = null;
				ncdScreening.setBenVisitID(visitID);
				saveNCDScreeningDetails = ncdScreeningNurseServiceImpl.saveNCDScreeningDetails(ncdScreening);

				if (null != vitalSuccessFlag && null != saveNCDScreeningDetails) {

					int i = updateBenFlowNurseAfterNurseActivityANC(beneficiaryVisitDetail.getBeneficiaryRegID(),
							visitID, benFlowID, beneficiaryVisitDetail.getVisitReason(),
							beneficiaryVisitDetail.getVisitCategory(), ncdScreening.getIsScreeningComplete());

					result = 1;
				}
			}
		}
		return result;
	}

	private int updateBenFlowNurseAfterNurseActivityANC(Long benRegID, Long benVisitID, Long benFlowID,
			String visitReason, String visitCategory, Boolean isScreeningDone) {
		short nurseFlag;
		short docFlag = (short) 0;
		short labIteration = (short) 0;

		if (isScreeningDone == true)
			nurseFlag = (short) 9;
		else
			nurseFlag = (short) 100;

		int rs = commonBenStatusFlowServiceImpl.updateBenFlowNurseAfterNurseActivity(benFlowID, benRegID, benVisitID,
				visitReason, visitCategory, nurseFlag, docFlag, labIteration, (short) 0, (short) 0);

		return rs;
	}

	public Long saveNCDScreeningVitalDetails(JsonObject jsonObject, Long benVisitID) throws Exception {

		Long vitalSuccessFlag = null;
		JsonElement ncdScreeningDetails = jsonObject.get("ncdScreeningDetails");

		BenAnthropometryDetail anthropometryDetail = null;
		BenPhysicalVitalDetail physicalVitalDetail = null;

		anthropometryDetail = InputMapper.gson().fromJson(ncdScreeningDetails, BenAnthropometryDetail.class);

		physicalVitalDetail = InputMapper.gson().fromJson(ncdScreeningDetails, BenPhysicalVitalDetail.class);

		Long saveAnthropometryDetail = null;
		if (null != anthropometryDetail) {
			anthropometryDetail.setBenVisitID(benVisitID);
			saveAnthropometryDetail = commonNurseServiceImpl
					.saveBeneficiaryPhysicalAnthropometryDetails(anthropometryDetail);
		}
		Long savePhysicalVitalDetails = null;
		if (null != physicalVitalDetail) {
			physicalVitalDetail.setBenVisitID(benVisitID);
			savePhysicalVitalDetails = commonNurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(physicalVitalDetail);
		}

		if ((null != saveAnthropometryDetail && saveAnthropometryDetail > 0)
				&& (null != savePhysicalVitalDetails && savePhysicalVitalDetails > 0)) {
			vitalSuccessFlag = saveAnthropometryDetail;
		}

		return vitalSuccessFlag;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer updateNurseNCDScreeningDetails(JsonObject jsonObject) throws Exception {

		NCDScreening ncdScreening = InputMapper.gson().fromJson(jsonObject, NCDScreening.class);

		if (ncdScreening.getNextScreeningDate() != null)
			ncdScreening.setNextScreeningDateDB(Timestamp.valueOf(ncdScreening.getNextScreeningDate()));

		BenAnthropometryDetail anthropometryDetail = InputMapper.gson().fromJson(jsonObject,
				BenAnthropometryDetail.class);
		BenPhysicalVitalDetail physicalVitalDetail = InputMapper.gson().fromJson(jsonObject,
				BenPhysicalVitalDetail.class);

		Integer result = null;

		Integer updateNCDScreeningDetails = ncdScreeningNurseServiceImpl.updateNCDScreeningDetails(ncdScreening);
		Integer updateANCAnthropometryDetails = commonNurseServiceImpl
				.updateANCAnthropometryDetails(anthropometryDetail);
		Integer updateANCPhysicalVitalDetails = commonNurseServiceImpl
				.updateANCPhysicalVitalDetails(physicalVitalDetail);

		if (null != updateANCAnthropometryDetails && null != updateANCPhysicalVitalDetails
				&& null != updateNCDScreeningDetails) {
			
			// int i =
			// updateBenFlowNurseAfterNurseActivityANC(ncdScreening.getBeneficiaryRegID(),
			// ncdScreening.getBenVisitID(), ncdScreening.getBenFlowID(),
			// beneficiaryVisitDetail.getVisitReason(),
			// beneficiaryVisitDetail.getVisitCategory(),
			// ncdScreening.getIsScreeningComplete());

			
			result = 1;
		}

		return result;

	}

	@Override
	public String getNCDScreeningDetails(Long beneficiaryRegID, Long benVisitID) {
		String ncdScreeningDetails = ncdScreeningNurseServiceImpl.getNCDScreeningDetails(beneficiaryRegID, benVisitID);
		String anthropometryDetails = commonNurseServiceImpl
				.getBeneficiaryPhysicalAnthropometryDetails(beneficiaryRegID, benVisitID);
		String vitalDetails = commonNurseServiceImpl.getBeneficiaryPhysicalVitalDetails(beneficiaryRegID, benVisitID);

		Map<String, Object> res = new HashMap<String, Object>();

		if (ncdScreeningDetails != null && anthropometryDetails != null && vitalDetails != null) {
			res.put("ncdScreeningDetails", ncdScreeningDetails);
			res.put("anthropometryDetails", anthropometryDetails);
			res.put("vitalDetails", vitalDetails);
		} else {
			// Failed to Fetch Beneficiary NCD Screening Details
		}
		return res.toString();
	}

}
