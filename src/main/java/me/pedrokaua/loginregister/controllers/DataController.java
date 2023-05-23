package me.pedrokaua.loginregister.controllers;

import me.pedrokaua.loginregister.dto.UserDTO;
import me.pedrokaua.loginregister.entitites.User;
import me.pedrokaua.loginregister.services.DataService;
import me.pedrokaua.loginregister.vision.DataManagerScreen;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class DataController {

    DataService dataService;

    DataManagerScreen screen;

    public DataController(DataManagerScreen screen) {
        this.screen = screen;
        dataService = new DataService();
    }

    public void showUserInfos(Long id){
        UserDTO user
                = dataService.findById(id);
        screen.getNameComplete()
                .setText(user.getUserName());
        screen.getNameUser()
                .setText(user.getUserName());
        screen.getDate()
                .setText(user.getBirth());
        screen.getEmail()
                .setText(user.getEmail());
    }

    public void setUsersOnTable(){
            List<String[]> infos
                    = dataService.findAllInfos();
            infos.forEach(i -> screen.getModel().addRow(i));
    }
}
