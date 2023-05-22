package me.pedrokaua.loginregister.exceptions;

public class UserNamePatternException extends RuntimeException {

    public UserNamePatternException(){}

    @Override
    public String getMessage() {
        return "User name is null or length < 4";
    }
}
