package com.iemr.mmu.service.reports;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.mmu.data.reports.ReportMaster;
import com.iemr.mmu.repo.reports.ReportMasterRepo;

@ExtendWith(MockitoExtension.class)
class ReportCheckPostImplTest {
    @InjectMocks
    private ReportCheckPostImpl reportCheckPostImpl;

    @Mock
    private ReportMasterRepo reportMasterRepo;

    @Test
    void testGetReportMaster() throws Exception {
        // Arrange
        when(reportMasterRepo.findByServiceIDAndDeletedOrderByReportNameAsc(Mockito.<Integer>any(), Mockito.<Boolean>any()))
                .thenReturn(new ArrayList<>());

        // Act
        String actualReportMaster = reportCheckPostImpl.getReportMaster(1);

        // Assert
        verify(reportMasterRepo).findByServiceIDAndDeletedOrderByReportNameAsc(Mockito.<Integer>any(),
                Mockito.<Boolean>any());
        assertEquals("[]", actualReportMaster);
    }

    @Test
    void testGetReportMaster2() throws Exception {
        // Arrange
        ReportMaster reportMaster = new ReportMaster();
        reportMaster.setDeleted(true);
        reportMaster.setReportID(1);
        reportMaster.setReportName("Report Name");
        reportMaster.setServiceID(1);

        ArrayList<ReportMaster> reportMasterList = new ArrayList<>();
        reportMasterList.add(reportMaster);
        when(reportMasterRepo.findByServiceIDAndDeletedOrderByReportNameAsc(Mockito.<Integer>any(), Mockito.<Boolean>any()))
                .thenReturn(reportMasterList);

        // Act
        String actualReportMaster = reportCheckPostImpl.getReportMaster(1);

        // Assert
        verify(reportMasterRepo).findByServiceIDAndDeletedOrderByReportNameAsc(Mockito.<Integer>any(),
                Mockito.<Boolean>any());
        assertEquals("[{\"reportID\":1,\"reportName\":\"Report Name\",\"deleted\":true,\"serviceID\":1}]",
                actualReportMaster);
    }

    @Test
    void testGetReportMaster3() throws Exception {
        // Arrange
        ReportMaster reportMaster = new ReportMaster();
        reportMaster.setDeleted(true);
        reportMaster.setReportID(1);
        reportMaster.setReportName("Report Name");
        reportMaster.setServiceID(1);

        ReportMaster reportMaster2 = new ReportMaster();
        reportMaster2.setDeleted(false);
        reportMaster2.setReportID(2);
        reportMaster2.setReportName("42");
        reportMaster2.setServiceID(2);

        ArrayList<ReportMaster> reportMasterList = new ArrayList<>();
        reportMasterList.add(reportMaster2);
        reportMasterList.add(reportMaster);
        when(reportMasterRepo.findByServiceIDAndDeletedOrderByReportNameAsc(Mockito.<Integer>any(), Mockito.<Boolean>any()))
                .thenReturn(reportMasterList);

        // Act
        String actualReportMaster = reportCheckPostImpl.getReportMaster(1);

        // Assert
        verify(reportMasterRepo).findByServiceIDAndDeletedOrderByReportNameAsc(Mockito.<Integer>any(),
                Mockito.<Boolean>any());
        assertEquals(
                "[{\"reportID\":2,\"reportName\":\"42\",\"deleted\":false,\"serviceID\":2},{\"reportID\":1,\"reportName\":\"Report"
                        + " Name\",\"deleted\":true,\"serviceID\":1}]",
                actualReportMaster);
    }

    @Test
    void testGetReportMaster4() throws Exception {
        // Arrange
        ReportMaster reportMaster = new ReportMaster();
        reportMaster.setDeleted(true);
        reportMaster.setReportID(1);
        reportMaster.setReportName("Report Name");
        reportMaster.setServiceID(1);

        ReportMaster reportMaster2 = new ReportMaster();
        reportMaster2.setDeleted(false);
        reportMaster2.setReportID(2);
        reportMaster2.setReportName("42");
        reportMaster2.setServiceID(2);

        ReportMaster reportMaster3 = new ReportMaster();
        reportMaster3.setDeleted(true);
        reportMaster3.setReportID(3);
        reportMaster3.setReportName("");
        reportMaster3.setServiceID(3);

        ArrayList<ReportMaster> reportMasterList = new ArrayList<>();
        reportMasterList.add(reportMaster3);
        reportMasterList.add(reportMaster2);
        reportMasterList.add(reportMaster);
        when(reportMasterRepo.findByServiceIDAndDeletedOrderByReportNameAsc(Mockito.<Integer>any(), Mockito.<Boolean>any()))
                .thenReturn(reportMasterList);

        // Act
        String actualReportMaster = reportCheckPostImpl.getReportMaster(1);

        // Assert
        verify(reportMasterRepo).findByServiceIDAndDeletedOrderByReportNameAsc(Mockito.<Integer>any(),
                Mockito.<Boolean>any());
        assertEquals(
                "[{\"reportID\":3,\"reportName\":\"\",\"deleted\":true,\"serviceID\":3},{\"reportID\":2,\"reportName\":\"42\",\"deleted"
                        + "\":false,\"serviceID\":2},{\"reportID\":1,\"reportName\":\"Report Name\",\"deleted\":true,\"serviceID\":1}]",
                actualReportMaster);
    }

    @Test
    void testReportHandler() throws Exception {
        // Arrange, Act and Assert
        assertThrows(Exception.class, () -> reportCheckPostImpl.reportHandler(""));
        assertThrows(Exception.class, () -> reportCheckPostImpl.reportHandler(null));
    }
}
