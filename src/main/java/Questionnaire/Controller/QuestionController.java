package Questionnaire.Controller;

import Questionnaire.Entities.Question;
import Questionnaire.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void create(@RequestBody Question question)
    {
        questionService.create(question);
    }

    @PutMapping(value = "/question/{id}")
    public void update(@PathVariable(name ="id") Integer id, @RequestBody Question question)
    {
        questionService.update(id, question);
    }

    @DeleteMapping (value = "/question/{id}")
    public void delete(@PathVariable(name ="id") Integer id)
    {
        questionService.delete(id);
    }

}
