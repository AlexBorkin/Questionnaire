package questionnaire.service;

import questionnaire.entities.RightAnswerRef;
import questionnaire.mappers.RightAnswerRefMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class RightAnswerRefService
{
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RightAnswerRefService(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<RightAnswerRef> getAll()
    {
        String sqlQuery = "select * from public.\"rightAnswerRef\";";
        List<RightAnswerRef> list = jdbcTemplate.query(sqlQuery, new RightAnswerRefMapper());

        return list;
    }

    public RightAnswerRef readByQuest(Integer questId)
    {
        String sqlQuery;
        List<RightAnswerRef> listRightAnswerRef;

        sqlQuery = "select * from public.\"rightAnswerRef\" where \"questId\" = ?;";

        listRightAnswerRef = jdbcTemplate.query(sqlQuery, new Integer[]{questId}, new RightAnswerRefMapper());

        return listRightAnswerRef != null && listRightAnswerRef.size() > 0 ? listRightAnswerRef.get(0) : null;
    }

    public void create(RightAnswerRef rightAnswerRef)
    {
        String sqlQuery = "insert into public.\"rightAnswerRef\" (\"questId\", \"answerId\") values(?,?);";

        jdbcTemplate.update(sqlQuery, rightAnswerRef.getQuestId(), rightAnswerRef.getAnswerId());
    }

    public void update(Integer questId, RightAnswerRef rightAnswerRef)
    {
        String sqlQuery = "update public.\"rightAnswerRef\" set \"answerText\" = ? where \"questId\" = ?;";

        jdbcTemplate.update(sqlQuery, rightAnswerRef.getAnswerId(), questId);
    }

    public void delete(Integer questId)
    {
        String sqlQuery = "delete from public.\"rightAnswerRef\" where \"questId\" = ?;";

        jdbcTemplate.update(sqlQuery, questId);
    }


}
