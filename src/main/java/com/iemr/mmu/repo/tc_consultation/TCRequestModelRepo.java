package com.iemr.mmu.repo.tc_consultation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.tele_consultation.TCRequestModel;

@Repository
public interface TCRequestModelRepo extends CrudRepository<TCRequestModel, Long> {

}
