package questionnaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import questionnaire.entities.Answer;
import questionnaire.service.AnswerService;

import java.sql.SQLException;
import java.util.List;

@RestController
public class AnswerController
{
    private AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService)
    {
        this.answerService = answerService;
    }

    @GetMapping(value = "/answer")
    public List<Answer> getAll()
    {
        return answerService.getAll();
    }

    @GetMapping(value = "/answer/{answerId}")
    public Answer read(@PathVariable(name = "answerId") Integer answerId)
    {
        Answer answer = answerService.read(answerId);

        return answer;
    }

    @PostMapping (value = "/answer")
    public void create(@RequestBody Answer answer) throws SQLException
    {
        try
        {
            answerService.create(answer);
        }
        catch (Exception e)
        {
            throw new SQLException("Ошибка создания записи в таблице ответов: " + e.getMessage());
        }
    }

    @PutMapping (value = "/answer/{answerId}")
    public void update(@PathVariable(name = "answerId") Integer answerId, @RequestBody Answer answer) throws SQLException
    {
        try
        {
            answerService.update(answerId, answer);
        }
        catch (Exception e)
        {
            throw new SQLException("Ошибка обновления записи в таблице ответов: " + e.getMessage());
        }
    }

    @DeleteMapping (value = "/answer/{answerId}")
    public void delete(@PathVariable(name = "answerId") Integer answerId) throws SQLException
    {
        try
        {
            answerService.delete(answerId);
        }
        catch (Exception e)
        {
            throw new SQLException("Ошибка удаления записи в таблице ответов: " + e.getMessage());
        }
    }
}
