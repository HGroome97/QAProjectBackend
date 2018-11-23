package com.qa.business.service;

import com.qa.persistence.domain.GameInfo;

public interface GameInfoService {

	String getAllGameInfo();
	String updateGameInfo(GameInfo gi);
}
