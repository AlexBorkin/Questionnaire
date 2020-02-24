package questionnaire.controller;

import questionnaire.entities.Question;
import questionnaire.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class QuestionController
{
    public final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService)
    {
        this.questionService = questionService;
    }

    @GetMapping(value = "/question")
    public List<Question> getAll()
    {
        return questionService.getAll();
    }

    @GetMapping(value = "/question/{id}")
    public Question read(@PathVariable(name = "id") int id)
    {
        return questionService.getQuestion(id);
    }

    @PostMapping(value = "/question")
    public void create(@RequestBody Question question) throws SQLException
    {
        try
        {
            questionService.create(question);
        }
        catch (Exception e)
        {
            throw new SQLException("Ошибка создания записи в таблице вопросов: " + e.getMessage());
        }
    }

    @PutMapping(value = "/question/{id}")
    public void update(@PathVariable(name ="id") Integer id, @RequestBody Question question) throws SQLException
    {
        try
        {
            questionService.update(id, question);
        }
        catch (Exception e)
        {
            throw new SQLException("Ошибка обновления записи в таблице вопросов: " + e.getMessage());
        }
    }

    @DeleteMapping (value = "/question/{id}")
    public void delete(@PathVariable(name ="id") Integer id) throws SQLException
    {
        try
        {
            questionService.delete(id);
        }
        catch (Exception e)
        {
            throw new SQLException("Ошибка удаления записи в таблице вопросов: " + e.getMessage());
        }
    }
}
