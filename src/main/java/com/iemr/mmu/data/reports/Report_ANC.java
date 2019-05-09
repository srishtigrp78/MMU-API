package com.iemr.mmu.data.reports;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.google.gson.annotations.Expose;

public class Report_ANC {

	private BigInteger ID;

	private BigInteger BeneficiaryRegID;

	private Integer ProviderServiceMapID;

	private BigInteger VisitCode;
	@Expose
	private Timestamp VisitDate;
	@Expose
	private String District;
	@Expose
	private String SubDistrict;
	@Expose
	private String Village;
	@Expose
	private String ServicePoint;
	@Expose
	private String VehicalNo;
	@Expose
	private String VanName;
	@Expose
	private String BeneficiaryID;
	@Expose
	private String Name;
	@Expose
	private String Gender;
	@Expose
	private String DOB;
	@Expose
	private BigInteger Age;
	@Expose
	private String PreferredPhoneNum;
	@Expose
	private Short VisitNo;
	@Expose
	private String VisitOrRevisit;
	@Expose
	private Boolean IshighRisk;

	private Integer VanID;

	private Integer ParkingPlaceID;
	@Expose
	private String referredToInstituteName;

	private String ServiceName;

	private Timestamp CreatedDate;

	public Report_ANC() {

	}

	public Report_ANC(BigInteger iD, BigInteger beneficiaryRegID, Integer providerServiceMapID, BigInteger visitCode,
			Timestamp visitDate, Short visitNo, String permDistrict, String permSubDistrict, String permVillage,
			String permServicePoint, BigInteger beneficiaryID, String name, String gender, Timestamp dOB,
			BigInteger age, String preferredPhoneNum, Boolean ishighRisk, Integer vanID, String vanName,
			String vehicalNo, Integer parkingPlaceID, String referredToInstituteName, String serviceName,
			Timestamp createdDate, String visit_revisit) {
		super();
		this.ID = iD;
		this.BeneficiaryRegID = beneficiaryRegID;
		this.ProviderServiceMapID = providerServiceMapID;
		this.VisitCode = visitCode;
		this.VisitDate = visitDate;
		this.VisitNo = visitNo;
		this.District = permDistrict;
		this.SubDistrict = permSubDistrict;
		this.Village = permVillage;
		this.ServicePoint = permServicePoint;
		if (beneficiaryID != null)
			this.BeneficiaryID = beneficiaryID.toString();
		// this.BeneficiaryID = beneficiaryID;
		this.Name = name;
		this.Gender = gender;
		if (dOB != null)
			this.DOB = dOB.toString();
		this.Age = age;
		this.PreferredPhoneNum = preferredPhoneNum;
		this.IshighRisk = ishighRisk;
		this.VanID = vanID;
		this.VanName = vanName;
		this.VehicalNo = vehicalNo;
		this.ParkingPlaceID = parkingPlaceID;
		this.referredToInstituteName = referredToInstituteName;
		this.ServiceName = serviceName;
		this.CreatedDate = createdDate;
		this.VisitOrRevisit = visit_revisit;
	}

	public static ArrayList<Report_ANC> getReport_ANC(ArrayList<Object[]> objArr) {
		Report_ANC obj;
		String visit_revisit;
		Short visit_No;
		ArrayList<Report_ANC> ANCList = new ArrayList<>();
		for (Object[] arr : objArr) {
			visit_No = (Short) arr[5];
			if (visit_No != null && visit_No > 1)
				visit_revisit = "Revisit";
			else
				visit_revisit = "Visit";

			obj = new Report_ANC((BigInteger) arr[0], (BigInteger) arr[1], (Integer) arr[2], (BigInteger) arr[3],
					(Timestamp) arr[4], (Short) arr[5], (String) arr[6], (String) arr[7], (String) arr[8],
					(String) arr[9], (BigInteger) arr[10], (String) arr[11], (String) arr[12], (Timestamp) arr[13],
					(BigInteger) arr[14], (String) arr[15], (Boolean) arr[16], (Integer) arr[17], (String) arr[18],
					(String) arr[19], (Integer) arr[20], (String) arr[21], (String) arr[22], (Timestamp) arr[23],
					visit_revisit);

			ANCList.add(obj);
		}

		return ANCList;
	}

}
