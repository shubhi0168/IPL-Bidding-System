package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Bid;
import net.javaguides.springboot.model.Players;
import net.javaguides.springboot.model.Teams;
import net.javaguides.springboot.services.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class TeamsController {
    @Autowired
    private TeamsService teamsService;

    @GetMapping("/dummy")
    public int dummy(@RequestParam("x") int x){
        return 1;
    };


    @GetMapping("/getTeamsList")
    public List<Teams> teamsList(){
        return teamsService.teamsList();}




}
