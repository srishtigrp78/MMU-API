package com.iemr.mmu.repo.nurse.anc;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.anc.SysObstetricExamination;

@Repository
public interface SysObstetricExaminationRepo extends CrudRepository<SysObstetricExamination, Long> {
	
	@Query(" SELECT u FROM SysObstetricExamination u WHERE u.beneficiaryRegID = :benRegID AND u.benVisitID = :benVisitID ")
	public SysObstetricExamination getSysObstetricExaminationData(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Transactional
	@Modifying
	@Query("update SysObstetricExamination set fundalHeight=:fundalHeight, fHAndPOA_Status=:fHAndPOA_Status, fHAndPOA_Interpretation=:fHAndPOA_Interpretation, "
			+ "fetalMovements=:fetalMovements, fetalHeartSounds=:fetalHeartSounds, fetalHeartRate_BeatsPerMinute=:fetalHeartRate_BeatsPerMinute, "
			+ "fetalPositionOrLie=:fetalPositionOrLie, fetalPresentation=:fetalPresentation, abdominalScars=:abdominalScars , modifiedBy=:modifiedBy "
			+ "where beneficiaryRegID=:benRegID and benVisitID = :benVisitID ")
	public int updateSysObstetricExamination(@Param("fundalHeight") String fundalHeight,
			@Param("fHAndPOA_Status") String fHAndPOA_Status,
			@Param("fHAndPOA_Interpretation") String fHAndPOA_Interpretation,
			@Param("fetalMovements") String fetalMovements,
			@Param("fetalHeartSounds") String fetalHeartSounds,
			@Param("fetalHeartRate_BeatsPerMinute") String fetalHeartRate_BeatsPerMinute,
			@Param("fetalPositionOrLie") String fetalPositionOrLie,
			@Param("fetalPresentation") String fetalPresentation,
			@Param("abdominalScars") String abdominalScars,
			@Param("modifiedBy") String modifiedBy,
			@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
}
