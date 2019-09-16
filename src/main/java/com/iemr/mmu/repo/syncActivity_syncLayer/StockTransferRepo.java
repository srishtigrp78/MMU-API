package com.iemr.mmu.repo.syncActivity_syncLayer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.syncActivity_syncLayer.T_StockTransfer;

@Repository
public interface StockTransferRepo extends CrudRepository<T_StockTransfer, Long> {
	ArrayList<T_StockTransfer> findByTransferToFacilityIDAndProcessedNotAndSyncFacilityIDNotNullAndVanSerialNoNotNull(
			Integer toFacilityID, String processed);

	@Query(" SELECT stockTransferID FROM T_StockTransfer WHERE syncFacilityID = :syncFacilityID AND vanSerialNo = :vanSerialNo  ")
	Long searchBySyncFacilityIDAndVanSerialNo(@Param("syncFacilityID") int syncFacilityID,
			@Param("vanSerialNo") long vanSerialNo);

	@Transactional
	@Modifying
	@Query("UPDATE T_StockTransfer SET processed = 'P' WHERE stockTransferID in :ids ")
	int updateProcessedFlag(@Param("ids") List<Long> ids);
}
