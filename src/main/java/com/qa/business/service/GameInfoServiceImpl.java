package com.qa.business.service;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

import com.qa.persistence.domain.GameInfo;
import com.qa.persistence.domain.Teamsheet;
import com.qa.persistence.repository.GameInfoRepository;
import com.qa.persistence.repository.TeamsheetRepository;


@Default
public class GameInfoServiceImpl implements GameInfoService {

	@Inject
	private GameInfoRepository repo;

	public String getAllGameInfo() {
		return repo.getAllGameInfo();
	}

	@Override
	public String updateGameInfo(GameInfo gi) {
		return repo.updateGameInfo(gi);
	}
	
	public void setRepo(GameInfoRepository repo) {
		this.repo = repo;
	}


	
}
