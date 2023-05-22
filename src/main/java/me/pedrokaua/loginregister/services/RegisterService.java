package me.pedrokaua.loginregister.services;

import me.pedrokaua.loginregister.entitites.User;
import me.pedrokaua.loginregister.exceptions.*;
import me.pedrokaua.loginregister.infrastructure.UserDAO;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

public class RegisterService {

    public UserDAO dao = new UserDAO();

    public RegisterService() {}

    public boolean verifyName(String name){

        List<String> names = dao.findAll()
                .stream().map(u -> u.getName()).toList();

        if (name.length() < 4) {
            throw new NamePatternException();
        } else if (names.contains(name)){
            throw new NameAlreadyExistsException();
        }
        return true;
    }

    public boolean verifyUserName(String userName){
        List<String> names = dao.findAll().stream()
                .map(u -> u.getUserName()).toList();

        if (userName.length() < 4) {
            throw new UserNamePatternException();
        } else if (names.contains(userName)){
            throw new UserNameAlreadyExistsException();
        }

        return true;
    }

    public boolean verifyEmail(String email){
        List<String> emails = dao.findAll().stream()
                .map(u -> u.getEmail()).toList();

        boolean c0 = emails.contains(email);
        boolean c1 = email.contains("@");
        boolean c2 = email.contains(".com");

        if(c0) {
            throw new EmailAlreadyExistsException();
        } else if(!(c1 && c2)
            || email.equals("")) {
            throw new EmailPatternException();
        }

        return true;
    }


    public boolean verifyBirthDate(String data){
        LocalDate date = null;
        try {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            date = LocalDate.parse(data, f);
        } catch (DateTimeParseException e) {
            throw new DateTimeException(data);
        }

        return true;
    }

    public boolean verifyPassword(char[] password, char[] confirmPassword){
        System.out.println(Arrays.toString(password) + "-" + Arrays.toString(confirmPassword));
        char[] s = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
                'Z', '^', '_', '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z'};


        boolean equals = Arrays.equals(password, confirmPassword);
        boolean length = password.length > 4;
        boolean contains = Arrays.compare(password, s) >= 0
                || Arrays.compare(password, s) == -54;


        if (!(length && contains)) {
            throw new PasswordException();
        } else if(!equals) {
            throw new PasswordNotContainsException();
        }
        return true;
    }

    public void registerUser(User user){
        try {
            dao.insertUserTransaction(user);
        } catch (Exception e) {
            throw new RegisterUserException();
        }
    }

    public UserDAO getDao() {
        return dao;
    }
}
