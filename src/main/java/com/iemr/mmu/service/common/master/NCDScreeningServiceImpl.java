package com.iemr.mmu.service.common.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mmu.data.masterdata.ncdscreening.NCDScreeningCondition;
import com.iemr.mmu.data.masterdata.ncdscreening.NCDScreeningReason;
import com.iemr.mmu.repo.masterrepo.ncdScreening.NCDScreeningConditionRepo;
import com.iemr.mmu.repo.masterrepo.ncdScreening.NCDScreeningReasonRepo;

@Service
public class NCDScreeningServiceImpl implements NCDScreeningService {
	
	private NCDScreeningConditionRepo ncdScreeningConditionRepo;
	private NCDScreeningReasonRepo ncdScreeningReasonRepo;
	
	@Autowired
	public void setNcdScreeningConditionRepo(NCDScreeningConditionRepo ncdScreeningConditionRepo) {
		this.ncdScreeningConditionRepo = ncdScreeningConditionRepo;
	}

	@Autowired
	public void setNcdScreeningReasonRepo(NCDScreeningReasonRepo ncdScreeningReasonRepo) {
		this.ncdScreeningReasonRepo = ncdScreeningReasonRepo;
	}

	@Override
	public List<NCDScreeningCondition> getNCDScreeningConditions() {
		List<NCDScreeningCondition> ncdScreeningConditions  = null;
		try {
			ncdScreeningConditions = (List<NCDScreeningCondition>) ncdScreeningConditionRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ncdScreeningConditions;
	}

	@Override
	public List<NCDScreeningReason> getNCDScreeningReasons() {
		List<NCDScreeningReason> ncdScreeningReasons = null;
		try {
			ncdScreeningReasons = (List<NCDScreeningReason>) ncdScreeningReasonRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ncdScreeningReasons;
	}

}
