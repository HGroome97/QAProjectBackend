package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Teamsheet;
import com.qa.persistence.domain.Teamsheet_Player;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TeamsheetDBRepository implements TeamsheetRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonOb;
	
	public String getAllTeamsheets() {
		Query query = manager.createQuery("Select ts FROM Teamsheet ts");
		Collection<Teamsheet> Teamsheets = (Collection<Teamsheet>) query.getResultList();
		return jsonOb.getJSONForObject(Teamsheets);
	}
	
	@Transactional(REQUIRED)
	public String createTeamsheet(String Teamsheet) {
		Teamsheet aTeamsheet = jsonOb.getObjectForJSON(Teamsheet, Teamsheet.class);
		manager.persist(aTeamsheet);
		return "{\"message\": \"Teamsheet has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteTeamsheet(long id) {
		Teamsheet teamsheetInDB = findTeamsheet(id);
		if (teamsheetInDB != null) {
			manager.remove(teamsheetInDB);
		}
		return "{\"message\": \"Teamsheet sucessfully deleted\"}";
	}

	public String getTeamsheet(long id) {
		Teamsheet teamsheetInDB = findTeamsheet(id);
		return jsonOb.getJSONForObject(teamsheetInDB);
	}
	
	@Transactional(REQUIRED)
	public String updateTeamsheet(Teamsheet ts) {
		Teamsheet teamsheetInDB = findTeamsheet(ts.getTeamsheetId());
		teamsheetInDB.setSaveName(ts.getSaveName());
		teamsheetInDB.setNumDefenders(ts.getNumDefenders());
		teamsheetInDB.setNumMidfielders(ts.getNumMidfielders());
		teamsheetInDB.setNumAttackers(ts.getNumAttackers());
		
		teamsheetInDB.setPlayers(ts.getPlayers());
		return "{\"message\": \"Teamsheet has been sucessfully updated\"}";
	}
	
	public String searchByName(String name) {
		TypedQuery<Teamsheet> query = manager.createQuery("Select ts FROM Teamsheet AS ts where ts.saveName = '"+name+"'", Teamsheet.class);
		Collection<Teamsheet> Teamsheet = (Collection<Teamsheet>) query.getResultList();
		return jsonOb.getJSONForObject(Teamsheet);
	}
	
	
	private Teamsheet findTeamsheet(long id) {
		return manager.find(Teamsheet.class, id);
	}


	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

		
}
