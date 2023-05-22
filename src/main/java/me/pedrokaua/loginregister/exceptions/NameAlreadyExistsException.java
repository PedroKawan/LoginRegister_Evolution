package me.pedrokaua.loginregister.exceptions;

public class NameAlreadyExistsException extends RuntimeException {

    public NameAlreadyExistsException(){}

    @Override
    public String getMessage() {
        return "Name length < 4";
    }
}
