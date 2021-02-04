package com.sg.blackjack.controller;

import com.sg.blackjack.model.Game;
import com.sg.blackjack.model.Player;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blackjack")
public class BlackJackController {

    @PostMapping("/begin")
    public Player beginGame() {
        // return player?
        return null;
    }

    @PostMapping("/game/{action}") // action = hit or stay
    public Game playGame(@PathVariable String action) {
        // return game?
        return null;
    }
}
