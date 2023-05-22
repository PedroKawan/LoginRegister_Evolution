package me.pedrokaua.loginregister.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(){}

    @Override
    public String getMessage() {
        return "Email was already been registered!";
    }
}
