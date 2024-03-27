package com.iemr.mmu.data.anc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.iemr.mmu.data.quickConsultation.BenChiefComplaint;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class WrapperAncFindingsTest {
   
    @Test
    void testGetFindingsData() {
        // Arrange
        ArrayList<Object[]> clinicalObservationsList = new ArrayList<>();

        // Act and Assert
        assertNull(WrapperAncFindings.getFindingsData(clinicalObservationsList, new ArrayList<>()));
    }

 
    @Test
    void testGettersAndSetters() {
        // Arrange
        ArrayList<BenChiefComplaint> complaints = new ArrayList<>();

        // Act
        WrapperAncFindings actualWrapperAncFindings = new WrapperAncFindings(1L, 1L, 1, "Jan 1, 2020 8:00am GMT+0100",
                "Clinical Observation", "Other Symptoms", "Significant Findings", complaints);
        actualWrapperAncFindings.setBenVisitID(1L);
        actualWrapperAncFindings.setBeneficiaryRegID(1L);
        actualWrapperAncFindings.setClinicalObservation("Clinical Observation");
        ArrayList<BenChiefComplaint> complaints2 = new ArrayList<>();
        actualWrapperAncFindings.setComplaints(complaints2);
        actualWrapperAncFindings.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        actualWrapperAncFindings.setIsForHistory(true);
        actualWrapperAncFindings.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualWrapperAncFindings.setOtherSymptoms("Other Symptoms");
        actualWrapperAncFindings.setOtherSymptomsSCTCode("Other Symptoms SCTCode");
        actualWrapperAncFindings.setOtherSymptomsSCTTerm("Other Symptoms SCTTerm");
        actualWrapperAncFindings.setParkingPlaceID(1);
        actualWrapperAncFindings.setProviderServiceMapID(1);
        actualWrapperAncFindings.setSignificantFindings("Significant Findings");
        actualWrapperAncFindings.setVanID(1);
        actualWrapperAncFindings.setVisitCode(1L);
        Long actualBenVisitID = actualWrapperAncFindings.getBenVisitID();
        Long actualBeneficiaryRegID = actualWrapperAncFindings.getBeneficiaryRegID();
        String actualClinicalObservation = actualWrapperAncFindings.getClinicalObservation();
        ArrayList<BenChiefComplaint> actualComplaints = actualWrapperAncFindings.getComplaints();
        String actualCreatedBy = actualWrapperAncFindings.getCreatedBy();
        Boolean actualIsForHistory = actualWrapperAncFindings.getIsForHistory();
        String actualModifiedBy = actualWrapperAncFindings.getModifiedBy();
        String actualOtherSymptoms = actualWrapperAncFindings.getOtherSymptoms();
        String actualOtherSymptomsSCTCode = actualWrapperAncFindings.getOtherSymptomsSCTCode();
        String actualOtherSymptomsSCTTerm = actualWrapperAncFindings.getOtherSymptomsSCTTerm();
        Integer actualParkingPlaceID = actualWrapperAncFindings.getParkingPlaceID();
        Integer actualProviderServiceMapID = actualWrapperAncFindings.getProviderServiceMapID();
        String actualSignificantFindings = actualWrapperAncFindings.getSignificantFindings();
        Integer actualVanID = actualWrapperAncFindings.getVanID();
        Long actualVisitCode = actualWrapperAncFindings.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Clinical Observation", actualClinicalObservation);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Symptoms SCTCode", actualOtherSymptomsSCTCode);
        assertEquals("Other Symptoms SCTTerm", actualOtherSymptomsSCTTerm);
        assertEquals("Other Symptoms", actualOtherSymptoms);
        assertEquals("Significant Findings", actualSignificantFindings);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertTrue(actualIsForHistory);
        assertEquals(complaints, actualComplaints);
        assertSame(complaints2, actualComplaints);
    }

    @Test
    void testGettersAndSetters2() {
        // Arrange
        ArrayList<BenChiefComplaint> chiefComplaints = new ArrayList<>();

        // Act
        WrapperAncFindings actualWrapperAncFindings = new WrapperAncFindings(1L, 1L, 1, "Clinical Observation",
                "Other Symptoms", "Significant Findings", chiefComplaints, true, 1L);
        actualWrapperAncFindings.setBenVisitID(1L);
        actualWrapperAncFindings.setBeneficiaryRegID(1L);
        actualWrapperAncFindings.setClinicalObservation("Clinical Observation");
        ArrayList<BenChiefComplaint> complaints = new ArrayList<>();
        actualWrapperAncFindings.setComplaints(complaints);
        actualWrapperAncFindings.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        actualWrapperAncFindings.setIsForHistory(true);
        actualWrapperAncFindings.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        actualWrapperAncFindings.setOtherSymptoms("Other Symptoms");
        actualWrapperAncFindings.setOtherSymptomsSCTCode("Other Symptoms SCTCode");
        actualWrapperAncFindings.setOtherSymptomsSCTTerm("Other Symptoms SCTTerm");
        actualWrapperAncFindings.setParkingPlaceID(1);
        actualWrapperAncFindings.setProviderServiceMapID(1);
        actualWrapperAncFindings.setSignificantFindings("Significant Findings");
        actualWrapperAncFindings.setVanID(1);
        actualWrapperAncFindings.setVisitCode(1L);
        Long actualBenVisitID = actualWrapperAncFindings.getBenVisitID();
        Long actualBeneficiaryRegID = actualWrapperAncFindings.getBeneficiaryRegID();
        String actualClinicalObservation = actualWrapperAncFindings.getClinicalObservation();
        ArrayList<BenChiefComplaint> actualComplaints = actualWrapperAncFindings.getComplaints();
        String actualCreatedBy = actualWrapperAncFindings.getCreatedBy();
        Boolean actualIsForHistory = actualWrapperAncFindings.getIsForHistory();
        String actualModifiedBy = actualWrapperAncFindings.getModifiedBy();
        String actualOtherSymptoms = actualWrapperAncFindings.getOtherSymptoms();
        String actualOtherSymptomsSCTCode = actualWrapperAncFindings.getOtherSymptomsSCTCode();
        String actualOtherSymptomsSCTTerm = actualWrapperAncFindings.getOtherSymptomsSCTTerm();
        Integer actualParkingPlaceID = actualWrapperAncFindings.getParkingPlaceID();
        Integer actualProviderServiceMapID = actualWrapperAncFindings.getProviderServiceMapID();
        String actualSignificantFindings = actualWrapperAncFindings.getSignificantFindings();
        Integer actualVanID = actualWrapperAncFindings.getVanID();
        Long actualVisitCode = actualWrapperAncFindings.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Clinical Observation", actualClinicalObservation);
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Other Symptoms SCTCode", actualOtherSymptomsSCTCode);
        assertEquals("Other Symptoms SCTTerm", actualOtherSymptomsSCTTerm);
        assertEquals("Other Symptoms", actualOtherSymptoms);
        assertEquals("Significant Findings", actualSignificantFindings);
        assertEquals(1, actualParkingPlaceID.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenVisitID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertTrue(actualIsForHistory);
        assertEquals(chiefComplaints, actualComplaints);
        assertSame(complaints, actualComplaints);
    }
}
