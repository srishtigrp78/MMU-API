package com.iemr.mmu.repo.nurse;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.nurse.BenCancerVitalDetail;

@Repository
public interface BenCancerVitalDetailRepo extends CrudRepository<BenCancerVitalDetail, Long> {

	@Transactional
	@Modifying
	@Query("update BenCancerVitalDetail set weight_Kg=:weight_Kg, height_cm=:height_cm, waistCircumference_cm=:waistCircumference_cm, bloodGlucose_Fasting=:bloodGlucose_Fasting,"
			+ " bloodGlucose_Random=:bloodGlucose_Random, bloodGlucose_2HrPostPrandial=:bloodGlucose_2HrPostPrandial, systolicBP_1stReading=:systolicBP_1stReading, "
			+ "diastolicBP_1stReading=:diastolicBP_1stReading, systolicBP_2ndReading=:systolicBP_2ndReading, diastolicBP_2ndReading=:diastolicBP_2ndReading,"
			+ " systolicBP_3rdReading=:systolicBP_3rdReading, diastolicBP_3rdReading=:diastolicBP_3rdReading, hbA1C=:hbA1C, hemoglobin=:hemoglobin, "
			+ " modifiedBy=:modifiedBy where iD=:iD")
	public int updateBenCancerVitalDetail(@Param("weight_Kg") Double weight_Kg,
			@Param("height_cm") Double height_cm,
			@Param("waistCircumference_cm") Double waistCircumference_cm,
			@Param("bloodGlucose_Fasting") Short bloodGlucose_Fasting,
			@Param("bloodGlucose_Random") Short bloodGlucose_Random,
			@Param("bloodGlucose_2HrPostPrandial") Short bloodGlucose_2HrPostPrandial,
			@Param("systolicBP_1stReading") Short systolicBP_1stReading,
			@Param("diastolicBP_1stReading") Short diastolicBP_1stReading,
			@Param("systolicBP_2ndReading") Short systolicBP_2ndReading,
			@Param("diastolicBP_2ndReading") Short diastolicBP_2ndReading,
			@Param("systolicBP_3rdReading") Short systolicBP_3rdReading,
			@Param("diastolicBP_3rdReading") Short diastolicBP_3rdReading,
			@Param("hbA1C") Short hbA1C,
			@Param("hemoglobin") Short hemoglobin,
			@Param("modifiedBy") String modifiedBy,
			@Param("iD") Long iD);

	@Query(" SELECT bvd from BenCancerVitalDetail bvd WHERE bvd.beneficiaryRegID = :benRegID AND bvd.benVisitID = :benVisitID ")
	public BenCancerVitalDetail getBenCancerVitalDetail(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
}
