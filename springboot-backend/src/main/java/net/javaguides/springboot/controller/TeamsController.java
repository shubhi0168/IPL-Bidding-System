package net.javaguides.springboot.controller;

import net.javaguides.springboot.services.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TeamsController {
    @Autowired
    private TeamsService teamsService;

    @GetMapping("/dummy")
    public int dummy(@RequestParam("x") int x){
        return 1;
    };


}
