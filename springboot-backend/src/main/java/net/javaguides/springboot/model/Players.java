package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Players {
    @Id
    private Integer playerid;

    private String playername;

    private int base;

    private int bid;

    private boolean sold;

    private int performance;

    private int socialrating;

    private int recentform;

    private int cumulativerating;

    private int teamid;

    public Players(){

    }

    public Players(int playerid, String playername, int base, int bid, boolean sold, int performance, int socialrating, int recentform, int cumulativerating, int teamid) {
        this.playerid = playerid;
        this.playername = playername;
        this.base = base;
        this.bid = bid;
        this.sold = sold;
        this.performance = performance;
        this.socialrating = socialrating;
        this.recentform = recentform;
        this.cumulativerating = cumulativerating;
        this.teamid = teamid;
    }



    public int getPlayerid() {
        return playerid;
    }

    public void setPlayerid(int playerid) {
        this.playerid = playerid;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public int getSocialrating() {
        return socialrating;
    }

    public void setSocialrating(int socialrating) {
        this.socialrating = socialrating;
    }

    public int getRecentform() {
        return recentform;
    }

    public void setRecentform(int recentform) {
        this.recentform = recentform;
    }

    public int getCumulativerating() {
        return cumulativerating;
    }

    public void setCumulativerating(int cumulativerating) {
        this.cumulativerating = cumulativerating;
    }

    public int getTeamid() {
        return teamid;
    }

    public void setTeamid(int teamid) {
        this.teamid = teamid;
    }
}
