package me.pedrokaua.loginregister.vision;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public abstract class Screen extends JFrame{
	private static final long serialVersionUID = 1L;
	protected ImageIcon imageLateral
		= new ImageIcon("src/main/java/me/pedrokaua/loginregister/imagens/computer.png");
	protected int imagePositionX = 85;
	protected int imagePositionY = 200;
	
//	public DataBase database = new DataBase();
	
	protected GradientPaint panelLateralGradient
		= new GradientPaint(0, 0, new Color(0, 0, 0), 300, 600, new Color(255, 255, 255));
	
	
	protected JPanel panelLateral, panelCentral, panelLabelLateral;	
	protected JLabel labelLateral, labelCentral, signature;

	public Screen(){
		creatingScreen();
		creatingLabel();
		creatingPanel();
	}

	protected void refresh() {
		SwingUtilities.invokeLater(() -> {
			repaint();
			validate();
		});
	}

	private void creatingScreen() {
		//Screen configuration 
		this.setSize(900, 600);
		this.setTitle("SCREEN-SCREEN");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(30, 30, 30));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setIconImage(new ImageIcon(
				"src/main/java/me/pedrokaua/loginregister/imagens/iconScreen.png").getImage());
		this.setVisible(true);
	}

	void creatingPanel(){
		//Panel Lateral with contrast.
		panelLateral = new JPanel(){
		private static final long serialVersionUID = 1L;

			@Override
			public void paint(Graphics arg0) {
				Graphics2D g2d = (Graphics2D) arg0;
				g2d.setPaint(panelLateralGradient);
				g2d.fillRect(0, 0, 300, 600);
				
				try {
					g2d.drawImage(imageLateral.getImage(), imagePositionX,
							imagePositionY, null);
		        }catch(Exception e) {
		        	throw new RuntimeException(e.getMessage());
		        }
				refresh();
			}
		};
		panelLateral.setSize(300, 600);
		panelLateral.setLocation(600, 0);
		panelLateral.setBackground(new Color(240, 0, 240));

		//Panel of Label -> Lateral
		panelLabelLateral = new JPanel();
		panelLabelLateral.setBounds(600, 350, 300, 24);
		panelLabelLateral.setBackground(new Color(220, 220, 220, 100));
		this.add(panelLabelLateral);
		this.add(panelLateral);	
	}

	private void creatingLabel(){
		labelLateral = new JLabel();
		labelLateral.setBounds(600, 352, 295, 20);
		labelLateral.setHorizontalAlignment(JLabel.CENTER);
		labelLateral.setFont(new Font("Arial", Font.BOLD, 20));
		labelLateral.setText("SCREEN");
		labelLateral.setForeground(Color.BLACK);

		labelCentral = new JLabel();
		labelCentral.setBounds(50, 40, 110, 24);
		labelCentral.setHorizontalAlignment(JLabel.CENTER);
		labelCentral.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		labelCentral.setText("label");
		labelCentral.setForeground(Color.WHITE);

		//My signature
		signature = new JLabel();
		signature.setText("Created by: Pedro Kauã Silva dos Santos");
		signature.setForeground(new Color(255, 255, 255, 127));
		signature.setBounds(5, 540, 400, 20);

		this.add(labelCentral);
		this.add(labelLateral);
		this.add(signature);	
	}

	
}
