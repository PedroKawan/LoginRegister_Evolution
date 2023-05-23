package me.pedrokaua.loginregister.vision;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import me.pedrokaua.loginregister.controllers.DataController;
import me.pedrokaua.loginregister.vision.components.TableLR;
import me.pedrokaua.loginregister.vision.components.LabelConnect;
import me.pedrokaua.loginregister.vision.components.RenderofTable;

public class DataManagerScreen extends Screen {
	private static final long serialVersionUID = 1L;

	private JLabel nameComplete, nameUser, gender, date, email,
			imageUser;

	private LabelConnect loginConnect, registerConnect;

	private ImageIcon image
			= new ImageIcon("src/main/java/me/pedrokaua/loginregister/imagens/user.png");

	DataController controller
			= new DataController(this);

	private JButton Button;
	private DefaultTableModel model;
	private TableLR table;
	private JScrollPane scroll;

	public DataManagerScreen() {
		define();
		try {
			table = new TableLR(this);
			creatingTable();
		} catch (Exception e) {
			System.out.println("creating Table error");
		}
		creatingButton();
		creatingNewLabel();
		creatingConnect();
		this.refresh();
		setUsersOnTable();
	}


	private void creatingConnect() {
		loginConnect = new LabelConnect(this, "login");
		loginConnect.setBounds(380, 250, 40, 20);
		loginConnect.setText("Login");
		loginConnect.setForeground(Color.WHITE);
		loginConnect.addMouseListener(loginConnect);

		registerConnect = new LabelConnect(this, "register");
		registerConnect.setBounds(280, 250, 50, 20);
		registerConnect.setText("Register");
		registerConnect.setForeground(Color.WHITE);
		registerConnect.addMouseListener(registerConnect);

		this.add(loginConnect);
		this.add(registerConnect);
	}

	private void creatingButton() {
		Button = new JButton();
		Button.setFont(new Font("arial", Font.BOLD, 12));
		Button.setText("Data");
		Button.setSize(50, 20);
		Button.setLocation(630, 318);
		Button.setBorder(BorderFactory.createEmptyBorder());
		Button.setForeground(new Color(0, 255, 0));
		Button.setBackground(new Color(150, 150, 150));
		addButtonAction();
		this.add(Button);
	}

	private void addButtonAction() {
		Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,
						"I MADE THIS PROJECT WITH DEDICATION JUST TO TRAIN!\n" +
								"(PT-BR) Feito por: Pedro Kauã", "MESSAGE TO YOU",
						JOptionPane.PLAIN_MESSAGE);
			}

		});
	}

	public void define() {
		this.setTitle("DATABASE SCREEN");

		this.remove(labelCentral);
		panelLateral.setBounds(700, 0, 200, 600);

		labelLateral.setBounds(700, labelLateral.getY(), 190, 20);
		labelLateral.setText("DATABASE");

		panelLabelLateral.setBounds(700, panelLabelLateral.getY(), 200, panelLabelLateral.getHeight());
		imagePositionX = 28;

		panelLateralGradient = new GradientPaint(-50, -50, new Color(30, 30, 30), 200, 600, new Color(1, 222, 20));
	}

	@SuppressWarnings("serial")
	private void creatingTable() {
		// Creating table info
		String[] identifiers = { "id", "name", "user_name", "gender", "birth", "email", "password" };
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.setColumnCount(7);
		model.setColumnIdentifiers(identifiers);

		table = new TableLR(this);
		table.setModel(model);
		table.setDefaultRenderer(Object.class, new RenderofTable());
		table.addMouseListener(table);

		scroll = new JScrollPane(table);
		scroll.setBounds(20, 340, 660, 200);
		scroll.setBackground(new Color(0, 150, 0));

		this.add(scroll);
	}

	private void creatingNewLabel() {
		// Labels "title"
		imageUser = new JLabel();
		imageUser.setBounds(50, 50, 128, 128);
		imageUser.setIcon(image);

		nameComplete = new JLabel();
		nameComplete.setText("Pedro Kauã Silva dos Santos");
		nameComplete.setBounds(200, 52, 200, 30);

		nameUser = new JLabel();
		nameUser.setText("Pedro Kawan");
		nameUser.setBounds(38, 182, 155, 20);
		nameUser.setHorizontalAlignment(JLabel.CENTER);

		date = new JLabel();
		date.setText("2004/09/20");
		date.setBounds(200, 82, 100, 30);

		email = new JLabel();
		email.setText("pedro@gmail.com");
		email.setBounds(200, 112, 200, 30);

		gender = new JLabel();
		gender.setText("(M)");
		gender.setBounds(200, 142, 20, 30);

		// lambda modify
		Arrays.asList(nameComplete, nameUser, gender, date, email)
				.forEach(l -> {
					l.setForeground(new Color(56, 144, 56));
				});

		this.add(date);
		this.add(nameUser);
		this.add(nameComplete);
		this.add(gender);
		this.add(email);
		this.add(imageUser);
	}

	private void setUsersOnTable() {
		controller.setUsersOnTable();
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public TableLR getTable() {
		return table;
	}

	public JLabel getNameComplete() {
		return nameComplete;
	}

	public void setNameComplete(JLabel nameComplete) {
		this.nameComplete = nameComplete;
	}

	public JLabel getNameUser() {
		return nameUser;
	}

	public void setNameUser(JLabel nameUser) {
		this.nameUser = nameUser;
	}

	public JLabel getGender() {
		return gender;
	}

	public void setGender(JLabel gender) {
		this.gender = gender;
	}

	public JLabel getDate() {
		return date;
	}

	public void setDate(JLabel date) {
		this.date = date;
	}

	public JLabel getEmail() {
		return email;
	}

	public void setEmail(JLabel email) {
		this.email = email;
	}

	public DataController getController() {
		return controller;
	}

	public static void main(String[] args) {
		new DataManagerScreen();
	}
}
