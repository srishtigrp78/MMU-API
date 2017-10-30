package com.iemr.mmu.repo.doctor;

import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iemr.mmu.data.doctor.CancerAbdominalExamination;
import com.iemr.mmu.data.nurse.BenCancerVitalDetail;

public interface CancerAbdominalExaminationRepo extends CrudRepository<CancerAbdominalExamination, Long>{

	@Query(" SELECT c from CancerAbdominalExamination c WHERE c.beneficiaryRegID = :benRegID AND c.benVisitID = :benVisitID "
			+ " AND DATE(c.createdDate) = :createdDate")
	public CancerAbdominalExamination getBenCancerAbdominalExaminationDetails(@Param("benRegID") Long benRegID,
	@Param("benVisitID") Long benVisitID, @Param("createdDate") Date createdDate);
}
