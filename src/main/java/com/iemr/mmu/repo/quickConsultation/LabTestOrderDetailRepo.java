package com.iemr.mmu.repo.quickConsultation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;

@Repository
public interface LabTestOrderDetailRepo extends CrudRepository<LabTestOrderDetail, Long>{

}
