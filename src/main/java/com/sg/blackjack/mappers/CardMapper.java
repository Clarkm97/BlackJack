package com.sg.blackjack.mappers;

import com.sg.blackjack.model.Cards;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardMapper implements RowMapper<Cards> {
    @Override
    public Cards mapRow(ResultSet rs, int index) throws SQLException {
        Cards c = new Cards();
        c.setCardId(rs.getInt("cardId"));
        c.setValue(rs.getInt("value"));
        c.setDescription(rs.getString("description"));
        return c;
    }
}
