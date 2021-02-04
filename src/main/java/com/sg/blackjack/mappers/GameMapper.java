package com.sg.blackjack.mappers;

import com.sg.blackjack.model.Game;
import com.sg.blackjack.model.Player;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GameMapper implements RowMapper<Game> {

    @Override
    public Game mapRow(ResultSet rs, int index) throws SQLException {
        Game g = new Game();
        g.setGameId(rs.getInt("gameId"));
        g.setFinished(rs.getBoolean("isFinished"));
        g.setPlayerId(rs.getInt("playerId"));
        g.setDealerId(rs.getInt("dealerId"));
        return g;
    }
}

