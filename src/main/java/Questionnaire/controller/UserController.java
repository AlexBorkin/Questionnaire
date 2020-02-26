package questionnaire.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import questionnaire.entities.User;
import questionnaire.service.UserService;

import java.sql.SQLException;
import java.util.List;

@RestController
public class UserController
{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public List<User> getAll()
    {
        return userService.getAll();
    }

    @GetMapping(value = "/user/{id}")
    public User read(@PathVariable(name ="id") Integer id)
    {
        return userService.read(id);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<ObjectNode> create(@RequestBody User user) throws SQLException, JsonProcessingException {
        ResponseEntity<ObjectNode> response;
        String retStr;
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.instance);

        User userExist = userService.checkExist(user.getLogin());

        if (userExist == null)
        {
            try
            {
                userService.create(user);
                objectNode.put("ОК", "Пользователь успешно добавлен!");
                response = new ResponseEntity<ObjectNode>(objectNode, HttpStatus.OK);
            }
            catch (Exception e)
            {
                throw new SQLException("Ошибка создания записи в таблице пользователей: " + e.getMessage());
            }
        }
        else
        {
            retStr = String.format("Пользователь с логином %s уже существует!", user.getLogin());
            objectNode.put("Ошибка", retStr);
            response = new ResponseEntity<ObjectNode>(objectNode, HttpStatus.BAD_REQUEST);
        }

        return  response;
    }

    @PutMapping(value="/user/{id}")
    public void update(@PathVariable(name="id") Integer id, @RequestBody User user) throws SQLException
    {
        try
        {
            userService.update(id, user);
        }
        catch (Exception e)
        {
            throw new SQLException("Ошибка обновления записи в таблице пользователей: " + e.getMessage());
        }
    }

    @DeleteMapping(value="/user/{id}")
    public void delete(@PathVariable(name="id") Integer id) throws SQLException
    {
        try
        {
            userService.delete(id);
        }
        catch (Exception e)
        {
            throw new SQLException("Ошибка удаления записи в таблице пользователей: " + e.getMessage());
        }
    }
}
