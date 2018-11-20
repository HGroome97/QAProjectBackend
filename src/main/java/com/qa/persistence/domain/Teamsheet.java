package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Teamsheet {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long teamsheetId;
	private String saveName;
	
	private int numDefenders;
	private int numMidfielders;
	private int numAttackers;
	
	
	@ManyToMany(targetEntity = com.qa.persistence.domain.Player.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "Teamsheet_Player",
    joinColumns = @JoinColumn(name = "teamsheetId"),
    inverseJoinColumns = @JoinColumn(name = "playerId")
)private List<Player> players = new ArrayList<>();
	
	
	public Teamsheet() {
		
	}
	
	public Teamsheet(int teamsheetId, String saveName, List<Player> players) {
		this.teamsheetId = teamsheetId;
		this.saveName = saveName;
		this.players = players;
	}

	public Teamsheet(String saveName, List<Player> players) {
		this.saveName = saveName;
		this.players = players;
	}

	
	
	public long getTeamsheetId() {
		return teamsheetId;
	}
	public void setTeamsheetId(long teamsheetId) {
		this.teamsheetId = teamsheetId;
	}
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public int getNumDefenders() {
		return numDefenders;
	}

	public void setNumDefenders(int numDefenders) {
		this.numDefenders = numDefenders;
	}

	public int getNumMidfielders() {
		return numMidfielders;
	}

	public void setNumMidfielders(int numMidfielders) {
		this.numMidfielders = numMidfielders;
	}

	public int getNumAttackers() {
		return numAttackers;
	}

	public void setNumAttackers(int numAttackers) {
		this.numAttackers = numAttackers;
	}

	@Override
	public String toString() {
		return "Teamsheet [teamsheetId=" + teamsheetId + ", saveName=" + saveName + ", numDefenders=" + numDefenders
				+ ", numMidfielders=" + numMidfielders + ", numAttackers=" + numAttackers + ", players=" + players
				+ "]";
	}

	
}
