package com.iemr.mmu.service.cancerScreening;

import java.util.List;

import com.iemr.mmu.data.nurse.BenCancerVitalDetail;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerDietHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerHistory;

public interface CSNurseService {

	int saveBenFamilyCancerHistory(List<BenFamilyCancerHistory> benFamilyCancerHistoryList);

	Long saveBenPersonalCancerHistory(BenPersonalCancerHistory benPersonalCancerHistory);

	Long saveBenPersonalCancerDietHistory(BenPersonalCancerDietHistory benPersonalCancerDietHistory);

	Long saveBenObstetricCancerHistory(BenObstetricCancerHistory benObstetricCancerHistory);

	Long saveBenVitalDetail(BenCancerVitalDetail benCancerVitalDetail);

	int updateBeneficiaryFamilyCancerHistory(List<BenFamilyCancerHistory> benFamilyCancerHistoryList);

	int updateBenObstetricCancerHistory(BenObstetricCancerHistory benObstetricCancerHistory);

	int updateBenPersonalCancerHistory(BenPersonalCancerHistory benPersonalCancerHistory);

	int updateBenPersonalCancerDietHistory(BenPersonalCancerDietHistory benPersonalCancerDietHistory);

	int updateBenVitalDetail(BenCancerVitalDetail benCancerVitalDetail);

	List<BenFamilyCancerHistory> getBenFamilyHisData(Long benRegID, Long benVisitID);

	BenObstetricCancerHistory getBenObstetricDetailsData(Long benRegID, Long benVisitID);

	BenPersonalCancerHistory getBenPersonalCancerHistoryData(Long benRegID, Long benVisitID);

	BenPersonalCancerDietHistory getBenPersonalCancerDietHistoryData(Long benRegID, Long benVisitID);

	BenCancerVitalDetail getBenCancerVitalDetailData(Long benRegID, Long benVisitID);

}
