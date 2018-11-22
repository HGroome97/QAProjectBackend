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

import com.qa.business.service.TeamsheetService;
import com.qa.business.service.PlayerService;
import com.qa.persistence.domain.Teamsheet;
import com.qa.persistence.domain.Player;
import com.qa.util.JSONUtil;

@Path("/player")
public class PlayerEndpoint {
	
	@Inject
	private PlayerService service;

	
	@Inject
	private JSONUtil jsonOb;
	
	@Path("/getAllPlayers")
	@GET
	@Produces({ "application/json" })
	public String getAllPlayers() {
		return service.getAllPlayers();
	}

	@Path("/getAllPlayersWithTeamName/{teamName}")
	@GET
	@Produces({ "application/json" })
	public String getAllPlayersWithTeamName(@PathParam("teamName") String teamName ) {
		return service.getAllPlayersWithTeamName(teamName);
	}
	
	@Path("/getAllPlayersWithoutTeamName/{teamName}")
	@GET
	@Produces({ "application/json" })
	public String getAllPlayersWithoutTeamName(@PathParam("teamName") String teamName ) {
		return service.getAllPlayersWithoutTeamName(teamName);
	}

	@Path("/createPlayer")
	@POST
	@Produces({ "application/json" })
	public String addPlayer(String p) {
		return service.createPlayer(p);
	}

	@Path("/deletePlayer/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deletePlayer(@PathParam("id") Long id) {
		return service.deletePlayer(id);
	}
	
	@Path("/getPlayer/{id}")
	@GET
	@Produces({ "application/json" })
	public String getPlayer(@PathParam("id") Long id) {
		return service.getPlayer(id);
	}
	
	@Path("/updatePlayer")
	@PUT
	@Produces({ "application/json" })
	public String updatePlayer(String p) {
		Player pObj= jsonOb.getObjectForJSON(p, Player.class);
		return service.updatePlayer(pObj);
	}

	public void setService(PlayerService service) {
		this.service = service;
	}

}
