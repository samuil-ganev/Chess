package gui;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardControl extends JPanel{
	//boolean gameEnd = false;
	private BoardPanel boardPanel = new BoardPanel();
	private TimerPanel timerPanel = new TimerPanel();
	
	public BoardControl() {
		setLayout (new BorderLayout());
		add(boardPanel, BorderLayout.CENTER);
		add(timerPanel, BorderLayout.EAST);
		timerPanel.turn(boardPanel.isWhiteOnTurn());
	}
	
	@Override
	protected void paintComponent (Graphics g) {
		timerPanel.turn(boardPanel.isWhiteOnTurn());
		repaint();
	}
	
}
