package com.iemr.mmu.repo.quickConsultation;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.quickConsultation.PrescribedDrugDetail;

@Repository
public interface PrescribedDrugDetailRepo extends CrudRepository<PrescribedDrugDetail, Long>{

	
	@Query(" SELECT prescribedDrugID, prescriptionID, drugForm, drugTradeOrBrandName, drugID, genericDrugName, "
			+ "drugStrength, dose, route, frequency, drugDuration, drugDurationUnit, relationToFood, specialInstruction "
			+ "from PrescribedDrugDetail ba WHERE ba.beneficiaryRegID =:beneficiaryRegID  and ba.benVisitID=:benVisitID"
			+ " and deleted = false")
	public ArrayList<Object[]> getBenPrescribedDrugDetails(@Param("beneficiaryRegID") Long beneficiaryRegID, @Param("benVisitID") Long benVisitID);
}
