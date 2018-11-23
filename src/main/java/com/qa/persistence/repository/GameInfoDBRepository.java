package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.GameInfo;
import com.qa.persistence.domain.Teamsheet;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class GameInfoDBRepository implements GameInfoRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonOb;

	
	public String getAllGameInfo() {
		Query query = manager.createQuery("Select gi FROM GameInfo gi");
		Collection<GameInfo> GameInfos= (Collection<GameInfo>) query.getResultList();
		return jsonOb.getJSONForObject(GameInfos);
	}

	@Transactional(REQUIRED)
	public String updateGameInfo(GameInfo gi) {
		GameInfo gameInfoInDB = findGameInfo(gi.getGameId());
		gameInfoInDB.setSaveName(gi.getSaveName());
		gameInfoInDB.setMoney(gi.getMoney());
		return "{\"message\": \"GameInfo has been sucessfully updated\"}";
	}
	
	private GameInfo findGameInfo(long id) {
		return manager.find(GameInfo.class, id);
	}


	public void setManager(EntityManager manager) {
		this.manager = manager;
	}


}
