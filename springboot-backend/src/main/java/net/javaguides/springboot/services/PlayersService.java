package net.javaguides.springboot.services;

import net.javaguides.springboot.model.Bid;
import net.javaguides.springboot.model.Players;
import net.javaguides.springboot.model.Result;
import net.javaguides.springboot.model.Teams;
import net.javaguides.springboot.repository.PlayersRepository;
import net.javaguides.springboot.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayersService {
    @Autowired
    private PlayersRepository playersRepository;

    @Autowired
    private TeamsRepository teamsRepository;

    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost", "root", "root");

    public PlayersService() throws SQLException {
    }

    public List<Players> playersList() {
        return playersRepository.findAll();

    }

    public boolean setBid(Bid bid) {
        boolean status= false;
        Players p = playersRepository.getOne(bid.getPlayerid());
        p.setBid(bid.getBid());
        p.setTeamid(bid.getTeamid());
        p.setSold(true);

        Teams t = teamsRepository.getOne(bid.getTeamid());
        t.setNop(t.getNop()+1);
        if(playersRepository.existsById(bid.getPlayerid()))
        {
            playersRepository.save(p);
            teamsRepository.save(t);
            status=true;
        }
        return status;
    }


    public void setBase(int player_id, int base_price){
        try {
            Statement setBase = conn.createStatement();
            setBase.executeQuery("UPDATE players " +
                    "SET base =" + base_price +
                    "WHERE playerid = " + player_id + ";");
        }
        catch (SQLException sq){

        }
    }

    public List<Result> getResult() {
        List<Result> r = new ArrayList<Result>();
        List<Players> p = playersRepository.findAll();
        List<Teams> t = teamsRepository.findAll();

        for (int i = 0; i < t.size(); i++)
        {
            int tteamid = t.get(i).getTeamid();
            System.out.println(tteamid);
            Result res = new Result();
            res.setTeamid(t.get(i).getTeamid());
            res.setTeamname(t.get(i).getTeamname());

            List<Players> lisPlayers = new ArrayList<Players>();
            for( int j=0; j<p.size(); j++) {
                int pteamid = p.get(j).getTeamid();
                if(tteamid==pteamid)
                    lisPlayers.add(p.get(j));
            }
            res.setPlayers(lisPlayers);
            r.add(res);
        }
        return r;
    }
}
