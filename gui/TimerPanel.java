package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimerPanel extends JPanel{
	Timer whiteTimer = new Timer ();
	Timer blackTimer = new Timer ();
	
	JLabel whiteTimerLbl = new JLabel();
	JLabel blackTimerLbl = new JLabel();
	
	boolean gameEnd = false;
	boolean whiteOnTurn = true;
	
	int startingTime = 180;
	int increment = 2;
	int whiteCounter = 180;
	int blackCounter = 180;
	TimerTask displayWhiteTimer = new TimerTask() {
		
		@Override
		public void run() {
			if (whiteCounter <= startingTime / 9 ) {
				whiteTimerLbl.setForeground(Color.RED);
				whiteTimerLbl.setText("" + whiteCounter);
			} else {
				whiteTimerLbl.setForeground(Color.BLACK);
				whiteTimerLbl.setText("" + whiteCounter);
			}
			--whiteCounter;
		}
		
	};
	
	TimerTask displayBlackTimer = new TimerTask() {
		
		@Override
		public void run() {
			if (blackCounter <= startingTime / 9 ) {
				blackTimerLbl.setForeground(Color.RED);
				blackTimerLbl.setText("" + blackCounter);
			} else {
				blackTimerLbl.setForeground(Color.BLACK);
				blackTimerLbl.setText("" + blackCounter);
			}
			--blackCounter;
		}
		
	};
	
	
	public TimerPanel () {
		whiteTimer.scheduleAtFixedRate(displayWhiteTimer, 1000, 1000);
		blackTimer.scheduleAtFixedRate(displayBlackTimer, 1000, 1000);
		add(whiteTimerLbl, BorderLayout.CENTER);
		add(blackTimerLbl, BorderLayout.CENTER);
		boolean prev = whiteOnTurn;
		//whiteTimer.scheduleAtFixedRate(displayWhiteTimer, 0, 1000);
		while (!gameEnd) {
			if (prev != whiteOnTurn) {
				if (!whiteOnTurn) {
					try {
						whiteTimer.cancel();
						blackTimer.scheduleAtFixedRate(displayBlackTimer, 0, 1000);
					} catch (Exception e) {
						System.out.println("1");
						e.printStackTrace();
					}
					
				} else {
					try {
						blackTimer.cancel();
						whiteTimer.scheduleAtFixedRate(displayWhiteTimer, 0, 1000);
					} catch (Exception e) {
						System.out.println("2");
						e.printStackTrace();
					}
					
				}
			}
			prev = whiteOnTurn;
//			if (whiteOnTurn) {
//				try {
//					blackTimer.cancel();
//				} catch (Exception e) {
//					System.out.println("1");
//					e.printStackTrace();
//				}
//				try {
//					whiteTimer.scheduleAtFixedRate(displayWhiteTimer, 0, 1000);
//				} catch (Exception e) {
//					System.out.println("2");
//					e.printStackTrace();
//				}
//				
//			} else {
//				try {
//					whiteTimer.cancel();
//				} catch (Exception e) {
//					System.out.println("3");
//					e.printStackTrace();
//				}
//				try {
//					blackTimer.scheduleAtFixedRate(displayBlackTimer, 0, 1000);
//				} catch (Exception e) {
//					System.out.println("4");
//					e.printStackTrace();
//				}
//				
//			}
		}
		
		//whiteTimer.scheduleAtFixedRate(displayWhiteTimer, 0, 1000);
		//blackTimer.scheduleAtFixedRate(displayBlackTimer, 0, 1000);
		
	}
	
	public void setTimer (int time, int increment) {
		startingTime = time;
		this.increment = increment;
		whiteCounter = time;
		blackCounter = time;
	}
}
