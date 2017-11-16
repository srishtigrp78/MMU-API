package com.iemr.mmu.repo.doctor;

import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.doctor.CancerOralExamination;
import com.iemr.mmu.data.doctor.CancerSignAndSymptoms;
@Repository
public interface CancerSignAndSymptomsRepo extends CrudRepository<CancerSignAndSymptoms, Long>{
	
	@Query(" SELECT c from CancerSignAndSymptoms c WHERE c.beneficiaryRegID = :benRegID AND c.benVisitID = :benVisitID "
			+ " AND DATE(c.createdDate) = :createdDate")
	public CancerSignAndSymptoms getBenCancerSignAndSymptomsDetails(@Param("benRegID") Long benRegID,
	@Param("benVisitID") Long benVisitID, @Param("createdDate") Date createdDate);
}
