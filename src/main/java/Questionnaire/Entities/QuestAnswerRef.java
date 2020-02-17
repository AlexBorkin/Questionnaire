package Questionnaire.Entities;

public class QuestAnswerRef
{
    private Integer questId;
    private Integer answerId;

    public QuestAnswerRef() {
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
