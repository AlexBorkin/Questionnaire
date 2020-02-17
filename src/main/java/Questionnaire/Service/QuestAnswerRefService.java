package Questionnaire.Service;

import Questionnaire.Entities.QuestAnswerRef;
import Questionnaire.Mappers.QuestAnswerRefMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class QuestAnswerRefService
{
        private final DataSource dataSource;
        private final JdbcTemplate jdbcTemplate;

        @Autowired
        public QuestAnswerRefService(DataSource dataSource)
        {
            this.dataSource = dataSource;
            this.jdbcTemplate = new JdbcTemplate(dataSource);
        }

        public List<QuestAnswerRef> getAll()
        {
            String sqlQuery = "select * from public.\"QuestAnswerRef\";";
            List<QuestAnswerRef> list = jdbcTemplate.query(sqlQuery, new QuestAnswerRefMapper());

            return list;
        }

        public List<QuestAnswerRef> readByQuest(Integer questId)
        {
            String sqlQuery;
            List<QuestAnswerRef> listAnswer;

            sqlQuery = "select * from public.\"questAnswerRef\" where \"questId\" = ?;";

            listAnswer = jdbcTemplate.query(sqlQuery, new Integer[]{questId}, new QuestAnswerRefMapper());

            return listAnswer;
        }

        public void create(QuestAnswerRef questAnswerRef)
        {
            String sqlQuery = "insert into public.\"questAnswerRef\" (\"questId\", \"answerId\") values(?,?);";

            jdbcTemplate.update(sqlQuery, questAnswerRef.getQuestId(), questAnswerRef.getAnswerId());
        }

        /*
        public void update(Integer answerId, Answer answer)
        {
            String sqlQuery = "update public.answers set \"answerText\" = ? where \"answerId\" = ?;";

            jdbcTemplate.update(sqlQuery, answer.getAnswerText(), answerId);
        }

         */

        public void delete(Integer questId, Integer answerId)
        {
            String sqlQuery = "delete from public.\"questAnswerRef\" where \"questId\" = ? and \"answerId\" = ?;";

            jdbcTemplate.update(sqlQuery, questId, answerId);
        }


}
