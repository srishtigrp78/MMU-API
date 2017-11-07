package com.iemr.mmu.repo.quickConsultation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.quickConsultation.PrescriptionDetail;

@Repository
public interface PrescriptionDetailRepo extends CrudRepository<PrescriptionDetail, Long>{

}
