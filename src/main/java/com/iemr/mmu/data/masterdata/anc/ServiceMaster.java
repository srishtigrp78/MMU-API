package com.iemr.mmu.data.masterdata.anc;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_servicemaster")
public class ServiceMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "ServiceID")
	private Short serviceID;
	
	@Expose
	@Column(name = "ServiceName")
	private String serviceName;
	
	@Expose
	@Column(name = "ServiceDesc")
	private String serviceDesc;
	
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	
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

	public ServiceMaster(Short serviceID, String serviceName, String serviceDesc) {
		super();
		this.serviceID = serviceID;
		this.serviceName = serviceName;
		this.serviceDesc = serviceDesc;
	}
	
	public static ArrayList<ServiceMaster> getServiceMaster(ArrayList<Object[]> resList) {
		ArrayList<ServiceMaster> resArray = new ArrayList<ServiceMaster>();
		for (Object[] obj : resList) {
			ServiceMaster cOBJ = new ServiceMaster((Short)obj[0], (String)obj[1], (String)obj[2]);
			resArray.add(cOBJ);
		}
		return resArray;
	}

}
