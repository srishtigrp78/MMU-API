package com.iemr.mmu.repo.masterrepo.anc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.masterdata.anc.PregComplicationTypes;

@Repository
public interface PregComplicationTypesRepo extends CrudRepository<PregComplicationTypes, Integer>{

}
