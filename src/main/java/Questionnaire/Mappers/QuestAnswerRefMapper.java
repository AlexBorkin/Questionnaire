package Questionnaire.Mappers;

import Questionnaire.Entities.QuestAnswerRef;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestAnswerRefMapper implements RowMapper<QuestAnswerRef>
{
    @Override
    public QuestAnswerRef mapRow(ResultSet resultSet, int i) throws SQLException
    {
        QuestAnswerRef questAnswerRef = new QuestAnswerRef();
        questAnswerRef.setAnswerId(resultSet.getInt("answerId"));
        questAnswerRef.setQuestId(resultSet.getInt("questId"));

        return questAnswerRef;
    }
}

