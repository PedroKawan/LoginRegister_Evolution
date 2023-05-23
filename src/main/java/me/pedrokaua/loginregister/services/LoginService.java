package me.pedrokaua.loginregister.services;

import me.pedrokaua.loginregister.entitites.User;
import me.pedrokaua.loginregister.exceptions.login.EmailNotFoundException;
import me.pedrokaua.loginregister.exceptions.login.LoginUserException;
import me.pedrokaua.loginregister.exceptions.login.PasswordNotMatchException;
import me.pedrokaua.loginregister.dao.UserDAO;

import java.util.List;

public class LoginService {

    UserDAO dao = new UserDAO();

    public LoginService(){}

    public boolean verifyUser(String email, char[] sequence){
        try {
            boolean emailMatch = verifyEmail(email);
            boolean passwordMatch = verifyPassword(email, sequence);
            return emailMatch && passwordMatch;
        } catch (RuntimeException e) {
            throw new LoginUserException(e);
        }

    }

    public boolean verifyEmail(String email) {
        List<String> emails = dao.findAll().stream()
                .map(u -> u.getEmail()).toList();

        if (!emails.contains(email)) {
            throw new EmailNotFoundException();
        }

        return true;
    }

    public boolean verifyPassword(String email, char[] sequence){
        User user = dao.findByEmail(email);
        StringBuilder password = new StringBuilder();

        for (char c: sequence) {
            password.append(c);
        }
        if(!(user.getPassword()
                .contentEquals(password.toString()))){
            throw new PasswordNotMatchException();
        }
        System.out.println("Entered!");
        return true;
    }
}
