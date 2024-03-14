package com.iemr.mmu.service.dataSyncActivity;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.mmu.repo.syncActivity_syncLayer.SyncDownloadMasterRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.TempVanRepo;

@ExtendWith(MockitoExtension.class)
class DownloadDataFromServerImplTest {

	@Mock
	private SyncDownloadMasterRepo syncDownloadMasterRepo;
	@Mock
	private DataSyncRepository dataSyncRepository;
	@Mock
	private TempVanRepo tempVanRepo;
	@InjectMocks
	DownloadDataFromServerImpl downloadDataFromServer;
	
	

}
