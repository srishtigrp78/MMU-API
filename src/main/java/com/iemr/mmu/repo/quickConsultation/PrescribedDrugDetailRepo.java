package com.iemr.mmu.repo.quickConsultation;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.quickConsultation.PrescribedDrugDetail;

@Repository
public interface PrescribedDrugDetailRepo extends CrudRepository<PrescribedDrugDetail, Long> {

	@Query(" SELECT id, prescriptionID, formName, drugTradeOrBrandName, drugID, drugName, "
			+ " drugStrength, dose, route, frequency, duration, unit, relationToFood, instructions "
			+ " FROM PrescribedDrugDetail  WHERE beneficiaryRegID =:beneficiaryRegID "
			+ " AND visitCode=:visitCode AND deleted = false ")
	public ArrayList<Object[]> getBenPrescribedDrugDetails(@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("visitCode") Long visitCode);
}
