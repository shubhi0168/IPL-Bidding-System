package net.javaguides.springboot.model;

public class Bid {
    private int teamid;
    private int playerid;
    private int bid;

    public Bid() {
    }

    public Bid(int teamid, int playerid, int bid) {
        this.teamid = teamid;
        this.playerid = playerid;
        this.bid = bid;
    }

    public int getTeamid() {
        return teamid;
    }

    public void setTeamid(int teamid) {
        this.teamid = teamid;
    }

    public int getPlayerid() {
        return playerid;
    }

    public void setPlayerid(int playerid) {
        this.playerid = playerid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }
}
