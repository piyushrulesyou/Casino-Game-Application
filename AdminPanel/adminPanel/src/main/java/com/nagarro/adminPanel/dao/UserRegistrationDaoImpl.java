package com.nagarro.adminPanel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.adminPanel.model.CustomerDetails;

@Repository
public class UserRegistrationDaoImpl implements UserRegistrationDao {

	@Autowired
	SessionDao sessionDao;

	public String registerUserInDB(CustomerDetails userInformation) {

		String newCustomerID;

		try {
			sessionDao.begin();
			newCustomerID = (String) sessionDao.getSession().save(userInformation);

			sessionDao.commit();
			sessionDao.close();
		} catch (Exception exception) {
			newCustomerID = null;
		}

		return newCustomerID;
	}

}
