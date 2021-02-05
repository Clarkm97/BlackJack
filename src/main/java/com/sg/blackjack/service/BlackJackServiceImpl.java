package com.sg.blackjack.service;

import com.sg.blackjack.data.CardsDataBaseDao;
import com.sg.blackjack.data.Cards_Owned_By_PlayersDao;
import com.sg.blackjack.data.Cards_Owned_By_PlayersDataBaseDao;
import com.sg.blackjack.data.GameDataBaseDao;
import com.sg.blackjack.model.Cards;
import com.sg.blackjack.model.Cards_Owned_By_Players;
import com.sg.blackjack.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BlackJackServiceImpl implements BlackJackService {

    final JdbcTemplate jdbc;
    final Cards_Owned_By_PlayersDataBaseDao cardsOwnedByPlayersDataBaseDao;

    @Autowired
    public BlackJackServiceImpl(JdbcTemplate jdbcTemplate, Cards_Owned_By_PlayersDataBaseDao cardsOwnedByPlayersDataBaseDao) {
        this.jdbc = jdbcTemplate;
        this.cardsOwnedByPlayersDataBaseDao = cardsOwnedByPlayersDataBaseDao;

    }



    @Override
    public List<Cards> dealCard(List<Cards> deck, int playerId) {
        Collections.shuffle(deck);
        cardsOwnedByPlayersDataBaseDao.addCardsOwnedByPlayer(deck.get(0).getCardId(),playerId);
        deck.remove(0);
        return deck;
    }

    @Override
    public List<Cards> dealerHand(List<Cards> deck, int playerId) {
        while(cardsOwnedByPlayersDataBaseDao.totalCardValueByPlayer(playerId)<17){
        Collections.shuffle(deck);
        cardsOwnedByPlayersDataBaseDao.addCardsOwnedByPlayer(deck.get(0).getCardId(),playerId);
        deck.remove(0);}
        return deck;
    }


}
