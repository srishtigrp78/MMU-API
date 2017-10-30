package com.iemr.mmu.repo.nurse;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;

@Repository
public interface BenObstetricCancerHistoryRepo extends CrudRepository<BenObstetricCancerHistory, Long> {

	@Transactional
	@Modifying
	@Query("update BenObstetricCancerHistory set pregnancyStatus=:pregnancyStatus, isUrinePregTest=:isUrinePregTest, pregnant_No=:pregnant_No, "
			+ " noOfLivingChild=:noOfLivingChild, isAbortion=:isAbortion, isOralContraceptiveUsed=:isOralContraceptiveUsed, isHormoneReplacementTherapy=:isHormoneReplacementTherapy, "
			+ " menarche_Age=:menarche_Age, isMenstrualCycleRegular=:isMenstrualCycleRegular, menstrualCycleLength=:menstrualCycleLength, "
			+ " menstrualFlowDuration=:menstrualFlowDuration, menstrualFlowType=:menstrualFlowType, isDysmenorrhea=:isDysmenorrhea,"
			+ " isInterMenstrualBleeding=:isInterMenstrualBleeding, menopauseAge=:menopauseAge, isPostMenopauseBleeding=:isPostMenopauseBleeding,"
			+ " isFoulSmellingDischarge=:isFoulSmellingDischarge, modifiedBy=:modifiedBy where iD=:iD")
	public int updateBenObstetricCancerHistory(@Param("pregnancyStatus") String pregnancyStatus,
			@Param("isUrinePregTest") Boolean isUrinePregTest, @Param("pregnant_No") String pregnant_No,
			@Param("noOfLivingChild") Integer noOfLivingChild, @Param("isAbortion") Boolean isAbortion,
			@Param("isOralContraceptiveUsed") Boolean isOralContraceptiveUsed,
			@Param("isHormoneReplacementTherapy") Boolean isHormoneReplacementTherapy,
			@Param("menarche_Age") Integer menarche_Age,
			@Param("isMenstrualCycleRegular") Boolean isMenstrualCycleRegular,
			@Param("menstrualCycleLength") Integer menstrualCycleLength,
			@Param("menstrualFlowDuration") Integer menstrualFlowDuration,
			@Param("menstrualFlowType") String menstrualFlowType, @Param("isDysmenorrhea") Boolean isDysmenorrhea,
			@Param("isInterMenstrualBleeding") Boolean isInterMenstrualBleeding,
			@Param("menopauseAge") Integer menopauseAge,
			@Param("isPostMenopauseBleeding") Boolean isPostMenopauseBleeding,
			@Param("isFoulSmellingDischarge") Boolean isFoulSmellingDischarge, @Param("modifiedBy") String modifiedBy,
			@Param("iD") Long iD);

	@Query("SELECT boh from BenObstetricCancerHistory boh WHERE boh.beneficiaryRegID = :benRegID AND boh.benVisitID = :benVisitID")
	public BenObstetricCancerHistory getBenObstetricCancerHistory(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Query("SELECT boh from BenObstetricCancerHistory boh WHERE boh.beneficiaryRegID = :benRegID AND boh.benVisitID = :benVisitID "
			+ "AND DATE(boh.createdDate) = :createdDate")
	public BenObstetricCancerHistory getBenObstetricCancerHistory(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID,  @Param("createdDate") Date createdDate);

}
