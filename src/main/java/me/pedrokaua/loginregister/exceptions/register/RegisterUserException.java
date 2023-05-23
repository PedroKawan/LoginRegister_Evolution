package me.pedrokaua.loginregister.exceptions.register;

public class RegisterUserException extends RuntimeException {

    public RegisterUserException(){}

    @Override
    public String getMessage() {
        return "Register user error!";
    }
}
