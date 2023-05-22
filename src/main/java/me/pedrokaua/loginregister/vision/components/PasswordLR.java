package me.pedrokaua.loginregister.vision.components;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import me.pedrokaua.loginregister.vision.RegisterScreen;
import me.pedrokaua.loginregister.vision.Screen;

public class PasswordLR extends JPasswordField implements MouseListener {
    private static final long serialVersionUID = 1L;

    public PasswordLR(Screen screen){
        this.setFont(new Font(Font.DIALOG, Font.CENTER_BASELINE, 14));
        this.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent arg0) {
                if (screen instanceof RegisterScreen) {
                    RegisterScreen register = (RegisterScreen) screen;
                    register.getController().verifyAllFields();
                }
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.setBackground(Color.WHITE);
        this.setForeground(Color.BLACK);
    }

    public void mouseEntered(MouseEvent e) {
        this.setBackground(Color.WHITE);
        this.setForeground(Color.BLACK);
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseExited(MouseEvent e) { }

    @Override
    public String toString() {
        char[] sequence = this.getPassword();
        StringBuilder password = new StringBuilder();
        for (char c: sequence) {
            password.append(c);
        }
        return password.toString();
    }
}