package Questionnaire.Controller;

import Questionnaire.Entities.User;
import Questionnaire.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/users")
    public void create(@RequestBody User user)
    {
        userService.create(user);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAll()
    {
        List<User> listUsers = userService.getAll();

        ResponseEntity<List<User>> response;

        if (listUsers != null && !listUsers.isEmpty())
        {
            response = new ResponseEntity<>(listUsers, HttpStatus.OK);
        }
        else
        {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return response;
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> read(@PathVariable(name ="id") Integer id)
    {
        ResponseEntity<User> response;

        User user = userService.read(id);

        if (user != null)
        {
            response = new ResponseEntity<>(user, HttpStatus.OK);
        }
        else
        {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return response;
    }

    @PutMapping(value="/users/{id}")
    public void update(@PathVariable(name="id") Integer id, @RequestBody User user)
    {
        userService.update(id, user);
    }

    @DeleteMapping(value="/users/{id}")
    public void delete(@PathVariable(name="id") Integer id)
    {
        userService.delete(id);
    }
}
