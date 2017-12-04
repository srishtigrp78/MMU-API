package com.iemr.mmu.data.anc;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.mmu.data.quickConsultation.LabTestOrderDetail;

@Entity
@Table(name = "t_anccare")
public class ANCCareDetails {

	@Id
	@GeneratedValue
	@Expose
	@Column(name = "ID")
	private Long ID;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;

	@Expose
	@Column(name = "BenVisitID")
	private Long benVisitID;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;

	@Expose
	@Column(name = "VisitNo")
	private Short visitNo;

	@Expose
	@Column(name = "ComolaintType")
	private String comolaintType;

	@Expose
	@Column(name = "Duration")
	private String duration;

	@Expose
	@Column(name = "Description")
	private String description;

	@Expose
	@Column(name = "ANCRegistrationDate")
	private Date aNCRegistrationDate;

	@Expose
	@Column(name = "ANCVisitNumber")
	private Short aNCVisitNumber;

	@Expose
	@Column(name = "LastMenstrualPeriod_LMP")
	private Date lastMenstrualPeriod_LMP;

	@Expose
	@Column(name = "GestationalAgeOrPeriodofAmenorrhea_POA")
	private Short gestationalAgeOrPeriodofAmenorrhea_POA;

	@Expose
	@Column(name = "TrimesterNumber")
	private Short trimesterNumber;

	@Expose
	@Column(name = "ExpectedDateofDelivery")
	private Date expectedDateofDelivery;

	@Expose
	@Column(name = "PrimiGravida")
	private Boolean primiGravida;

	@Expose
	@Column(name = "ObstetricFormula")
	private String obstetricFormula;

	@Expose
	@Column(name = "Gravida_G")
	private Short gravida_G;

	@Expose
	@Column(name = "TermDeliveries_T")
	private Short termDeliveries_T;

	@Expose
	@Column(name = "PretermDeliveries_P")
	private Short pretermDeliveries_P;

	@Expose
	@Column(name = "Abortions_A")
	private Short abortions_A;

	@Expose
	@Column(name = "Livebirths_L")
	private Short livebirths_L;

	@Expose
	@Column(name = "BloodGroup")
	private String bloodGroup;

	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;

	@Expose
	@Column(name = "Processed", insertable = false, updatable = true)
	private String processed;

	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;

	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	@Transient
	private String lmpDate;

	@Transient
	private String expDelDt;

	public ANCCareDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ANCCareDetails(Long iD, Long beneficiaryRegID, Long benVisitID, Integer providerServiceMapID, Short visitNo,
			String comolaintType, String duration, String description, Date aNCRegistrationDate, Short aNCVisitNumber,
			Date lastMenstrualPeriod_LMP, Short gestationalAgeOrPeriodofAmenorrhea_POA, Short trimesterNumber,
			Date expectedDateofDelivery, Boolean primiGravida, String obstetricFormula, Short gravida_G,
			Short termDeliveries_T, Short pretermDeliveries_P, Short abortions_A, Short livebirths_L, String bloodGroup) {
		super();
		ID = iD;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benVisitID = benVisitID;
		this.providerServiceMapID = providerServiceMapID;
		this.visitNo = visitNo;
		this.comolaintType = comolaintType;
		this.duration = duration;
		this.description = description;
		this.aNCRegistrationDate = aNCRegistrationDate;
		this.aNCVisitNumber = aNCVisitNumber;
		this.lastMenstrualPeriod_LMP = lastMenstrualPeriod_LMP;
		this.gestationalAgeOrPeriodofAmenorrhea_POA = gestationalAgeOrPeriodofAmenorrhea_POA;
		this.trimesterNumber = trimesterNumber;
		this.expectedDateofDelivery = expectedDateofDelivery;
		this.primiGravida = primiGravida;
		this.obstetricFormula = obstetricFormula;
		this.gravida_G = gravida_G;
		this.termDeliveries_T = termDeliveries_T;
		this.pretermDeliveries_P = pretermDeliveries_P;
		this.abortions_A = abortions_A;
		this.livebirths_L = livebirths_L;
		this.bloodGroup = bloodGroup;
	}

