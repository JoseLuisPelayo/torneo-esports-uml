package org.torneo.business;

import org.torneo.model.Player;
import org.torneo.utils.AbsGenericImplMy8;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayerDaoImplMy8Jdbc extends AbsGenericImplMy8 implements PlayerDao {


    @Override
    public Player findByUserName(String userName) {
        sql = "select * from players where username = ?";
        Player p = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);

            rs = ps.executeQuery();
            if (rs.next()) {
                p = new Player();

                p.setDni(rs.getString("dni"));
                p.setName(rs.getString("name"));
                p.setLName1(rs.getString("l_name1"));
                p.setLName2(rs.getString("l_name2"));
                p.setEmail(rs.getString("email"));
                p.setPhone(rs.getString("phone"));
                p.setTeamName(rs.getString("team_name"));
                p.setDateOfBirth(LocalDate.parse(rs.getString("date_of_birth")));
                p.setUserName(rs.getString("user_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return p;
    }

    @Override
    public Player findById(String id) {
        sql = "select * from players where username = ?";
        Player p = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                p = new Player();

                p.setDni(rs.getString("dni"));
                p.setName(rs.getString("name"));
                p.setLName1(rs.getString("l_name1"));
                p.setLName2(rs.getString("l_name2"));
                p.setEmail(rs.getString("email"));
                p.setPhone(rs.getString("phone"));
                p.setTeamName(rs.getString("team_name"));
                p.setDateOfBirth(LocalDate.parse(rs.getString("date_of_birth")));
                p.setUserName(rs.getString("user_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return p;
    }

    @Override
    public List<Player> findAll() {
        sql = "select * from players";
        List<Player> aux = new ArrayList<Player>();
        Player p = null;

        try {
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Player();

                p.setDni(rs.getString("dni"));
                p.setName(rs.getString("name"));
                p.setLName1(rs.getString("l_name1"));
                p.setLName2(rs.getString("l_name2"));
                p.setEmail(rs.getString("email"));
                p.setPhone(rs.getString("phone"));
                p.setTeamName(rs.getString("team_name"));
                p.setDateOfBirth(LocalDate.parse(rs.getString("date_of_birth")));
                p.setUserName(rs.getString("user_name"));

                aux.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return aux;
    }

    @Override
    public int insertOne(Player entity) {
        sql = "insert into players (dni," +
                " name," +
                " l_name1," +
                " l_name2," +
                " email," +
                " phone, " +
                " team_name, " +
                " date_of_birth," +
                " user_name) " +
                "values(?,?,?,?,?,?,?,?)";
        rows = 0;

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, entity.getDni());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getLName1());
            ps.setString(4, entity.getLName2());
            ps.setString(5, entity.getEmail());
            ps.setString(6, entity.getPhone());
            ps.setString(7, entity.getTeamName());
            ps.setString(8, entity.getDateOfBirth().toString());
            ps.setString(9, entity.getUserName());

            rows = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rows;
    }

    @Override
    public int updateOne(Player entity) {
        sql = "update players set " +
                "name = ?," +
                "l_name1 = ?," +
                "l_name2 = ?" +
                "email = ?," +
                "phone = ?, " +
                "team_name = ?," +
                "date_of_bird = ?," +
                "user_name = ?" +
                " where dni = ?";
        rows = 0;

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(9, entity.getDni());
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getLName1());
            ps.setString(3, entity.getLName2());
            ps.setString(4, entity.getEmail());
            ps.setString(5, entity.getPhone());
            ps.setString(6, entity.getTeamName());
            ps.setString(7, entity.getDateOfBirth().toString());
            ps.setString(8, entity.getUserName());

            rows = ps.executeUpdate();
        } catch (SQLException e) {
            rows = -1;
            e.printStackTrace();
        }

        return rows;
    }

    @Override
    public int deleteOne(String id) {
        sql = "delete from players where dni = ?";
        rows = 0;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            rows = -1;
        }

        return rows;
    }
}
