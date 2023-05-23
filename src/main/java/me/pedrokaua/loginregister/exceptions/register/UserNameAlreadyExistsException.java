package me.pedrokaua.loginregister.exceptions.register;

public class UserNameAlreadyExistsException extends RuntimeException{

    public UserNameAlreadyExistsException(){}

    @Override
    public String getMessage() {
        return "This name has already been registered";
    }
}
