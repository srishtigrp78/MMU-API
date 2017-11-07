package com.iemr.mmu.repo.nurse;

import java.util.ArrayList;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.iemr.mmu.data.nurse.BenAnthropometryDetail;

@Repository
public interface BenAnthropometryRepo extends CrudRepository<BenAnthropometryDetail, Long>{

	@Query("select a from BenAnthropometryDetail a where a.beneficiaryRegID = :beneficiaryRegID and  a.benVisitID = :benVisitID")
	public BenAnthropometryDetail getBenAnthropometryDetail(@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("benVisitID") Long benVisitID);
}
