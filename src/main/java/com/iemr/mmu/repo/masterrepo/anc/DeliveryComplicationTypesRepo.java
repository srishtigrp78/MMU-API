package com.iemr.mmu.repo.masterrepo.anc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.masterdata.anc.DeliveryComplicationTypes;

@Repository
public interface DeliveryComplicationTypesRepo extends CrudRepository<DeliveryComplicationTypes, Short>{

}
