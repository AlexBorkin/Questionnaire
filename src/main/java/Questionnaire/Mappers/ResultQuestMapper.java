package Questionnaire.Mappers;

import Questionnaire.Entities.ResultQuest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultQuestMapper implements RowMapper<ResultQuest>
{
    @Override
    public ResultQuest mapRow(ResultSet resultSet, int i) throws SQLException
    {
        ResultQuest resultQuest = new ResultQuest();
        resultQuest.setUserId(resultSet.getInt("userId"));
        resultQuest.setQuestId(resultSet.getInt("questId"));
        resultQuest.setAnswerId(resultSet.getInt("answerId"));

        return resultQuest;
    }
}
