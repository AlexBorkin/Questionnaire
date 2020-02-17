package Questionnaire.Entities;

import org.springframework.data.relational.core.sql.In;

public class ResultQuest
{
    private Integer userId;
    private Integer questId;
    private Integer answerId;

    public ResultQuest()
    {
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuestId() {
        return questId;
    }

    public void setQuestId(Integer questId) {
        this.questId = questId;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }
}
