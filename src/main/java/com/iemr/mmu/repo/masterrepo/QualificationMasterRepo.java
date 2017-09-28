package com.iemr.mmu.repo.masterrepo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.masterdata.QualificationMaster;

@Repository
public interface QualificationMasterRepo extends CrudRepository<QualificationMaster, Short> {
	@Query("select educationID, educationType from QualificationMaster where  deleted = false order by educationType ")
	public ArrayList<Object[]> getQualificationMaster();
}
