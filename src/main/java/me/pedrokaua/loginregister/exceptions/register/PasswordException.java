package me.pedrokaua.loginregister.exceptions.register;

public class PasswordException extends RuntimeException{

    public PasswordException(){}

    @Override
    public String getMessage() {
        return "Password Error: 'Not equals', 'incompatibles'!";
    }
}
