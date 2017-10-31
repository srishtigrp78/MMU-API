package com.iemr.mmu.service.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.login.ServicePointVillageMapping;
import com.iemr.mmu.repo.login.MasterVanRepo;
import com.iemr.mmu.repo.login.ServicePointVillageMappingRepo;
import com.iemr.mmu.repo.login.UserParkingplaceMappingRepo;
import com.iemr.mmu.repo.login.VanServicepointMappingRepo;

@Service
public class IemrMmuLoginServiceImpl implements IemrMmuLoginService{
	
	private UserParkingplaceMappingRepo userParkingplaceMappingRepo;
	private MasterVanRepo masterVanRepo;
	private VanServicepointMappingRepo vanServicepointMappingRepo;
	private ServicePointVillageMappingRepo servicePointVillageMappingRepo;
	
	@Autowired
	public void setUserParkingplaceMappingRepo(UserParkingplaceMappingRepo userParkingplaceMappingRepo) {
		this.userParkingplaceMappingRepo = userParkingplaceMappingRepo;
	}
	
	@Autowired
	public void setMasterVanRepo(MasterVanRepo masterVanRepo) {
		this.masterVanRepo = masterVanRepo;
	}
	
	@Autowired
	public void setVanServicepointMappingRepo(VanServicepointMappingRepo vanServicepointMappingRepo) {
		this.vanServicepointMappingRepo = vanServicepointMappingRepo;
	}
	
	@Autowired
	public void setServicePointVillageMappingRepo(ServicePointVillageMappingRepo servicePointVillageMappingRepo) {
		this.servicePointVillageMappingRepo = servicePointVillageMappingRepo;
	}

	@Override
	public String getUserServicePointVanDetails(Integer userID) {
		// System.out.println("hello");
		Map<String, ArrayList<Map<String, Object>>> responseMap = new HashMap<>();
		List<Object[]> parkingPlaceList = userParkingplaceMappingRepo.getUserParkingPlce(userID);
		Set<Integer> ppS = new HashSet<>();
		ArrayList<Map<String, Object>> parkingPlaceLocationList = new ArrayList<>();
		if (parkingPlaceList.size() > 0) {
			Map<String, Object> parkingPlaceLocationMap;
			for (Object[] obj : parkingPlaceList) {
				ppS.add((Integer) obj[0]);
				parkingPlaceLocationMap = new HashMap<String, Object>();
				parkingPlaceLocationMap.put("stateID", obj[1]);
				parkingPlaceLocationMap.put("stateName", obj[2]);
				parkingPlaceLocationMap.put("districtID", obj[3]);
				parkingPlaceLocationMap.put("districtName", obj[4]);
				parkingPlaceLocationMap.put("blockID", obj[5]);
				parkingPlaceLocationMap.put("blockName", obj[6]);
				parkingPlaceLocationList.add(parkingPlaceLocationMap);
			}
			// System.out.println("hello");
			List<Object[]> vanList = masterVanRepo.getUserVanDatails(ppS);
			Map<String, Object> vMap;
			ArrayList<Map<String, Object>> vanListResponse = new ArrayList<>();
			if (vanList.size() > 0) {
				for (Object[] obj : vanList) {
					vMap = new HashMap<String, Object>();
					vMap.put("vanID", obj[0]);
					vMap.put("vanNO", obj[1]);
					vanListResponse.add(vMap);
				}
			} else {
				vMap = new HashMap<String, Object>();
				vanListResponse.add(vMap);
			}
			// System.out.println("hello");

			List<Object[]> servicePointList = vanServicepointMappingRepo.getuserSpSessionDetails(ppS);
			Map<String, Object> spMap;
			ArrayList<Map<String, Object>> servicePointListResponse = new ArrayList<>();
			if (servicePointList.size() > 0) {
				for (Object[] obj : servicePointList) {
					spMap = new HashMap<String, Object>();
					spMap.put("servicePointID", obj[0]);
					spMap.put("servicePointName", obj[1]);
					spMap.put("sessionType", obj[2]);
					servicePointListResponse.add(spMap);
				}
			} else {
				spMap = new HashMap<String, Object>();
				servicePointListResponse.add(spMap);
			}

			responseMap.put("userVanDetails", vanListResponse);
			responseMap.put("userSpDetails", servicePointListResponse);
			responseMap.put("parkingPlaceLocationList", parkingPlaceLocationList);
			

			// System.out.println("hello");

		}
		return new Gson().toJson(responseMap);
	}

	@Override
	public String getServicepointVillages(Integer servicePointID) {
		List<Object[]> servicePointVillageList = servicePointVillageMappingRepo.getServicePointVillages(servicePointID);
		
		ArrayList<ServicePointVillageMapping> villageList=new ArrayList<ServicePointVillageMapping>();
		if (servicePointVillageList.size() > 0) {
			ServicePointVillageMapping VillageMap;
			for (Object[] obj : servicePointVillageList) {
				VillageMap = new ServicePointVillageMapping((Integer)obj[0], (String)obj[1]);
				villageList.add(VillageMap);
			}
		}
			
		return new Gson().toJson(villageList);
	}
}
