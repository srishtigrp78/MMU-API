package com.iemr.mmu.service.common.transaction;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;

import com.iemr.mmu.data.common.DocFileManager;

public interface CommonService {
	public String saveFiles(List<DocFileManager> docFileManagerList) throws IOException;

	public Resource loadFileAsResource(String file, String path) throws IOException;

	public String getBenSymptomaticQuestionnaireDetailsData(Long beneficiaryRegID) throws Exception;
}
