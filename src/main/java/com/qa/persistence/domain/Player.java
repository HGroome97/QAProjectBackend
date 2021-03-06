package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Player {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	//@JoinColumn(name = "playerId")
	private long playerId;
	
	private String fName;
	private String lName;
	private int rating;
	private int price;
	private String team;
	

	
	public Player() {
		
	}
	
	public Player(long playerId, String fName, String lName) {
		this.playerId = playerId;
		this.fName = fName;
		this.lName = lName;
	}

	public Player(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", fName=" + fName + ", lName=" + lName + ", rating=" + rating
				+ ", price=" + price + ", team=" + team + "]";
	}


	
	
}
