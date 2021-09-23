package net.javaguides.springboot.services;

import net.javaguides.springboot.model.Bid;
import net.javaguides.springboot.model.Players;
import net.javaguides.springboot.model.Teams;
import net.javaguides.springboot.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamsService {
    @Autowired
    private TeamsRepository teamsRepository;


    public List<Teams> teamsList() {
       return teamsRepository.findAll();
    }

}
