package com.iemr.mmu.service.dataSyncLayerCentral;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
@ExtendWith(MockitoExtension.class)
class GetDataFromVanAndSyncToDBImplTest {
	
	@Mock
	private static final String ServerColumnsNotRequired = null;
	@Mock
	private DataSyncRepositoryCentral dataSyncRepositoryCentral;
	@InjectMocks
	GetDataFromVanAndSyncToDBImpl getDataFromVanAndSyncToDB;

	@Test
	void testSyncDataToServer() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate_M_BeneficiaryRegIdMapping_for_provisioned_benID() {
		fail("Not yet implemented");
	}

	@Test
	void testGetQueryToInsertDataToServerDB() {
		fail("Not yet implemented");
	}

	@Test
	void testGetQueryToUpdateDataToServerDB() {
		fail("Not yet implemented");
	}

}
