package com.iemr.mmu.repo.masterrepo.nurse;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.iemr.mmu.data.masterdata.nurse.VisitCategory;

public interface VisitCategoryMasterRepo extends CrudRepository<VisitCategory, Long>{

	@Query("select visitCategoryID, visitCategory from VisitCategory where deleted = false order by visitCategory ")
	public ArrayList<Object[]> getVisitCategoryMaster();
	
}
