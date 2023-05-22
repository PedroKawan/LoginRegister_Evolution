package me.pedrokaua.loginregister.test;


import me.pedrokaua.loginregister.entitites.User;
import me.pedrokaua.loginregister.infrastructure.UserDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
/*
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.of(2006,12, 17);
        f.format(date);

        User user = new User("Pedro Kauã Silva dos Santos", "Pedro Kawan", "M", date, "pedro@gmail.com", "123456");
        User user2 = new User("João Victor Costa Gomes", "Joao", "M", date, "pedro@gmail.com", "123456");
        dao.insertUserTransaction(user2);
*/

        UserDAO dao = new UserDAO();
        User user = dao.findById(11L);
        /*user.setEmail("joão@gmail.com");
        dao.updateUserTransaction(user);
        dao.findAll().forEach(u -> System.out.println(u.getName() + " - " + u.getUserName()));*/
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date = user.getBirth();
        String data = date.format(f);
        System.out.println(data);
        dao.closeConnection();


    }
}
