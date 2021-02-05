package com.sg.blackjack.data;

import com.sg.blackjack.model.Cards;
import com.sg.blackjack.model.Cards_Owned_By_Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class Cards_Owned_By_PlayersDataBaseDao implements Cards_Owned_By_PlayersDao{

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<Cards_Owned_By_Players> getAllPlayersCards() {
        final String sql = "Select * from cards_owned_by_players";
        return jdbc.query(sql, new CardsOwnedByPlayersMapper());
    }

    @Override
    public List<Cards> getCardsByPlayerID(int playerID) {
        final String sql = "Select * from cards_owned_by_players\n" +
                "join cards\n" +
                "on Cards_Owned_By_Players.cardId = cards.cardId\n" +
                "where playerId = ?";
        return jdbc.query(sql,new CardsMapper(),playerID);

    }

    @Override
    public void addCardsOwnedByPlayer(int cardId, int playerId) {
        final String sql = "Insert into cards_owned_by_players(playerId,cardId) Values(?,?);";
        jdbc.update(sql,playerId,cardId);

    }

    @Override
    public int totalCardValueByPlayer(int playerID) {
        final String sql = "Select sum(`value`) as sumPoint\n" +
                "from Cards_Owned_By_Players\n" +
                "join cards\n" +
                "on Cards_Owned_By_Players.cardId = cards.cardId\n" +
                "where playerid =?;";
        //int total =jdbc.query(sql, playerID);

        Cards temp = jdbc.queryForObject(sql,new CardsMapper2(), playerID);
        return temp.getValue();
    }


    public static final class CardsOwnedByPlayersMapper implements RowMapper<Cards_Owned_By_Players>{

        @Override
        public Cards_Owned_By_Players mapRow(ResultSet rs, int index) throws SQLException {
            Cards_Owned_By_Players cobprunner = new Cards_Owned_By_Players();
            cobprunner.setCardId(rs.getInt("CardId"));
            cobprunner.setPlayerId(rs.getInt("PlayerId"));
            return cobprunner;
        }

    }

    public static final class CardsMapper implements RowMapper<Cards>{

        @Override
        public Cards mapRow(ResultSet rs, int i) throws SQLException {
            Cards cardRunner  = new Cards();
            cardRunner.setDescription(rs.getString("description"));
            return cardRunner;
        }
    }
    public static final class CardsMapper2 implements RowMapper<Cards>{

        @Override
        public Cards mapRow(ResultSet rs, int i) throws SQLException {
            Cards cardRunner  = new Cards();
            cardRunner.setValue(rs.getInt("sumPoint"));
            return cardRunner;
        }
    }


}
