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
	private int lastHomeScore;
	private int lastAwayScore;
	
	
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


	public int getLastHomeScore() {
		return lastHomeScore;
	}


	public void setLastHomeScore(int lastHomeScore) {
		this.lastHomeScore = lastHomeScore;
	}


	public int getLastAwayScore() {
		return lastAwayScore;
	}


	public void setLastAwayScore(int lastAwayScore) {
		this.lastAwayScore = lastAwayScore;
	}


	@Override
	public String toString() {
		return "GameInfo [gameId=" + gameId + ", saveName=" + saveName + ", money=" + money + "]";
	}
	
	
}
