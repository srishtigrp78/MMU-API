package com.iemr.mmu.repo.masterrepo.anc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.masterdata.anc.IllnessTypes;

@Repository
public interface IllnessTypesRepo extends CrudRepository<IllnessTypes, Integer>{

}
