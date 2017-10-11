package com.iemr.mmu.repo.nurse;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;

@Repository
public interface BenFamilyCancerHistoryRepo extends CrudRepository<BenFamilyCancerHistory, Long> {
	
	@Transactional
	@Modifying
	@Query("update BenFamilyCancerHistory set cancerDiseaseType=:cancerDiseaseType, familyMember=:familyMember, modifiedBy=:modifiedBy where iD=:iD")
	public int updateBenFamilyCancerHistory(@Param("cancerDiseaseType") String cancerDiseaseType,
			@Param("familyMember") String familyMember,
			@Param("modifiedBy") String modifiedBy,
			@Param("iD") Long iD);
}
