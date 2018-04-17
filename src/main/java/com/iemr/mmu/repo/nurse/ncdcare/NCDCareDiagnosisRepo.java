package com.iemr.mmu.repo.nurse.ncdcare;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iemr.mmu.data.ncdcare.NCDCareDiagnosis;

public interface NCDCareDiagnosisRepo extends CrudRepository<NCDCareDiagnosis, Long>
{

	@Query(" SELECT beneficiaryRegID, benVisitID, providerServiceMapID, ncdScreeningCondition, ncdComplication, ncdCareType "
			+ "from NCDCareDiagnosis ba "
			+ "WHERE ba.beneficiaryRegID = :benRegID AND ba.benVisitID = :benVisitID and ba.deleted = false")
	public ArrayList<Object[]> getNCDCareDiagnosisDetails(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
}
