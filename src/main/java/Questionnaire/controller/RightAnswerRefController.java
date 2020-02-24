package questionnaire.controller;

import questionnaire.entities.RightAnswerRef;
import questionnaire.service.RightAnswerRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
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
        return  rightAnswerRefService.read(questId);
    }

    @PostMapping(value = "/rightAnswerRef")
    public void create(@RequestBody RightAnswerRef rightAnswerRef) throws SQLException {
        try
        {
            rightAnswerRefService.create(rightAnswerRef);
        }
        catch (Exception e)
        {
            throw new SQLException("Ошибка создания записи в таблице правильных ответов: " + e.getMessage());
        }
    }

    @PutMapping(value = "/rightAnswerRef/{questId}")
    public void update(@PathVariable(value = "questId") Integer questId, @RequestBody RightAnswerRef rightAnswerRef) throws SQLException
    {
        try
        {
            rightAnswerRefService.update(questId, rightAnswerRef);
        }
        catch (Exception e)
        {
            throw new SQLException("Ошибка обновления записи в таблице правильных ответов: " + e.getMessage());
        }
    }

    @DeleteMapping(value = "/rightAnswerRef/{questId}")
    public void delete(@PathVariable(value = "questId") Integer questId) throws SQLException
    {
        try
        {
            rightAnswerRefService.delete(questId);
        }
        catch (Exception e)
        {
            throw new SQLException("Ошибка удаления записи в таблице правильных ответов: " + e.getMessage());
        }
    }
}
