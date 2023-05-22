package me.pedrokaua.loginregister.vision.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class TableRender implements TableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JPanel panel = new JPanel();
		JLabel label = new JLabel(value.toString());

		panel.setLayout(new BorderLayout());
		panel.add(label, BorderLayout.WEST);
		
			panel.setBackground(new Color(0,10,10, 20));
		if (isSelected) panel.setBackground(new Color(10, 200, 10, 90));
		return panel;
	}

}
