package questionnaire.controller;

import questionnaire.entities.QuestAnswerRef;
import questionnaire.service.QuestAnswerRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;
import java.util.List;

@RestController
public class QuestAnswerRefController
{
    private final QuestAnswerRefService questAnswerRefService;

    @Autowired
    public QuestAnswerRefController(QuestAnswerRefService questAnswerRefService)
    {
        this.questAnswerRefService = questAnswerRefService;
    }

    @GetMapping(value="/questAnswerRef")
    public List<QuestAnswerRef> getAll()
    {
        return questAnswerRefService.getAll();
    }

    @GetMapping(value="/questAnswerRef/quest/{questId}")
    public List<QuestAnswerRef> readAllByQuest(@PathVariable(value = "questId") Integer questId)
    {
        return  questAnswerRefService.read(questId);
    }

    @PostMapping(value = "/questAnswerRef")
    public void create(@RequestBody QuestAnswerRef QuestAnswerRef) throws SQLException
    {
        try
        {
            questAnswerRefService.create(QuestAnswerRef);
        }
        catch (Exception e)
        {
            throw new SQLException("Ошибка создания записи в таблице 'вопрос - ответы': " + e.getMessage());
        }
    }

    @PutMapping(value = "/questAnswerRef/quest/{questId}/answer/{answerId}")
    public void update(@PathVariable(value = "questId") Integer questId,
                       @PathVariable(value = "answerId") Integer answerId,
                       @RequestBody QuestAnswerRef questAnswerRef) throws SQLException
    {
        try
        {
            questAnswerRefService.update(questId, answerId, questAnswerRef);
        }
        catch (Exception e)
        {
            throw new SQLException("Ошибка обновления записи в таблице 'вопрос - ответы': " + e.getMessage());
        }
    }


    @DeleteMapping(value = "/questAnswerRef/quest/{questId}/answer/{answerId}")
    public void delete(@PathVariable(value = "questId") Integer questId,
                       @PathVariable(value = "answerId") Integer answerId) throws SQLException
    {
        try
        {
            questAnswerRefService.delete(questId, answerId);
        }
        catch (Exception e)
        {
            throw new SQLException("Ошибка удаления записи в таблице 'вопрос - ответы': " + e.getMessage());
        }
    }
}
