package com.iemr.mmu.repo.nurse.anc;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.ANCWomenVaccineDetail;

@Repository
public interface ANCWomenVaccineRepo extends CrudRepository<ANCWomenVaccineDetail, Long>{
	
	@Query(" SELECT ID, beneficiaryRegID, benVisitID, providerServiceMapID, vaccineName, status, receivedDate, receivedFacilityName "
			+ "from ANCWomenVaccineDetail ba WHERE ba.beneficiaryRegID = :benRegID AND ba.benVisitID = :benVisitID ")
	public ArrayList<Object[]> getANCWomenVaccineDetails(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
}
