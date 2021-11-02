package com.iemr.mmu.service.fileSync;

import java.io.IOException;

import com.iemr.mmu.utils.exception.IEMRException;

public interface FileSyncService {

	String getServerCredential();

	String syncFiles(String ServerAuthorization) throws IEMRException, IOException;
	
}
