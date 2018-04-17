package com.iemr.mmu.repo.doctor;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iemr.mmu.data.doctor.BenReferDetails;

public interface BenReferDetailsRepo extends CrudRepository<BenReferDetails, Long>{

	@Query(" SELECT benReferID, beneficiaryRegID, benVisitID, providerServiceMapID, referredToInstituteID, "
			+ "referredToInstituteName, serviceID, serviceName "
			+ "from BenReferDetails ba WHERE ba.beneficiaryRegID = :benRegID AND ba.benVisitID = :benVisitID AND ba.deleted = false")
	public ArrayList<Object[]> getBenReferDetails(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
}
