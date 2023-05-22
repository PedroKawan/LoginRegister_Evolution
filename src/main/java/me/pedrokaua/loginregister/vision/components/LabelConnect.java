package me.pedrokaua.loginregister.vision.components;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import me.pedrokaua.loginregister.vision.DataManagerScreen;
import me.pedrokaua.loginregister.vision.LoginScreen;
import me.pedrokaua.loginregister.vision.RegisterScreen;
import me.pedrokaua.loginregister.vision.Screen;

public class LabelConnect extends JLabel implements MouseListener{
	private static final long serialVersionUID = 1L;
	
	Screen screenCurrent;
	String type;
	
	public LabelConnect(Screen screenCurrent, String type){	
		this.screenCurrent = screenCurrent;
		this.type = type;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
//		DataBase.getInstance().clear();
		screenCurrent.dispose();
		if (this.type.equalsIgnoreCase("login")) {
			new LoginScreen();
		} else if (this.type.equalsIgnoreCase("register")) {
			new RegisterScreen();
		} else {
			new DataManagerScreen();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setForeground(Color.CYAN);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setForeground(Color.WHITE);
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
}
