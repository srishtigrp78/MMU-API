package com.iemr.mmu.repo.syncActivity_syncLayer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iemr.mmu.data.syncActivity_syncLayer.DownloadedCaseSheet;

public interface DownloadedCaseSheetRepo extends CrudRepository<DownloadedCaseSheet, Integer>{

	@Query("SELECT t FROM DownloadedCaseSheet t WHERE t.mmuVisitCode = :mmuVisitCode")
	public DownloadedCaseSheet getTmCaseSheetFromOffline(@Param("mmuVisitCode") Long mmuVisitCode);
}
