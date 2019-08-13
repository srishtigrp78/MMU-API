package com.iemr.mmu.controller.common.main;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.data.common.DocFileManager;
import com.iemr.mmu.service.common.transaction.CommonServiceImpl;
import com.iemr.mmu.utils.mapper.InputMapper;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = "/commonInsert", headers = "Authorization")
public class InsertCommonController {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	@Autowired
	private CommonServiceImpl commonServiceImpl;

	@CrossOrigin()
	@ApiOperation(value = "provides doctor worklist", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/saveFiles" }, method = { RequestMethod.POST })
	public String saveFiles(@RequestBody String request) {
		OutputResponse response = new OutputResponse();

		try {
			DocFileManager[] docFileManager = InputMapper.gson().fromJson(request, DocFileManager[].class);
			List<DocFileManager> docFileManagerList = Arrays.asList(docFileManager);
			String s = commonServiceImpl.saveFiles(docFileManagerList);
			if (s != null)
				response.setResponse(s);
		} catch (Exception e) {
			logger.error("Error while saving files : " + e);
			response.setError(5000, "Error while saving files : " + e);
		}

		return response.toString();
	}
}
