package com.nagarro.adminPanel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.adminPanel.dao.ValidateUserDao;
import com.nagarro.adminPanel.dto.LoginServicesDTO;
import com.nagarro.adminPanel.model.CustomerDetails;

@Service
public class ValidateUserServicesImpl implements ValidateUserServices {

	LoginServicesDTO customerLoginInformation = new LoginServicesDTO();

	@Autowired
	ValidateUserDao validateUserDao;

	@Override
	public LoginServicesDTO validateUser(String customerID) {
		CustomerDetails customerInformation = validateUserDao.validateUser(customerID);

		customerLoginInformation.setCustomerName(customerInformation.getCustomerName());
		customerLoginInformation.setAccountBalance(customerInformation.getAccountBalance());

		return customerLoginInformation;
	}
}