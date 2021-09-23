package net.javaguides.springboot.services;

import net.javaguides.springboot.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamsService {
    @Autowired
    private TeamsRepository teamsRepository;

}
