package com.iemr.mmu.repo.emergencyCasesheet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.emergencyCasesheet.LabTestOrderDetail;

@Repository
public interface LabTestOrderDetailRepo extends CrudRepository<LabTestOrderDetail, Long>{

}
