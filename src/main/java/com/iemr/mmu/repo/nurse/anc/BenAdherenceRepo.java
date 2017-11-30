package com.iemr.mmu.repo.nurse.anc;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.BenAdherence;

@Repository
public interface BenAdherenceRepo extends CrudRepository<BenAdherence, Long> {

	@Query(" SELECT ID, beneficiaryRegID, benVisitID, providerServiceMapID, toDrugs, drugReason, toReferral, referralReason, progress "
			+ "from BenAdherence ba WHERE ba.beneficiaryRegID = :benRegID AND ba.benVisitID = :benVisitID ")
	public ArrayList<Object[]> getBenAdherence(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
}
