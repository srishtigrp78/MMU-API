package com.iemr.mmu.repo.doctor;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iemr.mmu.data.doctor.CancerGynecologicalExamination;
import com.iemr.mmu.data.doctor.CancerLymphNodeDetails;

public interface CancerLymphNodeExaminationRepo extends CrudRepository<CancerLymphNodeDetails, Long>{
	
	@Query(" SELECT c from CancerLymphNodeDetails c WHERE c.beneficiaryRegID = :benRegID AND c.benVisitID = :benVisitID "
			+ " AND DATE(c.createdDate) = :createdDate")
	public List<CancerLymphNodeDetails> getBenCancerLymphNodeDetails(@Param("benRegID") Long benRegID,
	@Param("benVisitID") Long benVisitID, @Param("createdDate") Date createdDate);
}
