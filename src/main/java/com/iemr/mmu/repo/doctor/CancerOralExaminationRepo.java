package com.iemr.mmu.repo.doctor;

import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.doctor.CancerLymphNodeDetails;
import com.iemr.mmu.data.doctor.CancerOralExamination;
@Repository
public interface CancerOralExaminationRepo extends CrudRepository<CancerOralExamination, Long> {
	
	@Query(" SELECT c from CancerOralExamination c WHERE c.beneficiaryRegID = :benRegID AND c.benVisitID = :benVisitID "
			+ " AND c.deleted = false")
	public CancerOralExamination getBenCancerOralExaminationDetails(@Param("benRegID") Long benRegID,
	@Param("benVisitID") Long benVisitID);
}
