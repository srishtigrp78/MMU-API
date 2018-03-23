package com.iemr.mmu.service.benFlowStatus;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;
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

	public int createBenFlowRecord(String requestOBJ, Long beneficiaryRegID,Long beneficiaryID) {
		BeneficiaryFlowStatus obj = getBenFlowRecordObj(requestOBJ, beneficiaryRegID, beneficiaryID);
		return 0;
	}

	private BeneficiaryFlowStatus getBenFlowRecordObj(String requestOBJ, Long beneficiaryRegID,Long beneficiaryID) {
		JSONObject mainOBJ = null;
		JSONObject addressOBJ = null;
		if (requestOBJ != null) {
			 mainOBJ = new JSONObject(requestOBJ);
			if (mainOBJ.has("currentAddress") && mainOBJ.getJSONObject("currentAddress") != null) {
				 addressOBJ = mainOBJ.getJSONObject("currentAddress");
			}
		}
		
		BeneficiaryFlowStatus obj = new BeneficiaryFlowStatus();
		
		
		return null;
	}

}
