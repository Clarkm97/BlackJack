package com.sg.blackjack.data;

import com.sg.blackjack.model.Cards_Owned_By_Players;

import java.util.List;

public class Cards_Owned_By_PlayersDataBaseDao implements Cards_Owned_By_PlayersDao{
    @Override
    public List<Cards_Owned_By_Players> getAllPlayersCards() {
        return null;
    }

    @Override
    public List<Cards_Owned_By_Players> getCardsByPlayerID(int playerID) {
        return null;
    }

    @Override
    public Cards_Owned_By_Players addCardsOwnedByPlayer(Cards_Owned_By_Players cards) {
        return null;
    }
}
