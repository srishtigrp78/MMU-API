package com.iemr.mmu.service.nurse;

import com.iemr.mmu.data.nurse.BenCancerVitalDetail;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerDietHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerHistory;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;

public interface NurseService {

	public BeneficiaryVisitDetail saveBeneficiaryVisitDetails(BeneficiaryVisitDetail beneficiaryVisitDetail);
	
	public BenFamilyCancerHistory saveBenFamilyCancerHistory(BenFamilyCancerHistory benFamilyCancerHistory);
	
	public BenObstetricCancerHistory saveBenObstetricCancerHistory(BenObstetricCancerHistory benObstetricCancerHistory);
	
	public BenPersonalCancerDietHistory saveBenPersonalCancerDietHistory(BenPersonalCancerDietHistory benPersonalCancerDietHistory);
	
	public BenPersonalCancerHistory saveBenPersonalCancerHistory(BenPersonalCancerHistory benPersonalCancerHistory);
	
	public BenCancerVitalDetail saveBenVitalDetail(BenCancerVitalDetail benCancerVitalDetail);
	
	public String savePatientVisitDetails();

}