	public static ANCCareDetails getANCCareDetails(ArrayList<Object[]> resList) {
		ArrayList<ANCCareDetails> resArray = new ArrayList<ANCCareDetails>();
		ANCCareDetails cOBJ = null;
		for (Object[] obj : resList) {
			cOBJ = new ANCCareDetails((Long)obj[0], (Long)obj[1], (Long)obj[2], (Integer)obj[3], (Short)obj[4], (String)obj[5], 
					(String)obj[6], (String)obj[7], (Date)obj[8], (Short)obj[9], (Date)obj[10], (Short)obj[11], 
					(Short)obj[12], (Date)obj[13], (Boolean)obj[14], (String)obj[15], (Short)obj[16], (Short)obj[17], (Short)obj[18],
					(Short)obj[19], (Short)obj[20], (String)obj[21]);
			
			Date Ldate=(Date)obj[10];
			if(null != Ldate){
				cOBJ.setLmpDate(Ldate.toString());
			}
			
			Date EDate=(Date)obj[13];
			if(null != EDate){
				cOBJ.setExpDelDt(EDate.toString());
			}
		}
		return cOBJ;
	}
	
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
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

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public Short getVisitNo() {
		return visitNo;
	}

	public void setVisitNo(Short visitNo) {
		this.visitNo = visitNo;
	}

	public String getComolaintType() {
		return comolaintType;
	}

	public void setComolaintType(String comolaintType) {
		this.comolaintType = comolaintType;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getaNCRegistrationDate() {
		return aNCRegistrationDate;
	}

	public void setaNCRegistrationDate(Date aNCRegistrationDate) {
		this.aNCRegistrationDate = aNCRegistrationDate;
	}

	public Short getaNCVisitNumber() {
		return aNCVisitNumber;
	}

	public void setaNCVisitNumber(Short aNCVisitNumber) {
		this.aNCVisitNumber = aNCVisitNumber;
	}

	public Date getLastMenstrualPeriod_LMP() {
		return lastMenstrualPeriod_LMP;
	}

	public void setLastMenstrualPeriod_LMP(Date lastMenstrualPeriod_LMP) {
		this.lastMenstrualPeriod_LMP = lastMenstrualPeriod_LMP;
	}

	public Short getGestationalAgeOrPeriodofAmenorrhea_POA() {
		return gestationalAgeOrPeriodofAmenorrhea_POA;
	}

	public void setGestationalAgeOrPeriodofAmenorrhea_POA(Short gestationalAgeOrPeriodofAmenorrhea_POA) {
		this.gestationalAgeOrPeriodofAmenorrhea_POA = gestationalAgeOrPeriodofAmenorrhea_POA;
	}

	public Short getTrimesterNumber() {
		return trimesterNumber;
	}

	public void setTrimesterNumber(Short trimesterNumber) {
		this.trimesterNumber = trimesterNumber;
	}

	public Date getExpectedDateofDelivery() {
		return expectedDateofDelivery;
	}

	public void setExpectedDateofDelivery(Date expectedDateofDelivery) {
		this.expectedDateofDelivery = expectedDateofDelivery;
	}

	public Boolean getPrimiGravida() {
		return primiGravida;
	}

	public void setPrimiGravida(Boolean primiGravida) {
		this.primiGravida = primiGravida;
	}

	public String getObstetricFormula() {
		return obstetricFormula;
	}

	public void setObstetricFormula(String obstetricFormula) {
		this.obstetricFormula = obstetricFormula;
	}

	public Short getGravida_G() {
		return gravida_G;
	}

	public void setGravida_G(Short gravida_G) {
		this.gravida_G = gravida_G;
	}

	public Short getTermDeliveries_T() {
		return termDeliveries_T;
	}

	public void setTermDeliveries_T(Short termDeliveries_T) {
		this.termDeliveries_T = termDeliveries_T;
	}

	public Short getPretermDeliveries_P() {
		return pretermDeliveries_P;
	}

	public void setPretermDeliveries_P(Short pretermDeliveries_P) {
		this.pretermDeliveries_P = pretermDeliveries_P;
	}

	public Short getAbortions_A() {
		return abortions_A;
	}

	public void setAbortions_A(Short abortions_A) {
		this.abortions_A = abortions_A;
	}

	public Short getLivebirths_L() {
		return livebirths_L;
	}

	public void setLivebirths_L(Short livebirths_L) {
		this.livebirths_L = livebirths_L;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getProcessed() {
		return processed;
	}

	public void setProcessed(String processed) {
		this.processed = processed;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}

	public String getLmpDate() {
		return lmpDate;
	}

	public void setLmpDate(String lmpDate) {
		this.lmpDate = lmpDate;
	}

	public String getExpDelDt() {
		return expDelDt;
	}

	public void setExpDelDt(String expDelDt) {
		this.expDelDt = expDelDt;
	}

}
