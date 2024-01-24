/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.mmu.data.reports;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import jakarta.persistence.Column;

import org.hibernate.annotations.Columns;

import com.google.gson.annotations.Expose;

public class Report_ModifiedAnc {
	@Expose
	private Integer Sno;
	public Integer getSno() {
		return Sno;
	}

	public void setSno(Integer sno) {
		Sno = sno;
	}
	@Expose
	private BigInteger beneficiaryId;
	@Expose
	private BigInteger visitCode;
	public BigInteger getVisitCode() {
		return visitCode;
	}
	@Expose
	private Timestamp registrationDate;
	@Expose
	private Short visitNo;
	@Expose
	private String visitReason;
	@Expose
	private String visitCategory;
	@Expose
	private String createdBy;
	@Expose
	private Timestamp visitDate;
	@Expose
	private Integer vanId;
	@Expose

	private Integer parkingPlaceID;
	@Expose
	private BigInteger ben_age;
	@Expose
	private String ben_gender;
	@Expose
	private String district;
	@Expose
	private String village;
	@Expose
	private String servicePoint;
	@Expose
	private String martialStatus;
    @Expose
	private String occupation;
    @Expose
	
	private String incomeStatus;
    @Expose
	private String community;

	@Expose
	private String religion;
	@Expose
	private BigDecimal weight_Kg;
	@Expose
	private BigDecimal height_cm;
	@Expose
	private BigDecimal bmi;
	@Expose
	private String pregnancyStatus;
	@Expose
	private String rchid;
	@Expose
	private Short bloodGlucose_Random;
	@Expose
	private Short systolicBP_1stReading;
	@Expose
	private Short diastolicBP_1stReading;
	@Expose
	private Short averageSystolicBP;
	@Expose
	private Short averageDiastolicBP;
	@Expose
	private BigDecimal temperature;
	@Expose
	private Short pulseRate;
	@Expose
	private Short respiratoryRate;
	@Expose
	private String clinicalObservation;
	@Expose
	private String otherSymptoms;
	@Expose
	private String DiagnosisProvided;
	@Expose
	private Integer ReferredToInstituteID;
	@Expose
	private String ReferredToInstitute;
	@Expose
	private String tobaccoUseStatus;
	@Expose
	private String alcoholIntakeStatus;
	@Expose
	private String ChiefComplaint;
	@Expose
	private String Urobilinogen;
	@Expose
	private String Bilirubin;
	@Expose
	private String KetoneBodies;
	@Expose
	private String Glucose;
	@Expose
	private String Creatinine;
	@Expose
	private String Albumin;
	@Expose
	private String Calcium;
	@Expose
	private String Protein;
	@Expose
	private String Leukocyte;
	@Expose
	private String RDTforMalaria_Dengue;
	@Expose
	private String RBS;
	@Expose
	private String HB;
	@Expose
	private String Hba1c;
	@Expose
	private String UrineAlbumin;
	@Expose
	private String UrineSugar;
	@Expose
	private String UrinePregnancyTest;
	@Expose
	private String drug_1;
	@Expose
	private Integer drug_prescribed1;
	
	@Expose
	private String drug_2;
	@Expose
	private Integer drug_prescribed2;
	
	@Expose
	private String drug_3;
	@Expose
	private Integer drug_prescribed3;
	
	@Expose
	private String drug_4;
	@Expose
	private Integer drug_prescribed4;
	
	@Expose
	private String drug_5;
	@Expose
	private Integer drug_prescribed5;
	
	@Expose
	private String drug_6;
	@Expose
	private Integer drug_prescribed6;
	
	@Expose
	private String drug_7;
	@Expose
	private Integer drug_prescribed7;
	
	@Expose
	private String drug_8;
	@Expose
	private Integer drug_prescribed8;
	
	@Expose
	private String drug_9;
	@Expose
	private Integer drug_prescribed9;
	
	@Expose
	private String drug_10;
	@Expose
	private Integer drug_prescribed10;
	
	
	
	
	
	
	
	
	
	
	
	public String getDiagnosisProvided() {
		return DiagnosisProvided;
	}

	public void setDiagnosisProvided(String diagnosisProvided) {
		DiagnosisProvided = diagnosisProvided;
	}
	
	private BigInteger benVisitId;
	

	public void setVisitCode(BigInteger visitCode) {
		this.visitCode = visitCode;
	}
	
	
	private BigInteger beneficiaryRegId;
	
	
	private String name;
	
	
	private String subDistrict;

