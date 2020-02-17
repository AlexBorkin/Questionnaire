package Questionnaire.Entities;

public class Question
{
    private Integer questId;
    private String questText;

    public Question()
    {

    }

    public Question(Integer questId, String questText)
    {
        this.questId = questId;
        this.questText = questText;
    }

    public Integer getQuestId() {
        return questId;
    }

    public void setQuestId(Integer questId) {
        this.questId = questId;
    }

    public String getQuestText()
    {
        return questText;
    }

    public void setQuestText(String questText) {
        this.questText = questText;
    }
}
