package questionnaire.service;

import questionnaire.entities.Answer;
import questionnaire.mappers.AnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class AnswerService
{
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AnswerService(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<Answer> getAll()
    {
        String sqlQuery = "select * from public.answers;";
        List<Answer> listAnswer = jdbcTemplate.query(sqlQuery, new AnswerMapper());

        return listAnswer;
    }

    public Answer read(Integer answerId)
    {
        String sqlQuery;
        List<Answer> listAnswer;

        sqlQuery = "select * from public.answers where \"answerId\" = ?;";

        listAnswer = jdbcTemplate.query(sqlQuery, new Integer[]{answerId}, new AnswerMapper());

        return (listAnswer != null && listAnswer.size() > 0) ? listAnswer.get(0) : null;
    }

    public void create(Answer answer)
    {
        String sqlQuery = "insert into public.answers (\"answerText\") values(?);";

        jdbcTemplate.update(sqlQuery, answer.getAnswerText());
    }

    public void update(Integer answerId, Answer answer)
    {
        String sqlQuery = "update public.answers set \"answerText\" = ? where \"answerId\" = ?;";

        jdbcTemplate.update(sqlQuery, answer.getAnswerText(), answerId);
    }

    public void delete(Integer answerId)
    {
        String sqlQuery = "delete from public.answers where \"answerId\" = ?;";

        jdbcTemplate.update(sqlQuery, answerId);
    }
}
