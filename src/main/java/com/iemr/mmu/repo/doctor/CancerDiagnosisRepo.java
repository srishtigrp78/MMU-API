package com.iemr.mmu.repo.doctor;

import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iemr.mmu.data.doctor.CancerBreastExamination;
import com.iemr.mmu.data.doctor.CancerDiagnosis;

public interface CancerDiagnosisRepo extends CrudRepository<CancerDiagnosis, Long> {
	
	@Query(" SELECT c from CancerDiagnosis c WHERE c.beneficiaryRegID = :benRegID AND c.benVisitID = :benVisitID "
			+ " AND DATE(c.createdDate) = :createdDate")
	public CancerDiagnosis getBenCancerDiagnosisDetails(@Param("benRegID") Long benRegID,
	@Param("benVisitID") Long benVisitID, @Param("createdDate") Date createdDate);
	
}
