package com.sg.blackjack.data;

import com.sg.blackjack.model.Player;

import java.util.List;

public interface PlayerDao {

    List<Player> getAllPlayers();//list of all players

    Player findPlayerByID(int id);//finding a player based on playerID

    int addPlayer(Player newPlayer);//add a new player to the table
}
