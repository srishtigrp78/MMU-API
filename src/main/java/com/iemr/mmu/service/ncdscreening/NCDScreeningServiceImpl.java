package com.iemr.mmu.service.ncdscreening;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.ncdScreening.NCDScreening;
import com.iemr.mmu.repo.nurse.ncdscreening.NCDScreeningRepo;

@Service
public class NCDScreeningServiceImpl implements NCDScreeningService{

	private NCDScreeningRepo ncdScreeningRepo;

	@Autowired
	public void setNcdScreeningRepo(NCDScreeningRepo ncdScreeningRepo) {
		this.ncdScreeningRepo = ncdScreeningRepo;
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
		Map<String, Object> resMap = new HashMap<>();
		NCDScreening ncdScreeningDetails = ncdScreeningRepo.getNCDScreeningDetails(beneficiaryRegID, benVisitID);
		if(null != ncdScreeningDetails) {
			resMap.put("NCDScreeningDetails", ncdScreeningDetails);
			return new Gson().toJson(resMap);
		} else {
			return null;
		}
	}

	@Override
	public int updateNCDScreeningDetails(NCDScreening ncdScreening) {
		int r = 0;

		r = ncdScreeningRepo.updateNCDScreeningDetails(
				ncdScreening.getNcdScreeningConditionID(),ncdScreening.getScreeningCondition(),
				ncdScreening.getNcdScreeningReasonID(), ncdScreening.getReasonForScreening(), ncdScreening.getNextScreeningDate(),
				ncdScreening.getActionForScreenPositive(), ncdScreening.getIsScreeningComplete(), ncdScreening.getModifiedBy(),
				ncdScreening.getBeneficiaryRegID(), ncdScreening.getBenVisitID());

		return r;
	}

}
