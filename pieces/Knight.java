package pieces;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;

import board.Board;
import board.Tile;

public class Knight extends Piece{
	
	public Knight (Tile tile, boolean color, Board board, String name) {
		super(tile, color, board, name);
		if (color) {
			File image = new File("src/resources/images/WN.gif");
	        try {
				img = ImageIO.read(image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			File image = new File("src/resources/images/BN.gif");
	        try {
				img = ImageIO.read(image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public HashSet<Tile> allowedMoves () {
		
		HashSet<Tile> moves = new HashSet<Tile> ();
		Tile currTile = this.getTile();
		
		int currX = currTile.getX();
		int currY = currTile.getY();
		
//		if ((currX <= 6 && currY <= 5) && (!board.getTile(currX + 1, currY + 2).isOccupied() || board.getTile(currX + 1, currY + 2).getPiece().getColor() != this.color)) {
//			moves.add(board.getTile(currX + 1, currY + 2));
//		}
//		if ((currX >= 1 && currY <= 5) && (!board.getTile(currX - 1, currY + 2).isOccupied() || board.getTile(currX - 1, currY + 2).getPiece().getColor() != this.color)) {
//			moves.add(board.getTile(currX - 1, currY + 2));
//		}
//		if ((currX >= 1 && currY >= 2) && (!board.getTile(currX - 1, currY - 2).isOccupied() || board.getTile(currX - 1, currY - 2).getPiece().getColor() != this.color)) {
//			moves.add(board.getTile(currX - 1, currY - 2));
//		}
//		if ((currX <= 6 && currY <= 2) && (!board.getTile(currX + 1, currY - 2).isOccupied() || board.getTile(currX + 1, currY - 2).getPiece().getColor() != this.color)) {
//			moves.add(board.getTile(currX + 1, currY - 2));
//		}
//		if ((currX <= 5 && currY <= 6) && (!board.getTile(currX + 2, currY + 1).isOccupied() || board.getTile(currX + 2, currY + 1).getPiece().getColor() != this.color)) {
//			moves.add(board.getTile(currX + 2, currY + 1));
//		}
//		if ((currX <= 5 && currY >= 1) && (!board.getTile(currX + 2, currY - 1).isOccupied() || board.getTile(currX + 2, currY - 1).getPiece().getColor() != this.color)) {
//			moves.add(board.getTile(currX + 2, currY - 1));
//		}
//		if ((currX >= 2 && currY <= 6) && (!board.getTile(currX - 2, currY + 1).isOccupied() || board.getTile(currX - 2, currY + 1).getPiece().getColor() != this.color)) {
//			moves.add(board.getTile(currX - 2, currY + 1));
//		}
//		if ((currX >= 2 && currY >= 1) && (!board.getTile(currX - 2, currY - 1).isOccupied() || board.getTile(currX - 2, currY - 1).getPiece().getColor() != this.color)) {
//			moves.add(board.getTile(currX - 2, currY - 1));
//		}
		
		try { if (!board.getTile(currX - 1, currY + 2).isOccupied() || board.getTile(currX - 1, currY + 2).getPiece().getColor() != this.color) moves.add(board.getTile(currX - 1, currY + 2)); } catch (Exception e) {}
		try { if (!board.getTile(currX + 1, currY + 2).isOccupied() || board.getTile(currX + 1, currY + 2).getPiece().getColor() != this.color) moves.add(board.getTile(currX + 1, currY + 2)); } catch (Exception e) {}
		try { if (!board.getTile(currX - 1, currY - 2).isOccupied() || board.getTile(currX - 1, currY - 2).getPiece().getColor() != this.color) moves.add(board.getTile(currX - 1, currY - 2)); } catch (Exception e) {}
		try { if (!board.getTile(currX + 1, currY - 2).isOccupied() || board.getTile(currX + 1, currY - 2).getPiece().getColor() != this.color) moves.add(board.getTile(currX + 1, currY - 2)); } catch (Exception e) {}
		try { if (!board.getTile(currX - 2, currY + 1).isOccupied() || board.getTile(currX - 2, currY + 1).getPiece().getColor() != this.color) moves.add(board.getTile(currX - 2, currY + 1)); } catch (Exception e) {}
		try { if (!board.getTile(currX + 2, currY + 1).isOccupied() || board.getTile(currX + 2, currY + 1).getPiece().getColor() != this.color) moves.add(board.getTile(currX + 2, currY + 1)); } catch (Exception e) {}
		try { if (!board.getTile(currX - 2, currY - 1).isOccupied() || board.getTile(currX - 2, currY - 1).getPiece().getColor() != this.color) moves.add(board.getTile(currX - 2, currY - 1)); } catch (Exception e) {}
		try { if (!board.getTile(currX + 2, currY - 1).isOccupied() || board.getTile(currX + 2, currY - 1).getPiece().getColor() != this.color) moves.add(board.getTile(currX + 2, currY - 1)); } catch (Exception e) {}
		
		return moves;
	}
	
}
