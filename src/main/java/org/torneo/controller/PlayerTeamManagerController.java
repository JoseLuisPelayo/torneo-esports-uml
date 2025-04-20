package org.torneo.controller;

import org.torneo.business.*;
import org.torneo.model.Player;
import org.torneo.model.Team;

import java.time.LocalDate;
import java.util.List;

public class PlayerTeamManagerController {

    PlayerDao pDao;
    TeamDao tDao;

    public PlayerTeamManagerController() {
        this.tDao = new TeamDaoImplList();
        this.pDao = new PlayerDaoImplMy8Jdbc();
    }

    public String registerTeam(String teamName) {
        Team team = new Team();
        team.setName(teamName);
        team.setCreationDate(LocalDate.now());

        int res = tDao.insertOne(team);

        if (res == 1)
            return "Equipo registrado con exito";

        return "El equipo ya existe o no es válido vuelva a intentarlo";
    }

    public String addPlayerToTeam(String dni, String name, String lName1, String lName2,
                                  String email, String phone, String teamName, LocalDate dateOfBirth, String userName) {

        Team team = tDao.findById(teamName);

        if (team == null)
            return "no hay ningùn equipo con ese nombre";

        Player p = new Player();
        p.setDni(dni);
        p.setName(name);
        p.setLName1(lName1);
        p.setLName2(lName2);
        p.setEmail(email);
        p.setPhone(phone);
        p.setTeamName(teamName);
        p.setDateOfBirth(dateOfBirth);
        p.setUserName(userName);

        int res = pDao.insertOne(p);

        if (res == 1)
            return "jugador añadido correctamente";

        return "El jugador con dni "+ dni + " ya existe";
    }

    public String addPlayerToTeam(String dni, String teamName) {
        Player p = pDao.findById(dni);
        Team t = tDao.findById(teamName);

        if (t == null)
            return "no hay ningùn equipo con ese nombre";

        if (p == null)
            return "no existe un jugador con ese dni";

        if (p.getTeamName() == null) {
            p.setTeamName(teamName);

            int res = pDao.updateOne(p);
            if (res != 1)
                return "Ha ocurrido algun error al modificar el jugador intentelo de nuevo";

            return "Jugador añadido al equipo " + teamName + "correctamente";
        }

        return "El jugador se encuentra actualmente en otro equipo";

    }

    public String removePlayerFromTeam(String dni, String teamName) {
        Team t = tDao.findById(teamName);
        Player p = pDao.findById(dni);

        if (t == null)
            return "no existe un equipo con ese nombre";

        if (p == null)
            return "no existe un jugador con ese dni";

        p.setTeamName(null);
        return "jugador expulsado del equipo " + teamName + "correctamente";
    }

    public String playersList() {
        String res = "Lista de Jugadores\n***********************************************\n";
        List<Player> pList = pDao.findAll();

        int i = 1;

        if (!pList.isEmpty()) {
            for (Player p : pList) {
                res += "  #" + i + p.toString() + "\n";
                i++;
            }
        } else
            res += "No hay ningun jugador registrado";

        return res;
    }

    public String teamsList() {
        List<Team> tList = tDao.findAll();
        String res = "Lista de equipos\n***********************************************\n";
        int i = 1;

        if (!tList.isEmpty()) {
            for (Team t : tList) {
                res += "  #" + i + t.toString() + "\n";
                int count = 1;
                for (Player p: tDao.findPlayersTeam(t.getName())) {
                    res += "    -" + count + " " + p + "\n";
                    count++;
                }
                 if (count == 1)
                     res += "No hay ningun jugador en este equipo\n";
            }
        } else
            res += "No hay ningun equipo registrado";

        return res;
    }
}
