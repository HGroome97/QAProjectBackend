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
import com.qa.persistence.domain.Teamsheet;
import com.qa.util.JSONUtil;

@Path("/teamsheet")
public class TeamsheetEndpoint {
	
	@Inject
	private TeamsheetService service;

	
	@Inject
	private JSONUtil jsonOb;
	
	@Path("/getAllTeamsheets")
	@GET
	@Produces({ "application/json" })
	public String getAllTeamsheets() {
		return service.getAllTeamsheets();
	}

	@Path("/createTeamsheet")
	@POST
	@Produces({ "application/json" })
	public String addTeamsheet(String ts) {
		return service.createTeamsheet(ts);
	}

	@Path("/deleteTeamsheet/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTeamsheet(@PathParam("id") Long id) {
		return service.deleteTeamsheet(id);
	}
	
	@Path("/getTeamsheet/{id}")
	@GET
	@Produces({ "application/json" })
	public String getTeamsheet(@PathParam("id") Long id) {
		return service.getTeamsheet(id);
	}
	
	@Path("/updateTeamsheet")
	@PUT
	@Produces({ "application/json" })
	public String updateTeamsheet(String ts) {
		Teamsheet tsObj= jsonOb.getObjectForJSON(ts, Teamsheet.class);
		return service.updateTeamsheet(tsObj);
	}
	
	@Path("/searchTeamsheet/{name}")
	@GET
	@Produces({ "application/json" })
	public String searchByName(@PathParam("name") String name) {
		return service.searchByName(name);
	}

	public void setService(TeamsheetService service) {
		this.service = service;
	}

}
