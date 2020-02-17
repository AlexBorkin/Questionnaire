package Questionnaire.Entities;

public class User
{
    private String firstName;
    private String lastName;
    private String login;
    private Integer userId;
    private String  userPassword;

    public User()
    {
    }

    public User(String firstName, String lastName, String login, Integer userId, String userPassword)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
