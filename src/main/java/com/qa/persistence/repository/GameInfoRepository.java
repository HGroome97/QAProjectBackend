package com.qa.persistence.repository;

import com.qa.persistence.domain.GameInfo;

public interface GameInfoRepository {

	String getAllGameInfo();
	String updateGameInfo(GameInfo gi);
}
