package com.iemr.mmu.repo.nurse;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.nurse.BenCancerVitalDetail;

@Repository
public interface BenCancerVitalDetailRepo extends CrudRepository<BenCancerVitalDetail, Long>{

}
