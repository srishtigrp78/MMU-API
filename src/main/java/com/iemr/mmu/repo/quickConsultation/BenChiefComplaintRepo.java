package com.iemr.mmu.repo.quickConsultation;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;

@Repository
public interface BenChiefComplaintRepo extends CrudRepository<BenChiefComplaint, Long>{
	
	@Query(" SELECT benChiefComplaintID, beneficiaryRegID, benVisitID, providerServiceMapID, chiefComplaintID, chiefComplaint, "
			+ "duration, unitOfDuration, description "
			+ "from BenChiefComplaint ba WHERE ba.beneficiaryRegID = :benRegID AND ba.benVisitID = :benVisitID ")
	public ArrayList<Object[]> getBenChiefComplaints(@Param("benRegID") Long benRegID,
			@Param("benVisitID") Long benVisitID);
	
}
