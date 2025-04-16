package org.torneo.business;

import org.torneo.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImplList implements UserDao {

    private final List<User> users;

    public UserDaoImplList() {
        this.users = new ArrayList<>();
        loadData();
    }

    private void loadData() {
        User user1 = new User("U001", "Ana", "García", "López", "ana.garcia@example.com", "600123456", "admin", null, "pass123");
        User user2 = new User("U002", "Luis", "Martínez", "Pérez", "luis.martinez@example.com", "600234567", "player", "T002", "secure456");
        User user3 = new User("U003", "Marta", "Sánchez", "Ruiz", "marta.sanchez@example.com", "600345678", "player", "T002", "marta789");
        User user4 = new User("U004", "Carlos", "Fernández", "Gómez", "carlos.fernandez@example.com", "600456789", "manager", null, "carlospass");
        User user5 = new User("U005", "Elena", "Moreno", "Núñez", "elena.moreno@example.com", "600567890", "player", "T002", "elenasecret");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
    }

    @Override
    public User findByUserName(String userName) {
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findByTeam(String teamId) {
        List<User> aux = new ArrayList<>();

        for (User user : users) {
            if (user.getTeamId().equals(teamId)) {
                aux.add(user);
            }
        }

        return aux;
    }

    @Override
    public User findById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public int insertOne(User entity) {
        if (!users.contains(entity)) {
            users.add(entity);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateOne(User entity) {
        int index = users.indexOf(entity);
        if (index != -1) {
            users.set(index, entity);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteOne(String id) {
        User user = findById(id);
        if (user != null) {
            users.remove(user);
            return 1;
        }
        return 0;
    }
}
