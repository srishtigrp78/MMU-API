package com.iemr.mmu.repo.nurse.anc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.SysRespiratoryExamination;

@Repository
public interface SysRespiratoryExaminationRepo extends CrudRepository<SysRespiratoryExamination, Long>{

}
