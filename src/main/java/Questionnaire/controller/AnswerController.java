package questionnaire.controller;


import questionnaire.entities.Answer;
import questionnaire.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void create(@RequestBody Answer answer)
    {
        answerService.create(answer);
    }

    @PutMapping (value = "/answer/{answerId}")
    public void update(@PathVariable(name = "answerId") Integer answerId, @RequestBody Answer answer)
    {
        answerService.update(answerId, answer);
    }

    @DeleteMapping (value = "/answer/{answerId}")
    public void delete(@PathVariable(name = "answerId") Integer answerId)
    {
        answerService.delete(answerId);
    }

}
