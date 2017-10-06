package com.iemr.mmu.repo.nurse;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.nurse.BenPersonalCancerDietHistory;

@Repository
public interface BenPersonalCancerDietHistoryRepo extends CrudRepository<BenPersonalCancerDietHistory, Long> {

}
