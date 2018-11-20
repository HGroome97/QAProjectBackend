package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teamsheet_Player {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long teamsheetPlayerId;
	private long teamsheetId;
	private long playerId;
	private long posNo;
	
	public long getTeamsheetPlayerId() {
		return teamsheetPlayerId;
	}
	public void setTeamsheetPlayerId(long teamsheetPlayerId) {
		this.teamsheetPlayerId = teamsheetPlayerId;
	
	}
	public long getTeamsheetId() {
		return teamsheetId;
	}
	public void setTeamsheetId(long teamsheetId) {
		this.teamsheetId = teamsheetId;
	}
	public long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}
	public long getPosNo() {
		return posNo;
	}
	public void setPosNo(long posNo) {
		this.posNo = posNo;
	}
	@Override
	public String toString() {
		return "Teamsheet_Player [teamsheetPlayerId=" + teamsheetPlayerId + ", teamsheetId=" + teamsheetId
				+ ", playerId=" + playerId + ", posNo=" + posNo + "]";
	}
}
