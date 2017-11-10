package com.iemr.mmu.repo.masterrepo.anc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.masterdata.anc.JointTypes;

@Repository
public interface JointTypesRepo extends CrudRepository<JointTypes, Short>{

}
