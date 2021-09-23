package net.javaguides.springboot.services;

import net.javaguides.springboot.model.Bid;
import net.javaguides.springboot.model.Players;
import net.javaguides.springboot.model.Teams;
import net.javaguides.springboot.repository.PlayersRepository;
import net.javaguides.springboot.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class PlayersService {
    @Autowired
    private PlayersRepository playersRepository;
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost", "root", "root");

    public PlayersService() throws SQLException {
    }


    @Autowired
    private TeamsRepository teamsRepository;

    public List<Players> playersList() {
        return playersRepository.findAll();

    }

    public boolean setBid(Bid bid) {
        boolean status= false;
        Players p = playersRepository.getOne(bid.getPlayerid());
        p.setBid(bid.getBid());
        p.setTeamid(bid.getTeamid());

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

}
