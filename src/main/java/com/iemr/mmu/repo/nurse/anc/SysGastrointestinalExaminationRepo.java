package com.iemr.mmu.repo.nurse.anc;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.SysGastrointestinalExamination;

@Repository
public interface SysGastrointestinalExaminationRepo extends CrudRepository<SysGastrointestinalExamination, Long> {
	@Query(" SELECT u FROM SysGastrointestinalExamination u WHERE u.beneficiaryRegID = :benRegID AND u.benVisitID = :benVisitID ")
	public SysGastrointestinalExamination getSSysGastrointestinalExamination(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
}
