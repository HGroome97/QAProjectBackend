package com.qa.business.service;

import com.qa.persistence.domain.Player;

public interface PlayerService {

	String getAllPlayers();
	String getAllPlayersWithTeamName(String teamName);
	String getAllPlayersWithoutTeamName(String teamName);
	String createPlayer(String p);
	String getPlayer(long id);
	String deletePlayer(long id);
	String updatePlayer(Player p);
	
}
