package questionnaire.mappers;

import questionnaire.entities.RightAnswerRef;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RightAnswerRefMapper implements RowMapper<RightAnswerRef>
{
    @Override
    public RightAnswerRef mapRow(ResultSet resultSet, int i) throws SQLException
    {
        RightAnswerRef rightAnswerRef = new RightAnswerRef();
        rightAnswerRef.setAnswerId(resultSet.getInt("answerId"));
        rightAnswerRef.setQuestId(resultSet.getInt("questId"));

        return rightAnswerRef;
    }
}

