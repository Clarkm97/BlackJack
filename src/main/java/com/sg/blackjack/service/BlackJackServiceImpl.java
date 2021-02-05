package com.sg.blackjack.service;

import com.sg.blackjack.data.CardsDataBaseDao;
import com.sg.blackjack.model.Cards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BlackJackServiceImpl implements BlackJackService {

    final JdbcTemplate jdbc;

    @Autowired
    public BlackJackServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    @Override
    public List<Cards> shuffleDeck() {

        final String sql = "SELECT * FROM cards;";
        List<Cards> deck = jdbc.query(sql, new CardsDataBaseDao.CardsMapper());

        Collections.shuffle(deck);

        return deck;
    }

    @Override
    public Cards dealCard(List<Cards> deck) {

        List<Cards> playerHand = new ArrayList<>();
        List<Cards> dealerHand = new ArrayList<>();

        int lastCard = deck.size() - 1;

        for(int i = 0; i < 2; i++) {
            playerHand.add(deck.get(lastCard));
            deck.remove(lastCard);
            lastCard--;
            dealerHand.add(deck.get(lastCard));
            deck.remove(lastCard);
            lastCard--;
        }

        return null;
    }


}
