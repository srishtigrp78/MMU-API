package com.iemr.mmu.repo.nurse.pnc;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.pnc.PNCDiagnosis;

@Repository
public interface PNCDiagnosisRepo extends CrudRepository<PNCDiagnosis, Long>{

	@Query(" SELECT beneficiaryRegID, benVisitID, providerServiceMapID, prescriptionID, provisionalDiagnosis, "
			+ "confirmatoryDiagnosis, isMaternalDeath, placeOfDeath, dateOfDeath, causeOfDeath from PNCDiagnosis ba "
			+ "WHERE ba.beneficiaryRegID = :benRegID AND ba.benVisitID = :benVisitID AND ba.deleted = false ")
	public ArrayList<Object[]> getPNCDiagnosisDetails(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
}
