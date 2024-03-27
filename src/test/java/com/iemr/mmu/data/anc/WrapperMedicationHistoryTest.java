package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class WrapperMedicationHistoryTest {
    @Autowired
    private WrapperMedicationHistory wrapperMedicationHistory;

    
    @Test
    void testGetBenMedicationHistoryDetails() {
        // Arrange
        WrapperMedicationHistory wrapperMedicationHistory2 = new WrapperMedicationHistory();
        wrapperMedicationHistory2.setMedicationHistoryList(new ArrayList<>());

        // Act and Assert
        assertTrue(wrapperMedicationHistory2.getBenMedicationHistoryDetails().isEmpty());
    }

   
    @Test
    void testGetBenMedicationHistoryDetails2() {
        // Arrange
        BenMedicationHistory benMedicationHistory = new BenMedicationHistory();
        benMedicationHistory.setBenVisitID(1L);
        benMedicationHistory.setBeneficiaryRegID(1L);
        benMedicationHistory.setCaptureDate(mock(Date.class));
        benMedicationHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        benMedicationHistory.setCreatedDate(mock(Timestamp.class));
        benMedicationHistory.setCurrentMedication("Current Medication");
        benMedicationHistory.setDeleted(true);
        benMedicationHistory.setID(1L);
        benMedicationHistory.setLastModDate(mock(Timestamp.class));
        benMedicationHistory.setMedication_year(mock(Date.class));
        benMedicationHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        benMedicationHistory.setParkingPlaceID(1);
        benMedicationHistory.setProcessed("Processed");
        benMedicationHistory.setProviderServiceMapID(1);
        benMedicationHistory.setReservedForChange("Reserved For Change");
        benMedicationHistory.setSyncedBy("Synced By");
        benMedicationHistory.setSyncedDate(mock(Timestamp.class));
        benMedicationHistory.setTimePeriodAgo(1);
        benMedicationHistory.setTimePeriodUnit("Time Period Unit");
        benMedicationHistory.setVanID(1);
        benMedicationHistory.setVanSerialNo(1L);
        benMedicationHistory.setVehicalNo("Vehical No");
        benMedicationHistory.setVisitCode(1L);
        benMedicationHistory.setYear(mock(Timestamp.class));

        ArrayList<BenMedicationHistory> medicationHistoryList = new ArrayList<>();
        medicationHistoryList.add(benMedicationHistory);

        WrapperMedicationHistory wrapperMedicationHistory2 = new WrapperMedicationHistory();
        wrapperMedicationHistory2.setMedicationHistoryList(medicationHistoryList);

        // Act and Assert
        assertEquals(1, wrapperMedicationHistory2.getBenMedicationHistoryDetails().size());
    }

   
    @Test
    void testGetBenMedicationHistoryDetails3() {
        // Arrange
        BenMedicationHistory benMedicationHistory = new BenMedicationHistory();
        benMedicationHistory.setBenVisitID(1L);
        benMedicationHistory.setBeneficiaryRegID(1L);
        benMedicationHistory.setCaptureDate(mock(Date.class));
        benMedicationHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        benMedicationHistory.setCreatedDate(mock(Timestamp.class));
        benMedicationHistory.setCurrentMedication(null);
        benMedicationHistory.setDeleted(true);
        benMedicationHistory.setID(1L);
        benMedicationHistory.setLastModDate(mock(Timestamp.class));
        benMedicationHistory.setMedication_year(mock(Date.class));
        benMedicationHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        benMedicationHistory.setParkingPlaceID(1);
        benMedicationHistory.setProcessed("Processed");
        benMedicationHistory.setProviderServiceMapID(1);
        benMedicationHistory.setReservedForChange("Reserved For Change");
        benMedicationHistory.setSyncedBy("Synced By");
        benMedicationHistory.setSyncedDate(mock(Timestamp.class));
        benMedicationHistory.setTimePeriodAgo(1);
        benMedicationHistory.setTimePeriodUnit("Time Period Unit");
        benMedicationHistory.setVanID(1);
        benMedicationHistory.setVanSerialNo(1L);
        benMedicationHistory.setVehicalNo("Vehical No");
        benMedicationHistory.setVisitCode(1L);
        benMedicationHistory.setYear(mock(Timestamp.class));

        ArrayList<BenMedicationHistory> medicationHistoryList = new ArrayList<>();
        medicationHistoryList.add(benMedicationHistory);

        WrapperMedicationHistory wrapperMedicationHistory2 = new WrapperMedicationHistory();
        wrapperMedicationHistory2.setMedicationHistoryList(medicationHistoryList);

        // Act and Assert
        assertTrue(wrapperMedicationHistory2.getBenMedicationHistoryDetails().isEmpty());
    }

    
    @Test
    void testGetBenMedicationHistoryDetails4() {
        // Arrange
        BenMedicationHistory benMedicationHistory = new BenMedicationHistory();
        benMedicationHistory.setBenVisitID(1L);
        benMedicationHistory.setBeneficiaryRegID(1L);
        benMedicationHistory.setCaptureDate(mock(Date.class));
        benMedicationHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        benMedicationHistory.setCreatedDate(mock(Timestamp.class));
        benMedicationHistory.setCurrentMedication("Current Medication");
        benMedicationHistory.setDeleted(true);
        benMedicationHistory.setID(1L);
        benMedicationHistory.setLastModDate(mock(Timestamp.class));
        benMedicationHistory.setMedication_year(mock(Date.class));
        benMedicationHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        benMedicationHistory.setParkingPlaceID(1);
        benMedicationHistory.setProcessed("Processed");
        benMedicationHistory.setProviderServiceMapID(1);
        benMedicationHistory.setReservedForChange("Reserved For Change");
        benMedicationHistory.setSyncedBy("Synced By");
        benMedicationHistory.setSyncedDate(mock(Timestamp.class));
        benMedicationHistory.setTimePeriodAgo(null);
        benMedicationHistory.setTimePeriodUnit("Time Period Unit");
        benMedicationHistory.setVanID(1);
        benMedicationHistory.setVanSerialNo(1L);
        benMedicationHistory.setVehicalNo("Vehical No");
        benMedicationHistory.setVisitCode(1L);
        benMedicationHistory.setYear(mock(Timestamp.class));

        ArrayList<BenMedicationHistory> medicationHistoryList = new ArrayList<>();
        medicationHistoryList.add(benMedicationHistory);

        WrapperMedicationHistory wrapperMedicationHistory2 = new WrapperMedicationHistory();
        wrapperMedicationHistory2.setMedicationHistoryList(medicationHistoryList);

        // Act and Assert
        assertEquals(1, wrapperMedicationHistory2.getBenMedicationHistoryDetails().size());
    }

  
    @Test
    void testGetBenMedicationHistoryDetails5() {
        // Arrange
        BenMedicationHistory benMedicationHistory = new BenMedicationHistory();
        benMedicationHistory.setBenVisitID(1L);
        benMedicationHistory.setBeneficiaryRegID(1L);
        benMedicationHistory.setCaptureDate(mock(Date.class));
        benMedicationHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        benMedicationHistory.setCreatedDate(mock(Timestamp.class));
        benMedicationHistory.setCurrentMedication("Current Medication");
        benMedicationHistory.setDeleted(true);
        benMedicationHistory.setID(1L);
        benMedicationHistory.setLastModDate(mock(Timestamp.class));
        benMedicationHistory.setMedication_year(mock(Date.class));
        benMedicationHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        benMedicationHistory.setParkingPlaceID(1);
        benMedicationHistory.setProcessed("Processed");
        benMedicationHistory.setProviderServiceMapID(1);
        benMedicationHistory.setReservedForChange("Reserved For Change");
        benMedicationHistory.setSyncedBy("Synced By");
        benMedicationHistory.setSyncedDate(mock(Timestamp.class));
        benMedicationHistory.setTimePeriodAgo(1);
        benMedicationHistory.setTimePeriodUnit("Years");
        benMedicationHistory.setVanID(1);
        benMedicationHistory.setVanSerialNo(1L);
        benMedicationHistory.setVehicalNo("Vehical No");
        benMedicationHistory.setVisitCode(1L);
        benMedicationHistory.setYear(mock(Timestamp.class));

        ArrayList<BenMedicationHistory> medicationHistoryList = new ArrayList<>();
        medicationHistoryList.add(benMedicationHistory);

        WrapperMedicationHistory wrapperMedicationHistory2 = new WrapperMedicationHistory();
        wrapperMedicationHistory2.setMedicationHistoryList(medicationHistoryList);

        // Act and Assert
        assertEquals(1, wrapperMedicationHistory2.getBenMedicationHistoryDetails().size());
    }

   
    @Test
    void testGetBenMedicationHistoryDetails6() {
        // Arrange
        BenMedicationHistory benMedicationHistory = new BenMedicationHistory();
        benMedicationHistory.setBenVisitID(1L);
        benMedicationHistory.setBeneficiaryRegID(1L);
        benMedicationHistory.setCaptureDate(mock(Date.class));
        benMedicationHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        benMedicationHistory.setCreatedDate(mock(Timestamp.class));
        benMedicationHistory.setCurrentMedication("Current Medication");
        benMedicationHistory.setDeleted(true);
        benMedicationHistory.setID(1L);
        benMedicationHistory.setLastModDate(mock(Timestamp.class));
        benMedicationHistory.setMedication_year(mock(Date.class));
        benMedicationHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        benMedicationHistory.setParkingPlaceID(1);
        benMedicationHistory.setProcessed("Processed");
        benMedicationHistory.setProviderServiceMapID(1);
        benMedicationHistory.setReservedForChange("Reserved For Change");
        benMedicationHistory.setSyncedBy("Synced By");
        benMedicationHistory.setSyncedDate(mock(Timestamp.class));
        benMedicationHistory.setTimePeriodAgo(1);
        benMedicationHistory.setTimePeriodUnit("Months");
        benMedicationHistory.setVanID(1);
        benMedicationHistory.setVanSerialNo(1L);
        benMedicationHistory.setVehicalNo("Vehical No");
        benMedicationHistory.setVisitCode(1L);
        benMedicationHistory.setYear(mock(Timestamp.class));

        ArrayList<BenMedicationHistory> medicationHistoryList = new ArrayList<>();
        medicationHistoryList.add(benMedicationHistory);

        WrapperMedicationHistory wrapperMedicationHistory2 = new WrapperMedicationHistory();
        wrapperMedicationHistory2.setMedicationHistoryList(medicationHistoryList);

        // Act and Assert
        assertEquals(1, wrapperMedicationHistory2.getBenMedicationHistoryDetails().size());
    }

    @Test
    void testGetBenMedicationHistoryDetails7() {
        // Arrange
        BenMedicationHistory benMedicationHistory = new BenMedicationHistory();
        benMedicationHistory.setBenVisitID(1L);
        benMedicationHistory.setBeneficiaryRegID(1L);
        benMedicationHistory.setCaptureDate(mock(Date.class));
        benMedicationHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        benMedicationHistory.setCreatedDate(mock(Timestamp.class));
        benMedicationHistory.setCurrentMedication("Current Medication");
        benMedicationHistory.setDeleted(true);
        benMedicationHistory.setID(1L);
        benMedicationHistory.setLastModDate(mock(Timestamp.class));
        benMedicationHistory.setMedication_year(mock(Date.class));
        benMedicationHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        benMedicationHistory.setParkingPlaceID(1);
        benMedicationHistory.setProcessed("Processed");
        benMedicationHistory.setProviderServiceMapID(1);
        benMedicationHistory.setReservedForChange("Reserved For Change");
        benMedicationHistory.setSyncedBy("Synced By");
        benMedicationHistory.setSyncedDate(mock(Timestamp.class));
        benMedicationHistory.setTimePeriodAgo(1);
        benMedicationHistory.setTimePeriodUnit("Weeks");
        benMedicationHistory.setVanID(1);
        benMedicationHistory.setVanSerialNo(1L);
        benMedicationHistory.setVehicalNo("Vehical No");
        benMedicationHistory.setVisitCode(1L);
        benMedicationHistory.setYear(mock(Timestamp.class));

        ArrayList<BenMedicationHistory> medicationHistoryList = new ArrayList<>();
        medicationHistoryList.add(benMedicationHistory);

        WrapperMedicationHistory wrapperMedicationHistory2 = new WrapperMedicationHistory();
        wrapperMedicationHistory2.setMedicationHistoryList(medicationHistoryList);

        // Act and Assert
        assertEquals(1, wrapperMedicationHistory2.getBenMedicationHistoryDetails().size());
    }

  
    @Test
    void testGetBenMedicationHistoryDetails8() {
        // Arrange
        BenMedicationHistory benMedicationHistory = new BenMedicationHistory();
        benMedicationHistory.setBenVisitID(1L);
        benMedicationHistory.setBeneficiaryRegID(1L);
        benMedicationHistory.setCaptureDate(mock(Date.class));
        benMedicationHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        benMedicationHistory.setCreatedDate(mock(Timestamp.class));
        benMedicationHistory.setCurrentMedication("Current Medication");
        benMedicationHistory.setDeleted(true);
        benMedicationHistory.setID(1L);
        benMedicationHistory.setLastModDate(mock(Timestamp.class));
        benMedicationHistory.setMedication_year(mock(Date.class));
        benMedicationHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        benMedicationHistory.setParkingPlaceID(1);
        benMedicationHistory.setProcessed("Processed");
        benMedicationHistory.setProviderServiceMapID(1);
        benMedicationHistory.setReservedForChange("Reserved For Change");
        benMedicationHistory.setSyncedBy("Synced By");
        benMedicationHistory.setSyncedDate(mock(Timestamp.class));
        benMedicationHistory.setTimePeriodAgo(1);
        benMedicationHistory.setTimePeriodUnit("Days");
        benMedicationHistory.setVanID(1);
        benMedicationHistory.setVanSerialNo(1L);
        benMedicationHistory.setVehicalNo("Vehical No");
        benMedicationHistory.setVisitCode(1L);
        benMedicationHistory.setYear(mock(Timestamp.class));

        ArrayList<BenMedicationHistory> medicationHistoryList = new ArrayList<>();
        medicationHistoryList.add(benMedicationHistory);

        WrapperMedicationHistory wrapperMedicationHistory2 = new WrapperMedicationHistory();
        wrapperMedicationHistory2.setMedicationHistoryList(medicationHistoryList);

        // Act and Assert
        assertEquals(1, wrapperMedicationHistory2.getBenMedicationHistoryDetails().size());
    }

   
    @Test
    void testGetBenMedicationHistoryDetails9() {
        // Arrange
        BenMedicationHistory benMedicationHistory = new BenMedicationHistory();
        benMedicationHistory.setBenVisitID(1L);
        benMedicationHistory.setBeneficiaryRegID(1L);
        benMedicationHistory.setCaptureDate(mock(Date.class));
        benMedicationHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        benMedicationHistory.setCreatedDate(mock(Timestamp.class));
        benMedicationHistory.setCurrentMedication("Current Medication");
        benMedicationHistory.setDeleted(true);
        benMedicationHistory.setID(1L);
        benMedicationHistory.setLastModDate(mock(Timestamp.class));
        benMedicationHistory.setMedication_year(mock(Date.class));
        benMedicationHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        benMedicationHistory.setParkingPlaceID(1);
        benMedicationHistory.setProcessed("Processed");
        benMedicationHistory.setProviderServiceMapID(1);
        benMedicationHistory.setReservedForChange("Reserved For Change");
        benMedicationHistory.setSyncedBy("Synced By");
        benMedicationHistory.setSyncedDate(mock(Timestamp.class));
        benMedicationHistory.setTimePeriodAgo(1);
        benMedicationHistory.setTimePeriodUnit(null);
        benMedicationHistory.setVanID(1);
        benMedicationHistory.setVanSerialNo(1L);
        benMedicationHistory.setVehicalNo("Vehical No");
        benMedicationHistory.setVisitCode(1L);
        benMedicationHistory.setYear(mock(Timestamp.class));

        ArrayList<BenMedicationHistory> medicationHistoryList = new ArrayList<>();
        medicationHistoryList.add(benMedicationHistory);

        WrapperMedicationHistory wrapperMedicationHistory2 = new WrapperMedicationHistory();
        wrapperMedicationHistory2.setMedicationHistoryList(medicationHistoryList);

        // Act and Assert
        assertEquals(1, wrapperMedicationHistory2.getBenMedicationHistoryDetails().size());
    }

    @Test
    void testGetMedicationHistoryDetails() {
        // Arrange
        ArrayList<Object[]> medicationHistoryDetails = new ArrayList<>();

        // Act and Assert
        assertEquals(medicationHistoryDetails,
                WrapperMedicationHistory.getMedicationHistoryDetails(medicationHistoryDetails).getMedicationHistoryList());
    }

   
    @Test
    void testGettersAndSetters() {
        // Arrange
        WrapperMedicationHistory wrapperMedicationHistory = new WrapperMedicationHistory();

        // Act
        wrapperMedicationHistory.setBenVisitID(1L);
        wrapperMedicationHistory.setBeneficiaryRegID(1L);
        wrapperMedicationHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        ArrayList<BenMedicationHistory> medicationHistoryList = new ArrayList<>();
        wrapperMedicationHistory.setMedicationHistoryList(medicationHistoryList);
        wrapperMedicationHistory.setParkingPlaceID(1);
        wrapperMedicationHistory.setProviderServiceMapID(1);
        wrapperMedicationHistory.setVanID(1);
        wrapperMedicationHistory.setVisitCode(1L);
        Long actualBenVisitID = wrapperMedicationHistory.getBenVisitID();
        Long actualBeneficiaryRegID = wrapperMedicationHistory.getBeneficiaryRegID();
        String actualCreatedBy = wrapperMedicationHistory.getCreatedBy();
        ArrayList<BenMedicationHistory> actualMedicationHistoryList = wrapperMedicationHistory.getMedicationHistoryList();
        Integer actualParkingPlaceID = wrapperMedicationHistory.getParkingPlaceID();
        Integer actualProviderServiceMapID = wrapperMedicationHistory.getProviderServiceMapID();
        Integer actualVanID = wrapperMedicationHistory.getVanID();
        Long actualVisitCode = wrapperMedicationHistory.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertSame(medicationHistoryList, actualMedicationHistoryList);
    }
}
