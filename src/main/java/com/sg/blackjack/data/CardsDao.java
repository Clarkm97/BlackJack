package com.sg.blackjack.data;

import com.sg.blackjack.model.Cards;

import java.util.List;

public interface CardsDao {

    List<Cards> getAllCards(); //get a list of all cards

    int getCardValue(int cardID); //get the value of the card based on CardID

    Cards getCardByCardID(int id);//get the card by the cardID

    String getCardDescription(int cardID);// get a string of the card description by cardID

}
