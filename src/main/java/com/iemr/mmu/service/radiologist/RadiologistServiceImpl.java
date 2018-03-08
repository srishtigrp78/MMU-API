package com.iemr.mmu.service.radiologist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mmu.data.registrar.WrapperRegWorklist;
import com.iemr.mmu.repo.doctor.DocWorkListRepo;

@Service
public class RadiologistServiceImpl implements RadiologistService {
	private DocWorkListRepo docWorkListRepo;

	@Autowired
	public void setDocWorkListRepo(DocWorkListRepo docWorkListRepo) {
		this.docWorkListRepo = docWorkListRepo;
	}

	@Override
	public String getRadiologistWorkList() {
		List<Object[]> docWorkListData = docWorkListRepo.getRadiologistWorkList();
		//System.out.println("hello");
		return WrapperRegWorklist.getDocWorkListData(docWorkListData);
	}
}
