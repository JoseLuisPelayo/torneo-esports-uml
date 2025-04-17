package org.torneo.business;

import org.torneo.model.Player;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayerDaoImplList implements PlayerDao {

    private final List<Player> players;

    public PlayerDaoImplList() {
        this.players = new ArrayList<>();
        loadData();
    }

    private void loadData() {
        Player player1 = new Player("U001", "Ana", "García", "López",
                "ana.garcia@example.com", "600123456", "T001", LocalDate.of(2000,3,16), "killer");
        Player player2 = new Player("U002", "Luis", "Martínez", "Pérez", "luis.martinez@example.com", "600234567", "T002", LocalDate.of(2001,5,18) ,"secure456");
        Player player3 = new Player("U003", "Marta", "Sánchez", "Ruiz", "marta.sanchez@example.com", "600345678", "T002", LocalDate.of(1998,5,13), "marta789");
        Player player5 = new Player("U005", "Elena", "Moreno", "Núñez", "elena.moreno@example.com", "600567890",  "T002", LocalDate.of(1996,3,23),"elenasecret");

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player5);
    }

    @Override
    public Player findByUserName(String userName) {
        for (Player player : players) {
            if (player.getUserName().equals(userName)) {
                return player;
            }
        }
        return null;
    }

    @Override
    public Player findById(String id) {
        for (Player player : players) {
            if (player.getDni().equals(id)) {
                return player;
            }
        }
        return null;
    }

    @Override
    public List<Player> findAll() {
        return players;
    }

    @Override
    public int insertOne(Player entity) {
        if (!players.contains(entity)) {
            players.add(entity);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateOne(Player entity) {
        int index = players.indexOf(entity);
        if (index != -1) {
            players.set(index, entity);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteOne(String id) {
        Player player = findById(id);
        if (player != null) {
            players.remove(player);
            return 1;
        }
        return 0;
    }
}
