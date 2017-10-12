package com.iemr.mmu.repo.nurse;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.nurse.BenPersonalCancerDietHistory;

@Repository
public interface BenPersonalCancerDietHistoryRepo extends CrudRepository<BenPersonalCancerDietHistory, Long> {
	@Query("SELECT bpdh from BenPersonalCancerDietHistory bpdh  WHERE bpdh.beneficiaryRegID = :benRegID AND bpdh.benVisitID = :benVisitID")
	public BenPersonalCancerDietHistory getBenPersonaDietHistory(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);

}
