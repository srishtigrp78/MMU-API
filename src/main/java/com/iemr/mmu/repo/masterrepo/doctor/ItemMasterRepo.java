package com.iemr.mmu.repo.masterrepo.doctor;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.masterdata.doctor.ItemMaster;

@Repository
public interface ItemMasterRepo extends CrudRepository<ItemMaster, Integer> {
	@Query("SELECT t FROM ItemMaster t WHERE t.providerServiceMapID= :psmID and t.isEDL = false and t.deleted = false ")
	public ArrayList<ItemMaster> searchEdl(@Param("psmID") Integer psmID);

}
