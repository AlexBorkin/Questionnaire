package Questionnaire.Mappers;

import Questionnaire.Entities.Answer;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnswerMapper implements RowMapper<Answer>
{
    @Override
    public Answer mapRow(ResultSet resultSet, int i) throws SQLException
    {
        Answer answer = new Answer();
        answer.setAnswerId(resultSet.getInt("answerId"));
        answer.setAnswerText(resultSet.getString("answerText"));

        return answer;
    }
}
