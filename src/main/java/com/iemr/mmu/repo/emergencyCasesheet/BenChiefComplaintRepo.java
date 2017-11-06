package com.iemr.mmu.repo.emergencyCasesheet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.emergencyCasesheet.BenChiefComplaint;

@Repository
public interface BenChiefComplaintRepo extends CrudRepository<BenChiefComplaint, Long>{

}
