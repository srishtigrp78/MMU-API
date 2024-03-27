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
class WrapperComorbidCondDetailsTest {
    @Autowired
    private WrapperComorbidCondDetails wrapperComorbidCondDetails;

  
    @Test
    void testGetComrbidityConds() {
        // Arrange
        WrapperComorbidCondDetails wrapperComorbidCondDetails2 = new WrapperComorbidCondDetails();
        wrapperComorbidCondDetails2.setComorbidityConcurrentConditionsList(new ArrayList<>());

        // Act and Assert
        assertTrue(wrapperComorbidCondDetails2.getComrbidityConds().isEmpty());
    }

  
    @Test
    void testGetComrbidityConds2() {
        // Arrange
        BencomrbidityCondDetails bencomrbidityCondDetails = new BencomrbidityCondDetails();
        bencomrbidityCondDetails.setBenVisitID(1L);
        bencomrbidityCondDetails.setBeneficiaryRegID(1L);
        bencomrbidityCondDetails.setCaptureDate(mock(Date.class));
        bencomrbidityCondDetails.setComorbidCondition("Comorbid Condition");
        bencomrbidityCondDetails.setComorbidConditionID((short) 1);
        bencomrbidityCondDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        bencomrbidityCondDetails.setCreatedDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setDate(mock(Date.class));
        bencomrbidityCondDetails.setDeleted(true);
        bencomrbidityCondDetails.setID(1L);
        bencomrbidityCondDetails.setIsForHistory(true);
        bencomrbidityCondDetails.setLastModDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        bencomrbidityCondDetails.setOtherComorbidCondition("Other Comorbid Condition");
        bencomrbidityCondDetails.setParkingPlaceID(1);
        bencomrbidityCondDetails.setProcessed("Processed");
        bencomrbidityCondDetails.setProviderServiceMapID(1);
        bencomrbidityCondDetails.setReservedForChange("Reserved For Change");
        bencomrbidityCondDetails.setSyncedBy("Synced By");
        bencomrbidityCondDetails.setSyncedDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setTimePeriodAgo(1);
        bencomrbidityCondDetails.setTimePeriodUnit("Time Period Unit");
        bencomrbidityCondDetails.setVanID(1);
        bencomrbidityCondDetails.setVanSerialNo(1L);
        bencomrbidityCondDetails.setVehicalNo("Vehical No");
        bencomrbidityCondDetails.setVisitCode(1L);
        bencomrbidityCondDetails.setYear(mock(Timestamp.class));

        ArrayList<BencomrbidityCondDetails> comorbidityConcurrentConditionsList = new ArrayList<>();
        comorbidityConcurrentConditionsList.add(bencomrbidityCondDetails);

        WrapperComorbidCondDetails wrapperComorbidCondDetails2 = new WrapperComorbidCondDetails();
        wrapperComorbidCondDetails2.setComorbidityConcurrentConditionsList(comorbidityConcurrentConditionsList);

        // Act and Assert
        assertEquals(1, wrapperComorbidCondDetails2.getComrbidityConds().size());
    }

   
    @Test
    void testGetComrbidityConds3() {
        // Arrange
        BencomrbidityCondDetails bencomrbidityCondDetails = new BencomrbidityCondDetails();
        bencomrbidityCondDetails.setBenVisitID(1L);
        bencomrbidityCondDetails.setBeneficiaryRegID(1L);
        bencomrbidityCondDetails.setCaptureDate(mock(Date.class));
        bencomrbidityCondDetails.setComorbidCondition(null);
        bencomrbidityCondDetails.setComorbidConditionID((short) 1);
        bencomrbidityCondDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        bencomrbidityCondDetails.setCreatedDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setDate(mock(Date.class));
        bencomrbidityCondDetails.setDeleted(true);
        bencomrbidityCondDetails.setID(1L);
        bencomrbidityCondDetails.setIsForHistory(true);
        bencomrbidityCondDetails.setLastModDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        bencomrbidityCondDetails.setOtherComorbidCondition("Other Comorbid Condition");
        bencomrbidityCondDetails.setParkingPlaceID(1);
        bencomrbidityCondDetails.setProcessed("Processed");
        bencomrbidityCondDetails.setProviderServiceMapID(1);
        bencomrbidityCondDetails.setReservedForChange("Reserved For Change");
        bencomrbidityCondDetails.setSyncedBy("Synced By");
        bencomrbidityCondDetails.setSyncedDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setTimePeriodAgo(1);
        bencomrbidityCondDetails.setTimePeriodUnit("Time Period Unit");
        bencomrbidityCondDetails.setVanID(1);
        bencomrbidityCondDetails.setVanSerialNo(1L);
        bencomrbidityCondDetails.setVehicalNo("Vehical No");
        bencomrbidityCondDetails.setVisitCode(1L);
        bencomrbidityCondDetails.setYear(mock(Timestamp.class));

        ArrayList<BencomrbidityCondDetails> comorbidityConcurrentConditionsList = new ArrayList<>();
        comorbidityConcurrentConditionsList.add(bencomrbidityCondDetails);

        WrapperComorbidCondDetails wrapperComorbidCondDetails2 = new WrapperComorbidCondDetails();
        wrapperComorbidCondDetails2.setComorbidityConcurrentConditionsList(comorbidityConcurrentConditionsList);

        // Act and Assert
        assertTrue(wrapperComorbidCondDetails2.getComrbidityConds().isEmpty());
    }

   
    @Test
    void testGetComrbidityConds4() {
        // Arrange
        BencomrbidityCondDetails bencomrbidityCondDetails = new BencomrbidityCondDetails();
        bencomrbidityCondDetails.setBenVisitID(1L);
        bencomrbidityCondDetails.setBeneficiaryRegID(1L);
        bencomrbidityCondDetails.setCaptureDate(mock(Date.class));
        bencomrbidityCondDetails.setComorbidCondition("Comorbid Condition");
        bencomrbidityCondDetails.setComorbidConditionID((short) 1);
        bencomrbidityCondDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        bencomrbidityCondDetails.setCreatedDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setDate(mock(Date.class));
        bencomrbidityCondDetails.setDeleted(true);
        bencomrbidityCondDetails.setID(1L);
        bencomrbidityCondDetails.setIsForHistory(true);
        bencomrbidityCondDetails.setLastModDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        bencomrbidityCondDetails.setOtherComorbidCondition("Other Comorbid Condition");
        bencomrbidityCondDetails.setParkingPlaceID(1);
        bencomrbidityCondDetails.setProcessed("Processed");
        bencomrbidityCondDetails.setProviderServiceMapID(1);
        bencomrbidityCondDetails.setReservedForChange("Reserved For Change");
        bencomrbidityCondDetails.setSyncedBy("Synced By");
        bencomrbidityCondDetails.setSyncedDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setTimePeriodAgo(null);
        bencomrbidityCondDetails.setTimePeriodUnit("Time Period Unit");
        bencomrbidityCondDetails.setVanID(1);
        bencomrbidityCondDetails.setVanSerialNo(1L);
        bencomrbidityCondDetails.setVehicalNo("Vehical No");
        bencomrbidityCondDetails.setVisitCode(1L);
        bencomrbidityCondDetails.setYear(mock(Timestamp.class));

        ArrayList<BencomrbidityCondDetails> comorbidityConcurrentConditionsList = new ArrayList<>();
        comorbidityConcurrentConditionsList.add(bencomrbidityCondDetails);

        WrapperComorbidCondDetails wrapperComorbidCondDetails2 = new WrapperComorbidCondDetails();
        wrapperComorbidCondDetails2.setComorbidityConcurrentConditionsList(comorbidityConcurrentConditionsList);

        // Act and Assert
        assertEquals(1, wrapperComorbidCondDetails2.getComrbidityConds().size());
    }

   
    @Test
    void testGetComrbidityConds5() {
        // Arrange
        BencomrbidityCondDetails bencomrbidityCondDetails = new BencomrbidityCondDetails();
        bencomrbidityCondDetails.setBenVisitID(1L);
        bencomrbidityCondDetails.setBeneficiaryRegID(1L);
        bencomrbidityCondDetails.setCaptureDate(mock(Date.class));
        bencomrbidityCondDetails.setComorbidCondition("Comorbid Condition");
        bencomrbidityCondDetails.setComorbidConditionID((short) 1);
        bencomrbidityCondDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        bencomrbidityCondDetails.setCreatedDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setDate(mock(Date.class));
        bencomrbidityCondDetails.setDeleted(true);
        bencomrbidityCondDetails.setID(1L);
        bencomrbidityCondDetails.setIsForHistory(true);
        bencomrbidityCondDetails.setLastModDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        bencomrbidityCondDetails.setOtherComorbidCondition("Other Comorbid Condition");
        bencomrbidityCondDetails.setParkingPlaceID(1);
        bencomrbidityCondDetails.setProcessed("Processed");
        bencomrbidityCondDetails.setProviderServiceMapID(1);
        bencomrbidityCondDetails.setReservedForChange("Reserved For Change");
        bencomrbidityCondDetails.setSyncedBy("Synced By");
        bencomrbidityCondDetails.setSyncedDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setTimePeriodAgo(1);
        bencomrbidityCondDetails.setTimePeriodUnit("Years");
        bencomrbidityCondDetails.setVanID(1);
        bencomrbidityCondDetails.setVanSerialNo(1L);
        bencomrbidityCondDetails.setVehicalNo("Vehical No");
        bencomrbidityCondDetails.setVisitCode(1L);
        bencomrbidityCondDetails.setYear(mock(Timestamp.class));

        ArrayList<BencomrbidityCondDetails> comorbidityConcurrentConditionsList = new ArrayList<>();
        comorbidityConcurrentConditionsList.add(bencomrbidityCondDetails);

        WrapperComorbidCondDetails wrapperComorbidCondDetails2 = new WrapperComorbidCondDetails();
        wrapperComorbidCondDetails2.setComorbidityConcurrentConditionsList(comorbidityConcurrentConditionsList);

        // Act and Assert
        assertEquals(1, wrapperComorbidCondDetails2.getComrbidityConds().size());
    }

    
    @Test
    void testGetComrbidityConds6() {
        // Arrange
        BencomrbidityCondDetails bencomrbidityCondDetails = new BencomrbidityCondDetails();
        bencomrbidityCondDetails.setBenVisitID(1L);
        bencomrbidityCondDetails.setBeneficiaryRegID(1L);
        bencomrbidityCondDetails.setCaptureDate(mock(Date.class));
        bencomrbidityCondDetails.setComorbidCondition("Comorbid Condition");
        bencomrbidityCondDetails.setComorbidConditionID((short) 1);
        bencomrbidityCondDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        bencomrbidityCondDetails.setCreatedDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setDate(mock(Date.class));
        bencomrbidityCondDetails.setDeleted(true);
        bencomrbidityCondDetails.setID(1L);
        bencomrbidityCondDetails.setIsForHistory(true);
        bencomrbidityCondDetails.setLastModDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        bencomrbidityCondDetails.setOtherComorbidCondition("Other Comorbid Condition");
        bencomrbidityCondDetails.setParkingPlaceID(1);
        bencomrbidityCondDetails.setProcessed("Processed");
        bencomrbidityCondDetails.setProviderServiceMapID(1);
        bencomrbidityCondDetails.setReservedForChange("Reserved For Change");
        bencomrbidityCondDetails.setSyncedBy("Synced By");
        bencomrbidityCondDetails.setSyncedDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setTimePeriodAgo(1);
        bencomrbidityCondDetails.setTimePeriodUnit("Months");
        bencomrbidityCondDetails.setVanID(1);
        bencomrbidityCondDetails.setVanSerialNo(1L);
        bencomrbidityCondDetails.setVehicalNo("Vehical No");
        bencomrbidityCondDetails.setVisitCode(1L);
        bencomrbidityCondDetails.setYear(mock(Timestamp.class));

        ArrayList<BencomrbidityCondDetails> comorbidityConcurrentConditionsList = new ArrayList<>();
        comorbidityConcurrentConditionsList.add(bencomrbidityCondDetails);

        WrapperComorbidCondDetails wrapperComorbidCondDetails2 = new WrapperComorbidCondDetails();
        wrapperComorbidCondDetails2.setComorbidityConcurrentConditionsList(comorbidityConcurrentConditionsList);

        // Act and Assert
        assertEquals(1, wrapperComorbidCondDetails2.getComrbidityConds().size());
    }

    
    @Test
    void testGetComrbidityConds7() {
        // Arrange
        BencomrbidityCondDetails bencomrbidityCondDetails = new BencomrbidityCondDetails();
        bencomrbidityCondDetails.setBenVisitID(1L);
        bencomrbidityCondDetails.setBeneficiaryRegID(1L);
        bencomrbidityCondDetails.setCaptureDate(mock(Date.class));
        bencomrbidityCondDetails.setComorbidCondition("Comorbid Condition");
        bencomrbidityCondDetails.setComorbidConditionID((short) 1);
        bencomrbidityCondDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        bencomrbidityCondDetails.setCreatedDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setDate(mock(Date.class));
        bencomrbidityCondDetails.setDeleted(true);
        bencomrbidityCondDetails.setID(1L);
        bencomrbidityCondDetails.setIsForHistory(true);
        bencomrbidityCondDetails.setLastModDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        bencomrbidityCondDetails.setOtherComorbidCondition("Other Comorbid Condition");
        bencomrbidityCondDetails.setParkingPlaceID(1);
        bencomrbidityCondDetails.setProcessed("Processed");
        bencomrbidityCondDetails.setProviderServiceMapID(1);
        bencomrbidityCondDetails.setReservedForChange("Reserved For Change");
        bencomrbidityCondDetails.setSyncedBy("Synced By");
        bencomrbidityCondDetails.setSyncedDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setTimePeriodAgo(1);
        bencomrbidityCondDetails.setTimePeriodUnit("Weeks");
        bencomrbidityCondDetails.setVanID(1);
        bencomrbidityCondDetails.setVanSerialNo(1L);
        bencomrbidityCondDetails.setVehicalNo("Vehical No");
        bencomrbidityCondDetails.setVisitCode(1L);
        bencomrbidityCondDetails.setYear(mock(Timestamp.class));

        ArrayList<BencomrbidityCondDetails> comorbidityConcurrentConditionsList = new ArrayList<>();
        comorbidityConcurrentConditionsList.add(bencomrbidityCondDetails);

        WrapperComorbidCondDetails wrapperComorbidCondDetails2 = new WrapperComorbidCondDetails();
        wrapperComorbidCondDetails2.setComorbidityConcurrentConditionsList(comorbidityConcurrentConditionsList);

        // Act and Assert
        assertEquals(1, wrapperComorbidCondDetails2.getComrbidityConds().size());
    }

  
    @Test
    void testGetComrbidityConds8() {
        // Arrange
        BencomrbidityCondDetails bencomrbidityCondDetails = new BencomrbidityCondDetails();
        bencomrbidityCondDetails.setBenVisitID(1L);
        bencomrbidityCondDetails.setBeneficiaryRegID(1L);
        bencomrbidityCondDetails.setCaptureDate(mock(Date.class));
        bencomrbidityCondDetails.setComorbidCondition("Comorbid Condition");
        bencomrbidityCondDetails.setComorbidConditionID((short) 1);
        bencomrbidityCondDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        bencomrbidityCondDetails.setCreatedDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setDate(mock(Date.class));
        bencomrbidityCondDetails.setDeleted(true);
        bencomrbidityCondDetails.setID(1L);
        bencomrbidityCondDetails.setIsForHistory(true);
        bencomrbidityCondDetails.setLastModDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        bencomrbidityCondDetails.setOtherComorbidCondition("Other Comorbid Condition");
        bencomrbidityCondDetails.setParkingPlaceID(1);
        bencomrbidityCondDetails.setProcessed("Processed");
        bencomrbidityCondDetails.setProviderServiceMapID(1);
        bencomrbidityCondDetails.setReservedForChange("Reserved For Change");
        bencomrbidityCondDetails.setSyncedBy("Synced By");
        bencomrbidityCondDetails.setSyncedDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setTimePeriodAgo(1);
        bencomrbidityCondDetails.setTimePeriodUnit("Days");
        bencomrbidityCondDetails.setVanID(1);
        bencomrbidityCondDetails.setVanSerialNo(1L);
        bencomrbidityCondDetails.setVehicalNo("Vehical No");
        bencomrbidityCondDetails.setVisitCode(1L);
        bencomrbidityCondDetails.setYear(mock(Timestamp.class));

        ArrayList<BencomrbidityCondDetails> comorbidityConcurrentConditionsList = new ArrayList<>();
        comorbidityConcurrentConditionsList.add(bencomrbidityCondDetails);

        WrapperComorbidCondDetails wrapperComorbidCondDetails2 = new WrapperComorbidCondDetails();
        wrapperComorbidCondDetails2.setComorbidityConcurrentConditionsList(comorbidityConcurrentConditionsList);

        // Act and Assert
        assertEquals(1, wrapperComorbidCondDetails2.getComrbidityConds().size());
    }

   
    @Test
    void testGetComrbidityConds9() {
        // Arrange
        BencomrbidityCondDetails bencomrbidityCondDetails = new BencomrbidityCondDetails();
        bencomrbidityCondDetails.setBenVisitID(1L);
        bencomrbidityCondDetails.setBeneficiaryRegID(1L);
        bencomrbidityCondDetails.setCaptureDate(mock(Date.class));
        bencomrbidityCondDetails.setComorbidCondition("Comorbid Condition");
        bencomrbidityCondDetails.setComorbidConditionID((short) 1);
        bencomrbidityCondDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        bencomrbidityCondDetails.setCreatedDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setDate(mock(Date.class));
        bencomrbidityCondDetails.setDeleted(true);
        bencomrbidityCondDetails.setID(1L);
        bencomrbidityCondDetails.setIsForHistory(true);
        bencomrbidityCondDetails.setLastModDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        bencomrbidityCondDetails.setOtherComorbidCondition("Other Comorbid Condition");
        bencomrbidityCondDetails.setParkingPlaceID(1);
        bencomrbidityCondDetails.setProcessed("Processed");
        bencomrbidityCondDetails.setProviderServiceMapID(1);
        bencomrbidityCondDetails.setReservedForChange("Reserved For Change");
        bencomrbidityCondDetails.setSyncedBy("Synced By");
        bencomrbidityCondDetails.setSyncedDate(mock(Timestamp.class));
        bencomrbidityCondDetails.setTimePeriodAgo(1);
        bencomrbidityCondDetails.setTimePeriodUnit(null);
        bencomrbidityCondDetails.setVanID(1);
        bencomrbidityCondDetails.setVanSerialNo(1L);
        bencomrbidityCondDetails.setVehicalNo("Vehical No");
        bencomrbidityCondDetails.setVisitCode(1L);
        bencomrbidityCondDetails.setYear(mock(Timestamp.class));

        ArrayList<BencomrbidityCondDetails> comorbidityConcurrentConditionsList = new ArrayList<>();
        comorbidityConcurrentConditionsList.add(bencomrbidityCondDetails);

        WrapperComorbidCondDetails wrapperComorbidCondDetails2 = new WrapperComorbidCondDetails();
        wrapperComorbidCondDetails2.setComorbidityConcurrentConditionsList(comorbidityConcurrentConditionsList);

        // Act and Assert
        assertEquals(1, wrapperComorbidCondDetails2.getComrbidityConds().size());
    }

   
    @Test
    void testGetComorbidityDetails() {
        // Arrange
        ArrayList<Object[]> comrbidityCondDetails = new ArrayList<>();

        // Act and Assert
        assertEquals(comrbidityCondDetails, WrapperComorbidCondDetails.getComorbidityDetails(comrbidityCondDetails)
                .getComorbidityConcurrentConditionsList());
    }

   
    @Test
    void testGettersAndSetters() {
        // Arrange
        WrapperComorbidCondDetails wrapperComorbidCondDetails = new WrapperComorbidCondDetails();

        // Act
        wrapperComorbidCondDetails.setBenVisitID(1L);
        wrapperComorbidCondDetails.setBeneficiaryRegID(1L);
        ArrayList<BencomrbidityCondDetails> comorbidityConcurrentConditionsList = new ArrayList<>();
        wrapperComorbidCondDetails.setComorbidityConcurrentConditionsList(comorbidityConcurrentConditionsList);
        wrapperComorbidCondDetails.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        wrapperComorbidCondDetails.setParkingPlaceID(1);
        wrapperComorbidCondDetails.setProviderServiceMapID(1);
        wrapperComorbidCondDetails.setVanID(1);
        wrapperComorbidCondDetails.setVisitCode(1L);
        Long actualBenVisitID = wrapperComorbidCondDetails.getBenVisitID();
        Long actualBeneficiaryRegID = wrapperComorbidCondDetails.getBeneficiaryRegID();
        ArrayList<BencomrbidityCondDetails> actualComorbidityConcurrentConditionsList = wrapperComorbidCondDetails
                .getComorbidityConcurrentConditionsList();
        String actualCreatedBy = wrapperComorbidCondDetails.getCreatedBy();
        Integer actualParkingPlaceID = wrapperComorbidCondDetails.getParkingPlaceID();
        Integer actualProviderServiceMapID = wrapperComorbidCondDetails.getProviderServiceMapID();
        Integer actualVanID = wrapperComorbidCondDetails.getVanID();
        Long actualVisitCode = wrapperComorbidCondDetails.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertSame(comorbidityConcurrentConditionsList, actualComorbidityConcurrentConditionsList);
    }
}
