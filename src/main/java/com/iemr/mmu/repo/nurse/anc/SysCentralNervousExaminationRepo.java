package com.iemr.mmu.repo.nurse.anc;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.SysCentralNervousExamination;

@Repository
public interface SysCentralNervousExaminationRepo extends CrudRepository<SysCentralNervousExamination, Long> {

	@Query(" SELECT u FROM SysCentralNervousExamination u WHERE u.beneficiaryRegID = :benRegID AND u.benVisitID = :benVisitID ")
	public SysCentralNervousExamination getSysCentralNervousExaminationData(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
}
