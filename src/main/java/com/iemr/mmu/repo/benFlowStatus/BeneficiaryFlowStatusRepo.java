package com.iemr.mmu.repo.benFlowStatus;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;

/***
 * 
 * @author NE298657
 *
 */
@Repository
public interface BeneficiaryFlowStatusRepo extends CrudRepository<BeneficiaryFlowStatus, Long> {
	@Query("SELECT  t from BeneficiaryFlowStatus t WHERE t.nurseFlag = 1 AND t.deleted = false AND Date(t.visitDate)  = curdate()")
	public ArrayList<BeneficiaryFlowStatus> getNurseWorklistNew();
}
