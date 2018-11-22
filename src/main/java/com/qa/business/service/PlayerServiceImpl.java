package com.qa.business.service;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.persistence.domain.Teamsheet;
import com.qa.persistence.domain.Player;
import com.qa.persistence.repository.PlayerRepository;


@Default
public class PlayerServiceImpl implements PlayerService {

	@Inject
	private PlayerRepository repo;

	public String getAllPlayers() {
		return repo.getAllPlayers();
	}

	public String getAllPlayersWithTeamName(String teamName) {
		return repo.getAllPlayersWithTeamName(teamName);
	}

	public String getAllPlayersWithoutTeamName(String teamName){
		return repo.getAllPlayersWithoutTeamName(teamName);
	}

	public String createPlayer(String t) {
		return repo.createPlayer(t);
	}

	@Override
	public String deletePlayer(long id) {
		return repo.deletePlayer(id);
	}

	@Override
	public String getPlayer(long id) {
		return repo.getPlayer(id);
	}

	@Override
	public String updatePlayer(Player t) {
		return repo.updatePlayer(t);
	}

	
	public void setRepo(PlayerRepository repo) {
		this.repo = repo;
	}


	
}
