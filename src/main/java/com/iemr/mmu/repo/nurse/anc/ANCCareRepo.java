package com.iemr.mmu.repo.nurse.anc;

import java.sql.Date;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.ANCCareDetails;

@Repository
public interface ANCCareRepo extends CrudRepository<ANCCareDetails, Long>{

	@Query(" SELECT ID, beneficiaryRegID, benVisitID, providerServiceMapID, visitNo, comolaintType, duration, description, aNCRegistrationDate,"
			+ " aNCVisitNumber, lastMenstrualPeriod_LMP, gestationalAgeOrPeriodofAmenorrhea_POA, trimesterNumber, expectedDateofDelivery, "
			+ "primiGravida, obstetricFormula, gravida_G, termDeliveries_T, pretermDeliveries_P, abortions_A, livebirths_L, bloodGroup "
			+ "from ANCCareDetails ba WHERE ba.beneficiaryRegID = :benRegID AND ba.benVisitID = :benVisitID ")
	public ArrayList<Object[]> getANCCareDetails(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	
	@Transactional
	@Modifying
	@Query("update ANCCareDetails set comolaintType=:comolaintType, duration=:duration, description=:description, aNCRegistrationDate=:aNCRegistrationDate,"
			+ " aNCVisitNumber=:aNCVisitNumber, lastMenstrualPeriod_LMP=:lastMenstrualPeriod_LMP, "
			+ "gestationalAgeOrPeriodofAmenorrhea_POA=:gestationalAgeOrPeriodofAmenorrhea_POA,"
			+ "trimesterNumber=:trimesterNumber,  expectedDateofDelivery=:expectedDateofDelivery, primiGravida=:primiGravida, "
			+ "obstetricFormula=:obstetricFormula, gravida_G=:gravida_G, termDeliveries_T=:termDeliveries_T, pretermDeliveries_P=:pretermDeliveries_P,"
			+ "abortions_A=:abortions_A,livebirths_L=:livebirths_L, bloodGroup=:bloodGroup, modifiedBy=:modifiedBy where ID=:ID AND beneficiaryRegID=:beneficiaryRegID")
	public int updateANCCareDetails(@Param("comolaintType") String comolaintType,
			@Param("duration") String duration,
			@Param("description") String description,
			@Param("aNCRegistrationDate") Date aNCRegistrationDate,
			@Param("aNCVisitNumber") Short aNCVisitNumber,
			@Param("lastMenstrualPeriod_LMP") Date lastMenstrualPeriod_LMP,
			@Param("gestationalAgeOrPeriodofAmenorrhea_POA") Short gestationalAgeOrPeriodofAmenorrhea_POA,
			@Param("trimesterNumber") Short trimesterNumber,
			@Param("expectedDateofDelivery") Date expectedDateofDelivery,
			@Param("primiGravida") Boolean primiGravida,
			@Param("obstetricFormula") String obstetricFormula,
			@Param("gravida_G") Short gravida_G,
			@Param("termDeliveries_T") Short termDeliveries_T,
			@Param("pretermDeliveries_P") Short pretermDeliveries_P,
			@Param("abortions_A") Short abortions_A,
			@Param("livebirths_L") Short livebirths_L,
			@Param("bloodGroup") String bloodGroup,
			@Param("modifiedBy") String modifiedBy,
			@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("ID") Long ID);
}
