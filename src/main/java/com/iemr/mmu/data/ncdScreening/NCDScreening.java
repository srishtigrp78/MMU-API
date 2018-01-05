package com.iemr.mmu.data.ncdScreening;

import java.util.Date;

public class NCDScreening {

	private Long BeneficiaryRegID; 
	private Long BenVisitID;
	private int ProviderServiceMapID; 
	private Long VisitCode; 
	private short NCDScreeningVisitNo;
	private String ScreeningCondition; 
	private String ReasonForScreening; 
	private short SystolicBP_1stReading;  
	private short DiastolicBP_1stReading;  
	private short SystolicBP_2ndReading;  
	private short DiastolicBP_2ndReading;  
	private short SystolicBP_3rdReading;  
	private short DiastolicBP_3rdReading;  
	private short AverageSystolicBP;  
	private short AverageDiastolicBP;  
	private String BloodGlucoseSampleType; 
	private short BloodGlucoseValue;  
	private String BloodPressureStatus; 
	private String DiabeticStatus; 
	private Date NextScreeningDate; 
	private String ActionForScreenPositive;
	private boolean Deleted; 
	private String Processed; 
	private String CreatedBy; 
	private Date CreatedDate; 
	private String ModifiedBy; 
	private Date LastModDate;
}
