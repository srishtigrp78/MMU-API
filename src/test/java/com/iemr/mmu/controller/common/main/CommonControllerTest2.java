//package com.iemr.mmu.controller.common.main;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus;
//import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;
//import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
//import com.iemr.mmu.service.common.transaction.CommonServiceImpl;
//import com.iemr.mmu.utils.exception.IEMRException;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//@ExtendWith(MockitoExtension.class)
//class CommonControllerTest2 {
//	@InjectMocks
//	private CommonController commonController;
//
//	@Test
//	void testGetDocWorkListNew() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting doctor worklist\",\"status\":\"Error while getting"
//						+ " doctor worklist\"}",
//				(new CommonController()).getDocWorkListNew(1, 1, 1));
//	}
//
//	@Test
//	void testGetDocWorkListNew2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(new CommonDoctorServiceImpl());
//
//		// Act and Assert
//		assertEquals("{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				commonController.getDocWorkListNew(1, 1, 1));
//	}
//
//	@Test
//	void testGetDocWorkListNew3() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonDoctorServiceImpl commonDoctorServiceImpl = mock(CommonDoctorServiceImpl.class);
//		when(commonDoctorServiceImpl.getDocWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any(),
//				Mockito.<Integer>any())).thenReturn("Doc Work List New");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(commonDoctorServiceImpl);
//
//		// Act
//		String actualDocWorkListNew = commonController.getDocWorkListNew(1, 1, 1);
//
//		// Assert
//		verify(commonDoctorServiceImpl).getDocWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any(),
//				Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"Doc Work List New\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":"
//						+ "\"Success\"}",
//				actualDocWorkListNew);
//	}
//
//	@Test
//	void testGetDocWorkListNew4() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonDoctorServiceImpl commonDoctorServiceImpl = mock(CommonDoctorServiceImpl.class);
//		when(commonDoctorServiceImpl.getDocWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any(),
//				Mockito.<Integer>any())).thenReturn("FAILURE");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(commonDoctorServiceImpl);
//
//		// Act
//		String actualDocWorkListNew = commonController.getDocWorkListNew(1, 1, 1);
//
//		// Assert
//		verify(commonDoctorServiceImpl).getDocWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any(),
//				Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"FAILURE\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualDocWorkListNew);
//	}
//
//	@Test
//	void testGetDocWorkListNew5() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonDoctorServiceImpl commonDoctorServiceImpl = mock(CommonDoctorServiceImpl.class);
//		when(commonDoctorServiceImpl.getDocWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any(),
//				Mockito.<Integer>any())).thenReturn("{\"response\":\"$$STRING\"}");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(commonDoctorServiceImpl);
//
//		// Act
//		String actualDocWorkListNew = commonController.getDocWorkListNew(1, 1, 1);
//
//		// Assert
//		verify(commonDoctorServiceImpl).getDocWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any(),
//				Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualDocWorkListNew);
//	}
//
//	@Test
//	void testGetDocWorkListNew6() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonDoctorServiceImpl commonDoctorServiceImpl = mock(CommonDoctorServiceImpl.class);
//		when(commonDoctorServiceImpl.getDocWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any(),
//				Mockito.<Integer>any())).thenReturn(null);
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(commonDoctorServiceImpl);
//
//		// Act
//		String actualDocWorkListNew = commonController.getDocWorkListNew(1, 1, 1);
//
//		// Assert
//		verify(commonDoctorServiceImpl).getDocWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any(),
//				Mockito.<Integer>any());
//		assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}",
//				actualDocWorkListNew);
//	}
//
//	@Test
//	void testGetDocWorkListNew7() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonDoctorServiceImpl commonDoctorServiceImpl = mock(CommonDoctorServiceImpl.class);
//		when(commonDoctorServiceImpl.getDocWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any(),
//				Mockito.<Integer>any())).thenReturn("");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(commonDoctorServiceImpl);
//
//		// Act
//		String actualDocWorkListNew = commonController.getDocWorkListNew(1, 1, 1);
//
//		// Assert
//		verify(commonDoctorServiceImpl).getDocWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any(),
//				Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualDocWorkListNew);
//	}
//
//	@Test
//	void testGetDocWorkListNew8() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(mock(CommonDoctorServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Invalid request, either ProviderServiceMapID or ServiceID is"
//						+ " invalid\",\"status\":\"Invalid request, either ProviderServiceMapID or ServiceID is invalid\"}",
//				commonController.getDocWorkListNew(null, 1, 1));
//	}
//
//	@Test
//	void testGetDocWorkListNew9() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(mock(CommonDoctorServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Invalid request, either ProviderServiceMapID or ServiceID is"
//						+ " invalid\",\"status\":\"Invalid request, either ProviderServiceMapID or ServiceID is invalid\"}",
//				commonController.getDocWorkListNew(1, null, 1));
//	}
//
//	@Test
//	void testGetDocWorkListNewFutureScheduledForTM() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Error while getting doctor worklist for future scheduled"
//				+ " beneficiay\",\"status\":\"Error while getting doctor worklist for future scheduled beneficiay\"}",
//				(new CommonController()).getDocWorkListNewFutureScheduledForTM(1, 1));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Invalid request, either ProviderServiceMapID or ServiceID is"
//						+ " invalid\",\"status\":\"Invalid request, either ProviderServiceMapID or ServiceID is invalid\"}",
//				(new CommonController()).getDocWorkListNewFutureScheduledForTM(null, null));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Invalid request, either ProviderServiceMapID or ServiceID is"
//						+ " invalid\",\"status\":\"Invalid request, either ProviderServiceMapID or ServiceID is invalid\"}",
//				(new CommonController()).getDocWorkListNewFutureScheduledForTM(1, null));
//	}
//
//	@Test
//	void testGetDocWorkListNewFutureScheduledForTM2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(new CommonDoctorServiceImpl());
//
//		// Act and Assert
//		assertEquals("{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				commonController.getDocWorkListNewFutureScheduledForTM(1, 1));
//	}
//
//	@Test
//	void testGetDocWorkListNewFutureScheduledForTM3() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonDoctorServiceImpl commonDoctorServiceImpl = mock(CommonDoctorServiceImpl.class);
//		when(commonDoctorServiceImpl.getDocWorkListNewFutureScheduledForTM(Mockito.<Integer>any(),
//				Mockito.<Integer>any())).thenReturn("Doc Work List New Future Scheduled For TM");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(commonDoctorServiceImpl);
//
//		// Act
//		String actualDocWorkListNewFutureScheduledForTM = commonController.getDocWorkListNewFutureScheduledForTM(1, 1);
//
//		// Assert
//		verify(commonDoctorServiceImpl).getDocWorkListNewFutureScheduledForTM(Mockito.<Integer>any(),
//				Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"Doc Work List New Future Scheduled For TM\"},\"statusCode\":200,\"errorMessage\":"
//						+ "\"Success\",\"status\":\"Success\"}",
//				actualDocWorkListNewFutureScheduledForTM);
//	}
//
//	@Test
//	void testGetDocWorkListNewFutureScheduledForTM4() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonDoctorServiceImpl commonDoctorServiceImpl = mock(CommonDoctorServiceImpl.class);
//		when(commonDoctorServiceImpl.getDocWorkListNewFutureScheduledForTM(Mockito.<Integer>any(),
//				Mockito.<Integer>any())).thenReturn("FAILURE");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(commonDoctorServiceImpl);
//
//		// Act
//		String actualDocWorkListNewFutureScheduledForTM = commonController.getDocWorkListNewFutureScheduledForTM(1, 1);
//
//		// Assert
//		verify(commonDoctorServiceImpl).getDocWorkListNewFutureScheduledForTM(Mockito.<Integer>any(),
//				Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"FAILURE\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualDocWorkListNewFutureScheduledForTM);
//	}
//
//	@Test
//	void testGetDocWorkListNewFutureScheduledForTM5() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonDoctorServiceImpl commonDoctorServiceImpl = mock(CommonDoctorServiceImpl.class);
//		when(commonDoctorServiceImpl.getDocWorkListNewFutureScheduledForTM(Mockito.<Integer>any(),
//				Mockito.<Integer>any())).thenReturn("{\"response\":\"$$STRING\"}");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(commonDoctorServiceImpl);
//
//		// Act
//		String actualDocWorkListNewFutureScheduledForTM = commonController.getDocWorkListNewFutureScheduledForTM(1, 1);
//
//		// Assert
//		verify(commonDoctorServiceImpl).getDocWorkListNewFutureScheduledForTM(Mockito.<Integer>any(),
//				Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualDocWorkListNewFutureScheduledForTM);
//	}
//
//	@Test
//	void testGetDocWorkListNewFutureScheduledForTM6() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonDoctorServiceImpl commonDoctorServiceImpl = mock(CommonDoctorServiceImpl.class);
//		when(commonDoctorServiceImpl.getDocWorkListNewFutureScheduledForTM(Mockito.<Integer>any(),
//				Mockito.<Integer>any())).thenReturn(null);
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(commonDoctorServiceImpl);
//
//		// Act
//		String actualDocWorkListNewFutureScheduledForTM = commonController.getDocWorkListNewFutureScheduledForTM(1, 1);
//
//		// Assert
//		verify(commonDoctorServiceImpl).getDocWorkListNewFutureScheduledForTM(Mockito.<Integer>any(),
//				Mockito.<Integer>any());
//		assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}",
//				actualDocWorkListNewFutureScheduledForTM);
//	}
//
//	@Test
//	void testGetDocWorkListNewFutureScheduledForTM7() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonDoctorServiceImpl commonDoctorServiceImpl = mock(CommonDoctorServiceImpl.class);
//		when(commonDoctorServiceImpl.getDocWorkListNewFutureScheduledForTM(Mockito.<Integer>any(),
//				Mockito.<Integer>any())).thenReturn("");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(commonDoctorServiceImpl);
//
//		// Act
//		String actualDocWorkListNewFutureScheduledForTM = commonController.getDocWorkListNewFutureScheduledForTM(1, 1);
//
//		// Assert
//		verify(commonDoctorServiceImpl).getDocWorkListNewFutureScheduledForTM(Mockito.<Integer>any(),
//				Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualDocWorkListNewFutureScheduledForTM);
//	}
//
//	@Test
//	void testGetNurseWorkListNew() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting nurse worklist\",\"status\":\"Error while getting"
//						+ " nurse worklist\"}",
//				(new CommonController()).getNurseWorkListNew(1, 1));
//	}
//
//	@Test
//	void testGetNurseWorkListNew2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(new CommonNurseServiceImpl());
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting nurse worklist\",\"status\":\"Error while getting"
//						+ " nurse worklist\"}",
//				commonController.getNurseWorkListNew(1, 1));
//	}
//
//	@Test
//	void testGetNurseWorkListNew3() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getNurseWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("Nurse Work List New");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualNurseWorkListNew = commonController.getNurseWorkListNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getNurseWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"Nurse Work List New\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":"
//						+ "\"Success\"}",
//				actualNurseWorkListNew);
//	}
//
//	@Test
//	void testGetNurseWorkListNew4() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getNurseWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("FAILURE");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualNurseWorkListNew = commonController.getNurseWorkListNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getNurseWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"FAILURE\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualNurseWorkListNew);
//	}
//	@Test
//	void testGetNurseWorkListNew5() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getNurseWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("{\"response\":\"$$STRING\"}");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualNurseWorkListNew = commonController.getNurseWorkListNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getNurseWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualNurseWorkListNew);
//	}
//
//	@Test
//	void testGetNurseWorkListNew6() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getNurseWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn(null);
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualNurseWorkListNew = commonController.getNurseWorkListNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getNurseWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting nurse worklist\",\"status\":\"Error while getting"
//						+ " nurse worklist\"}",
//				actualNurseWorkListNew);
//	}
//	@Test
//	void testGetNurseWorkListNew7() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getNurseWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn("");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualNurseWorkListNew = commonController.getNurseWorkListNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getNurseWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualNurseWorkListNew);
//	}
//	@Test
//	void testGetNurseWorkListNew8() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getNurseWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn(",");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualNurseWorkListNew = commonController.getNurseWorkListNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getNurseWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\",\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualNurseWorkListNew);
//	}
//
//	@Test
//	void testGetNurseWorklistTMreferred() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting nurse worklist\",\"status\":\"Error while getting"
//						+ " nurse worklist\"}",
//				(new CommonController()).getNurseWorklistTMreferred(1, 1));
//	}
//
//	@Test
//	void testGetNurseWorklistTMreferred2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(new CommonNurseServiceImpl());
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting nurse worklist\",\"status\":\"Error while getting"
//						+ " nurse worklist\"}",
//				commonController.getNurseWorklistTMreferred(1, 1));
//	}
//
//	@Test
//	void testGetNurseWorklistTMreferred3() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getNurseWorkListTMReferred(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("Nurse Work List TMReferred");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualNurseWorklistTMreferred = commonController.getNurseWorklistTMreferred(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getNurseWorkListTMReferred(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"Nurse Work List TMReferred\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\""
//						+ ":\"Success\"}",
//				actualNurseWorklistTMreferred);
//	}
//
//	@Test
//	void testGetNurseWorklistTMreferred4() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getNurseWorkListTMReferred(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("FAILURE");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualNurseWorklistTMreferred = commonController.getNurseWorklistTMreferred(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getNurseWorkListTMReferred(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"FAILURE\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualNurseWorklistTMreferred);
//	}
//
//	@Test
//	void testGetNurseWorklistTMreferred5() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getNurseWorkListTMReferred(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("{\"response\":\"$$STRING\"}");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualNurseWorklistTMreferred = commonController.getNurseWorklistTMreferred(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getNurseWorkListTMReferred(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualNurseWorklistTMreferred);
//	}
//
//	@Test
//	void testGetNurseWorklistTMreferred6() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getNurseWorkListTMReferred(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn(null);
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualNurseWorklistTMreferred = commonController.getNurseWorklistTMreferred(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getNurseWorkListTMReferred(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting nurse worklist\",\"status\":\"Error while getting"
//						+ " nurse worklist\"}",
//				actualNurseWorklistTMreferred);
//	}
//
//	@Test
//	void testGetNurseWorklistTMreferred7() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getNurseWorkListTMReferred(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualNurseWorklistTMreferred = commonController.getNurseWorklistTMreferred(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getNurseWorkListTMReferred(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualNurseWorklistTMreferred);
//	}
//
//	@Test
//	void testGetNurseWorklistTMreferred8() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getNurseWorkListTMReferred(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn(",");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualNurseWorklistTMreferred = commonController.getNurseWorklistTMreferred(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getNurseWorkListTMReferred(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\",\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualNurseWorklistTMreferred);
//	}
//
//	@Test
//	void testGetDoctorPreviousSignificantFindings() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting previous significant findings\",\"status\":\"Error"
//						+ " while getting previous significant findings\"}",
//				(new CommonController()).getDoctorPreviousSignificantFindings("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting previous significant findings\",\"status\":\"Error"
//						+ " while getting previous significant findings\"}",
//				(new CommonController()).getDoctorPreviousSignificantFindings(null));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting previous significant findings\",\"status\":\"Error"
//						+ " while getting previous significant findings\"}",
//				(new CommonController()).getDoctorPreviousSignificantFindings("﻿"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting previous significant findings\",\"status\":\"Error"
//						+ " while getting previous significant findings\"}",
//				(new CommonController()).getDoctorPreviousSignificantFindings("foo"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting previous significant findings\",\"status\":\"Error"
//						+ " while getting previous significant findings\"}",
//				(new CommonController()).getDoctorPreviousSignificantFindings("42"));
//	}
//
//	@Test
//	void testGetDoctorPreviousSignificantFindings2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting previous significant findings\",\"status\":\"Error"
//						+ " while getting previous significant findings\"}",
//				commonController.getDoctorPreviousSignificantFindings("Coming Request"));
//	}
//
//	@Test
//	void testGetLabWorkListNew() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting lab technician worklist\",\"status\":\"Error while"
//						+ " getting lab technician worklist\"}",
//				(new CommonController()).getLabWorkListNew(1, 1));
//	}
//
//	@Test
//	void testGetLabWorkListNew2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(new CommonNurseServiceImpl());
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting lab technician worklist\",\"status\":\"Error while"
//						+ " getting lab technician worklist\"}",
//				commonController.getLabWorkListNew(1, 1));
//	}
//	@Test
//	void testGetLabWorkListNew3() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getLabWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("Lab Work List New");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualLabWorkListNew = commonController.getLabWorkListNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getLabWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"Lab Work List New\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":"
//						+ "\"Success\"}",
//				actualLabWorkListNew);
//	}
//
//	@Test
//	void testGetLabWorkListNew4() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getLabWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("FAILURE");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualLabWorkListNew = commonController.getLabWorkListNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getLabWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"FAILURE\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualLabWorkListNew);
//	}
//
//	@Test
//	void testGetLabWorkListNew5() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getLabWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("{\"response\":\"$$STRING\"}");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualLabWorkListNew = commonController.getLabWorkListNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getLabWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualLabWorkListNew);
//	}
//
//	@Test
//	void testGetLabWorkListNew6() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getLabWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn(null);
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualLabWorkListNew = commonController.getLabWorkListNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getLabWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting lab technician worklist\",\"status\":\"Error while"
//						+ " getting lab technician worklist\"}",
//				actualLabWorkListNew);
//	}
//
//	@Test
//	void testGetLabWorkListNew7() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getLabWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn("");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualLabWorkListNew = commonController.getLabWorkListNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getLabWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualLabWorkListNew);
//	}
//
//	@Test
//	void testGetLabWorkListNew8() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getLabWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn(",");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualLabWorkListNew = commonController.getLabWorkListNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getLabWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\",\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualLabWorkListNew);
//	}
//
//	@Test
//	void testGetRadiologistWorklistNew() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting radiologist worklist\",\"status\":\"Error while"
//						+ " getting radiologist worklist\"}",
//				(new CommonController()).getRadiologistWorklistNew(1, 1));
//	}
//
//	@Test
//	void testGetRadiologistWorklistNew2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(new CommonNurseServiceImpl());
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting radiologist worklist\",\"status\":\"Error while"
//						+ " getting radiologist worklist\"}",
//				commonController.getRadiologistWorklistNew(1, 1));
//	}
//
//	@Test
//	void testGetRadiologistWorklistNew3() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getRadiologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("Radiologist Work List New");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualRadiologistWorklistNew = commonController.getRadiologistWorklistNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getRadiologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"Radiologist Work List New\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":"
//						+ "\"Success\"}",
//				actualRadiologistWorklistNew);
//	}
//
//	@Test
//	void testGetRadiologistWorklistNew4() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getRadiologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("FAILURE");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualRadiologistWorklistNew = commonController.getRadiologistWorklistNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getRadiologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"FAILURE\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualRadiologistWorklistNew);
//	}
//
//	@Test
//	void testGetRadiologistWorklistNew5() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getRadiologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("{\"response\":\"$$STRING\"}");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualRadiologistWorklistNew = commonController.getRadiologistWorklistNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getRadiologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualRadiologistWorklistNew);
//	}
//
//	@Test
//	void testGetRadiologistWorklistNew6() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getRadiologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn(null);
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualRadiologistWorklistNew = commonController.getRadiologistWorklistNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getRadiologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting radiologist worklist\",\"status\":\"Error while"
//						+ " getting radiologist worklist\"}",
//				actualRadiologistWorklistNew);
//	}
//
//	@Test
//	void testGetRadiologistWorklistNew7() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getRadiologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualRadiologistWorklistNew = commonController.getRadiologistWorklistNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getRadiologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualRadiologistWorklistNew);
//	}
//
//	@Test
//	void testGetRadiologistWorklistNew8() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getRadiologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn(",");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualRadiologistWorklistNew = commonController.getRadiologistWorklistNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getRadiologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\",\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualRadiologistWorklistNew);
//	}
//
//	@Test
//	void testGetOncologistWorklistNew() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting oncologist worklist\",\"status\":\"Error while"
//						+ " getting oncologist worklist\"}",
//				(new CommonController()).getOncologistWorklistNew(1, 1));
//	}
//
//	@Test
//	void testGetOncologistWorklistNew2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(new CommonNurseServiceImpl());
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting oncologist worklist\",\"status\":\"Error while"
//						+ " getting oncologist worklist\"}",
//				commonController.getOncologistWorklistNew(1, 1));
//	}
//
//	@Test
//	void testGetOncologistWorklistNew3() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getOncologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("Oncologist Work List New");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualOncologistWorklistNew = commonController.getOncologistWorklistNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getOncologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"Oncologist Work List New\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":"
//						+ "\"Success\"}",
//				actualOncologistWorklistNew);
//	}
//
//	@Test
//	void testGetOncologistWorklistNew4() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getOncologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("FAILURE");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualOncologistWorklistNew = commonController.getOncologistWorklistNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getOncologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"FAILURE\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualOncologistWorklistNew);
//	}
//
//	@Test
//	void testGetOncologistWorklistNew5() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getOncologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("{\"response\":\"$$STRING\"}");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualOncologistWorklistNew = commonController.getOncologistWorklistNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getOncologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualOncologistWorklistNew);
//	}
//
//	@Test
//	void testGetOncologistWorklistNew6() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getOncologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn(null);
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualOncologistWorklistNew = commonController.getOncologistWorklistNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getOncologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting oncologist worklist\",\"status\":\"Error while"
//						+ " getting oncologist worklist\"}",
//				actualOncologistWorklistNew);
//	}
//
//	@Test
//	void testGetOncologistWorklistNew7() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getOncologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualOncologistWorklistNew = commonController.getOncologistWorklistNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getOncologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualOncologistWorklistNew);
//	}
//
//	@Test
//	void testGetOncologistWorklistNew8() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getOncologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn(",");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualOncologistWorklistNew = commonController.getOncologistWorklistNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getOncologistWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\",\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualOncologistWorklistNew);
//	}
//
//	@Test
//	void testGetPharmaWorklistNew() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting pharma worklist\",\"status\":\"Error while getting"
//						+ " pharma worklist\"}",
//				(new CommonController()).getPharmaWorklistNew(1, 1));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getPharmaWorklistNew(Integer, Integer)}
//	 */
//	@Test
//	void testGetPharmaWorklistNew2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(new CommonNurseServiceImpl());
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting pharma worklist\",\"status\":\"Error while getting"
//						+ " pharma worklist\"}",
//				commonController.getPharmaWorklistNew(1, 1));
//	}
//
//	@Test
//	void testGetPharmaWorklistNew3() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getPharmaWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("Pharma Work List New");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualPharmaWorklistNew = commonController.getPharmaWorklistNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getPharmaWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"Pharma Work List New\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":"
//						+ "\"Success\"}",
//				actualPharmaWorklistNew);
//	}
//
//	@Test
//	void testGetPharmaWorklistNew4() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getPharmaWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("FAILURE");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualPharmaWorklistNew = commonController.getPharmaWorklistNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getPharmaWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"FAILURE\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualPharmaWorklistNew);
//	}
//
//	@Test
//	void testGetPharmaWorklistNew5() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getPharmaWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("{\"response\":\"$$STRING\"}");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualPharmaWorklistNew = commonController.getPharmaWorklistNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getPharmaWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualPharmaWorklistNew);
//	}
//
//	@Test
//	void testGetPharmaWorklistNew6() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getPharmaWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn(null);
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualPharmaWorklistNew = commonController.getPharmaWorklistNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getPharmaWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting pharma worklist\",\"status\":\"Error while getting"
//						+ " pharma worklist\"}",
//				actualPharmaWorklistNew);
//	}
//
//	@Test
//	void testGetPharmaWorklistNew7() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getPharmaWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualPharmaWorklistNew = commonController.getPharmaWorklistNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getPharmaWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualPharmaWorklistNew);
//	}
//
//	@Test
//	void testGetPharmaWorklistNew8() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.getPharmaWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn(",");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualPharmaWorklistNew = commonController.getPharmaWorklistNew(1, 1);
//
//		// Assert
//		verify(commonNurseServiceImpl).getPharmaWorkListNew(Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\",\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualPharmaWorklistNew);
//	}
//
//	@Test
//	void testGetCasesheetPrintData() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}",
//				(new CommonController()).getCasesheetPrintData("Coming Req", "JaneDoe"));
//		assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Invalid request\",\"status\":\"Invalid request\"}",
//				(new CommonController()).getCasesheetPrintData(null, "foo"));
//		assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}",
//				(new CommonController()).getCasesheetPrintData("", "JaneDoe"));
//	}
//
//	@Test
//	void testGetCasesheetPrintData2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(new CommonServiceImpl());
//
//		// Act and Assert
//		assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}",
//				commonController.getCasesheetPrintData("", "JaneDoe"));
//	}
//	@Test
//	void testGetCasesheetPrintData3() throws Exception {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonServiceImpl commonServiceImpl = mock(CommonServiceImpl.class);
//		when(commonServiceImpl.getCaseSheetPrintDataForBeneficiary(Mockito.<BeneficiaryFlowStatus>any(),
//				Mockito.<String>any())).thenReturn("Case Sheet Print Data For Beneficiary");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(commonServiceImpl);
//
//		// Act
//		String actualCasesheetPrintData = commonController.getCasesheetPrintData("", "JaneDoe");
//
//		// Assert
//		verify(commonServiceImpl).getCaseSheetPrintDataForBeneficiary(Mockito.<BeneficiaryFlowStatus>any(),
//				eq("JaneDoe"));
//		assertEquals(
//				"{\"data\":{\"response\":\"Case Sheet Print Data For Beneficiary\"},\"statusCode\":200,\"errorMessage\":\"Success"
//						+ "\",\"status\":\"Success\"}",
//				actualCasesheetPrintData);
//	}
//
//	@Test
//	void testGetCasesheetPrintData4() throws Exception {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonServiceImpl commonServiceImpl = mock(CommonServiceImpl.class);
//		when(commonServiceImpl.getCaseSheetPrintDataForBeneficiary(Mockito.<BeneficiaryFlowStatus>any(),
//				Mockito.<String>any())).thenReturn("FAILURE");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(commonServiceImpl);
//
//		// Act
//		String actualCasesheetPrintData = commonController.getCasesheetPrintData("", "JaneDoe");
//
//		// Assert
//		verify(commonServiceImpl).getCaseSheetPrintDataForBeneficiary(Mockito.<BeneficiaryFlowStatus>any(),
//				eq("JaneDoe"));
//		assertEquals(
//				"{\"data\":{\"response\":\"FAILURE\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualCasesheetPrintData);
//	}
//
//	@Test
//	void testGetCasesheetPrintData5() throws Exception {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonServiceImpl commonServiceImpl = mock(CommonServiceImpl.class);
//		when(commonServiceImpl.getCaseSheetPrintDataForBeneficiary(Mockito.<BeneficiaryFlowStatus>any(),
//				Mockito.<String>any())).thenReturn("{\"response\":\"$$STRING\"}");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(commonServiceImpl);
//
//		// Act
//		String actualCasesheetPrintData = commonController.getCasesheetPrintData("", "JaneDoe");
//
//		// Assert
//		verify(commonServiceImpl).getCaseSheetPrintDataForBeneficiary(Mockito.<BeneficiaryFlowStatus>any(),
//				eq("JaneDoe"));
//		assertEquals(
//				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualCasesheetPrintData);
//	}
//
//	@Test
//	void testGetCasesheetPrintData6() throws Exception {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonServiceImpl commonServiceImpl = mock(CommonServiceImpl.class);
//		when(commonServiceImpl.getCaseSheetPrintDataForBeneficiary(Mockito.<BeneficiaryFlowStatus>any(),
//				Mockito.<String>any())).thenReturn(null);
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(commonServiceImpl);
//
//		// Act
//		String actualCasesheetPrintData = commonController.getCasesheetPrintData("", "JaneDoe");
//
//		// Assert
//		verify(commonServiceImpl).getCaseSheetPrintDataForBeneficiary(Mockito.<BeneficiaryFlowStatus>any(),
//				eq("JaneDoe"));
//		assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}",
//				actualCasesheetPrintData);
//	}
//
//	@Test
//	void testGetCasesheetPrintData7() throws Exception {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonServiceImpl commonServiceImpl = mock(CommonServiceImpl.class);
//		when(commonServiceImpl.getCaseSheetPrintDataForBeneficiary(Mockito.<BeneficiaryFlowStatus>any(),
//				Mockito.<String>any())).thenReturn("");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(commonServiceImpl);
//
//		// Act
//		String actualCasesheetPrintData = commonController.getCasesheetPrintData("", "JaneDoe");
//
//		// Assert
//		verify(commonServiceImpl).getCaseSheetPrintDataForBeneficiary(Mockito.<BeneficiaryFlowStatus>any(),
//				eq("JaneDoe"));
//		assertEquals(
//				"{\"data\":{\"response\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualCasesheetPrintData);
//	}
//
//	@Test
//	void testGetCasesheetPrintData8() throws Exception {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonServiceImpl commonServiceImpl = mock(CommonServiceImpl.class);
//		when(commonServiceImpl.getCaseSheetPrintDataForBeneficiary(Mockito.<BeneficiaryFlowStatus>any(),
//				Mockito.<String>any())).thenReturn("Case Sheet Print Data For Beneficiary");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(commonServiceImpl);
//
//		// Act
//		String actualCasesheetPrintData = commonController.getCasesheetPrintData("{\"response\":\"$$STRING\"}",
//				"JaneDoe");
//
//		// Assert
//		verify(commonServiceImpl).getCaseSheetPrintDataForBeneficiary(Mockito.<BeneficiaryFlowStatus>any(),
//				eq("JaneDoe"));
//		assertEquals(
//				"{\"data\":{\"response\":\"Case Sheet Print Data For Beneficiary\"},\"statusCode\":200,\"errorMessage\":\"Success"
//						+ "\",\"status\":\"Success\"}",
//				actualCasesheetPrintData);
//	}
//
//	@Test
//	void testGetBenPastHistory() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting illness and surgery history\",\"status\":\"Error"
//						+ " while getting illness and surgery history\"}",
//				(new CommonController()).getBenPastHistory("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting illness and surgery history\",\"status\":\"Error"
//						+ " while getting illness and surgery history\"}",
//				(new CommonController()).getBenPastHistory(null));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting illness and surgery history\",\"status\":\"Error"
//						+ " while getting illness and surgery history\"}",
//				(new CommonController()).getBenPastHistory("﻿"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting illness and surgery history\",\"status\":\"Error"
//						+ " while getting illness and surgery history\"}",
//				(new CommonController()).getBenPastHistory("foo"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting illness and surgery history\",\"status\":\"Error"
//						+ " while getting illness and surgery history\"}",
//				(new CommonController()).getBenPastHistory("42"));
//	}
//
//	@Test
//	void testGetBenPastHistory2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting illness and surgery history\",\"status\":\"Error"
//						+ " while getting illness and surgery history\"}",
//				commonController.getBenPastHistory("Coming Request"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenTobaccoHistory(String)}
//	 */
//	@Test
//	void testGetBenTobaccoHistory() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting tobacco history\",\"status\":\"Error while getting"
//						+ " tobacco history\"}",
//				(new CommonController()).getBenTobaccoHistory("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting tobacco history\",\"status\":\"Error while getting"
//						+ " tobacco history\"}",
//				(new CommonController()).getBenTobaccoHistory(null));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting tobacco history\",\"status\":\"Error while getting"
//						+ " tobacco history\"}",
//				(new CommonController()).getBenTobaccoHistory("﻿"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting tobacco history\",\"status\":\"Error while getting"
//						+ " tobacco history\"}",
//				(new CommonController()).getBenTobaccoHistory("foo"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting tobacco history\",\"status\":\"Error while getting"
//						+ " tobacco history\"}",
//				(new CommonController()).getBenTobaccoHistory("42"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenTobaccoHistory(String)}
//	 */
//	@Test
//	void testGetBenTobaccoHistory2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting tobacco history\",\"status\":\"Error while getting"
//						+ " tobacco history\"}",
//				commonController.getBenTobaccoHistory("Coming Request"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenAlcoholHistory(String)}
//	 */
//	@Test
//	void testGetBenAlcoholHistory() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting alcohol history\",\"status\":\"Error while getting"
//						+ " alcohol history\"}",
//				(new CommonController()).getBenAlcoholHistory("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting alcohol history\",\"status\":\"Error while getting"
//						+ " alcohol history\"}",
//				(new CommonController()).getBenAlcoholHistory(null));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting alcohol history\",\"status\":\"Error while getting"
//						+ " alcohol history\"}",
//				(new CommonController()).getBenAlcoholHistory("﻿"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting alcohol history\",\"status\":\"Error while getting"
//						+ " alcohol history\"}",
//				(new CommonController()).getBenAlcoholHistory("foo"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting alcohol history\",\"status\":\"Error while getting"
//						+ " alcohol history\"}",
//				(new CommonController()).getBenAlcoholHistory("42"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenAlcoholHistory(String)}
//	 */
//	@Test
//	void testGetBenAlcoholHistory2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting alcohol history\",\"status\":\"Error while getting"
//						+ " alcohol history\"}",
//				commonController.getBenAlcoholHistory("Coming Request"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenANCAllergyHistory(String)}
//	 */
//	@Test
//	void testGetBenANCAllergyHistory() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting allergy history\",\"status\":\"Error while getting"
//						+ " allergy history\"}",
//				(new CommonController()).getBenANCAllergyHistory("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting allergy history\",\"status\":\"Error while getting"
//						+ " allergy history\"}",
//				(new CommonController()).getBenANCAllergyHistory(null));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting allergy history\",\"status\":\"Error while getting"
//						+ " allergy history\"}",
//				(new CommonController()).getBenANCAllergyHistory("﻿"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting allergy history\",\"status\":\"Error while getting"
//						+ " allergy history\"}",
//				(new CommonController()).getBenANCAllergyHistory("foo"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting allergy history\",\"status\":\"Error while getting"
//						+ " allergy history\"}",
//				(new CommonController()).getBenANCAllergyHistory("42"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenANCAllergyHistory(String)}
//	 */
//	@Test
//	void testGetBenANCAllergyHistory2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting allergy history\",\"status\":\"Error while getting"
//						+ " allergy history\"}",
//				commonController.getBenANCAllergyHistory("Coming Request"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenMedicationHistory(String)}
//	 */
//	@Test
//	void testGetBenMedicationHistory() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting medication history\",\"status\":\"Error while getting"
//						+ " medication history\"}",
//				(new CommonController()).getBenMedicationHistory("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting medication history\",\"status\":\"Error while getting"
//						+ " medication history\"}",
//				(new CommonController()).getBenMedicationHistory(null));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting medication history\",\"status\":\"Error while getting"
//						+ " medication history\"}",
//				(new CommonController()).getBenMedicationHistory("﻿"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting medication history\",\"status\":\"Error while getting"
//						+ " medication history\"}",
//				(new CommonController()).getBenMedicationHistory("foo"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting medication history\",\"status\":\"Error while getting"
//						+ " medication history\"}",
//				(new CommonController()).getBenMedicationHistory("42"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenMedicationHistory(String)}
//	 */
//	@Test
//	void testGetBenMedicationHistory2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting medication history\",\"status\":\"Error while getting"
//						+ " medication history\"}",
//				commonController.getBenMedicationHistory("Coming Request"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenFamilyHistory(String)}
//	 */
//	@Test
//	void testGetBenFamilyHistory() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting family history\",\"status\":\"Error while getting"
//						+ " family history\"}",
//				(new CommonController()).getBenFamilyHistory("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting family history\",\"status\":\"Error while getting"
//						+ " family history\"}",
//				(new CommonController()).getBenFamilyHistory(null));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting family history\",\"status\":\"Error while getting"
//						+ " family history\"}",
//				(new CommonController()).getBenFamilyHistory("﻿"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting family history\",\"status\":\"Error while getting"
//						+ " family history\"}",
//				(new CommonController()).getBenFamilyHistory("foo"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting family history\",\"status\":\"Error while getting"
//						+ " family history\"}",
//				(new CommonController()).getBenFamilyHistory("42"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenFamilyHistory(String)}
//	 */
//	@Test
//	void testGetBenFamilyHistory2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting family history\",\"status\":\"Error while getting"
//						+ " family history\"}",
//				commonController.getBenFamilyHistory("Coming Request"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenMenstrualHistory(String)}
//	 */
//	@Test
//	void testGetBenMenstrualHistory() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting menstrual history\",\"status\":\"Error while getting"
//						+ " menstrual history\"}",
//				(new CommonController()).getBenMenstrualHistory("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting menstrual history\",\"status\":\"Error while getting"
//						+ " menstrual history\"}",
//				(new CommonController()).getBenMenstrualHistory(null));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting menstrual history\",\"status\":\"Error while getting"
//						+ " menstrual history\"}",
//				(new CommonController()).getBenMenstrualHistory("﻿"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting menstrual history\",\"status\":\"Error while getting"
//						+ " menstrual history\"}",
//				(new CommonController()).getBenMenstrualHistory("foo"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting menstrual history\",\"status\":\"Error while getting"
//						+ " menstrual history\"}",
//				(new CommonController()).getBenMenstrualHistory("42"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenMenstrualHistory(String)}
//	 */
//	@Test
//	void testGetBenMenstrualHistory2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting menstrual history\",\"status\":\"Error while getting"
//						+ " menstrual history\"}",
//				commonController.getBenMenstrualHistory("Coming Request"));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getBenPastObstetricHistory(String)}
//	 */
//	@Test
//	void testGetBenPastObstetricHistory() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting obstetric history\",\"status\":\"Error while getting"
//						+ " obstetric history\"}",
//				(new CommonController()).getBenPastObstetricHistory("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting obstetric history\",\"status\":\"Error while getting"
//						+ " obstetric history\"}",
//				(new CommonController()).getBenPastObstetricHistory(null));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting obstetric history\",\"status\":\"Error while getting"
//						+ " obstetric history\"}",
//				(new CommonController()).getBenPastObstetricHistory("﻿"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting obstetric history\",\"status\":\"Error while getting"
//						+ " obstetric history\"}",
//				(new CommonController()).getBenPastObstetricHistory("foo"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting obstetric history\",\"status\":\"Error while getting"
//						+ " obstetric history\"}",
//				(new CommonController()).getBenPastObstetricHistory("42"));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getBenPastObstetricHistory(String)}
//	 */
//	@Test
//	void testGetBenPastObstetricHistory2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting obstetric history\",\"status\":\"Error while getting"
//						+ " obstetric history\"}",
//				commonController.getBenPastObstetricHistory("Coming Request"));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getBenANCComorbidityConditionHistory(String)}
//	 */
//	@Test
//	void testGetBenANCComorbidityConditionHistory() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting comodbidity history\",\"status\":\"Error while"
//						+ " getting comodbidity history\"}",
//				(new CommonController()).getBenANCComorbidityConditionHistory("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting comodbidity history\",\"status\":\"Error while"
//						+ " getting comodbidity history\"}",
//				(new CommonController()).getBenANCComorbidityConditionHistory(null));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting comodbidity history\",\"status\":\"Error while"
//						+ " getting comodbidity history\"}",
//				(new CommonController()).getBenANCComorbidityConditionHistory("﻿"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting comodbidity history\",\"status\":\"Error while"
//						+ " getting comodbidity history\"}",
//				(new CommonController()).getBenANCComorbidityConditionHistory("foo"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting comodbidity history\",\"status\":\"Error while"
//						+ " getting comodbidity history\"}",
//				(new CommonController()).getBenANCComorbidityConditionHistory("42"));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getBenANCComorbidityConditionHistory(String)}
//	 */
//	@Test
//	void testGetBenANCComorbidityConditionHistory2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting comodbidity history\",\"status\":\"Error while"
//						+ " getting comodbidity history\"}",
//				commonController.getBenANCComorbidityConditionHistory("Coming Request"));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getBenOptionalVaccineHistory(String)}
//	 */
//	@Test
//	void testGetBenOptionalVaccineHistory() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting optional vaccination history\",\"status\":\"Error"
//						+ " while getting optional vaccination history\"}",
//				(new CommonController()).getBenOptionalVaccineHistory("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting optional vaccination history\",\"status\":\"Error"
//						+ " while getting optional vaccination history\"}",
//				(new CommonController()).getBenOptionalVaccineHistory(null));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting optional vaccination history\",\"status\":\"Error"
//						+ " while getting optional vaccination history\"}",
//				(new CommonController()).getBenOptionalVaccineHistory("﻿"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting optional vaccination history\",\"status\":\"Error"
//						+ " while getting optional vaccination history\"}",
//				(new CommonController()).getBenOptionalVaccineHistory("foo"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting optional vaccination history\",\"status\":\"Error"
//						+ " while getting optional vaccination history\"}",
//				(new CommonController()).getBenOptionalVaccineHistory("42"));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getBenOptionalVaccineHistory(String)}
//	 */
//	@Test
//	void testGetBenOptionalVaccineHistory2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting optional vaccination history\",\"status\":\"Error"
//						+ " while getting optional vaccination history\"}",
//				commonController.getBenOptionalVaccineHistory("Coming Request"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenImmunizationHistory(String)}
//	 */
//	@Test
//	void testGetBenImmunizationHistory() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting child vaccine(immunization) history\",\"status\":\"Error"
//						+ " while getting child vaccine(immunization) history\"}",
//				(new CommonController()).getBenImmunizationHistory("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting child vaccine(immunization) history\",\"status\":\"Error"
//						+ " while getting child vaccine(immunization) history\"}",
//				(new CommonController()).getBenImmunizationHistory(null));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting child vaccine(immunization) history\",\"status\":\"Error"
//						+ " while getting child vaccine(immunization) history\"}",
//				(new CommonController()).getBenImmunizationHistory("﻿"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting child vaccine(immunization) history\",\"status\":\"Error"
//						+ " while getting child vaccine(immunization) history\"}",
//				(new CommonController()).getBenImmunizationHistory("foo"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting child vaccine(immunization) history\",\"status\":\"Error"
//						+ " while getting child vaccine(immunization) history\"}",
//				(new CommonController()).getBenImmunizationHistory("42"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenImmunizationHistory(String)}
//	 */
//	@Test
//	void testGetBenImmunizationHistory2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting child vaccine(immunization) history\",\"status\":\"Error"
//						+ " while getting child vaccine(immunization) history\"}",
//				commonController.getBenImmunizationHistory("Coming Request"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenPerinatalHistory(String)}
//	 */
//	@Test
//	void testGetBenPerinatalHistory() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting perinatal history\",\"status\":\"Error while getting"
//						+ " perinatal history\"}",
//				(new CommonController()).getBenPerinatalHistory("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting perinatal history\",\"status\":\"Error while getting"
//						+ " perinatal history\"}",
//				(new CommonController()).getBenPerinatalHistory(null));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting perinatal history\",\"status\":\"Error while getting"
//						+ " perinatal history\"}",
//				(new CommonController()).getBenPerinatalHistory("﻿"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting perinatal history\",\"status\":\"Error while getting"
//						+ " perinatal history\"}",
//				(new CommonController()).getBenPerinatalHistory("foo"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting perinatal history\",\"status\":\"Error while getting"
//						+ " perinatal history\"}",
//				(new CommonController()).getBenPerinatalHistory("42"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenPerinatalHistory(String)}
//	 */
//	@Test
//	void testGetBenPerinatalHistory2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting perinatal history\",\"status\":\"Error while getting"
//						+ " perinatal history\"}",
//				commonController.getBenPerinatalHistory("Coming Request"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenFeedingHistory(String)}
//	 */
//	@Test
//	void testGetBenFeedingHistory() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting child feeding history\",\"status\":\"Error while"
//						+ " getting child feeding history\"}",
//				(new CommonController()).getBenFeedingHistory("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting child feeding history\",\"status\":\"Error while"
//						+ " getting child feeding history\"}",
//				(new CommonController()).getBenFeedingHistory(null));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting child feeding history\",\"status\":\"Error while"
//						+ " getting child feeding history\"}",
//				(new CommonController()).getBenFeedingHistory("﻿"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting child feeding history\",\"status\":\"Error while"
//						+ " getting child feeding history\"}",
//				(new CommonController()).getBenFeedingHistory("foo"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting child feeding history\",\"status\":\"Error while"
//						+ " getting child feeding history\"}",
//				(new CommonController()).getBenFeedingHistory("42"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenFeedingHistory(String)}
//	 */
//	@Test
//	void testGetBenFeedingHistory2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting child feeding history\",\"status\":\"Error while"
//						+ " getting child feeding history\"}",
//				commonController.getBenFeedingHistory("Coming Request"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenDevelopmentHistory(String)}
//	 */
//	@Test
//	void testGetBenDevelopmentHistory() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting child development history\",\"status\":\"Error while"
//						+ " getting child development history\"}",
//				(new CommonController()).getBenDevelopmentHistory("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting child development history\",\"status\":\"Error while"
//						+ " getting child development history\"}",
//				(new CommonController()).getBenDevelopmentHistory(null));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting child development history\",\"status\":\"Error while"
//						+ " getting child development history\"}",
//				(new CommonController()).getBenDevelopmentHistory("﻿"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting child development history\",\"status\":\"Error while"
//						+ " getting child development history\"}",
//				(new CommonController()).getBenDevelopmentHistory("foo"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting child development history\",\"status\":\"Error while"
//						+ " getting child development history\"}",
//				(new CommonController()).getBenDevelopmentHistory("42"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenDevelopmentHistory(String)}
//	 */
//	@Test
//	void testGetBenDevelopmentHistory2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting child development history\",\"status\":\"Error while"
//						+ " getting child development history\"}",
//				commonController.getBenDevelopmentHistory("Coming Request"));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getBeneficiaryCaseSheetHistory(String)}
//	 */
//	@Test
//	void testGetBeneficiaryCaseSheetHistory() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while fetching beneficiary previous visit history details\","
//						+ "\"status\":\"Error while fetching beneficiary previous visit history details\"}",
//				(new CommonController()).getBeneficiaryCaseSheetHistory("Coming Request"));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getBeneficiaryCaseSheetHistory(String)}
//	 */
//	@Test
//	void testGetBeneficiaryCaseSheetHistory2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(new CommonServiceImpl());
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while fetching beneficiary previous visit history details\","
//						+ "\"status\":\"Error while fetching beneficiary previous visit history details\"}",
//				commonController.getBeneficiaryCaseSheetHistory("Coming Request"));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getBeneficiaryCaseSheetHistory(String)}
//	 */
//	@Test
//	void testGetBeneficiaryCaseSheetHistory3() throws IEMRException {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonServiceImpl commonServiceImpl = mock(CommonServiceImpl.class);
//		when(commonServiceImpl.getBenPreviousVisitDataForCaseRecord(Mockito.<String>any()))
//				.thenReturn("Ben Previous Visit Data For Case Record");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(commonServiceImpl);
//
//		// Act
//		String actualBeneficiaryCaseSheetHistory = commonController.getBeneficiaryCaseSheetHistory("Coming Request");
//
//		// Assert
//		verify(commonServiceImpl).getBenPreviousVisitDataForCaseRecord(eq("Coming Request"));
//		assertEquals(
//				"{\"data\":{\"response\":\"Ben Previous Visit Data For Case Record\"},\"statusCode\":200,\"errorMessage\":\"Success"
//						+ "\",\"status\":\"Success\"}",
//				actualBeneficiaryCaseSheetHistory);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getBeneficiaryCaseSheetHistory(String)}
//	 */
//	@Test
//	void testGetBeneficiaryCaseSheetHistory4() throws IEMRException {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonServiceImpl commonServiceImpl = mock(CommonServiceImpl.class);
//		when(commonServiceImpl.getBenPreviousVisitDataForCaseRecord(Mockito.<String>any())).thenReturn("FAILURE");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(commonServiceImpl);
//
//		// Act
//		String actualBeneficiaryCaseSheetHistory = commonController.getBeneficiaryCaseSheetHistory("Coming Request");
//
//		// Assert
//		verify(commonServiceImpl).getBenPreviousVisitDataForCaseRecord(eq("Coming Request"));
//		assertEquals(
//				"{\"data\":{\"response\":\"FAILURE\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualBeneficiaryCaseSheetHistory);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getBeneficiaryCaseSheetHistory(String)}
//	 */
//	@Test
//	void testGetBeneficiaryCaseSheetHistory5() throws IEMRException {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonServiceImpl commonServiceImpl = mock(CommonServiceImpl.class);
//		when(commonServiceImpl.getBenPreviousVisitDataForCaseRecord(Mockito.<String>any()))
//				.thenReturn("{\"response\":\"$$STRING\"}");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(commonServiceImpl);
//
//		// Act
//		String actualBeneficiaryCaseSheetHistory = commonController.getBeneficiaryCaseSheetHistory("Coming Request");
//
//		// Assert
//		verify(commonServiceImpl).getBenPreviousVisitDataForCaseRecord(eq("Coming Request"));
//		assertEquals(
//				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualBeneficiaryCaseSheetHistory);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getBeneficiaryCaseSheetHistory(String)}
//	 */
//	@Test
//	void testGetBeneficiaryCaseSheetHistory6() throws IEMRException {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonServiceImpl commonServiceImpl = mock(CommonServiceImpl.class);
//		when(commonServiceImpl.getBenPreviousVisitDataForCaseRecord(Mockito.<String>any())).thenReturn(null);
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(commonServiceImpl);
//
//		// Act
//		String actualBeneficiaryCaseSheetHistory = commonController.getBeneficiaryCaseSheetHistory("Coming Request");
//
//		// Assert
//		verify(commonServiceImpl).getBenPreviousVisitDataForCaseRecord(eq("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while fetching beneficiary previous visit history details\","
//						+ "\"status\":\"Error while fetching beneficiary previous visit history details\"}",
//				actualBeneficiaryCaseSheetHistory);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getBeneficiaryCaseSheetHistory(String)}
//	 */
//	@Test
//	void testGetBeneficiaryCaseSheetHistory7() throws IEMRException {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonServiceImpl commonServiceImpl = mock(CommonServiceImpl.class);
//		when(commonServiceImpl.getBenPreviousVisitDataForCaseRecord(Mockito.<String>any())).thenReturn("");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(commonServiceImpl);
//
//		// Act
//		String actualBeneficiaryCaseSheetHistory = commonController.getBeneficiaryCaseSheetHistory("Coming Request");
//
//		// Assert
//		verify(commonServiceImpl).getBenPreviousVisitDataForCaseRecord(eq("Coming Request"));
//		assertEquals(
//				"{\"data\":{\"response\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualBeneficiaryCaseSheetHistory);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getBeneficiaryCaseSheetHistory(String)}
//	 */
//	@Test
//	void testGetBeneficiaryCaseSheetHistory8() throws IEMRException {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonServiceImpl commonServiceImpl = mock(CommonServiceImpl.class);
//		when(commonServiceImpl.getBenPreviousVisitDataForCaseRecord(Mockito.<String>any()))
//				.thenReturn("Failed with generic error{\"response\":\"$$STRING\"}");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(commonServiceImpl);
//
//		// Act
//		String actualBeneficiaryCaseSheetHistory = commonController.getBeneficiaryCaseSheetHistory("Coming Request");
//
//		// Assert
//		verify(commonServiceImpl).getBenPreviousVisitDataForCaseRecord(eq("Coming Request"));
//		assertEquals(
//				"{\"data\":\"Failed with generic error{\\\"response\\\":\\\"$$STRING\\\"}\",\"statusCode\":5000,\"errorMessage\":\"Error"
//						+ " while fetching beneficiary previous visit history details\",\"status\":\"Error while fetching beneficiary"
//						+ " previous visit history details\"}",
//				actualBeneficiaryCaseSheetHistory);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTCSpecialistWorkListNew(Integer, Integer, Integer)}
//	 */
//	@Test
//	void testGetTCSpecialistWorkListNew() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting TC specialist worklist\",\"status\":\"Error while"
//						+ " getting TC specialist worklist\"}",
//				(new CommonController()).getTCSpecialistWorkListNew(1, 1, 1));
//		assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Invalid request, either ProviderServiceMapID or userID is"
//				+ " invalid\",\"status\":\"Invalid request, either ProviderServiceMapID or userID is invalid\"}",
//				(new CommonController()).getTCSpecialistWorkListNew(null, null, null));
//		assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Invalid request, either ProviderServiceMapID or userID is"
//				+ " invalid\",\"status\":\"Invalid request, either ProviderServiceMapID or userID is invalid\"}",
//				(new CommonController()).getTCSpecialistWorkListNew(1, null, null));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTCSpecialistWorkListNew(Integer, Integer, Integer)}
//	 */
//	@Test
//	void testGetTCSpecialistWorkListNew2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(new CommonDoctorServiceImpl());
//
//		// Act and Assert
//		assertEquals("{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				commonController.getTCSpecialistWorkListNew(1, 1, 1));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTCSpecialistWorkListNew(Integer, Integer, Integer)}
//	 */
//	@Test
//	void testGetTCSpecialistWorkListNew3() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonDoctorServiceImpl commonDoctorServiceImpl = mock(CommonDoctorServiceImpl.class);
//		when(commonDoctorServiceImpl.getTCSpecialistWorkListNewForTM(Mockito.<Integer>any(), Mockito.<Integer>any(),
//				Mockito.<Integer>any())).thenReturn("Tc Specialist Work List New For TM");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(commonDoctorServiceImpl);
//
//		// Act
//		String actualTCSpecialistWorkListNew = commonController.getTCSpecialistWorkListNew(1, 1, 1);
//
//		// Assert
//		verify(commonDoctorServiceImpl).getTCSpecialistWorkListNewForTM(Mockito.<Integer>any(), Mockito.<Integer>any(),
//				Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"Tc Specialist Work List New For TM\"},\"statusCode\":200,\"errorMessage\":\"Success\","
//						+ "\"status\":\"Success\"}",
//				actualTCSpecialistWorkListNew);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTCSpecialistWorkListNew(Integer, Integer, Integer)}
//	 */
//	@Test
//	void testGetTCSpecialistWorkListNew4() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonDoctorServiceImpl commonDoctorServiceImpl = mock(CommonDoctorServiceImpl.class);
//		when(commonDoctorServiceImpl.getTCSpecialistWorkListNewForTM(Mockito.<Integer>any(), Mockito.<Integer>any(),
//				Mockito.<Integer>any())).thenReturn("FAILURE");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(commonDoctorServiceImpl);
//
//		// Act
//		String actualTCSpecialistWorkListNew = commonController.getTCSpecialistWorkListNew(1, 1, 1);
//
//		// Assert
//		verify(commonDoctorServiceImpl).getTCSpecialistWorkListNewForTM(Mockito.<Integer>any(), Mockito.<Integer>any(),
//				Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"FAILURE\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualTCSpecialistWorkListNew);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTCSpecialistWorkListNew(Integer, Integer, Integer)}
//	 */
//	@Test
//	void testGetTCSpecialistWorkListNew5() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonDoctorServiceImpl commonDoctorServiceImpl = mock(CommonDoctorServiceImpl.class);
//		when(commonDoctorServiceImpl.getTCSpecialistWorkListNewForTM(Mockito.<Integer>any(), Mockito.<Integer>any(),
//				Mockito.<Integer>any())).thenReturn("{\"response\":\"$$STRING\"}");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(commonDoctorServiceImpl);
//
//		// Act
//		String actualTCSpecialistWorkListNew = commonController.getTCSpecialistWorkListNew(1, 1, 1);
//
//		// Assert
//		verify(commonDoctorServiceImpl).getTCSpecialistWorkListNewForTM(Mockito.<Integer>any(), Mockito.<Integer>any(),
//				Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualTCSpecialistWorkListNew);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTCSpecialistWorkListNew(Integer, Integer, Integer)}
//	 */
//	@Test
//	void testGetTCSpecialistWorkListNew6() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonDoctorServiceImpl commonDoctorServiceImpl = mock(CommonDoctorServiceImpl.class);
//		when(commonDoctorServiceImpl.getTCSpecialistWorkListNewForTM(Mockito.<Integer>any(), Mockito.<Integer>any(),
//				Mockito.<Integer>any())).thenReturn(null);
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(commonDoctorServiceImpl);
//
//		// Act
//		String actualTCSpecialistWorkListNew = commonController.getTCSpecialistWorkListNew(1, 1, 1);
//
//		// Assert
//		verify(commonDoctorServiceImpl).getTCSpecialistWorkListNewForTM(Mockito.<Integer>any(), Mockito.<Integer>any(),
//				Mockito.<Integer>any());
//		assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}",
//				actualTCSpecialistWorkListNew);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTCSpecialistWorkListNew(Integer, Integer, Integer)}
//	 */
//	@Test
//	void testGetTCSpecialistWorkListNew7() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonDoctorServiceImpl commonDoctorServiceImpl = mock(CommonDoctorServiceImpl.class);
//		when(commonDoctorServiceImpl.getTCSpecialistWorkListNewForTM(Mockito.<Integer>any(), Mockito.<Integer>any(),
//				Mockito.<Integer>any())).thenReturn("");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(commonDoctorServiceImpl);
//
//		// Act
//		String actualTCSpecialistWorkListNew = commonController.getTCSpecialistWorkListNew(1, 1, 1);
//
//		// Assert
//		verify(commonDoctorServiceImpl).getTCSpecialistWorkListNewForTM(Mockito.<Integer>any(), Mockito.<Integer>any(),
//				Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualTCSpecialistWorkListNew);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTCSpecialistWorklistFutureScheduled(Integer, Integer, Integer)}
//	 */
//	@Test
//	void testGetTCSpecialistWorklistFutureScheduled() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting TC specialist future scheduled worklist\",\"status"
//						+ "\":\"Error while getting TC specialist future scheduled worklist\"}",
//				(new CommonController()).getTCSpecialistWorklistFutureScheduled(1, 1, 1));
//		assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Invalid request, either ProviderServiceMapID or userID is"
//				+ " invalid\",\"status\":\"Invalid request, either ProviderServiceMapID or userID is invalid\"}",
//				(new CommonController()).getTCSpecialistWorklistFutureScheduled(null, null, null));
//		assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Invalid request, either ProviderServiceMapID or userID is"
//				+ " invalid\",\"status\":\"Invalid request, either ProviderServiceMapID or userID is invalid\"}",
//				(new CommonController()).getTCSpecialistWorklistFutureScheduled(1, null, null));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTCSpecialistWorklistFutureScheduled(Integer, Integer, Integer)}
//	 */
//	@Test
//	void testGetTCSpecialistWorklistFutureScheduled2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(new CommonDoctorServiceImpl());
//
//		// Act and Assert
//		assertEquals("{\"data\":[],\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				commonController.getTCSpecialistWorklistFutureScheduled(1, 1, 1));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTCSpecialistWorklistFutureScheduled(Integer, Integer, Integer)}
//	 */
//	@Test
//	void testGetTCSpecialistWorklistFutureScheduled3() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonDoctorServiceImpl commonDoctorServiceImpl = mock(CommonDoctorServiceImpl.class);
//		when(commonDoctorServiceImpl.getTCSpecialistWorkListNewFutureScheduledForTM(Mockito.<Integer>any(),
//				Mockito.<Integer>any(), Mockito.<Integer>any()))
//				.thenReturn("Tc Specialist Work List New Future Scheduled For TM");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(commonDoctorServiceImpl);
//
//		// Act
//		String actualTCSpecialistWorklistFutureScheduled = commonController.getTCSpecialistWorklistFutureScheduled(1, 1,
//				1);
//
//		// Assert
//		verify(commonDoctorServiceImpl).getTCSpecialistWorkListNewFutureScheduledForTM(Mockito.<Integer>any(),
//				Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"Tc Specialist Work List New Future Scheduled For TM\"},\"statusCode\":200,\"errorMessage"
//						+ "\":\"Success\",\"status\":\"Success\"}",
//				actualTCSpecialistWorklistFutureScheduled);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTCSpecialistWorklistFutureScheduled(Integer, Integer, Integer)}
//	 */
//	@Test
//	void testGetTCSpecialistWorklistFutureScheduled4() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonDoctorServiceImpl commonDoctorServiceImpl = mock(CommonDoctorServiceImpl.class);
//		when(commonDoctorServiceImpl.getTCSpecialistWorkListNewFutureScheduledForTM(Mockito.<Integer>any(),
//				Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn("FAILURE");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(commonDoctorServiceImpl);
//
//		// Act
//		String actualTCSpecialistWorklistFutureScheduled = commonController.getTCSpecialistWorklistFutureScheduled(1, 1,
//				1);
//
//		// Assert
//		verify(commonDoctorServiceImpl).getTCSpecialistWorkListNewFutureScheduledForTM(Mockito.<Integer>any(),
//				Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"FAILURE\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualTCSpecialistWorklistFutureScheduled);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTCSpecialistWorklistFutureScheduled(Integer, Integer, Integer)}
//	 */
//	@Test
//	void testGetTCSpecialistWorklistFutureScheduled5() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonDoctorServiceImpl commonDoctorServiceImpl = mock(CommonDoctorServiceImpl.class);
//		when(commonDoctorServiceImpl.getTCSpecialistWorkListNewFutureScheduledForTM(Mockito.<Integer>any(),
//				Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn("{\"response\":\"$$STRING\"}");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(commonDoctorServiceImpl);
//
//		// Act
//		String actualTCSpecialistWorklistFutureScheduled = commonController.getTCSpecialistWorklistFutureScheduled(1, 1,
//				1);
//
//		// Assert
//		verify(commonDoctorServiceImpl).getTCSpecialistWorkListNewFutureScheduledForTM(Mockito.<Integer>any(),
//				Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualTCSpecialistWorklistFutureScheduled);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTCSpecialistWorklistFutureScheduled(Integer, Integer, Integer)}
//	 */
//	@Test
//	void testGetTCSpecialistWorklistFutureScheduled6() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonDoctorServiceImpl commonDoctorServiceImpl = mock(CommonDoctorServiceImpl.class);
//		when(commonDoctorServiceImpl.getTCSpecialistWorkListNewFutureScheduledForTM(Mockito.<Integer>any(),
//				Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn(null);
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(commonDoctorServiceImpl);
//
//		// Act
//		String actualTCSpecialistWorklistFutureScheduled = commonController.getTCSpecialistWorklistFutureScheduled(1, 1,
//				1);
//
//		// Assert
//		verify(commonDoctorServiceImpl).getTCSpecialistWorkListNewFutureScheduledForTM(Mockito.<Integer>any(),
//				Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}",
//				actualTCSpecialistWorklistFutureScheduled);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTCSpecialistWorklistFutureScheduled(Integer, Integer, Integer)}
//	 */
//	@Test
//	void testGetTCSpecialistWorklistFutureScheduled7() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonDoctorServiceImpl commonDoctorServiceImpl = mock(CommonDoctorServiceImpl.class);
//		when(commonDoctorServiceImpl.getTCSpecialistWorkListNewFutureScheduledForTM(Mockito.<Integer>any(),
//				Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn("");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonDoctorServiceImpl(commonDoctorServiceImpl);
//
//		// Act
//		String actualTCSpecialistWorklistFutureScheduled = commonController.getTCSpecialistWorklistFutureScheduled(1, 1,
//				1);
//
//		// Assert
//		verify(commonDoctorServiceImpl).getTCSpecialistWorkListNewFutureScheduledForTM(Mockito.<Integer>any(),
//				Mockito.<Integer>any(), Mockito.<Integer>any());
//		assertEquals(
//				"{\"data\":{\"response\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualTCSpecialistWorklistFutureScheduled);
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenPhysicalHistory(String)}
//	 */
//	@Test
//	void testGetBenPhysicalHistory() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting Physical history\",\"status\":\"Error while getting"
//						+ " Physical history\"}",
//				(new CommonController()).getBenPhysicalHistory("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting Physical history\",\"status\":\"Error while getting"
//						+ " Physical history\"}",
//				(new CommonController()).getBenPhysicalHistory(null));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting Physical history\",\"status\":\"Error while getting"
//						+ " Physical history\"}",
//				(new CommonController()).getBenPhysicalHistory("﻿"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting Physical history\",\"status\":\"Error while getting"
//						+ " Physical history\"}",
//				(new CommonController()).getBenPhysicalHistory("foo"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting Physical history\",\"status\":\"Error while getting"
//						+ " Physical history\"}",
//				(new CommonController()).getBenPhysicalHistory("42"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#getBenPhysicalHistory(String)}
//	 */
//	@Test
//	void testGetBenPhysicalHistory2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting Physical history\",\"status\":\"Error while getting"
//						+ " Physical history\"}",
//				commonController.getBenPhysicalHistory("Coming Request"));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getBenSymptomaticQuestionnaireDetails(String)}
//	 */
//	@Test
//	void testGetBenSymptomaticQuestionnaireDetails() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting details\",\"status\":\"Error while getting"
//						+ " details\"}",
//				(new CommonController()).getBenSymptomaticQuestionnaireDetails("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting details\",\"status\":\"Error while getting"
//						+ " details\"}",
//				(new CommonController()).getBenSymptomaticQuestionnaireDetails("FAILURE"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting details\",\"status\":\"Error while getting"
//						+ " details\"}",
//				(new CommonController()).getBenSymptomaticQuestionnaireDetails("42"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting details\",\"status\":\"Error while getting"
//						+ " details\"}",
//				(new CommonController()).getBenSymptomaticQuestionnaireDetails(""));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getBenSymptomaticQuestionnaireDetails(String)}
//	 */
//	@Test
//	void testGetBenSymptomaticQuestionnaireDetails2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting details\",\"status\":\"Error while getting"
//						+ " details\"}",
//				commonController.getBenSymptomaticQuestionnaireDetails("Coming Request"));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getBenPreviousDiabetesHistoryDetails(String)}
//	 */
//	@Test
//	void testGetBenPreviousDiabetesHistoryDetails() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting details\",\"status\":\"Error while getting"
//						+ " details\"}",
//				(new CommonController()).getBenPreviousDiabetesHistoryDetails("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting details\",\"status\":\"Error while getting"
//						+ " details\"}",
//				(new CommonController()).getBenPreviousDiabetesHistoryDetails(null));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting details\",\"status\":\"Error while getting"
//						+ " details\"}",
//				(new CommonController()).getBenPreviousDiabetesHistoryDetails("﻿"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting details\",\"status\":\"Error while getting"
//						+ " details\"}",
//				(new CommonController()).getBenPreviousDiabetesHistoryDetails("foo"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting details\",\"status\":\"Error while getting"
//						+ " details\"}",
//				(new CommonController()).getBenPreviousDiabetesHistoryDetails("42"));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getBenPreviousDiabetesHistoryDetails(String)}
//	 */
//	@Test
//	void testGetBenPreviousDiabetesHistoryDetails2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting details\",\"status\":\"Error while getting"
//						+ " details\"}",
//				commonController.getBenPreviousDiabetesHistoryDetails("Coming Request"));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTMReferredPrintData(String, String, String)}
//	 */
//	@Test
//	void testGetTMReferredPrintData() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error in getting case sheet - java.lang.IllegalStateException:"
//						+ " Expected BEGIN_OBJECT but was STRING at line 1 column 1 path $\",\"status\":\"Error in getting case sheet"
//						+ " - java.lang.IllegalStateException: Expected BEGIN_OBJECT but was STRING at line 1 column 1 path $\"}",
//				(new CommonController()).getTMReferredPrintData("Coming Request", "JaneDoe", "JaneDoe"));
//		assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Invalid request\",\"status\":\"Invalid request\"}",
//				(new CommonController()).getTMReferredPrintData(null, "foo", "foo"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error in getting case sheet - Cannot invoke \\\"com.iemr.mmu.data"
//						+ ".benFlowStatus.BeneficiaryFlowStatus.getBenVisitCode()\\\" because \\\"obj\\\" is null\",\"status\":\"Error in"
//						+ " getting case sheet - Cannot invoke \\\"com.iemr.mmu.data.benFlowStatus.BeneficiaryFlowStatus.getBenVisitCode"
//						+ "()\\\" because \\\"obj\\\" is null\"}",
//				(new CommonController()).getTMReferredPrintData("", "JaneDoe", "JaneDoe"));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getBenPreviousReferralHistoryDetails(String)}
//	 */
//	@Test
//	void testGetBenPreviousReferralHistoryDetails() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting details\",\"status\":\"Error while getting"
//						+ " details\"}",
//				(new CommonController()).getBenPreviousReferralHistoryDetails("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting details\",\"status\":\"Error while getting"
//						+ " details\"}",
//				(new CommonController()).getBenPreviousReferralHistoryDetails(null));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting details\",\"status\":\"Error while getting"
//						+ " details\"}",
//				(new CommonController()).getBenPreviousReferralHistoryDetails("﻿"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting details\",\"status\":\"Error while getting"
//						+ " details\"}",
//				(new CommonController()).getBenPreviousReferralHistoryDetails("foo"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting details\",\"status\":\"Error while getting"
//						+ " details\"}",
//				(new CommonController()).getBenPreviousReferralHistoryDetails("42"));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getBenPreviousReferralHistoryDetails(String)}
//	 */
//	@Test
//	void testGetBenPreviousReferralHistoryDetails2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while getting details\",\"status\":\"Error while getting"
//						+ " details\"}",
//				commonController.getBenPreviousReferralHistoryDetails("Coming Request"));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTMCaseSheetFromCentralServer(String, String)}
//	 */
//	@Test
//	void testGetTMCaseSheetFromCentralServer() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error in MMU central server case sheetCannot invoke \\\"com.iemr.mmu"
//						+ ".service.common.transaction.CommonServiceImpl.getCaseSheetOfTm(String, String)\\\" because \\\"this"
//						+ ".commonServiceImpl\\\" is null\",\"status\":\"Error in MMU central server case sheetCannot invoke"
//						+ " \\\"com.iemr.mmu.service.common.transaction.CommonServiceImpl.getCaseSheetOfTm(String, String)\\\" because"
//						+ " \\\"this.commonServiceImpl\\\" is null\"}",
//				(new CommonController()).getTMCaseSheetFromCentralServer("Coming Request", "JaneDoe"));
//		assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Invalid request\",\"status\":\"Invalid request\"}",
//				(new CommonController()).getTMCaseSheetFromCentralServer(null, "foo"));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTMCaseSheetFromCentralServer(String, String)}
//	 */
//	@Test
//	void testGetTMCaseSheetFromCentralServer2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(new CommonServiceImpl());
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error in MMU central server case sheetjava.lang.IllegalStateException:"
//						+ " Expected BEGIN_OBJECT but was STRING at line 1 column 1 path $\",\"status\":\"Error in MMU central server"
//						+ " case sheetjava.lang.IllegalStateException: Expected BEGIN_OBJECT but was STRING at line 1 column 1"
//						+ " path $\"}",
//				commonController.getTMCaseSheetFromCentralServer("Coming Request", "JaneDoe"));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTMCaseSheetFromCentralServer(String, String)}
//	 */
//	@Test
//	void testGetTMCaseSheetFromCentralServer3() throws Exception {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonServiceImpl commonServiceImpl = mock(CommonServiceImpl.class);
//		when(commonServiceImpl.getCaseSheetOfTm(Mockito.<String>any(), Mockito.<String>any()))
//				.thenReturn("Case Sheet Of Tm");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(commonServiceImpl);
//
//		// Act
//		String actualTMCaseSheetFromCentralServer = commonController.getTMCaseSheetFromCentralServer("Coming Request",
//				"JaneDoe");
//
//		// Assert
//		verify(commonServiceImpl).getCaseSheetOfTm(eq("Coming Request"), eq("JaneDoe"));
//		assertEquals(
//				"{\"data\":{\"response\":\"Case Sheet Of Tm\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":"
//						+ "\"Success\"}",
//				actualTMCaseSheetFromCentralServer);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTMCaseSheetFromCentralServer(String, String)}
//	 */
//	@Test
//	void testGetTMCaseSheetFromCentralServer4() throws Exception {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonServiceImpl commonServiceImpl = mock(CommonServiceImpl.class);
//		when(commonServiceImpl.getCaseSheetOfTm(Mockito.<String>any(), Mockito.<String>any())).thenReturn("FAILURE");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(commonServiceImpl);
//
//		// Act
//		String actualTMCaseSheetFromCentralServer = commonController.getTMCaseSheetFromCentralServer("Coming Request",
//				"JaneDoe");
//
//		// Assert
//		verify(commonServiceImpl).getCaseSheetOfTm(eq("Coming Request"), eq("JaneDoe"));
//		assertEquals(
//				"{\"data\":{\"response\":\"FAILURE\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualTMCaseSheetFromCentralServer);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTMCaseSheetFromCentralServer(String, String)}
//	 */
//	@Test
//	void testGetTMCaseSheetFromCentralServer5() throws Exception {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonServiceImpl commonServiceImpl = mock(CommonServiceImpl.class);
//		when(commonServiceImpl.getCaseSheetOfTm(Mockito.<String>any(), Mockito.<String>any()))
//				.thenReturn("{\"response\":\"$$STRING\"}");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(commonServiceImpl);
//
//		// Act
//		String actualTMCaseSheetFromCentralServer = commonController.getTMCaseSheetFromCentralServer("Coming Request",
//				"JaneDoe");
//
//		// Assert
//		verify(commonServiceImpl).getCaseSheetOfTm(eq("Coming Request"), eq("JaneDoe"));
//		assertEquals(
//				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualTMCaseSheetFromCentralServer);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTMCaseSheetFromCentralServer(String, String)}
//	 */
//	@Test
//	void testGetTMCaseSheetFromCentralServer6() throws Exception {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonServiceImpl commonServiceImpl = mock(CommonServiceImpl.class);
//		when(commonServiceImpl.getCaseSheetOfTm(Mockito.<String>any(), Mockito.<String>any())).thenReturn(null);
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(commonServiceImpl);
//
//		// Act
//		String actualTMCaseSheetFromCentralServer = commonController.getTMCaseSheetFromCentralServer("Coming Request",
//				"JaneDoe");
//
//		// Assert
//		verify(commonServiceImpl).getCaseSheetOfTm(eq("Coming Request"), eq("JaneDoe"));
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Beneficiary pending for Tele-Consultation\",\"status\":\"Beneficiary"
//						+ " pending for Tele-Consultation\"}",
//				actualTMCaseSheetFromCentralServer);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTMCaseSheetFromCentralServer(String, String)}
//	 */
//	@Test
//	void testGetTMCaseSheetFromCentralServer7() throws Exception {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonServiceImpl commonServiceImpl = mock(CommonServiceImpl.class);
//		when(commonServiceImpl.getCaseSheetOfTm(Mockito.<String>any(), Mockito.<String>any())).thenReturn("");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(commonServiceImpl);
//
//		// Act
//		String actualTMCaseSheetFromCentralServer = commonController.getTMCaseSheetFromCentralServer("Coming Request",
//				"JaneDoe");
//
//		// Assert
//		verify(commonServiceImpl).getCaseSheetOfTm(eq("Coming Request"), eq("JaneDoe"));
//		assertEquals(
//				"{\"data\":{\"response\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualTMCaseSheetFromCentralServer);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#getTMCaseSheetFromCentralServer(String, String)}
//	 */
//	@Test
//	void testGetTMCaseSheetFromCentralServer8() throws Exception {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonServiceImpl commonServiceImpl = mock(CommonServiceImpl.class);
//		when(commonServiceImpl.getCaseSheetOfTm(Mockito.<String>any(), Mockito.<String>any()))
//				.thenThrow(new IEMRException("An error occurred"));
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(commonServiceImpl);
//
//		// Act
//		String actualTMCaseSheetFromCentralServer = commonController.getTMCaseSheetFromCentralServer("Coming Request",
//				"JaneDoe");
//
//		// Assert
//		verify(commonServiceImpl).getCaseSheetOfTm(eq("Coming Request"), eq("JaneDoe"));
//		assertEquals("{\"statusCode\":5000,\"errorMessage\":\"An error occurred\",\"status\":\"An error occurred\"}",
//				actualTMCaseSheetFromCentralServer);
//	}
//
//	/**
//	 * Method under test: {@link CommonController#calculateBMIStatus(String)}
//	 */
//	@Test
//	void testCalculateBMIStatus() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Cannot invoke \\\"com.iemr.mmu.service.common.transaction.CommonNur"
//						+ "seServiceImpl.calculateBMIStatus(String)\\\" because \\\"this.commonNurseServiceImpl\\\" is null\",\"status\":\"Cannot"
//						+ " invoke \\\"com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl.calculateBMIStatus(String)\\\""
//						+ " because \\\"this.commonNurseServiceImpl\\\" is null\"}",
//				(new CommonController()).calculateBMIStatus("Coming Request"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#calculateBMIStatus(String)}
//	 */
//	@Test
//	void testCalculateBMIStatus2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(new CommonNurseServiceImpl());
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5000,\"errorMessage\":\"Error while calculating BMI status:java.lang.IllegalStateException:"
//						+ " Expected BEGIN_OBJECT but was STRING at line 1 column 1 path $\",\"status\":\"Error while calculating"
//						+ " BMI status:java.lang.IllegalStateException: Expected BEGIN_OBJECT but was STRING at line 1 column 1"
//						+ " path $\"}",
//				commonController.calculateBMIStatus("Coming Request"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#calculateBMIStatus(String)}
//	 */
//	@Test
//	void testCalculateBMIStatus3() throws IEMRException {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.calculateBMIStatus(Mockito.<String>any())).thenReturn("Calculate BMIStatus");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualCalculateBMIStatusResult = commonController.calculateBMIStatus("Coming Request");
//
//		// Assert
//		verify(commonNurseServiceImpl).calculateBMIStatus(eq("Coming Request"));
//		assertEquals(
//				"{\"data\":{\"response\":\"Calculate BMIStatus\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":"
//						+ "\"Success\"}",
//				actualCalculateBMIStatusResult);
//	}
//
//	/**
//	 * Method under test: {@link CommonController#calculateBMIStatus(String)}
//	 */
//	@Test
//	void testCalculateBMIStatus4() throws IEMRException {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.calculateBMIStatus(Mockito.<String>any())).thenReturn("FAILURE");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualCalculateBMIStatusResult = commonController.calculateBMIStatus("Coming Request");
//
//		// Assert
//		verify(commonNurseServiceImpl).calculateBMIStatus(eq("Coming Request"));
//		assertEquals(
//				"{\"data\":{\"response\":\"FAILURE\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualCalculateBMIStatusResult);
//	}
//
//	/**
//	 * Method under test: {@link CommonController#calculateBMIStatus(String)}
//	 */
//	@Test
//	void testCalculateBMIStatus5() throws IEMRException {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.calculateBMIStatus(Mockito.<String>any()))
//				.thenReturn("{\"response\":\"$$STRING\"}");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualCalculateBMIStatusResult = commonController.calculateBMIStatus("Coming Request");
//
//		// Assert
//		verify(commonNurseServiceImpl).calculateBMIStatus(eq("Coming Request"));
//		assertEquals(
//				"{\"data\":{\"response\":\"$$STRING\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualCalculateBMIStatusResult);
//	}
//
//	/**
//	 * Method under test: {@link CommonController#calculateBMIStatus(String)}
//	 */
//	@Test
//	void testCalculateBMIStatus6() throws IEMRException {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.calculateBMIStatus(Mockito.<String>any())).thenReturn("");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualCalculateBMIStatusResult = commonController.calculateBMIStatus("Coming Request");
//
//		// Assert
//		verify(commonNurseServiceImpl).calculateBMIStatus(eq("Coming Request"));
//		assertEquals(
//				"{\"data\":{\"response\":\"\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualCalculateBMIStatusResult);
//	}
//
//	/**
//	 * Method under test: {@link CommonController#calculateBMIStatus(String)}
//	 */
//	@Test
//	void testCalculateBMIStatus7() throws IEMRException {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.calculateBMIStatus(Mockito.<String>any())).thenReturn(",");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualCalculateBMIStatusResult = commonController.calculateBMIStatus("Coming Request");
//
//		// Assert
//		verify(commonNurseServiceImpl).calculateBMIStatus(eq("Coming Request"));
//		assertEquals(
//				"{\"data\":{\"response\":\",\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status\":\"Success\"}",
//				actualCalculateBMIStatusResult);
//	}
//
//	/**
//	 * Method under test: {@link CommonController#calculateBMIStatus(String)}
//	 */
//	@Test
//	void testCalculateBMIStatus8() throws IEMRException {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonNurseServiceImpl commonNurseServiceImpl = mock(CommonNurseServiceImpl.class);
//		when(commonNurseServiceImpl.calculateBMIStatus(Mockito.<String>any()))
//				.thenReturn("Failed with generic error{\"response\":\"$$STRING\"}");
//
//		CommonController commonController = new CommonController();
//		commonController.setCommonNurseServiceImpl(commonNurseServiceImpl);
//
//		// Act
//		String actualCalculateBMIStatusResult = commonController.calculateBMIStatus("Coming Request");
//
//		// Assert
//		verify(commonNurseServiceImpl).calculateBMIStatus(eq("Coming Request"));
//		assertEquals(
//				"{\"data\":\"Failed with generic error{\\\"response\\\":\\\"$$STRING\\\"}\",\"statusCode\":5000,\"errorMessage\":\"com"
//						+ ".google.gson.stream.MalformedJsonException: Unterminated object at line 1 column 42 path $.response\""
//						+ ",\"status\":\"com.google.gson.stream.MalformedJsonException: Unterminated object at line 1 column 42 path"
//						+ " $.response\"}",
//				actualCalculateBMIStatusResult);
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#saveBeneficiaryVisitDetail(String)}
//	 */
//	@Test
//	void testSaveBeneficiaryVisitDetail() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
//				(new CommonController()).saveBeneficiaryVisitDetail("Coming Request"));
//		assertEquals(
//				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
//				(new CommonController()).saveBeneficiaryVisitDetail("﻿"));
//		assertEquals(
//				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
//				(new CommonController()).saveBeneficiaryVisitDetail("foo"));
//		assertEquals(
//				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
//				(new CommonController()).saveBeneficiaryVisitDetail("42"));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#saveBeneficiaryVisitDetail(String)}
//	 */
//	@Test
//	void testSaveBeneficiaryVisitDetail2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//
//		// Act
//		commonController.saveBeneficiaryVisitDetail(null);
//
//		// Assert
//		assertEquals(
//				"{\"data\":{\"response\":\"Session extended for 30 mins\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status"
//						+ "\":\"Success\"}",
//				commonController.extendRedisSession());
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#saveBeneficiaryVisitDetail(String)}
//	 */
//	@Test
//	void testSaveBeneficiaryVisitDetail3() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
//				commonController.saveBeneficiaryVisitDetail("Coming Request"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#extendRedisSession()}
//	 */
//	@Test
//	void testExtendRedisSession() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"data\":{\"response\":\"Session extended for 30 mins\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status"
//						+ "\":\"Success\"}",
//				(new CommonController()).extendRedisSession());
//	}
//
//	/**
//	 * Method under test: {@link CommonController#extendRedisSession()}
//	 */
//	@Test
//	void testExtendRedisSession2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"data\":{\"response\":\"Session extended for 30 mins\"},\"statusCode\":200,\"errorMessage\":\"Success\",\"status"
//						+ "\":\"Success\"}",
//				commonController.extendRedisSession());
//	}
//
//	/**
//	 * Method under test: {@link CommonController#deletePrescribedMedicine(String)}
//	 */
//	@Test
//	void testDeletePrescribedMedicine() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertEquals(
//				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
//				(new CommonController()).deletePrescribedMedicine("Request OBJ"));
//		assertEquals("{\"statusCode\":5000,\"errorMessage\":\"Failed with generic error\",\"status\":\"FAILURE\"}",
//				(new CommonController()).deletePrescribedMedicine(null));
//		assertEquals(
//				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
//				(new CommonController()).deletePrescribedMedicine("﻿"));
//		assertEquals(
//				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
//				(new CommonController()).deletePrescribedMedicine("foo"));
//		assertEquals(
//				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
//				(new CommonController()).deletePrescribedMedicine("42"));
//	}
//
//	/**
//	 * Method under test: {@link CommonController#deletePrescribedMedicine(String)}
//	 */
//	@Test
//	void testDeletePrescribedMedicine2() {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		CommonController commonController = new CommonController();
//		commonController.setCommonServiceImpl(mock(CommonServiceImpl.class));
//
//		// Act and Assert
//		assertEquals(
//				"{\"statusCode\":5001,\"errorMessage\":\"Invalid object conversion\",\"status\":\"Invalid object conversion\"}",
//				commonController.deletePrescribedMedicine("Request OBJ"));
//	}
//
//	/**
//	 * Method under test:
//	 * {@link CommonController#downloadFile(String, HttpServletRequest)}
//	 */
//	@Test
//	@Disabled("TODO: Complete this test")
//	void testDownloadFile() throws Exception {
//		// TODO: Diffblue Cover was only able to create a partial test for this method:
//		// Reason: Failed to create Spring context.
//		// Attempt to initialize test context failed with
//		// java.lang.IllegalStateException: ApplicationContext failure threshold (1)
//		// exceeded: skipping repeated attempt to load context for
//		// [MergedContextConfiguration@5dc87d5c testClass =
//		// com.iemr.mmu.controller.common.main.DiffblueFakeClass81, locations = [],
//		// classes = [com.iemr.mmu.controller.common.main.CommonController,
//		// com.iemr.mmu.utils.AESEncryption.AESEncryptionDecryption,
//		// jakarta.servlet.ServletContext,
//		// com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl,
//		// com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl,
//		// com.iemr.mmu.service.common.transaction.CommonServiceImpl],
//		// contextInitializerClasses = [], activeProfiles = [],
//		// propertySourceDescriptors = [], propertySourceProperties = [],
//		// contextCustomizers =
//		// [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@65a08f7a,
//		// org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@791d8810,
//		// org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0,
//		// org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f,
//		// org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0,
//		// org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@6bbd977d],
//		// contextLoader =
//		// org.springframework.test.context.support.DelegatingSmartContextLoader, parent
//		// = null]
//		// at
//		// org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
//		// at
//		// org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
//		// at java.base/java.util.Optional.map(Optional.java:260)
//		// See https://diff.blue/R026 to resolve this issue.
//
//		// Arrange
//		MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/common/downloadFile")
//				.contentType(MediaType.APPLICATION_JSON);
//		MockHttpServletRequestBuilder requestBuilder = contentTypeResult
//				.content((new ObjectMapper()).writeValueAsString("﻿"));
//
//		// Act
//		MockMvcBuilders.standaloneSetup(commonController).build().perform(requestBuilder);
//	}
//
//	/**
//	 * Methods under test:
//	 *
//	 * <ul>
//	 * <li>
//	 * {@link CommonController#setCommonDoctorServiceImpl(CommonDoctorServiceImpl)}
//	 * <li>
//	 * {@link CommonController#setCommonNurseServiceImpl(CommonNurseServiceImpl)}
//	 * <li>{@link CommonController#setCommonServiceImpl(CommonServiceImpl)}
//	 * </ul>
//	 */
//	@Test
//	void testGettersAndSetters() {
//		// TODO: Diffblue Cover was only able to create a partial test for this method:
//		// Reason: Missing observers.
//		// Diffblue Cover was unable to create an assertion.
//		// Add getters for the following fields or make them package-private:
//		// CommonController.aESEncryptionDecryption
//		// CommonController.commonDoctorServiceImpl
//		// CommonController.commonNurseServiceImpl
//		// CommonController.commonServiceImpl
//		// CommonController.inputMapper
//		// CommonController.logger
//		// CommonController.servletContext
//
//		// Arrange
//		CommonController commonController = new CommonController();
//
//		// Act
//		commonController.setCommonDoctorServiceImpl(new CommonDoctorServiceImpl());
//		commonController.setCommonNurseServiceImpl(new CommonNurseServiceImpl());
//		commonController.setCommonServiceImpl(new CommonServiceImpl());
//	}
//}
