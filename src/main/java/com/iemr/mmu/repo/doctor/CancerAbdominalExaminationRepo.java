package com.iemr.mmu.repo.doctor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.doctor.CancerAbdominalExamination;

@Repository
public interface CancerAbdominalExaminationRepo extends CrudRepository<CancerAbdominalExamination, Long> {

	@Query(" SELECT c from CancerAbdominalExamination c WHERE c.beneficiaryRegID = :benRegID AND c.benVisitID = :benVisitID AND c.deleted = false")
	public CancerAbdominalExamination getBenCancerAbdominalExaminationDetails(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
}
