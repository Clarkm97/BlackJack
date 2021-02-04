package com.sg.blackjack.mappers;

import com.sg.blackjack.model.Game;
import com.sg.blackjack.model.Player;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerMapper implements RowMapper<Player> {

    @Override
    public Player mapRow(ResultSet rs, int index) throws SQLException {
        Player p = new Player();
        p.setPlayerId(rs.getInt("playerId"));
        p.setPlayerName(rs.getString("playerName"));
        return p;
    }
}
