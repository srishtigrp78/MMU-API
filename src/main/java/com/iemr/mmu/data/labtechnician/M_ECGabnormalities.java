package com.iemr.mmu.data.labtechnician;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.mmu.annotation.sqlinjection.SQLInjectionSafe;

@Entity
@Table(name = "m_ecgabnormalities")
public class M_ECGabnormalities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@Expose
	private Integer id;

	@SQLInjectionSafe
	@Column(name = "name")
	@Expose
	private String ecgAbnormality;

	@Expose
	@Column(name = "Deleted")
	private Boolean deleted;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEcgAbnormality() {
		return ecgAbnormality;
	}

	public void setEcgAbnormality(String ecgAbnormality) {
		this.ecgAbnormality = ecgAbnormality;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}
