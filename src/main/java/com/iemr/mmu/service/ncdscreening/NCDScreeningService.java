package com.iemr.mmu.service.ncdscreening;

import com.iemr.mmu.data.ncdScreening.NCDScreening;

public interface NCDScreeningService {
	
	public Long saveNCDScreeningDetails(NCDScreening ncdScreening);
	
	public String getNCDScreeningDetails(Long beneficiaryRegID, Long benVisitID);
	
	public Integer updateNCDScreeningDetails(NCDScreening ncdScreening); 
}
