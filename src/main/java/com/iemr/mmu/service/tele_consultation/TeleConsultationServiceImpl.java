package com.iemr.mmu.service.tele_consultation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mmu.data.tele_consultation.TCRequestModel;
import com.iemr.mmu.repo.tc_consultation.TCRequestModelRepo;

@Service
public class TeleConsultationServiceImpl implements TeleConsultationService {
	@Autowired
	private TCRequestModelRepo tCRequestModelRepo;

	public int createTCRequest(TCRequestModel tCRequestModel) {
		TCRequestModel tCRequestModelRS = tCRequestModelRepo.save(tCRequestModel);
		if (tCRequestModelRS != null && tCRequestModelRS.gettMRequestID() > 0)
			return 1;
		else
			return 0;
	}
}
