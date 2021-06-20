package gui;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import pieces.Piece;

public class CapturedPiecesPanel extends JPanel{
	HashMap <String, Integer> capturedPieces = new HashMap<String, Integer> ();
	int whiteLength = 0;
	int blackLength = 0;
	public CapturedPiecesPanel () {
		
	}
	
	public void setCapturedPieces (HashMap <String, Integer> capturedPieces) {
		this.capturedPieces = capturedPieces;
	}
	
	@Override
	protected void paintComponent (Graphics g) {
		for (String piece : capturedPieces.keySet()) {
			
		}
	}
}
