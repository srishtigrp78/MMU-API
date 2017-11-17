package com.iemr.mmu.repo.nurse.anc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.ANCCareDetails;

@Repository
public interface ANCCareRepo extends CrudRepository<ANCCareDetails, Long>{

}
