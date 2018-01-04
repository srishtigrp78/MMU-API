package com.iemr.mmu.repo.nurse.anc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.ChildVaccineDetail1;

@Repository
public interface ChildVaccineDetail1Repo extends CrudRepository<ChildVaccineDetail1, Long>{
	
	@Query("select defaultReceivingAge, vaccineName, status "
			+ "from ChildVaccineDetail1 a where a.beneficiaryRegID = :beneficiaryRegID ORDER BY createdDate DESC ")
	public ArrayList<Object[]> getBenChildVaccineDetails(@Param("beneficiaryRegID") Long beneficiaryRegID);
	
	@Query("select beneficiaryRegID, benVisitID, providerServiceMapID, defaultReceivingAge, vaccineName, status"
			+ " from ChildVaccineDetail1 a where a.beneficiaryRegID = :beneficiaryRegID and a.benVisitID = :benVisitID")
	public ArrayList<Object[]> getBenChildVaccineDetails(@Param("beneficiaryRegID") Long beneficiaryRegID, @Param("benVisitID") Long benVisitID);
	
}
