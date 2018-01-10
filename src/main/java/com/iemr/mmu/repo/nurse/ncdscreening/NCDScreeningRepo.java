package com.iemr.mmu.repo.nurse.ncdscreening;


import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.ncdScreening.NCDScreening;

@Repository
public interface NCDScreeningRepo extends CrudRepository<NCDScreening, Long>{
	
	
	@Query(" SELECT ba FROM NCDScreening ba WHERE ba.beneficiaryRegID = :benRegID AND ba.benVisitID = :benVisitID ")
	public NCDScreening getNCDScreeningDetails(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Transactional
	@Modifying
	@Query("update NCDScreening set ncdScreeningConditionID=:ncdScreeningConditionID, screeningCondition=:screeningCondition, ncdScreeningReasonID=:ncdScreeningReasonID, reasonForScreening=:reasonForScreening,"
			+ " nextScreeningDate=:nextScreeningDate, actionForScreenPositive=:actionForScreenPositive, "
			+ "isScreeningComplete=:isScreeningComplete,"
			+ "modifiedBy=:modifiedBy where benVisitID=:benVisitID AND beneficiaryRegID=:beneficiaryRegID")
	public int updateNCDScreeningDetails(
			@Param("ncdScreeningConditionID") Integer ncdScreeningConditionID,
			@Param("screeningCondition") String screeningCondition,
			@Param("ncdScreeningReasonID") Integer ncdScreeningReasonID,
			@Param("reasonForScreening") String reasonForScreening,
			@Param("nextScreeningDate")  Date nextScreeningDate,
			@Param("actionForScreenPositive") String actionForScreenPositive,
			@Param("isScreeningComplete") Boolean isScreeningComplete,
			@Param("modifiedBy") String modifiedBy,
			@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("benVisitID") Long benVisitID);

}
