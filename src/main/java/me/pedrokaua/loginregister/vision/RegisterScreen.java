package me.pedrokaua.loginregister.vision;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import me.pedrokaua.loginregister.controllers.RegisterController;
import me.pedrokaua.loginregister.vision.components.ButtonLR;
import me.pedrokaua.loginregister.vision.components.PasswordLR;
import me.pedrokaua.loginregister.vision.components.LabelConnect;
import me.pedrokaua.loginregister.vision.components.TextFieldLR;

public class RegisterScreen extends Screen {
    TextFieldLR nameComplete, nameUser, date, email;
    PasswordLR password, confirm;
    
    JLabel nameCompleteLabel, nameUserLabel, dateLabel, emailLabel, passwordLabel, confirmLabel, error;
    
    LabelConnect connectionScreens;
    
    ButtonLR button;

    LoginScreen loginScreen;

    RegisterController controller
            = new RegisterController(this);
    
    boolean isMan = true;
    boolean isWoman = false;
    
    public RegisterScreen(){
        define();
        creatingLabel();
        creatingButton();
        creatingTextField();
        creatingConnectScreen();
        SwingUtilities.invokeLater(() -> {
            repaint();
            validate();
        });
    }
    
    protected void define() {
        // 'Screen' attributes
        labelLateral.setText("REGISTER");
        this.setTitle("REGISTER SCREEN");
        labelCentral.setText("Welcome");
        try {
            imageLateral =
                    new ImageIcon("src/main/java/me/pedrokaua/loginregister/imagens/register.png");
        } catch(Exception e) {
            System.out.println("add image path");
        }
        panelLateralGradient
                = new GradientPaint(0, 0, new Color(10, 10, 255), 300, 600, new Color(150, 20, 255));
    }
    
    void creatingTextField(){
        // TextFields
        nameComplete = new TextFieldLR(this);
        nameComplete.setBounds(140, 120, 300, 30);

        nameUser = new TextFieldLR(this);
        nameUser.setBounds(140, 180, 300, 30);

        date = new TextFieldLR(this);
        date.setBounds(140, 240, 300, 30);

        email = new TextFieldLR(this);
        email.setBounds(140, 300, 300, 30);

        password = new PasswordLR(this);
        password.setBounds(140, 360, 300, 30);

        confirm = new PasswordLR(this);
        confirm.setBounds(140, 420, 300, 30);

        Arrays.asList(nameComplete, nameUser, date, email, password, confirm)
                .forEach(f -> f.addMouseListener(f));

        this.add(date);
        this.add(nameUser);
        this.add(nameComplete);
        this.add(email);
        this.add(password);
        this.add(confirm);
    }

    void creatingLabel(){
        // Labels ('Name' 'Email')
        nameCompleteLabel = new JLabel();
        nameCompleteLabel.setText("Name Complete");
        nameCompleteLabel.setBounds(140, 120 - 25, 100, 20);
        nameCompleteLabel.setForeground(Color.WHITE);

        nameUserLabel = new JLabel();
        nameUserLabel.setText("User Name");
        nameUserLabel.setBounds(140, 180 - 25, 100, 20);
        nameUserLabel.setForeground(Color.WHITE);

        dateLabel = new JLabel();
        dateLabel.setText("Birth Date Ex:(2000/05/20)");
        dateLabel.setBounds(140, 240 - 25, 200, 20);
        dateLabel.setForeground(Color.WHITE);

        emailLabel = new JLabel();
        emailLabel.setText("Email");
        emailLabel.setBounds(140, 300 - 25, 100, 20);
        emailLabel.setForeground(Color.WHITE);

        passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setBounds(140, 360 - 25, 100, 20);
        passwordLabel.setForeground(Color.WHITE);

        confirmLabel = new JLabel();
        confirmLabel.setText("Confirm password");
        confirmLabel.setBounds(140, 420 - 25, 120, 20);
        confirmLabel.setForeground(Color.WHITE);

        error = new JLabel();
        error.setText("(!) fill in the fields correctly!");
        error.setBounds(140, 462, 315, 20);
        error.setFont(new Font("Dialog", Font.BOLD, 12));
        error.setForeground(new Color(200, 10, 10));

        this.add(dateLabel);
        this.add(nameUserLabel);
        this.add(nameCompleteLabel);
        this.add(emailLabel);
        this.add(passwordLabel);
        this.add(confirmLabel);
        this.add(error);
    }
    
    
    private void creatingConnectScreen() {
        //Connect 'register and login' screens with label
        connectionScreens = new LabelConnect(this, "login");
        connectionScreens.setText("Login now!");
        connectionScreens.setBounds(365, 490, 100, 20);
        connectionScreens.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        connectionScreens.setForeground(Color.WHITE);
        connectionScreens.addMouseListener(connectionScreens);

        this.add(connectionScreens);
    }
    

    void creatingButton(){
        // Button 'Register now'
        button = new ButtonLR(this);
        button.setText("Register");
        button.setBounds(140, 493, 120, 30);
        button.setBackground(new Color(100, 100, 100));
        button.setForeground(new Color(255, 255, 255));
        button.setBorder(BorderFactory.createBevelBorder(0));
        button.addMouseListener(button);
        this.add(button);
        
        JButton buttonMen = new JButton();
        JButton buttonWomen = new JButton();
        
        buttonMen.setText("Man");
        buttonMen.setBounds(240, 10, 50, 30);
        buttonMen.setBackground(new Color(100, 100, 255));
        buttonMen.setForeground(new Color(255, 255, 255));
        buttonMen.setBorder(BorderFactory.createEmptyBorder());
        buttonMen.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //e -> {}
        buttonMen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isMan = true;
                isWoman = false;
                buttonMen.setBorder(BorderFactory.createEtchedBorder(1));
                buttonWomen.setBorder(BorderFactory.createEmptyBorder());
                panelRepaint();
            }
        });
        this.add(buttonMen);
        
        buttonWomen.setText("Woman");
        buttonWomen.setBounds(310, 10, 50, 30);
        buttonWomen.setBackground(new Color(255, 100, 100));
        buttonWomen.setForeground(new Color(255, 255, 255));
        buttonWomen.setBorder(BorderFactory.createEmptyBorder());
        buttonWomen.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonWomen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isMan = false;
                isWoman = true;
                buttonMen.setBorder(BorderFactory.createEmptyBorder());
                buttonWomen.setBorder(BorderFactory.createEtchedBorder(1));
                panelRepaint();
            }

        });
        this.add(buttonWomen);
    }

    private void panelRepaint() {
        if (isMan) {
            panelLateralGradient
                    = new GradientPaint(0, 0, new Color(10, 10, 255), 300, 600, new Color(150, 20, 255));
        } else {
            panelLateralGradient
                    = new GradientPaint(0, 0, new Color(255, 0, 94), 300, 600, new Color(150, 20, 255));
        }

    }

    public void registerUser(){
        var p = password.getPassword();
        System.out.println(Arrays.toString(p));
        controller.verifyAllFields();
    }

    public TextFieldLR getNameComplete() {
        return nameComplete;
    }

    public TextFieldLR getNameUser() {
        return nameUser;
    }
    public TextFieldLR getDate() {
        return date;
    }

    public Character getGender() {
        return (isMan) ? 'M' : 'F';
    }

    public TextFieldLR getEmail() {
        return email;
    }

    public PasswordLR getPassword() {
        return password;
    }

    public PasswordLR getConfirm() {
        return confirm;
    }

    public JLabel getError() {
        return this.error;
    }
    public RegisterController getController() {
        return controller;
    }

    public static void main(String[] args) {
        new RegisterScreen();
    }
}
