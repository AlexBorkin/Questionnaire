package Questionnaire.Service;

import Questionnaire.Entities.ResultQuest;
import Questionnaire.Mappers.ResultQuestMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class ResultQuestService
{
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public ResultQuestService(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    public List<ResultQuest> getAll()
    {
        String sqlQuery = "select * from public.\"resultQuest\";";

        return jdbcTemplate.query(sqlQuery, new ResultQuestMapper());
    }

    public void create(ResultQuest resultQuest)
    {
        String sqlQuery = "insert into public.\"resultQuest\" (\"userId\", \"questId\", \"answerId\") values(?,?,?);";

        jdbcTemplate.update(sqlQuery, resultQuest.getUserId(), resultQuest.getQuestId(), resultQuest.getAnswerId());
    }

    public ResultQuest read(Integer userId, Integer questId)
    {
        String sqlQuery = "select * from public.\"resultQuest\" where \"userId\" = ? and \"questId\" = ?;";
        List<ResultQuest> listResult = jdbcTemplate.query(sqlQuery, new Integer[]{userId, questId}, new ResultQuestMapper());

        return !listResult.isEmpty() && listResult != null ? listResult.get(0) : null;
    }

    public void update(Integer userId, Integer questId, ResultQuest resultQuest)
    {
        String sqlQuery = "update public.\"resultQuest\" set \"answerId\" = ? where \"userId\" = ? and \"questId\" = ?;";
        jdbcTemplate.update(sqlQuery, resultQuest.getAnswerId(), userId, questId);
    }

    public void delete(Integer userId, Integer questId)
    {
        String sqlQuery = "delete from public.\"resultQuest\" where \"userId\" = ? and \"questId\" = ?;";
        jdbcTemplate.update(sqlQuery, userId, questId);
    }


}
