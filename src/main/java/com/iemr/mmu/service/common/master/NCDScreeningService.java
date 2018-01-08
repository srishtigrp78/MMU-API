package com.iemr.mmu.service.common.master;

import java.util.List;

import com.iemr.mmu.data.masterdata.ncdscreening.NCDScreeningCondition;
import com.iemr.mmu.data.masterdata.ncdscreening.NCDScreeningReason;

public interface NCDScreeningService {

	public List<NCDScreeningCondition> getNCDScreeningConditions(); 
	
	public List<NCDScreeningReason> getNCDScreeningReasons();
	
}
