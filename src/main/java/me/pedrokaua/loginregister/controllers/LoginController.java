package me.pedrokaua.loginregister.controllers;

import me.pedrokaua.loginregister.exceptions.login.EmailNotFoundException;
import me.pedrokaua.loginregister.exceptions.login.LoginUserException;
import me.pedrokaua.loginregister.services.LoginService;
import me.pedrokaua.loginregister.vision.DataManagerScreen;
import me.pedrokaua.loginregister.vision.LoginScreen;

import java.awt.*;

public class LoginController {

    LoginScreen screen;
    LoginService loginService;


    public LoginController(LoginScreen screen) {
        this.screen = screen;
        loginService = new LoginService();
    }

    public void enterDataManager() {
        if (verifyUser()) {
            screen.dispose();
            new DataManagerScreen();
        }
    }

    public boolean verifyUser() {
        String email = screen.getEmail().toString();
        char[] password = screen.getPassword().getPassword();

        try {
            loginService.verifyUser(email, password);
            return true;
        } catch (LoginUserException e) {
            screen.getError().setText(e.getCause().getMessage());
            if (e.getCause() instanceof EmailNotFoundException) {
                screen.getEmail().setBackground(new Color(122, 21, 21));
                screen.getEmail().setForeground(Color.WHITE);
            } else {
                screen.getPassword().setBackground(new Color(122, 21, 21));
                screen.getPassword().setForeground(Color.WHITE);
            }

            return false;
        }
    }



}
