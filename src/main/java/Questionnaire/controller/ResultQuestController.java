package questionnaire.controller;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import questionnaire.entities.QuestAnswerRef;
import questionnaire.entities.ResultQuest;
import questionnaire.service.ResultQuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ResultQuestController
{
    private final ResultQuestService resultQuestService;

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
        return  resultQuestService.read(userId, questId);
    }

    @GetMapping(value = "/resultQuest/{userId}")
    public List<ResultQuest> readByUser(@PathVariable(value = "userId")  Integer userId)
    {
        return  resultQuestService.readByUser(userId);
    }

    @PostMapping(value = "/resultQuest")
    public ResponseEntity<ObjectNode> create(@RequestBody ResultQuest resultQuest)
    {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.instance);
        ResponseEntity responseEntity;
        QuestAnswerRef questAnswerRef = resultQuestService.checkExistAnswer(resultQuest.getQuestId(), resultQuest.getAnswerId());

        if (questAnswerRef == null)
        {
            objectNode.put("Ошибка!", String.format("Вопрос %s не содержит варианта ответа %s",
                    resultQuest.getQuestId(),
                    resultQuest.getAnswerId()));
            responseEntity = new ResponseEntity(objectNode, HttpStatus.BAD_REQUEST);
        }
        else
        {
            try
            {
                resultQuestService.create(resultQuest);
                responseEntity = new ResponseEntity(HttpStatus.OK);
            }
            catch (Exception e)
            {
                objectNode.put("Ошибка!", e.getMessage());
                responseEntity = new ResponseEntity(objectNode, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return responseEntity;
    }

    @PutMapping(value = "/resultQuest/user/{userId}/quest/{questId}")
    public void update(@PathVariable(value = "userId") Integer userId,
                       @PathVariable(value = "questId") Integer questId,
                       @RequestBody ResultQuest resultQuest) throws SQLException {
        try
        {
            resultQuestService.update(userId, questId, resultQuest);
        }
        catch (Exception e)
        {
            throw new SQLException("Ошибка обновления записи в таблице результатов тестирования: " + e.getMessage());
        }
    }

    @DeleteMapping(value = "/resultQuest/user/{userId}/quest/{questId}")
    public void delete(@PathVariable(value = "userId") Integer userId,
                       @PathVariable(value = "questId") Integer questId) throws SQLException {
        try
        {
            resultQuestService.delete(userId, questId);
        }
        catch (Exception e)
        {
            throw new SQLException("Ошибка удаления записи в таблице результатов тестирования: " + e.getMessage());
        }
    }
}
