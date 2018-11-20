package com.qa.business.service;

import com.qa.persistence.domain.Teamsheet;

public interface TeamsheetService {

	String getAllTeamsheets();
	String createTeamsheet(String ts);
	String getTeamsheet(long id);
	String deleteTeamsheet(long id);
	String updateTeamsheet(Teamsheet ts);
	String searchByName(String name);
}
