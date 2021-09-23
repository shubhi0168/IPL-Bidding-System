package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Bid;
import net.javaguides.springboot.model.Players;
import net.javaguides.springboot.repository.PlayersRepository;
import net.javaguides.springboot.services.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PlayersController {
    @Autowired
    private PlayersService playersService;

    @GetMapping("/dummy2")
    public int dummy2(@RequestParam("x") int x){
        return 1;
    };

    @GetMapping("/getPlayersList")
    public List<Players> playersList(){
        return playersService.playersList();
    }

    @GetMapping("/setBid")
    public boolean setBid(@RequestBody Bid bid){
        return playersService.setBid(bid);
    }

    @GetMapping("/setBase")
    public void setBid(int base_price, int player_id){
        playersService.setBase(base_price, player_id);
    }

}
