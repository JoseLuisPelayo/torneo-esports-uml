package org.torneo.business;

import org.torneo.model.Player;
import org.torneo.model.Team;

import java.util.List;

public interface TeamDao extends GenericCrud<Team, String> {
    List<Player> findPlayersTeam(String teamName);
}
