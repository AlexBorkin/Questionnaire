package questionnaire.controller;

import questionnaire.entities.QuestAnswerRef;
import questionnaire.service.QuestAnswerRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestAnswerRefController
{
    private QuestAnswerRefService questAnswerRefService;

    @Autowired
    public QuestAnswerRefController(QuestAnswerRefService questAnswerRefService)
    {
        this.questAnswerRefService = questAnswerRefService;
    }

    @GetMapping(value = "/questAnswerRef")
    public List<QuestAnswerRef> getAll()
    {
        return questAnswerRefService.getAll();
    }

    @GetMapping(value = "/questAnswerRef/quest/{questId}")
    public List<QuestAnswerRef> read(@PathVariable(value = "questId") Integer questId)
    {
        return  questAnswerRefService.readByQuest(questId);
    }

    @PostMapping(value = "/questAnswerRef")
    public void create(@RequestBody QuestAnswerRef QuestAnswerRef)
    {
        questAnswerRefService.create(QuestAnswerRef);
    }

    @DeleteMapping(value = "/questAnswerRef/user/{userId}/quest/{questId}")
    public void delete(@PathVariable(value = "questId") Integer questId,
                       @PathVariable(value = "answerId") Integer answerId)
    {
        questAnswerRefService.delete(questId, answerId);
    }
}
