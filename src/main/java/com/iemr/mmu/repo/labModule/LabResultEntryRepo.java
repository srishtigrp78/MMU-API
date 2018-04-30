package com.iemr.mmu.repo.labModule;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.labModule.LabResultEntry;

@Repository
public interface LabResultEntryRepo extends CrudRepository<LabResultEntry, Long>{

}
