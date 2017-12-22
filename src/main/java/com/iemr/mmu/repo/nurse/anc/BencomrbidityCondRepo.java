package com.iemr.mmu.repo.nurse.anc;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.BencomrbidityCondDetails;

@Repository
public interface BencomrbidityCondRepo extends CrudRepository<BencomrbidityCondDetails, Long> {

	@Query("select comorbidCondition ,  otherComorbidCondition, year "
			+ "from BencomrbidityCondDetails a where a.beneficiaryRegID = :beneficiaryRegID AND a.isForHistory = true ORDER BY createdDate DESC ")
	public ArrayList<Object[]> getBencomrbidityCondDetails(@Param("beneficiaryRegID") Long beneficiaryRegID);

}
