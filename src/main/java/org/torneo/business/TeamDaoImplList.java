package org.torneo.business;

import org.torneo.model.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamDaoImplList implements TeamDao {
    private List<Team> teams;

    public TeamDaoImplList() {
        this.teams = new ArrayList<Team>();
    }

    private void loadData() {
        teams.add(new )
    }

    @Override
    public Team findByManager(String managerId) {
        return null;
    }

    @Override
    public Team findById(String id) {
        return null;
    }

    @Override
    public List<Team> findAll() {
        return List.of();
    }

    @Override
    public int insertOne(Team entity) {
        return 0;
    }

    @Override
    public int updateOne(Team entity) {
        return 0;
    }

    @Override
    public int deleteOne(String id) {
        return 0;
    }
}
