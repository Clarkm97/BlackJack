package com.sg.blackjack.data;

import com.sg.blackjack.model.Game;
import com.sg.blackjack.model.Player;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class PlayerDataBaseDao implements PlayerDao {
    @Override
    public List<Player> getAllPlayers() {
        return null;
    }

    @Override
    public List<Player> findPlayerByID(int id) {
        return null;
    }

    @Override
    public Player addPlayer(Player newPlayer) {
        return null;
    }


    public static final class PlayerMapper implements RowMapper<Player> {


        @Override
        public Player mapRow(ResultSet rs, int i) throws SQLException {

            Player playerRunner = new Player();
            playerRunner.setPlayerId(rs.getInt("PlayerId"));
            playerRunner.setPlayerName(rs.getString("playerName"));
            return playerRunner;
        }
    }

}
