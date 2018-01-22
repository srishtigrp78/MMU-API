package com.iemr.mmu.service.ncdscreening;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iemr.mmu.data.ncdScreening.NCDScreening;
import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.repo.nurse.ncdscreening.NCDScreeningRepo;
import com.iemr.mmu.service.anc.ANCServiceImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.utils.mapper.InputMapper;

@Service
public class NCDScreeningServiceImpl implements NCDScreeningService{

	private NCDScreeningRepo ncdScreeningRepo;
	private NurseServiceImpl nurseServiceImpl;
	private ANCServiceImpl ancServiceImpl;

	@Autowired
	public void setNcdScreeningRepo(NCDScreeningRepo ncdScreeningRepo) {
		this.ncdScreeningRepo = ncdScreeningRepo;
	}

	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}

	@Autowired
	public void setAncServiceImpl(ANCServiceImpl ancServiceImpl) {
		this.ancServiceImpl = ancServiceImpl;
	}

	@Transactional(rollbackFor=Exception.class)
	public Integer handleSaveNCDScreeningRequest(JsonObject jsonObject) throws Exception {

		JsonElement visitDetails = jsonObject.get("visitDetails");
		JsonElement ncdScreeningDetails = jsonObject.get("ncdScreeningDetails");

		BeneficiaryVisitDetail beneficiaryVisitDetail = InputMapper.gson().fromJson(visitDetails, BeneficiaryVisitDetail.class);
		NCDScreening ncdScreening = InputMapper.gson().fromJson(ncdScreeningDetails, NCDScreening.class);
		BenAnthropometryDetail anthropometryDetail = InputMapper.gson().fromJson(ncdScreeningDetails, BenAnthropometryDetail.class);
		BenPhysicalVitalDetail physicalVitalDetail = InputMapper.gson().fromJson(ncdScreeningDetails, BenPhysicalVitalDetail.class);

		Long visitID = nurseServiceImpl.saveBeneficiaryVisitDetails(beneficiaryVisitDetail);
		Integer result = null;
		Integer updateStatus = null;

		if(null != visitID) {
			anthropometryDetail.setBenVisitID(visitID);
			Long saveAnthropometryDetail = nurseServiceImpl.saveBeneficiaryPhysicalAnthropometryDetails(anthropometryDetail);

			physicalVitalDetail.setBenVisitID(visitID);
			Long savePhysicalVitalDetails = nurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(physicalVitalDetail);

			ncdScreening.setBenVisitID(visitID);
			Long saveNCDScreeningDetails = saveNCDScreeningDetails(ncdScreening);

			if(null != saveAnthropometryDetail && null != savePhysicalVitalDetails && null != saveNCDScreeningDetails) {
				updateStatus = nurseServiceImpl.updateBeneficiaryStatus('N', beneficiaryVisitDetail.getBeneficiaryRegID());
				result = 1;
			}

			if(null == result || null == updateStatus)
				throw new Exception("Insertion Error");
		} else {
			throw new Exception("Insertion Error");
		}
		return result;
	}


	@Transactional(rollbackFor=Exception.class)
	public Integer handleUpdateNCDScreeningRequest(JsonObject jsonObject) throws Exception {

		

		NCDScreening ncdScreening = InputMapper.gson().fromJson(jsonObject, NCDScreening.class);
		BenAnthropometryDetail anthropometryDetail = InputMapper.gson().fromJson(jsonObject, BenAnthropometryDetail.class);
		BenPhysicalVitalDetail physicalVitalDetail = InputMapper.gson().fromJson(jsonObject, BenPhysicalVitalDetail.class);

		Integer result = null;

		Integer updateNCDScreeningDetails = updateNCDScreeningDetails(ncdScreening);
		Integer updateANCAnthropometryDetails = ancServiceImpl.updateANCAnthropometryDetails(anthropometryDetail);
		Integer updateANCPhysicalVitalDetails = ancServiceImpl.updateANCPhysicalVitalDetails(physicalVitalDetail);

		 
		if(null != updateANCAnthropometryDetails && null != updateANCPhysicalVitalDetails && null != updateNCDScreeningDetails ) 
			result = 1;

		if(null == result)
			throw new Exception("Insertion Error");
		else
			return result;
	}

	@Override    
	public Long saveNCDScreeningDetails(NCDScreening ncdScreening) {
		NCDScreening save = ncdScreeningRepo.save(ncdScreening);
		Long ncdScreeningID = null;
		if (null != save) {
			ncdScreeningID = save.getId();
		}

		return ncdScreeningID;
	}

	@Override
	public String getNCDScreeningDetails(Long beneficiaryRegID, Long benVisitID) {
		NCDScreening ncdScreeningDetails = ncdScreeningRepo.getNCDScreeningDetails(beneficiaryRegID, benVisitID);
		GsonBuilder builder = new GsonBuilder();
		builder.excludeFieldsWithoutExposeAnnotation();
		if(null != ncdScreeningDetails) {
			return builder.create().toJson(ncdScreeningDetails);
		} else {
			return null;
		}
	}

	@Override
	public Integer updateNCDScreeningDetails(NCDScreening ncdScreening) {
		Integer r = 0;

		r = ncdScreeningRepo.updateNCDScreeningDetails(
				ncdScreening.getNcdScreeningConditionID(),ncdScreening.getScreeningCondition(),
				ncdScreening.getNcdScreeningReasonID(), ncdScreening.getReasonForScreening(), ncdScreening.getNextScreeningDate(),
				ncdScreening.getActionForScreenPositive(), ncdScreening.getIsScreeningComplete(), ncdScreening.getModifiedBy(),
				ncdScreening.getBeneficiaryRegID(), ncdScreening.getBenVisitID());

		return r;
	}

}
