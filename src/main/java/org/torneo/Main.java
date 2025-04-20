package org.torneo;


import org.torneo.view.PlayerTeamManagerCLI;

public class Main {

    private static final PlayerTeamManagerCLI playerTeamManagerCLI;

    static {
        playerTeamManagerCLI = new PlayerTeamManagerCLI();
    }

    public static void main(String[] args) {
        playerTeamManagerCLI.menu();
    }
}