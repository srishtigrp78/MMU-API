package com.iemr.mmu.repo.masterrepo.anc;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iemr.mmu.data.masterdata.anc.PersonalHabitType;

public interface PersonalHabitTypeRepo extends CrudRepository<PersonalHabitType, Long>{
	
	@Query("select personalHabitTypeID, habitType, habitValue from PersonalHabitType where deleted = false and habitType=:habitType "
			+ "order by habitValue ")
	public ArrayList<Object[]> getPersonalHabitTypeMaster(@Param("habitType") String habitType);
	
}
