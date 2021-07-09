package com.iemr.mmu.repo.syncActivity_syncLayer;

import org.springframework.data.repository.CrudRepository;

import com.iemr.mmu.data.syncActivity_syncLayer.EmployeeSignature;


public interface EmployeeSignatureRepo extends CrudRepository<EmployeeSignature, Long> {

	EmployeeSignature findOneByUserID(Long userID);

}
