package com.iemr.mmu.repo.doctor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.doctor.LabTestMaster;

@Repository
public interface LabTestMasterRepo extends CrudRepository<LabTestMaster, Integer> {

}
