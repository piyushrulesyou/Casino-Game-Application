package com.nagarro.adminPanel.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.adminPanel.model.CustomerDetails;

@Repository
public class UserListDaoImpl implements UserListDao {

	final static Logger LOG = Logger.getLogger(UserListDaoImpl.class);

	private Configuration con;
	private SessionFactory sessionFactory;

	public UserListDaoImpl() {

		LOG.info("Configuring hibernate and building session factory. ");

		con = new Configuration().configure();
		sessionFactory = con.buildSessionFactory();

		LOG.info("Configuration and building Succesfull");
	}

	public List<CustomerDetails> fetchAllUsers() {

		LOG.info("Inside method to fetching the list of all the users.");

		Session session = sessionFactory.openSession();

		CriteriaBuilder criteriaBuider = session.getCriteriaBuilder();
		CriteriaQuery<CustomerDetails> criteriaQuery = criteriaBuider.createQuery(CustomerDetails.class);
		Root<CustomerDetails> root = criteriaQuery.from(CustomerDetails.class);

		criteriaQuery.select(root);

		Query<CustomerDetails> query = session.createQuery(criteriaQuery);
		List<CustomerDetails> usersList = query.getResultList();

		session.close();

		return usersList;

	}
}
