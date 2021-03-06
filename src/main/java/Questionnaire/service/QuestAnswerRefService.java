package questionnaire.service;

import questionnaire.entities.QuestAnswerRef;
import questionnaire.mappers.QuestAnswerRefMapper;
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
            String sqlQuery = "select QUEST.\"questId\", QUEST.\"questText\", ANSW.\"answerId\", ANSW.\"answerText\" \n" +
                    "from public.\"questAnswerRef\" as QAF\n" +
                    "left join public.\"questions\" as QUEST\n" +
                    "on QUEST.\"questId\" = QAF.\"questId\"\n" +
                    "left join public.\"answers\" as ANSW\n" +
                    "on ANSW.\"answerId\" = QAF.\"answerId\"\n" +
                    "order by QUEST.\"questId\";";

            List<QuestAnswerRef> list = jdbcTemplate.query(sqlQuery, new QuestAnswerRefMapper());

            return list;
        }

        public List<QuestAnswerRef> read(Integer questId)
        {
            String sqlQuery;
            List<QuestAnswerRef> listAnswer;

             sqlQuery = "select QUEST.\"questId\", QUEST.\"questText\", ANSW.\"answerId\", ANSW.\"answerText\" \n" +
                     "from public.\"questAnswerRef\" as QAF\n" +
                     "left join public.\"questions\" as QUEST\n" +
                     "on QUEST.\"questId\" = QAF.\"questId\"\n" +
                     "left join public.\"answers\" as ANSW\n" +
                     "on ANSW.\"answerId\" = QAF.\"answerId\"\n" +
                     "where QAF.\"questId\" = ?\n" +
                     "order by QUEST.\"questId\";";

            listAnswer = jdbcTemplate.query(sqlQuery, new Integer[]{questId}, new QuestAnswerRefMapper());

            return listAnswer;
        }

        public void create(QuestAnswerRef questAnswerRef)
        {
            String sqlQuery = "insert into public.\"questAnswerRef\" (\"questId\", \"answerId\") values(?,?);";

            jdbcTemplate.update(sqlQuery, questAnswerRef.getQuestId(), questAnswerRef.getAnswerId());
        }


        public void update(Integer questId, Integer answerId, QuestAnswerRef questAnswerRef)
        {
            String sqlQuery = "update public.\"questAnswerRef\" set \"questId\" = ?, \"answerId\" = ? where \"questId\" = ? and \"answerId\" = ?;";

            jdbcTemplate.update(sqlQuery, questAnswerRef.getQuestId(), questAnswerRef.getAnswerId(), questId, answerId);
        }

        public void delete(Integer questId, Integer answerId)
        {
            String sqlQuery = "delete from public.\"questAnswerRef\" where \"questId\" = ? and \"answerId\" = ?;";

            jdbcTemplate.update(sqlQuery, questId, answerId);
        }


}
