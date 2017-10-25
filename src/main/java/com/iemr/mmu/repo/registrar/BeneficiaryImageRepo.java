package com.iemr.mmu.repo.registrar;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.registrar.BeneficiaryImage;

@Repository
public interface BeneficiaryImageRepo extends CrudRepository<BeneficiaryImage, Long> {
	@Query(" SELECT benImage from BeneficiaryImage where beneficiaryRegID =:benRegID ")
	public String getBenImage(@Param("benRegID") Long benRegID);

}
