package com.iemr.mmu.repo.location;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.location.DistrictBranchMapping;

@Repository
@RestResource(exported = false)
public interface DistrictBranchMasterRepo extends CrudRepository<DistrictBranchMapping, Integer> {

	@Query(" SELECT districtBranchID, villageName FROM DistrictBranchMapping WHERE blockID = :blockID  AND deleted != 1 ")
	public ArrayList<Object[]> findByBlockID(@Param("blockID") Integer blockID);

	/*@Query("select  v.villageName, v.districtBranchID from DistrictBranchMapping v "
			+ "inner join v.districtBlock b "
			+ "inner join b.districts d "
			+ "inner join d.states s where s.stateID =: stateID ")
	public ArrayList<Object[]> getVillageStateList(@Param("stateID") Integer stateID);*/
	
	
	@Query(" SELECT  b.blockName,b.blockID,d.districtName,d.districtID FROM DistrictBranchMapping v "
			+ " INNER JOIN v.districtBlock b"
			+ " INNER JOIN b.districts d"
			+ " WHERE v.districtBranchID = :districtBranchID AND v.deleted != 1 ")
	public ArrayList<Object[]> getDistrictTalukList(@Param("districtBranchID") Integer districtBranchID);
	

}
