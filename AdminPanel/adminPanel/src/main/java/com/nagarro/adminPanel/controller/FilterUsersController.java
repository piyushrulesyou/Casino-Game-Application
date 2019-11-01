package com.nagarro.adminPanel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.adminPanel.model.CustomerDetails;
import com.nagarro.adminPanel.services.FilterUsersServices;

@Controller
public class FilterUsersController {

	@Autowired
	FilterUsersServices filterUsersServices;

	@RequestMapping(value = "filterUsers", method = RequestMethod.POST)
	public ModelAndView filterUsersList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String filterName = request.getParameter("filterName");
		String filterContact = request.getParameter("filterContact");
		String filterEMail = request.getParameter("filterEMail");

		List<CustomerDetails> filteredUsers = filterUsersServices.filterUsersList(filterName, filterContact,
				filterEMail);

		ModelAndView modelAndView = new ModelAndView("UsersList");
		modelAndView.addObject("listOfUsers", filteredUsers);

		return modelAndView;

	}
}
