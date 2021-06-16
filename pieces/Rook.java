package pieces;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;

import board.Board;
import board.Tile;

public class Rook extends Piece{
	
	public Rook (Tile tile, boolean color, Board board, String name) {
		super(tile, color, board, name);
		if (color) {
			File image = new File("src/resources/images/WR.gif");
	        try {
				img = ImageIO.read(image);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			File image = new File("src/resources/images/BR.gif");
	        try {
				img = ImageIO.read(image);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public HashSet<Tile> allowedMoves () {
		HashSet<Tile> moves = new HashSet<Tile> ();
		Tile thisTile = this.getTile();
		int thisX = thisTile.getX();
		int thisY = thisTile.getY();
		if (thisX != 0) { //move left
			int currX = thisX - 1;
			
			while (true) {
				
				try {
					
					Tile currTile = board.getTile(currX, thisY);
					
					if (!currTile.isOccupied() || (currTile.isOccupied() && currTile.getPiece().getColor() != this.color)) {
						
						moves.add(currTile);
						--currX;
						
						if (!(currTile instanceof EmptyTile))
							if (currTile.getPiece().getColor() != this.color)
								break;
						
					} else { break; }
					
				} catch (Exception e) { break; }
				
			}
			
		}
		if (thisX != 7) { //move right
			int currX = thisX + 1;
			
			while (true) {
				
				try {
					
					Tile currTile = board.getTile(currX, thisY);
					
					if (!currTile.isOccupied() || (currTile.isOccupied() && currTile.getPiece().getColor() != this.color)) {
						
						moves.add(currTile);
						++currX;
						
						if (!(currTile instanceof EmptyTile))
							if (currTile.getPiece().getColor() != this.color)
								break;
						
					} else { break; }
					
				} catch (Exception e) { break; }
				
			}
			
		}
		if (thisY != 0) { //move up
			int currY = thisY - 1;
			
			while (true) {
				
				try {
					
					Tile currTile = board.getTile(thisX, currY);
					
					if (!currTile.isOccupied() || (currTile.isOccupied() && currTile.getPiece().getColor() != this.color)) {
						
						moves.add(currTile);
						--currY;
						
						if (!(currTile instanceof EmptyTile))
							if (currTile.getPiece().getColor() != this.color)
								break;
						
					} else { break; }
					
				} catch (Exception e) { break; }
				
			}
			
		}
		if (thisY != 7) { //move down
			int currY = thisY + 1;
			
			while (true) {
				
				try {
					
					Tile currTile = board.getTile(thisX, currY);
					
					if (!currTile.isOccupied() || (currTile.isOccupied() && currTile.getPiece().getColor() != this.color)) {
						
						moves.add(currTile);
						++currY;
						
						if (!(currTile instanceof EmptyTile))
							if (currTile.getPiece().getColor() != this.color)
								break;
						
					} else { break; }
					
				} catch (Exception e) { break; }
				
			}
			
		}
		
		return moves;
		
	}
	
}
