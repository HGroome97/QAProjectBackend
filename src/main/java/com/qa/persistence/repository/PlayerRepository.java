package com.qa.persistence.repository;

import com.qa.persistence.domain.Player;

public interface PlayerRepository {

	String getAllPlayers();
	String createPlayer(String p);
	String getPlayer(long id);
	String deletePlayer(long id);
	String updatePlayer(Player p);
}