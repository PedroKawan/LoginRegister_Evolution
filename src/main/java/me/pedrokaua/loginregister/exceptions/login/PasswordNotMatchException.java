package me.pedrokaua.loginregister.exceptions.login;

public class PasswordNotMatchException extends RuntimeException {

    public PasswordNotMatchException(){}

    @Override
    public String getMessage() {
        return "Password does not match the email!";
    }
}
