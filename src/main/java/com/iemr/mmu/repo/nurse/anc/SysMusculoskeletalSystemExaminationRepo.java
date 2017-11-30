package com.iemr.mmu.repo.nurse.anc;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.SysMusculoskeletalSystemExamination;

@Repository
public interface SysMusculoskeletalSystemExaminationRepo
		extends CrudRepository<SysMusculoskeletalSystemExamination, Long> {
	@Query(" SELECT u FROM SysMusculoskeletalSystemExamination u WHERE u.beneficiaryRegID = :benRegID AND u.benVisitID = :benVisitID ")
	public SysMusculoskeletalSystemExamination getSysMusculoskeletalSystemExamination(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
}
