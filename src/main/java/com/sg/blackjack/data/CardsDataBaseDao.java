package com.sg.blackjack.data;

import com.sg.blackjack.model.Cards;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class CardsDataBaseDao implements CardsDao{
    @Override
    public List<Cards> getAllCards() {
        return null;
    }

    @Override
    public int getCardValue(int cardID) {
        return 0;
    }

    @Override
    public Cards getCardByCardID(int id) {
        return null;
    }

    @Override
    public String getCardDescription(int cardID) {
        return null;
    }


    public static final class CardsMapper implements RowMapper<Cards> {

        @Override
        public Cards mapRow(ResultSet rs, int index) throws SQLException {
            Cards cardRunner = new Cards();
            cardRunner.setCardId(rs.getInt("CardId"));
            cardRunner.setDescription(rs.getString("description"));
            cardRunner.setValue(rs.getInt("value"));
            return cardRunner;
        }
    }
}
