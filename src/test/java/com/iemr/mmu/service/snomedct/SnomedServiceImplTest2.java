//package com.iemr.mmu.service.snomedct;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.fail;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.Collections;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//import com.iemr.mmu.data.snomedct.SCTDescription;
//import com.iemr.mmu.repo.snomedct.SnomedRepository;
//
//@ExtendWith(MockitoExtension.class)
//class SnomedServiceImplTest2 {
//	@Mock
//	private SnomedRepository snomedRepository;
//
//	@InjectMocks
//	private SnomedServiceImpl snomedService;
//
//	@Test
//	public void testFindSnomedCTRecordFromTerm_Found() {
//		String term = "testTerm";
//		List<Object[]> mockData = Collections.singletonList(new Object[1]);
//
//		when(snomedRepository.findSnomedCTRecordFromTerm(term)).thenReturn(mockData);
//
//		try {
//			SCTDescription actualObj = snomedService.findSnomedCTRecordFromTerm(term);
//			fail("Expected ArrayIndexOutOfBoundsException"); // This line will fail the test if no exception is thrown
//		} catch (ArrayIndexOutOfBoundsException e) {
//			// Expected exception, test passes
//		}
//
//		verify(snomedRepository).findSnomedCTRecordFromTerm(term);
//	}
//
//	@Test
//	public void testFindSnomedCTRecordFromTerm_NotFound() {
//		String term = "notFoundTerm";
//		when(snomedRepository.findSnomedCTRecordFromTerm(term)).thenReturn(Collections.emptyList());
//
//		SCTDescription actualObj = snomedService.findSnomedCTRecordFromTerm(term);
//
//		assertNull(actualObj);
//		verify(snomedRepository).findSnomedCTRecordFromTerm(term);
//	}
//
//	@Test
//	void testFindSnomedCTRecordList() throws Exception {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange, Act and Assert
//		assertThrows(Exception.class, () -> (new SnomedServiceImpl()).findSnomedCTRecordList(null));
//	}
//
//	@Test
//	void testFindSnomedCTRecordList2() throws Exception {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		SnomedServiceImpl snomedServiceImpl = new SnomedServiceImpl();
//
//		SCTDescription sctdescription = new SCTDescription();
//		sctdescription.setActive("Active");
//		sctdescription.setCaseSignificanceID("Case Significance ID");
//		sctdescription.setConceptID("Concept ID");
//		sctdescription.setSctDesID(1L);
//		sctdescription.setPageNo(null);
//		sctdescription.setTerm(null);
//
//		// Act and Assert
//		assertThrows(Exception.class, () -> snomedServiceImpl.findSnomedCTRecordList(sctdescription));
//	}
//
//	@Test
//	void testFindSnomedCTRecordList3() throws Exception {
//		// Diffblue Cover was unable to create a Spring-specific test for this Spring
//		// method.
//
//		// Arrange
//		SnomedServiceImpl snomedServiceImpl = new SnomedServiceImpl();
//
//		SCTDescription sctdescription = new SCTDescription();
//		sctdescription.setActive("Active");
//		sctdescription.setCaseSignificanceID("Case Significance ID");
//		sctdescription.setConceptID("Concept ID");
//		sctdescription.setSctDesID(1L);
//		sctdescription.setPageNo(null);
//		sctdescription.setTerm("foo");
//
//		// Act and Assert
//		assertThrows(Exception.class, () -> snomedServiceImpl.findSnomedCTRecordList(sctdescription));
//	}
////
////	@Test
////	void testFindSnomedCTRecordFromTerm() {
////		fail("Not yet implemented");
////	}
////
////	@Test
////	void testFindSnomedCTRecordList() {
////		fail("Not yet implemented");
////	}
//
//}
