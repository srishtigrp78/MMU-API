//package com.iemr.mmu.controller.covid19;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@ExtendWith(MockitoExtension.class)
//class CovidControllerTest2 {
//    @InjectMocks
//    private CovidController covidController;
//
//    /**
//     * Method under test:
//     * {@link CovidController#saveBenCovid19NurseData(String, String)}
//     */
//    @Test
//    void testSaveBenCovid19NurseData() {
//        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
//
//        // Arrange, Act and Assert
//        assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Unable to save data\",\"status\":\"Unable to save data\"}",
//                (new CovidController()).saveBenCovid19NurseData("Request Obj", "JaneDoe"));
//        assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Unable to save data\",\"status\":\"Unable to save data\"}",
//                (new CovidController()).saveBenCovid19NurseData("foo", "foo"));
//        assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Unable to save data\",\"status\":\"Unable to save data\"}",
//                (new CovidController()).saveBenCovid19NurseData("Failed with generic error", "JaneDoe"));
//        assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Unable to save data\",\"status\":\"Unable to save data\"}",
//                (new CovidController()).saveBenCovid19NurseData("FAILURE", "JaneDoe"));
//        assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Unable to save data\",\"status\":\"Unable to save data\"}",
//                (new CovidController()).saveBenCovid19NurseData("42", "JaneDoe"));
//        assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Unable to save data\",\"status\":\"Unable to save data\"}",
//                (new CovidController()).saveBenCovid19NurseData("", "JaneDoe"));
//    }
//
//    /**
//     * Method under test:
//     * {@link CovidController#saveBenCovidDoctorData(String, String)}
//     */
//    @Test
//    void testSaveBenCovidDoctorData() {
//        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
//
//        // Arrange, Act and Assert
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Unable to save data. com.google.gson.stream.MalformedJsonException:"
//                        + " Use JsonReader.setLenient(true) to accept malformed JSON at line 1 column 10 path $\",\"status\":\"Unable"
//                        + " to save data. com.google.gson.stream.MalformedJsonException: Use JsonReader.setLenient(true) to accept"
//                        + " malformed JSON at line 1 column 10 path $\"}",
//                (new CovidController()).saveBenCovidDoctorData("Request Obj", "JaneDoe"));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Unable to save data. Not a JSON Object: \\\"foo\\\"\",\"status\":\"Unable"
//                        + " to save data. Not a JSON Object: \\\"foo\\\"\"}",
//                (new CovidController()).saveBenCovidDoctorData("foo", "foo"));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Unable to save data. com.google.gson.stream.MalformedJsonException:"
//                        + " Use JsonReader.setLenient(true) to accept malformed JSON at line 1 column 9 path $\",\"status\":\"Unable"
//                        + " to save data. com.google.gson.stream.MalformedJsonException: Use JsonReader.setLenient(true) to accept"
//                        + " malformed JSON at line 1 column 9 path $\"}",
//                (new CovidController()).saveBenCovidDoctorData("Failed with generic error", "JaneDoe"));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Unable to save data. Not a JSON Object: \\\"FAILURE\\\"\",\"status\":\"Unable"
//                        + " to save data. Not a JSON Object: \\\"FAILURE\\\"\"}",
//                (new CovidController()).saveBenCovidDoctorData("FAILURE", "JaneDoe"));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Unable to save data. Not a JSON Object: 42\",\"status\":\"Unable to"
//                        + " save data. Not a JSON Object: 42\"}",
//                (new CovidController()).saveBenCovidDoctorData("42", "JaneDoe"));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Unable to save data. Not a JSON Object: null\",\"status\":\"Unable to"
//                        + " save data. Not a JSON Object: null\"}",
//                (new CovidController()).saveBenCovidDoctorData("", "JaneDoe"));
//    }
//
//    /**
//     * Method under test:
//     * {@link CovidController#getBenVisitDetailsFrmNurseCovid19(String)}
//     */
//    @Test
//    void testGetBenVisitDetailsFrmNurseCovid19() {
//        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
//
//        // Arrange, Act and Assert
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Error while getting beneficiary visit data\",\"status\":\"Error while"
//                        + " getting beneficiary visit data\"}",
//                (new CovidController()).getBenVisitDetailsFrmNurseCovid19("Coming Request"));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Error while getting beneficiary visit data\",\"status\":\"Error while"
//                        + " getting beneficiary visit data\"}",
//                (new CovidController()).getBenVisitDetailsFrmNurseCovid19(null));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Error while getting beneficiary visit data\",\"status\":\"Error while"
//                        + " getting beneficiary visit data\"}",
//                (new CovidController()).getBenVisitDetailsFrmNurseCovid19("﻿"));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Error while getting beneficiary visit data\",\"status\":\"Error while"
//                        + " getting beneficiary visit data\"}",
//                (new CovidController()).getBenVisitDetailsFrmNurseCovid19("foo"));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Error while getting beneficiary visit data\",\"status\":\"Error while"
//                        + " getting beneficiary visit data\"}",
//                (new CovidController()).getBenVisitDetailsFrmNurseCovid19("42"));
//    }
//
//    /**
//     * Method under test:
//     * {@link CovidController#getBenCovid19HistoryDetails(String)}
//     */
//    @Test
//    void testGetBenCovid19HistoryDetails() {
//        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
//
//        // Arrange, Act and Assert
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Error while getting beneficiary history data\",\"status\":\"Error while"
//                        + " getting beneficiary history data\"}",
//                (new CovidController()).getBenCovid19HistoryDetails("Coming Request"));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Error while getting beneficiary history data\",\"status\":\"Error while"
//                        + " getting beneficiary history data\"}",
//                (new CovidController()).getBenCovid19HistoryDetails(null));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Error while getting beneficiary history data\",\"status\":\"Error while"
//                        + " getting beneficiary history data\"}",
//                (new CovidController()).getBenCovid19HistoryDetails("﻿"));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Error while getting beneficiary history data\",\"status\":\"Error while"
//                        + " getting beneficiary history data\"}",
//                (new CovidController()).getBenCovid19HistoryDetails("foo"));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Error while getting beneficiary history data\",\"status\":\"Error while"
//                        + " getting beneficiary history data\"}",
//                (new CovidController()).getBenCovid19HistoryDetails("42"));
//    }
//
//    /**
//     * Method under test:
//     * {@link CovidController#getBenVitalDetailsFrmNurseNCDCare(String)}
//     */
//    @Test
//    void testGetBenVitalDetailsFrmNurseNCDCare() {
//        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
//
//        // Arrange, Act and Assert
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Error while getting beneficiary vital data\",\"status\":\"Error while"
//                        + " getting beneficiary vital data\"}",
//                (new CovidController()).getBenVitalDetailsFrmNurseNCDCare("Coming Request"));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Error while getting beneficiary vital data\",\"status\":\"Error while"
//                        + " getting beneficiary vital data\"}",
//                (new CovidController()).getBenVitalDetailsFrmNurseNCDCare(null));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Error while getting beneficiary vital data\",\"status\":\"Error while"
//                        + " getting beneficiary vital data\"}",
//                (new CovidController()).getBenVitalDetailsFrmNurseNCDCare("﻿"));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Error while getting beneficiary vital data\",\"status\":\"Error while"
//                        + " getting beneficiary vital data\"}",
//                (new CovidController()).getBenVitalDetailsFrmNurseNCDCare("foo"));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Error while getting beneficiary vital data\",\"status\":\"Error while"
//                        + " getting beneficiary vital data\"}",
//                (new CovidController()).getBenVitalDetailsFrmNurseNCDCare("42"));
//    }
//
//    /**
//     * Method under test:
//     * {@link CovidController#getBenCaseRecordFromDoctorCovid19(String)}
//     */
//    @Test
//    void testGetBenCaseRecordFromDoctorCovid19() {
//        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
//
//        // Arrange, Act and Assert
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Error while getting beneficiary doctor data\",\"status\":\"Error while"
//                        + " getting beneficiary doctor data\"}",
//                (new CovidController()).getBenCaseRecordFromDoctorCovid19("Coming Request"));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Error while getting beneficiary doctor data\",\"status\":\"Error while"
//                        + " getting beneficiary doctor data\"}",
//                (new CovidController()).getBenCaseRecordFromDoctorCovid19(null));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Error while getting beneficiary doctor data\",\"status\":\"Error while"
//                        + " getting beneficiary doctor data\"}",
//                (new CovidController()).getBenCaseRecordFromDoctorCovid19("﻿"));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Error while getting beneficiary doctor data\",\"status\":\"Error while"
//                        + " getting beneficiary doctor data\"}",
//                (new CovidController()).getBenCaseRecordFromDoctorCovid19("foo"));
//        assertEquals(
//                "{\"statusCode\":5000,\"errorMessage\":\"Error while getting beneficiary doctor data\",\"status\":\"Error while"
//                        + " getting beneficiary doctor data\"}",
//                (new CovidController()).getBenCaseRecordFromDoctorCovid19("42"));
//    }
//
//    /**
//     * Method under test:
//     * {@link CovidController#updateCovid19DoctorData(String, String)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testUpdateCovid19DoctorData() throws Exception {
//        // TODO: Diffblue Cover was only able to create a partial test for this method:
//        //   Reason: Failed to create Spring context.
//        //   Attempt to initialize test context failed with
//        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@2da7d194 testClass = com.iemr.mmu.controller.covid19.DiffblueFakeClass292, locations = [], classes = [com.iemr.mmu.controller.covid19.CovidController, com.iemr.mmu.service.covid19.Covid19Service, com.iemr.mmu.service.covid19.Covid19ServiceImpl], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@55d00de7, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@70cf758f, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@4ff987ea], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
//        //       at java.base/java.util.Optional.map(Optional.java:260)
//        //   See https://diff.blue/R026 to resolve this issue.
//
//        // Arrange
//        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/pandemic/covid/update/doctorData")
//                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==")
//                .contentType(MediaType.APPLICATION_JSON);
//        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
//                .content((new ObjectMapper()).writeValueAsString("foo"));
//
//        // Act
//        MockMvcBuilders.standaloneSetup(covidController).build().perform(requestBuilder);
//    }
//
//    /**
//     * Method under test: {@link CovidController#updateHistoryNurse(String)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testUpdateHistoryNurse() throws Exception {
//        // TODO: Diffblue Cover was only able to create a partial test for this method:
//        //   Reason: Failed to create Spring context.
//        //   Attempt to initialize test context failed with
//        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@5d5e83a7 testClass = com.iemr.mmu.controller.covid19.DiffblueFakeClass359, locations = [], classes = [com.iemr.mmu.controller.covid19.CovidController, com.iemr.mmu.service.covid19.Covid19Service, com.iemr.mmu.service.covid19.Covid19ServiceImpl], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@55d00de7, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@70cf758f, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@4ff987ea], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
//        //       at java.base/java.util.Optional.map(Optional.java:260)
//        //   See https://diff.blue/R026 to resolve this issue.
//
//        // Arrange
//        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
//                .post("/pandemic/covid/update/historyScreen")
//                .contentType(MediaType.APPLICATION_JSON);
//        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
//                .content((new ObjectMapper()).writeValueAsString("foo"));
//
//        // Act
//        MockMvcBuilders.standaloneSetup(covidController).build().perform(requestBuilder);
//    }
//
//    /**
//     * Method under test: {@link CovidController#updateVitalNurse(String)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testUpdateVitalNurse() throws Exception {
//        // TODO: Diffblue Cover was only able to create a partial test for this method:
//        //   Reason: Failed to create Spring context.
//        //   Attempt to initialize test context failed with
//        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@7c3bd3f5 testClass = com.iemr.mmu.controller.covid19.DiffblueFakeClass398, locations = [], classes = [com.iemr.mmu.controller.covid19.CovidController, com.iemr.mmu.service.covid19.Covid19Service, com.iemr.mmu.service.covid19.Covid19ServiceImpl], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@55d00de7, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@70cf758f, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@4ff987ea], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
//        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
//        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
//        //       at java.base/java.util.Optional.map(Optional.java:260)
//        //   See https://diff.blue/R026 to resolve this issue.
//
//        // Arrange
//        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/pandemic/covid/update/vitalScreen")
//                .contentType(MediaType.APPLICATION_JSON);
//        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
//                .content((new ObjectMapper()).writeValueAsString("foo"));
//
//        // Act
//        MockMvcBuilders.standaloneSetup(covidController).build().perform(requestBuilder);
//    }
//}
