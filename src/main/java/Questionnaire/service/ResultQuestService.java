package questionnaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import questionnaire.entities.QuestAnswerRef;
import questionnaire.entities.ResultQuest;
import questionnaire.mappers.QuestAnswerRefMapper;
import questionnaire.mappers.ResultQuestMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class ResultQuestService
{
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ResultQuestService(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    public List<ResultQuest> getAll()
    {
        String sqlQuery = "select USERS.\"userId\", USERS.\"firstName\", USERS.\"lastName\", QUEST.\"questId\", \n" +
                "QUEST.\"questText\", ANSW.\"answerId\", ANSW.\"answerText\" \n" +
                "from public.\"resultQuest\" as RES\n" +
                "left join public.\"questions\" as QUEST\n" +
                "on QUEST.\"questId\" = RES.\"questId\"\n" +
                "left join public.\"answers\" as ANSW\n" +
                "on ANSW.\"answerId\" = RES.\"answerId\"\n" +
                "left join public.\"users\" as USERS\n" +
                "on USERS.\"userId\" = RES.\"userId\"\n" +
                "order by USERS.\"userId\", QUEST.\"questId\";";

        return jdbcTemplate.query(sqlQuery, new ResultQuestMapper());
    }

    public void create(ResultQuest resultQuest)
    {
        String sqlQuery = "insert into public.\"resultQuest\"(\"userId\", \"questId\", \"answerId\") values(?,?,?);";

        jdbcTemplate.update(sqlQuery, resultQuest.getUserId(), resultQuest.getQuestId(), resultQuest.getAnswerId());
    }

    public ResultQuest read(Integer userId, Integer questId)
    {
        String sqlQuery = "select USERS.\"userId\", USERS.\"firstName\", USERS.\"lastName\", QUEST.\"questId\", \n" +
                "QUEST.\"questText\", ANSW.\"answerId\", ANSW.\"answerText\" \n" +
                "from public.\"resultQuest\" as RES\n" +
                "left join public.\"questions\" as QUEST\n" +
                "on QUEST.\"questId\" = RES.\"questId\"\n" +
                "left join public.\"answers\" as ANSW\n" +
                "on ANSW.\"answerId\" = RES.\"answerId\"\n" +
                "left join public.\"users\" as USERS\n" +
                "on USERS.\"userId\" = RES.\"userId\"\n" +
                "where RES.\"userId\" = ? and RES.\"questId\" = ?;";


        List<ResultQuest> listResult = jdbcTemplate.query(sqlQuery, new Integer[]{userId, questId}, new ResultQuestMapper());

        return !listResult.isEmpty() && listResult != null ? listResult.get(0) : null;
    }

    public List<ResultQuest> readByUser(Integer userId)
    {
        String sqlQuery = "select USERS.\"userId\", USERS.\"firstName\", USERS.\"lastName\", QUEST.\"questId\", \n" +
                "QUEST.\"questText\", ANSW.\"answerId\", ANSW.\"answerText\" \n" +
                "from public.\"resultQuest\" as RES\n" +
                "left join public.\"questions\" as QUEST\n" +
                "on QUEST.\"questId\" = RES.\"questId\"\n" +
                "left join public.\"answers\" as ANSW\n" +
                "on ANSW.\"answerId\" = RES.\"answerId\"\n" +
                "left join public.\"users\" as USERS\n" +
                "on USERS.\"userId\" = RES.\"userId\"\n" +
                "where RES.\"userId\" = ?" +
                "order by USERS.\"userId\", QUEST.\"questId\";";

        List<ResultQuest> listResult = jdbcTemplate.query(sqlQuery, new Integer[]{userId}, new ResultQuestMapper());

        return listResult;
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

    public QuestAnswerRef checkExistAnswer(Integer questId, Integer answerId)
    {
        List<QuestAnswerRef> listAnswer;

        String sqlQuery = "select QUEST.\"questId\", QUEST.\"questText\", ANSW.\"answerId\", ANSW.\"answerText\"" +
                "from public.\"questAnswerRef\" as QAR " +
                "left join public.\"questions\" as QUEST " +
                "on QUEST.\"questId\" = QAR.\"questId\"" +
                "left join public.\"answers\" as ANSW " +
                "on ANSW.\"answerId\" = QAR.\"answerId\" " +
                "where QAR.\"questId\" = ? and QAR.\"answerId\" = ?" +
                "order by QUEST.\"questId\";";

        listAnswer = jdbcTemplate.query(sqlQuery, new Integer[]{questId, answerId}, new QuestAnswerRefMapper());

        return listAnswer != null && listAnswer.size() > 0 ? listAnswer.get(0) : null;
    }

}
