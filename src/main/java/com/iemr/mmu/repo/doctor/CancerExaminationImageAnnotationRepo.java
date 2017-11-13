package com.iemr.mmu.repo.doctor;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.doctor.CancerExaminationImageAnnotation;

@Repository
public interface CancerExaminationImageAnnotationRepo extends CrudRepository<CancerExaminationImageAnnotation, Long> {

	@Query(" SELECT t FROM CancerExaminationImageAnnotation t  "
			+ "  WHERE t.beneficiaryRegID =:benRegID AND t.benVisitID =:benVisitID ORDER BY t.cancerImageID  ")
	public List<CancerExaminationImageAnnotation> getCancerExaminationImageAnnotationList(
			@Param("benRegID") Long benRegID, @Param("benVisitID") Long benVisitID);

}
