package com.iemr.mmu.repo.registrar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.registrar.V_BenAdvanceSearch;

@Repository
public interface ReistrarRepoBenSearch extends CrudRepository<V_BenAdvanceSearch, Long> {
	@Query("SELECT beneficiaryRegID, beneficiaryID, "
			+ " UPPER( concat(IFNULL(firstName, ''), ' ',IFNULL(lastName,''))) as benName, "
			+ " dob, genderID, genderName, UPPER(fatherName) as fatherName, "
			+ " districtID, districtName, districtBranchID, villageName, phoneNo " + " FROM  V_BenAdvanceSearch "
			+ " WHERE beneficiaryID =:benID")

	public ArrayList<Object[]> getAdvanceBenSearchList(@Param("benID") String benID);

	@Query("SELECT DISTINCT beneficiaryRegID, beneficiaryID, "
			+ " UPPER( concat(IFNULL(firstName, ''), ' ',IFNULL(lastName,''))) as benName, "
			+ " Date(dob), genderID, genderName, UPPER(fatherName) as fatherName, "
			+ " districtID, districtName, districtBranchID, villageName, phoneNo " + " FROM  V_BenAdvanceSearch "
			+ " WHERE beneficiaryID=:searchKeyword OR  "
			+ " CONCAT(IFNULL(firstName, ''), ' ', IFNULL(lastName, '')) like '%' ||:searchKeyword || '%' "
			+ " OR phoneNO = :searchKeyword ")

	public List<Object[]> getQuickSearch(@Param("searchKeyword") String searchKeyword);

	@Query("Select DISTINCT beneficiaryRegID, beneficiaryID, "
			+ " UPPER( concat(IFNULL(firstName, ''), ' ',IFNULL(lastName,''))) as benName, "
			+ " Date(dob), genderID, genderName, UPPER(fatherName) as fatherName, "
			+ " districtID, districtName, districtBranchID, villageName, phoneNo "
			+ " from V_BenAdvanceSearch  Where flowStatusFlag = 'R' and Date(regLastModDate) = curdate() ")
	public List<Object[]> getNurseWorkList();
	
}
