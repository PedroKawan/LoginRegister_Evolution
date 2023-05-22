package me.pedrokaua.loginregister.exceptions;

public class PasswordException extends RuntimeException{

    public PasswordException(){}

    @Override
    public String getMessage() {
        return "Password Error: 'Not equals' or 'characters incompatibles'!";
    }
}
