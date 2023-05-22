package me.pedrokaua.loginregister.exceptions.login;

import com.google.protobuf.Message;

public class LoginUserException extends RuntimeException {

    private String message;
    private Throwable cause;

    public LoginUserException(){}
    public LoginUserException(String message){
        this.message = message;
    }

    public LoginUserException(Throwable cause){
        this.cause = cause;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
