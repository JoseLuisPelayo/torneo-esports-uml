package org.torneo.business;

import org.torneo.model.Team;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeamDaoImplList implements TeamDao {
    private List<Team> teams;
    private UserDao uDao;

    public TeamDaoImplList() {
        this.teams = new ArrayList<Team>();
        this.uDao = new UserDaoImplList();
        loadData();
    }

    private void loadData() {
        teams.add(new Team("T002", "Furia", uDao.findById("U004"), uDao.findByTeam("T002"), LocalDate.of(2025,4,16)));
    }

    @Override
    public Team findByManager(String managerId) {
        for (Team team : teams) {
            if (team.getManager().getId().equals(managerId)) {
                return team;
            }
        }
        return null;
    }

    @Override
    public Team findById(String id) {
        for (Team team : teams) {
            if (team.getId().equals(id)) {
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
    public int deleteOne(String id) {
        Team team = findById(id);
        if (team != null) {
            teams.remove(team);
            return 1;
        }
        return 0;
    }
}
