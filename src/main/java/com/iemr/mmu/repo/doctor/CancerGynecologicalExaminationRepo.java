package com.iemr.mmu.repo.doctor;

import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.doctor.CancerDiagnosis;
import com.iemr.mmu.data.doctor.CancerGynecologicalExamination;
@Repository
public interface CancerGynecologicalExaminationRepo extends CrudRepository<CancerGynecologicalExamination, Long> {
	
	@Query(" SELECT c from CancerGynecologicalExamination c WHERE c.beneficiaryRegID = :benRegID AND c.benVisitID = :benVisitID "
			+ " AND DATE(c.createdDate) = :createdDate")
	public CancerGynecologicalExamination getBenCancerGynecologicalExaminationDetails(@Param("benRegID") Long benRegID,
	@Param("benVisitID") Long benVisitID, @Param("createdDate") Date createdDate);
}
