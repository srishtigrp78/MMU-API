package com.iemr.mmu.data.anc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import com.iemr.mmu.service.anc.Utility;

public class WrapperComorbidCondDetails {

	private Long beneficiaryRegID;
	private Long benVisitID;
	private Integer providerServiceMapID;
	private String createdBy;

	private ArrayList<BencomrbidityCondDetails> comorbidityConcurrentConditionsList;

	public ArrayList<BencomrbidityCondDetails> getComorbidityConcurrentConditionsList() {
		return comorbidityConcurrentConditionsList;
	}

	public void setComorbidityConcurrentConditionsList(
			ArrayList<BencomrbidityCondDetails> comorbidityConcurrentConditionsList) {
		this.comorbidityConcurrentConditionsList = comorbidityConcurrentConditionsList;
	}

	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public Long getBenVisitID() {
		return benVisitID;
	}

	public void setBenVisitID(Long benVisitID) {
		this.benVisitID = benVisitID;
	}

	public ArrayList<BencomrbidityCondDetails> getComrbidityConds() {
		ArrayList<BencomrbidityCondDetails> comorbidityConcurrentConditionsListTMP = new ArrayList<>();
		for (BencomrbidityCondDetails comrbidityCond : comorbidityConcurrentConditionsList) {
			if (comrbidityCond.getComorbidCondition() != null) {
				String timePeriodUnit = comrbidityCond.getTimePeriodUnit();
				Integer timePeriodAgo = comrbidityCond.getTimePeriodAgo();

				comrbidityCond.setBeneficiaryRegID(beneficiaryRegID);
				comrbidityCond.setBenVisitID(benVisitID);
				comrbidityCond.setProviderServiceMapID(providerServiceMapID);
				comrbidityCond.setCreatedBy(createdBy);
				comrbidityCond.setYear(Utility.convertToDateFormat(timePeriodUnit, timePeriodAgo));

				comorbidityConcurrentConditionsListTMP.add(comrbidityCond);
			}
		}

		return comorbidityConcurrentConditionsListTMP;
	}

	public static WrapperComorbidCondDetails getComorbidityDetails(ArrayList<Object[]> comrbidityCondDetails) {
		WrapperComorbidCondDetails WCD = new WrapperComorbidCondDetails();
		WCD.comorbidityConcurrentConditionsList = new ArrayList<BencomrbidityCondDetails>();

		if (null != comrbidityCondDetails && comrbidityCondDetails.size() > 0) {
			Object[] obj1 = comrbidityCondDetails.get(0);
			WCD.beneficiaryRegID = (Long) obj1[0];
			WCD.benVisitID = (Long) obj1[1];
			WCD.providerServiceMapID = (Integer) obj1[2];

			for (Object[] obj : comrbidityCondDetails) {

				Map<String, Object> timePeriod = Utility.convertTimeToWords((Timestamp) obj[5], (Timestamp) obj[8]);

				Integer timePeriodAgo = Integer.parseInt(timePeriod.get("timePeriodAgo").toString());
				BencomrbidityCondDetails comrbidityConds = new BencomrbidityCondDetails((Short) obj[3], (String) obj[4],
						(String) obj[6], (Boolean) obj[7], timePeriodAgo, timePeriod.get("timePeriodUnit").toString());

				WCD.comorbidityConcurrentConditionsList.add(comrbidityConds);

			}
		}
		return WCD;
	}

}
