package com.iemr.mmu.data.covid19;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class Covid19BenFeedbackTest {
    @InjectMocks
    private Covid19BenFeedback covid19BenFeedback;

    @Test
    void testGetcOVID19ID() {
        // Arrange, Act and Assert
        assertNull((new Covid19BenFeedback()).getcOVID19ID());
    }

    
    @Test
    void testGetcOVID19ID2() {
        // Arrange
        Covid19BenFeedback covid19BenFeedback2 = new Covid19BenFeedback();
        covid19BenFeedback2.setCreatedDate(mock(Timestamp.class));

        // Act and Assert
        assertNull(covid19BenFeedback2.getcOVID19ID());
    }

    
    @Test
    void testGetcOVID19_contact_history() {
        // Arrange, Act and Assert
        assertNull((new Covid19BenFeedback()).getcOVID19_contact_history());
    }

    
    @Test
    void testGetcOVID19_contact_history2() {
        // Arrange
        Covid19BenFeedback covid19BenFeedback2 = new Covid19BenFeedback();
        covid19BenFeedback2.setCreatedDate(mock(Timestamp.class));

        // Act and Assert
        assertNull(covid19BenFeedback2.getcOVID19_contact_history());
    }

   
    @Test
    void testGettersAndSetters() {
        // Arrange
        Covid19BenFeedback covid19BenFeedback = new Covid19BenFeedback();

        // Act
        covid19BenFeedback.setBenCallID(1L);
        covid19BenFeedback.setBenMedHistoryID(1L);
        covid19BenFeedback.setBeneficiaryRegID(1L);
        String[] contactStatus = new String[]{"Contact Status"};
        covid19BenFeedback.setContactStatus(contactStatus);
        covid19BenFeedback.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Timestamp createdDate = mock(Timestamp.class);
        covid19BenFeedback.setCreatedDate(createdDate);
        covid19BenFeedback.setDeleted(true);
        covid19BenFeedback.setFromCityInter(1);
        covid19BenFeedback.setFromCountryInter(3);
        covid19BenFeedback.setFromDistrictDom(1);
        covid19BenFeedback.setFromStateDom(1);
        covid19BenFeedback.setFromSubDistrictDom(1);
        covid19BenFeedback.setFromcityInter(1);
        Timestamp lastModDate = mock(Timestamp.class);
        covid19BenFeedback.setLastModDate(lastModDate);
        covid19BenFeedback.setMedical_consultation(true);
        covid19BenFeedback.setModeOfTravelDomestic("Mode Of Travel Domestic");
        covid19BenFeedback.setModeOfTravelInter("Mode Of Travel Inter");
        covid19BenFeedback.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        covid19BenFeedback.setProcessed("Processed");
        covid19BenFeedback.setProviderServiceMapID(1);
        ArrayList<String[]> recommendation = new ArrayList<>();
        covid19BenFeedback.setRecommendation(recommendation);
        covid19BenFeedback.setRecommendation_db("Recommendation db");
        covid19BenFeedback.setSuspectedStatus(true);
        covid19BenFeedback.setSuspectedStatusUI("Suspected Status UI");
        covid19BenFeedback.setSymptom(new String[]{"Symptom"});
        String[] symptoms = new String[]{"Symptoms"};
        covid19BenFeedback.setSymptoms(symptoms);
        covid19BenFeedback.setSymptoms_db("Symptoms db");
        covid19BenFeedback.setToCityInter(1);
        covid19BenFeedback.setToCountryInter(3);
        covid19BenFeedback.setToDistrictDom(1);
        covid19BenFeedback.setToStateDom(1);
        covid19BenFeedback.setToSubDistrictDom(1);
        covid19BenFeedback.setTocityInter(1);
        String[] travelList = new String[]{"Travel List"};
        covid19BenFeedback.setTravelList(travelList);
        covid19BenFeedback.setTravelStatus(true);
        covid19BenFeedback.setTravelType("Travel Type");
        covid19BenFeedback.setVanID(1);
        covid19BenFeedback.setVanSerialNo(1L);
        covid19BenFeedback.setVisitCode(1L);
//        covid19BenFeedback.setcOVID19ID(1L);
        covid19BenFeedback.setcOVID19_contact_history("C OVID19 contact history");
        Long actualBenCallID = covid19BenFeedback.getBenCallID();
        Long actualBenMedHistoryID = covid19BenFeedback.getBenMedHistoryID();
        Long actualBeneficiaryRegID = covid19BenFeedback.getBeneficiaryRegID();
        String[] actualContactStatus = covid19BenFeedback.getContactStatus();
        String actualCreatedBy = covid19BenFeedback.getCreatedBy();
        Timestamp actualCreatedDate = covid19BenFeedback.getCreatedDate();
        Boolean actualDeleted = covid19BenFeedback.getDeleted();
        Integer actualFromCityInter = covid19BenFeedback.getFromCityInter();
        Integer actualFromCountryInter = covid19BenFeedback.getFromCountryInter();
        Integer actualFromDistrictDom = covid19BenFeedback.getFromDistrictDom();
        Integer actualFromStateDom = covid19BenFeedback.getFromStateDom();
        Integer actualFromSubDistrictDom = covid19BenFeedback.getFromSubDistrictDom();
        Integer actualFromcityInter = covid19BenFeedback.getFromcityInter();
        Timestamp actualLastModDate = covid19BenFeedback.getLastModDate();
        Boolean actualMedical_consultation = covid19BenFeedback.getMedical_consultation();
        String actualModeOfTravelDomestic = covid19BenFeedback.getModeOfTravelDomestic();
        String actualModeOfTravelInter = covid19BenFeedback.getModeOfTravelInter();
        String actualModifiedBy = covid19BenFeedback.getModifiedBy();
        String actualProcessed = covid19BenFeedback.getProcessed();
        Integer actualProviderServiceMapID = covid19BenFeedback.getProviderServiceMapID();
        ArrayList<String[]> actualRecommendation = covid19BenFeedback.getRecommendation();
        String actualRecommendation_db = covid19BenFeedback.getRecommendation_db();
        Boolean actualSuspectedStatus = covid19BenFeedback.getSuspectedStatus();
        String actualSuspectedStatusUI = covid19BenFeedback.getSuspectedStatusUI();
        String[] actualSymptom = covid19BenFeedback.getSymptom();
        String[] actualSymptoms = covid19BenFeedback.getSymptoms();
        String actualSymptoms_db = covid19BenFeedback.getSymptoms_db();
        Integer actualToCityInter = covid19BenFeedback.getToCityInter();
        Integer actualToCountryInter = covid19BenFeedback.getToCountryInter();
        Integer actualToDistrictDom = covid19BenFeedback.getToDistrictDom();
        Integer actualToStateDom = covid19BenFeedback.getToStateDom();
        Integer actualToSubDistrictDom = covid19BenFeedback.getToSubDistrictDom();
        Integer actualTocityInter = covid19BenFeedback.getTocityInter();
        String[] actualTravelList = covid19BenFeedback.getTravelList();
        Boolean actualTravelStatus = covid19BenFeedback.getTravelStatus();
        String actualTravelType = covid19BenFeedback.getTravelType();
        Integer actualVanID = covid19BenFeedback.getVanID();
        Long actualVanSerialNo = covid19BenFeedback.getVanSerialNo();
        Long actualVisitCode = covid19BenFeedback.getVisitCode();

        // Assert that nothing has changed
        assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedBy);
        assertEquals("Jan 1, 2020 9:00am GMT+0100", actualModifiedBy);
        assertEquals("Mode Of Travel Domestic", actualModeOfTravelDomestic);
        assertEquals("Mode Of Travel Inter", actualModeOfTravelInter);
        assertEquals("Processed", actualProcessed);
        assertEquals("Recommendation db", actualRecommendation_db);
        assertEquals("Suspected Status UI", actualSuspectedStatusUI);
        assertEquals("Symptoms db", actualSymptoms_db);
        assertEquals("Travel Type", actualTravelType);
        assertEquals(1, actualFromCityInter.intValue());
        assertEquals(1, actualFromDistrictDom.intValue());
        assertEquals(1, actualFromStateDom.intValue());
        assertEquals(1, actualFromSubDistrictDom.intValue());
        assertEquals(1, actualFromcityInter.intValue());
        assertEquals(1, actualProviderServiceMapID.intValue());
        assertEquals(1, actualToCityInter.intValue());
        assertEquals(1, actualToDistrictDom.intValue());
        assertEquals(1, actualToStateDom.intValue());
        assertEquals(1, actualToSubDistrictDom.intValue());
        assertEquals(1, actualTocityInter.intValue());
        assertEquals(1, actualVanID.intValue());
        assertEquals(1L, actualBenCallID.longValue());
        assertEquals(1L, actualBenMedHistoryID.longValue());
        assertEquals(1L, actualBeneficiaryRegID.longValue());
        assertEquals(1L, actualVanSerialNo.longValue());
        assertEquals(1L, actualVisitCode.longValue());
        assertEquals(3, actualFromCountryInter.intValue());
        assertEquals(3, actualToCountryInter.intValue());
        assertTrue(actualDeleted);
        assertTrue(actualMedical_consultation);
        assertTrue(actualSuspectedStatus);
        assertTrue(actualTravelStatus);
        assertSame(recommendation, actualRecommendation);
        assertSame(actualSymptom, actualSymptoms);
        assertSame(contactStatus, actualContactStatus);
        assertSame(symptoms, actualSymptom);
        assertSame(travelList, actualTravelList);
        assertSame(createdDate, actualCreatedDate);
        assertSame(lastModDate, actualLastModDate);
    }
}
