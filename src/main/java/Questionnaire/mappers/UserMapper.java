package questionnaire.mappers;

import questionnaire.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User>
{
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException
    {
        User user = new User();
        user.setFirstName(resultSet.getString("firstName"));
        user.setLastName(resultSet.getString("lastName"));
        user.setUserId(resultSet.getInt("userId"));
        user.setLogin(resultSet.getString("login"));
        user.setUserPassword(resultSet.getString("userPassword"));
        return user;
    }
}
