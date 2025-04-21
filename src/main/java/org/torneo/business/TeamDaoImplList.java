package org.torneo.business;

import org.torneo.model.Player;
import org.torneo.model.Team;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeamDaoImplList implements TeamDao {
    private final List<Team> teams;
    private final PlayerDao pDao;

    public TeamDaoImplList() {
        this.teams = new ArrayList<Team>();
        this.pDao = new PlayerDaoImplList();
        loadData();
    }

    private void loadData() {
        teams.add(new Team("Furia", LocalDate.of(2025,4,16)));
        teams.add(new Team( "Killers", LocalDate.of(2025,4,16)));
    }

    @Override
    public Team findById(String teamName) {
        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                return team;
            }
        }
        return null;
    }

    @Override
    public List<Team> findAll() {
        return teams;
    }

    @Override
    public int insertOne(Team entity) {
        if (!teams.contains(entity)) {
            teams.add(entity);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateOne(Team entity) {
        int index = teams.indexOf(entity);
        if (index != -1) {
            teams.set(index, entity);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteOne(String teamName) {
        Team team = findById(teamName);
        if (team != null) {
            teams.remove(team);
            return 1;
        }
        return 0;
    }

}
