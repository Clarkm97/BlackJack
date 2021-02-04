package com.sg.blackjack.data;

import com.sg.blackjack.model.Cards;

import java.util.List;

public class CardsDataBaseDao implements CardsDao{
    @Override
    public List<Cards> getAllCards() {
        return null;
    }

    @Override
    public int getCardValue(int cardID) {
        return 0;
    }

    @Override
    public Cards getCardByCardID(int id) {
        return null;
    }

    @Override
    public String getCardDescription(int cardID) {
        return null;
    }
}
