package com.iemr.mmu.repo.location;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.location.Country;

@Repository
public interface CountryMasterRepo extends CrudRepository<Country, Integer> {
	
	@Query("select c from Country c where deleted = false order by countryName asc")
	public ArrayList<Country> findAllCountries();

}
