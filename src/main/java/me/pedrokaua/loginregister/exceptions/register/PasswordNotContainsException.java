package me.pedrokaua.loginregister.exceptions.register;

public class PasswordNotContainsException extends RuntimeException{

    public PasswordNotContainsException(){}

    @Override
    public String getMessage() {
        return "Password does not contains Letters!";
    }
}
