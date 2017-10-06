package com.iemr.mmu.repo.nurse;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;

@Repository
public interface BenFamilyCancerHistoryRepo extends CrudRepository<BenFamilyCancerHistory, Long> {

}
