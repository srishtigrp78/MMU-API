package com.iemr.mmu.repo.nurse.anc;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iemr.mmu.data.anc.PerinatalHistory;

public interface PerinatalHistoryRepo extends CrudRepository<PerinatalHistory, Long>{

	@Query("select Date(createdDate), placeOfDelivery, otherPlaceOfDelivery, typeOfDelivery, complicationAtBirth, otherComplicationAtBirth, gestation, birthWeight_kg "
			+ "from PerinatalHistory a where a.beneficiaryRegID = :beneficiaryRegID AND (placeOfDelivery is not null OR "
			+ "typeOfDelivery is not null OR complicationAtBirth is not null)"
			+ "AND deleted = false ORDER BY createdDate DESC ")
	public ArrayList<Object[]> getBenPerinatalDetail(@Param("beneficiaryRegID") Long beneficiaryRegID);
	
}
