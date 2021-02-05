package com.sg.blackjack.data;

import com.sg.blackjack.model.Cards_Owned_By_Players;
import com.sg.blackjack.model.Game;
import com.sg.blackjack.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDataBaseDao implements GameDao {

    private final JdbcTemplate jdbc;

    @Autowired
    public GameDataBaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

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
    public Game addGame(Game newGame, String playerName) {
        Player dealer = new Player();
        dealer.setPlayerName("Dealer");

        Player player = new Player();
        player.setPlayerName(playerName);



        newGame.setFinished(false);

        return null;
    }

    public static final class GameMapper implements RowMapper<Game> {


        @Override
        public Game mapRow(ResultSet rs, int i) throws SQLException {
            Game gameMapper = new Game();
            gameMapper.setGameId(rs.getInt("GameId"));
            gameMapper.setDealerId(rs.getInt("dealerId"));
            gameMapper.setDealerId(rs.getInt("playerId"));
            gameMapper.setFinished(rs.getBoolean("isFinished"));
            return gameMapper;
        }
    }

}
