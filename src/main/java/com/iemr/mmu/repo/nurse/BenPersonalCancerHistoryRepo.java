package com.iemr.mmu.repo.nurse;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.nurse.BenPersonalCancerHistory;

@Repository
public interface BenPersonalCancerHistoryRepo extends CrudRepository<BenPersonalCancerHistory, Long> {

	@Query(" SELECT bph from BenPersonalCancerHistory bph  WHERE bph.beneficiaryRegID = :benRegID AND bph.benVisitID = :benVisitID ")
	public BenPersonalCancerHistory getBenPersonalHistory(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);

}
