package com.sg.blackjack.data;

import com.sg.blackjack.model.Cards_Owned_By_Players;

import java.util.List;

public interface Cards_Owned_By_PlayersDao {

    List<Cards_Owned_By_Players> getAllPlayersCards();//get a list of all cards owned by all players

    List<Cards_Owned_By_Players> getCardsByPlayerID(int playerID);//get a list of all cards owned by one player

    Cards_Owned_By_Players addCardsOwnedByPlayer(Cards_Owned_By_Players cards);//used to add to the table to increase

}
