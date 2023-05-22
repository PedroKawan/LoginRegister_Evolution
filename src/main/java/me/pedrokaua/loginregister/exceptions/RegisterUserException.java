package me.pedrokaua.loginregister.exceptions;

public class RegisterUserException extends RuntimeException {

    public RegisterUserException(){}

    @Override
    public String getMessage() {
        return "Register user error!";
    }
}
