package com.iemr.mmu.repo.nurse.anc;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mmu.data.anc.BenAdherence;

@Repository
public interface BenAdherenceRepo extends CrudRepository<BenAdherence, Long> {

	@Query(" SELECT ID, beneficiaryRegID, benVisitID, providerServiceMapID, toDrugs, drugReason, toReferral, referralReason, progress "
			+ "from BenAdherence ba WHERE ba.beneficiaryRegID = :benRegID AND ba.benVisitID = :benVisitID ")
	public ArrayList<Object[]> getBenAdherence(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
	@Transactional
	@Modifying
	@Query("update BenAdherence set toDrugs=:toDrugs, drugReason=:drugReason, toReferral=:toReferral, referralReason=:referralReason,"
			+ " progress=:progress, providerServiceMapID=:providerServiceMapID, modifiedBy=:modifiedBy, beneficiaryRegID=:benRegID, "
			+ " benVisitID = :benVisitID where ID=:ID")
	public int updateBenAdherence(@Param("toDrugs") Boolean toDrugs,
			@Param("drugReason") String drugReason,
			@Param("toReferral") Boolean toReferral,
			@Param("referralReason") String referralReason,
			@Param("progress") String progress,
			@Param("modifiedBy") String modifiedBy,
			@Param("providerServiceMapID") Integer providerServiceMapID,
			@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID,
			@Param("ID") Long ID);
	
	
}
