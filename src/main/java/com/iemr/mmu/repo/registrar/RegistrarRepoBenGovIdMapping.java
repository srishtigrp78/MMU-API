package com.iemr.mmu.repo.registrar;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.registrar.BenGovIdMapping;

@Repository
public interface RegistrarRepoBenGovIdMapping extends CrudRepository<BenGovIdMapping, Long> {

}
