package com.iemr.mmu.repo.doctor;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iemr.mmu.data.doctor.BenReferDetails;

public interface BenReferDetailsRepo extends CrudRepository<BenReferDetails, Long>{

	@Query(" SELECT benReferID, beneficiaryRegID, benVisitID, providerServiceMapID, referredToInstituteID, "
			+ "referredToInstituteName, serviceID, serviceName "
			+ "from BenReferDetails ba WHERE ba.beneficiaryRegID = :benRegID AND ba.benVisitID = :benVisitID AND ba.deleted = false")
	public ArrayList<Object[]> getBenReferDetails(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
/*	@Query("SELECT processed from BenReferDetails where beneficiaryRegID=:benRegID AND benVisitID = :benVisitID")
	public String getBenReferDetailsStatus(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);*/
	
	@Query("SELECT benReferID, processed from BenReferDetails where beneficiaryRegID=:benRegID AND benVisitID = :benVisitID AND deleted=false")
	public ArrayList<Object[]> getBenReferDetailsStatus(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Modifying
	@Transactional
	@Query(" Update BenReferDetails  set deleted=true, processed=:processed WHERE benReferID = :benReferID")
	public int deleteExistingBenReferDetails(@Param("benReferID") Long benReferID, @Param("processed") String processed);
}
