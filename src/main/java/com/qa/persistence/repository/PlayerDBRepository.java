package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Teamsheet;
import com.qa.persistence.domain.Player;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class PlayerDBRepository implements PlayerRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonOb;
	
	public String getAllPlayers() {
		Query query = manager.createQuery("Select t FROM Player t");
		Collection<Player> players = (Collection<Player>) query.getResultList();
		return jsonOb.getJSONForObject(players);
	}
	
	@Transactional(REQUIRED)
	public String createPlayer(String player) {
		Player aPlayer = jsonOb.getObjectForJSON(player, Player.class);
		manager.persist(aPlayer);
		return "{\"message\": \"Player has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String deletePlayer(long id) {
		Player playerInDB = findPlayer(id);
		if (playerInDB != null) {
			manager.remove(playerInDB);
		}
		return "{\"message\": \"Player sucessfully deleted\"}";
	}

	public String getPlayer(long id) {
		Player PlayerInDB = findPlayer(id);
		return jsonOb.getJSONForObject(PlayerInDB);
	}
	
	@Transactional(REQUIRED)
	public String updatePlayer(Player p) {
		Player playerInDB = findPlayer(p.getPlayerId());
		playerInDB.setfName(p.getfName());
		playerInDB.setlName(p.getlName());
		return "{\"message\": \"Player has been sucessfully updated\"}";
	}
	
	
	private Player findPlayer(long id) {
		return manager.find(Player.class, id);
	}


	public void setManager(EntityManager manager) {
		this.manager = manager;
	}


		
}
