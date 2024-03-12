package com.iemr.mmu.service.common.master;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iemr.mmu.data.masterdata.doctor.ItemMaster;
import com.iemr.mmu.data.masterdata.doctor.M_Uom;
import com.iemr.mmu.repo.doctor.ChiefComplaintMasterRepo;
import com.iemr.mmu.repo.doctor.DrugDoseMasterRepo;
import com.iemr.mmu.repo.doctor.DrugDurationUnitMasterRepo;
import com.iemr.mmu.repo.doctor.DrugFrequencyMasterRepo;
import com.iemr.mmu.repo.labModule.ProcedureRepo;
import com.iemr.mmu.repo.login.MasterVanRepo;
import com.iemr.mmu.repo.masterrepo.anc.AllergicReactionTypesRepo;
import com.iemr.mmu.repo.masterrepo.anc.BloodGroupsRepo;
import com.iemr.mmu.repo.masterrepo.anc.ChildVaccinationsRepo;
import com.iemr.mmu.repo.masterrepo.anc.ComorbidConditionRepo;
import com.iemr.mmu.repo.masterrepo.anc.CompFeedsRepo;
import com.iemr.mmu.repo.masterrepo.anc.ComplicationTypesRepo;
import com.iemr.mmu.repo.masterrepo.anc.CounsellingTypeRepo;
import com.iemr.mmu.repo.masterrepo.anc.DeliveryPlaceRepo;
import com.iemr.mmu.repo.masterrepo.anc.DeliveryTypeRepo;
import com.iemr.mmu.repo.masterrepo.anc.DevelopmentProblemsRepo;
import com.iemr.mmu.repo.masterrepo.anc.DiseaseTypeRepo;
import com.iemr.mmu.repo.masterrepo.anc.FundalHeightRepo;
import com.iemr.mmu.repo.masterrepo.anc.GestationRepo;
import com.iemr.mmu.repo.masterrepo.anc.GrossMotorMilestoneRepo;
import com.iemr.mmu.repo.masterrepo.anc.IllnessTypesRepo;
import com.iemr.mmu.repo.masterrepo.anc.JointTypesRepo;
import com.iemr.mmu.repo.masterrepo.anc.MenstrualCycleRangeRepo;
import com.iemr.mmu.repo.masterrepo.anc.MenstrualCycleStatusRepo;
import com.iemr.mmu.repo.masterrepo.anc.MenstrualProblemRepo;
import com.iemr.mmu.repo.masterrepo.anc.MusculoskeletalRepo;
import com.iemr.mmu.repo.masterrepo.anc.OptionalVaccinationsRepo;
import com.iemr.mmu.repo.masterrepo.anc.PersonalHabitTypeRepo;
import com.iemr.mmu.repo.masterrepo.anc.PregDurationRepo;
import com.iemr.mmu.repo.masterrepo.anc.PregOutcomeRepo;
import com.iemr.mmu.repo.masterrepo.anc.ServiceFacilityMasterRepo;
import com.iemr.mmu.repo.masterrepo.anc.ServiceMasterRepo;
import com.iemr.mmu.repo.masterrepo.anc.SurgeryTypesRepo;
import com.iemr.mmu.repo.masterrepo.covid19.CovidContactHistoryMasterRepo;
import com.iemr.mmu.repo.masterrepo.covid19.CovidRecommnedationMasterRepo;
import com.iemr.mmu.repo.masterrepo.covid19.CovidSymptomsMasterRepo;
import com.iemr.mmu.repo.masterrepo.doctor.InstituteRepo;
import com.iemr.mmu.repo.masterrepo.doctor.ItemFormMasterRepo;
import com.iemr.mmu.repo.masterrepo.doctor.ItemMasterRepo;
import com.iemr.mmu.repo.masterrepo.doctor.RouteOfAdminRepo;
import com.iemr.mmu.repo.masterrepo.doctor.V_DrugPrescriptionRepo;
import com.iemr.mmu.repo.masterrepo.ncdCare.NCDCareTypeRepo;
import com.iemr.mmu.repo.masterrepo.nurse.FamilyMemberMasterRepo;
import com.iemr.mmu.repo.masterrepo.pnc.NewbornHealthStatusRepo;

