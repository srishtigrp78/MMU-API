package com.iemr.mmu.service.benFlowStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;

/***
 * 
 * @author NE298657
 *
 */
@Service
public class CommonBenStatusFlowServiceImpl implements CommonBenStatusFlowService {
	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;
	CommonNurseServiceImpl commonNurseServiceImpl;

	@Autowired
	public void setCommonNurseServiceImpl(CommonNurseServiceImpl commonNurseServiceImpl) {
		this.commonNurseServiceImpl = commonNurseServiceImpl;
	}

	@Autowired
	public void setBeneficiaryFlowStatusRepo(BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo) {
		this.beneficiaryFlowStatusRepo = beneficiaryFlowStatusRepo;
	}

}
