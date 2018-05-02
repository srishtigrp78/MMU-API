package com.iemr.mmu.repo.labtechnician;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.labtechnician.V_benLabTestOrderedDetails;

@Repository
public interface V_benLabTestOrderedDetailsRepo extends CrudRepository<V_benLabTestOrderedDetails, Long> {
	ArrayList<V_benLabTestOrderedDetails> findDistinctByBeneficiaryRegIDAndBenVisitIDAndProcedureTypeAndProcedureIDNotInOrderByProcedureIDAscTestComponentIDAscResultValueAsc(
			Long benRegID, Long benVisitID, String procedureType, ArrayList<Integer> ids);
}
