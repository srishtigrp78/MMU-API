package com.iemr.mmu.repo.nurse.anc;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.SysGenitourinarySystemExamination;

@Repository
public interface SysGenitourinarySystemExaminationRepo extends CrudRepository<SysGenitourinarySystemExamination, Long> {
	@Query(" SELECT u FROM SysGenitourinarySystemExamination u WHERE u.beneficiaryRegID = :benRegID AND u.benVisitID = :benVisitID ")
	public SysGenitourinarySystemExamination getSysGenitourinarySystemExaminationData(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
}
