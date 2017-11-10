package com.iemr.mmu.repo.masterrepo.anc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.masterdata.anc.ChildVaccinations;

@Repository
public interface ChildVaccinationsRepo extends CrudRepository<ChildVaccinations, Short>{

}
