package com.iemr.mmu.repo.registrar;

import org.springframework.data.repository.CrudRepository;

import com.iemr.mmu.data.registrar.BeneficiaryDemographicData;

public interface RegistrarRepoBenDemoData extends CrudRepository<BeneficiaryDemographicData, Long> {

}
