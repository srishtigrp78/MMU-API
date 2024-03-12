package com.iemr.mmu.service.snomedct;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.mmu.data.snomedct.SCTDescription;
import com.iemr.mmu.repo.snomedct.SnomedRepository;

@ExtendWith(MockitoExtension.class)
class SnomedServiceImplTest {
	@Mock
	private SnomedRepository snomedRepository;

	@InjectMocks
	private SnomedServiceImpl snomedServiceImpl;

	@Test
	@Disabled("TODO: Complete this test")
	void testFindSnomedCTRecordFromTerm() {
		// TODO: Diffblue Cover was only able to create a partial test for this method:
		// Reason: Failed to create Spring context.
		// Attempt to initialize test context failed with
		// java.lang.IllegalStateException: ApplicationContext failure threshold (1)
		// exceeded: skipping repeated attempt to load context for
		// [MergedContextConfiguration@62da6985 testClass =
		// com.iemr.mmu.service.snomedct.DiffblueFakeClass1, locations = [], classes =
		// [com.iemr.mmu.service.snomedct.SnomedServiceImpl], contextInitializerClasses
		// = [], activeProfiles = [], propertySourceDescriptors = [],
		// propertySourceProperties = [], contextCustomizers =
		// [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@1b77baaf,
		// org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@3147dcb9,
		// org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@25c5a74f,
		// org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f,
		// org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0,
		// org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@6b7f7c0f],
		// contextLoader =
		// org.springframework.test.context.support.DelegatingSmartContextLoader, parent
		// = null]
		// at
		// org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
		// at
		// org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
		// at java.base/java.util.Optional.map(Optional.java:260)
		// See https://diff.blue/R026 to resolve this issue.

		// Arrange and Act
		snomedServiceImpl.findSnomedCTRecordFromTerm("Term");
	}

	@Test
	void testFindSnomedCTRecordList() throws Exception {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange, Act and Assert
		assertThrows(Exception.class, () -> (new SnomedServiceImpl()).findSnomedCTRecordList(null));
	}

	@Test
	void testFindSnomedCTRecordList2() throws Exception {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		SnomedServiceImpl snomedServiceImpl = new SnomedServiceImpl();

		SCTDescription sctdescription = new SCTDescription();
		sctdescription.setActive("Active");
		sctdescription.setCaseSignificanceID("Case Significance ID");
		sctdescription.setConceptID("Concept ID");
		sctdescription.setSctDesID(1L);
		sctdescription.setPageNo(null);
		sctdescription.setTerm(null);

		// Act and Assert
		assertThrows(Exception.class, () -> snomedServiceImpl.findSnomedCTRecordList(sctdescription));
	}

	@Test
	void testFindSnomedCTRecordList3() throws Exception {
		// Diffblue Cover was unable to create a Spring-specific test for this Spring
		// method.

		// Arrange
		SnomedServiceImpl snomedServiceImpl = new SnomedServiceImpl();

		SCTDescription sctdescription = new SCTDescription();
		sctdescription.setActive("Active");
		sctdescription.setCaseSignificanceID("Case Significance ID");
		sctdescription.setConceptID("Concept ID");
		sctdescription.setSctDesID(1L);
		sctdescription.setPageNo(null);
		sctdescription.setTerm("foo");

		// Act and Assert
		assertThrows(Exception.class, () -> snomedServiceImpl.findSnomedCTRecordList(sctdescription));
	}
}
