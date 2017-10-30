package com.iemr.mmu.repo.registrar;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iemr.mmu.data.registrar.FetchBeneficiaryDetails;

public interface RegistrarRepoBeneficiaryDetails extends CrudRepository<FetchBeneficiaryDetails, Long> {

	@Query(" SELECT d.beneficiaryRegID, d.beneficiaryID, d.firstName, d.lastName, d.gender, "
			+ "d.dob, d.maritalStatus, d.husbandName, d.income, d.educationQualification, d.occupation,  "
			+ " d.blockID, d.blockName, d.stateID, d.stateName,"
			+ " d.community, d.religion, d.fatherName, d.aadharNo, d.districtID, d.districtName, d.villageID,  "
			+ " d.villageName, d.phoneNo, "
			+ " d.govtIdentityTypeID, d.govtIdentityNo, d.isGovtID, d.ageAtMarriage, d.literacyStatus, d.motherName, d.emailID, "
			+ " d.bankName, d.branchName, "
			+ " d.IFSCCode, d.accountNumber, d.benGovMapID from FetchBeneficiaryDetails d where d.beneficiaryRegID=:beneficiaryRegID")
	public List<Object[]> getBeneficiaryDetails(@Param("beneficiaryRegID") Long beneficiaryRegID);
}
