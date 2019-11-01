package com.nagarro.adminPanel.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.nagarro.adminPanel.constants.Constants;

public class DateParser {
//	final static Logger LOG = Logger.getLogger(DateParser.class);

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATEFORMAT);

	public static LocalDate getDate(String stringDate) {

		LocalDate date = LocalDate.parse(stringDate, formatter);
		return date;
	}
}
