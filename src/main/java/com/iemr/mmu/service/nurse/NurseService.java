package com.iemr.mmu.service.nurse;

import java.util.List;

import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenCancerVitalDetail;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerDietHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerHistory;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;

public interface NurseService {

	public Long saveBeneficiaryVisitDetails(BeneficiaryVisitDetail beneficiaryVisitDetail);

	public int saveBenFamilyCancerHistory(List<BenFamilyCancerHistory> benFamilyCancerHistory);

	public Long saveBenObstetricCancerHistory(BenObstetricCancerHistory benObstetricCancerHistory);

	public Long saveBenPersonalCancerDietHistory(BenPersonalCancerDietHistory benPersonalCancerDietHistory);

	public Long saveBenPersonalCancerHistory(BenPersonalCancerHistory benPersonalCancerHistory);

	public Long saveBenVitalDetail(BenCancerVitalDetail benCancerVitalDetail);

	public String savePatientVisitDetails();

	int updateBeneficiaryVisitDetails(BeneficiaryVisitDetail beneficiaryVisitDetail);

	int updateBeneficiaryFamilyCancerHistory(List<BenFamilyCancerHistory> benFamilyCancerHistory);

	int updateBenObstetricCancerHistory(BenObstetricCancerHistory benObstetricCancerHistory);

	int updateBenPersonalCancerHistory(BenPersonalCancerHistory benPersonalCancerHistory);

	int updateBenPersonalCancerDietHistory(BenPersonalCancerDietHistory benPersonalCancerDietHistory);

	int updateBenVitalDetail(BenCancerVitalDetail benCancerVitalDetail);
	
	public Long saveBeneficiaryPhysicalAnthropometryDetails(BenAnthropometryDetail benAnthropometryDetail);
	
	public Long saveBeneficiaryPhysicalVitalDetails(BenPhysicalVitalDetail benPhysicalVitalDetail);

}
