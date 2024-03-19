package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class WrapperFemaleObstetricHistoryTest {
    @InjectMocks
    private WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory;

   
    @Test
    void testGetFemaleObstetricHistoryDetails() {
        // Arrange, Act and Assert
        assertNull((new WrapperFemaleObstetricHistory()).getFemaleObstetricHistoryDetails());
        assertTrue(WrapperFemaleObstetricHistory.getFemaleObstetricHistory(new ArrayList<>())
                .getFemaleObstetricHistoryDetails()
                .isEmpty());
    }

 
    @Test
    void testGetFemaleObstetricHistoryDetails2() {
        // Arrange
        WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory2 = new WrapperFemaleObstetricHistory();
        wrapperFemaleObstetricHistory2.setTotalNoOfPreg((short) 1);

        // Act
        ArrayList<FemaleObstetricHistory> actualFemaleObstetricHistoryDetails = wrapperFemaleObstetricHistory2
                .getFemaleObstetricHistoryDetails();

        // Assert
        assertEquals(1, actualFemaleObstetricHistoryDetails.size());
        assertSame(actualFemaleObstetricHistoryDetails, wrapperFemaleObstetricHistory2.getFemaleObstetricHistoryList());
    }

    
    @Test
    void testGetFemaleObstetricHistoryDetails3() {
        // Arrange
        FemaleObstetricHistory femaleObstetricHistory = new FemaleObstetricHistory();
        femaleObstetricHistory.setAbortionType(new HashMap<>());
        femaleObstetricHistory.setAbortionTypeID(1);
        femaleObstetricHistory.setBenVisitID(1L);
        femaleObstetricHistory.setBeneficiaryRegID(1L);
        femaleObstetricHistory.setCaptureDate(mock(Date.class));
        femaleObstetricHistory.setCongenitalAnomalies("Congenital Anomalies");
        femaleObstetricHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        femaleObstetricHistory.setCreatedDate(mock(Timestamp.class));
        femaleObstetricHistory.setDeleted(true);
        femaleObstetricHistory.setDeliveryComplicationID("Delivery Complication ID");
        femaleObstetricHistory.setDeliveryComplicationList(new ArrayList<>());
        femaleObstetricHistory.setDeliveryComplicationType("Delivery Complication Type");
        femaleObstetricHistory.setDeliveryPlace("Delivery Place");
        femaleObstetricHistory.setDeliveryPlaceID((short) 1);
        femaleObstetricHistory.setDeliveryType("Delivery Type");
        femaleObstetricHistory.setDeliveryTypeID((short) 1);
        femaleObstetricHistory.setDurationType("Duration Type");
        femaleObstetricHistory.setLastModDate(mock(Timestamp.class));
        femaleObstetricHistory.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        femaleObstetricHistory.setNewBornComplication("New Born Complication");
        femaleObstetricHistory.setNewBornComplicationID((short) 1);
        femaleObstetricHistory.setObstetricHistoryID(1L);
        femaleObstetricHistory.setOtherDeliveryComplication("Other Delivery Complication");
        femaleObstetricHistory.setOtherDeliveryPlace("Other Delivery Place");
        femaleObstetricHistory.setOtherNewBornComplication("Other New Born Complication");
        femaleObstetricHistory.setOtherPostNatalComplication("Other Post Natal Complication");
        femaleObstetricHistory.setOtherPostpartumCompType("Other Postpartum Comp Type");
        femaleObstetricHistory.setOtherPregComplication("Other Preg Complication");
        femaleObstetricHistory.setParkingPlaceID(1);
        femaleObstetricHistory.setPostAbortionComplication(new ArrayList<>());
        femaleObstetricHistory.setPostAbortionComplication_db("Post Abortion Complication db");
        femaleObstetricHistory.setPostAbortionComplicationsValues("42");
        femaleObstetricHistory.setPostNatalComplication("Post Natal Complication");
        femaleObstetricHistory.setPostNatalComplicationID((short) 1);
        femaleObstetricHistory.setPostpartumComplicationID("Postpartum Complication ID");
        femaleObstetricHistory.setPostpartumComplicationList(new ArrayList<>());
        femaleObstetricHistory.setPostpartumComplicationType("Postpartum Complication Type");
        femaleObstetricHistory.setPregComplicationID("Preg Complication ID");
        femaleObstetricHistory.setPregComplicationList(new ArrayList<>());
        femaleObstetricHistory.setPregComplicationType("Preg Complication Type");
        femaleObstetricHistory.setPregDuration(1);
        femaleObstetricHistory.setPregDurationID((short) 1);
        femaleObstetricHistory.setPregOrder((short) 1);
        femaleObstetricHistory.setPregOutcome("Preg Outcome");
        femaleObstetricHistory.setPregOutcomeID((short) 1);
        femaleObstetricHistory.setProcessed("Processed");
        femaleObstetricHistory.setProviderServiceMapID(1);
        femaleObstetricHistory.setReservedForChange("Reserved For Change");
        femaleObstetricHistory.setServiceFacilityID(1);
        femaleObstetricHistory.setServiceFacilityValue("42");
        femaleObstetricHistory.setSyncedBy("Synced By");
        femaleObstetricHistory.setSyncedDate(mock(Timestamp.class));
        femaleObstetricHistory.setTotalNoOfPreg((short) 1);
        femaleObstetricHistory.setTypeOfAbortionValue("42");
        femaleObstetricHistory.setTypeofFacility(new HashMap<>());
        femaleObstetricHistory.setTypeofFacilityID(1);
        femaleObstetricHistory.setVanID(1);
        femaleObstetricHistory.setVanSerialNo(1L);
        femaleObstetricHistory.setVehicalNo("Vehical No");
        femaleObstetricHistory.setVisitCode(1L);

        ArrayList<FemaleObstetricHistory> femaleObstetricHistoryList = new ArrayList<>();
        femaleObstetricHistoryList.add(femaleObstetricHistory);

        WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory2 = new WrapperFemaleObstetricHistory();
        wrapperFemaleObstetricHistory2.setFemaleObstetricHistoryList(femaleObstetricHistoryList);

        // Act
        ArrayList<FemaleObstetricHistory> actualFemaleObstetricHistoryDetails = wrapperFemaleObstetricHistory2
                .getFemaleObstetricHistoryDetails();

        // Assert
        assertEquals(1, actualFemaleObstetricHistoryDetails.size());
        assertSame(femaleObstetricHistoryList, actualFemaleObstetricHistoryDetails);
    }

  
    @Test
    void testGetFemaleObstetricHistory() {
        // Arrange and Act
        WrapperFemaleObstetricHistory actualFemaleObstetricHistory = WrapperFemaleObstetricHistory
                .getFemaleObstetricHistory(new ArrayList<>());

        // Assert
        ArrayList<FemaleObstetricHistory> expectedFemaleObstetricHistoryDetails = actualFemaleObstetricHistory
                .getFemaleObstetricHistoryList();
        assertSame(expectedFemaleObstetricHistoryDetails, actualFemaleObstetricHistory.getFemaleObstetricHistoryDetails());
    }

   
    @Test
    void testGettersAndSetters() {
        // Arrange
        WrapperFemaleObstetricHistory wrapperFemaleObstetricHistory = new WrapperFemaleObstetricHistory();

        // Act
        wrapperFemaleObstetricHistory.setBenVisitID(1L);
        wrapperFemaleObstetricHistory.setBeneficiaryRegID(1L);
        wrapperFemaleObstetricHistory.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        ArrayList<FemaleObstetricHistory> femaleObstetricHistoryList = new ArrayList<>();
        wrapperFemaleObstetricHistory.setFemaleObstetricHistoryList(femaleObstetricHistoryList);
        wrapperFemaleObstetricHistory.setParkingPlaceID(1);
        wrapperFemaleObstetricHistory.setProviderServiceMapID(1);
        wrapperFemaleObstetricHistory.setTotalNoOfPreg((short) 1);
        wrapperFemaleObstetricHistory.setVanID(1);
        wrapperFemaleObstetricHistory.setVisitCode(1L);
        Long actualBenVisitID = wrapperFemaleObstetricHistory.getBenVisitID();
        Long actualBeneficiaryRegID = wrapperFemaleObstetricHistory.getBeneficiaryRegID();
        String actualCreatedBy = wrapperFemaleObstetricHistory.getCreatedBy();
        ArrayList<FemaleObstetricHistory> actualFemaleObstetricHistoryList = wrapperFemaleObstetricHistory
                .getFemaleObstetricHistoryList();
        Integer actualParkingPlaceID = wrapperFemaleObstetricHistory.getParkingPlaceID();
        Integer actualProviderServiceMapID = wrapperFemaleObstetricHistory.getProviderServiceMapID();
        Short actualTotalNoOfPreg = wrapperFemaleObstetricHistory.getTotalNoOfPreg();
        Integer actualVanID = wrapperFemaleObstetricHistory.getVanID();
        Long actualVisitCode = wrapperFemaleObstetricHistory.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertEquals((short) 1, actualTotalNoOfPreg.shortValue());
        assertSame(femaleObstetricHistoryList, actualFemaleObstetricHistoryList);
    }
}
