package com.sg.blackjack.data;

import com.sg.blackjack.model.Cards;
import com.sg.blackjack.model.Cards_Owned_By_Players;

import java.util.List;

public interface Cards_Owned_By_PlayersDao {

    List<Cards_Owned_By_Players> getAllPlayersCards();//get a list of all cards owned by all players

    List<Cards> getCardsByPlayerID(int playerID);//get a list of all cards owned by one player

    void addCardsOwnedByPlayer(int cardId,int playerID );//used to add to the table to increase

    int totalCardValueByPlayer(int playerID);//used to get the total of card value of a player

}
