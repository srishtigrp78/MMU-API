package com.iemr.mmu.service.ncdscreening;

import java.util.HashMap;
import java.util.Map;

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
import com.iemr.mmu.service.anc.ANCNurseServiceImpl;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.mmu.utils.exception.IEMRException;
import com.iemr.mmu.utils.mapper.InputMapper;

@Service
public class NCDScreeningServiceImpl implements NCDScreeningService {

	private NCDScreeningNurseServiceImpl ncdScreeningNurseServiceImpl;
	private NurseServiceImpl nurseServiceImpl;
	private ANCNurseServiceImpl ancNurseServiceImpl;


	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}

	@Autowired
	public void setAncServiceImpl(ANCNurseServiceImpl ancNurseServiceImpl) {
		this.ancNurseServiceImpl = ancNurseServiceImpl;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer saveNCDScreeningNurseData(JsonObject jsonObject) throws Exception {

		JsonElement visitDetails = jsonObject.get("visitDetails");
		JsonElement ncdScreeningDetails = jsonObject.get("ncdScreeningDetails");

		BeneficiaryVisitDetail beneficiaryVisitDetail = InputMapper.gson().fromJson(visitDetails,
				BeneficiaryVisitDetail.class);
		
		NCDScreening ncdScreening = InputMapper.gson().fromJson(ncdScreeningDetails, NCDScreening.class);

		Long visitID = nurseServiceImpl.saveBeneficiaryVisitDetails(beneficiaryVisitDetail);
		Integer result = null;
		Integer updateStatus = null;

		if (null != visitID) {
			
			Long vitalSuccessFlag = saveNCDScreeningVitalDetails(jsonObject, visitID);
			Long saveNCDScreeningDetails = null;
			if(null != ncdScreening){
				ncdScreening.setBenVisitID(visitID);
				saveNCDScreeningDetails = ncdScreeningNurseServiceImpl.saveNCDScreeningDetails(ncdScreening);
			}

			if (null != vitalSuccessFlag && null != saveNCDScreeningDetails) {
				updateStatus = nurseServiceImpl.updateBeneficiaryStatus('N',
						beneficiaryVisitDetail.getBeneficiaryRegID());
				result = 1;
			}

			if (null == result || null == updateStatus)
				throw new Exception("Insertion Error");
		} else {
			throw new Exception("Insertion Error");
		}
		return result;
	}

	public Long saveNCDScreeningVitalDetails(JsonObject jsonObject, Long benVisitID) {
		
		Long vitalSuccessFlag = null;
		JsonElement ncdScreeningDetails = jsonObject.get("ncdScreeningDetails");
		
		BenAnthropometryDetail anthropometryDetail = null;
		BenPhysicalVitalDetail physicalVitalDetail = null;
		try {
			anthropometryDetail = InputMapper.gson().fromJson(ncdScreeningDetails,
					BenAnthropometryDetail.class);
			
			physicalVitalDetail = InputMapper.gson().fromJson(ncdScreeningDetails,
					BenPhysicalVitalDetail.class);
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Long saveAnthropometryDetail = null;
		if(null != anthropometryDetail){
			anthropometryDetail.setBenVisitID(benVisitID);
			saveAnthropometryDetail = nurseServiceImpl
					.saveBeneficiaryPhysicalAnthropometryDetails(anthropometryDetail);
		}
		Long savePhysicalVitalDetails = null;
		if(null != physicalVitalDetail){
			physicalVitalDetail.setBenVisitID(benVisitID);
			savePhysicalVitalDetails = nurseServiceImpl.saveBeneficiaryPhysicalVitalDetails(physicalVitalDetail);
		}
		
		if((null != saveAnthropometryDetail && saveAnthropometryDetail>0) && (null != savePhysicalVitalDetails && savePhysicalVitalDetails>0)){
			vitalSuccessFlag = saveAnthropometryDetail;
		}
		
		return vitalSuccessFlag;
	}
	
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer updateNurseNCDScreeningDetails(JsonObject jsonObject) throws Exception {

		NCDScreening ncdScreening = InputMapper.gson().fromJson(jsonObject, NCDScreening.class);
		BenAnthropometryDetail anthropometryDetail = InputMapper.gson().fromJson(jsonObject,
				BenAnthropometryDetail.class);
		BenPhysicalVitalDetail physicalVitalDetail = InputMapper.gson().fromJson(jsonObject,
				BenPhysicalVitalDetail.class);

		Integer result = null;

		Integer updateNCDScreeningDetails = ncdScreeningNurseServiceImpl.updateNCDScreeningDetails(ncdScreening);
		Integer updateANCAnthropometryDetails = ancNurseServiceImpl.updateANCAnthropometryDetails(anthropometryDetail);
		Integer updateANCPhysicalVitalDetails = ancNurseServiceImpl.updateANCPhysicalVitalDetails(physicalVitalDetail);

		if (null != updateANCAnthropometryDetails && null != updateANCPhysicalVitalDetails
				&& null != updateNCDScreeningDetails)
			result = 1;

		if (null == result)
			throw new Exception("Insertion Error");
		else
			return result;
	}

	@Override
	public String getNCDScreeningDetails(Long beneficiaryRegID, Long benVisitID) {
		String ncdScreeningDetails = ncdScreeningNurseServiceImpl.getNCDScreeningDetails(beneficiaryRegID, benVisitID);
		String anthropometryDetails = nurseServiceImpl.getBeneficiaryPhysicalAnthropometryDetails(beneficiaryRegID,
				benVisitID);
		String vitalDetails = nurseServiceImpl.getBeneficiaryPhysicalVitalDetails(beneficiaryRegID, benVisitID);
	
		Map<String, String> res = new HashMap<String, String>();
	
		if (ncdScreeningDetails != null && anthropometryDetails != null && vitalDetails != null) {
			res.put("ncdScreeningDetails", ncdScreeningDetails);
			res.put("anthropometryDetails", anthropometryDetails);
			res.put("vitalDetails", vitalDetails);
		} else {
			// Failed to Fetch Beneficiary NCD Screening Details
		}
		return new Gson().toJson(res);
	}

}
