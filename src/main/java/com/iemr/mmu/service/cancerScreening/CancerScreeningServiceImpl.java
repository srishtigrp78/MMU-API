package com.iemr.mmu.service.cancerScreening;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.service.nurse.NurseServiceImpl;
import com.iemr.utils.mapper.InputMapper;

@Service
public class CancerScreeningServiceImpl implements CancerScreeningService {

	private NurseServiceImpl nurseServiceImpl;

	@Autowired
	public void setNurseServiceImpl(NurseServiceImpl nurseServiceImpl) {
		this.nurseServiceImpl = nurseServiceImpl;
	}

	public void saveCancerScreeningNurseData(JsonObject requestOBJ) {
		System.out.println("hi...");
		if (requestOBJ != null && requestOBJ.has("visitDetails") && !requestOBJ.get("visitDetails").isJsonNull()) {
			BeneficiaryVisitDetail benVisitDetailsOBJ = InputMapper.gson().fromJson(requestOBJ.get("visitDetails"),
					BeneficiaryVisitDetail.class);
			Long benVisitID = nurseServiceImpl.saveBeneficiaryVisitDetails(benVisitDetailsOBJ);
			System.out.println("hi...");
			if (benVisitID != null && benVisitID > 0) {
				if (requestOBJ != null && requestOBJ.has("historyDetails")
						&& !requestOBJ.get("historyDetails").isJsonNull()) {
					JsonObject historyOBJ = requestOBJ.getAsJsonObject("historyDetails");
					System.out.println("hi...");
					if (historyOBJ != null && historyOBJ.has("familyHistory")
							&& !historyOBJ.get("familyHistory").isJsonNull()) {
						System.out.println("hi...");
						JsonObject familyHistoryOBJ = historyOBJ.getAsJsonObject("familyHistory");
						if (familyHistoryOBJ != null && familyHistoryOBJ.has("diseases")
								&& !familyHistoryOBJ.get("diseases").isJsonNull()) {
							System.out.println("hi...");
							BenFamilyCancerHistory[] benFamilyCancerHistoryArray = InputMapper.gson().fromJson(
									familyHistoryOBJ.get("diseases").getAsJsonArray(), BenFamilyCancerHistory[].class);
							System.out.println("hi...");
						} else {
							// familyHistoryOBJ is null or diseases are not
							// there in familyHistoryOBJ or null
						}
					} else {
						// history Obj is null or family history history is null
						// or not there in history obj !!!
					}

				} else {
					// History Object is not there in request object !!!
				}
			} else {
				// Error in visit details data saving....so no visit id created
				// for beneficiary !!!
			}
		}
		System.out.println("hi...");
	}
}
