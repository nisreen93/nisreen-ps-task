package com.demo.FXDealsAnalyzer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Deal;
import com.demo.service.DealService;

@RestController
public class AnalyzingRestController {

	@Autowired
	private DealService dealService;

	private static final Logger logger = LoggerFactory.getLogger(AnalyzingRestController.class);

	
	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public ResponseEntity<HttpStatus> login() {
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@RequestMapping(value = "/fx/deal/save", method = { RequestMethod.POST })
	public ResponseEntity<Deal> save(@RequestBody Deal dealToSave) {
		logger.info("AnalyzingController-Start with save deal request...");
		try {
			Deal dealSaved = dealService.save(dealToSave);
			logger.info("AnalyzingController-Deal saved successfully...");
			return ResponseEntity.status(HttpStatus.OK).body(dealSaved);
		} catch (DataIntegrityViolationException ex) {
			logger.error("AnalyzingController-DataIntegrityViolationException...");
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} catch (Exception e) {
			logger.error("AnalyzingController-Exception...");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}finally {
			logger.info("AnalyzingController-End of save deal request...");
		}
	}

	
	
}
