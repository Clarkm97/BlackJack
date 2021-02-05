package com.sg.blackjack.service;

import com.sg.blackjack.model.Cards;
import com.sg.blackjack.model.Game;

import java.util.List;

public interface BlackJackService {



    List<Cards> dealCard(List<Cards> deck, int playerId);

    List<Cards> dealerHand(List<Cards> deck, int playerId);
}
