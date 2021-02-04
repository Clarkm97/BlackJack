package com.sg.blackjack.data;

import com.sg.blackjack.model.Game;

import java.util.List;

public interface GameDao {

    List<Game> getAllGames();//Get List of all games

    Game findByGameID(int id);// Get the game by id

    boolean updateGame(int id);//probably just be used to update the isFinished state

    Game addGame(Game newGame, String playerName); //used to add game to the tables

}
