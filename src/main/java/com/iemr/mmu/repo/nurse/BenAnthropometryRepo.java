package com.iemr.mmu.repo.nurse;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.nurse.BenAnthropometryDetail;

@Repository
public interface BenAnthropometryRepo extends CrudRepository<BenAnthropometryDetail, Long>{

}
