package com.iemr.mmu.repo.nurse.anc;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.anc.SysCardiovascularExamination;

@Repository
public interface SysCardiovascularExaminationRepo extends CrudRepository<SysCardiovascularExamination, Long> {
	
	@Query(" SELECT u FROM SysCardiovascularExamination u WHERE u.beneficiaryRegID = :benRegID AND u.benVisitID = :benVisitID ")
	public SysCardiovascularExamination getSysCardiovascularExaminationData(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	

	@Query("SELECT processed from SysCardiovascularExamination where beneficiaryRegID=:benRegID AND benVisitID = :benVisitID")
	public String getBenCardiovascularExaminationStatus(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Transactional
	@Modifying
	@Query("update SysCardiovascularExamination set jugularVenousPulse_JVP=:jugularVenousPulse_JVP, apexbeatLocation=:apexbeatLocation, apexbeatType=:apexbeatType, "
			+ "firstHeartSound_S1=:firstHeartSound_S1, secondHeartSound_S2=:secondHeartSound_S2, additionalHeartSounds =:additionalHeartSounds, "
			+ "murmurs=:murmurs, pericardialRub=:pericardialRub, modifiedBy=:modifiedBy, processed=:processed "
			+ "where beneficiaryRegID=:benRegID and benVisitID = :benVisitID ")
	public int updateSysCardiovascularExamination(@Param("jugularVenousPulse_JVP") String jugularVenousPulse_JVP,
			@Param("apexbeatLocation") String apexbeatLocation,
			@Param("apexbeatType") String apexbeatType,
			@Param("firstHeartSound_S1") String firstHeartSound_S1,
			@Param("secondHeartSound_S2") String secondHeartSound_S2,
			@Param("additionalHeartSounds") String additionalHeartSounds,
			@Param("murmurs") String murmurs,
			@Param("pericardialRub") String pericardialRub,
			@Param("modifiedBy") String modifiedBy,
			@Param("processed") String processed,
			@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
}
