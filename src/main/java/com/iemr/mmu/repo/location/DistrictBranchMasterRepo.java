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
