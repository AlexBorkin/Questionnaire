package questionnaire.mappers;

import questionnaire.entities.ResultQuest;
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

        resultQuest.setFirstName(resultSet.getString("firstName"));
        resultQuest.setLastName(resultSet.getString("lastName"));
        resultQuest.setQuestText(resultSet.getString("questText"));
        resultQuest.setAnswerText(resultSet.getString("answerText"));


        return resultQuest;
    }
}

/*
select USERS."userId", USERS."firstName", USERS."lastName", QUEST."questId",
	QUEST."questText", ANSW."answerId", ANSW."answerText"
from public."resultQuest" as RES
left join public."questions" as QUEST
on QUEST."questId" = RES."questId"
left join public."answers" as ANSW
on ANSW."answerId" = RES."answerId"
left join public."users" as USERS
on USERS."userId" = RES."userId"
order by USERS."userId", QUEST."questId";
 */
