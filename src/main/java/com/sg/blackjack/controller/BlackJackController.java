package com.sg.blackjack.controller;

import com.sg.blackjack.data.CardsDao;
import com.sg.blackjack.data.Cards_Owned_By_PlayersDao;
import com.sg.blackjack.data.GameDao;
import com.sg.blackjack.model.Cards;
import com.sg.blackjack.model.Game;
import com.sg.blackjack.service.BlackJackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blackjack")
public class BlackJackController {

    private final GameDao gameDao;
    private final CardsDao cardsDao;
    private final BlackJackServiceImpl service;

    private final Cards_Owned_By_PlayersDao cobpDao;
    @Autowired
    public BlackJackController(GameDao gameDao, BlackJackServiceImpl service, CardsDao cardsDao,Cards_Owned_By_PlayersDao cobpDao) {
        this.gameDao = gameDao;
        this.service = service;
        this.cardsDao = cardsDao;
        this.cobpDao = cobpDao;
    }

    @PostMapping("/begin/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public Game beginGame(@PathVariable String name) {
        // creates game and two players (dealer/player)

        Game game = gameDao.addGame(new Game(), name);
        List<Cards> cardsList = cardsDao.getAllCards();

        // deal 2 cards to player, 2 cards to dealer to start game
        cardsList = service.dealCard(cardsList, game.getPlayerId());
        cardsList = service.dealCard(cardsList, game.getPlayerId());
        cardsList = service.dealCard(cardsList, game.getDealerId());
        cardsList = service.dealCard(cardsList, game.getDealerId());
        return game;

    }
    @GetMapping("/game")
    public List<Game> allGames(){
        // return list of all games in database
        return gameDao.getAllGames();
    }
    @GetMapping("/game/{gameId}")
    public ResponseEntity<Game> getGame(@PathVariable int gameId){
        // returns 1 game based on given Id
        Game result = gameDao.findByGameID(gameId);
        if (result == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/player/{gameId}")
    public List<Cards> getPlayerCards(@PathVariable int gameId){

        Game temp = gameDao.findByGameID(gameId);
        return cobpDao.getCardsByPlayerID(temp.getPlayerId());
    }

    @GetMapping("/dealer/{gameId}")
    public List<Cards> getDealerCards(@PathVariable int gameId){

        Game temp = gameDao.findByGameID(gameId);
        List<Cards> cardsList = cardsDao.getAllCards();
        service.dealerHand( cardsList ,temp.getDealerId());
        return cobpDao.getCardsByPlayerID(temp.getDealerId());
    }


    @PostMapping("/game/{gameId}/{action}") // action = hit or stay
    public Game playGame(@PathVariable int gameId,String action) {
        // returns updated version of game after action

        return null;
    }

}