package com.iemr.mmu.service.location;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.location.DistrictBlock;
import com.iemr.mmu.data.location.Districts;
import com.iemr.mmu.data.location.States;
import com.iemr.mmu.data.location.V_GetLocDetailsFromSPidAndPSMid;
import com.iemr.mmu.data.location.ZoneMaster;
import com.iemr.mmu.data.login.MasterServicePoint;
import com.iemr.mmu.data.login.ParkingPlace;
import com.iemr.mmu.repo.location.DistrictBlockMasterRepo;
import com.iemr.mmu.repo.location.DistrictMasterRepo;
import com.iemr.mmu.repo.location.ParkingPlaceMasterRepo;
import com.iemr.mmu.repo.location.ServicePointMasterRepo;
import com.iemr.mmu.repo.location.StateMasterRepo;
import com.iemr.mmu.repo.location.V_GetLocDetailsFromSPidAndPSMidRepo;
import com.iemr.mmu.repo.location.ZoneMasterRepo;

@Service
public class LocationServiceImpl implements LocationService {

	private StateMasterRepo stateMasterRepo;
	private ZoneMasterRepo zoneMasterRepo;
	private DistrictMasterRepo districtMasterRepo;
	private DistrictBlockMasterRepo districtBlockMasterRepo;
	private ParkingPlaceMasterRepo parkingPlaceMasterRepo;
	private ServicePointMasterRepo servicePointMasterRepo;
	private V_GetLocDetailsFromSPidAndPSMidRepo v_GetLocDetailsFromSPidAndPSMidRepo;

	@Autowired
	public void setV_GetLocDetailsFromSPidAndPSMidRepo(
			V_GetLocDetailsFromSPidAndPSMidRepo v_GetLocDetailsFromSPidAndPSMidRepo) {
		this.v_GetLocDetailsFromSPidAndPSMidRepo = v_GetLocDetailsFromSPidAndPSMidRepo;
	}

	@Autowired
	public void setServicePointMasterRepo(ServicePointMasterRepo servicePointMasterRepo) {
		this.servicePointMasterRepo = servicePointMasterRepo;
	}

	@Autowired
	public void setParkingPlaceMasterRepo(ParkingPlaceMasterRepo parkingPlaceMasterRepo) {
		this.parkingPlaceMasterRepo = parkingPlaceMasterRepo;
	}

	@Autowired
	public void setDistrictBlockMasterRepo(DistrictBlockMasterRepo districtBlockMasterRepo) {
		this.districtBlockMasterRepo = districtBlockMasterRepo;
	}

	@Autowired
	public void setDistrictMasterRepo(DistrictMasterRepo districtMasterRepo) {
		this.districtMasterRepo = districtMasterRepo;
	}

	@Autowired
	public void setZoneMasterRepo(ZoneMasterRepo zoneMasterRepo) {
		this.zoneMasterRepo = zoneMasterRepo;
	}

	@Autowired
	public void setStateMasterRepo(StateMasterRepo stateMasterRepo) {
		this.stateMasterRepo = stateMasterRepo;
	}

	@Override
	public String getStateList() {
		ArrayList<States> stateList = new ArrayList<>();
		ArrayList<Object[]> stateMasterList = stateMasterRepo.getStateMaster();
		if (stateMasterList != null && stateMasterList.size() > 0) {
			for (Object[] objArr : stateMasterList) {
				States states = new States((Integer) objArr[0], (String) objArr[1]);
				stateList.add(states);
			}
		}
		return new Gson().toJson(stateList);
	}

	@Override
	public String getZoneList(Integer providerServiceMapID) {
		ArrayList<Object> zoneList = new ArrayList<>();
		ArrayList<Object[]> zoneMasterList = zoneMasterRepo.getZoneMaster(providerServiceMapID);
		if (zoneMasterList != null && zoneMasterList.size() > 0) {
			for (Object[] objArr : zoneMasterList) {
				ZoneMaster zoneMaster = new ZoneMaster((Integer) objArr[0], (String) objArr[1]);
				zoneList.add(zoneMaster);
			}
		}
		return new Gson().toJson(zoneList);
	}

	@Override
	public String getDistrictList(Integer stateID) {
		ArrayList<Object> districtList = new ArrayList<>();
		ArrayList<Object[]> districtMasterList = districtMasterRepo.getDistrictMaster(stateID);
		if (districtMasterList != null && districtMasterList.size() > 0) {
			for (Object[] objArr : districtMasterList) {
				Districts districtMaster = new Districts((Integer) objArr[0], (String) objArr[1]);
				districtList.add(districtMaster);
			}
		}
		return new Gson().toJson(districtList);
	}

	@Override
	public String getDistrictBlockList(Integer districtID) {
		ArrayList<Object> districtBlockList = new ArrayList<>();
		ArrayList<Object[]> districtBlockMasterList = districtBlockMasterRepo.getDistrictBlockMaster(districtID);
		if (districtBlockMasterList != null && districtBlockMasterList.size() > 0) {
			for (Object[] objArr : districtBlockMasterList) {
				DistrictBlock districtBLockMaster = new DistrictBlock((Integer) objArr[0], (String) objArr[1]);
				districtBlockList.add(districtBLockMaster);
			}
		}
		return new Gson().toJson(districtBlockList);
	}

	@Override
	public String getParkingPlaceList(Integer providerServiceMapID) {
		ArrayList<Object> parkingPlaceList = new ArrayList<>();
		ArrayList<Object[]> parkingPlaceMasterList = parkingPlaceMasterRepo.getParkingPlaceMaster(providerServiceMapID);
		if (parkingPlaceMasterList != null && parkingPlaceMasterList.size() > 0) {
			for (Object[] objArr : parkingPlaceMasterList) {
				ParkingPlace parkingPlace = new ParkingPlace((Integer) objArr[0], (String) objArr[1]);
				parkingPlaceList.add(parkingPlace);
			}
		}
		return new Gson().toJson(parkingPlaceList);
	}

	public String getServicePointPlaceList(Integer parkingPlaceID) {
		ArrayList<Object> servicePointList = new ArrayList<>();
		ArrayList<Object[]> servicePointMasterList = servicePointMasterRepo.getServicePointMaster(parkingPlaceID);
		if (servicePointMasterList != null && servicePointMasterList.size() > 0) {
			for (Object[] objArr : servicePointMasterList) {
				MasterServicePoint masterServicePoint = new MasterServicePoint((Integer) objArr[0], (String) objArr[1]);
				servicePointList.add(masterServicePoint);
			}
		}
		return new Gson().toJson(servicePointList);
	}

	public String getLocDetails(Integer a, Integer b, Integer c, Integer d) {
		ArrayList<V_GetLocDetailsFromSPidAndPSMid> objList = v_GetLocDetailsFromSPidAndPSMidRepo
				.findByServicepointidAndSpproviderservicemapidAndPpproviderservicemapidAndZdmproviderservicemapid(a, b,
						c, d);
		return null;
	}
}
