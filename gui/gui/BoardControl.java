package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardControl extends JPanel{
	private BoardPanel boardPanel = new BoardPanel();
	
	
	public BoardControl() {
		setLayout (new BorderLayout());
		add(boardPanel, BorderLayout.CENTER);
		
		
	}
}
