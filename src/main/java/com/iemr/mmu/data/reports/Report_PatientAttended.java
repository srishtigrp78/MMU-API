package com.iemr.mmu.data.reports;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.google.gson.annotations.Expose;

//@Entity
// @NamedStoredProcedureQueries({
// @NamedStoredProcedureQuery(name = PatientAttended.NamedQuery_PatientAttened,
// procedureName = "db_reporting.SP_PatientAttended", resultClasses =
// PatientAttended.class, parameters = {
// @StoredProcedureParameter(type = Timestamp.class, mode = ParameterMode.IN),
// @StoredProcedureParameter(type = Timestamp.class, mode = ParameterMode.IN),
// @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN),
// @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN) })
// })

public class Report_PatientAttended {
	// public static final String NamedQuery_PatientAttened = "patientAttended";
	@Expose
	private Timestamp VisitDate;
	@Expose
	private String District;
	@Expose
	private String Village;
	@Expose
	private String ServicePoint;
	@Expose
	private String MmuNumber;
	@Expose
	private String BenId;
	@Expose
	private String BenName;
	@Expose
	private String Gender;
	@Expose
	private BigInteger Age;
	@Expose
	private String Visit_or_revisit;
	@Expose
	private Short VisitNo;

	public Report_PatientAttended() {
	}

	public Report_PatientAttended(Timestamp visit_Date, String district, String village, String service_Point,
			String mMU_Number, BigInteger ben_ID, String benName, String gender, BigInteger age, String visit_revisit,
			Short visitNo) {
		super();
		VisitDate = visit_Date;
		District = district;
		Village = village;
		ServicePoint = service_Point;
		MmuNumber = mMU_Number;
		if(ben_ID != null)
		BenId = ben_ID.toString();
		BenName = benName;
		Gender = gender;
		Age = age;
		Visit_or_revisit = visit_revisit;
		VisitNo = visitNo;
	}

	public static ArrayList<Report_PatientAttended> getPatientAttendedReport(ArrayList<Object[]> objArr) {
		Report_PatientAttended paOBJ;
		String visit_revisit;
		Short visit_No;
		ArrayList<Report_PatientAttended> paList = new ArrayList<>();
		for (Object[] arr : objArr) {
			visit_No = (Short) arr[12];
			if (visit_No != null && visit_No > 1)
				visit_revisit = "Revisit";
			else
				visit_revisit = "Visit";
			paOBJ = new Report_PatientAttended((Timestamp) arr[13], (String) arr[3], (String) arr[5], (String) arr[6],
					(String) arr[15], (BigInteger) arr[7], (String) arr[8], (String) arr[9], (BigInteger) arr[11],
					visit_revisit, (Short) arr[12]);

			paList.add(paOBJ);
		}
		return paList;
	}

}
