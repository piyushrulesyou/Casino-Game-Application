package com.nagarro.adminPanel.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.adminPanel.model.CustomerDetails;

@Repository
public class FilterUsersDaoImpl implements FilterUsersDao {

	private Configuration con;
	private SessionFactory sessionFactory;

	public FilterUsersDaoImpl() {
		con = new Configuration().configure();
		sessionFactory = con.buildSessionFactory();
	}

	public List<CustomerDetails> filterList(String filterName, String filterContact, String filterEMail) {

		Session session = sessionFactory.openSession();

		CriteriaBuilder criteriaBuider = session.getCriteriaBuilder();
		CriteriaQuery<CustomerDetails> criteriaQuery = criteriaBuider.createQuery(CustomerDetails.class);

		Root<CustomerDetails> root = criteriaQuery.from(CustomerDetails.class);

		Predicate[] predicates = new Predicate[3];
		predicates[0] = criteriaBuider.like(root.get("customerName"), "%" + filterName + "%");
		predicates[1] = criteriaBuider.like(root.get("contactNumber"), "%" + filterContact + "%");
		predicates[2] = criteriaBuider.like(root.get("emailID"), "%" + filterEMail + "%");

		criteriaQuery.select(root).where(predicates);

		Query<CustomerDetails> query = session.createQuery(criteriaQuery);

		List<CustomerDetails> usersList = query.getResultList();

		session.close();

		return usersList;

	}

}
