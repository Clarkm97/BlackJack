package com.sg.blackjack.data;

import com.sg.blackjack.model.Game;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GameDataBaseDao implements GameDao {



    @Override
    public List<Game> getAllGames() {

        return null;
    }

    @Override
    public Game findByGameID(int id) {
        return null;
    }

    @Override
    public boolean updateGame(int id) {
        return false;
    }

    @Override
    public Game addGame(Game newGame) {
        return null;
    }
}