@ExtendWith(MockitoExtension.class)
class ANCMasterDataServiceImplTest {
	@InjectMocks
	private ANCMasterDataServiceImpl aNCMasterDataServiceImpl;

	@Mock
	private AllergicReactionTypesRepo allergicReactionTypesRepo;

	@Mock
	private BloodGroupsRepo bloodGroupsRepo;

	@Mock
	private ChiefComplaintMasterRepo chiefComplaintMasterRepo;

	@Mock
	private ChildVaccinationsRepo childVaccinationsRepo;

	@Mock
	private ComorbidConditionRepo comorbidConditionRepo;

	@Mock
	private CompFeedsRepo compFeedsRepo;

	@Mock
	private ComplicationTypesRepo complicationTypesRepo;

	@Mock
	private CounsellingTypeRepo counsellingTypeRepo;

	@Mock
	private CovidContactHistoryMasterRepo covidContactHistoryMasterRepo;

	@Mock
	private CovidRecommnedationMasterRepo covidRecommnedationMasterRepo;

	@Mock
	private CovidSymptomsMasterRepo covidSymptomsMasterRepo;

	@Mock
	private DeliveryPlaceRepo deliveryPlaceRepo;

	@Mock
	private DeliveryTypeRepo deliveryTypeRepo;

	@Mock
	private DevelopmentProblemsRepo developmentProblemsRepo;

	@Mock
	private DiseaseTypeRepo diseaseTypeRepo;

	@Mock
	private DrugDoseMasterRepo drugDoseMasterRepo;

	@Mock
	private DrugDurationUnitMasterRepo drugDurationUnitMasterRepo;

	@Mock
	private DrugFrequencyMasterRepo drugFrequencyMasterRepo;

	@Mock
	private FamilyMemberMasterRepo familyMemberMasterRepo;

	@Mock
	private FundalHeightRepo fundalHeightRepo;

	@Mock
	private GestationRepo gestationRepo;

	@Mock
	private GrossMotorMilestoneRepo grossMotorMilestoneRepo;

	@Mock
	private IllnessTypesRepo illnessTypesRepo;

	@Mock
	private InstituteRepo instituteRepo;

	@Mock
	private ItemFormMasterRepo itemFormMasterRepo;

	@Mock
	private ItemMasterRepo itemMasterRepo;

	@Mock
	private JointTypesRepo jointTypesRepo;

	@Mock
	private MasterVanRepo masterVanRepo;

	@Mock
	private MenstrualCycleRangeRepo menstrualCycleRangeRepo;

	@Mock
	private MenstrualCycleStatusRepo menstrualCycleStatusRepo;

	@Mock
	private MenstrualProblemRepo menstrualProblemRepo;

	@Mock
	private MusculoskeletalRepo musculoskeletalRepo;

	@Mock
	private NCDCareTypeRepo nCDCareTypeRepo;

	@Mock
	private NCDScreeningMasterServiceImpl nCDScreeningMasterServiceImpl;

	@Mock
	private NewbornHealthStatusRepo newbornHealthStatusRepo;

	@Mock
	private OptionalVaccinationsRepo optionalVaccinationsRepo;

	@Mock
	private PersonalHabitTypeRepo personalHabitTypeRepo;

	@Mock
	private PregDurationRepo pregDurationRepo;

	@Mock
	private PregOutcomeRepo pregOutcomeRepo;

	@Mock
	private ProcedureRepo procedureRepo;

	@Mock
	private RouteOfAdminRepo routeOfAdminRepo;

	@Mock
	private ServiceFacilityMasterRepo serviceFacilityMasterRepo;

	@Mock
	private ServiceMasterRepo serviceMasterRepo;

	@Mock
	private SurgeryTypesRepo surgeryTypesRepo;

