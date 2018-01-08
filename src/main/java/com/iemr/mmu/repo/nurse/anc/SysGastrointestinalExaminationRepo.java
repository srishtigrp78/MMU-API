package com.iemr.mmu.repo.nurse.anc;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.anc.SysGastrointestinalExamination;

@Repository
public interface SysGastrointestinalExaminationRepo extends CrudRepository<SysGastrointestinalExamination, Long> {
	
	@Query(" SELECT u FROM SysGastrointestinalExamination u WHERE u.beneficiaryRegID = :benRegID AND u.benVisitID = :benVisitID ")
	public SysGastrointestinalExamination getSSysGastrointestinalExamination(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Transactional
	@Modifying
	@Query("update SysGastrointestinalExamination set inspection=:inspection, palpation=:palpation, palpation_AbdomenTexture=:palpation_AbdomenTexture, "
			+ "palpation_Liver=:palpation_Liver, palpation_Spleen=:palpation_Spleen, palpation_Tenderness =:palpation_Tenderness, "
			+ "palpation_LocationOfTenderness=:palpation_LocationOfTenderness, percussion=:percussion, auscultation=:auscultation, analRegion=:analRegion,"
			+ " modifiedBy=:modifiedBy where beneficiaryRegID=:benRegID and benVisitID = :benVisitID ")
	public int updateSysGastrointestinalExamination(@Param("inspection") String inspection,
			@Param("palpation") String palpation,
			@Param("palpation_AbdomenTexture") String palpation_AbdomenTexture,
			@Param("palpation_Liver") String palpation_Liver,
			@Param("palpation_Spleen") String palpation_Spleen,
			@Param("palpation_Tenderness") String palpation_Tenderness,
			@Param("palpation_LocationOfTenderness") String palpation_LocationOfTenderness,
			@Param("percussion") String percussion,
			@Param("auscultation") String auscultation,
			@Param("analRegion") String analRegion,
			@Param("modifiedBy") String modifiedBy,
			@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
}
