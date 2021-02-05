package com.sg.blackjack.controller;

import com.sg.blackjack.data.GameDao;
import com.sg.blackjack.data.GameDataBaseDao;
import com.sg.blackjack.model.Game;
import com.sg.blackjack.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blackjack")
public class BlackJackController {

    private final GameDao gameDao;

    @Autowired
    public BlackJackController(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @PostMapping("/begin/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public Game beginGame(@PathVariable String name) {
        // creates game and two players (dealer/player)
        return gameDao.addGame(new Game(), name);
    }
    @GetMapping("/game")
    public List<Game> allGames(){
        // return list of all games in database
        return gameDao.getAllGames();
    }
    @@GetMapping("/game/{gameId}")
    public ResponseEntity<Game> getGame(@PathVariable int gameId){
        // returns 1 game based on given Id
        Game result = gameDao.findByGameID(gameId);
        if (result == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/game/{gameId}/{action}") // action = hit or stay
    public Game playGame(@PathVariable int gameId,String action) {
        // returns updated version of game after action
        return null;
    }

}