	@Mock
	private V_DrugPrescriptionRepo v_DrugPrescriptionRepo;

	@Test
	@Disabled("TODO: Complete this test")
	void testGetCommonNurseMasterDataForGenopdAncNcdcarePnc() {

		// Arrange
		// TODO: Populate arranged inputs
		Integer visitCategoryID = null;
		Integer providerServiceMapID = null;
		String gender = "";

		// Act
		String actualCommonNurseMasterDataForGenopdAncNcdcarePnc = this.aNCMasterDataServiceImpl
				.getCommonNurseMasterDataForGenopdAncNcdcarePnc(visitCategoryID, providerServiceMapID, gender);

		// Assert
		// TODO: Add assertions on result
	}

	@Test
	void testGetCommonDoctorMasterDataForGenopdAncNcdcarePnc() {
		// Arrange
		when(itemMasterRepo.searchEdl(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
		when(counsellingTypeRepo.getCounsellingTypes()).thenReturn(new ArrayList<>());
		when(drugDoseMasterRepo.getDrugDoseMaster()).thenReturn(new ArrayList<>());
		when(drugDurationUnitMasterRepo.getDrugDurationUnitMaster()).thenReturn(new ArrayList<>());
		when(drugFrequencyMasterRepo.getDrugFrequencyMaster()).thenReturn(new ArrayList<>());
		when(instituteRepo.getInstituteDetails(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
		when(itemFormMasterRepo.getItemFormMaster()).thenReturn(new ArrayList<>());
		when(routeOfAdminRepo.getRouteOfAdminList()).thenReturn(new ArrayList<>());
		when(serviceMasterRepo.getAdditionalServices()).thenReturn(new ArrayList<>());
		when(v_DrugPrescriptionRepo.getItemListForFacility(Mockito.<Integer>any())).thenReturn(new ArrayList<>());

		// Act
		String actualCommonDoctorMasterDataForGenopdAncNcdcarePnc = aNCMasterDataServiceImpl
				.getCommonDoctorMasterDataForGenopdAncNcdcarePnc(1, 1, "Gender", 1, 1);

		// Assert
		verify(drugDoseMasterRepo).getDrugDoseMaster();
		verify(drugDurationUnitMasterRepo).getDrugDurationUnitMaster();
		verify(drugFrequencyMasterRepo).getDrugFrequencyMaster();
		verify(counsellingTypeRepo).getCounsellingTypes();
		verify(serviceMasterRepo).getAdditionalServices();
		verify(instituteRepo).getInstituteDetails(Mockito.<Integer>any());
		verify(itemFormMasterRepo).getItemFormMaster();
		verify(itemMasterRepo).searchEdl(Mockito.<Integer>any());
		verify(routeOfAdminRepo).getRouteOfAdminList();
		verify(v_DrugPrescriptionRepo).getItemListForFacility(Mockito.<Integer>any());
		assertEquals(
				"{\"additionalServices\":[],\"NonEdlMaster\":[],\"counsellingTypes\":[],\"drugDoseMaster\":[],\"routeOfAdmin\":"
						+ "[],\"itemMaster\":[],\"drugFormMaster\":[],\"drugDurationUnitMaster\":[],\"higherHealthCare\":[],\"drugFrequencyMaster"
						+ "\":[]}",
				actualCommonDoctorMasterDataForGenopdAncNcdcarePnc);
	}

	@Test
	void testGetCommonDoctorMasterDataForGenopdAncNcdcarePnc2() {
		// Arrange
		Date createdDate = mock(Date.class);
		when(createdDate.getTime()).thenReturn(10L);
		Date lastModDate = mock(Date.class);
		when(lastModDate.getTime()).thenReturn(10L);
		Date createdDate2 = mock(Date.class);
		when(createdDate2.getTime()).thenReturn(10L);
		Date lastModDate2 = mock(Date.class);
		when(lastModDate2.getTime()).thenReturn(10L);

		M_Uom uom = new M_Uom();
		uom.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		uom.setCreatedDate(createdDate2);
		uom.setDeleted(true);
		uom.setLastModDate(lastModDate2);
		uom.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		uom.setProcessed('\u0007');
		uom.setProviderServiceMapID(1);
		uom.setStatus("counsellingTypes");
		uom.setuOMCode("counsellingTypes");
		uom.setuOMDesc("counsellingTypes");
		uom.setuOMID(1);
		uom.setuOMName("counsellingTypes");

		ItemMaster itemMaster = new ItemMaster();
		itemMaster.setComposition("counsellingTypes");
		itemMaster.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		itemMaster.setCreatedDate(createdDate);
		itemMaster.setDeleted(true);
		itemMaster.setDiscontinued(true);
		itemMaster.setIsEDL(true);
		itemMaster.setIsMedical(true);
		itemMaster.setIsScheduledDrug(true);
		itemMaster.setItemCategoryID(1);
		itemMaster.setItemCode("counsellingTypes");
		itemMaster.setItemDesc("counsellingTypes");
		itemMaster.setItemFormID(1);
		itemMaster.setItemID(1);
		itemMaster.setItemName("counsellingTypes");
		itemMaster.setLastModDate(lastModDate);
		itemMaster.setManufacturerID(1);
		itemMaster.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		itemMaster.setPharmacologyCategoryID(1);
		itemMaster.setProcessed('\u0007');
		itemMaster.setProviderServiceMapID(1);
		itemMaster.setQuantity(7);
		itemMaster.setRouteID(1);
		itemMaster.setStatus("counsellingTypes");
		itemMaster.setStrength("counsellingTypes");
		itemMaster.setUnitOfMeasurement("counsellingTypes");
		itemMaster.setUom(uom);
		itemMaster.setUomID(1);

		ArrayList<ItemMaster> itemMasterList = new ArrayList<>();
		itemMasterList.add(itemMaster);
		when(itemMasterRepo.searchEdl(Mockito.<Integer>any())).thenReturn(itemMasterList);
		when(counsellingTypeRepo.getCounsellingTypes()).thenReturn(new ArrayList<>());
		when(drugDoseMasterRepo.getDrugDoseMaster()).thenReturn(new ArrayList<>());
		when(drugDurationUnitMasterRepo.getDrugDurationUnitMaster()).thenReturn(new ArrayList<>());
		when(drugFrequencyMasterRepo.getDrugFrequencyMaster()).thenReturn(new ArrayList<>());
		when(instituteRepo.getInstituteDetails(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
		when(itemFormMasterRepo.getItemFormMaster()).thenReturn(new ArrayList<>());
		when(routeOfAdminRepo.getRouteOfAdminList()).thenReturn(new ArrayList<>());
		when(serviceMasterRepo.getAdditionalServices()).thenReturn(new ArrayList<>());
		when(v_DrugPrescriptionRepo.getItemListForFacility(Mockito.<Integer>any())).thenReturn(new ArrayList<>());

		// Act
		aNCMasterDataServiceImpl.getCommonDoctorMasterDataForGenopdAncNcdcarePnc(1, 1, "Gender", 1, 1);

		// Assert
		verify(drugDoseMasterRepo).getDrugDoseMaster();
		verify(drugDurationUnitMasterRepo).getDrugDurationUnitMaster();
		verify(drugFrequencyMasterRepo).getDrugFrequencyMaster();
		verify(counsellingTypeRepo).getCounsellingTypes();
		verify(serviceMasterRepo).getAdditionalServices();
		verify(instituteRepo).getInstituteDetails(Mockito.<Integer>any());
		verify(itemFormMasterRepo).getItemFormMaster();
		verify(itemMasterRepo).searchEdl(Mockito.<Integer>any());
		verify(routeOfAdminRepo).getRouteOfAdminList();
		verify(v_DrugPrescriptionRepo).getItemListForFacility(Mockito.<Integer>any());
		verify(createdDate).getTime();
		verify(lastModDate).getTime();
		verify(createdDate2).getTime();
		verify(lastModDate2).getTime();
	}

	@Test
	void testGetCommonDoctorMasterDataForGenopdAncNcdcarePnc3() {
		// Arrange
		Date createdDate = mock(Date.class);
		when(createdDate.getTime()).thenReturn(10L);
		Date lastModDate = mock(Date.class);
		when(lastModDate.getTime()).thenReturn(10L);
		Date createdDate2 = mock(Date.class);
		when(createdDate2.getTime()).thenReturn(10L);
		Date lastModDate2 = mock(Date.class);
		when(lastModDate2.getTime()).thenReturn(10L);

		M_Uom uom = new M_Uom();
		uom.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		uom.setCreatedDate(createdDate2);
		uom.setDeleted(true);
		uom.setLastModDate(lastModDate2);
		uom.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		uom.setProcessed('\u0007');
		uom.setProviderServiceMapID(1);
		uom.setStatus("counsellingTypes");
		uom.setuOMCode("counsellingTypes");
		uom.setuOMDesc("counsellingTypes");
		uom.setuOMID(1);
		uom.setuOMName("counsellingTypes");

		ItemMaster itemMaster = new ItemMaster();
		itemMaster.setComposition("counsellingTypes");
		itemMaster.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
		itemMaster.setCreatedDate(createdDate);
		itemMaster.setDeleted(true);
		itemMaster.setDiscontinued(true);
		itemMaster.setIsEDL(true);
		itemMaster.setIsMedical(true);
		itemMaster.setIsScheduledDrug(true);
		itemMaster.setItemCategoryID(1);
		itemMaster.setItemCode("counsellingTypes");
		itemMaster.setItemDesc("counsellingTypes");
		itemMaster.setItemFormID(1);
		itemMaster.setItemID(1);
		itemMaster.setItemName("counsellingTypes");
		itemMaster.setLastModDate(lastModDate);
		itemMaster.setManufacturerID(1);
		itemMaster.setModifiedBy("Jan 1, 2020 9:00am GMT+0100");
		itemMaster.setPharmacologyCategoryID(1);
		itemMaster.setProcessed('\u0007');
		itemMaster.setProviderServiceMapID(1);
		itemMaster.setQuantity(7);
		itemMaster.setRouteID(1);
		itemMaster.setStatus("counsellingTypes");
		itemMaster.setStrength("counsellingTypes");
		itemMaster.setUnitOfMeasurement("counsellingTypes");
		itemMaster.setUom(uom);
		itemMaster.setUomID(1);
		Date createdDate3 = mock(Date.class);
		when(createdDate3.getTime()).thenReturn(10L);
		Date lastModDate3 = mock(Date.class);
		when(lastModDate3.getTime()).thenReturn(10L);
		Date createdDate4 = mock(Date.class);
		when(createdDate4.getTime()).thenReturn(10L);
		Date lastModDate4 = mock(Date.class);
		when(lastModDate4.getTime()).thenReturn(10L);

		M_Uom uom2 = new M_Uom();
		uom2.setCreatedBy("counsellingTypes");
		uom2.setCreatedDate(createdDate4);
		uom2.setDeleted(false);
		uom2.setLastModDate(lastModDate4);
		uom2.setModifiedBy("counsellingTypes");
		uom2.setProcessed('\u0001');
		uom2.setProviderServiceMapID(2);
		uom2.setStatus("higherHealthCare");
		uom2.setuOMCode("higherHealthCare");
		uom2.setuOMDesc("higherHealthCare");
		uom2.setuOMID(2);
		uom2.setuOMName("higherHealthCare");

		ItemMaster itemMaster2 = new ItemMaster();
		itemMaster2.setComposition("higherHealthCare");
		itemMaster2.setCreatedBy("counsellingTypes");
		itemMaster2.setCreatedDate(createdDate3);
		itemMaster2.setDeleted(false);
		itemMaster2.setDiscontinued(false);
		itemMaster2.setIsEDL(false);
		itemMaster2.setIsMedical(false);
		itemMaster2.setIsScheduledDrug(false);
		itemMaster2.setItemCategoryID(2);
		itemMaster2.setItemCode("higherHealthCare");
		itemMaster2.setItemDesc("higherHealthCare");
		itemMaster2.setItemFormID(2);
		itemMaster2.setItemID(2);
		itemMaster2.setItemName("higherHealthCare");
		itemMaster2.setLastModDate(lastModDate3);
		itemMaster2.setManufacturerID(2);
		itemMaster2.setModifiedBy("counsellingTypes");
		itemMaster2.setPharmacologyCategoryID(2);
		itemMaster2.setProcessed('\u0001');
		itemMaster2.setProviderServiceMapID(2);
		itemMaster2.setQuantity(1);
		itemMaster2.setRouteID(2);
		itemMaster2.setStatus("higherHealthCare");
		itemMaster2.setStrength("higherHealthCare");
		itemMaster2.setUnitOfMeasurement("higherHealthCare");
		itemMaster2.setUom(uom2);
		itemMaster2.setUomID(2);

		ArrayList<ItemMaster> itemMasterList = new ArrayList<>();
		itemMasterList.add(itemMaster2);
		itemMasterList.add(itemMaster);
		when(itemMasterRepo.searchEdl(Mockito.<Integer>any())).thenReturn(itemMasterList);
		when(counsellingTypeRepo.getCounsellingTypes()).thenReturn(new ArrayList<>());
		when(drugDoseMasterRepo.getDrugDoseMaster()).thenReturn(new ArrayList<>());
		when(drugDurationUnitMasterRepo.getDrugDurationUnitMaster()).thenReturn(new ArrayList<>());
		when(drugFrequencyMasterRepo.getDrugFrequencyMaster()).thenReturn(new ArrayList<>());
		when(instituteRepo.getInstituteDetails(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
		when(itemFormMasterRepo.getItemFormMaster()).thenReturn(new ArrayList<>());
		when(routeOfAdminRepo.getRouteOfAdminList()).thenReturn(new ArrayList<>());
		when(serviceMasterRepo.getAdditionalServices()).thenReturn(new ArrayList<>());
		when(v_DrugPrescriptionRepo.getItemListForFacility(Mockito.<Integer>any())).thenReturn(new ArrayList<>());

		// Act
		aNCMasterDataServiceImpl.getCommonDoctorMasterDataForGenopdAncNcdcarePnc(1, 1, "Gender", 1, 1);

		// Assert
		verify(drugDoseMasterRepo).getDrugDoseMaster();
		verify(drugDurationUnitMasterRepo).getDrugDurationUnitMaster();
		verify(drugFrequencyMasterRepo).getDrugFrequencyMaster();
		verify(counsellingTypeRepo).getCounsellingTypes();
		verify(serviceMasterRepo).getAdditionalServices();
		verify(instituteRepo).getInstituteDetails(Mockito.<Integer>any());
		verify(itemFormMasterRepo).getItemFormMaster();
		verify(itemMasterRepo).searchEdl(Mockito.<Integer>any());
		verify(routeOfAdminRepo).getRouteOfAdminList();
		verify(v_DrugPrescriptionRepo).getItemListForFacility(Mockito.<Integer>any());
		verify(createdDate3).getTime();
		verify(lastModDate3).getTime();
		verify(createdDate4).getTime();
		verify(lastModDate4).getTime();
		verify(createdDate).getTime();
		verify(lastModDate).getTime();
		verify(createdDate2).getTime();
		verify(lastModDate2).getTime();
	}

	@Test
	void testGettersAndSetters() {
		// TODO: Diffblue Cover was only able to create a partial test for this method:
		// Reason: Missing observers.
		// Diffblue Cover was unable to create an assertion.
		// Add getters for the following fields or make them package-private:
		// ANCMasterDataServiceImpl.allergicReactionTypesRepo
		// ANCMasterDataServiceImpl.bloodGroupsRepo
		// ANCMasterDataServiceImpl.chiefComplaintMasterRepo
		// ANCMasterDataServiceImpl.childVaccinationsRepo
		// ANCMasterDataServiceImpl.comorbidConditionRepo
		// ANCMasterDataServiceImpl.compFeedsRepo
		// ANCMasterDataServiceImpl.complicationTypesRepo
		// ANCMasterDataServiceImpl.counsellingTypeRepo
		// ANCMasterDataServiceImpl.covidContactHistoryMasterRepo
		// ANCMasterDataServiceImpl.covidRecommnedationMasterRepo
		// ANCMasterDataServiceImpl.covidSymptomsMasterRepo
		// ANCMasterDataServiceImpl.deliveryPlaceRepo
		// ANCMasterDataServiceImpl.deliveryTypeRepo
		// ANCMasterDataServiceImpl.developmentProblemsRepo
		// ANCMasterDataServiceImpl.diseaseTypeRepo
		// ANCMasterDataServiceImpl.drugDoseMasterRepo
		// ANCMasterDataServiceImpl.drugDurationUnitMasterRepo
		// ANCMasterDataServiceImpl.drugFrequencyMasterRepo
		// ANCMasterDataServiceImpl.familyMemberMasterRepo
		// ANCMasterDataServiceImpl.fundalHeightRepo
		// ANCMasterDataServiceImpl.gestationRepo
		// ANCMasterDataServiceImpl.grossMotorMilestoneRepo
		// ANCMasterDataServiceImpl.illnessTypesRepo
		// ANCMasterDataServiceImpl.instituteRepo
		// ANCMasterDataServiceImpl.itemFormMasterRepo
		// ANCMasterDataServiceImpl.itemMasterRepo
		// ANCMasterDataServiceImpl.jointTypesRepo
		// ANCMasterDataServiceImpl.masterVanRepo
		// ANCMasterDataServiceImpl.menstrualCycleRangeRepo
		// ANCMasterDataServiceImpl.menstrualCycleStatusRepo
		// ANCMasterDataServiceImpl.menstrualProblemRepo
		// ANCMasterDataServiceImpl.musculoskeletalRepo
		// ANCMasterDataServiceImpl.ncdCareTypeRepo
		// ANCMasterDataServiceImpl.ncdScreeningMasterServiceImpl
		// ANCMasterDataServiceImpl.newbornHealthStatusRepo
		// ANCMasterDataServiceImpl.optionalVaccinationsRepo
		// ANCMasterDataServiceImpl.personalHabitTypeRepo
		// ANCMasterDataServiceImpl.pregDurationRepo
		// ANCMasterDataServiceImpl.pregOutcomeRepo
		// ANCMasterDataServiceImpl.procedureRepo
		// ANCMasterDataServiceImpl.routeOfAdminRepo
		// ANCMasterDataServiceImpl.serviceFacilityMasterRepo
		// ANCMasterDataServiceImpl.serviceMasterRepo
		// ANCMasterDataServiceImpl.surgeryTypesRepo
		// ANCMasterDataServiceImpl.v_DrugPrescriptionRepo

		// Arrange
		ANCMasterDataServiceImpl ancMasterDataServiceImpl = new ANCMasterDataServiceImpl();

		// Act
		ancMasterDataServiceImpl.setAllergicReactionTypesRepo(mock(AllergicReactionTypesRepo.class));
		ancMasterDataServiceImpl.setBloodGroupsRepo(mock(BloodGroupsRepo.class));
		ancMasterDataServiceImpl.setChiefComplaintMasterRepo(mock(ChiefComplaintMasterRepo.class));
		ancMasterDataServiceImpl.setChildVaccinationsRepo(mock(ChildVaccinationsRepo.class));
		ancMasterDataServiceImpl.setComorbidConditionRepo(mock(ComorbidConditionRepo.class));
		ancMasterDataServiceImpl.setCompFeedsRepo(mock(CompFeedsRepo.class));
		ancMasterDataServiceImpl.setComplicationTypesRepo(mock(ComplicationTypesRepo.class));
		ancMasterDataServiceImpl.setCounsellingTypeRepo(mock(CounsellingTypeRepo.class));
		ancMasterDataServiceImpl.setDeliveryPlaceRepo(mock(DeliveryPlaceRepo.class));
		ancMasterDataServiceImpl.setDeliveryTypeRepo(mock(DeliveryTypeRepo.class));
		ancMasterDataServiceImpl.setDevelopmentProblemsRepo(mock(DevelopmentProblemsRepo.class));
		ancMasterDataServiceImpl.setDiseaseTypeRepo(mock(DiseaseTypeRepo.class));
		ancMasterDataServiceImpl.setDrugDoseMasterRepo(mock(DrugDoseMasterRepo.class));
		ancMasterDataServiceImpl.setDrugDurationUnitMasterRepo(mock(DrugDurationUnitMasterRepo.class));
		ancMasterDataServiceImpl.setDrugFrequencyMasterRepo(mock(DrugFrequencyMasterRepo.class));
		ancMasterDataServiceImpl.setFamilyMemberMasterRepo(mock(FamilyMemberMasterRepo.class));
		ancMasterDataServiceImpl.setFundalHeightRepo(mock(FundalHeightRepo.class));
		ancMasterDataServiceImpl.setGestationRepo(mock(GestationRepo.class));
		ancMasterDataServiceImpl.setGrossMotorMilestoneRepo(mock(GrossMotorMilestoneRepo.class));
		ancMasterDataServiceImpl.setIllnessTypesRepo(mock(IllnessTypesRepo.class));
		ancMasterDataServiceImpl.setInstituteRepo(mock(InstituteRepo.class));
		ancMasterDataServiceImpl.setItemFormMasterRepo(mock(ItemFormMasterRepo.class));
		ancMasterDataServiceImpl.setJointTypesRepo(mock(JointTypesRepo.class));
		ancMasterDataServiceImpl.setMenstrualCycleRangeRepo(mock(MenstrualCycleRangeRepo.class));
		ancMasterDataServiceImpl.setMenstrualCycleStatusRepo(mock(MenstrualCycleStatusRepo.class));
		ancMasterDataServiceImpl.setMenstrualProblemRepo(mock(MenstrualProblemRepo.class));
		ancMasterDataServiceImpl.setMusculoskeletalRepo(mock(MusculoskeletalRepo.class));
		ancMasterDataServiceImpl.setNcdCareTypeRepo(mock(NCDCareTypeRepo.class));
		ancMasterDataServiceImpl.setNcdScreeningMasterServiceImpl(new NCDScreeningMasterServiceImpl());
		ancMasterDataServiceImpl.setNewbornHealthStatusRepo(mock(NewbornHealthStatusRepo.class));
		ancMasterDataServiceImpl.setOptionalVaccinationsRepo(mock(OptionalVaccinationsRepo.class));
		ancMasterDataServiceImpl.setPersonalHabitTypeRepo(mock(PersonalHabitTypeRepo.class));
		ancMasterDataServiceImpl.setPregDurationRepo(mock(PregDurationRepo.class));
		ancMasterDataServiceImpl.setPregOutcomeRepo(mock(PregOutcomeRepo.class));
		ancMasterDataServiceImpl.setProcedureRepo(mock(ProcedureRepo.class));
		ancMasterDataServiceImpl.setRouteOfAdminRepo(mock(RouteOfAdminRepo.class));
		ancMasterDataServiceImpl.setServiceMasterRepo(mock(ServiceMasterRepo.class));
		ancMasterDataServiceImpl.setSurgeryTypesRepo(mock(SurgeryTypesRepo.class));
		ancMasterDataServiceImpl.setV_DrugPrescriptionRepo(mock(V_DrugPrescriptionRepo.class));
	}
}
