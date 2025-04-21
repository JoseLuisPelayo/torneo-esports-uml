package org.torneo.business;

import org.torneo.model.Player;
import org.torneo.model.Team;
import org.torneo.utils.AbsGenericImplMy8;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TeamDaoImplMy8Jdbc extends AbsGenericImplMy8 implements TeamDao {
    @Override
    public List<Player> findPlayersTeam(String teamName) {
        sql = "SELECT * FROM players WHERE team_name = ?";
        List<Player> aux = new ArrayList<>();
        Player p = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, teamName);
            rs = ps.executeQuery();

            while (rs.next()) {
                p = new Player();
                p.setDni(rs.getString("dni"));
                p.setName(rs.getString("name"));
                p.setLName1(rs.getString("l_name2"));
                p.setEmail(rs.getString("email"));
                p.setPhone(rs.getString("phone"));
                p.setDateOfBirth(LocalDate.parse(rs.getString("date_of_birth")));
                p.setUserName(rs.getString("user_name"));
                p.setTeamName(rs.getString("team_name"));

                aux.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return aux;
    }

    @Override
    public Team findById(String id) {
        sql = "SELECT * FROM team WHERE id = ?";
        Team t = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                t = new Team();

                t.setName(rs.getString("name"));
                t.setCreationDate(LocalDate.parse(rs.getString("creation_date")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return t;
    }

    @Override
    public List<Team> findAll() {
        sql = "SELECT * FROM team";
        List<Team> aux = new ArrayList<>();
        Team t = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                t = new Team();

                t.setName(rs.getString("name"));
                t.setCreationDate(LocalDate.parse(rs.getString("creation_date")));

                aux.add(t);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return aux;
    }

    @Override
    public int insertOne(Team entity) {
        sql = "INSERT INTO team (name, creation_date) VALUES (?, ?)";
        rows = 0;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, entity.getName());
            ps.setString(2, LocalTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public int updateOne(Team entity) {
        sql = "UPDATE team SET creation_date = ? WHERE id = ?";
        rows = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(2, entity.getName());
            ps.setString(1, LocalTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            rows = -1;
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int deleteOne(String id) {
        sql = "DELETE FROM team WHERE id = ?";
        rows = 0;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            rows = -1;
            e.printStackTrace();
        }

        return rows;
    }
}
