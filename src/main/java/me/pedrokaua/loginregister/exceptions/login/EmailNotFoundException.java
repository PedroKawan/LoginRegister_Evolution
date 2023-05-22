package me.pedrokaua.loginregister.exceptions.login;

public class EmailNotFoundException extends RuntimeException {

    public EmailNotFoundException(){}

    @Override
    public String getMessage() {
        return "Email not found!";
    }
}
