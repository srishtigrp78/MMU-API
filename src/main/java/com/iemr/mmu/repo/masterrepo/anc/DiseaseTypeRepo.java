package com.iemr.mmu.repo.masterrepo.anc;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.masterdata.anc.DiseaseType;

@Repository
public interface DiseaseTypeRepo extends CrudRepository<DiseaseType, Short>{

	@Query("select diseaseTypeID, diseaseType from DiseaseType where deleted = false order by diseaseType")
	public ArrayList<Object[]> getDiseaseTypes();
}
