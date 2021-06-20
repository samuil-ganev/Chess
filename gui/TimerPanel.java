package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;
import gui.BoardPanel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimerPanel extends JPanel{
	Timer timer = new Timer ();
	
	JLabel whiteTimerLbl = new JLabel();
	JLabel blackTimerLbl = new JLabel();
	
	boolean whiteOnTurn = true;
	boolean prevTurn;
	
	int startingTime = 180;
	int increment = 3;
	int whiteCounter = 180;
	int blackCounter = whiteCounter - increment;
	TimerTask displayTimers = new TimerTask() {
		
		@Override
		public void run() {
			if (whiteOnTurn) {
				if (whiteOnTurn != prevTurn ) {
					blackCounter += increment;
					blackTimerLbl.setText(toMinutes(blackCounter));
				}
				--whiteCounter;
				whiteTimerLbl.setText(toMinutes(whiteCounter));
			} else {
				if (whiteOnTurn != prevTurn ) {
					whiteCounter += increment;
					whiteTimerLbl.setText(toMinutes(whiteCounter));
				}
				--blackCounter;
				blackTimerLbl.setText(toMinutes(blackCounter));
			}
			prevTurn = whiteOnTurn;
		}
		
	};
	
	
	
	public TimerPanel () {
		setLayout(new GridLayout(2,2));
		add(blackTimerLbl);
		add(whiteTimerLbl);
		blackTimerLbl.setText(toMinutes(blackCounter));
		timer.scheduleAtFixedRate(displayTimers, 0, 1000);
		
	}
	
	public void turn (boolean isWhiteOnTurn) {
		whiteOnTurn = isWhiteOnTurn;
	}
	
	private String toMinutes (int seconds) {
		int min = seconds / 60;
		int sec = seconds % 60;
		if (sec < 10) {
			return min + ":0" + sec;
		}
		return min + ":" + seconds % 60;
	}
	
	public void setTimer (int time, int increment) {
		startingTime = time;
		this.increment = increment;
		whiteCounter = time;
		blackCounter = time;
	}
}
