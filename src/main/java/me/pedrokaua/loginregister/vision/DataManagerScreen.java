package me.pedrokaua.loginregister.vision;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import me.pedrokaua.loginregister.vision.components.TableLR;
import me.pedrokaua.loginregister.vision.components.LabelConnect;
import me.pedrokaua.loginregister.vision.components.RenderofTable;

public class DataManagerScreen extends Screen {
	private static final long serialVersionUID = 1L;

	private JLabel nameComplete, nameUser, gender, date, email, password;
	private JLabel nameCompleteResp, nameUserResp, genderResp, dateResp, emailResp, passwordResp;

	private LabelConnect loginConnect, registerConnect;

	public List<JLabel> listLabels;
	public List<JLabel> listLabelsResp;

	Function<Map<String, String>, String[]> getAttributes = u -> {
		String[] values = { u.get("namecomplete"), u.get("username"), u.get("gender"), u.get("birthdate"),
				u.get("email"), u.get("password") };
		return values;
	};

	private JButton Button;
	private DefaultTableModel model;
	public TableLR table;
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
		creatingNewLabelResponses();
		creatingConnect();
		this.refresh();

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
		String[] identifiers = { "NameComplete", "UserName", "Gender", "BirthDate", "Email", "Password" };
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.setColumnCount(6);
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
		nameComplete = new JLabel();
		nameComplete.setText("Name Complete:");
		nameComplete.setBounds(20, 20, 100, 20);

		nameUser = new JLabel();
		nameUser.setText("User Name:");
		nameUser.setBounds(20, 60, 100, 20);

		gender = new JLabel();
		gender.setText("Gender:");
		gender.setBounds(20, 100, 100, 20);

		date = new JLabel();
		date.setText("Birth Date:");
		date.setBounds(20, 100, 100, 20);

		email = new JLabel();
		email.setText("Email:");
		email.setBounds(20, 140, 100, 20);

		password = new JLabel();
		password.setText("Password:");
		password.setBounds(20, 180, 100, 20);

		int[] positionAfter = {20, 20};
		listLabels = Arrays.asList(nameComplete, nameUser, gender, date, email, password);

		// lambda modify
		listLabels.forEach(l -> {
			l.setLocation(positionAfter[0], positionAfter[1]);
			positionAfter[1] += 40;
			l.setForeground(new Color(70, 150, 70));
		});

		this.add(date);
		this.add(nameUser);
		this.add(nameComplete);
		this.add(gender);
		this.add(email);
		this.add(password);
	}

	private void creatingNewLabelResponses() {
		// Labels "title"
		nameCompleteResp = new JLabel();
		nameCompleteResp.setText("Name Complete");
		nameCompleteResp.setBounds(20, 0, 200, 20);
		nameCompleteResp.setForeground(Color.WHITE);
		nameCompleteResp.setHorizontalAlignment(SwingConstants.RIGHT);

		nameUserResp = new JLabel();
		nameUserResp.setText("User Name");
		nameUserResp.setBounds(20, 0, 200, 20);
		nameUserResp.setForeground(Color.WHITE);
		nameUserResp.setHorizontalAlignment(SwingConstants.RIGHT);

		genderResp = new JLabel();
		genderResp.setText("Gender");
		genderResp.setBounds(20, 0, 200, 20);
		genderResp.setForeground(Color.WHITE);
		genderResp.setHorizontalAlignment(SwingConstants.RIGHT);

		dateResp = new JLabel();
		dateResp.setText("Birth Date");
		dateResp.setBounds(20, 0, 200, 20);
		dateResp.setForeground(Color.WHITE);
		dateResp.setHorizontalAlignment(SwingConstants.RIGHT);

		emailResp = new JLabel();
		emailResp.setText("Email");
		emailResp.setBounds(20, 0, 200, 20);
		emailResp.setForeground(Color.WHITE);
		emailResp.setHorizontalAlignment(SwingConstants.RIGHT);

		passwordResp = new JLabel();
		passwordResp.setText("Password");
		passwordResp.setBounds(20, 0, 200, 20);
		passwordResp.setForeground(Color.WHITE);
		passwordResp.setHorizontalAlignment(SwingConstants.RIGHT);

		int[] positionAfter = { 460, 20 };
		listLabelsResp = Arrays.asList(nameCompleteResp, nameUserResp, genderResp, dateResp, emailResp, passwordResp);

		listLabelsResp.forEach(l -> l.setForeground(Color.GREEN));

		// lambda modify
		listLabelsResp.forEach(l -> {
			l.setLocation(positionAfter[0], positionAfter[1]);
			positionAfter[1] += 40;
			l.setText("...");
		});

		this.add(dateResp);
		this.add(nameUserResp);
		this.add(nameCompleteResp);
		this.add(genderResp);
		this.add(emailResp);
		this.add(passwordResp);
	}

	public static void main(String[] args) {
		new DataManagerScreen();
	}
}
