package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "team")
public class Teams {
    @Id
    private int teamid;

    private String teamname;

    private int nop;

    private Teams(){

    }
    public Teams(int teamid, String teamname, int nop) {
        this.teamid = teamid;
        this.teamname = teamname;
        this.nop = nop;
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

    public int getNop() {
        return nop;
    }

    public void setNop(int nop) {
        this.nop = nop;
    }

    @Override
    public String toString() {
        return "Teams{" +
                "teamid=" + teamid +
                ", teamname='" + teamname + '\'' +
                ", nop=" + nop +
                '}';
    }

}
