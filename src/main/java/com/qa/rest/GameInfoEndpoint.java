package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.service.GameInfoService;
import com.qa.persistence.domain.GameInfo;
import com.qa.util.JSONUtil;

@Path("/gameinfo")
public class GameInfoEndpoint {

	@Inject
	private GameInfoService service;

	
	@Inject
	private JSONUtil jsonOb;
	
	@Path("/getAllGameInfo")
	@GET
	@Produces({ "application/json" })
	public String getAllGameInfo() {
		return service.getAllGameInfo();
	}
	
	@Path("/updateGameInfo")
	@PUT
	@Produces({ "application/json" })
	public String updateGameInfo(String gi) {
		GameInfo giObj= jsonOb.getObjectForJSON(gi, GameInfo.class);
		return service.updateGameInfo(giObj);
	}
	
	public void setService(GameInfoService service) {
		this.service = service;
	}
	
	
}
