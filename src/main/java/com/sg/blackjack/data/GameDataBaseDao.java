package com.sg.blackjack.data;

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
    private final PlayerDao playerDao;

    @Autowired
    public GameDataBaseDao(JdbcTemplate jdbcTemplate, PlayerDao playerDao) {
        this.jdbc = jdbcTemplate;
        this.playerDao = playerDao;
    }

    @Override
    public List<Game> getAllGames() {
        final String sql = "SELECT * FROM game;";
        return jdbc.query(sql, new GameMapper());
    }

    @Override
    public Game findByGameID(int id) {
        final String sql = "SELECT * FROM game WHERE gameId = ?;";
        return jdbc.queryForObject(sql, new GameMapper(), id);
    }

    @Override
    public boolean updateGame(int id) {
        final String sql = "UPDATE game SET isFinished = true " +
                           "WHERE gameId = ?;";
        jdbc.update(sql, id);
        return true;
    }

    @Override
    public Game addGame(Game newGame, String playerName) {
        Player dealer = new Player();
        dealer.setPlayerName("Dealer");

        Player player = new Player();
        player.setPlayerName(playerName);

        int dealerId = playerDao.addPlayer(dealer);
        int playerId = playerDao.addPlayer(player);

        final String sql = "INSERT INTO game (dealerId, playerId, isFinished) VALUES (?, ?, ?);";

        jdbc.update(sql, dealerId, playerId, false);

        newGame.setFinished(false);
        newGame.setPlayerId(playerId);
        newGame.setDealerId(dealerId);

        return newGame;
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
