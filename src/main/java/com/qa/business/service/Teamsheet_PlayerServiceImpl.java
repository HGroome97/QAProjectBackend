package com.qa.business.service;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.persistence.domain.Teamsheet_Player;
import com.qa.persistence.repository.Teamsheet_PlayerRepository;


@Default
public class Teamsheet_PlayerServiceImpl implements Teamsheet_PlayerService {

	@Inject
	private Teamsheet_PlayerRepository repo;

	public String getAllTeamsheet_Player() {
		return repo.getAllTeamsheet_Player();
	}

	public String getAllTeamsheet_PlayersWithTeamsheetId(String teamsheetId) {
		return repo.getAllTeamsheet_PlayersWithTeamsheetId(teamsheetId);
	}
	
	public String getAllTeamsheet_PlayersWithPlayerId(String playerId) {
		return repo.getAllTeamsheet_PlayersWithPlayerId(playerId);
	}

	public String createTeamsheet_Player(String tsp) {
		return repo.createTeamsheet_Player(tsp);
	}

	@Override
	public String deleteTeamsheet_Player(long id) {
		return repo.deleteTeamsheet_Player(id);
	}

	@Override
	public String getTeamsheet_Player(long id) {
		return repo.getTeamsheet_Player(id);
	}

	@Override
	public String updateTeamsheet_Player(Teamsheet_Player tsp) {
		return repo.updateTeamsheet_Player(tsp);
	}

	
	public void setRepo(Teamsheet_PlayerRepository repo) {
		this.repo = repo;
	}


	
}
