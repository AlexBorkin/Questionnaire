package questionnaire.controller;

import questionnaire.entities.ResultQuest;
import questionnaire.service.ResultQuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultQuestController
{
    private ResultQuestService resultQuestService;

    @Autowired
    public ResultQuestController(ResultQuestService resultQuestService)
    {
        this.resultQuestService = resultQuestService;
    }

    @GetMapping(value = "/resultQuest")
    public List<ResultQuest> getAll()
    {
        return resultQuestService.getAll();
    }

    @GetMapping(value = "/resultQuest/user/{userId}/quest/{questId}")
    public ResultQuest read(@PathVariable(value = "userId")  Integer userId,
                            @PathVariable(value = "questId") Integer questId)
    {
        ResultQuest resultQuest = new ResultQuest();

        resultQuest = resultQuestService.read(userId, questId);

        return  resultQuest;
    }

    @PostMapping(value = "/resultQuest")
    public void create(@RequestBody ResultQuest resultQuest)
    {
        resultQuestService.create(resultQuest);
    }

    @PutMapping(value = "/resultQuest/user/{userId}/quest/{questId}")
    public void update(@PathVariable(value = "userId") Integer userId,
                       @PathVariable(value = "questId") Integer questId,
                       @RequestBody ResultQuest resultQuest)
    {
        resultQuestService.update(userId, questId, resultQuest);
    }

    @DeleteMapping(value = "/resultQuest/user/{userId}/quest/{questId}")
    public void delete(@PathVariable(value = "userId") Integer userId,
                       @PathVariable(value = "questId") Integer questId)
    {
        resultQuestService.delete(userId, questId);
    }
}
