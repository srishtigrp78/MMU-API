package com.iemr.mmu.service.common.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mmu.service.doctor.DoctorServiceImpl;

@Service
public class CommonMasterServiceImpl implements CommonMaterService{

	private ANCMasterDataServiceImpl ancMasterDataServiceImpl;
	private NurseMasterDataServiceImpl nurseMasterDataServiceImpl;
	private DoctorServiceImpl doctorServiceImpl;
	private DoctorMasterDataServiceImpl doctorMasterDataServiceImpl;
	private RegistrarServiceMasterDataImpl registrarServiceMasterDataImpl;


	@Autowired
	public void setRegistrarServiceMasterDataImpl(RegistrarServiceMasterDataImpl registrarServiceMasterDataImpl) {
		this.registrarServiceMasterDataImpl = registrarServiceMasterDataImpl;
	}
	
	@Autowired
	public void setAncMasterDataServiceImpl(ANCMasterDataServiceImpl ancMasterDataServiceImpl) {
		this.ancMasterDataServiceImpl = ancMasterDataServiceImpl;
	}
	
	@Autowired
	public void setNurseMasterDataServiceImpl(NurseMasterDataServiceImpl nurseMasterDataServiceImpl) {
		this.nurseMasterDataServiceImpl = nurseMasterDataServiceImpl;
	}
	
	@Autowired
	public void setDoctorServiceImpl(DoctorServiceImpl doctorServiceImpl) {
		this.doctorServiceImpl = doctorServiceImpl;
	}
	
	@Autowired
	public void setDoctorMasterDataServiceImpl(DoctorMasterDataServiceImpl doctorMasterDataServiceImpl) {
		this.doctorMasterDataServiceImpl = doctorMasterDataServiceImpl;
	}
	
	
	@Override
	public String getVisitReasonAndCategories() {
		String visitReasonAndCategories = nurseMasterDataServiceImpl.GetVisitReasonAndCategories();
		return visitReasonAndCategories;
	}
	
	@Override
	public String getMasterDataForNurse(Integer visitCategoryID) {
		String nurseMasterData = null;
		if(null!=visitCategoryID){
			switch(visitCategoryID){
				case 1 :{
					// 1 : Cancer Screening
					nurseMasterData = nurseMasterDataServiceImpl.getCancerScreeningMasterDataForNurse();
				}
				break;
				case 2 :{
					// 2 : NCD screening
					//TODO: NCD SCreening Master Data call
					nurseMasterData = "No Master Data found for NCD SCreening";
				}
				break;
				case 3 :{
					// 3 : NCD care
					//TODO: NCD Care Master Data call
					nurseMasterData = "No Master Data found for NCD Care";
				}
				break;
				case 4 :{
					// 4 : ANC
					nurseMasterData = ancMasterDataServiceImpl.getANCMasterDataForNurse();
				}
				break;
				case 5 :{
					// 5 : PNC
					//TODO: PNC Master Data call
					nurseMasterData = "No Master Data found for PNC Master";
				}
				break;
				case 6 :{
					// 6 : General OPD
					//TODO: General OPD Master Data call
					nurseMasterData = "No Master Data found for General OPD";
				}
				break;
				case 7 :{
					// 7 : General OPD (QC)
					nurseMasterData = "No Master Data found for QuickConsultation";
				}
				break;
				default :{
					nurseMasterData = "Invalid VisitCategoryID";
				}
			}
		}else{
			nurseMasterData = "Invalid VisitCategoryID";
		}
		return nurseMasterData;
	}
	@Override
	public String getMasterDataForDoctor(Integer visitCategoryID) {
		String doctorMasterData = null;
		if(null!=visitCategoryID){
			switch(visitCategoryID){
				case 1 :{
					// 1 : Cancer Screening
					doctorMasterData = doctorMasterDataServiceImpl.getCancerScreeningMasterDataForDoctor();
				}
				break;
				case 2 :{
					// 2 : NCD screening
					//TODO: NCD SCreening Master Data call
					doctorMasterData = "No Master Data found for NCD SCreening";
				}
				break;
				case 3 :{
					// 3 : NCD care
					//TODO: NCD Care Master Data call
					doctorMasterData = "No Master Data found for NCD Care";
				}
				break;
				case 4 :{
					// 4 : ANC
					doctorMasterData = ancMasterDataServiceImpl.getANCMasterDataForDoctor();
				}
				break;
				case 5 :{
					// 5 : PNC
					//TODO: PNC Master Data call
					doctorMasterData = "No Master Data found for PNC Master";
				}
				break;
				case 6 :{
					// 6 : General OPD
					//TODO: General OPD Master Data call
					doctorMasterData = "No Master Data found for General OPD";
				}
				break;
				case 7 :{
					// 7 : General OPD (QC)
					doctorMasterData =  doctorServiceImpl.getQuickConsultMasterData();
				}
				break;
				default :{
					doctorMasterData = "Invalid VisitCategoryID";
				}
			}
		}else{
			doctorMasterData = "Invalid VisitCategoryID";
		}
		return doctorMasterData;
	}

}
