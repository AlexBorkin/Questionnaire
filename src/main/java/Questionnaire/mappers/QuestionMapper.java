package questionnaire.mappers;

import questionnaire.entities.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements RowMapper<Question>
{
    @Override
    public Question mapRow(ResultSet resultSet, int i) throws SQLException
    {
        Question question = new Question();
        question.setQuestId(resultSet.getInt("questId"));
        question.setQuestText(resultSet.getString("questText"));
        return question;
    }
}
