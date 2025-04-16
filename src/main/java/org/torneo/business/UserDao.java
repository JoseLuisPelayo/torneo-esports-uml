package org.torneo.business;

import org.torneo.model.User;

public interface UserDao extends GenericCrud<User, String> {
    User findByUserName(String userName);
    User findByTeam(String teamId);
}
