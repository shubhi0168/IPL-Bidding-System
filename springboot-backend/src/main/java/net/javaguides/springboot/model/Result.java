package net.javaguides.springboot.model;

import java.util.List;


public class Result {


    private int teamid;
    private String teamname;
    private List<Players> players;

    public Result(int teamid, String teamname, List<Players> players) {
        this.teamid = teamid;
        this.teamname = teamname;
        this.players = players;
    }

    public Result() {
    }

    public int getTeamid() {
        return teamid;
    }

    public void setTeamid(int teamid) {
        this.teamid = teamid;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public List<Players> getPlayers() {
        return players;
    }

    public void setPlayers(List<Players> players) {
        this.players = players;
    }
}
