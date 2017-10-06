package com.iemr.mmu.repo.nurse;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;

@Repository
public interface BenVisitDetailRepo extends CrudRepository<BeneficiaryVisitDetail, Long>{

}
