package org.torneo.business;

import org.torneo.model.Player;

public interface PlayerDao extends GenericCrud<Player, String> {
    Player findByUserName(String userName);
}
