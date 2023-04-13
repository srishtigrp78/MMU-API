package com.iemr.mmu.repo.labtechnician;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.labtechnician.M_ECGabnormalities;

@Repository
public interface M_ECGabnormalitiesRepo extends CrudRepository<M_ECGabnormalities, Integer> {

	List<M_ECGabnormalities> findByDeleted(Boolean deleted);

}
