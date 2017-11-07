package com.iemr.mmu.data.quickConsultation;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_lab_othertest")
public class ExternalLabTestOrder {

	@Id
	@GeneratedValue
	@Expose
	@Column(name = "ID")
	private Long externalTestOrderID;
	
	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;
	
	@Expose
	@Column(name = "BenVisitID")
	private Long benVisitID;
	
	@Expose
	@Column(name = "TestName")
	private String testName;
	
	@Expose
	@Column(name = "TestResult")
	private String testResult;
	
	@Expose
	@Column(name = "TestReport")
	private String testReport;
	
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

	public ExternalLabTestOrder() {
		super();
		// TODO Auto-generated constructor stub
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



	public String getTestName() {
		return testName;
	}



	public void setTestName(String testName) {
		this.testName = testName;
	}



	public String getTestResult() {
		return testResult;
	}



	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}



	public String getTestReport() {
		return testReport;
	}



	public void setTestReport(String testReport) {
		this.testReport = testReport;
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



	public Long getExternalTestOrderID() {
		return externalTestOrderID;
	}



	public static ExternalLabTestOrder getExternalLabTestOrderList(JsonObject emrgCasesheet) {
		ExternalLabTestOrder externalLabTestOrder =  new ExternalLabTestOrder();;
		
		for (JsonElement csobj : emrgCasesheet.getAsJsonArray("externalInvestigation")) {
			externalLabTestOrder = new ExternalLabTestOrder();
			
			if (emrgCasesheet.has("benVisitID") && !emrgCasesheet.get("benVisitID").isJsonNull())
				externalLabTestOrder.setBenVisitID(emrgCasesheet.get("benVisitID").getAsLong());
			
			if (emrgCasesheet.has("beneficiaryRegID") && !emrgCasesheet.get("beneficiaryRegID").isJsonNull())
				externalLabTestOrder.setBeneficiaryRegID(emrgCasesheet.get("beneficiaryRegID").getAsLong());
			
			JsonObject obj = csobj.getAsJsonObject();
			
			if (obj.has("externalInvestigation") && !obj.get("externalInvestigation").isJsonNull())
				externalLabTestOrder.setTestName(obj.get("externalInvestigation").getAsString());
			
/*			if (obj.has("testResult") && !obj.get("testResult").isJsonNull())
				externalLabTestOrder.setTestResult(obj.get("testResult").getAsString());
			
			if (obj.has("testReport") && !obj.get("testReport").isJsonNull())
				externalLabTestOrder.setTestReport(obj.get("testReport").getAsString());*/
			
			if (emrgCasesheet.has("createdBy") && !emrgCasesheet.get("createdBy").isJsonNull())
				externalLabTestOrder.setCreatedBy(emrgCasesheet.get("createdBy").getAsString());
			
		}

		return externalLabTestOrder;
	}

}