	private Date date;
	
	private Timestamp createdDate;
	
	private String vanName;
	
	private String vehicleNo;
	
	private String visit_revisit;
	
	public String getChiefComplaint() {
		return ChiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		ChiefComplaint = chiefComplaint;
	}
	
	
	private String testComponentName;
	
	private String testResult;
	
	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setTemperature(BigDecimal d) {
		this.temperature = d;
	}
	
	
	
	
	
	
	private String genericDrugName;
	private Integer qtyPrescribed;
	
	
	
	
	

	public BigInteger getBenVisitId() {
		return benVisitId;
	}

	public void setBenVisitId(BigInteger benVisitId) {
		this.benVisitId = benVisitId;
	}

	public Timestamp getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Timestamp visitDate) {
		this.visitDate = visitDate;
	}

	public BigInteger getBeneficiaryRegId() {
		return beneficiaryRegId;
	}

	public void setBeneficiaryRegId(BigInteger beneficiaryRegId) {
		this.beneficiaryRegId = beneficiaryRegId;
	}

	public BigInteger getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(BigInteger beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getSubDistrict() {
		return subDistrict;
	}

	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getServicePoint() {
		return servicePoint;
	}

	public void setServicePoint(String servicePoint) {
		this.servicePoint = servicePoint;
	}

	public String getBen_gender() {
		return ben_gender;
	}

	public void setBen_gender(String ben_gender) {
		this.ben_gender = ben_gender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigInteger getBen_age() {
		return ben_age;
	}

	public void setBen_age(BigInteger ben_age) {
		this.ben_age = ben_age;
	}

	public Timestamp getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}



	public String getVisitReason() {
		return visitReason;
	}

	public void setVisitReason(String visitReason) {
		this.visitReason = visitReason;
	}

	public String getVisitCategory() {
		return visitCategory;
	}

	public void setVisitCategory(String visitCategory) {
		this.visitCategory = visitCategory;
	}

	public Short getVisitNo() {
		return visitNo;
	}

	public void setVisitNo(Short visitNo) {
		this.visitNo = visitNo;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getVanId() {
		return vanId;
	}

	public void setVanId(Integer vanId) {
		this.vanId = vanId;
	}

	public String getVanName() {
		return vanName;
	}

	public void setVanName(String vanName) {
		this.vanName = vanName;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getParkingPlaceID() {
		return parkingPlaceID;
	}

	public void setParkingPlaceID(Integer parkingPlaceID) {
		this.parkingPlaceID = parkingPlaceID;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getIncomeStatus() {
		return incomeStatus;
	}

	public void setIncomeStatus(String incomeStatus) {
		this.incomeStatus = incomeStatus;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}

	public String getPregnancyStatus() {
		return pregnancyStatus;
	}

	public void setPregnancyStatus(String pregnancyStatus) {
		this.pregnancyStatus = pregnancyStatus;
	}

	public String getRchid() {
		return rchid;
	}

	public void setRchid(String rchid) {
		this.rchid = rchid;
	}

	public String getVisit_revisit() {
		return visit_revisit;
	}

	public void setVisit_revisit(String visit_revisit) {
		this.visit_revisit = visit_revisit;
	}

	public String getTestComponentName() {
		return testComponentName;
	}

	public void setTestComponentName(String testComponentName) {
		this.testComponentName = testComponentName;
	}

	public String getTestResult() {
		return testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	public String getGenericDrugName() {
		return genericDrugName;
	}

	public void setGenericDrugName(String genericDrugName) {
		this.genericDrugName = genericDrugName;
	}

	public Integer getQtyPrescribed() {
		return qtyPrescribed;
	}

	public void setQtyPrescribed(Integer qtyPrescribed) {
		this.qtyPrescribed = qtyPrescribed;
	}

	public Short getPulseRate() {
		return pulseRate;
	}

	public void setPulseRate(Short pulseRate) {
		this.pulseRate = pulseRate;
	}

	public Short getRespiratoryRate() {
		return respiratoryRate;
	}

	public void setRespiratoryRate(Short respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

	public Short getSystolicBP_1stReading() {
		return systolicBP_1stReading;
	}

	public void setSystolicBP_1stReading(Short systolicBP_1stReading) {
		this.systolicBP_1stReading = systolicBP_1stReading;
	}

	public Short getDiastolicBP_1stReading() {
		return diastolicBP_1stReading;
	}

	public void setDiastolicBP_1stReading(Short diastolicBP_1stReading) {
		this.diastolicBP_1stReading = diastolicBP_1stReading;
	}

	public Short getAverageSystolicBP() {
		return averageSystolicBP;
	}

	public void setAverageSystolicBP(Short averageSystolicBP) {
		this.averageSystolicBP = averageSystolicBP;
	}

	public Short getAverageDiastolicBP() {
		return averageDiastolicBP;
	}

	public void setAverageDiastolicBP(Short averageDiastolicBP) {
		this.averageDiastolicBP = averageDiastolicBP;
	}

	public Short getBloodGlucose_Random() {
		return bloodGlucose_Random;
	}

	public void setBloodGlucose_Random(Short bloodGlucose_Random) {
		this.bloodGlucose_Random = bloodGlucose_Random;
	}

	public BigDecimal getWeight_Kg() {
		return weight_Kg;
	}

	public void setWeight_Kg(BigDecimal weight_Kg) {
		this.weight_Kg = weight_Kg;
	}

	public BigDecimal getHeight_cm() {
		return height_cm;
	}

	public void setHeight_cm(BigDecimal height_cm) {
		this.height_cm = height_cm;
	}

	public BigDecimal getBmi() {
		return bmi;
	}

	public void setBmi(BigDecimal bmi) {
		this.bmi = bmi;
	}

	public String getClinicalObservation() {
		return clinicalObservation;
	}

	public void setClinicalObservation(String clinicalObservation) {
		this.clinicalObservation = clinicalObservation;
	}

	public String getOtherSymptoms() {
		return otherSymptoms;
	}

	public void setOtherSymptoms(String otherSymptoms) {
		this.otherSymptoms = otherSymptoms;
	}

	public String getTobaccoUseStatus() {
		return tobaccoUseStatus;
	}

	public void setTobaccoUseStatus(String tobaccoUseStatus) {
		this.tobaccoUseStatus = tobaccoUseStatus;
	}

	public String getAlcoholIntakeStatus() {
		return alcoholIntakeStatus;
	}

	public void setAlcoholIntakeStatus(String alcoholIntakeStatus) {
		this.alcoholIntakeStatus = alcoholIntakeStatus;
	}

	public Report_ModifiedAnc() {

	}

	public Report_ModifiedAnc(BigInteger BenVisitID, BigInteger VisitCode,Timestamp VisitDate,BigInteger BeneficiaryRegID,
			BigInteger BeneficiaryID, String Name,String permDistrict, String permSubDistrict, String permVillage,
			String permServicePoint, String Ben_gender, Date DATE,
			BigInteger Ben_Age, Timestamp RegistrationDate,  String VisitReason,
			String VisitCategory, Short VisitNo, Timestamp createdDate, Integer VanID, String VanName, 
			String VehicalNo, String CreatedBy, Integer ParkingPlaceID,String occupation,
			String incomeStatus, String community, String religion, String MartialStatus, String PregnancyStatus,String RCHID,
			 String visit_revisit) {
		super();
		this.benVisitId = BenVisitID;
		this.visitCode = VisitCode;
		this.visitDate = VisitDate;
		this.beneficiaryRegId = BeneficiaryRegID;
		this.name = Name;
		this.district = permDistrict;
		this.subDistrict = permSubDistrict;
		this.village = permVillage;
		this.servicePoint = permServicePoint;
	    this.beneficiaryId = BeneficiaryID;
		this.ben_gender = Ben_gender;
		this.date = DATE;
		this.ben_age= Ben_Age;
		this.registrationDate = RegistrationDate;
		
		this.visitReason = VisitReason;
		this.visitCategory = VisitCategory;
		this.visitNo = VisitNo;
		this.createdDate = createdDate;
		this.vanId = VanID;
		this.vanName = VanName;
		this.vehicleNo = VehicalNo;
		this.createdBy = CreatedBy;
		this.parkingPlaceID = ParkingPlaceID;
		this.occupation = occupation;
		this.incomeStatus = incomeStatus;
		this.community = community;
		this.religion = religion;
		this.martialStatus= MartialStatus;
		this.pregnancyStatus= PregnancyStatus;
		this.rchid = RCHID;
		this.visit_revisit = visit_revisit;
		/*
		 * this.testComponentName= TestComponentName; this.testResult = TestResult;
		 * this.genericDrugName = GenericDrugName; this.qtyPrescribed = QtyPrescribed;
		 * this.temperature = Temperature; this.pulseRate = PulseRate;
		 * this.respiratoryRate = RespiratoryRate; this.systolicBP_1stReading =
		 * SystolicBP_1stReading; this.diastolicBP_1stReading = DiastolicBP_1stReading;
		 * this.averageSystolicBP = AverageSystolicBP; this.averageDiastolicBP =
		 * AverageDiastolicBP; this.bloodGlucose_Random = BloodGlucose_Random;
		 * this.weight_Kg = Weight_Kg; this.height_cm = Height_cm; this.bmi = BMI;
		 * this.clinicalObservation = ClinicalObservation; this.otherSymptoms =
		 * OtherSymptoms; this.tobaccoUseStatus = TobaccoUseStatus;
		 * this.alcoholIntakeStatus = AlcoholIntakeStatus;
		 */
	}
	
	public Report_ModifiedAnc(String TestComponentName,String TestResult)
	{
		super();
		this.testComponentName= TestComponentName;
		this.testResult = TestResult;
	}
	
	public Report_ModifiedAnc(String GenericDrugName,Integer QtyPrescribed,Integer ReferredToInstituteID, String ReferredToInstitute, String DiagnosisProvided)
	{
		super();
		this.genericDrugName = GenericDrugName;
		this.qtyPrescribed = QtyPrescribed;
		this.ReferredToInstituteID = ReferredToInstituteID;
		this.ReferredToInstitute = ReferredToInstitute;
		this.DiagnosisProvided = DiagnosisProvided;
	}
	
	public Report_ModifiedAnc(BigDecimal Temperature,Short PulseRate,Short RespiratoryRate,Short SystolicBP_1stReading,Short DiastolicBP_1stReading,
			Short AverageSystolicBP,Short AverageDiastolicBP,Short BloodGlucose_Random,BigDecimal Weight_Kg,BigDecimal Height_cm,
			BigDecimal BMI,String ClinicalObservation,String OtherSymptoms,String TobaccoUseStatus,String AlcoholIntakeStatus,
			String ChiefComplaint)
	{
		super();
		this.temperature = Temperature; this.pulseRate = PulseRate;
		this.respiratoryRate = RespiratoryRate; this.systolicBP_1stReading =
	     SystolicBP_1stReading; this.diastolicBP_1stReading = DiastolicBP_1stReading;
		this.averageSystolicBP = AverageSystolicBP; this.averageDiastolicBP =
		 AverageDiastolicBP; this.bloodGlucose_Random = BloodGlucose_Random;
	    this.weight_Kg = Weight_Kg; this.height_cm = Height_cm; this.bmi = BMI;
		this.clinicalObservation = ClinicalObservation; this.otherSymptoms =
		 OtherSymptoms; this.tobaccoUseStatus = TobaccoUseStatus;
		this.alcoholIntakeStatus = AlcoholIntakeStatus;
		this.ChiefComplaint = ChiefComplaint;
	}

	public static  ArrayList<Report_ModifiedAnc> getReport_modifiedAnc(ArrayList<Object[]> objArr) {
		
		Report_ModifiedAnc obj;
		
		ArrayList<Report_ModifiedAnc> ANCList = new ArrayList<>();
		String visit_revisit;
		Short visit_No;
	
		for (Object[] arr : objArr) {
			visit_No = (Short) arr[16];
			if (visit_No != null && visit_No > 1)
				visit_revisit = "Revisit";
			else
				visit_revisit = "Visit";

			obj = new Report_ModifiedAnc((BigInteger) arr[0], (BigInteger) arr[1], (Timestamp) arr[2], (BigInteger) arr[3],
					(BigInteger) arr[4], (String) arr[5], (String) arr[6], (String) arr[7], (String) arr[8],(String) arr[9],
					(String) arr[10], (Date) arr[11],
					(BigInteger) arr[12], (Timestamp) arr[13], (String) arr[14],
				    (String) arr[15], (Short) arr[16], (Timestamp) arr[17], (Integer) arr[18], (String) arr[19],
					(String) arr[20], (String) arr[21], (Integer) arr[22], (String) arr[23], (String) arr[24],
					(String) arr[25],(String) arr[26], (String) arr[27], (String) arr[28], (String) arr[29],
					visit_revisit);
			
			

			ANCList.add(obj);
		}

		return ANCList;
	}
	
	public static ArrayList<Report_ModifiedAnc> getReport_modifiedAnc1(ArrayList<Object[]> objArr){
		
		Report_ModifiedAnc obj1;
		ArrayList<Report_ModifiedAnc> ANCList1 = new ArrayList<>();
		for (Object[] arr : objArr) {
		obj1 =  new Report_ModifiedAnc((String) arr[5], (String) arr[6]);
		
		ANCList1.add(obj1);
		}
		return ANCList1;
		
	}
	
public String getUrobilinogen() {
		return Urobilinogen;
	}

	public void setUrobilinogen(String urobilinogen) {
		Urobilinogen = urobilinogen;
	}

	public String getBilirubin() {
		return Bilirubin;
	}

	public void setBilirubin(String bilirubin) {
		Bilirubin = bilirubin;
	}

	public String getKetoneBodies() {
		return KetoneBodies;
	}

	public void setKetoneBodies(String ketoneBodies) {
		KetoneBodies = ketoneBodies;
	}

	public String getGlucose() {
		return Glucose;
	}

	public void setGlucose(String glucose) {
		Glucose = glucose;
	}

	public String getCreatinine() {
		return Creatinine;
	}

	public void setCreatinine(String creatinine) {
		Creatinine = creatinine;
	}

	public String getAlbumin() {
		return Albumin;
	}

	public void setAlbumin(String albumin) {
		Albumin = albumin;
	}

	public String getCalcium() {
		return Calcium;
	}

	public void setCalcium(String calcium) {
		Calcium = calcium;
	}

	public String getProtein() {
		return Protein;
	}

	public void setProtein(String protein) {
		Protein = protein;
	}

	public String getLeukocyte() {
		return Leukocyte;
	}

	public void setLeukocyte(String leukocyte) {
		Leukocyte = leukocyte;
	}

	public String getRDTforMalaria_Dengue() {
		return RDTforMalaria_Dengue;
	}

	public void setRDTforMalaria_Dengue(String rDTforMalaria_Dengue) {
		RDTforMalaria_Dengue = rDTforMalaria_Dengue;
	}

	public String getRBS() {
		return RBS;
	}

	public void setRBS(String rBS) {
		RBS = rBS;
	}

	public String getHB() {
		return HB;
	}

	public void setHB(String hB) {
		HB = hB;
	}

	public String getHba1c() {
		return Hba1c;
	}

	public void setHba1c(String hba1c) {
		Hba1c = hba1c;
	}

	public String getUrineAlbumin() {
		return UrineAlbumin;
	}

	public void setUrineAlbumin(String urineAlbumin) {
		UrineAlbumin = urineAlbumin;
	}

	public String getUrineSugar() {
		return UrineSugar;
	}

	public void setUrineSugar(String urineSugar) {
		UrineSugar = urineSugar;
	}

	public String getUrinePregnancyTest() {
		return UrinePregnancyTest;
	}

	public void setUrinePregnancyTest(String urinePregnancyTest) {
		UrinePregnancyTest = urinePregnancyTest;
	}

	public String getDrug_1() {
		return drug_1;
	}

	public void setDrug_1(String drug_1) {
		this.drug_1 = drug_1;
	}


	

	public String getDrug_2() {
		return drug_2;
	}

	public void setDrug_2(String drug_2) {
		this.drug_2 = drug_2;
	}

	

	

	public String getDrug_3() {
		return drug_3;
	}

	public void setDrug_3(String drug_3) {
		this.drug_3 = drug_3;
	}

	

	

	public String getDrug_4() {
		return drug_4;
	}

	public void setDrug_4(String drug_4) {
		this.drug_4 = drug_4;
	}

	

	public String getDrug_5() {
		return drug_5;
	}

	public void setDrug_5(String drug_5) {
		this.drug_5 = drug_5;
	}

	

	public String getDrug_6() {
		return drug_6;
	}

	public void setDrug_6(String drug_6) {
		this.drug_6 = drug_6;
	}

	public Integer getReferredToInstituteID() {
		return ReferredToInstituteID;
	}

	public void setReferredToInstituteID(Integer referredToInstituteID) {
		ReferredToInstituteID = referredToInstituteID;
	}

	public String getReferredToInstitute() {
		return ReferredToInstitute;
	}

	public void setReferredToInstitute(String referredToInstitute) {
		ReferredToInstitute = referredToInstitute;
	}

	


	public String getDrug_7() {
		return drug_7;
	}

	public void setDrug_7(String drug_7) {
		this.drug_7 = drug_7;
	}

	

	public String getDrug_8() {
		return drug_8;
	}

	public void setDrug_8(String drug_8) {
		this.drug_8 = drug_8;
	}

	

	public String getDrug_9() {
		return drug_9;
	}

	public void setDrug_9(String drug_9) {
		this.drug_9 = drug_9;
	}




	public String getDrug_10() {
		return drug_10;
	}

	public void setDrug_10(String drug_10) {
		this.drug_10 = drug_10;
	}

	

public Integer getDrug_prescribed1() {
		return drug_prescribed1;
	}

	public void setDrug_prescribed1(Integer drug_prescribed1) {
		this.drug_prescribed1 = drug_prescribed1;
	}

	public Integer getDrug_prescribed2() {
		return drug_prescribed2;
	}

	public void setDrug_prescribed2(Integer drug_prescribed2) {
		this.drug_prescribed2 = drug_prescribed2;
	}

	public Integer getDrug_prescribed3() {
		return drug_prescribed3;
	}

	public void setDrug_prescribed3(Integer drug_prescribed3) {
		this.drug_prescribed3 = drug_prescribed3;
	}

	public Integer getDrug_prescribed4() {
		return drug_prescribed4;
	}

	public void setDrug_prescribed4(Integer drug_prescribed4) {
		this.drug_prescribed4 = drug_prescribed4;
	}

	public Integer getDrug_prescribed5() {
		return drug_prescribed5;
	}

	public void setDrug_prescribed5(Integer drug_prescribed5) {
		this.drug_prescribed5 = drug_prescribed5;
	}

	public Integer getDrug_prescribed6() {
		return drug_prescribed6;
	}

	public void setDrug_prescribed6(Integer drug_prescribed6) {
		this.drug_prescribed6 = drug_prescribed6;
	}

	public Integer getDrug_prescribed7() {
		return drug_prescribed7;
	}

	public void setDrug_prescribed7(Integer drug_prescribed7) {
		this.drug_prescribed7 = drug_prescribed7;
	}

	public Integer getDrug_prescribed8() {
		return drug_prescribed8;
	}

	public void setDrug_prescribed8(Integer drug_prescribed8) {
		this.drug_prescribed8 = drug_prescribed8;
	}

	public Integer getDrug_prescribed9() {
		return drug_prescribed9;
	}

	public void setDrug_prescribed9(Integer drug_prescribed9) {
		this.drug_prescribed9 = drug_prescribed9;
	}

	public Integer getDrug_prescribed10() {
		return drug_prescribed10;
	}

	public void setDrug_prescribed10(Integer drug_prescribed10) {
		this.drug_prescribed10 = drug_prescribed10;
	}

public static ArrayList<Report_ModifiedAnc> getReport_modifiedAnc2(ArrayList<Object[]> objArr){
		
		Report_ModifiedAnc obj2;
		ArrayList<Report_ModifiedAnc> ANCList2 = new ArrayList<>();
		for (Object[] arr : objArr) {
		obj2 =  new Report_ModifiedAnc((String) arr[4], (Integer) arr[6], (Integer) arr[10], (String) arr[11],(String) arr[9]);
		
		ANCList2.add(obj2);
		}
		return ANCList2;
		
	}
public static ArrayList<Report_ModifiedAnc> getReport_modifiedAnc3(ArrayList<Object[]> objArr){
	
	Report_ModifiedAnc obj3;
	ArrayList<Report_ModifiedAnc> ANCList3 = new ArrayList<>();
	for (Object[] arr : objArr) {
		
		
	obj3 =  new Report_ModifiedAnc((BigDecimal) arr[4],(Short) arr[5],
			(Short) arr[6], (Short) arr[7], (Short) arr[8],(Short) arr[9], (Short) arr[10], (Short) arr[14],
			(BigDecimal) arr[17], (BigDecimal) arr[18], (BigDecimal) arr[19],(String) arr[20], (String) arr[21],(String) arr[22],
			(String) arr[23],(String) arr[24]);
	
	ANCList3.add(obj3);
	}
	return ANCList3;
	
}


}
