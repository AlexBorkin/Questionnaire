package Questionnaire.Service;

import Questionnaire.Entities.Question;
import Questionnaire.Mappers.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class QuestionService
{
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionService(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    public List<Question> getAll()
    {
        String sqlQuery = "select * from public.questions";
        List<Question> listQuestion = jdbcTemplate.query(sqlQuery, new QuestionMapper());

        return listQuestion;
    }

    public Question getQuestion(int id)
    {
        String sqlQuery = "select * from public.questions where \"questId\" = ?;";
        List<Question> listQuestion = jdbcTemplate.query(sqlQuery, new Integer[]{id}, new QuestionMapper());

        return !listQuestion.isEmpty() && listQuestion != null ? listQuestion.get(0) : null;
    }

    public void create(Question question)
    {
        String sqlQuery = "insert into public.questions(\"questText\") values (?);";

        jdbcTemplate.update(sqlQuery, question.getQuestText());
    }

    public void update(int id, Question question)
    {
        String sqlQuery = "update public.questions set \"questText\" = ? where \"questId\" = ?;";
       jdbcTemplate.update(sqlQuery, question.getQuestText(), id);
    }

    public void delete(int id)
    {
        String sqlQuery = "delete from public.questions where \"questId\" = ?;";
        jdbcTemplate.update(sqlQuery, id);
    }

}
