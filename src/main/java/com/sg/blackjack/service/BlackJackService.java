package com.sg.blackjack.service;

import com.sg.blackjack.model.Cards;

import java.util.List;

public interface BlackJackService {

    List<Cards> shuffleDeck(); // get cards from DB and shuffle.

    Cards dealCard(List<Cards> deck);
}
