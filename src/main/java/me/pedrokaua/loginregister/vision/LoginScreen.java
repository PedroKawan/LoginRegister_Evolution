package me.pedrokaua.loginregister.vision;

import me.pedrokaua.loginregister.controllers.LoginController;
import me.pedrokaua.loginregister.vision.components.ButtonLR;
import me.pedrokaua.loginregister.vision.components.LabelConnect;
import me.pedrokaua.loginregister.vision.components.PasswordLR;
import me.pedrokaua.loginregister.vision.components.TextFieldLR;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends Screen{
    private static final long serialVersionUID = 1L;

    TextFieldLR email;
    PasswordLR password;

    JLabel emailLabel, passwordLabel, error;
    LabelConnect connectionScreens;

    LoginController controller
            = new LoginController(this);

    ButtonLR button;
    RegisterScreen registerScreen;

    public LoginScreen(){
        define();
        creatingTextField();
        creatingLabel();
        creatingButton();
        creatingConnectScreen();

        SwingUtilities.invokeLater(() -> {
            repaint();
            validate();
        });
    }


    protected void define() {
        // 'Screen' attributes
        labelLateral.setText("LOGIN");
        this.setTitle("LOGIN SCREEN");
        labelCentral.setText("Hello user!");
        labelCentral.setLocation(60, labelCentral.getY());
        try {
            imageLateral =
                    new ImageIcon("src/main/java/me/pedrokaua/loginregister/imagens/login.png");
        } catch(Exception e) {
            System.out.println("add image path");
        }
        panelLateralGradient
                = new GradientPaint(0, 0, new Color(100, 200, 255), 300, 600, new Color(10, 10, 200));
    }

    private void creatingTextField() {
        email = new TextFieldLR(this);
        email.setBounds(140, 160, 300, 30);
        email.addMouseListener(email);
        email.addMouseListener(email);

        password = new PasswordLR(this);
        password.setBounds(140, 260, 300, 30);
        password.addMouseListener(password);

        this.add(email);
        this.add(password);
    }


    void creatingLabel() {
        // Labels ('Email' 'Password')
        emailLabel = new JLabel();
        emailLabel.setText("Email");
        emailLabel.setBounds(140, email.getY() - 25, 100, 20);
        emailLabel.setForeground(Color.WHITE);
        
        passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setBounds(140, password.getY() - 25, 100, 20);
        passwordLabel.setForeground(Color.WHITE);

        error = new JLabel();
        error.setText("(!) fill in the fields correctly!");
        error.setBounds(140, 300, 315, 20);
        error.setFont(new Font("Dialog", Font.BOLD, 12));
        error.setForeground(new Color(200, 10, 10));

        this.add(emailLabel);
        this.add(passwordLabel);
        this.add(error);
    }

    private void creatingConnectScreen() {
        //Connect 'register and login' screens with label
        connectionScreens = new LabelConnect(this, "register");
        connectionScreens.setText("Register now!");
        connectionScreens.setBounds(340, 334, 100, 20);
        connectionScreens.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        connectionScreens.setForeground(Color.WHITE);
        connectionScreens.addMouseListener(connectionScreens);

        this.add(connectionScreens);
    }


    void creatingButton(){
        // Button 'Register now'
        button = new ButtonLR(this);
        button.setText("Sign in");
        button.setBounds(140, 330, 120, 30);
        button.setBackground(new Color(100, 100, 100));
        button.setForeground(new Color(255, 255, 255));
        button.setBorder(BorderFactory.createBevelBorder(0));
        button.addMouseListener(button);
        this.add(button);
    }

    public TextFieldLR getEmail() {
        return email;
    }

    public PasswordLR getPassword() {
        return password;
    }

    public JLabel getError() {
        return error;
    }

    public LabelConnect getConnectionScreens() {
        return connectionScreens;
    }

    public LoginController getController() {
        return controller;
    }

}
