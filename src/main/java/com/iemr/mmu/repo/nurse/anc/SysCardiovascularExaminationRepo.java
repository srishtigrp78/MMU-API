package com.iemr.mmu.repo.nurse.anc;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.SysCardiovascularExamination;

@Repository
public interface SysCardiovascularExaminationRepo extends CrudRepository<SysCardiovascularExamination, Long> {
	@Query(" SELECT u FROM SysCardiovascularExamination u WHERE u.beneficiaryRegID = :benRegID AND u.benVisitID = :benVisitID ")
	public SysCardiovascularExamination getSysCardiovascularExaminationData(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
}
