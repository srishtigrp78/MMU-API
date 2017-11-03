package com.iemr.mmu.repo.nurse;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.nurse.BenPhysicalVitalDetail;

@Repository
public interface BenPhysicalVitalRepo extends CrudRepository<BenPhysicalVitalDetail, Long>{

}
