package me.pedrokaua.loginregister.vision.components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.JTable;

import me.pedrokaua.loginregister.vision.DataManagerScreen;

public class TableLR extends JTable implements MouseListener{
	private static final long serialVersionUID = 1L;

	DataManagerScreen screen;
	int cont = 0;

	public TableLR(DataManagerScreen screen){
		this.screen = screen;
	}


	@Override
	public boolean isCellEditable(int row, int column) {
		return super.isCellEditable(row, column);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		screen.getController()
				.showUserInfos(
						Long.parseLong(this.getValueAt(this.getSelectedRow(), 0).toString()));
	}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
}
