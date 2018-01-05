package com.iemr.mmu.repo.nurse.anc;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.anc.SysRespiratoryExamination;

@Repository
public interface SysRespiratoryExaminationRepo extends CrudRepository<SysRespiratoryExamination, Long>{
	
	@Query(" SELECT u FROM SysRespiratoryExamination u WHERE u.beneficiaryRegID = :benRegID AND u.benVisitID = :benVisitID ")
	public SysRespiratoryExamination getSysRespiratoryExaminationData(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
/*	
	Long iD, Long beneficiaryRegID, Long benVisitID, Integer providerServiceMapID,
	String trachea, String inspection, String signsOfRespiratoryDistress, String palpation, String auscultation,
	String auscultation_Stridor, String auscultation_BreathSounds, String auscultation_Crepitations,
	String auscultation_Wheezing, String auscultation_PleuralRub, String auscultation_ConductedSounds,
	String percussion, Boolean deleted, String processed, String createdBy, Timestamp createdDate,
	String modifiedBy, Timestamp lastModDate*/
	
	
	
//	@Transactional
//	@Modifying
//	@Query("update SysRespiratoryExamination set trachea=:trachea, inspection=:inspection, "
//			+ "signsOfRespiratoryDistress=:signsOfRespiratoryDistress, palpation=:palpation, auscultation =:auscultation, "
//			+ "auscultation_Stridor=:auscultation_Stridor, auscultation_BreathSounds=:auscultation_BreathSounds, "
//			+ "auscultation_Crepitations =:auscultation_Crepitations, auscultation_Wheezing =:auscultation_Wheezing, auscultation_PleuralRub=:auscultation_PleuralRub, "
//			+ "auscultation_ConductedSounds=:auscultation_ConductedSounds, percussion=:percussion, modifiedBy=:modifiedBy "
//			+ "where beneficiaryRegID=:benRegID and benVisitID = :benVisitID ")
//	public int updateSysGastrointestinalExamination(@Param("trachea") String trachea,
//			@Param("inspection") String inspection,
//			@Param("signsOfRespiratoryDistress") String signsOfRespiratoryDistress,
//			@Param("palpation") String palpation,
//			@Param("auscultation") String auscultation,
//			@Param("auscultation_Stridor") String auscultation_Stridor,
//			
//			@Param("auscultation_BreathSounds") String auscultation_BreathSounds,
//			@Param("auscultation_Crepitations") String auscultation_Crepitations,
//			@Param("auscultation_Wheezing") String auscultation_Wheezing,
//			@Param("auscultation_PleuralRub") String auscultation_PleuralRub,
//			
//			@Param("auscultation_PleuralRub") String auscultation_PleuralRub,
//			@Param("pericardialRub") String pericardialRub,
//			@Param("modifiedBy") String modifiedBy,
//			@Param("benRegID") Long benRegID,
//			@Param("benVisitID") Long benVisitID);
//	
}
