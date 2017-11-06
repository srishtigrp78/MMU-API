package com.iemr.mmu.repo.emergencyCasesheet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.emergencyCasesheet.BenClinicalObservations;

@Repository
public interface BenClinicalObservationsRepo extends CrudRepository<BenClinicalObservations, Long>{

}
