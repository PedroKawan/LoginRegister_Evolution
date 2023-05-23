package me.pedrokaua.loginregister.exceptions.register;

public class UserNamePatternException extends RuntimeException {

    public UserNamePatternException(){}

    @Override
    public String getMessage() {
        return "User name is null or length < 4";
    }
}
