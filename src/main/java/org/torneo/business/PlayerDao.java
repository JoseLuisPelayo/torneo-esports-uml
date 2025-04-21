package org.torneo.business;

import org.torneo.model.Player;

import java.util.List;

public interface PlayerDao extends GenericCrud<Player, String> {
    Player findByUserName(String userName);
    List<Player> findPlayersTeam(String teamName);
}
