package questionnaire.entities;

public class RightAnswerRef
{
    private Integer questId;
    private Integer answerId;

    public RightAnswerRef() {
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
