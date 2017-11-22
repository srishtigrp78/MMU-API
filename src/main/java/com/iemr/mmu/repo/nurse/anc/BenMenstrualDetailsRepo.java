package com.iemr.mmu.repo.nurse.anc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.BenMenstrualDetails;

@Repository
public interface BenMenstrualDetailsRepo extends CrudRepository<BenMenstrualDetails, Integer>{

}
