package com.iemr.mmu.repo.registrar;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.registrar.V_BenAdvanceSearch;

@Repository
public interface ReistrarRepoBenSearch extends CrudRepository<V_BenAdvanceSearch, Long> {
	
	@Query("SELECT DISTINCT(beneficiaryRegID), beneficiaryID, "
			+ " UPPER( concat(IFNULL(firstName, ''), ' ',IFNULL(lastName,''))) as benName, "
			+ " Date(dob), genderID, genderName, UPPER(fatherName) as fatherName, "
			+ " districtID, districtName, districtBranchID, villageName, phoneNo " + " FROM  V_BenAdvanceSearch "
			+ " WHERE (beneficiaryID IS NULL OR beneficiaryID like :beneficiaryID ) AND"
			+ " (firstName like %:firstName% ) AND"
			+ " (Isnull(lastName) LIKE %:lastName%  OR lastName like %:lastName% ) AND"
			+ " (Isnull(phoneNo) LIKE :phoneNo OR phoneNo like :phoneNo ) AND"
			+ " (Isnull(aadharNo) LIKE :aadharNo OR aadharNo like :aadharNo ) AND"
			+ " (Isnull(govtIdentityNo) LIKE :govtIdentityNo OR govtIdentityNo like :govtIdentityNo ) AND"
			+ " (Isnull(cast(stateID as string)) LIKE :stateID OR cast(stateID as string) like :stateID) AND"
			+ " (Isnull(cast(districtID as string)) LIKE :districtID OR cast(districtID as string) like :districtID)")

	public ArrayList<Object[]> getAdvanceBenSearchList(@Param("beneficiaryID") String beneficiaryID,
			@Param("firstName") String firstName,
			@Param("lastName") String lastName,
			@Param("phoneNo") String phoneNo,
			@Param("aadharNo") String aadharNo,
			@Param("govtIdentityNo") String govtIdentityNo,
			@Param("stateID") String stateID,
			@Param("districtID") String districtID);

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
