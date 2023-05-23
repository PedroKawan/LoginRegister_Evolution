package me.pedrokaua.loginregister.controllers;

import me.pedrokaua.loginregister.dto.UserDTO;
import me.pedrokaua.loginregister.services.DataService;
import me.pedrokaua.loginregister.vision.DataManagerScreen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class DataController {

    DataService dataService;
    DataManagerScreen screen;

    public DataController(DataManagerScreen screen) {
        this.screen = screen;
        dataService = new DataService();
    }

    public void showUserInfos(Long id){
        try {
            UserDTO user = dataService.findById(id);
            screen.getNameComplete()
                    .setText(user.getName());
            screen.getNameUser()
                    .setText(user.getUserName());
            screen.getDate()
                    .setText(user.getBirth());
            screen.getEmail()
                    .setText(user.getEmail());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(screen, "User not found!");
        }
    }

    public void setUsersOnTable(){
            List<String[]> infos
                    = dataService.findAllInfos();
            infos.forEach(i -> screen.getModel().addRow(i));
    }

    public void refreshTable(){
        dataService.deleteRows(screen.getModel());
        JOptionPane
                .showMessageDialog(null, "The Table has been updated!");
        setUsersOnTable();
    }

    public void DeleteUser(){
        DefaultTableModel model = screen.getModel();

        try {
            Long id = Long.parseLong(
                    model.getValueAt(screen.getTable().getSelectedRow(), 0).toString()
            );
            System.out.println(id);
            dataService.deleteUser(id);
            refreshTable();
        } catch (Exception e) {}
    }
}
