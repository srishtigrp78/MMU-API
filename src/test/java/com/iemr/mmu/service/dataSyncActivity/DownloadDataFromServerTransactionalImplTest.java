package com.iemr.mmu.service.dataSyncActivity;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.mmu.repo.login.MasterVanRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.IndentIssueRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.IndentOrderRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.IndentRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.ItemStockEntryRepo;
import com.iemr.mmu.repo.syncActivity_syncLayer.StockTransferRepo;

@ExtendWith(MockitoExtension.class)
class DownloadDataFromServerTransactionalImplTest {
    @InjectMocks
    private DownloadDataFromServerTransactionalImpl downloadDataFromServerTransactionalImpl;

    @Mock
    private IndentIssueRepo indentIssueRepo;

    @Mock
    private IndentOrderRepo indentOrderRepo;

    @Mock
    private IndentRepo indentRepo;

    @Mock
    private ItemStockEntryRepo itemStockEntryRepo;

    @Mock
    private MasterVanRepo masterVanRepo;

    @Mock
    private StockTransferRepo stockTransferRepo;

    @Test
    void testDownloadTransactionalData() throws Exception {
        // Arrange
        when(masterVanRepo.getFacilityID(Mockito.<Integer>any())).thenReturn(null);

        // Act and Assert
        assertThrows(Exception.class,
                () -> downloadDataFromServerTransactionalImpl.downloadTransactionalData(1, "JaneDoe"));
        verify(masterVanRepo).getFacilityID(Mockito.<Integer>any());
    }
}
