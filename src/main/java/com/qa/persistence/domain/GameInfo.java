package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GameInfo {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long gameId;
	private String saveName;
	private int money;
	
	
	public long getGameId() {
		return gameId;
	}


	public void setGameId(long gameId) {
		this.gameId = gameId;
	}


	public String getSaveName() {
		return saveName;
	}


	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	@Override
	public String toString() {
		return "GameInfo [gameId=" + gameId + ", saveName=" + saveName + ", money=" + money + "]";
	}
	
	
}
