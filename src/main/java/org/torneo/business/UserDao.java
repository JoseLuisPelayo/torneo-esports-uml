package org.torneo.business;

import org.torneo.model.User;

import java.util.List;

public interface UserDao extends GenericCrud<User, String> {
    User findByUserName(String userName);
    List<User> findByTeam(String teamId);
}
