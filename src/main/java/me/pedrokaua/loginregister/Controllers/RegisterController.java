package me.pedrokaua.loginregister.Controllers;

import me.pedrokaua.loginregister.entitites.User;
import me.pedrokaua.loginregister.exceptions.*;
import me.pedrokaua.loginregister.servicies.RegisterService;
import me.pedrokaua.loginregister.vision.RegisterScreen;

import javax.swing.*;
import java.awt.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegisterController {

    RegisterScreen screen;
    RegisterService registerService;

    public RegisterController(RegisterScreen screen) {
        this.screen = screen;
        registerService = new RegisterService();
    }

    public User getUserInfos(){
        try {
            String name = screen.getNameComplete().toString();
            String userName = screen.getNameUser().toString();
            String gender = screen.getGender().toString();

            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate date = LocalDate.parse(screen.getDate().toString(), f);

            String email = screen.getEmail().toString();
            String password = screen.getPassword().toString();

            return new User(name, userName, gender, date,
                    email, password);
        } catch (Exception e) {
            return null;
        }
    }

    public void verifyAllFields() {
        try {
            registerService.verifyName(screen.getNameComplete().toString());
            registerService.verifyUserName(screen.getNameUser().toString());
            registerService.verifyBirthDate(screen.getDate().toString());
            registerService.verifyEmail(screen.getEmail().toString());
            registerService.verifyPassword(
                    screen.getPassword().getPassword(),
                    screen.getConfirm().getPassword());

            registerService.registerUser(getUserInfos());
        } catch (NameAlreadyExistsException e) {
            screen.getNameComplete().setBackground(new Color(122, 21, 21));
            screen.getNameComplete().setForeground(Color.WHITE);
        } catch (UserNameAlreadyExistsException e) {
            screen.getNameUser().setBackground(new Color(122, 21, 21));
            screen.getNameUser().setForeground(Color.WHITE);
        } catch (DateTimeException e ){
            screen.getDate().setBackground(new Color(122, 21, 21));
            screen.getDate().setForeground(Color.WHITE);
        } catch (EmailPatternException e) {
            screen.getEmail().setBackground(new Color(122, 21, 21));
            screen.getEmail().setForeground(Color.WHITE);
        } catch (PasswordException e) {
            screen.getPassword().setBackground(new Color(122, 21, 21));
            screen.getPassword().setForeground(Color.WHITE);
            screen.getConfirm().setBackground(new Color(122, 21, 21));
            screen.getConfirm().setForeground(Color.WHITE);
        } catch (RegisterUserException e) {
            JOptionPane
                    .showMessageDialog(null, "Register Error: 'INTERNAL ERROR' > " + e.getMessage());
            registerService.getDao().restartConnection();
        }

    }
}
