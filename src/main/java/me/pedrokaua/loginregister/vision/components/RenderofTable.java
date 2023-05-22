package me.pedrokaua.loginregister.vision.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellRenderer;

public class RenderofTable implements TableCellRenderer{

	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JLabel label = new JLabel(value.toString());
		panel.add(label, BorderLayout.WEST);
		
		if(isSelected) {
			panel.setBackground(new Color(0, 150, 0, 60));
		}
		
		SwingUtilities.invokeLater(() -> {
			table.repaint();
			table.validate();
			panel.repaint();
			panel.validate();
		});
		return panel;
	}
	
}
