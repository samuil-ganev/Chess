package pieces;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;

import board.Board;
import board.Tile;

public class Pawn extends Piece{
	
	boolean isMoved;
	boolean twoPieceMove;
	
	public Pawn (Tile tile, boolean color, Board board, String name) {
		super(tile, color, board, name);
		isMoved = false;
		twoPieceMove = false;
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
		
		if (color) {
			
			try {
	
				if (board.getTile(currX - 1, currY).getPiece() instanceof Pawn && 
					board.getTile(currX - 1, currY).getPiece().color == !color &&
					twoPieceMove) {
					moves.add(board.getTile(currX - 1, currY - 1));
				}
			
			} catch (Exception e) {}
			
			try {
			
				if (board.getTile(currX + 1, currY).getPiece() instanceof Pawn && 
					board.getTile(currX + 1, currY).getPiece().color == !color &&
					twoPieceMove) {
					moves.add(board.getTile(currX + 1, currY - 1));
				}
			
			} catch (Exception e) {}
			
			try {
			
				if (!board.getTile(currX, currY - 2).isOccupied() && !isMoved)
					moves.add(board.getTile(currX, currY - 2));
			
			} catch (Exception e) {}
			
			try {
				
				if (!board.getTile(currX, currY - 1).isOccupied())
					moves.add(board.getTile(currX, currY - 1));
			
			} catch (Exception e) {}
			
			try {
					
				if (board.getTile(currX - 1, currY - 1).isOccupied() && board.getTile(currX - 1, currY - 1).getPiece().getColor() != this.color)
					moves.add(board.getTile(currX - 1, currY - 1));
			
			} catch (Exception e) {}
			
			try {
					
				if (board.getTile(currX + 1, currY - 1).isOccupied() && board.getTile(currX + 1, currY - 1).getPiece().getColor() != this.color)
					moves.add(board.getTile(currX + 1, currY - 1));
				
			} catch (Exception e) {}
					
		} else {
		
		try {
			
			if (board.getTile(currX - 1, currY).getPiece() instanceof Pawn && 
					board.getTile(currX - 1, currY).getPiece().color == !color &&
					twoPieceMove) {
				moves.add(board.getTile(currX - 1, currY + 1));
			}
			
		} catch (Exception e) {}
		
		try {
			
			if (board.getTile(currX + 1, currY).getPiece() instanceof Pawn && 
					board.getTile(currX + 1, currY).getPiece().color == !color &&
					twoPieceMove) {
				moves.add(board.getTile(currX + 1, currY + 1));
			}
			
		} catch (Exception e) {}
		
		try {
			
			if (!board.getTile(currX, currY + 2).isOccupied() && !isMoved)
				moves.add(board.getTile(currX, currY + 2));
		
		} catch (Exception e) {}
		
		try {

			if (!board.getTile(currX, currY + 1).isOccupied())
					moves.add(board.getTile(currX, currY + 1));
			
		} catch (Exception e) {}
		
		try {
					
			if (board.getTile(currX - 1, currY + 1).isOccupied() && board.getTile(currX - 1, currY + 1).getPiece().getColor() != this.color)
				moves.add(board.getTile(currX - 1, currY + 1));
		
		} catch (Exception e) {}
		
		try {
				
			if(board.getTile(currX + 1, currY + 1).isOccupied() && board.getTile(currX + 1, currY + 1).getPiece().getColor() != this.color)
				moves.add(board.getTile(currX + 1, currY + 1));
		
		} catch (Exception e) {}
				
		}
		
		return moves;
	
	}

}