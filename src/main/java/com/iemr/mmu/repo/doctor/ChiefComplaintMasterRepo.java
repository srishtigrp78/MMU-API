package com.iemr.mmu.repo.doctor;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.doctor.ChiefComplaintMaster;

@Repository
public interface ChiefComplaintMasterRepo extends CrudRepository<ChiefComplaintMaster, Integer> {
	@Query("SELECT c FROM ChiefComplaintMaster c where c.deleted != 1 ")
	public ArrayList<ChiefComplaintMaster> getChiefComplaintMaster();
}
