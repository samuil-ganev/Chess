package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardControl extends JPanel{
	private BoardPanel boardPanel = new BoardPanel();
	private TimerPanel timerPanel = new TimerPanel();
	
	public BoardControl() {
		setLayout (new BorderLayout());
		add(boardPanel, BorderLayout.CENTER);
		add(timerPanel, BorderLayout.SOUTH);
		
	}
}
