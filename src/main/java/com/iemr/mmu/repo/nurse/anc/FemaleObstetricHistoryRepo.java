package com.iemr.mmu.repo.nurse.anc;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.anc.FemaleObstetricHistory;

@Repository
public interface FemaleObstetricHistoryRepo extends CrudRepository<FemaleObstetricHistory, Long>{

	@Query("select pregOrder, pregComplicationID, pregComplicationType, otherPregComplication, pregDurationID, "
			+ "durationType, deliveryTypeID, deliveryType, deliveryPlaceID, deliveryPlace, otherDeliveryPlace, deliveryComplicationID, "
			+ "deliveryComplicationType, otherDeliveryComplication, pregOutcomeID, pregOutcome, postpartumComplicationID, "
			+ " postpartumComplicationType, otherPostpartumCompType, postNatalComplicationID, postNatalComplication, otherPostNatalComplication,"
			+ " congenitalAnomalies, newBornComplicationID, newBornComplication, otherNewBornComplication from "
			+ "FemaleObstetricHistory a where a.beneficiaryRegID = :beneficiaryRegID")
	public ArrayList<Object[]> getBenFemaleObstetricHistoryDetail(@Param("beneficiaryRegID") Long beneficiaryRegID);
	
	@Query("select beneficiaryRegID, benVisitID, providerServiceMapID, pregOrder, totalNoOfPreg, pregComplicationID, pregComplicationType, otherPregComplication, pregDurationID, "
			+ "durationType, deliveryTypeID, deliveryType, deliveryPlaceID, deliveryPlace, otherDeliveryPlace, deliveryComplicationID, "
			+ "deliveryComplicationType, otherDeliveryComplication, pregOutcomeID, pregOutcome, postpartumComplicationID, "
			+ " postpartumComplicationType, otherPostpartumCompType, postNatalComplicationID, postNatalComplication, otherPostNatalComplication,"
			+ " congenitalAnomalies, newBornComplicationID, newBornComplication, otherNewBornComplication from "
			+ "FemaleObstetricHistory a where a.beneficiaryRegID = :beneficiaryRegID and a.benVisitID = :benVisitID")
	public ArrayList<Object[]> getBenFemaleObstetricHistoryDetail(@Param("beneficiaryRegID") Long beneficiaryRegID, @Param("benVisitID") Long benVisitID);
}
