package com.iemr.mmu.repo.doctor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.doctor.CancerExaminationImageAnnotation;

@Repository
public interface CancerExaminationImageAnnotationRepo extends CrudRepository<CancerExaminationImageAnnotation, Long> {

	@Query(" SELECT t FROM CancerExaminationImageAnnotation t  "
			+ "  WHERE t.beneficiaryRegID =:benRegID AND t.benVisitID =:benVisitID ORDER BY t.cancerImageID  ")
	public List<CancerExaminationImageAnnotation> getCancerExaminationImageAnnotationList(
			@Param("benRegID") Long benRegID, @Param("benVisitID") Long benVisitID);
	
	@Query("SELECT ID, processed from CancerExaminationImageAnnotation where beneficiaryRegID=:benRegID AND benVisitID = :benVisitID")
	public  ArrayList<Object[]> getCancerExaminationImageAnnotationDetailsStatus(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Modifying
	@Transactional
	@Query("update CancerExaminationImageAnnotation set deleted=true, processed=:processed WHERE ID = :ID")
	public int deleteExistingImageAnnotationDetails(@Param("ID") Long ID, @Param("processed") String processed);

}
