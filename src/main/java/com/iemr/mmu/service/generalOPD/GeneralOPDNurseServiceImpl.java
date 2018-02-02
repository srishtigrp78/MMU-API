package com.iemr.mmu.service.generalOPD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.iemr.mmu.data.anc.BenChildDevelopmentHistory;
import com.iemr.mmu.data.anc.ChildFeedingDetails;
import com.iemr.mmu.data.anc.PerinatalHistory;
import com.iemr.mmu.repo.nurse.anc.BenChildDevelopmentHistoryRepo;
import com.iemr.mmu.repo.nurse.anc.ChildFeedingDetailsRepo;
import com.iemr.mmu.repo.nurse.anc.PerinatalHistoryRepo;

@Service
public class GeneralOPDNurseServiceImpl implements GeneralOPDNurseService{
	private BenChildDevelopmentHistoryRepo benChildDevelopmentHistoryRepo;
	private ChildFeedingDetailsRepo childFeedingDetailsRepo;
	private PerinatalHistoryRepo perinatalHistoryRepo;
	
	@Autowired
	public void setPerinatalHistoryRepo(PerinatalHistoryRepo perinatalHistoryRepo) {
		this.perinatalHistoryRepo = perinatalHistoryRepo;
	}
	
	@Autowired
	public void setChildFeedingDetailsRepo(ChildFeedingDetailsRepo childFeedingDetailsRepo) {
		this.childFeedingDetailsRepo = childFeedingDetailsRepo;
	}
	
	@Autowired
	public void setBenChildDevelopmentHistoryRepo(BenChildDevelopmentHistoryRepo benChildDevelopmentHistoryRepo) {
		this.benChildDevelopmentHistoryRepo = benChildDevelopmentHistoryRepo;
	}
	
	public Long saveChildDevelopmentHistory(BenChildDevelopmentHistory benChildDevelopmentHistory) {
		Long developmentSuccessFlag = null;

		BenChildDevelopmentHistory childDevelopmentHistory = BenChildDevelopmentHistory
				.getDevelopmentHistory(benChildDevelopmentHistory);
		BenChildDevelopmentHistory res = benChildDevelopmentHistoryRepo.save(childDevelopmentHistory);
		if (null != res && res.getID() > 0) {
			developmentSuccessFlag = res.getID();
		}
		return developmentSuccessFlag;
	}
	
	public Long saveChildFeedingHistory(ChildFeedingDetails childFeedingDetails) {
		Long feedingSuccessFlag = null;
		ChildFeedingDetails res = childFeedingDetailsRepo.save(childFeedingDetails);
		if (null != res && res.getID() > 0) {
			feedingSuccessFlag = res.getID();
		}
		return feedingSuccessFlag;
	}
	
	public Long savePerinatalHistory(PerinatalHistory perinatalHistory) {
		Long perinatalSuccessFlag = null;

		PerinatalHistory res = perinatalHistoryRepo.save(perinatalHistory);
		if (null != res && res.getID() > 0) {
			perinatalSuccessFlag = res.getID();
		}
		return perinatalSuccessFlag;
	}

	
}
