package pieces;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;

import board.Board;
import board.Tile;

public class King extends Piece{
	
	public King (Tile tile, boolean color, Board board) {
		super(tile, color, board);
		if (color) {
			File image = new File("src/resources/WK.gif");
	        try {
				img = ImageIO.read(image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			File image = new File("src/resources/BK.gif");
	        try {
				img = ImageIO.read(image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public HashSet<Tile> allowedMoves() {
		HashSet<Tile> moves = new HashSet<Tile> ();
		Tile currTile = this.getTile(); 
		int currX = currTile.getX();
		int currY = currTile.getY();
		if (currX != 0 && (!board.getTile(currX - 1 , currY).isOccupied() || board.getTile(currX - 1, currY).getPiece().getColor() != this.color)) {
			
		}
		return moves;
	}
	
}
