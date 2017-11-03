package com.iemr.mmu.repo.doctor;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.doctor.DocWorkList;

@Repository
public interface DocWorkListRepo extends CrudRepository<DocWorkList, Long> {
	@Query("SELECT DISTINCT beneficiaryRegID, beneficiaryID, "
			+ " UPPER( concat(IFNULL(firstName, ''), ' ',IFNULL(lastName,''))) as benName, "
			+ " Date(dob), genderID, genderName, benVisitID, visitNo, visitFlowStatusFlag, visitCategory from DocWorkList  "
			+ " where visitFlowStatusFlag in( 'N', 'D') and Date(visitCreatedDate) = curdate() ")
	public List<Object[]> getDocWorkList();
}
