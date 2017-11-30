package com.iemr.mmu.repo.nurse.anc;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.PhyHeadToToeExamination;

@Repository
public interface PhyHeadToToeExaminationRepo extends CrudRepository<PhyHeadToToeExamination, Long> {
	@Query(" SELECT u FROM PhyHeadToToeExamination u WHERE u.beneficiaryRegID = :benRegID AND u.benVisitID = :benVisitID ")
	public PhyHeadToToeExamination getPhyHeadToToeExaminationData(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
}
