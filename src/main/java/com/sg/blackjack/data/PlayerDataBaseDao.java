package com.sg.blackjack.data;

import com.sg.blackjack.model.Game;
import com.sg.blackjack.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.List;
@Repository
public class PlayerDataBaseDao implements PlayerDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<Player> getAllPlayers() {
        final String sql = "Select * from player;";
        return jdbc.query(sql,new PlayerMapper());
    }

    @Override
    public Player findPlayerByID(int id) {
        try {
            final String sql = "Select * From player Where playerID = ?;";
            return jdbc.queryForObject(sql, new PlayerMapper(), id);
        }catch (DataAccessException ex){
            return null;
        }
    }

    @Override
    @Transactional
    public int addPlayer(Player newPlayer) {
        final String sql = "Insert into player(playerName) Values(?)";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbc.update((Connection conn) -> {
            PreparedStatement stmt = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, newPlayer.getPlayerName());

            return stmt;
        }, keyHolder);

        newPlayer.setPlayerId(keyHolder.getKey().intValue());

        return newPlayer.getPlayerId();

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
