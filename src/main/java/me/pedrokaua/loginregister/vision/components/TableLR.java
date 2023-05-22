package me.pedrokaua.loginregister.vision.components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		cont = 0;

		if (this.getSelectedRow() != -1) {
			screen.listLabelsResp.forEach(l -> {
				l.setText(this.getValueAt(getSelectedRow(), cont).toString());
				cont++;
			});
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}
