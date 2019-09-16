package com.iemr.mmu.repo.syncActivity_syncLayer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.syncActivity_syncLayer.IndentIssue;

@Repository
public interface IndentIssueRepo extends CrudRepository<IndentIssue, Long> {
	ArrayList<IndentIssue> findByToFacilityIDAndProcessedNotAndSyncFacilityIDNotNullAndVanSerialNoNotNull(
			Integer toFacilityID, String processed);

	@Query(" SELECT indentIssueID FROM IndentIssue WHERE syncFacilityID = :syncFacilityID AND vanSerialNo = :vanSerialNo  ")
	Long searchBySyncFacilityIDAndVanSerialNo(@Param("syncFacilityID") int syncFacilityID,
			@Param("vanSerialNo") long vanSerialNo);

	@Transactional
	@Modifying
	@Query("UPDATE IndentIssue SET processed = 'P' WHERE indentIssueID in :ids ")
	int updateProcessedFlag(@Param("ids") List<Long> ids);
}
