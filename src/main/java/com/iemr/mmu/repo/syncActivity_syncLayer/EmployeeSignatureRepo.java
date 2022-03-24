package com.iemr.mmu.repo.syncActivity_syncLayer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.syncActivity_syncLayer.EmployeeSignature;

@Repository
@RestResource(exported = false)
public interface EmployeeSignatureRepo extends CrudRepository<EmployeeSignature, Long> {

	EmployeeSignature findOneByUserID(Long userID);

}
