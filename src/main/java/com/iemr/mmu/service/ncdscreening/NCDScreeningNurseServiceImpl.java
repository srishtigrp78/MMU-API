package com.iemr.mmu.service.ncdscreening;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.ncdScreening.NCDScreening;
import com.iemr.mmu.repo.nurse.ncdscreening.NCDScreeningRepo;

@Service
public class NCDScreeningNurseServiceImpl implements NCDScreeningNurseService {

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
			ncdScreeningID = save.getID();
		}

		return ncdScreeningID;
	}

	@Override
	public String getNCDScreeningDetails(Long beneficiaryRegID, Long benVisitID) {
		NCDScreening ncdScreeningDetails = ncdScreeningRepo.getNCDScreeningDetails(beneficiaryRegID, benVisitID);

		if (null != ncdScreeningDetails) {
			return new Gson().toJson(ncdScreeningDetails);
		} else {
			return null;
		}
	}

	@Override
	public Integer updateNCDScreeningDetails(NCDScreening ncdScreening) {
		Integer r = 0;

		r = ncdScreeningRepo.updateNCDScreeningDetails(ncdScreening.getNcdScreeningConditionID(),
				ncdScreening.getScreeningCondition(), ncdScreening.getNcdScreeningReasonID(),
				ncdScreening.getReasonForScreening(), ncdScreening.getNextScreeningDateDB(),
				ncdScreening.getActionForScreenPositive(), ncdScreening.getIsScreeningComplete(),
				ncdScreening.getModifiedBy(), ncdScreening.getBeneficiaryRegID(), ncdScreening.getBenVisitID(),
				ncdScreening.getIsBPPrescribed(), ncdScreening.getIsBloodGlucosePrescribed());

		return r;
	}
}
