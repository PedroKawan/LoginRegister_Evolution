package me.pedrokaua.loginregister.vision.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.mysql.cj.log.Log;
import me.pedrokaua.loginregister.vision.LoginScreen;
import me.pedrokaua.loginregister.vision.RegisterScreen;
import me.pedrokaua.loginregister.vision.Screen;

public class TextFieldLR extends TextField implements MouseListener{
	private static final long serialVersionUID = 1L;
    private Screen screen;

	public TextFieldLR(Screen s){
        this.screen = s;

        this.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
        this.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(screen instanceof RegisterScreen) {
                    RegisterScreen register = (RegisterScreen) screen;
                    register.getController().startDataManager();
                } else if (screen instanceof LoginScreen) {
                    LoginScreen login = (LoginScreen) screen;
                    login.getController().startDataManager();
                }
            }

        });
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        this.setBackground(Color.WHITE);
        this.setForeground(Color.BLACK);
    }

    public void mouseEntered(MouseEvent arg0) {
        this.setBackground(Color.WHITE);
        this.setForeground(Color.BLACK);
    }

    public void mouseExited(MouseEvent arg0) {}
    public void mousePressed(MouseEvent arg0) {}
    public void mouseReleased(MouseEvent arg0) {}

    @Override
    public String toString() {
        return this.getText();
    }
}
