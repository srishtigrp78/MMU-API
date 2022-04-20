package com.iemr.mmu.service.common.transaction;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;

import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;
import com.iemr.mmu.data.common.DocFileManager;
import com.iemr.mmu.utils.exception.IEMRException;

public interface CommonService {
	public String saveFiles(List<DocFileManager> docFileManagerList) throws IOException, Exception;

	public Resource loadFileAsResource(String file, String path) throws IOException;

	public String getBenSymptomaticQuestionnaireDetailsData(Long beneficiaryRegID) throws Exception;

	public String getBenPreviousDiabetesData(Long beneficiaryRegID) throws Exception;

	public String getBenPreviousReferralData(Long beneficiaryRegID) throws Exception;

	String getCaseSheetFromCentralServer(String mmuBenFlowOBJ, String authCentralServer) throws Exception;

	String getCaseSheetOfTm(String mmuBenFlowReq, String authCentralServer) throws Exception;
}
