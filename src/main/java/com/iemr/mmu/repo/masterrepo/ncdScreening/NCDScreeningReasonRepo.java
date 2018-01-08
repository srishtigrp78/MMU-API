package com.iemr.mmu.repo.masterrepo.ncdScreening;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.masterdata.ncdscreening.NCDScreeningReason;

@Repository
public interface NCDScreeningReasonRepo extends CrudRepository<NCDScreeningReason, Long>{

}
