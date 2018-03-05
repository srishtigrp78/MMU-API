package com.iemr.mmu.repo.benFlowStatus;

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

}
