package com.sg.blackjack.controller;

import com.sg.blackjack.data.GameDao;
import com.sg.blackjack.data.GameDataBaseDao;
import com.sg.blackjack.model.Game;
import com.sg.blackjack.model.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blackjack")
public class BlackJackController {

    @PostMapping("/begin/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public Game beginGame(@PathVariable String name) {

        //creates game and two players (dealer/player)
        // return game
        return null;
    }
    @GetMapping("/game")
    public List<Game> allGames(){
        // return list of all games in database
        return null;
    }
    @GetMapping("/game/{gameId}")
    public ResponseEntity<Game> getGame(@PathVariable int gameId){
        // returns 1 game based on given Id

        return null;

    }

    @PostMapping("/game/{action}") // action = hit or stay
    public Game playGame(@PathVariable String action) {
        // returns updated version of game after action
        return null;
    }

}
