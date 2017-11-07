package com.iemr.mmu.repo.nurse;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.nurse.BenAnthropometryDetail;
import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;

@Repository
public interface BenPhysicalVitalRepo extends CrudRepository<BenPhysicalVitalDetail, Long>{
	
	@Query("select v from BenPhysicalVitalDetail v where v.beneficiaryRegID = :beneficiaryRegID and  v.benVisitID = :benVisitID")
	public BenPhysicalVitalDetail getBenPhysicalVitalDetail(@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("benVisitID") Long benVisitID);
}
