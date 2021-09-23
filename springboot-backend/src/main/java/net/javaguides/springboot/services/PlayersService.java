package net.javaguides.springboot.services;

import net.javaguides.springboot.model.Players;
import net.javaguides.springboot.repository.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayersService {
    @Autowired
    private PlayersRepository playersRepository;

    public List<Players> playersList() {
        return playersRepository.findAll();

    }
}
