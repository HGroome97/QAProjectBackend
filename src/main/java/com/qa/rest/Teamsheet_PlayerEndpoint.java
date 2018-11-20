package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.qa.business.service.Teamsheet_PlayerService;
import com.qa.persistence.domain.Teamsheet_Player;
import com.qa.util.JSONUtil;

@Path("/teamsheet_player")
public class Teamsheet_PlayerEndpoint {
	
	@Inject
	private Teamsheet_PlayerService service;

	
	@Inject
	private JSONUtil jsonOb;
	
	@Path("/getAllTeamsheet_Players")
	@GET
	@Produces({ "application/json" })
	public String getAllTeamsheet_Player() {
		return service.getAllTeamsheet_Player();
	}

	@Path("/getAllTeamsheet_PlayersWithTeamsheetId/{teamsheetId}")
	@GET
	@Produces({ "application/json" })
	public String getAllTeamsheet_PlayersWithTeamsheetId(@PathParam("teamsheetId") String teamsheetId) {
		return service.getAllTeamsheet_PlayersWithTeamsheetId(teamsheetId);
	}

	
	@Path("/createTeamsheet_Player")
	@POST
	@Produces({ "application/json" })
	public String addTeamsheet_Player(String ts) {
		return service.createTeamsheet_Player(ts);
	}

	@Path("/deleteTeamsheet_Player/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTeamsheet_Player(@PathParam("id") Long id) {
		return service.deleteTeamsheet_Player(id);
	}
	
	@Path("/getTeamsheet_Player/{id}")
	@GET
	@Produces({ "application/json" })
	public String getTeamsheet_Player(@PathParam("id") Long id) {
		return service.getTeamsheet_Player(id);
	}
	
	@Path("/updateTeamsheet_Player")
	@PUT
	@Produces({ "application/json" })
	public String updateTeamsheet_Player(String ts) {
		Teamsheet_Player tsObj= jsonOb.getObjectForJSON(ts, Teamsheet_Player.class);
		return service.updateTeamsheet_Player(tsObj);
	}

	public void setService(Teamsheet_PlayerService service) {
		this.service = service;
	}

}
