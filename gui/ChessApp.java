package gui;

import javax.swing.JFrame;
import java.awt.*;

public class ChessApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setSize(670, 700);
		frame.add(new BoardControl());
		frame.setTitle("Chess");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		 
		Image icon = Toolkit.getDefaultToolkit().getImage("resources/icon.png");  
		frame.setIconImage(icon);  
		 
	}

}
