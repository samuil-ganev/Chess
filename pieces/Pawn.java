package pieces;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;

import board.Board;
import board.Tile;

public class Pawn extends Piece{
	
	boolean isMoved;
	
	public Pawn (Tile tile, boolean color, Board board) {
		super(tile, color, board);
		isMoved = false;
		if (color) {
			File image = new File("src/resources/WP.gif");
	        try {
				img = ImageIO.read(image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			File image = new File("src/resources/BP.gif");
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
		if(!isMoved) {
			if(color) {
				if(!board.getTile(currX, currY - 2).isOccupied()) {
					moves.add(board.getTile(currX, currY - 2));
				}
				if(!board.getTile(currX, currY - 1).isOccupied()) {
					moves.add(board.getTile(currX, currY - 1));
				}
				if(board.getTile(currX - 1, currY - 1).isOccupied() && board.getTile(currX - 1, currY - 1).getPiece().getColor() != this.color) {
					moves.add(board.getTile(currX - 1, currY - 1));
				}
				if(board.getTile(currX + 1, currY - 1).isOccupied() && board.getTile(currX + 1, currY - 1).getPiece().getColor() != this.color) {
					moves.add(board.getTile(currX + 1, currY - 1));
				}
			}else {
				if(!board.getTile(currX, currY + 2).isOccupied()) {
					moves.add(board.getTile(currX, currY + 2));
				}
				if(!board.getTile(currX, currY + 1).isOccupied()) {
					moves.add(board.getTile(currX, currY + 1));
				}
				if(board.getTile(currX - 1, currY + 1).isOccupied() && board.getTile(currX - 1, currY + 1).getPiece().getColor() != this.color) {
					moves.add(board.getTile(currX - 1, currY + 1));
				}
				if(board.getTile(currX + 1, currY + 1).isOccupied() && board.getTile(currX + 1, currY + 1).getPiece().getColor() != this.color) {
					moves.add(board.getTile(currX + 1, currY + 1));
				}
			}
		}else {
			if(color) {
				if(!board.getTile(currX, currY - 1).isOccupied()) {
					moves.add(board.getTile(currX, currY - 1));
				}
				if(board.getTile(currX - 1, currY - 1).isOccupied() && board.getTile(currX - 1, currY - 1).getPiece().getColor() != this.color) {
					moves.add(board.getTile(currX - 1, currY - 1));
				}
				if(board.getTile(currX + 1, currY - 1).isOccupied() && board.getTile(currX + 1, currY - 1).getPiece().getColor() != this.color) {
					moves.add(board.getTile(currX + 1, currY - 1));
				}
			}else {
				if(!board.getTile(currX, currY + 1).isOccupied()) {
					moves.add(board.getTile(currX, currY + 1));
				}
				if(board.getTile(currX - 1, currY + 1).isOccupied() && board.getTile(currX - 1, currY + 1).getPiece().getColor() != this.color) {
					moves.add(board.getTile(currX - 1, currY + 1));
				}
				if(board.getTile(currX + 1, currY + 1).isOccupied() && board.getTile(currX + 1, currY + 1).getPiece().getColor() != this.color) {
					moves.add(board.getTile(currX + 1, currY + 1));
				}
			}
		}
		return moves;
	}
}
