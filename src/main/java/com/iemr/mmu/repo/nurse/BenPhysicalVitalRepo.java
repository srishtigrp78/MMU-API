package com.iemr.mmu.repo.nurse;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;

@Repository
public interface BenPhysicalVitalRepo extends CrudRepository<BenPhysicalVitalDetail, Long>{
	
	@Query("select v from BenPhysicalVitalDetail v where v.beneficiaryRegID = :beneficiaryRegID and  v.benVisitID = :benVisitID")
	public BenPhysicalVitalDetail getBenPhysicalVitalDetail(@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("benVisitID") Long benVisitID);
	
		
	@Transactional
	@Modifying
	@Query("update BenPhysicalVitalDetail set temperature=:temperature, pulseRate=:pulseRate, respiratoryRate=:respiratoryRate, diastolicBP_1stReading=:diastolicBP_1stReading,"
			+ " systolicBP_1stReading=:systolicBP_1stReading, averageSystolicBP=:averageSystolicBP, averageDiastolicBP=:averageDiastolicBP, capillaryRefillTime=:capillaryRefillTime, "
			+ " modifiedBy=:modifiedBy where beneficiaryRegID=:beneficiaryRegID AND benVisitID=:benVisitID")
	public int updateANCCareDetails(
			@Param("temperature") Double temperature,
			@Param("pulseRate") Short pulseRate,
			@Param("respiratoryRate") Short respiratoryRate,
			@Param("systolicBP_1stReading") Short systolicBP_1stReading,
			@Param("diastolicBP_1stReading") Short diastolicBP_1stReading,
			@Param("averageSystolicBP") Short averageSystolicBP,
			@Param("averageDiastolicBP") Short averageDiastolicBP,
			@Param("capillaryRefillTime") String capillaryRefillTime,
			@Param("modifiedBy") String modifiedBy,
			@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("benVisitID") Long benVisitID );

}
