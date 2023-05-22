package me.pedrokaua.loginregister.vision.components;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import me.pedrokaua.loginregister.vision.RegisterScreen;
import me.pedrokaua.loginregister.vision.Screen;

public class ButtonLR extends JButton implements MouseListener{
	private static final long serialVersionUID = 1L;
	
	Screen screen;
	
	public ButtonLR(Screen screen) {
		this.screen = screen;
	}
	
    public void mouseClicked(MouseEvent arg0) {
        if (screen instanceof RegisterScreen){
            RegisterScreen register = (RegisterScreen) screen;
            register.getController().verifyAllFields();
        }
    }

    public void mouseEntered(MouseEvent arg0) {
    	this.setForeground(new Color(100, 200, 255));
    }
    public void mouseExited(MouseEvent arg0) {
    	this.setForeground(Color.WHITE);
    }
    public void mousePressed(MouseEvent arg0) {}
    public void mouseReleased(MouseEvent arg0) {}

}
