package me.pedrokaua.loginregister.exceptions;

public class EmailPatternException extends RuntimeException {

    public EmailPatternException(){}

    @Override
    public String getMessage() {
        return "Email pattern: does not contains '@' or '.com'";
    }
}
