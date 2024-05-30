package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.DealDao;
import com.demo.exception.handler.DataIntegrityViolationException;
import com.demo.model.Deal;

@Service("dealService")
public class DealService {

	@Autowired
	private DealDao dealDao;

	public Deal save(Deal deal) {
		 if (dealDao.existsById(deal.getId())) {
			throw new DataIntegrityViolationException("Deal you entered is exist.");
		}
		return dealDao.save(deal);
	}
}
