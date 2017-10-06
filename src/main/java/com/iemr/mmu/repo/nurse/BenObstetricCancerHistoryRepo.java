package com.iemr.mmu.repo.nurse;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;

@Repository
public interface BenObstetricCancerHistoryRepo extends CrudRepository<BenObstetricCancerHistory, Long> {

}
