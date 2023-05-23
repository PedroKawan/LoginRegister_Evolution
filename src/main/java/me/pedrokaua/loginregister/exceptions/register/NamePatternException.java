package me.pedrokaua.loginregister.exceptions.register;

public class NamePatternException extends RuntimeException {

    public NamePatternException(){}

    @Override
    public String getMessage() {
        return "Name is null or length < 4";
    }
}
