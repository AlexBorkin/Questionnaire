package Questionnaire.Service;
import Questionnaire.Entities.User;
import Questionnaire.Mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class UserService
{
    public final DataSource dataSource;
    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserService(final DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    public void create(User user)
    {
        String sqlQuery = "insert into public.users(\"firstName\", \"lastName\", login, \"userPassword\") values (?, ?, ?, ?);";

        jdbcTemplate.update(sqlQuery,
                user.getFirstName(),
                user.getLastName(),
                user.getLogin(),
                user.getUserPassword());
    }

    public List<User> getAll()
    {
        String sqlQuery = "select * from public.users";
        List<User> listUser = jdbcTemplate.query(sqlQuery, new UserMapper());

        return listUser;
    }

    public User read(int id)
    {
        String sqlQuery = "select * from public.users where \"userId\" = ?;";
        List<User> listUser = jdbcTemplate.query(sqlQuery, new Integer[]{id}, new UserMapper());
        return !listUser.isEmpty() && listUser != null ? listUser.get(0) :  null;
    }

    public void update(int id, User user)
    {
        String sqlQuery = "update public.users " +
                "set \"firstName\"=?, \"lastName\"=?, login=?, \"userPassword\"=? where \"userId\" = ?;";

        jdbcTemplate.update(sqlQuery,
                user.getFirstName(),
                user.getLastName(),
                user.getLogin(),
                user.getUserPassword(),
                id);
    }

    public void delete(int id)
    {
        String sqlQuery = "delete from public.users where \"userId\" = ?;";

        jdbcTemplate.update(sqlQuery,id);
    }
}
