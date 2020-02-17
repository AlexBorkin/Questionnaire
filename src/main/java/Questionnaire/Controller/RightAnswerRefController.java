package Questionnaire.Controller;

import Questionnaire.Entities.QuestAnswerRef;
import Questionnaire.Entities.RightAnswerRef;
import Questionnaire.Service.QuestAnswerRefService;
import Questionnaire.Service.RightAnswerRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RightAnswerRefController
{
    private RightAnswerRefService rightAnswerRefService;

    @Autowired
    public RightAnswerRefController(RightAnswerRefService rightAnswerRefService)
    {
        this.rightAnswerRefService = rightAnswerRefService;
    }

    @GetMapping(value = "/rightAnswerRef")
    public List<RightAnswerRef> getAll()
    {
        return rightAnswerRefService.getAll();
    }

    @GetMapping(value = "/rightAnswerRef/{questId}")
    public RightAnswerRef read(@PathVariable(value = "questId") Integer questId)
    {
        return  rightAnswerRefService.readByQuest(questId);
    }

    @PostMapping(value = "/rightAnswerRef")
    public void create(@RequestBody RightAnswerRef rightAnswerRef)
    {
        rightAnswerRefService.create(rightAnswerRef);
    }

    @DeleteMapping(value = "/rightAnswerRef/{questId}")
    public void delete(@PathVariable(value = "questId") Integer questId)
    {
        rightAnswerRefService.delete(questId);
    }
}
