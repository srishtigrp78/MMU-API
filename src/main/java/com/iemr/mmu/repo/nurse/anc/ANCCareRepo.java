package com.iemr.mmu.repo.nurse.anc;

import java.sql.Date;
import java.util.ArrayList;

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
	
}
