package com.iemr.mmu.repo.masterrepo.nurse;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.iemr.mmu.data.masterdata.nurse.FamilyMemberType;

public interface FamilyMemberMasterRepo extends CrudRepository<FamilyMemberType, Long>{

	@Query("select benRelationshipID, benRelationshipType, gender  from FamilyMemberType where deleted = false and benRelationshipID>3 order by benRelationshipType ")
	public ArrayList<Object[]> getFamilyMemberTypeMaster();
	
}
