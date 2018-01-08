package com.iemr.mmu.repo.masterrepo.ncdScreening;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.masterdata.ncdscreening.NCDScreeningCondition;

@Repository
public interface NCDScreeningConditionRepo extends CrudRepository<NCDScreeningCondition, Long>{

}
