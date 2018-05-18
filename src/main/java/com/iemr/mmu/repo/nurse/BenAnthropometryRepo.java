package com.iemr.mmu.repo.nurse;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.nurse.BenAnthropometryDetail;

@Repository
public interface BenAnthropometryRepo extends CrudRepository<BenAnthropometryDetail, Long> {

	@Query("select a from BenAnthropometryDetail a where a.beneficiaryRegID = :beneficiaryRegID and  a.benVisitID = :benVisitID")
	public BenAnthropometryDetail getBenAnthropometryDetail(@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("benVisitID") Long benVisitID);

	@Query("SELECT processed from BenAnthropometryDetail where beneficiaryRegID=:benRegID AND benVisitID = :benVisitID")
	public String getBenAnthropometryStatus(@Param("benRegID") Long benRegID, @Param("benVisitID") Long benVisitID);

	@Transactional
	@Modifying
	@Query("update BenAnthropometryDetail set weight_Kg=:weight_Kg, height_cm=:height_cm, bMI=:bMI, headCircumference_cm=:headCircumference_cm,"
			+ " midUpperArmCircumference_MUAC_cm=:midUpperArmCircumference_MUAC_cm, hipCircumference_cm=:hipCircumference_cm, "
			+ " waistCircumference_cm=:waistCircumference_cm, waistHipRatio=:waistHipRatio, "
			+ " modifiedBy=:modifiedBy, processed=:processed where beneficiaryRegID=:beneficiaryRegID AND benVisitID=:benVisitID")
	public int updateANCCareDetails(@Param("weight_Kg") Double weight_Kg, @Param("height_cm") Double height_cm,
			@Param("bMI") Double bMI, @Param("headCircumference_cm") Double headCircumference_cm,
			@Param("midUpperArmCircumference_MUAC_cm") Double midUpperArmCircumference_MUAC_cm,
			@Param("hipCircumference_cm") Double hipCircumference_cm,
			@Param("waistCircumference_cm") Double waistCircumference_cm, @Param("waistHipRatio") Double waistHipRatio,
			@Param("modifiedBy") String modifiedBy, @Param("processed") String processed,
			@Param("beneficiaryRegID") Long beneficiaryRegID, @Param("benVisitID") Long benVisitID);

	@Query("select a.weight_Kg, Date(a.createdDate) from BenAnthropometryDetail a "
			+ " where a.benVisitID in :visitIDList ")
	public ArrayList<Object[]> getBenAnthropometryDetailForGraphtrends(
			@Param("visitIDList") ArrayList<Long> visitIDList);

}
