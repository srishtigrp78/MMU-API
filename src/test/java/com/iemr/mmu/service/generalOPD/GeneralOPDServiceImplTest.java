//package com.iemr.mmu.service.generalOPD;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import com.iemr.mmu.repo.benFlowStatus.BeneficiaryFlowStatusRepo;
//import com.iemr.mmu.service.benFlowStatus.CommonBenStatusFlowServiceImpl;
//import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;
//import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
//import com.iemr.mmu.service.labtechnician.LabTechnicianServiceImpl;
//import com.iemr.mmu.service.tele_consultation.TeleConsultationServiceImpl;
//
//@ExtendWith(MockitoExtension.class)
//class GeneralOPDServiceImplTest {
//	@Mock
//	private CommonNurseServiceImpl commonNurseServiceImpl;
//	@Mock
//	private GeneralOPDNurseServiceImpl generalOPDNurseServiceImpl;
//	@Mock
//	private CommonDoctorServiceImpl commonDoctorServiceImpl;
//	@Mock
//	private CommonBenStatusFlowServiceImpl commonBenStatusFlowServiceImpl;
//	@Mock
//	private GeneralOPDDoctorServiceImpl generalOPDDoctorServiceImpl;
//	@Mock
//	private LabTechnicianServiceImpl labTechnicianServiceImpl;
//	@Mock
//	private TeleConsultationServiceImpl teleConsultationServiceImpl;
//	@Mock
//	private BeneficiaryFlowStatusRepo beneficiaryFlowStatusRepo;
//
//	@InjectMocks
//	GeneralOPDServiceImpl generalOPDService;
//
//
//}
