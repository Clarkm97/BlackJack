package com.sg.blackjack.data;

import com.sg.blackjack.model.Cards_Owned_By_Players;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class Cards_Owned_By_PlayersDataBaseDao implements Cards_Owned_By_PlayersDao{
    @Override
    public List<Cards_Owned_By_Players> getAllPlayersCards() {
        return null;
    }

    @Override
    public List<Cards_Owned_By_Players> getCardsByPlayerID(int playerID) {
        return null;
    }

    @Override
    public Cards_Owned_By_Players addCardsOwnedByPlayer(Cards_Owned_By_Players cards) {
        return null;
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
}
