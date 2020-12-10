package com.iemr.mmu.repo.nurse.ncdscreening;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.ncdScreening.IDRSData;
@Repository
public interface IDRSDataRepo extends CrudRepository<IDRSData, Long> {

	@Query("select a from IDRSData a where a.beneficiaryRegID = :beneficiaryRegID and  a.visitCode = :visitCode")
	public IDRSData getBenIdrsDetails(@Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("visitCode") Long visitCode);
}
