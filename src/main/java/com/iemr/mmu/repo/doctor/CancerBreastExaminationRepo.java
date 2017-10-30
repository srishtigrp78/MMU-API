package com.iemr.mmu.repo.doctor;

import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iemr.mmu.data.doctor.CancerBreastExamination;
import com.iemr.mmu.data.nurse.BenCancerVitalDetail;

public interface CancerBreastExaminationRepo extends CrudRepository<CancerBreastExamination, Long>{

	@Query(" SELECT c from CancerBreastExamination c WHERE c.beneficiaryRegID = :benRegID AND c.benVisitID = :benVisitID "
			+ " AND DATE(c.createdDate) = :createdDate")
	public CancerBreastExamination getBenCancerBreastExaminationDetails(@Param("benRegID") Long benRegID,
	@Param("benVisitID") Long benVisitID, @Param("createdDate") Date createdDate);
}
