package com.iemr.mmu.repo.labModule;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.labModule.ProcedureData;

@Repository
public interface ProcedureRepo extends CrudRepository<ProcedureData, Integer>
{
	@Query("select procedureID, procedureName, procedureDesc, gender, providerServiceMapID from ProcedureData"
			+ " where procedureType =:procedureType and deleted = false order by procedureName")
	public ArrayList<Object[]> getProcedures(@Param("procedureType") String procedureType);
}
