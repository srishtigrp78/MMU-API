package com.iemr.mmu.repo.doctor;

import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.doctor.CancerBreastExamination;

@Repository
public interface CancerBreastExaminationRepo extends CrudRepository<CancerBreastExamination, Long> {

	@Query(" SELECT c from CancerBreastExamination c WHERE c.beneficiaryRegID = :benRegID AND c.benVisitID = :benVisitID "
			+ " AND c.deleted = fasle")
	public CancerBreastExamination getBenCancerBreastExaminationDetails(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
}
