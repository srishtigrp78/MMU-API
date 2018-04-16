package com.iemr.mmu.repo.nurse.anc;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.ANCDiagnosis;

@Repository
public interface ANCDiagnosisRepo extends CrudRepository<ANCDiagnosis, Long>{

	@Query(" SELECT ID, beneficiaryRegID, benVisitID, providerServiceMapID, highRiskStatus, highRiskCondition, complicationOfCurrentPregnancy, "
			+ "isMaternalDeath, placeOfDeath, dateOfDeath, causeOfDeath from ANCDiagnosis ba "
			+ "WHERE ba.beneficiaryRegID = :benRegID AND ba.benVisitID = :benVisitID ")
	public ArrayList<Object[]> getANCDiagnosisDetails(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
}
