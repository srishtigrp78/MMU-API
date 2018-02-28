package com.iemr.mmu.repo.doctor;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.doctor.CancerLymphNodeDetails;
import com.iemr.mmu.data.doctor.CancerOralExamination;
@Repository
public interface CancerOralExaminationRepo extends CrudRepository<CancerOralExamination, Long> {
	
	@Query(" SELECT c from CancerOralExamination c WHERE c.beneficiaryRegID = :benRegID AND c.benVisitID = :benVisitID "
			+ " AND c.deleted = false")
	public CancerOralExamination getBenCancerOralExaminationDetails(@Param("benRegID") Long benRegID,
	@Param("benVisitID") Long benVisitID);
	
	@Query("SELECT processed from CancerOralExamination where beneficiaryRegID=:benRegID AND benVisitID = :benVisitID")
	public String getCancerOralExaminationStatus(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Transactional
	@Modifying
	@Query("update CancerOralExamination set providerServiceMapID=:providerServiceMapID, limitedMouthOpening=:limitedMouthOpening, "
			+ "premalignantLesions=:premalignantLesions, preMalignantLesionType=:preMalignantLesionType, "
			+ "prolongedIrritation=:prolongedIrritation, chronicBurningSensation=:chronicBurningSensation, "
			+ "observation =:observation, modifiedBy=:modifiedBy, processed=:processed where "
			+ " beneficiaryRegID=:benRegID AND benVisitID = :benVisitID")
	public int updateCancerSignAndSymptoms(@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("limitedMouthOpening") String limitedMouthOpening, 
			@Param("premalignantLesions") Boolean premalignantLesions,
			@Param("preMalignantLesionType") String preMalignantLesionType, 
			@Param("prolongedIrritation") Boolean prolongedIrritation,
			@Param("chronicBurningSensation") Boolean chronicBurningSensation, 
			@Param("observation") String observation,
			@Param("modifiedBy") String modifiedBy,
			@Param("benRegID") Long benRegID, @Param("benVisitID") Long benVisitID,
			@Param("processed") String processed);
}
