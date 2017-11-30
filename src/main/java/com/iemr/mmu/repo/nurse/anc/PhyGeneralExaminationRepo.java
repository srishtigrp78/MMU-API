package com.iemr.mmu.repo.nurse.anc;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.PhyGeneralExamination;

@Repository
public interface PhyGeneralExaminationRepo extends CrudRepository<PhyGeneralExamination, Long> {

	@Query(" SELECT u FROM PhyGeneralExamination u WHERE u.beneficiaryRegID = :benRegID AND u.benVisitID = :benVisitID ")
	public PhyGeneralExamination getPhyGeneralExaminationData(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);

}
