package net.javaguides.springboot.services;

import net.javaguides.springboot.model.Players;
import net.javaguides.springboot.repository.PlayersRepository;
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


    public List<Players> playersList() {
        return playersRepository.findAll();

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
