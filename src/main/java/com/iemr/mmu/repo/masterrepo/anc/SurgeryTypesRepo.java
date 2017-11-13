package com.iemr.mmu.repo.masterrepo.anc;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.masterdata.anc.SurgeryTypes;

@Repository
public interface SurgeryTypesRepo extends CrudRepository<SurgeryTypes, Integer>{
	
	@Query("select surgeryID, surgeryType from SurgeryTypes where deleted = false order by surgeryType")
	public ArrayList<Object[]> getSurgeryTypes();
}
