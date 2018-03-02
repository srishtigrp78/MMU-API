package com.iemr.mmu.service.common.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mmu.repo.common.BeneficiaryFlowStatusRepo;

/***
 * 
 * @author NE298657
 *
 */
@Service
public class CommonBenStatusFlowServiceImpl implements CommonBenStatusFlowService {
	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;

	@Autowired
	public void setBeneficiaryFlowStatusRepo(BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo) {
		this.beneficiaryFlowStatusRepo = beneficiaryFlowStatusRepo;
	}

	public Long updateBenFlowStatusFlagMain(String role, Long benRegID, Long benVisitID, Long benVisitCode,
			String visitReason, String visitCategory, Integer visitNo, Short nurseFlag, Short doctorFlag,
			Short pharmaFlag, Short labFlow, Short radiologistFlag, Short oncologistFlag, Short specialistFlag,
			String createdBy, String modifiedBy) {
		
		if(role.equalsIgnoreCase("registrar")){
			
		}
		return null;
	}
}
