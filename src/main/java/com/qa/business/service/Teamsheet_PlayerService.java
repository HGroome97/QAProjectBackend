package com.qa.business.service;

import com.qa.persistence.domain.Teamsheet_Player;

public interface Teamsheet_PlayerService {

	String getAllTeamsheet_Player();
	String getAllTeamsheet_PlayersWithTeamsheetId(String teamsheetId);
	String getAllTeamsheet_PlayersWithPlayerId(String playerId);
	String createTeamsheet_Player(String tsp);
	String getTeamsheet_Player(long id);
	String deleteTeamsheet_Player(long id);
	String updateTeamsheet_Player(Teamsheet_Player tsp);
	
}
