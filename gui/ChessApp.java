package gui;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ChessApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		 frame.setSize(400, 400);
		 frame.add(new BoardControl());
		 frame.setTitle("Chess");
		 frame.setLocationRelativeTo(null);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);
		 

		Image icon = Toolkit.getDefaultToolkit().getImage("src/resources/images/icon.png");  
		frame.setIconImage(icon); 
	}

}
