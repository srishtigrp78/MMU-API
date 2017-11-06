package com.iemr.mmu.repo.emergencyCasesheet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.emergencyCasesheet.PrescribedDrugDetail;

@Repository
public interface PrescribedDrugDetailRepo extends CrudRepository<PrescribedDrugDetail, Long>{

}
